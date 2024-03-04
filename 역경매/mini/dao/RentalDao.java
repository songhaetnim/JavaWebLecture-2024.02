package mini.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import mini.entity.Rental;

public class RentalDao {

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

	public Rental getRentalById(int rentalId) {
		Connection conn = getConnection();
		String sql = "SELECT * FROM rentals WHERE rental_id=?";
		Rental rental = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rentalId);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				rental = new Rental(rs.getInt(1), rs.getString(2), rs.getString(3),
						LocalDateTime.parse(rs.getString(4).replace(" ", "T")),
						LocalDateTime.parse(rs.getString(5).replace(" ", "T")), rs.getInt(6), rs.getInt(7));
			}

			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rental;
	}

	public List<Rental> getRentalList(int page, int countPerPage) {
		List<Rental> rentals = new ArrayList<>();
		Connection conn = getConnection();
		String sql = "SELECT * FROM rentals LIMIT ? OFFSET ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, countPerPage);
			pstmt.setInt(2, (page - 1) * countPerPage);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Rental rental = new Rental(rs.getInt(1), rs.getString(2), rs.getString(3),
						LocalDateTime.parse(rs.getString(4).replace(" ", "T")),
						LocalDateTime.parse(rs.getString(5).replace(" ", "T")), rs.getInt(6), rs.getInt(7));

				rentals.add(rental);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rentals;
	}

	public void insertRental(Rental rental) {
		Connection conn = getConnection();
		String sql = "INSERT INTO rentals (rental_id, user_id, equipment_id, start_date, end_date, total_price, payment_status) VALUES (?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rental.getRentalId());
			pstmt.setString(2, rental.getUserId());
			pstmt.setString(3, rental.getEquipmentId());
			pstmt.setString(4, rental.getStartDate().toString().replace(" ", "T"));
			pstmt.setString(5, rental.getEndDate().toString().replace(" ", "T"));
			pstmt.setInt(6, rental.getTotalPrice());
			pstmt.setInt(7, rental.getPaymentStatus());

			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateRental(Rental rental) {
	    Connection conn = getConnection();
	    String sql = "UPDATE rentals SET user_id=?, equipment_id=?, start_date=?, end_date=?, total_price=?, payment_status=? WHERE rental_id=?";
	    try {
	        PreparedStatement pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, rental.getUserId());
	        pstmt.setString(2, rental.getEquipmentId());
	        pstmt.setString(3, rental.getStartDate().toString().replace("T", " ")); // "T"를 공백으로 대체
	        pstmt.setString(4, rental.getEndDate().toString().replace("T", " ")); // "T"를 공백으로 대체
	        pstmt.setInt(5, rental.getTotalPrice());
	        pstmt.setInt(6, rental.getPaymentStatus());
	        pstmt.setInt(7, rental.getRentalId());
	        
	        pstmt.executeUpdate();
	        pstmt.close();
	        conn.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}


	public void deleteRental(String rentalId) {
		Connection conn = getConnection();
		String sql = "DELETE FROM rentals WHERE rental_id=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rentalId);

			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 추가
	public int countRentals() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;

		try {
			conn = getConnection();
			String sql = "SELECT COUNT(*) FROM rentals";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) { // 결과가 존재하면
				count = rs.getInt(1); // 첫 번째 컬럼의 값을 가져오기
			}
		} catch (Exception e) {
			e.printStackTrace(); // 예외 처리
		} finally {
			// 자원 해제
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		return count; // 총 렌탈 수 반환
	}

}
