package services;

import java.sql.SQLException;
import java.util.ArrayList;

import models.StudentModel;

public interface IStudentService {
	public void updateDataNhanVienDependOnStudentModel(StudentModel studentModel);
	public void them(StudentModel studentModel) throws ClassNotFoundException, SQLException;
	public void sua(StudentModel studentModel) throws ClassNotFoundException, SQLException;
	public void updateListStudentModel() throws ClassNotFoundException, SQLException;
	public ArrayList<StudentModel> getListStudentModel();
}
