package com.masai.bean;

public class Customer {

	private int cid;
	private String cname;
	private int cage;
	private String cgender;
	private String cmobile;
	private String cpassword;
	public int getCid() {
		return cid;
	}
	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cname=" + cname + ", cage=" + cage + ", cgender=" + cgender + ", cmobile="
				+ cmobile + ", cpassword=" + cpassword + "]";
	}
	public Customer() {
		super();
	}
	public Customer(int cid, String cname, int cage, String cgender, String cmobile, String cpassword) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.cage = cage;
		this.cgender = cgender;
		this.cmobile = cmobile;
		this.cpassword = cpassword;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getCage() {
		return cage;
	}
	public void setCage(int cage) {
		this.cage = cage;
	}
	public String getCgender() {
		return cgender;
	}
	public void setCgender(String cgender) {
		this.cgender = cgender;
	}
	public String getCmobile() {
		return cmobile;
	}
	public void setCmobile(String cmobile) {
		this.cmobile = cmobile;
	}
	public String getCpassword() {
		return cpassword;
	}
	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}
	
	
	
	
}
