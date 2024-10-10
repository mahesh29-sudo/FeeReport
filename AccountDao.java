import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AccountDao {
	
	public static Connection getCon() {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","","");
		}catch(Exception e){
			System.out.println(e);
		}
		return con;		
	}
	
	public static boolean Validate(String name,String password) {
		boolean status = false;
		
		Connection con =getCon();
		try {
			PreparedStatement ps = con.prepareStatement("select * from feereport_accountant where name=? and password=?");
			ps.setString(1, name);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			rs.next();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;		
	}
	
	public static int save(Accountant a) {
		int status = 0;
		Connection con = getCon();
		try {
			PreparedStatement ps=con.prepareStatement("insert into feereport_accountant(name,password,email,contactno) "
					+ "values (?,?,?,?)");
			ps.setString(1, a.getName());
			ps.setString(2, a.getPassword());
			ps.setString(3, a.getEmail());
			ps.setString(4, a.getContactno());
			ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
	
	public static ArrayList<Accountant> view(){
		
		ArrayList<Accountant> list = new ArrayList<>();
		
		Connection con = getCon();
		
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select * from feereport_accountant");
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				Accountant a = new Accountant();
				a.setId(rs.getInt(1));
				a.setName(rs.getString(2));
				a.setPassword(rs.getString(3));
				a.setEmail(rs.getString(4));
				a.setContactno(rs.getString(5));
				list.add(a);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
