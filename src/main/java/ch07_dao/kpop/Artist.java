package ch07_dao.kpop;

import java.time.LocalDate;

public class Artist {
	private int aid;
	private String name;
	private LocalDate debut;
	private int hitSongId;
	
	public Artist() { }
	public Artist(String name, LocalDate debut, int hitSongId) {
		this.name = name;
		this.debut = debut;
		this.hitSongId = hitSongId;
	}
	public Artist(int aid, String name, LocalDate debut, int hitSongId) {
		this.aid = aid;
		this.name = name;
		this.debut = debut;
		this.hitSongId = hitSongId;
	}
	
	@Override
	public String toString() {
		return "Artist [aid=" + aid + ", name=" + name + ", debut=" + debut + ", hitSongId=" + hitSongId + "]";
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
	public int getHitSongId() {
		return hitSongId;
	}
	public void setHitSongId(int hitSongId) {
		this.hitSongId = hitSongId;
	}
}

