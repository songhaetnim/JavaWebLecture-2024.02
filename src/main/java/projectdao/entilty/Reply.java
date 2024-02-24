package projectdao.entilty;

import java.time.LocalDateTime;

public class Reply {
	private int rid;
	private String comment;
	private LocalDateTime regTime;
	private String uid;
	private int bid;
	private String uname;
	
	public Reply() { }
	public Reply(String comment, String uid, int bid) {
		this.comment = comment;
		this.uid = uid;
		this.bid = bid;
	}
	public Reply(int rid, String comment, LocalDateTime regTime, String uid, int bid, String uname) {
		this.rid = rid;
		this.comment = comment;
		this.regTime = regTime;
		this.uid = uid;
		this.bid = bid;
		this.uname = uname;
	}
	
	@Override
	public String toString() {
		return "Reply [rid=" + rid + ", comment=" + comment + ", regTime=" + regTime + ", uid=" + uid + ", bid=" + bid
				+ ", uname=" + uname + "]";
	}
	
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public LocalDateTime getRegTime() {
		return regTime;
	}
	public void setRegTime(LocalDateTime regTime) {
		this.regTime = regTime;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
}
