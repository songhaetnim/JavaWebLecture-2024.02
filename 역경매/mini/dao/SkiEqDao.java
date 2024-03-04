package mini.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import mini.entity.SkiEquipment;

public class SkiEqDao {

	public Connection getConnection() {
		Connection conn = null;
		try {
			Context initContext = new InitialContext();
			DataSource ds = (DataSource) initContext.lookup("java:comp/env/" + "jdbc/auctiondb");
			conn = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public SkiEquipment getEquipmentById(String equipmentId) {
		// 장비를 가져오는 메서드
		Connection conn = getConnection();
		String sql = "SELECT * FROM ski_equipment WHERE equipment_id=?";
		SkiEquipment equipment = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, equipmentId);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				equipment = new SkiEquipment(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6));
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return equipment;
	}

	public List<SkiEquipment> getEquipmentList(int num, int offset) {
		Connection conn = getConnection();
		String sql = "SELECT * FROM ski_equipment LIMIT ? OFFSET ?";

		List<SkiEquipment> list = new ArrayList<>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setInt(2, offset);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				SkiEquipment equipment = new SkiEquipment(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6));
				list.add(equipment);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public void insertEquipment(SkiEquipment equipment) {
		// 장비 추가 메서드
		Connection conn = getConnection();
		String sql = "INSERT INTO ski_equipment (equipment_id, user_id, equipment_name, description, `condition`, image_url) VALUES (?, ?, default, ?, ?, ?)";
		try {
		    PreparedStatement pstmt = conn.prepareStatement(sql);
		    pstmt.setString(1, equipment.getEquipmentId());
		    pstmt.setString(2, equipment.getUserId());
		    pstmt.setString(3, equipment.getDescription());
		    pstmt.setString(4, equipment.getCondition());
		    pstmt.setString(5, equipment.getImageUrl());

		    pstmt.executeUpdate();
		    pstmt.close();
		    conn.close();
		} catch (Exception e) {
		    e.printStackTrace();
		}

	}

	public void updateEquipment(SkiEquipment equipment) {
		// 장비 업데이트 메서드
		Connection conn = getConnection();
		String sql = "UPDATE ski_equipment SET description=?, `condition`=?, image_url=? WHERE equipment_id=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, equipment.getDescription());
			pstmt.setString(2, equipment.getCondition());
			pstmt.setString(3, equipment.getImageUrl());
			pstmt.setString(4, equipment.getEquipmentId());

			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteEquipment(String equipmentId) {
		// 삭제 메서드
		Connection conn = getConnection();
		String sql = "DELETE FROM ski_equipment WHERE equipment_id=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, equipmentId);

			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int countEquipment() {
		// 장비 카운트 메서드
		Connection conn = getConnection();
		String sql = "SELECT COUNT(equipment_id) FROM ski_equipment";
		int count = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
}
