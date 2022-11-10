package project.dto;

public class SignUpDto {
	private String email;
	private String uname;
	private String pwd;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public SignUpDto(String email, String uname, String pwd) {
		this.email = email;
		this.uname = uname;
		this.pwd = pwd;
	}
	public SignUpDto() {
		
	}
}
