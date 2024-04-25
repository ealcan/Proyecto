DROP DATABASE IF EXISTS red_social;
CREATE DATABASE IF NOT EXISTS red_social;
USE red_social;

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







