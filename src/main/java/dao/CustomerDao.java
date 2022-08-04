package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.CustomerBean;
import util.DbConnection;

public class CustomerDao {
	public void insertUser(CustomerBean customer) {
		try (Connection con = DbConnection.getConnection();
				PreparedStatement pstmt = con
						.prepareStatement("insert into customers (firstname,email,password,mnumber,usertype,isactive) values (?,?,?,?,'customer','1')");) {
			pstmt.setString(1, customer.getFirstName());
			pstmt.setString(2, customer.getEmail());
			pstmt.setString(3, customer.getPassword());
			pstmt.setString(4, customer.getMnumber());
			pstmt.setInt(5, customer.getIsactive());

			int records = pstmt.executeUpdate();
			System.out.println(records + "Data insterted");

		} catch (Exception e) {
			System.out.println("SWR in insertUser()");
			e.printStackTrace();
		}
	}



	public CustomerBean login(String email, String password) 
	{
		CustomerBean customer = null;
		try (Connection con = DbConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement("select * from customers where email=? and password=?");) 
		{
			pstmt.setString(1, email);
			pstmt.setString(2, password);
//			System.out.println(email+password);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) 
			{
				customer = new CustomerBean();
				customer.setUserId(rs.getInt("userid"));
				customer.setFirstName(rs.getString("firstname"));
				customer.setUserType(rs.getString("usertype"));
				customer.setIsactive(rs.getInt("isactive"));
			} 
		}
		catch (Exception e) {
			System.out.println("SMW in login Dao ");
			e.printStackTrace();
		}
		return customer;

	}
	
	public CustomerBean getUserByUserId(int userId)
	{
		CustomerBean customer = null;
		try(Connection con = DbConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement("select * from customers where userid=?");	
				){
			pstmt.setInt(1, userId);
			ResultSet rs = pstmt.executeQuery(); 
			while(rs.next())
			{
				customer  = new CustomerBean();
				customer.setEmail(rs.getString("email"));
				customer.setPassword(rs.getString("password"));
				customer.setUserId(userId);
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return customer;
	}

	public CustomerBean ForgotPassword(String email,String mnumber) {
		CustomerBean customer = null;
		try(Connection con = DbConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement("select * from customers where email=? and mnumber=?");)
		{
			pstmt.setString(1, email);
			pstmt.setString(2, mnumber);
//			 System.out.println(pstmt);
			 ResultSet rs= pstmt.executeQuery();
			if(rs.next())
			{
				customer = new CustomerBean();
//				customer.setUserId(rs.getInt("userId"));
//				customer.setUserType(rs.getString("userType"));
				//				customer.setEmail(rs.getString("email"));
//				customer.setMnumber(rs.getString("mnumber"));
			}
		}
		catch(Exception e) {
			System.out.println("smw in fogotPassword dao");
			e.printStackTrace();
		}
	return customer;
	}
	
	public boolean updatePassword(CustomerBean customer) {
		   boolean flag = false;
		   try(Connection con = DbConnection.getConnection();
				   PreparedStatement psmt = con.prepareStatement("update customers set password=? where mnumber=?");)
			 {
				   psmt.setString(1, customer.getPassword());
				   System.out.println(customer.getPassword());
				   psmt.setString(2, customer.getMnumber());
				   System.out.println(customer.getMnumber());
				   int updateCount = psmt.executeUpdate();
				   if(updateCount == 1) {
				   flag = true;
			   }
			 }
		   catch (Exception e) {
			   System.out.println("SWR in updatePassword");
			   e.printStackTrace();	
		   }
		   return flag;
	}

	public Boolean CheckDuplicateEmail(String email) {
		try(Connection con = DbConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement("select * from customers where email=?");) {
			pstmt.setString(1, email);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public Boolean CheckDuplicateNumber(String mnumber) {
		try(Connection con = DbConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement("select * from customers where mnumber=?");) {
			pstmt.setString(1, mnumber);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}



	public boolean disable(int userId) {
		try(Connection con = DbConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement("update customers set isactive=? where userid=?");){
			pstmt.setInt(1, 0);
			pstmt.setInt(2, userId);
			int delete = pstmt.executeUpdate();
			if(delete==1)
			{
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}





		
		   
