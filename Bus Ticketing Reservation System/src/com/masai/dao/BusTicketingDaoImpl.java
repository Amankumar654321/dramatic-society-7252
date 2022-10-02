package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import com.masai.bean.Admin;
import com.masai.bean.Bus;
import com.masai.bean.Customer;
import com.masai.bean.Ticket;
import com.masai.exception.AdminException;
import com.masai.exception.BusException;
import com.masai.exception.Customerexception;
import com.masai.utility.DBUtil;
import com.mysql.cj.protocol.Resultset;

public class BusTicketingDaoImpl implements BusTicketingDao {

	@Override
	public String registerAdministrator(int aid, String aname, String aemail, String apassword) {
		
		String message =  "Not inserted";
	
		try(Connection conn =  DBUtil.provideConnection()){
			
	PreparedStatement ps = conn.prepareStatement("insert into admin values(?, ?, ?, ?)");
			
			ps.setInt(1, aid);
			ps.setString(2, aname);
			ps.setString(3, aemail);
			ps.setString(4, apassword);
			
			int x =  ps.executeUpdate();
			if(x> 0) {
				message = "Admin inserted successfully !";
			}
			
		}catch(SQLException e) {
			
			message = e.getMessage();
			
		}
	
		return message;
		
	}

	@Override
	public String registerCustomer(Customer customer) {
      String message =  "Not inserted";
		
		try(Connection conn =  DBUtil.provideConnection()){
			
	PreparedStatement ps = conn.prepareStatement("insert into customer values(?,?,?,?,?,?)");
			
			ps.setInt(1, customer.getCid());
			ps.setString(2, customer.getCname());
			ps.setInt(3, customer.getCage());
			ps.setString(4, customer.getCgender());
			ps.setString(5, customer.getCmobile());
			ps.setString(6, customer.getCpassword());
			
			int x =  ps.executeUpdate();
			if(x> 0) {
				message = "Customer inserted successfully !";
			}
			
		}catch(SQLException e) {
			
			message = e.getMessage();
			
		}
	
		return message;
	}

	@Override
	public String registerBus(Bus bus) {
		 String message =  "Not inserted";
			
			try(Connection conn =  DBUtil.provideConnection()){
				
		PreparedStatement ps = conn.prepareStatement("insert into bus values(?,?,?,?,?,?,?,?,?)");
				
				ps.setInt(1, bus.getBid());
				ps.setString(2, bus.getBname());
				ps.setString(3, bus.getBsource());
				ps.setString(4, bus.getBdestination());
				ps.setInt(5, bus.getBseatAvailable());
				ps.setInt(6, bus.getBfare());
				ps.setString(7, bus.getBcontactperson());
				ps.setString(8, bus.getBmobileno());
				ps.setString(9, bus.getBustype());
				
				
				int x =  ps.executeUpdate();
				if(x> 0) {
					message = "Bus details inserted successfully !";
				}
				
			}catch(SQLException e) {
				
				message = e.getMessage();
				
			}
		
			return message;
	}

	@Override
	public String registerForTicketBus(Ticket ticket) {
		
		 String message =  "Ticket Not registerd";
			
			try(Connection conn =  DBUtil.provideConnection()){
				
		PreparedStatement ps = conn.prepareStatement("insert into ticket values(?,?,?)");
				
				ps.setInt(1, ticket.getTcid());
				ps.setInt(2, ticket.getTid());
				ps.setInt(3, ticket.getTbid());
				
				
				
				int x =  ps.executeUpdate();
				if(x> 0) {
					message = "Ticket registerd successfully !";
				}
				
			}catch(SQLException e) {
				
				message = e.getMessage();
				
			}
		
			return message;
		
	}

	@Override
	public Bus getBusDetailsBybusId(int bid) throws BusException {
		
		Bus bus = null;
		
		try(Connection conn = DBUtil.provideConnection()){
			
		PreparedStatement ps = conn.prepareStatement("select b.bid, b.bname, b.bsource, b.bdestination,b.bseatavailable, b.bfare, b.bcontactperson,b.bconatctperson_mobileno, b.bustype from bus b inner join admin a on b.bid = a.aid and  a.aid = ?");
			
		ps.setInt(1, bid);
	    ResultSet rs = ps.executeQuery();
	    if(rs.next()) {
	    	
	    	int id = rs.getInt("b.bid");
	    	String n = rs.getString("b.bname");
	    	String s = rs.getString("b.bsource");
	    	String d = rs.getString("b.bdestination");
	    	int a = rs.getInt("b.bseatavailable");
	    	int f = rs.getInt("b.bfare");
	    	String c = rs.getString("b.bcontactperson");
	    	String m = rs.getString("b.bconatctperson_mobileno");
	    	String t = rs.getString("b.bustype");
	    	
	     	bus = new Bus(id, n, s, d, a, f, c, m, t);
	     		
	    }
	    else {
	    	throw new BusException("Bus with this " + bid + " admin id does not exist");
	    }
				
		}catch(SQLException e) {
			e.printStackTrace();
			
			throw new BusException(e.getMessage());
		}catch(InputMismatchException ime) {
			ime.getMessage();
		}
		
	
		return bus;
	}

	@Override
	public Admin loginAdmin(String username, String password) throws AdminException{
		
		Admin admin = null;
		
		try(Connection conn = DBUtil.provideConnection()){
			
		PreparedStatement ps = conn.prepareStatement("select * from admin where aemail = ? and apassword = ?");
			
		ps.setString(1, username);
		ps.setString(2, password);
		
	 ResultSet rs =	ps.executeQuery();
	 
	 if(rs.next()) {
		 
		 int id = rs.getInt("aid");
		 String n = rs.getString("aname");
		 String e = rs.getString("aemail");
		 String p = rs.getString("apassword");
		 
		 admin = new Admin(id, n, e, p);
		 
		 
	 }else {
		 throw new AdminException("Invalid username and password");
	 }
			
			
		}catch(SQLException e){
			
			throw new AdminException(e.getMessage());
			
		}
		return admin;
	}

	@Override
	public List<Bus> getAllBusDetails() throws BusException {
		
		List<Bus> bus = new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from bus b");
			
		ResultSet rs =	ps.executeQuery();
		
		while(rs.next()) {
			
	    	int id = rs.getInt("b.bid");
	    	String n = rs.getString("b.bname");
	    	String s = rs.getString("b.bsource");
	    	String d = rs.getString("b.bdestination");
	    	int a = rs.getInt("b.bseatavailable");
	    	int f = rs.getInt("b.bfare");
	    	String c = rs.getString("b.bcontactperson");
	    	String m = rs.getString("b.bconatctperson_mobileno");
	    	String t = rs.getString("b.bustype");
			
	    Bus	buses = new Bus(id, n, s, d, a, f, c, m, t);
	    bus.add(buses);
	    
		}
			
		}catch(SQLException e) {
			throw new BusException(e.getMessage());
		}
		if(bus.size() == 0) {
			throw new BusException("No bus found");
		}
		
		return bus;
		
	}

	@Override
	public String ticketBookedByCustomer(int Tcid, int Tbid, int Tbooked) throws BusException, Customerexception {
		
		String message = "Ticked Not booked by the " + Tcid + " customer";
		
		try(Connection conn = DBUtil.provideConnection()){
		PreparedStatement ps=	conn.prepareStatement("select * from customer where cid = ?");
			
			ps.setInt(1, Tcid);
			
	     ResultSet rs =	ps.executeQuery();
	     if(rs.next()) {
	  PreparedStatement ps2= conn.prepareStatement("select * from bus where bid = ?"); 
	  ps2.setInt(1, Tbid);  	
	  
	 ResultSet rs2 = ps2.executeQuery();
	 if(rs2.next()) {
		 
	PreparedStatement ps3 = conn.prepareStatement("insert into ticket(Tcid, Tbid, Tbooked)values(?, ?, ?)");
		 
		 ps3.setInt(1, Tcid);
		 ps3.setInt(2, Tbid);
		 ps3.setInt(3, Tbooked);
		 
		int x = ps3.executeUpdate();
		
		if(x>0) {
			message = Tbooked + " Ticket has been booked by customer id " + Tcid + " and  " + " Bus id is " + Tbid; 
		}else {
			throw new BusException("Technical error..");
		}
		
	 }else {
		 throw new BusException("The bus with this id " + Tbid + " not found");
	 }
	  
	     }else {
	    	 
	    	 throw new Customerexception("Customer with this " + Tcid + " does not exist");
	    	 
	     }
			
		}catch(SQLException e) {
			throw new BusException(e.getMessage());
			
		}
		
		return message;
	}

	@Override
	public String AvailableTicketsafterbooking(int bookedticket, int bid) {
	
		String message = "Ticket not booked";
		
		try(Connection conn = DBUtil.provideConnection()){
			
		PreparedStatement ps =	conn.prepareStatement("  update bus b set b.bseatavailable = b.bseatavailable -? where b.bid = ? and b.bseatavailable > 0");
			
		ps.setInt(1, bookedticket);
		ps.setInt(2, bid);
		
		int x = ps.executeUpdate();
		if(x> 0) {
			
			message = bookedticket + " ticket has been booked by the customer ";
			
			
		}	
		}catch(SQLException e) {
			message = e.getMessage();
		}
		return message;
		
	}

	@Override
	public String deleteTheTicket(int Tcid, int Tbid) {
		
		String message = "No ticket available with customer having id " + Tcid + " and bus no " + Tbid;  
		
		
		try(Connection conn = DBUtil.provideConnection()){
			
	PreparedStatement ps =	conn.prepareStatement("delete from ticket where tcid = ? and tbid = ?");
	
	ps.setInt(1, Tcid);
	ps.setInt(2, Tbid);
	
	
		int x =	ps.executeUpdate();
			if(x> 0) {
				message = "Ticket cancled sucessfully";
			}
			
		}catch(SQLException e) {
			message = e.getMessage();
		}
		
		return message;
	}

	@Override
	public void getTheTicketDetails(int tcid) {
	
		
		try(Connection conn = DBUtil.provideConnection()){
			
		PreparedStatement ps = conn.prepareStatement(" select t.tcid ,c.cname,c.cage, c.cgender,c.cmobile,t.tbid,t.tid, b.bsource, b.bdestination, b.bfare,b.bcontactperson, b.bconatctperson_mobileno, b.bustype from ticket t inner join bus b inner join customer c on t.tcid = c.cid and t.tbid = b.bid where t.tcid = ?");
			
		boolean flag = false;
		ps.setInt(1, tcid);
	    ResultSet rs = ps.executeQuery();
	    while(rs.next()) {
	    	flag = true;

			System.out.println("The ticket details is ");
			System.out.println("========================================================");
	    	
	    	int id = rs.getInt("t.tcid");
	    	String n = rs.getString("c.cname");
	    	int a = rs.getInt("c.cage");
	    	String g = rs.getString("c.cgender");
	    	String m = rs.getString("c.cmobile");
	    	int b = rs.getInt("t.tbid");
	    	int t = rs.getInt("t.tid");
	    	String s = rs.getString("b.bsource");
	    	String d = rs.getString("b.bdestination");
	    	int f = rs.getInt("b.bfare");
	    	String c = rs.getString("b.bcontactperson");
	    	String cm = rs.getString("b.bconatctperson_mobileno");
	    	String bt = rs.getString("b.bustype");
	    	
	    	System.out.println("Customer id is : " + id);
	    	System.out.println("Customer name is : " + n);
	    	System.out.println("Customer age is : " + a);
	    	System.out.println("Customer gender is : " + g);
	    	System.out.println("Customer mobile is : " + m);
	    	System.out.println("Bus no is " + b);
	    	System.out.println("Ticket number is : " + t);
	    	System.out.println("Bus source is : " + s);
	    	System.out.println("Bus destination is : " + d);
	    	System.out.println("Bus fare is : " + f);
	    	System.out.println("Bus contact person is : " + c);
	    	System.out.println("Bus contact person mobile no is : " + cm);
	    	System.out.println("Bus type is : " + bt);
	    	
	    }
	    if(flag == false) {
	    	System.out.println("Ticket details is not available");
	    }
	    
	    
	    
	  	
		}catch(SQLException e) {
			e.getMessage();
		}	
		
		
	}
	
}
