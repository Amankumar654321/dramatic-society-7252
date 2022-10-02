package com.masai.bean;

public class Ticket {

	private int tcid;
	private int tid;
	private int tbid;
	private int tbooked;
	public Ticket(int tcid, int tid, int tbid) {
		super();
		this.tcid = tcid;
		this.tid = tid;
		this.tbid = tbid;
	}
	@Override
	public String toString() {
		return "Ticket [tcid=" + tcid + ", tid=" + tid + ", tbid=" + tbid + "]";
	}
	public Ticket() {
		super();
	}
	public int getTcid() {
		return tcid;
	}
	public void setTcid(int tcid) {
		this.tcid = tcid;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public int getTbid() {
		return tbid;
	}
	public void setTbid(int tbid) {
		this.tbid = tbid;
	}
	public int getTbooked() {
		return tbooked;
	}
	public void setTbooked(int tbooked) {
		this.tbooked = tbooked;
	}
	
	
}
