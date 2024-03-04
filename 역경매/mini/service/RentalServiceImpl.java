package mini.service;

import java.util.List;
import mini.dao.RentalDao;
import mini.entity.Rental;

public class RentalServiceImpl implements RentalService {
    private RentalDao rDao = new RentalDao();

    @Override
    public List<Rental> getRentalList(int page, String field, String query) {
        int countPerPage = RentalService.COUNT_PER_PAGE;
        return rDao.getRentalList(page, countPerPage);
    }

    @Override
    public Rental getRental(int rentalId) {
        return rDao.getRentalById(rentalId);
    }

    @Override
    public int getRentalCount(String field, String query) {
        return rDao.countRentals();
    }

    @Override
    public int insertRental(Rental rental) {
        try {
            rDao.insertRental(rental);
            return RentalService.RENTAL_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return RentalService.RENTAL_FAIL;
        }
    }

    @Override
    public int updateRental(Rental rental) {
        try {
            rDao.updateRental(rental);
            return RentalService.RENTAL_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return RentalService.RENTAL_FAIL;
        }
    }

    @Override
    public int deleteRental(String rentalId) {
        try {
            rDao.deleteRental(rentalId);
            return RentalService.RENTAL_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return RentalService.RENTAL_FAIL;
        }
    }
}
