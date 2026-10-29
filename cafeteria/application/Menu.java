package cafeteria.application;

import cafeteria.domain.Producto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Menu {

    private List<Producto> productos;

    public Menu() {
        productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        if (producto == null) {
            throw new IllegalArgumentException(
                "El producto no puede ser null."
            );
        }

        productos.add(producto);
    }

    public List<Producto> listarProductos() {
        return Collections.unmodifiableList(
            new ArrayList<>(productos)
        );
    }

    public List<Producto> listarPorCategoria(String categoria) {
        if (categoria == null) {
            throw new IllegalArgumentException(
                "La categoría es obligatoria."
            );
        }

        List<Producto> resultado = new ArrayList<>();

        for (Producto producto : productos) {
            if (producto.getCategoria().equalsIgnoreCase(categoria)) {
                resultado.add(producto);
            }
        }

        return Collections.unmodifiableList(resultado);
    }

    public void mostrarMenu() {
        for (Producto producto : productos) {
            System.out.println(producto.getInformation());
            System.out.println("--------------------");
        }
    }
}