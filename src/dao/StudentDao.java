package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import entities.Student;
import utils.DB_connection;

public class StudentDao implements IStudentDao{
	private ArrayList<Student> _listStudent = new ArrayList<Student>();
	@Override
	public void them(Student student) throws SQLException, ClassNotFoundException {
		Connection con = new DB_connection().connect();
		Statement st = con.createStatement();
		st.executeUpdate("insert into student values ("+"N'"+student.getMaSinhVien()+"',"+"N'"+student.getHoTen()+"',"+"N'"+student.getEmail()+"',"+"N'"+student.getSdt()+"',"+student.getGioiTinh()+",N'"+student.getDiaChi()+"',"+"N'"+student.getHinh()+"')");
		st.close();
	}

	@Override
	public void sua(Student student) throws ClassNotFoundException, SQLException {
		Connection con = new DB_connection().connect();
		Statement st = con.createStatement();
		System.out.println(student.getGioiTinh());
		st.executeUpdate("update student set  "+"hoTen =N'"+student.getHoTen()+"',"+"email =N'"+student.getEmail()+"',"+"sdt =N'"+student.getSdt()+"', gioiTinh ="+student.getGioiTinh()+",diaChi =N'"+student.getDiaChi()+"',"+"hinh =N'"+student.getHinh()+"'"+"where maSV =N'"+student.getMaSinhVien()+"'");
		st.close();
	}
	@Override
	public boolean xoa(Student student) throws ClassNotFoundException, SQLException {
		Connection con = new DB_connection().connect();
		Statement st = con.createStatement();
		try {
			st.executeUpdate("delete student where maSV = N'"+student.getMaSinhVien()+"'");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Bạn không thể xóa sinh viên này vì sinh viên này đang có trong lớp nào đó");
			return false;
		}
		st.close();
		return true;
	}

	@Override
	public void updateListStudent() throws ClassNotFoundException, SQLException {
		Connection con = new DB_connection().connect();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from student");
		while(rs.next()) {
			Student student = new Student(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
			_listStudent.add(student);
		}
		st.close();
		
	}

	@Override
	public ArrayList<Student> getListStudent() {
		return _listStudent;
	}
	
}
