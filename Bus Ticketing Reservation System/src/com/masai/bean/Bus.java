package com.masai.bean;

public class Bus {

	private int bid;
	private String bname;
	private String bsource;
	private String bdestination;
	private int bseatAvailable;
	private int bfare;
	private String bcontactperson;
	private String bmobileno;
	private String bustype;
	public Bus() {
		super();
	}
	public Bus(int bid, String bname, String bsource, String bdestination, int bseatAvailable, int bfare,
			String bcontactperson, String bmobileno, String bustype) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.bsource = bsource;
		this.bdestination = bdestination;
		this.bseatAvailable = bseatAvailable;
		this.bfare = bfare;
		this.bcontactperson = bcontactperson;
		this.bmobileno = bmobileno;
		this.bustype = bustype;
	}
	@Override
	public String toString() {
		return "Bus [bid=" + bid + ", bname=" + bname + ", bsource=" + bsource + ", bdestination=" + bdestination
				+ ", bseatAvailable=" + bseatAvailable + ", bfare=" + bfare + ", bcontactperson=" + bcontactperson
				+ ", bmobileno=" + bmobileno + ", bustype=" + bustype + "]";
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getBsource() {
		return bsource;
	}
	public void setBsource(String bsource) {
		this.bsource = bsource;
	}
	public String getBdestination() {
		return bdestination;
	}
	public void setBdestination(String bdestination) {
		this.bdestination = bdestination;
	}
	public int getBseatAvailable() {
		return bseatAvailable;
	}
	public void setBseatAvailable(int bseatAvailable) {
		this.bseatAvailable = bseatAvailable;
	}
	public int getBfare() {
		return bfare;
	}
	public void setBfare(int bfare) {
		this.bfare = bfare;
	}
	public String getBcontactperson() {
		return bcontactperson;
	}
	public void setBcontactperson(String bcontactperson) {
		this.bcontactperson = bcontactperson;
	}
	public String getBmobileno() {
		return bmobileno;
	}
	public void setBmobileno(String bmobileno) {
		this.bmobileno = bmobileno;
	}
	public String getBustype() {
		return bustype;
	}
	public void setBustype(String bustype) {
		this.bustype = bustype;
	}
	
	
}
