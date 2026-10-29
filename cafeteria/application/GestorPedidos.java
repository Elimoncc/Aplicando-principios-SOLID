package cafeteria.application;

import cafeteria.application.port.MetodoPago;
import cafeteria.application.port.ServicioCocina;
import cafeteria.domain.EstadoPedido;
import cafeteria.domain.Pedido;

public class GestorPedidos {

    private final CalculadoraPedido calculadora;
    private final ServicioCocina servicioCocina;

    public GestorPedidos(
            CalculadoraPedido calculadora,
            ServicioCocina servicioCocina) {

        if (calculadora == null || servicioCocina == null) {
            throw new IllegalArgumentException(
                "Las dependencias son obligatorias."
            );
        }

        this.calculadora = calculadora;
        this.servicioCocina = servicioCocina;
    }

    public boolean cobrarYEnviar( Pedido pedido, MetodoPago metodoPago) {

        if (pedido == null || metodoPago == null) {
            throw new IllegalArgumentException(
                "El pedido y el método de pago son obligatorios."
            );
        }

        if (pedido.getEstado() != EstadoPedido.CREADO) {
            throw new IllegalStateException(
                "El pedido ya fue procesado o no está disponible."
            );
        }

        double total = calculadora.calcularTotal(pedido);

        if (!metodoPago.procesarPago(total)) {
            System.out.println("El pago fue rechazado.");
            return false;
        }

        pedido.confirmarPago();

        boolean enviado = servicioCocina.enviarPedido(pedido);

        if (!enviado) {
            System.out.println(
                "El pago fue aceptado, pero no se pudo enviar "
                + "el pedido a cocina. Debe reintentarse el envío."
            );
            return false;
        }

        System.out.println("Pago aceptado mediante: "
                + metodoPago.getNombreMetodo());
        System.out.println("Total cobrado: Bs " + total);
        System.out.println("Pedido enviado a cocina.");

        return true;
    }
}