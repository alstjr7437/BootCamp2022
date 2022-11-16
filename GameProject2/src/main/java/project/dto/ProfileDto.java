package project.dto;

public class ProfileDto {
	private String infor;
	private String name;

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
	public ProfileDto(String name, String infor) {
		this.name = name;
		this.infor = infor;
	}
	
}
