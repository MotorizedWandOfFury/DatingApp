truncate Users restart identity;
insert into Users(user_name, password, first_name, last_name, birthday, height_inches, gender, ethnicity, religion, politicalOrientation, location)
values
('test_user_id_1', 'abcdef', 'Test', 'User1', '1991-03-12', 58, 'Non-binary', 'African American', 'Atheist/Agnostic', 'Leftist', Point(0.0,0.0))