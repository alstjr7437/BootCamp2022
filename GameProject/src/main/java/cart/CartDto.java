package cart;

public class CartDto {
	private String cuser;
	private int cgame;
	private int cprice;
	
	public String getCuser() {
		return cuser;
	}
	public void setCuser(String cuser) {
		this.cuser = cuser;
	}
	public int getCgame() {
		return cgame;
	}
	public void setCgame(int cgame) {
		this.cgame = cgame;
	}
	public int getCprice() {
		return cprice;
	}
	public void setCprice(int cprice) {
		this.cprice = cprice;
	}
	
	public CartDto(String cuser, int cgame, int cprice) {
		this.cuser = cuser;
		this.cgame = cgame;
		this.cprice = cprice;
	}
	public CartDto() {}

	
}
