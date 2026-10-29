package cafeteria.presentation;

import cafeteria.application.CalculadoraPedido;
import cafeteria.application.GestorPedidos;
import cafeteria.application.Menu;
import cafeteria.application.port.MetodoPago;
import cafeteria.application.port.ServicioCocina;
import cafeteria.domain.Agregado;
import cafeteria.domain.Bebida;
import cafeteria.domain.Pedido;
import cafeteria.domain.Postre;
import cafeteria.infrastructure.kitchen.CocinaEnMemoria;
import cafeteria.infrastructure.payment.PagoEfectivo;

public class Main {

    public static void main(String[] args) {

        Menu menu = new Menu();

        Bebida cafe = new Bebida(
            "Café con leche", 12.00, "Mediano", false
        );

        Postre pastel = new Postre(
            "Pastel de chocolate", 15.00, true, true
        );


        menu.agregarProducto(cafe);
        menu.agregarProducto(pastel);

        System.out.println("=== MENÚ ===");
        menu.mostrarMenu();

        Pedido pedido = new Pedido();

        pedido.agregarProducto(cafe, 2);
        pedido.agregarProducto(pastel, 1);


        Agregado quesoExtra = new Agregado(
            "Queso extra", 3.00
        );

        pedido.agregarAgregado(1, quesoExtra);

        CalculadoraPedido calculadora =
            new CalculadoraPedido();

        System.out.println("\n=== PEDIDO ===");
        pedido.listarPedido();

        System.out.println(
            "Subtotal: Bs "
            + calculadora.calcularSubtotal(pedido)
        );

        System.out.println(
            "IVA: Bs "
            + calculadora.calcularImpuesto(pedido)
        );

        System.out.println(
            "Total: Bs "
            + calculadora.calcularTotal(pedido)
        );


        ServicioCocina cocina = new CocinaEnMemoria();

        GestorPedidos gestor = new GestorPedidos(
            calculadora, cocina
        );

        MetodoPago pago = new PagoEfectivo(80.00);

        boolean procesado = gestor.cobrarYEnviar(
            pedido, pago
        );

        if (procesado) {
            System.out.println(
                "\nEstado final: " + pedido.getEstado()
            );
        }
    }
}