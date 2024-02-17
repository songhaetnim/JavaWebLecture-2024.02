package ch07_dao.kpop2;

public class Song2 {

	private int sid;
	private String title;
	private String lyrics;
	
	public Song2() { };
	public Song2(String title, String lyrics) {
		this.title = title;
		this.lyrics = lyrics;
	}
	public Song2(int sid, String title, String lyrics) {
		this.sid = sid;
		this.title = title;
		this.lyrics = lyrics;
	}
	@Override
	public String toString() {
		return "Song2 [sid=" + sid + ", title=" + title + ", lyrics=" + lyrics + "]";
	}
	
	

}
