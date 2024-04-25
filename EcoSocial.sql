DROP DATABASE IF EXISTS red_social;
CREATE DATABASE IF NOT EXISTS red_social;
USE red_social;

CREATE TABLE IF NOT EXISTS wins(
	id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(100),
    rewards_points DOUBLE
);

CREATE TABLE IF NOT EXISTS rewards(
	id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(100),
    price_points DOUBLE
);

CREATE TABLE IF NOT EXISTS user(
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(100),
    password VARCHAR(100),
    email VARCHAR(100),
    points DOUBLE,
    id_wins INT,
    id_reward INT,
    FOREIGN KEY (id_wins) REFERENCES wins(id),
	FOREIGN KEY (id_reward) REFERENCES rewards(id)
);

CREATE TABLE IF NOT EXISTS profile(
	id INT PRIMARY KEY AUTO_INCREMENT,
    FOREIGN KEY (id) REFERENCES user(id),
    name VARCHAR(100),
    lastname VARCHAR(100)
);







