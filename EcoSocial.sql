DROP DATABASE IF EXISTS red_social;
CREATE DATABASE IF NOT EXISTS red_social;
USE red_social;

<<<<<<< HEAD
CREATE TABLE IF NOT EXISTS objetivos(
	id INT PRIMARY KEY AUTO_INCREMENT,
	nombre VARCHAR(45),
    puntos_premio DOUBLE
);

CREATE TABLE IF NOT EXISTS recompensas(
	id INT PRIMARY KEY AUTO_INCREMENT,
	nombre VARCHAR(45),
    puntos_precio DOUBLE
);

CREATE TABLE IF NOT EXISTS usuario(
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100),
    apellido1 VARCHAR(100),
    apellido2 VARCHAR(100),
    id_objetivo INT,
    id_recompensa INT,
    FOREIGN KEY (id_objetivo) REFERENCES objetivos(id),
	FOREIGN KEY (id_recompensa) REFERENCES recompensas(id)
);

CREATE TABLE IF NOT EXISTS perfil(
	id INT PRIMARY KEY AUTO_INCREMENT,
    FOREIGN KEY (id) REFERENCES usuario(id),
	nombre_usuario VARCHAR(100),
    contraseña VARCHAR(100),
    email VARCHAR(100),
    puntos DOUBLE
);


SELECT * FROM usuario;


=======
CREATE TABLE IF NOT EXISTS wins(
	id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(100),
    description TEXT,
    verified BOOLEAN,
    rewards_points DOUBLE
);

CREATE TABLE IF NOT EXISTS rewards(
	id INT PRIMARY KEY AUTO_INCREMENT,
    description TEXT,
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
    profile_image BLOB,
    name VARCHAR(100),
    lastname VARCHAR(100)
);


>>>>>>> 87862e07c20de3267fcd345b72d0553dd90d1b82





