-- person table
insert into person (id, name, first_name) values (1, 'Muster', 'Hans');
insert into person (id, name, first_name) values (2, 'Meier', 'Peter');
insert into person (id, name, first_name) values (3, 'Yuma', 'Bruggmann');
-- user table
insert into user (id, login, administrator, person_id) values (1, 'loginMusterHans', TRUE, 1);
insert into user (id, login, administrator, person_id) values (2, 'loginMeierPeter', FALSE, 2);