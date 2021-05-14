package art_Gallery;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class eventDBUtil {
	
	private static Connection con = null ;
	private static Statement stmt = null ;
	private static ResultSet rs = null;
	
	
	public static boolean insertEvent(String name, String date, String status, String description, String adminID ) {
		
		boolean isSuccess = false;
		
		try 
		{
			con = EventDBconnect.getConnection();
			stmt = con.createStatement();
			
			boolean stats = Boolean.parseBoolean(status);
			int admin = Integer.parseInt(adminID);
			
			String sql = "insert into event values (0,  '"+name+"', '"+date+"', '"+stats+"', '"+description+"', '"+admin+"')";  
			
			int result = stmt.executeUpdate(sql);
			
			if(result > 0)
			{
				isSuccess = true;
				
			}
			else
			{
				isSuccess = false;
				
			}
			
	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		return isSuccess;	
		
	}
	
	
	
	
	public static List<EventClass> validate (String Ename, String adminID)
	{
		ArrayList<EventClass> eve = new ArrayList<>();
		
		//db connection
		con = EventDBconnect.getConnection();
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		int adID = Integer.parseInt(adminID);
				
				
		String sql = "select * from event where name = '"+Ename+"' and a_admin_id = '"+adID+"'";
		
		try {
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		try {
			if (rs.next()) {
				
				int id = rs.getInt(1);
				String name = rs.getString(2);
				Date date = rs.getDate(3);
				Boolean status = rs.getBoolean(4);
				String description = rs.getString(5);
				int adminId = rs.getInt(6);
				
				EventClass e = new EventClass(id,name,date,status,description,adminId);
				
				eve.add(e);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return eve;
		
		
	}
	
	

}
 