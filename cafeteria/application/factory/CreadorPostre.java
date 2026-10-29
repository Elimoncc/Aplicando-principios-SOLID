package cafeteria.application.factory;

import cafeteria.domain.Postre;
import cafeteria.domain.Producto;

public class CreadorPostre extends CreadorProducto {

    private final String nombre;
    private final double precio;
    private final boolean contieneAzucar;
    private final boolean vegetariano;

    public CreadorPostre(
            String nombre,
            double precio,
            boolean contieneAzucar,
            boolean vegetariano) {

        this.nombre = nombre;
        this.precio = precio;
        this.contieneAzucar = contieneAzucar;
        this.vegetariano = vegetariano;
    }

    @Override
    public Producto crearProducto() {
        return new Postre(
            nombre,
            precio,
            contieneAzucar,
            vegetariano
        );
    }
}
