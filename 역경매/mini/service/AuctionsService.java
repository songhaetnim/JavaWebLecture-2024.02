package mini.service;

import java.util.List;

import mini.entity.Auctions;

public interface AuctionsService {
	public static final int COUNT_PER_PAGE = 10;

	void insertAuctions(Auctions auctions);

	void auctionParticipation(Auctions auctions);
	
	int getAuctionsCount();
	
	List<Auctions> getAuctionsList(int page);
	
	Auctions getAuctions(int auction_id);
}
