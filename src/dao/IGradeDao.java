package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import entities.Grade;
import entities.Student;

public interface IGradeDao {
	public void them(Grade grade) throws SQLException, ClassNotFoundException;
	public void sua(Grade grade)throws SQLException, ClassNotFoundException;
	public void updateListGrade()throws SQLException, ClassNotFoundException;
	public ArrayList<Grade> getListGrade();
	public void xoa(Grade grade) throws ClassNotFoundException, SQLException;
}
