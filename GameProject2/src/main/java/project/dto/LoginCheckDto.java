package project.dto;

public class LoginCheckDto {
	private String email;
	private String pwd;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public LoginCheckDto(String email, String pwd) {
		this.email = email;
		this.pwd = pwd;
	}
	public LoginCheckDto() {
		
	}
	
}
