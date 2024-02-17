package ch07_dao.kpop2;

import java.time.LocalDate;  // <-- LocalDate 컨트롤 스페으바 누르고 생성하면 자동으로 생김

public class Artist2 {
	
	 private int aid;
	 private String name;
	 private LocalDate debut;
	 private int hitSongId;
	
	 
	 public Artist2() { }
	 public Artist2(String name, LocalDate debut, int hitSongId) {
		this.name = name;
		this.debut = debut;
		this.hitSongId = hitSongId;
	}
	public Artist2(int aid, String name, LocalDate debut, int hitSongId) {
		super();
		this.aid = aid;
		this.name = name;
		this.debut = debut;
		this.hitSongId = hitSongId;
	/*
	 * 3개는 DB에 데이터를 입력할 때 사용할거임
	 * 4개는 DB에서 데이터를 부를때 사용할거고
	 * 첫번째 필드명은 4가지중 하난 빈곽으로 둬야함으로 3개만 해두고
	 * 첫번째 필드명 끝나는 이 중가로 } 밑으로 다시 두번째 필드명 불러서 4개를 총 불러둠
	 */
		
	}
	@Override
	public String toString() {
		return "Artist2 [aid=" + aid + ", name=" + name + ", debut=" + debut + ", hitSongId=" + hitSongId + "]";
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
	 

	 		