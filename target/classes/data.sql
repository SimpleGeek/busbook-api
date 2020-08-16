insert into routes(bus_num)
values(25);

insert into stops(seq_num, street_addr, city, state_abbr, zip, apartment, building, door, route_id)
values(1, '1234 Nowhere Dr.', 'Winston-Salem', 'NC', '29999', null, null, null, 1);

insert into riders(fname, lname, birthday, stop_id)
values('Joe', 'Rider', current_date, 1);

insert into riders(fname, lname, birthday, stop_id)
values('Alice', 'Rider', current_date, 1);

insert into riders(fname, lname, birthday, stop_id)
values('Junior', 'Rider', current_date, 1);