package services;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.StudentDao;
import entities.Student;
import models.StudentModel;
import utils.IoCContainer;


public class StudentService implements IStudentService{
	private IoCContainer _ioCContainer = new IoCContainer();
	private ArrayList<StudentModel> _listStudentModels = new ArrayList<StudentModel>();
	private StudentDao _studentDao = (StudentDao) _ioCContainer.getBean(StudentDao.class.toString());
	private Student _student;
	private StudentModel _studentModel = (StudentModel) IoCContainer.getBean(StudentModel.class.toString());
	private int _stt = 0;

	public void updateDataNhanVienDependOnStudentModel(StudentModel studentModel) {
		_student = (Student) _ioCContainer.getBean(Student.class.toString());
		_student.setMaSinhVien(studentModel.getMaSinhVien());
		_student.setHoTen(studentModel.getHoTen());
		_student.setEmail(studentModel.getEmail());
		_student.setSdt(studentModel.getSdt());
		_student.setGioiTinh(studentModel.getGioiTinh());
		_student.setDiaChi(studentModel.getDiaChi());
		_student.setHinh(studentModel.getHinh());
	}

	public void them(StudentModel studentModel) throws ClassNotFoundException, SQLException {
		updateDataNhanVienDependOnStudentModel(studentModel);
		_studentDao.them(_student);
		studentModel.setStt(_stt);
		_listStudentModels.add(_stt, studentModel);
		_stt++;
	}

	public void sua(StudentModel studentModel) throws ClassNotFoundException, SQLException {
		updateDataNhanVienDependOnStudentModel(studentModel);
		_studentDao.sua(_student);
		int stt = studentModel.getStt();
		_listStudentModels.remove(stt);
		_listStudentModels.add(stt, studentModel);
	}
	public void xoa(StudentModel studentModel) throws ClassNotFoundException, SQLException {
		updateDataNhanVienDependOnStudentModel(studentModel);
		boolean check = _studentDao.xoa(_student);
		if(check) {
			int stt = studentModel.getStt();
			_listStudentModels.remove(stt);
		}
	}

	public void updateListStudentModel() throws ClassNotFoundException, SQLException {
		_studentDao.updateListStudent();
		ArrayList<Student> listStudent = _studentDao.getListStudent();
		for (Student student : listStudent) {
			_studentModel = new StudentModel();
			_studentModel.setMaSinhVien(student.getMaSinhVien());
			_studentModel.setHoTen(student.getHoTen());
			_studentModel.setEmail(student.getEmail());
			_studentModel.setSdt(student.getSdt());
			_studentModel.setGioiTinh(student.getGioiTinh());
			_studentModel.setDiaChi(student.getDiaChi());
			_studentModel.setHinh(student.getHinh());
			_studentModel.setStt(_stt);
			_stt++;
			_listStudentModels.add(_studentModel);
		}

	}

	public ArrayList<StudentModel> getListStudentModel() {
		return _listStudentModels;
	}
}
