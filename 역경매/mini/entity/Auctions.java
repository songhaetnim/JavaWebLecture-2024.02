package mini.entity;

import java.time.LocalDateTime;

public class Auctions {
	private int auction_id;
	private String user_id;
	private String title;
	private int start_price;
	private int current_price;
	private LocalDateTime end_time;
	private String content ;
	private String seller_id;
	private String pimage;
	
	// 기본 생성자
	public Auctions() { }
	// 전체 생성자
	public Auctions(int auction_id, String user_id, String title, int start_price, int current_price,
			LocalDateTime end_time, String content, String seller_id, String pimage) {
		this.auction_id = auction_id;
		this.user_id = user_id;
		this.title = title;
		this.start_price = start_price;
		this.current_price = current_price;
		this.end_time = end_time;
		this.content = content;
		this.seller_id = seller_id;
		this.pimage = pimage;
	}
	// 경매 게시물 작성
	public Auctions(String user_id, String title, int start_price, String content, String pimage) {
		this.user_id = user_id;
		this.title = title;
		this.start_price = start_price;
		this.content = content;
		this.pimage = pimage;
	}
	// 경매 참여
	public Auctions(int auction_id, int current_price, String seller_id) {
		this.auction_id = auction_id;
		this.current_price = current_price;
		this.seller_id = seller_id;
	}
	
	@Override
	public String toString() {
		return "Auctions [auction_id=" + auction_id + ", user_id=" + user_id + ", title=" + title
				+ ", start_price=" + start_price + ", current_price=" + current_price + ", end_time=" + end_time
				+ ", content=" + content + ", seller_id=" + seller_id + "]";
	}
	
	public int getAuction_id() {
		return auction_id;
	}
	public void setAuction_id(int auction_id) {
		this.auction_id = auction_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getStart_price() {
		return start_price;
	}
	public void setStart_price(int start_price) {
		this.start_price = start_price;
	}
	public int getCurrent_price() {
		return current_price;
	}
	public void setCurrent_price(int current_price) {
		this.current_price = current_price;
	}
	public LocalDateTime getEnd_time() {
		return end_time;
	}
	public void setEnd_time(LocalDateTime end_time) {
		this.end_time = end_time;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSeller_id() {
		return seller_id;
	}
	public void setSeller_id(String seller_id) {
		this.seller_id = seller_id;
	}
	public String getPimage() {
		return pimage;
	}
	public void setPimage(String pimage) {
		this.pimage = pimage;
	}
}
