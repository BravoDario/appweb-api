package com.miempresa.appweb;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public CommandLineRunner testConexion() {
        return args -> {
            try {
                System.out.println("****************************************************************:");
                System.out.println("Conexión exitosa. Productos encontrados:");
                /* 
                // test login
                Usuario usuario = us.iniciarSesion("admin@mail.com", "1234");
                System.out.println(usuario.getNombre());
                // test productos agrupados
                List<InventarioGroupDTO> inventarioGrupo = ps.obtenerGrupoInventario();
                for (InventarioGroupDTO ig : inventarioGrupo) {
                    System.out.println(ig.getNombre() + ": " + ig.getCantidad());
                }
                // test productos detalles
                List<InventarioDetailsDTO> inventario = ps.obtenerInventario(1);
                for (InventarioDetailsDTO id : inventario) {
                    System.out.println(id.getNombre() + ": " + id.getCantidad());
                }
                // test registrar inventario
                Producto newProducto = new Producto();
                newProducto.setNombre("Nuevo producto");
                newProducto.setPrecio(100.0);
                newProducto.setEstatus((byte) 1);
                newProducto = ps.guardar(newProducto);
                System.out.println(
                        "Producto guardado: " + newProducto.getNombre() + " con id: " + newProducto.getIdProducto());

                // test actualizar producto
                newProducto.setNombre("Nuevo producto actualizado");
                Producto actualizadoProducto = ps.actualizar(newProducto);
                System.out.println("Producto actualizado: " + actualizadoProducto.getNombre());

                // Test eliminar inventario
                System.out.println("Eliminando inventario...");
                List<Producto> productos = ps.obtenerTodos();
                for (Producto ig : productos) {
                    System.out.println(ig.getNombre() + ": " + ig.getEstatus());
                }
                newProducto.setEstatus((byte) 0);
                ps.actualizar(newProducto);
                productos = ps.obtenerTodos();
                for (Producto ig : productos) {
                    System.out.println(ig.getNombre() + ": " + ig.getEstatus());
                }
                inventarioGrupo = ps.obtenerGrupoInventario();
                for (InventarioGroupDTO ig : inventarioGrupo) {
                    System.out.println(ig.getNombre() + ": " + ig.getCantidad());
                } 

                // test registrar inventario
                Inventario newInventario = ps.registrarInventario(
                        newProducto.getIdProducto(), usuario.getIdUsuario(), 10);
                System.out.println("Inventario registrado: " + newInventario.getIdInventario() + " con folio: "
                        + newInventario.getFolio());

                inventarioGrupo = ps.obtenerGrupoInventario();
                for (InventarioGroupDTO ig : inventarioGrupo) {
                    System.out.println(ig.getNombre() + ": " + ig.getCantidad());
                }

                // test eliminar inventario
                System.out.println("Eliminando inventario...");
                newInventario = ps.eliminarInventario(newInventario.getIdInventario(), usuario.getIdUsuario(), 5);
                inventarioGrupo = ps.obtenerGrupoInventario();
                for (InventarioGroupDTO ig : inventarioGrupo) {
                    System.out.println(ig.getNombre() + ": " + ig.getCantidad());
                }
                 */
 
                System.out.println("****************************************************************:");
            } catch (Exception e) {
                System.err.println("Error al insertar movimiento: " + e.getMessage());
            }
        };
    }
}