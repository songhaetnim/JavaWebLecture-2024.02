package mini.service;

import java.util.List;

import mini.entity.Rental;

public interface RentalService {

    // 상수 정의
    public static final int RENTAL_SUCCESS = 0;
    public static final int RENTAL_FAIL = 1;
    public static final int EQUIPMENT_NOT_AVAILABLE = 2;
    public static final int COUNT_PER_PAGE = 10;

    // 페이지 번호와 검색 조건에 따라 렌탈 목록 조회
    List<Rental> getRentalList(int page, String field, String query);

    // 특정 렌탈 ID로 렌탈 정보 조회
    Rental getRental(int rentalId);

    // 검색 조건에 따른 렌탈 정보의 총 개수 조회
    int getRentalCount(String field, String query);

    // 새로운 렌탈 정보 추가
    int insertRental(Rental rental);

    // 기존 렌탈 정보 수정
    int updateRental(Rental rental);

    // 특정 렌탈 정보 삭제
    int deleteRental(String rentalId);
    
}

