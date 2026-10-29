package cafeteria.domain;

import java.util.ArrayList;
import java.util.List;

public class LineaPedido {
    private Producto producto;
    private int cantidad;
    private List<Agregado> agregados;

    public LineaPedido(Producto producto, int cantidad) {
        if (producto == null) {
            throw new IllegalArgumentException(
                "El producto es obligatorio."
            );
        }

        if (cantidad < 1) {
            throw new IllegalArgumentException(
                "La cantidad debe ser mayor que cero."
            );
        }

        this.producto = producto;
        this.cantidad = cantidad;
        this.agregados = new ArrayList<>();
    }

    public void agregarAgregado(Agregado agregado) {
        agregados.add(agregado);
    }

    public void aumentarCantidad() {
        cantidad++;
    }

    public void disminuirCantidad() {
        if (cantidad > 1) {
            cantidad--;
        }
    }

    public double calcularSubtotal() {
        double precioUnitario = producto.getPrecio();

        for (Agregado agregado : agregados) {
            precioUnitario += agregado.getPrecio();
        }

        return precioUnitario * cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public List<Agregado> getAgregados() {
        return new ArrayList<>(agregados);
    }
}