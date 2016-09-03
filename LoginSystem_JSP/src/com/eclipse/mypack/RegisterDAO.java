/**
 * 
 */
package com.eclipse.mypack;
import java.sql.*;
import java.util.*;

/**
 * @author mshaikh
 *
 */
@SuppressWarnings("unused")
public class RegisterDAO {
	
	/**
	 * 
	 */
	public RegisterDAO() {
		// TODO Auto-generated constructor stub
	}
	

	private static String driverName;
	private static String connURL;
	private static String dbUser;
	private static  String dbPass;


	public static void setConnParameters(){
		driverName ="oracle.jdbc.driver.OracleDriver";
		connURL = "jdbc:oracle:thin:@localhost:1521:ORCL";
		dbUser = "U_DEV";
		dbPass = "U_DEV";		
	}
	
	public static Connection getConnection(){
		Connection con = null;
		try 
		{
			setConnParameters();
			Class.forName(driverName);
			con = DriverManager.getConnection(connURL,dbUser ,dbPass);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return con;
		
	}
	
	public static int RegisterUser(Register r){
		
		int status = 0;
		String sql;
		Connection c = getConnection();
		try{
			
			sql="select nvl(max(id),0)+1 from dev_user";
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			rs.next();
			r.setId(rs.getInt(1));
			s.close();
			sql = "insert into dev_user(id,name,password,emailid,address) values (?,?,?,?,?)";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setLong(1,r.getId());
			ps.setString(2, r.getUserName());
			ps.setString(3, r.getUserPass());
			ps.setString(4, r.getUserEmail());
			ps.setString(5, r.getUserAddress());
			status = ps.executeUpdate();
			c.commit();
			ps.close();
			c.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return status;
		
	}

}
