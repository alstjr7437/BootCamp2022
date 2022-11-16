package game;

public class SearchDto {
	private int gnum;
	private String gname;
	private int gprice;
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
	public SearchDto(int gnum, String gname, int gprice) {
		this.gnum = gnum;
		this.gname = gname;
		this.gprice = gprice;
	}

}
