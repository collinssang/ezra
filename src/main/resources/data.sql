insert into status(id,status) values (1,'idle');
insert into status(id,status) values (2,'moving');
insert into status(id,status) values (3,'under maintenace');
insert into status(id,status) values (4,'occupied');

insert into floors(name) values (1);
insert into floors(name) values (0);
insert into floors(name) values (2);
insert into floors(name) values (3);
insert into floors(name) values (4);
insert into floors(name) values (5);
insert into floors(name) values (6);


insert into elevators(name,status, floor_no) values ('B',1,1);
insert into elevators(name,status, floor_no) values ('C',1,1);
insert into elevators(name,status, floor_no) values ('D',1,1);
insert into elevators(name,status, floor_no) values ('E',1,1);;