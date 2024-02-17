package ch07_dao.kpop2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.mysql.cj.exceptions.RSAException;

import ch07_dao.kpop.Artist;
import ch07_dao.kpop.Song;

public class KpopDaoImpl2<kpop2> implements KpopDao2 {

	public Connection getConnection() {
		Connection conn = null;
		try {
			Context initContext = new InitialContext();
			DataSource ds = (DataSource) initContext.lookup("java:comp/env/" + "jdbc/world");
			conn = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	@Override
		public List<Kpop2> getKpopList() {
			Connection conn = getConnection();
			String sql = "SELECT g.*, s.title, s.lyrics FROM girl_group g"
					+ "  JOIN song s ON g. hit_song_id=s.sid"
					+ " ORDER BY gid desc";
		List<Kpop2> list = new ArrayList<Kpop2>();
		try {
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Kpop2 kpop = new Kpop2(rs.getInt(1), rs.getString(2),
						LocalDate.parse(rs.getString(3)), rs.getInt(4),
						rs.getString(5), rs.getString(6));
			list.add(kpop);
			}
			rs.close(); stmt.close(); conn.close();
		} catch (Exception e) {
		}
		return list;
		}

	@Override
	public Artist getArtist(int aid) {
		
		return null;
	}

	@Override
	public Song getSong(int sid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertArtist(Artist2 artist) {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertSong(Song2 song) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateArtist(Artist2 artist) {
		// TODO Auto-generated method stub

	}

	@Override
	public void upfateSong(Song2 song) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteArtist(int aid) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteSong(int sid) {
		// TODO Auto-generated method stub

	}

}
