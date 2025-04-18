--create database miempresa;

use miempresa;

CREATE TABLE Rol (
    id_Rol INT IDENTITY(1,1) PRIMARY KEY,
    nombre NCHAR(20) NOT NULL
);

CREATE TABLE Usuario (
    id_Usuario INT IDENTITY(1,1) PRIMARY KEY,
    nombre NCHAR(100) NOT NULL,
    correo NCHAR(50) NOT NULL,
    contrasena NCHAR(25) NOT NULL,
    id_Rol INT NOT NULL,
    FOREIGN KEY (id_Rol) REFERENCES Rol(id_Rol)
);

CREATE TABLE Producto (
    id_Producto INT IDENTITY(1,1) PRIMARY KEY,
    nombre NCHAR(50) NOT NULL,
    Precio FLOAT NOT NULL,
    estatus TINYINT NOT NULL
);

CREATE TABLE Inventario (
    id_Inventario INT IDENTITY(1,1) PRIMARY KEY,
    folio NCHAR(15) NOT NULL,
    cantidad INT NOT NULL,
    id_Producto INT NOT NULL,
    FOREIGN KEY (id_Producto) REFERENCES Producto(id_Producto)
);

CREATE TABLE Movimiento (
    id_Movimiento INT IDENTITY(1,1) PRIMARY KEY ,
    fecha DATETIME NOT NULL,
    accion NCHAR(20) NOT NULL,
    id_Usuario INT NOT NULL,
    id_Inventario INT NOT NULL,
    FOREIGN KEY (id_Usuario) REFERENCES Usuario(id_Usuario),
    FOREIGN KEY (id_Inventario) REFERENCES Inventario(id_Inventario)
);

insert into rol 
(NOMBRE)
	values 
		('ADMINISTRADOR'), 
		('ALMACENISTA');

INSERT INTO Usuario
(NOMBRE, CORREO, CONTRASENA, ID_ROL)
	VALUES 
		('admin', 'admin@mail.com', '1234', 1),
		('almac', 'almac@mail.com', '1234', 2);

insert into producto
(NOMBRE, PRECIO, ESTATUS)
	values 
		('PAPEL', 300, 1),
		('CARTÓN', 300, 1),
		('METAL', 300, 1),
		('PLÁSTICO', 300, 1),
		('new Paper', 300, 0);
			
select * from inventario;
select * from movimiento;
select * from Usuario;
select * from rol;
select * from producto

select CAST(m.fecha AS DATE) as fecha, CAST(m.fecha AS TIME) as hora, u.nombre, m.accion
	from movimiento m
	join usuario u on u.id_usuario = m.id_usuario;

SELECT i.id_inventario AS idInventario, i.folio AS folio, i.cantidad AS cantidad, p.nombre AS nombre
	FROM inventario i
	JOIN Producto p ON p.id_producto = i.id_producto;

SELECT p.id_producto, p.nombre, coalesce(i.cantidad, 0) as cantidad
	FROM Producto p
	left JOIN (
		SELECT id_producto, SUM(cantidad) AS cantidad
			FROM inventario
			GROUP BY id_producto
	) i ON i.id_producto = p.id_producto
	order by p.estatus, p.nombre asc;