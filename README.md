# dramatic-society-7252
Bus_Ticketing_Reservation_System
# Tables that i have used in this application-

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





