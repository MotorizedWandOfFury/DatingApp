truncate Users, Tokens restart identity;
insert into Users(user_name, password, first_name, last_name, birthday, height_inches, gender, ethnicity, religion, politicalOrientation, location)
values
('test_user_id_1', 'abcdef', 'Test', 'User1', '1991-03-12', 58, 'Non-binary', 'African American', 'Atheist/Agnostic', 'Leftist', Point(0.0,0.0));

insert into Tokens(token, user_id, expiration_date) values
('8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', 1, '2020-12-31');