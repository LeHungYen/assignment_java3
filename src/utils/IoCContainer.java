package utils;

import java.util.HashMap;
import java.util.Map;

import dao.GradeDao;
import dao.IGradeDao;
import dao.IStudentDao;
import dao.IUserDao;
import dao.StudentDao;
import dao.UserDao;
import entities.Student;
import models.StudentModel;
import services.GradeService;
import services.IGradeService;
import services.IStudentService;
import services.IUserService;
import services.StudentService;
import services.UserService;

public class IoCContainer {
	private static Map<String, Object> container;
	static {
		container = new HashMap<String, Object>();
	}

	public static Object getBean(String classNameSpace) {
		switch (classNameSpace) {
		case "class utils.Utilities":
			if (container.containsKey(classNameSpace)) {
				return container.get(classNameSpace);
			}
			Utilities utilities = new Utilities();
			container.put(classNameSpace, utilities);
			return utilities;
		case "class utils.DB_Connection":
			if (container.containsKey(classNameSpace)) {
				return container.get(classNameSpace);
			}
			DB_connection db_Connection = new DB_connection();
			container.put(classNameSpace, db_Connection);
			return db_Connection;
		case "class entities.Student":
			if (container.containsKey(classNameSpace)) {
				return container.get(classNameSpace);
			}
			Student nhanVien = new Student();
			container.put(classNameSpace, nhanVien);
			return nhanVien;
		case "class models.StudentModel":
			if (container.containsKey(classNameSpace)) {
				return container.get(classNameSpace);
			}
			StudentModel studentModel = new StudentModel();
			container.put(classNameSpace, studentModel);
			return studentModel;
		case "class dao.StudentDao":
			if (container.containsKey(classNameSpace)) {
				return container.get(classNameSpace);
			}
			IStudentDao studentDao = new StudentDao();
			container.put(classNameSpace, studentDao);
			return studentDao;
		case "class services.StudentService":
			if (container.containsKey(classNameSpace)) {
				return container.get(classNameSpace);
			}
			IStudentService studentService = new StudentService();
			container.put(classNameSpace, studentService);
			return studentService;
		case "class services.UserService":
			if (container.containsKey(classNameSpace)) {
				return container.get(classNameSpace);
			}
			IUserService userService = new UserService();
			container.put(classNameSpace, userService);
			return userService;
		case "class dao.UserDao":
			if (container.containsKey(classNameSpace)) {
				return container.get(classNameSpace);
			}
			IUserDao userDao = new UserDao();
			container.put(classNameSpace, userDao);
			return userDao;
		case "class dao.GradeDao":
			if (container.containsKey(classNameSpace)) {
				return container.get(classNameSpace);
			}
			IGradeDao gradeDao = new GradeDao();
			container.put(classNameSpace, gradeDao);
			return gradeDao;
		case "class services.GradeService":
			if (container.containsKey(classNameSpace)) {
				return container.get(classNameSpace);
			}
			IGradeService gradeService = new GradeService();
			container.put(classNameSpace, gradeService);
			return gradeService;

		}
		return null;
	}

	public static void main(String[] args) {
		System.out.println(GradeService.class);
	}
}
