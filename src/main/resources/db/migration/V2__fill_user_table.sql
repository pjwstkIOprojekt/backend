-- USERS
insert into test_db.medical_info
values (1, null, 1, null);
insert into test_db.user (id, band_code, birth_date, email, name, password, phone, salt, medical_info_id)
values (1, 'test_code', '2000-01-01', 'test@example.com', 'John Doe', sha('passwordsalt'), '123456789', 'salt', 1);
insert into test_db.medical_info
values (2, 'nuts', 1, null);
insert into test_db.user (id, band_code, birth_date, email, name, password, phone, salt, medical_info_id)
values (2, 'test_code', '1996-05-12', 'test2@example.com', 'Adam Kowalski', sha('passwordsalt'), '667776667', 'salt', 2);
insert into test_db.medical_info
values (3, 'milk', 2, 'asthma');
insert into test_db.user (id, band_code, birth_date, email, name, password, phone, salt, medical_info_id)
values (3, 'test_code', '2002-03-03', 'test3@example.com', 'Jakub Nowak', sha('passwordsalt'), '111222333', 'salt', 3);
insert into test_db.medical_info
values (4, null, 2, null);
insert into test_db.user (id, band_code, birth_date, email, name, password, phone, salt, medical_info_id)
values (4, 'test_code', '2000-01-10', 'test4@example.com', 'Alice Doe', sha('passwordsalt'), '333444555666', 'salt', 4);