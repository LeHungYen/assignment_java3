package entities;

public class Grade {
	private int id;
	private String maSV;
	private double tiengAnh;
	private double tinHoc;
	private double gdtc;
	public Grade(int id, String maSV, double tiengAnh, double tinHoc, double gdtc) {
		this.id = id;
		this.maSV = maSV;
		this.tiengAnh = tiengAnh;
		this.tinHoc = tinHoc;
		this.gdtc = gdtc;
	}
	public Grade() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMaSV() {
		return maSV;
	}
	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}
	public double getTiengAnh() {
		return tiengAnh;
	}
	public void setTiengAnh(double tiengAnh) {
		this.tiengAnh = tiengAnh;
	}
	public double getTinHoc() {
		return tinHoc;
	}
	public void setTinHoc(double tinHoc) {
		this.tinHoc = tinHoc;
	}
	public double getGdtc() {
		return gdtc;
	}
	public void setGdtc(double gdtc) {
		this.gdtc = gdtc;
	}
	@Override
	public String toString() {
		return "Grade [id=" + id + ", maSV=" + maSV + ", tiengAnh=" + tiengAnh + ", tinHoc=" + tinHoc + ", gdtc=" + gdtc
				+ "]";
	}
	
	
}
