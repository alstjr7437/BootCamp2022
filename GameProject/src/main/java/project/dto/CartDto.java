package project.dto;

public class CartDto {
	private int gprice;
	private int gnum;
	private String email;
	public int getGprice() {
		return gprice;
	}
	public void setGprice(int gprice) {
		this.gprice = gprice;
	}
	public int getGnum() {
		return gnum;
	}
	public void setGnum(int gnum) {
		this.gnum = gnum;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public CartDto(int gprice, int gnum, String email) {
		this.gprice = gprice;
		this.gnum = gnum;
		this.email = email;
	}
	
}
