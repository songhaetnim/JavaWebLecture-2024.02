package project.entilty;

import java.time.LocalDateTime;

public class Reply {
		private int rid;
		private String comment;
		private LocalDateTime reDateTime;
		private String uid;
		private int bid;
		private String uname;
	
		public Reply() { }
		public Reply(int rid, String comment, LocalDateTime reDateTime, String uid, int bid, String uname) {
			super();
			this.rid = rid;
			this.comment = comment;
			this.reDateTime = reDateTime;
			this.uid = uid;
			this.bid = bid;
			this.uname = uname;
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
		public LocalDateTime getReDateTime() {
			return reDateTime;
		}
		public void setReDateTime(LocalDateTime reDateTime) {
			this.reDateTime = reDateTime;
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
	
		@Override
		public String toString() {
			return "Reply [rid=" + rid + ", comment=" + comment + ", reDateTime=" + reDateTime + ", uid=" + uid
					+ ", bid=" + bid + ", uname=" + uname + "]";
		}
		public Reply(String comment, String uid, int bid) {
			super();
			this.comment = comment;
			this.uid = uid;
			this.bid = bid;
		}
}
