package ch07_dao.kpop;

import java.time.LocalDate;

public class Kpop {
	private int aid;
	private String name;
	private LocalDate debut;
	private int sid;
	private String title;
	private String lyrics;
	
	public Kpop() { }
	public Kpop(int aid, String name, LocalDate debut, int sid, String title, String lyrics) {
		this.aid = aid;
		this.name = name;
		this.debut = debut;
		this.sid = sid;
		this.title = title;
		this.lyrics = lyrics;
	}
	
	@Override
	public String toString() {
		return "Kpop [aid=" + aid + ", name=" + name + ", debut=" + debut + ", sid=" + sid + ", title=" + title
				+ ", lyrics=" + lyrics + "]";
	}
	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDebut() {
		return debut;
	}
	public void setDebut(LocalDate debut) {
		this.debut = debut;
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
