package cafeteria.application;

import cafeteria.domain.LineaPedido;
import cafeteria.domain.Pedido;

public class CalculadoraPedido {

    private static final double TASA_IVA = 0.13;

    public double calcularSubtotal(Pedido pedido) {
        validarPedido(pedido);

        double subtotal = 0;

        for (LineaPedido linea : pedido.getLineas()) {
            subtotal += linea.calcularSubtotal();
        }

        return subtotal;
    }

    public double calcularImpuesto(Pedido pedido) {
        return calcularSubtotal(pedido) * TASA_IVA;
    }

    public double calcularTotal(Pedido pedido) {
        return calcularSubtotal(pedido)
                + calcularImpuesto(pedido);
    }

    private void validarPedido(Pedido pedido) {
        if (pedido == null) {
            throw new IllegalArgumentException(
                "El pedido no puede ser null."
            );
        }
    }
}