package makeGame;

import java.sql.Date;

public class MakeGameDto {
	private int mnum;
	private String mtitle;
	private String mtag;
	private String mfile;
	private String mwriter;
	private int mview;
	private Date mdate;
	public int getMnum() {
		return mnum;
	}
	public void setMnum(int mnum) {
		this.mnum = mnum;
	}
	public String getMtitle() {
		return mtitle;
	}
	public void setMtitle(String mtitle) {
		this.mtitle = mtitle;
	}
	public String getMtag() {
		return mtag;
	}
	public void setMtag(String mtag) {
		this.mtag = mtag;
	}
	public String getMfile() {
		return mfile;
	}
	public void setMfile(String mfile) {
		this.mfile = mfile;
	}
	public String getMwriter() {
		return mwriter;
	}
	public void setMwriter(String mwriter) {
		this.mwriter = mwriter;
	}
	public int getMview() {
		return mview;
	}
	public void setMview(int mview) {
		this.mview = mview;
	}
	public Date getMdate() {
		return mdate;
	}
	public void setMdate(Date mdate) {
		this.mdate = mdate;
	}
	
	public MakeGameDto(int mnum, String mtitle, String mtag, String mfile, String mwriter, int mview, Date mdate) {
		this.mnum = mnum;
		this.mtitle = mtitle;
		this.mtag = mtag;
		this.mfile = mfile;
		this.mwriter = mwriter;
		this.mview = mview;
		this.mdate = mdate;
	}
	
	public MakeGameDto() {}


}
