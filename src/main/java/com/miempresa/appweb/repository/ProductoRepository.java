package com.miempresa.appweb.repository;

import com.miempresa.appweb.dtos.InventarioDetailsDTO;
import com.miempresa.appweb.dtos.InventarioGroupDTO;
import com.miempresa.appweb.model.Producto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    @Query(value = """
            SELECT p.id_producto as idProducto, p.nombre, coalesce(i.cantidad, 0) as cantidad, p.estatus
                FROM Producto p
                left JOIN (
                    SELECT id_producto, SUM(cantidad) AS cantidad
                    FROM inventario
                    GROUP BY id_producto
                ) i ON i.id_producto = p.id_producto
                order by p.estatus desc, p.nombre asc
            """, nativeQuery = true)
    List<InventarioGroupDTO> getGrupoInventario();

    @Query(value = """
            SELECT
                i.id_inventario AS idInventario,
                i.folio AS folio,
                i.cantidad AS cantidad,
                p.nombre AS nombre
            FROM inventario i
            JOIN Producto p ON p.id_producto = i.id_producto
            WHERE i.cantidad > 0 AND i.id_producto = :idProducto
            """, nativeQuery = true)
    List<InventarioDetailsDTO> getInventarioDetails(@Param("idProducto") int idProducto);
}