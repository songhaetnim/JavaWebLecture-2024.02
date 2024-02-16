package ch07_dao.kpop;

public class Song {
	private int sid;
	private String title;
	private String lyrics;

	public Song() { }
	public Song(String title, String lyrics) {
		this.title = title;
		this.lyrics = lyrics;
	}
	public Song(int sid, String title, String lyrics) {
		this.sid = sid;
		this.title = title;
		this.lyrics = lyrics;
	}
	@Override
	public String toString() {
		return "Song [sid=" + sid + ", title=" + title + ", lyrics=" + lyrics + "]";
	}
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLyrics() {
		return lyrics;
	}
	public void setLyrics(String lyrics) {
		this.lyrics = lyrics;
	}
}