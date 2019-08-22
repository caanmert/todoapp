package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.mindrot.jbcrypt.BCrypt;

import model.User;
import util.DbUtil;

public class UserDao {

	private Connection connection;

	public UserDao() {
	}

	// Adds user into Database.
	public void addUser(User user) {
		String sql = "insert into users(first_name,last_name,username,password,email) values (?,?,?,?,?)";
		try {
			connection = DbUtil.getConnection();
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, user.getFirstName());
			st.setString(2, user.getLastName());
			st.setString(3, user.getUserName());
			st.setString(4, BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
			st.setString(5, user.getEmail());
			st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Checks if user exists.
	public boolean LoginCheck(String username, String password) {

		String sql = "select * from users where username=?";

		try {
			connection = DbUtil.getConnection();
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, username);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String dbPass = rs.getString("password");// If username exists checks input pw if it is equals to hashed
															// one
				if (BCrypt.checkpw(password, dbPass)) {

					return true;
				} else
					return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	// Gets userID with username
	public String getUserId(String username) {
		String sql = "select id from users where username=?";
		try {
			connection = DbUtil.getConnection();
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, username);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				String userID = rs.getString("id");
				return userID;
			}

			return null;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//Checks if user e
	public boolean UserExists(User user) {

		String sql = "select * from users where username=?";
		String secSql = "select * from users where email=?";

		try {
			Connection connection = DbUtil.getConnection();
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, user.getUserName());
			PreparedStatement ts = connection.prepareStatement(secSql);
			ts.setString(1, user.getEmail());
			ResultSet rs = st.executeQuery();
			ResultSet sr = ts.executeQuery();

			if (rs.next() || sr.next()) {
				return false;
			} else
				return true;

		} catch (SQLException e) {

		}
		return true;

	}

}
