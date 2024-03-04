package mini.service;

import java.util.List;

import mini.dao.AuctionsDao;
import mini.entity.Auctions;

public class AuctionsServiceImpl implements AuctionsService {
	private AuctionsDao aDao = new AuctionsDao();

	@Override
	public void insertAuctions(Auctions auctions) {
		aDao.insertAuctions(auctions);
	}

	@Override
	public int getAuctionsCount() {
		return aDao.getAuctionsCount();
	}

	@Override
	public List<Auctions> getAuctionsList(int page) {
		int offset = (page - 1) * COUNT_PER_PAGE;
		List<Auctions> list = aDao.getAuctionsList(COUNT_PER_PAGE, offset);
		return list;
	}

	@Override
	public Auctions getAuctions(int auction_id) {
		return aDao.getAuctions(auction_id);
	}

	@Override
	public void auctionParticipation(Auctions auctions) {
		aDao.auctionParticipation(auctions);
	}
	
	
}
