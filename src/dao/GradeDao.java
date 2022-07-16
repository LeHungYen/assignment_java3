package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entities.Grade;
import utils.DB_connection;

public class GradeDao implements IGradeDao{
	private ArrayList<Grade> _listGrade = new ArrayList<Grade>();
	@Override
	public void them(Grade grade) throws SQLException, ClassNotFoundException {
		Connection con = new DB_connection().connect();
		Statement st = con.createStatement();
		st.executeUpdate("insert into Grade values ("+"N'"+grade.getMaSV()+"',"+grade.getTiengAnh()+","+grade.getTinHoc()+","+grade.getGdtc()+")");
		st.close();
	}

	@Override
	public void sua(Grade grade) throws ClassNotFoundException, SQLException {
		Connection con = new DB_connection().connect();
		Statement st = con.createStatement();
		st.executeUpdate("update Grade set  "+"tiengAnh ="+grade.getTiengAnh()+","+"tinHoc ="+grade.getTinHoc()+", gdtc ="+grade.getGdtc()+" where maSV =N'"+grade.getMaSV()+"'");
		st.close();
	}
	@Override
	public void xoa(Grade grade) throws ClassNotFoundException, SQLException {
		Connection con = new DB_connection().connect();
		Statement st = con.createStatement();
		st.executeUpdate("delete Grade where maSV =N'"+grade.getMaSV()+"'");
		st.close();
	}

	@Override
	public void updateListGrade() throws ClassNotFoundException, SQLException {
		Connection con = new DB_connection().connect();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from Grade");
		while(rs.next()) {
			Grade grade = new Grade(Integer.parseInt(rs.getString(1)),rs.getString(2), Double.parseDouble(rs.getString(3)), Double.parseDouble(rs.getString(4)), Double.parseDouble(rs.getString(5)));
			_listGrade.add(grade);
		}
		st.close();
		
	}

	@Override
	public ArrayList<Grade> getListGrade() {
		return _listGrade;
	}
}