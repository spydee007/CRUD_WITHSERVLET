import java.io.*;
import java.sql.*;
import java.util.*;

@SuppressWarnings("unused")
public class UserDAO {
	
	
	public static Connection getConnection(){
		Connection c = null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL" , "U_DEV" , "U_DEV");
		}
		catch(Exception e){
		e.printStackTrace();	
		}	
		return c;
	}
	
	public static int save(User u){
		int status = 0;
		try{
			Connection c = getConnection();
			DatabaseMetaData dbm = c.getMetaData();
			System.out.println(dbm.getDatabaseProductName()+dbm.getDatabaseProductVersion()+dbm.getUserName()+dbm.getURL()+dbm.getDriverName()+dbm.getDefaultTransactionIsolation());
//			PreparedStatement p = c.prepareStatement("select nvl(max(id),0)+1 from dev_user");
			PreparedStatement p = c.prepareStatement("select getid from dual");
			ResultSet rs = p.executeQuery();
			rs.next();
			ResultSetMetaData rsmd = rs.getMetaData();
			System.out.println(rsmd.getColumnCount()+rsmd.getCatalogName(1)+rsmd.getColumnType(1)+rsmd.getColumnType(1));
			u.setId(rs.getInt(1));
			p.close();
			
			CallableStatement cs = c.prepareCall("{call p_getname (?,?)}");
			cs.setInt(1, 2);
			cs.registerOutParameter(2, Types.VARCHAR );
			cs.executeQuery();
			String z = cs.getString(2);
			System.out.println(z);
			PreparedStatement p1 = c.prepareStatement(
					"insert into dev_user(id,name,password,emailid,address) values (?,?,?,?,?)"
					);
			p1.setInt(1, u.getId());
			p1.setString(2, u.getName());
			p1.setString(3, u.getPass());
			p1.setString(4, u.getEmail());
			p1.setString(5, u.getAddress());
			status = p1.executeUpdate();
			p1.close();
			
			
			PreparedStatement pi = c.prepareStatement("insert into imgtab(img_name , img_data) values(?,?)");
			pi.setString(1, "img1");
			File f1 = new File("D:\\new.txt");
			//InputStream fin = new FileInputStream("D:\\new.txt");
			FileReader fr = new FileReader(f1);
//			pi.setBinaryStream(2,fin , (int)f1.length() );
			pi.setCharacterStream(3, fr, f1.length());
			int result = pi.executeUpdate();
			System.out.println(result);
			
			//fin.close();
			c.close();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return status;
		
	}
	
	public static List <User> viewUsers() throws SQLException{
		
		List<User> l = new ArrayList<User>();
		try{
		PreparedStatement p = getConnection().prepareStatement("select * from dev_user");
		ResultSet rs = p.executeQuery();
		while(rs.next()){
			User u = new User();
			u.setId(rs.getInt(1));
			u.setName(rs.getString(2));
			u.setPass(rs.getString(3));
			u.setEmail(rs.getString(4));
			u.setAddress(rs.getString(5));
			l.add(u);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
			getConnection().close();
			return l;
		}
	
	public static int update(User u){
		int status = 0;
		
		try{
		 PreparedStatement p = getConnection().prepareStatement("update dev_user set name=? , password=? , emailid=? , address=? where id= ?");
		 p.setString(1, u.getName());
		 p.setString(2, u.getPass());
		 p.setString(3, u.getEmail());
		 p.setString(4, u.getAddress());
		 p.setInt(5, u.getId());
		 status = p.executeUpdate();
		}
		catch(Exception e){
			e.printStackTrace();			
		}
		return status;		
	}
	
	public static int delete(int id){
		int status = 0;
		try{
			PreparedStatement p = getConnection().prepareStatement("delete from dev_user where id =?");
			p.setInt(1, id);
			status = p.executeUpdate();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return id;
		
	}
	
	public static User getUserbyId(int id){
		User u = new User();
		try{
			PreparedStatement p = getConnection().prepareStatement("select * from dev_user where id =?");
			p.setInt(1, id);
			ResultSet rs = p.executeQuery();
			while(rs.next()){
				u.setName(rs.getString(2));
				u.setEmail(rs.getString(4));
				u.setPass(rs.getString(3));
				u.setAddress(rs.getString(5));
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
	}
}
