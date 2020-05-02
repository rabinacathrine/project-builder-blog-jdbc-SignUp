package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import utility.ConnectionManager;
import model.User;

public class UserDAO implements UserDaoInterface{

	ConnectionManager con=new ConnectionManager();
	
	@Override
	public int signUp(User user) throws SQLException, Exception {
		String email=user.getEmail();
		String password=user.getPassword();
	//	String confirmPassword=user.getConfirmpassword();
		LocalDate date=user.getDate();
		
		String sql="insert into USERDATE(email,password,date)VALUES(?,?,?)";
		
		PreparedStatement st=con.getConnection().prepareStatement(sql);
		
		st.setString(1,email);
		st.setString(2,password);
		st.setDate(3,Date.valueOf(date));
		st.executeQuery();
		
		return 0;
	}

	@Override
	public boolean loginUser(User user) throws SQLException, Exception {
		String email=user.getEmail();
		String password=user.getPassword();
		
		
		Statement st = con.getConnection().createStatement();
		
		ResultSet rs=st.executeQuery("SELECT *  from  USERDATE");
		
		while(rs.next()) {
			if(email.equals(rs.getString("email"))&& password.equals(rs.getString("password"))) {
				con.getConnection().close();
				return true;
			}
		}
				con.getConnection().close();
				return false;
				
		
	}
}