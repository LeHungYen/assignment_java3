package services;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.UserDao;
import dao.UserDao;
import entities.User;
import entities.User;
import models.UserModel;
import models.UserModel;
import utils.IoCContainer;

public class UserService implements IUserService{
	private IoCContainer _ioCContainer = new IoCContainer();
	private ArrayList<UserModel> _listUserModels = new ArrayList<UserModel>();
	private UserDao _userDao = (UserDao) _ioCContainer.getBean(UserDao.class.toString());
	private User _user;
	private UserModel _userModel = new UserModel();
	private int _stt = 0;

	public void updateDataUserDependOnUserModel(UserModel userModel) {
		_user = new User();
		_user.setUsername(userModel.getUsername());
		_user.setPassword(userModel.getPassword());
		_user.setRole(userModel.getRole());
		
	}

	public void them(UserModel userModel) throws ClassNotFoundException, SQLException {
		updateDataUserDependOnUserModel(userModel);
		_userDao.them(_user);
		userModel.setStt(_stt);
		_listUserModels.add(_stt, userModel);
		_stt++;
	}

	public void sua(UserModel userModel) throws ClassNotFoundException, SQLException {
		updateDataUserDependOnUserModel(userModel);
		_userDao.sua(_user);
		int stt = userModel.getStt();
		_listUserModels.remove(stt);
		_listUserModels.add(stt, userModel);
	}
	public void xoa(UserModel userModel) throws ClassNotFoundException, SQLException {
		updateDataUserDependOnUserModel(userModel);
		_userDao.xoa(_user);
		int stt = userModel.getStt();
		_listUserModels.remove(stt);
	}

	public void updateListUserModel() throws ClassNotFoundException, SQLException {
		_userDao.updateListUser();
		ArrayList<User> listUser = _userDao.getListUser();
		for (User user : listUser) {
			_userModel = new UserModel();
			_userModel.setUsername(user.getUsername());
			_userModel.setPassword(user.getPassword());
			_userModel.setRole(user.getRole());
			_userModel.setStt(_stt);
			_stt++;
			_listUserModels.add(_userModel);
		}

	}

	public ArrayList<UserModel> getListUserModel() {
		return _listUserModels;
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		UserService userService = (UserService) IoCContainer.getBean(UserService.class+"");
		UserModel userModel = new UserModel(0, "CanBoDaoTao",utils.Utilities.hashingPassword("CanBoDaoTao") , "CanBoDaoTao");
		UserModel userModel1 = new UserModel(0, "GiangVien", utils.Utilities.hashingPassword("GiangVien"), "GiangVien");
		
		userService.them(userModel);
		userService.them(userModel1);
	}
}
