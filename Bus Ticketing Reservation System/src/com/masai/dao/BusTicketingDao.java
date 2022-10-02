package com.masai.dao;

import java.util.List;

import com.masai.bean.Admin;
import com.masai.bean.Bus;
import com.masai.bean.Customer;
import com.masai.bean.Ticket;
import com.masai.exception.AdminException;
import com.masai.exception.BusException;
import com.masai.exception.Customerexception;

public interface BusTicketingDao {
	
	
	public String registerAdministrator(int aid, String aname, String aemail, String apassword);
	
	public String registerCustomer(Customer customer);
	public String registerBus(Bus bus);
	public String registerForTicketBus(Ticket ticket);
	public Bus getBusDetailsBybusId(int bid) throws BusException;
	public Admin loginAdmin(String username, String password) throws AdminException;
	
	public List<Bus> getAllBusDetails() throws BusException;
	
	public String ticketBookedByCustomer(int Tcid, int Tbid, int Tbooked ) throws BusException, Customerexception;
	
	public String AvailableTicketsafterbooking(int bookedticket, int availableticket);
	public String deleteTheTicket(int Tcid, int Tbid);
	public void getTheTicketDetails(int tcid);
	
	
	

}
