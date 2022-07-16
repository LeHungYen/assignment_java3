package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import entities.Student;


public interface IStudentDao {
	public void them(Student student) throws SQLException, ClassNotFoundException;
	public void sua(Student student)throws SQLException, ClassNotFoundException;
	public void updateListStudent()throws SQLException, ClassNotFoundException;
	public ArrayList<Student> getListStudent();
	public boolean xoa(Student student) throws ClassNotFoundException, SQLException;
}
