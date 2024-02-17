package ch07_dao.kpop2;

import java.util.List;

import ch07_dao.kpop.Artist;
import ch07_dao.kpop.Kpop;
import ch07_dao.kpop.Song;

public interface KpopDao2 {

	List<Kpop2> getKpopList();

	Artist getArtist(int aid);

	Song getSong(int sid);

	void insertArtist(Artist2 artist);
	
	void insertSong(Song2 song);

	void updateArtist(Artist2 artist);

	void upfateSong(Song2 song);

	void deleteArtist(int aid);

	void deleteSong(int sid);
// interface 에서 이 기능들을 Dao에서 사용할거라고 미리 선언해둔다.
}
