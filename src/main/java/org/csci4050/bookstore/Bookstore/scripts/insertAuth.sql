USE bookstoreDB;

-- Example script that shows record insertions into the user and authorities tables.

insert into users(username,password,enabled)
	values('admin','pass',true);

insert into authorities(username,authority)
	values('admin','ROLE_ADMIN');