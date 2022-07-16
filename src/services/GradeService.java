package services;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.GradeDao;
import entities.Grade;
import models.GradeModel;
import utils.IoCContainer;

public class GradeService implements IGradeService{
	private IoCContainer _ioCContainer = new IoCContainer();
	private ArrayList<GradeModel> _listGradeModels = new ArrayList<GradeModel>();
	private GradeDao _gradeDao = (GradeDao) _ioCContainer.getBean(GradeDao.class.toString());
	private Grade _grade;
	private GradeModel _gradeModel = new GradeModel();
	private int _stt = 0;

	public void updateDataGradeDependOnGradeModel(GradeModel gradeModel) {
		_grade = new Grade();
		_grade.setId(gradeModel.getId());
		_grade.setMaSV(gradeModel.getMaSV());
		_grade.setTiengAnh(gradeModel.getTiengAnh());
		_grade.setTinHoc(gradeModel.getTinHoc());
		_grade.setGdtc(gradeModel.getGdtc());
	}

	public void them(GradeModel gradeModel) throws ClassNotFoundException, SQLException {
		updateDataGradeDependOnGradeModel(gradeModel);
		_gradeDao.them(_grade);
		gradeModel.setStt(_stt);
		gradeModel.setDiemTb(getDiemTB(gradeModel.getTiengAnh(), gradeModel.getTinHoc(), gradeModel.getGdtc()));
		_listGradeModels.add(_stt, gradeModel);
		_stt++;
	}

	public void sua(GradeModel gradeModel) throws ClassNotFoundException, SQLException {
		updateDataGradeDependOnGradeModel(gradeModel);
		_gradeDao.sua(_grade);
		int stt = gradeModel.getStt();
		_listGradeModels.remove(stt);
		gradeModel.setDiemTb(getDiemTB(gradeModel.getTiengAnh(), gradeModel.getTinHoc(), gradeModel.getGdtc()));
		_listGradeModels.add(stt, gradeModel);
	}
	public void xoa(GradeModel gradeModel) throws ClassNotFoundException, SQLException {
		updateDataGradeDependOnGradeModel(gradeModel);
		_gradeDao.xoa(_grade);
		int stt = gradeModel.getStt();
		_listGradeModels.remove(stt);
		updateSTT();
	}
	
	public double getDiemTB(double tiengAnh , double tinHoc , double gdtc) {
		double diemTB = (tiengAnh+tinHoc+gdtc)/3;
		return diemTB;
	}

	public void updateSTT() {
		_stt = 0;
		for (GradeModel gradeModel : _listGradeModels) {
			gradeModel.setStt(_stt);
			_stt++;
		}
	}
	
	public void updateListGradeModel() throws ClassNotFoundException, SQLException {
		_gradeDao.updateListGrade();
		ArrayList<Grade> listGrade = _gradeDao.getListGrade();
		for (Grade grade : listGrade) {
			_gradeModel = new GradeModel();
			_gradeModel.setId(grade.getId());
			_gradeModel.setMaSV(grade.getMaSV());
			_gradeModel.setTiengAnh(grade.getTiengAnh());
			_gradeModel.setTinHoc(grade.getTinHoc());
			_gradeModel.setGdtc(grade.getGdtc());
			_gradeModel.setStt(_stt);
			_stt++;
			_gradeModel.setDiemTb(getDiemTB(grade.getTiengAnh(), grade.getTinHoc(), grade.getGdtc()));
			_listGradeModels.add(_gradeModel);
		}

	}

	public ArrayList<GradeModel> getListGradeModel() {
		return _listGradeModels;
	}
}
