package signUp;

public class SignUpDto {
	private String email;
	private String uname;
	private String pwd;
	private String infor;
	private int credit;
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
	public String getInfor() {
		return infor;
	}
	public void setInfor(String infor) {
		this.infor = infor;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	
	public SignUpDto(String email, String uname, String pwd, String infor, int credit) {
		this.email = email;
		this.uname = uname;
		this.pwd = pwd;
		this.infor = infor;
		this.credit = credit;
	}
	public SignUpDto() {}
}
