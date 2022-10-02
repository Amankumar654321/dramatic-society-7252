# Project Code- dramatic-society-7252


Project Name - Bus_Ticketing_Reservation_System
==============================================

# Tables that I have used in this application-

create table Customer(
cid int primary key,
cname varchar(20),
cage int,
cgender varchar(20),
cmobile varchar(20),
cpassword varchar(20)
);


create table Admin(
Aid int primary key,
Aname varchar(20),
Aemail varchar(20),
Apassword varchar(20)
);

create table Bus(
bid int primary key,
bname varchar(20),
bsource varchar(20),
bdestination varchar(20),
bSeatAvailable int,
bfare int,
bcontactperson varchar(20), 
bconatctperson_mobileno varchar(20),
bustype varchar(20),
foreign key(bid) references Admin(Aid)
);

create table ticket(
tid int primary key auto_increment, 
Tcid int,
Tbid int, 
tbooked int,
foreign key (Tcid) references Customer(cid) on delete cascade,
foreign key(Tbid) references Bus(bid) on delete cascade
);


# The SQL server queries and answers- 

![image](https://user-images.githubusercontent.com/101914524/193448127-e5823021-0cae-4e8c-a88d-a63a6b05bc5f.png)

![image](https://user-images.githubusercontent.com/101914524/193448158-2722894c-974b-4f3f-ab53-c6bf84d0532f.png)

![image](https://user-images.githubusercontent.com/101914524/193448174-2c24afde-e5cc-4b44-8014-246f0445e781.png)

![image](https://user-images.githubusercontent.com/101914524/193448190-caf26aae-30ee-42d7-8261-eec8e3a56951.png)

![image](https://user-images.githubusercontent.com/101914524/193448211-957cec91-0649-4465-a349-90d33325179d.png)

![image](https://user-images.githubusercontent.com/101914524/193448227-f9f97a84-84ab-4bb5-a792-fa7475ab82da.png)

# Output of the Application in the client Side------>

Welcome to Bus Ticketing system
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

Choose the options to continue-
1 For customer

2 For  Admin panel  registration

3 For Admin panel details 

4 To register the bus details

5 Get all the  bus details

6 Get the bus details under the admin by admin id

7 Registration by customer for ticket

8 Get the ticket details

9 Update the ticket on entering the same no of ticket you have booked 

10 Cancel the ticket 

11 For Exit
================================*==============================

1

Welcome to customer panel

Want to register for customer yes or no
yes

Enter the  customer id:
105

Enter the  customer name:
akshay

Enter the  customer age:
25

Enter the  customer gender:
male

Enter the  customer mobile:
12365489

Enter the  customer password:
2536

Duplicate entry '105' for key 'customer.PRIMARY'

Want to register for customer yes or no
yes

Enter the  customer id:
115

Enter the  customer name:
akshay

Enter the  customer age:
25

Enter the  customer gender:
male

Enter the  customer mobile:
12569586

Enter the  customer password:
1236

Customer inserted successfully !
Want to register for customer yes or no
no
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++

Choose the options to continue-

1 For customer

2 For  Admin panel  registration

3 For Admin panel details 

4 To register the bus details

5 Get all the  bus details

6 Get the bus details under the admin by admin id

7 Registration by customer for ticket

8 Get the ticket details

9 Update the ticket on entering the same no of ticket you have booked 

10 Cancel the ticket 

11 For Exit
================================*========================

2
Enter the Admin id
119

Enter the Admin name
mohan

Enter the Admin email
mohan@gmail.com

Enter the Admin password
123

Admin inserted successfully !
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

Choose the options to continue-

1 For customer

2 For  Admin panel  registration

3 For Admin panel details 

4 To register the bus details

5 Get all the  bus details

6 Get the bus details under the admin by admin id

7 Registration by customer for ticket

8 Get the ticket details

9 Update the ticket on entering the same no of ticket you have booked 

10 Cancel the ticket 

11 For Exit
================================*=====================

3

Welcome to admin panel

Admin Login

Enter the username

mohan@gmail.com

Enter the password
123


-----------------*-----------------------

Welcome mohan
Your id is 119

++++++++++++++++++++++++++++++++++++++++++++++++++++++

Choose the options to continue-

1 For customer

2 For  Admin panel  registration

3 For Admin panel details 

4 To register the bus details

5 Get all the  bus details

6 Get the bus details under the admin by admin id

7 Registration by customer for ticket

8 Get the ticket details

9 Update the ticket on entering the same no of ticket you have booked 

10 Cancel the ticket 

11 For Exit

================================*==========================

4

Enter the Bus id:
119

Enter the Bus name:
StarBus

Enter the Bus source:
Tata

Enter the Bus destination:
mumbai

Enter the Bus seatavailable:
100

Enter the Bus fare:
2800

Enter the Bus contact person:
ranjan

Enter the Bus contact person mobile no:
123659452

Enter the Bus type:
Ac

Bus details inserted successfully !
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

Choose the options to continue-

1 For customer

2 For  Admin panel  registration

3 For Admin panel details 

4 To register the bus details

5 Get all the  bus details

6 Get the bus details under the admin by admin id

7 Registration by customer for ticket

8 Get the ticket details

9 Update the ticket on entering the same no of ticket you have booked 

10 Cancel the ticket 

11 For Exit

================================*==========================

5
The bus id is : 1

The bus name is : Volvo

The bus source is : Mumbai

The bus destination is : Delhi

The bus seats available are : 70

The bus fare is : 5000

The bus contact person is : Raju

The bus person mobile no is : 1234567896

The bus type is : AC

--------------*-----------------------------

The bus id is : 2

The bus name is : Sonipari

The bus source is : Delhi

The bus destination is : Mumbai

The bus seats available are : 160

The bus fare is : 6000

The bus contact person is : Raman

The bus person mobile no is : 123648596

The bus type is : AC

--------------*-----------------------------

The bus id is : 3

The bus name is : StarBus

The bus source is : kolkata

The bus destination is : Goa

The bus seats available are : 380

The bus fare is : 10000

The bus contact person is : Rajubutter

The bus person mobile no is : 2569854563

The bus type is : NON-AC

--------------*-----------------------------

The bus id is : 4

The bus name is : Tata

The bus source is : Goa

The bus destination is : Kolkata

The bus seats available are : 300

The bus fare is : 4000

The bus contact person is : Amresh

The bus person mobile no is : 263548965

The bus type is : No-Ac

--------------*-----------------------------

The bus id is : 5

The bus name is : VilashBus

The bus source is : Bihar

The bus destination is : Nepal

The bus seats available are : 600

The bus fare is : 9000

The bus contact person is : Ramesh

The bus person mobile no is : 256958745

The bus type is : Ac

--------------*-----------------------------

The bus id is : 6

The bus name is : saloni

The bus source is : patna

The bus destination is : mumbai

The bus seats available are : 60

The bus fare is : 8000

The bus contact person is : ramu

The bus person mobile no is : 25369584

The bus type is : Ac

--------------*-----------------------------

The bus id is : 115

The bus name is : SiligurBus

The bus source is : Mumbai

The bus destination is : Mahrashtra

The bus seats available are : 80

The bus fare is : 6000

The bus contact person is : Ramaya

The bus person mobile no is : 12346985

The bus type is : Non-Ac

--------------*-----------------------------

The bus id is : 116

The bus name is : volvo

The bus source is : odissa

The bus destination is : goa

The bus seats available are : 90

The bus fare is : 5000

The bus contact person is : raju

The bus person mobile no is : 12365489

The bus type is : Ac

--------------*-----------------------------

The bus id is : 119

The bus name is : StarBus

The bus source is : Tata

The bus destination is : mumbai

The bus seats available are : 100

The bus fare is : 2800

The bus contact person is : ranjan

The bus person mobile no is : 123659452

The bus type is : Ac

--------------*-----------------------------

++++++++++++++++++++++++++++++++++++++++++++++

Choose the options to continue-

1 For customer

2 For  Admin panel  registration

3 For Admin panel details 

4 To register the bus details

5 Get all the  bus details

6 Get the bus details under the admin by admin id

7 Registration by customer for ticket

8 Get the ticket details

9 Update the ticket on entering the same no of ticket you have booked 

10 Cancel the ticket 

11 For Exit

================================*==========================

6
Enter the Admin id to get the details of buses under him: 

119
The bus id is : 119

The bus name is : StarBus

The bus source is : Tata

The bus destination is : mumbai

The bus seats available are : 100

The bus fare is : 2800

The bus contact person is : ranjan

The bus person mobile no is : 123659452

The bus type is : Ac

--------------*-----------------------------

+++++++++++++++++++++++++++++++++++++++++++++++++

Choose the options to continue-

1 For customer

2 For  Admin panel  registration

3 For Admin panel details 

4 To register the bus details

5 Get all the  bus details

6 Get the bus details under the admin by admin id

7 Registration by customer for ticket

8 Get the ticket details

9 Update the ticket on entering the same no of ticket you have booked 

10 Cancel the ticket 

11 For Exit

================================*==============

7
Want to book  tickets

choose yes or no
yes

Enter the your customer id
115

Enter the bus id in which you want to book
119

The number of ticket u want to book
20

20 Ticket has been booked by customer id 115 and   Bus id is 119
choose yes or no

no
+++++++++++++++++++++++++++++++++++++++++++++++++

Choose the options to continue-

1 For customer

2 For  Admin panel  registration

3 For Admin panel details 

4 To register the bus details

5 Get all the  bus details

6 Get the bus details under the admin by admin id

7 Registration by customer for ticket

8 Get the ticket details

9 Update the ticket on entering the same no of ticket you have booked 

10 Cancel the ticket 

11 For Exit

================================*==========================

8
Enter the customer id

115
The ticket details is 

========================================================
Customer id is : 115

Customer name is : akshay

Customer age is : 25

Customer gender is : male

Customer mobile is : 12569586

Bus no is 119

Ticket number is : 9

Bus source is : Tata

Bus destination is : mumbai

Bus fare is : 2800

Bus contact person is : ranjan

Bus contact person mobile no is : 123659452

Bus type is : Ac
+++++++++++++++++++++++++++++++++++++++++++++++

Choose the options to continue-

1 For customer

2 For  Admin panel  registration

3 For Admin panel details 

4 To register the bus details

5 Get all the  bus details

6 Get the bus details under the admin by admin id

7 Registration by customer for ticket

8 Get the ticket details

9 Update the ticket on entering the same no of ticket you have booked 

10 Cancel the ticket 

11 For Exit

================================*==========================

9
Enter the number of ticket you want to book
20

Enter the bus id
119

20 ticket has been booked by the customer 

+++++++++++++++++++++++++++++++++++++++++++++++++++++

Choose the options to continue-

1 For customer

2 For  Admin panel  registration

3 For Admin panel details 

4 To register the bus details

5 Get all the  bus details

6 Get the bus details under the admin by admin id

7 Registration by customer for ticket

8 Get the ticket details

9 Update the ticket on entering the same no of ticket you have booked 

10 Cancel the ticket 

11 For Exit

================================*==========================

10
Enter the customer id
115

Enter the bus id
119

Ticket cancled sucessfully

++++++++++++++++++++++++++++++++++++++++++++++

Choose the options to continue-

1 For customer

2 For  Admin panel  registration

3 For Admin panel details 

4 To register the bus details

5 Get all the  bus details

6 Get the bus details under the admin by admin id

7 Registration by customer for ticket

8 Get the ticket details

9 Update the ticket on entering the same no of ticket you have booked 

10 Cancel the ticket 

11 For Exit

================================*==========================

11






