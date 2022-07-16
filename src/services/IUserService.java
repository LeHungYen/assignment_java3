package services;

import java.sql.SQLException;
import java.util.ArrayList;

import models.StudentModel;
import models.UserModel;

public interface IUserService {
	public void updateDataUserDependOnUserModel(UserModel userModel);
	public void them(UserModel userModel) throws ClassNotFoundException, SQLException;
	public void sua(UserModel userModel) throws ClassNotFoundException, SQLException;
	public void updateListUserModel() throws ClassNotFoundException, SQLException;
	public ArrayList<UserModel> getListUserModel();
}
