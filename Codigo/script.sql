

CREATE DATABASE parcial;
use parcial;

CREATE TABLE IF NOT EXISTS Clientes
(
    cliente_id   INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    apellido VARCHAR(255),
    dni     VARCHAR(255),
    fecha_nacimiento  VARCHAR(255),
    correo VARCHAR(255),
    nombre_usuario VARCHAR(255),
    contrasenia VARCHAR(255),
    cuenta_bancaria VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS BilleterasVirtuales
(
    billetera_id   INT NOT NULL AUTO_INCREMENT PRIMARY KEY
);


CREATE TABLE IF NOT EXISTS CriptosMonedas
(
    cripto_moneda_id   INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    cripto_moneda_nombre varchar(255),
    cripto_precio_unitario integer
);
