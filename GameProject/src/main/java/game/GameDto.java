package game;

public class GameDto {
	private int gnum;
	private String gname;
	private int gprice;
	private String gtag;
	private String gpicture;
	public int getGnum() {
		return gnum;
	}
	public void setGnum(int gnum) {
		this.gnum = gnum;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public int getGprice() {
		return gprice;
	}
	public void setGprice(int gprice) {
		this.gprice = gprice;
	}
	public String getGtag() {
		return gtag;
	}
	public void setGtag(String gtag) {
		this.gtag = gtag;
	}
	public String getGpicture() {
		return gpicture;
	}
	public void setGpicture(String gpicture) {
		this.gpicture = gpicture;
	}
	
	public GameDto(int gnum, String gname, int gprice, String gtag, String gpicture) {
		this.gnum = gnum;
		this.gname = gname;
		this.gprice = gprice;
		this.gtag = gtag;
		this.gpicture = gpicture;
	}
	public GameDto() {}
	
}
