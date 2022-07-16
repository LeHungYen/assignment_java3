package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entities.Student;
import entities.User;
import utils.DB_connection;

public class UserDao implements IUserDao{
	private ArrayList<User> _listUser = new ArrayList<User>();
	@Override
	public void them(User user) throws SQLException, ClassNotFoundException {
		Connection con = new DB_connection().connect();
		Statement st = con.createStatement();
		st.executeUpdate("insert into users values ("+"N'"+user.getUsername()+"',"+"N'"+user.getPassword()+"',"+"N'"+user.getRole()+"')");
		st.close();
	}

	@Override
	public void sua(User user) throws ClassNotFoundException, SQLException {
		Connection con = new DB_connection().connect();
		Statement st = con.createStatement();
		st.executeUpdate("update users set  "+"password =N'"+user.getPassword()+"',"+"role =N'"+user.getRole()+"'"+"where username =N'"+user.getUsername()+"'");
		st.close();
	}
	@Override
	public void xoa(User user) throws ClassNotFoundException, SQLException {
		Connection con = new DB_connection().connect();
		Statement st = con.createStatement();
		st.executeUpdate("delete users where username = N'"+user.getUsername()+"'");
		st.close();
	}

	@Override
	public void updateListUser() throws ClassNotFoundException, SQLException {
		Connection con = new DB_connection().connect();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from users");
		while(rs.next()) {
			User user = new User(rs.getString(1),rs.getString(2),rs.getString(3));
			_listUser.add(user);
		}
		st.close();
		
	}

	@Override
	public ArrayList<User> getListUser() {
		return _listUser;
	}
}
