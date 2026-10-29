package cafeteria.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pedido {

    private final List<LineaPedido> lineas;
    private EstadoPedido estado;

    public Pedido() {
        lineas = new ArrayList<>();
        estado = EstadoPedido.CREADO;
    }

    public void agregarProducto(Producto producto, int cantidad) {
        verificarEditable();

        lineas.add(new LineaPedido(producto, cantidad));
    }

    public void eliminarProducto(int indice) {
        verificarEditable();

        if (indice < 0 || indice >= lineas.size()) {
            throw new IndexOutOfBoundsException(
                "Índice de producto no válido."
            );
        }

        lineas.remove(indice);
    }

    public void aumentarCantidad(int indice) {
        verificarEditable();
        obtenerLinea(indice).aumentarCantidad();
    }

    public void disminuirCantidad(int indice) {
        verificarEditable();
        obtenerLinea(indice).disminuirCantidad();
    }

    public LineaPedido obtenerLinea(int indice) {
        if (indice < 0 || indice >= lineas.size()) {
            throw new IndexOutOfBoundsException(
                "Índice de producto no válido."
            );
        }

        return lineas.get(indice);
    }

    public List<LineaPedido> getLineas() {
        return Collections.unmodifiableList(
            new ArrayList<>(lineas)
        );
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void confirmarPago() {
        if (estado != EstadoPedido.CREADO) {
            throw new IllegalStateException(
                "El pedido no está disponible para el pago."
            );
        }

        if (lineas.isEmpty()) {
            throw new IllegalStateException(
                "No se puede pagar un pedido vacío."
            );
        }

        estado = EstadoPedido.PAGADO;
    }

    public void marcarEnCocina() {
        if (estado != EstadoPedido.PAGADO) {
            throw new IllegalStateException(
                "El pedido debe estar pagado."
            );
        }

        estado = EstadoPedido.EN_COCINA;
    }

    public void completar() {
        if (estado != EstadoPedido.EN_COCINA) {
            throw new IllegalStateException(
                "El pedido no está en cocina."
            );
        }

        estado = EstadoPedido.COMPLETADO;
    }

    private void verificarEditable() {
        if (estado != EstadoPedido.CREADO) {
            throw new IllegalStateException(
                "Solo se pueden modificar pedidos creados."
            );
        }
    }

    public void listarPedido() {
        for (LineaPedido linea : lineas) {
            System.out.println(
                linea.getProducto().getNombre()
                + " x " + linea.getCantidad()
                + " = Bs " + linea.calcularSubtotal()
            );
        }
    }

    public void agregarAgregado(int indice, Agregado agregado) {
        verificarEditable();

        if (agregado == null) {
            throw new IllegalArgumentException(
                "El agregado no puede ser null."
            );
        }

        obtenerLinea(indice).agregarAgregado(agregado);
    }
}