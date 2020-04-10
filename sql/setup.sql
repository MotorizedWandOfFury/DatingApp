drop database if exists datingappdb;
create database datingappdb;

drop user if exists datingappdbuser;
create user datingappdbuser with password 'datingappdbuser';

grant all privileges on database datingappdb to datingappdbuser;
grant all privileges on all sequences in schema public to datingappdbuser;