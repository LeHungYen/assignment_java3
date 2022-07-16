package entities;

public class Student {
	private String maSinhVien;
	private String hoTen;
	private String Email;
	private String sdt;
	private String gioiTinh;
	private String diaChi;
	private String hinh;
	
	
	
	public Student(String maSinhVien, String hoTen, String email, String sdt, String gioiTinh, String diaChi,
			String hinh) {
		this.maSinhVien = maSinhVien;
		this.hoTen = hoTen;
		Email = email;
		this.sdt = sdt;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
		this.hinh = hinh;
	}
	public Student() {
	}
	
	public String getMaSinhVien() {
		return maSinhVien;
	}
	public void setMaSinhVien(String maSinhVien) {
		this.maSinhVien = maSinhVien;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getHinh() {
		return hinh;
	}
	public void setHinh(String hinh) {
		this.hinh = hinh;
	}
	@Override
	public String toString() {
		return "Student [maSinhVien=" + maSinhVien + ", hoTen=" + hoTen + ", Email=" + Email + ", sdt=" + sdt
				+ ", gioiTinh=" + gioiTinh + ", diaChi=" + diaChi + ", hinh=" + hinh + "]";
	}
	
	
}
