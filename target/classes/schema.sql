drop table if exists routes cascade;
create table routes(
	route_id serial primary key,
	bus_num integer
);

drop table if exists stops cascade;
create table stops(
	stop_id serial primary key,
	seq_num integer,
	street_addr varchar (250),
	city varchar (250),
	state_abbr varchar (2),
	zip varchar (10),
	apartment varchar (250),
	building varchar (50),
	door varchar (20),
	route_id integer references routes(route_id)
);

drop table if exists riders cascade;
create table riders(
	rider_id serial primary key,
	fname varchar (200),
	lname varchar (200),
	birthday date,
	stop_id integer references stops(stop_id)
);

drop table if exists users cascade;
create table users(
	user_id serial primary key,
	fname varchar (200),
	lname varchar (200),
	email varchar (350),
	phone varchar (12),
	username varchar (250),
	password varchar (250),
	salt varchar (250),
	route_id integer references routes(route_id)
);

drop table if exists attendance_records;
create table attendance_records(
	attendance_rec_id serial primary key,
	attendance_dt date,
	rider_id integer references riders(rider_id)
);