package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.text.DefaultEditorKit.PasteAction;

import bean.AddTaskBean;
import util.DbConnection;



public class AddTaskDao {
	public void insertTask(AddTaskBean addtaskBean)
	{
		try
		{
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt  = con.prepareStatement("insert into addtasks(taskname,description,priority,status,userid,date) values (?,?,?,?,?,?)");
			pstmt.setString(1, addtaskBean.getTaskname());
			pstmt.setString(2, addtaskBean.getDescription());
			pstmt.setString(3, addtaskBean.getPriority());
			pstmt.setString(4, addtaskBean.getStatus());
			pstmt.setInt(5, addtaskBean.getUserid());
			pstmt.setString(6, addtaskBean.getDate());
			pstmt.executeUpdate();
		}catch(Exception e)
		{
			System.out.println("SWR in AddTaskDao()");
			e.printStackTrace();
		}
	}
	
	public ArrayList<AddTaskBean> getMyTasks(int userId) {
		ArrayList<AddTaskBean> tasks = new ArrayList<>();
		try(Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from addtasks where userid=?"); )
		{
			pstmt.setInt(1, userId);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				AddTaskBean task = new AddTaskBean();
				task.setTaskname(rs.getString("taskname"));
				task.setDescription(rs.getString("description"));
				task.setStatus(rs.getString("status"));
				task.setPriority(rs.getString("priority"));
				task.setTaskId(rs.getInt("taskid"));
				task.setDate(rs.getString("date"));
				task.setUserid(userId);
				tasks.add(task);  
			}
		} catch (Exception e) {
			System.out.println("SMW :: OrderDao::getMyTasks()");
			e.printStackTrace();
		}
		return tasks;
	}

	public boolean deleteTask(int taskId)
	{
		boolean flag=false;
		try(Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("delete from addtasks where taskid=?");){
			pstmt.setInt(1, taskId);
			
			int deleteRow = pstmt.executeUpdate();
			if(deleteRow==1)
			{
				flag=true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public AddTaskBean getTaskByTaskId(int taskId) {
		AddTaskBean task = null;
		try(Connection con = DbConnection.getConnection();
			PreparedStatement psmt = con.prepareStatement("select * from addtasks where taskid=?");
				){
			psmt.setInt(1, taskId);
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next()) {
				task= new AddTaskBean();
				task.setTaskname(rs.getString("taskname"));
					task.setDescription(rs.getString("description"));
					task.setStatus(rs.getString("status"));
					task.setPriority(rs.getString("priority"));
					task.setDate(rs.getString("date"));
					task.setTaskId(taskId);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return task;
	}
	
	public boolean UpdateTask(AddTaskBean task)
	{
		boolean flag=false;
		try(Connection con = DbConnection.getConnection();
		PreparedStatement pstmt = con.prepareStatement("update addtasks set taskname=?,description=?,priority=?,status=?,date=? where taskid=?");)
		{
			pstmt.setString(1, task.getTaskname());
			pstmt.setString(2, task.getDescription());
			pstmt.setString(3, task.getPriority());
			pstmt.setString(4, task.getStatus());
			pstmt.setString(5, task.getDate());
			pstmt.setInt(6, task.getTaskId());
			int updateCount = pstmt.executeUpdate();
			if(updateCount==1)
			{
				flag=true;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public boolean Statusupdate(int taskId) {
		
		boolean flag=false;
		try(Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("update addtasks set status=? where taskid=?");){
			pstmt.setString(1, "Done");
			pstmt.setInt(2, taskId);
			
			int updateStatus = pstmt.executeUpdate();
			if(updateStatus==1)
			{
				flag=true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

}
