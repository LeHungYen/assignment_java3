package models;

public class UserModel {
	private int stt;
	private String username;
	private String password;
	private String role;
	
	public UserModel(int stt, String username, String password, String role) {
		this.stt = stt;
		this.username = username;
		this.password = password;
		this.role = role;
	}
	public UserModel() {
	}
	
	
	public int getStt() {
		return stt;
	}
	public void setStt(int stt) {
		this.stt = stt;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", role=" + role + "]";
	}
}