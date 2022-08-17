
DROP DATABASE PARCIAL;
CREATE DATABASE parcial;
use parcial;

CREATE TABLE IF NOT EXISTS Cliente
(
    cliente_id   INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    apellido VARCHAR(255),
    dni     VARCHAR(255),
    correo VARCHAR(255),
    nombre_usuario VARCHAR(255),
    contrasenia VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS Billetera
(
    billetera_id   INT NOT NULL AUTO_INCREMENT PRIMARY KEY
);


CREATE TABLE IF NOT EXISTS CriptoMoneda
(
    cripto_moneda_id   INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    cripto_moneda_nombre varchar(255),
    cripto_precio_unitario integer
);

CREATE TABLE IF NOT EXISTS Transaccion
(
    transaccion_id   INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    fechaTransaccion varchar(255),
    cripto_precio_unitario integer,
    cripto_cantidad integer,
    billeteraOrigen  INT NOT NULL,
    billeteraDestino INT NOT NULL,
    foreign key(billeteraOrigen) references Billetera (billetera_id),
    foreign key(billeteraDestino) references Billetera (billetera_id)
);

CREATE TABLE IF NOT EXISTS Oferta
(
    oferta_id   INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    cripto_cantidad integer,
    precio_unidad integer,
    billeteraVendedor integer,
    foreign key(billeteraVendedor) references Billetera (billetera_id)
);

CREATE TABLE IF NOT EXISTS IngresoDeDinero
(
    ingreso_dinero_id   INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    numero_tarjeta integer,
    titular_tarjeta integer,
    fechaInicio varchar(255),
    fechaVencimiento varchar(255),
    cbu varchar(255),
    nombreBanco varchar(255)
);

CREATE TABLE IF NOT EXISTS ClienteFormaDeIngresarDinero
(
	cliente_ingreso_dinero_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	cliente_id INT NOT NULL,
    ingreso_dinero_id INT NOT NULL,
    foreign key(cliente_id) references Cliente (cliente_id),
    foreign key(ingreso_dinero_id) references IngresoDeDinero (ingreso_dinero_id)
);



