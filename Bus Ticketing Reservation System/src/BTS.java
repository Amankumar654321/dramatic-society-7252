import java.util.List;
import java.util.Scanner;

import com.masai.bean.Admin;
import com.masai.bean.Bus;
import com.masai.bean.Customer;
import com.masai.dao.BusTicketingDao;
import com.masai.dao.BusTicketingDaoImpl;
import com.masai.exception.AdminException;
import com.masai.exception.BusException;
import com.masai.exception.Customerexception;

public class BTS {

	private static Scanner sc = new Scanner(System.in);
	private  static BusTicketingDao dao =  new BusTicketingDaoImpl();
	

	public static void selectOption() {
		
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("Choose the options to continue-\n"
				+ "1 For customer\n"
				+ "2 For  Admin panel  registration\n"
				+ "3 For Admin panel details \n"
				+ "4 To register the bus details\n"
				+ "5 Get all the  bus details\n"
				+ "6 Get the bus details under the admin by admin id\n"
				+ "7 Registration by customer for ticket\n"
				+ "8 Get the ticket details\n"
				+ "9 Update the ticket on entering the same no of ticket you have booked \n"
				+ "10 Cancel the ticket \n"
				+ "11 For Exit");
		System.out.println("================================*============================================================================");
		int choice = sc.nextInt();
		switch(choice) {
		
		case 1: 
			System.out.println("Welcome to customer panel");
			while(true) {
			System.out.println("Want to register for customer yes or no");
			String ch = sc.next();
				if(ch.equalsIgnoreCase("yes")) {

					System.out.println("Enter the  customer id:");
					int cid = sc.nextInt();
					System.out.println("Enter the  customer name:");
				    String cname = sc.next();
					System.out.println("Enter the  customer age:");
					int cage = sc.nextInt();
					System.out.println("Enter the  customer gender:");
					String cgender = sc.next();
					System.out.println("Enter the  customer mobile:");
					String cmobile = sc.next();
					System.out.println("Enter the  customer password:");
					String cpassword = sc.next();
				
				
					Customer customer = new Customer();
					
					customer.setCid(cid);
					customer.setCname(cname);
					customer.setCage(cage);
					customer.setCgender(cgender);
					customer.setCmobile(cmobile);
					customer.setCpassword(cpassword);
					
					String result = dao.registerCustomer(customer);
					System.out.println(result);
					
				}else {
					break;
				}
			}
			BTS.selectOption();
			break;
		case 2:
			System.out.println("Enter the Admin id");
			int id = BTS.sc.nextInt();
			System.out.println("Enter the Admin name");
			String name = BTS.sc.next();
			System.out.println("Enter the Admin email");
			String email = BTS.sc.next();
			System.out.println("Enter the Admin password");
			String password = BTS.sc.next();
			
		
				
			String result = BTS.dao.registerAdministrator(id, name, email, password);
			
			System.out.println(result);
			BTS.selectOption();
			break;
		case 3:
			
			System.out.println("Welcome to admin panel");
			System.out.println("Admin Login");
			System.out.println("Enter the username");
			String uname = sc.next();
			System.out.println("Enter the password");
			String pass = sc.next();
		
			
			try {
				Admin admin = dao.loginAdmin(uname, pass);
				System.out.println("-----------------*-----------------------");
				System.out.println("Welcome " + admin.getAname());
				System.out.println("Your id is " + admin.getAid());
				
				
				
			} catch (AdminException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			BTS.selectOption();
			break;
			
		case 4:

			System.out.println("Enter the Bus id:");
			int bid = sc.nextInt();
			System.out.println("Enter the Bus name:");
			String bname = sc.next();
			System.out.println("Enter the Bus source:");
			String bsource = sc.next();
			System.out.println("Enter the Bus destination:");
			String bdestination = sc.next();
			System.out.println("Enter the Bus seatavailable:");
			int seatavailable = sc.nextInt();
			System.out.println("Enter the Bus fare:");
			int bfare = sc.nextInt();
			System.out.println("Enter the Bus contact person:");
			String bcontactperson = sc.next();
			System.out.println("Enter the Bus contact person mobile no:");
			String contactno = sc.next();
			System.out.println("Enter the Bus type:");
			String btype = sc.next();
			
		
			Bus bus = new Bus();
			
			bus.setBid(bid);
			bus.setBname(bname);
			bus.setBsource(bsource);
			bus.setBdestination(bdestination);
			bus.setBseatAvailable(seatavailable);
			bus.setBfare(bfare);
			bus.setBcontactperson(bcontactperson);
			bus.setBmobileno(contactno);
			bus.setBustype(btype);
			
			String result1= dao.registerBus(bus);
			System.out.println(result1);
			BTS.selectOption();
			break;
		case 5:

			try {
			List<Bus> bus1 =	dao.getAllBusDetails();
			
			bus1.forEach(b -> {
				
				System.out.println("The bus id is : "+b.getBid());
		    	System.out.println("The bus name is : " + b.getBname());
		    	System.out.println("The bus source is : " +b.getBsource());
		    	System.out.println("The bus destination is : " +b.getBdestination() );
		    	System.out.println("The bus seats available are : "+ b.getBseatAvailable());
		    	System.out.println("The bus fare is : "+ b.getBfare());
		     	System.out.println("The bus contact person is : " +b.getBcontactperson() );
		     	System.out.println("The bus person mobile no is : " +b.getBmobileno() );
		     	System.out.println("The bus type is : " + b.getBustype());
				
				System.out.println("--------------*-----------------------------");
			
				
			});
				
			} catch (BusException e) {
				System.out.println(e.getMessage());
			}
			BTS.selectOption();
			break;
			
		case 6:
			System.out.println("Enter the Admin id to get the details of buses under him: ");
			int id1 = sc.nextInt();
			
			BusTicketingDao dao = new BusTicketingDaoImpl();
			
			Bus bus2;
			try {
				bus2 = dao.getBusDetailsBybusId(id1);
				
					System.out.println("The bus id is : "+bus2.getBid());
			    	System.out.println("The bus name is : " + bus2.getBname());
			    	System.out.println("The bus source is : " +bus2.getBsource());
			    	System.out.println("The bus destination is : " +bus2.getBdestination() );
			    	System.out.println("The bus seats available are : "+ bus2.getBseatAvailable());
			    	System.out.println("The bus fare is : "+ bus2.getBfare());
			     	System.out.println("The bus contact person is : " +bus2.getBcontactperson() );
			     	System.out.println("The bus person mobile no is : " +bus2.getBmobileno() );
			     	System.out.println("The bus type is : " + bus2.getBustype());
					
					System.out.println("--------------*-----------------------------");
				
				
			} catch (BusException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		BTS.selectOption();
		break;
		
		case 7:

			System.out.println("Want to book  tickets");
			
			while(true) {
				System.out.println("choose yes or no");
				String choose = sc.next();
				if(choose.equalsIgnoreCase("yes")) {
					System.out.println("Enter the your customer id");
					int cid = sc.nextInt();
					
					System.out.println("Enter the bus id in which you want to book");
					
					int bid3 = sc.nextInt();
					
					System.out.println("The number of ticket u want to book");
					int tbook = sc.nextInt();
				
					try {
						String result6 = BTS.dao.ticketBookedByCustomer(cid, bid3, tbook);
						
						System.out.println(result6);
						
						
					} catch (BusException | Customerexception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				}
				
				if(choose.equalsIgnoreCase("no")) {
					break;
				}
				
			}
			BTS.selectOption();
			break;
		case 8:
			System.out.println("Enter the customer id");
			int id9 = sc.nextInt();
			 BTS.dao.getTheTicketDetails(id9);
		     BTS.selectOption();
		     break;
			
		case 9:
		     System.out.println("Enter the number of ticket you want to book");
		     int bookedticket = sc.nextInt();
		     System.out.println("Enter the bus id");
		     int bid1 = sc.nextInt();
		     
		     String result4 = BTS.dao.AvailableTicketsafterbooking(bookedticket, bid1);
				
		     System.out.println(result4);
		     
		     BTS.selectOption();
		     break;
		  
		case 10:
			   
						System.out.println("Enter the customer id");
						int cid = sc.nextInt();
						System.out.println("Enter the bus id");
						int bid2 = sc.nextInt();
						
							String result5 = BTS.dao.deleteTheTicket(cid, bid2);
							
							System.out.println(result5);
							
							BTS.selectOption();
							break;
							
							
		case 11:
			break;
			
		}
		
		
	}
	
	
	
}
