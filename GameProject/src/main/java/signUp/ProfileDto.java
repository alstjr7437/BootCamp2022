package signUp;

public class ProfileDto {
	private String infor;
	private String name;
	private int credit;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getinFor() {
		return infor;
	}
	public void setinFor(String infor) {
		this.infor = infor;
	}
	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}
	public ProfileDto(String name, String infor, int credit) {
		this.name = name;
		this.infor = infor;
		this.credit = credit;
	}


	
}
