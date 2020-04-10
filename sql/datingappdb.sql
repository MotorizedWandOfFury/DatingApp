drop table if exists Users;

drop type if exists EthnicityOption;
drop type if exists GenderOption;
drop type if exists ReligionOption;
drop type if exists PoliticalOrientationOption;

create type EthnicityOption as enum('White', 'African American', 'East Asian', 'SE Asian', 'Mixed', 'Hispanic', 'Prefer not to say');
create type GenderOption as enum('Male', 'Female', 'Non-binary', 'Prefer not to say');
create type ReligionOption as enum('Christian', 'Muslim', 'Atheist/Agnostic', 'Spiritual/Non-Religious', 'Hindu');
create type PoliticalOrientationOption as enum('Leftist', 'Liberal', 'Centrist', 'Conservative');

create table Users (
id serial primary key,
user_name varchar(30) not null unique,
password varchar(50) not null,
first_name varchar(100) not null,
last_name varchar(100) not null,
birthday date not null,
height_inches integer not null,
religion ReligionOption not null,
gender GenderOption not null,
ethnicity EthnicityOption not null,
politicalOrientation PoliticalOrientationOption not null,
location point not null
);