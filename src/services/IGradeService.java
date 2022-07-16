package services;

import java.sql.SQLException;
import java.util.ArrayList;

import models.GradeModel;

public interface IGradeService {
	public void updateDataGradeDependOnGradeModel(GradeModel gradeModel);
	public void them(GradeModel gradeModel) throws ClassNotFoundException, SQLException;
	public void sua(GradeModel gradeModel) throws ClassNotFoundException, SQLException;
	public void updateListGradeModel() throws ClassNotFoundException, SQLException;
	public ArrayList<GradeModel> getListGradeModel();
}
