package cafeteria.application.factory;

import cafeteria.domain.Bebida;
import cafeteria.domain.Producto;

public class CreadorBebida extends CreadorProducto {

    private final String nombre;
    private final double precio;
    private final String tamano;
    private final boolean fria;

    public CreadorBebida(
            String nombre,
            double precio,
            String tamano,
            boolean fria) {

        this.nombre = nombre;
        this.precio = precio;
        this.tamano = tamano;
        this.fria = fria;
    }

    @Override
    public Producto crearProducto() {
        return new Bebida(
            nombre,
            precio,
            tamano,
            fria
        );
    }
}
