package models;

public class GradeModel{
	private int stt;
	private int id;
	private String maSV;
	private double tiengAnh;
	private double tinHoc;
	private double gdtc;
	private double diemTb;
	public GradeModel(int stt, int id, String maSV, double tiengAnh, double tinHoc, double gdtc, double diemTb) {
		this.stt = stt;
		this.id = id;
		this.maSV = maSV;
		this.tiengAnh = tiengAnh;
		this.tinHoc = tinHoc;
		this.gdtc = gdtc;
		this.diemTb = diemTb;
	}
	public GradeModel() {
	
	}
	public int getStt() {
		return stt;
	}
	public void setStt(int stt) {
		this.stt = stt;
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
	public double getDiemTb() {
		return diemTb;
	}
	public void setDiemTb(double diemTb) {
		this.diemTb = diemTb;
	}
	@Override
	public String toString() {
		return "GradeModel [stt=" + stt + ", id=" + id + ", maSV=" + maSV + ", tiengAnh=" + tiengAnh + ", tinHoc="
				+ tinHoc + ", gdtc=" + gdtc + ", diemTb=" + diemTb + "]";
	}
	
	
	
	
}