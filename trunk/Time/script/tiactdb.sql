CREATE TABLE user(
	id VARCHAR(36) NOT NULL PRIMARY KEY,
	username VARCHAR(32) NOT NULL,
	password VARCHAR(32) NOT NULL)

CREATE TABLE event(
	id VARCHAR(36) NOT NULL PRIMARY KEY,
	time timestamp default 'now',
	event VARCHAR(32) NOT NULL,
	note VARCHAR(32) NOT NULL)