--create database consultas;
use consultas;

CREATE TABLE Productos (
    idProducto INT PRIMARY KEY,
    nombre VARCHAR(50),
    precio DECIMAL(10,2)
);

INSERT INTO Productos (idProducto, nombre, precio)
VALUES
(1, 'LAPTOP', 3000.00),
(2, 'PC', 4000.00),
(3, 'MOUSE', 100.00),
(4, 'TECLADO', 150.00),
(5, 'MONITOR', 2000.00),
(6, 'MICROFONO', 350.00),
(7, 'AUDIFONOS', 450.00);

CREATE TABLE Pedidos (
    idVenta INT PRIMARY KEY,
    idProducto INT,
    cantidad INT
);

INSERT INTO Pedidos (idVenta, idProducto, cantidad)
VALUES
(1, 5, 8),
(2, 1, 15),
(3, 6, 13),
(4, 6, 4),
(5, 2, 1),
(6, 5, 1),
(7, 4, 5),
(8, 4, 5),
(9, 6, 2),
(10, 1, 8);

-- productos con ventas
select idproducto, nombre 
	from productos p 
	where p.idproducto in (select idproducto from pedidos);

-- productos que tengan ventas y la cantidad total de productos vendidos
select p.nombre, sum(pd.cantidad) as productosVendidos 
	from productos p 
	join Pedidos pd on pd.idProducto = p.idProducto
	group by p.nombre;

-- productos y la suma total vendida por producto
select p.nombre, coalesce(sum(p.precio * pd.cantidad), 0) as total 
	from productos p 
	left join Pedidos pd on pd.idProducto = p.idProducto
	group by p.nombre, p.precio;

select* from Productos;