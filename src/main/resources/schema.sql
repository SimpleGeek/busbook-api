drop table if exists routes;
create table routes(
	route_id serial primary key,
	bus_num integer
);

drop table if exists stops;
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

drop table if exists riders;
create table riders(
	rider_id serial primary key,
	fname varchar (200),
	lname varchar (200),
	birthday date,
	stop_id integer references stops(stop_id)
);