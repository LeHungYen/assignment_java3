package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import entities.User;


public interface IUserDao {
	public void them(User user) throws SQLException, ClassNotFoundException;
	public void sua(User user)throws SQLException, ClassNotFoundException;
	public void updateListUser()throws SQLException, ClassNotFoundException;
	public ArrayList<User> getListUser();
	void xoa(User student) throws ClassNotFoundException, SQLException;
}
