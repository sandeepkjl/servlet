package org.example.servlet.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.example.servlet.model.User;

public class ServletLogInRepsiotry {
	
	
	public User getUserfromDataBase(Connection conn, String uname, String pwd)
	{
		User usr=null;
		String sql = "select * from userinfo where userId=? and  password=?";
		
		try {
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,uname);
			pstmt.setString(2, pwd);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				usr = new User();
				usr.setUserId(rs.getString(1));
				usr.setPassword(rs.getString(2));
				usr.setUsername(rs.getString(3));
				usr.setUserAddress(rs.getString(4));
			}
					
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return usr;
		
	}
}
