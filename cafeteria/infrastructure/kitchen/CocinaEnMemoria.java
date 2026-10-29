package cafeteria.infrastructure.kitchen;

import cafeteria.application.port.ServicioCocina;
import cafeteria.domain.EstadoPedido;
import cafeteria.domain.Pedido;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CocinaEnMemoria implements ServicioCocina {

    private final List<Pedido> pedidosPendientes;

    public CocinaEnMemoria() {
        pedidosPendientes = new ArrayList<>();
    }

    @Override
    public boolean enviarPedido(Pedido pedido) {
        if (pedido == null
                || pedido.getEstado() != EstadoPedido.PAGADO) {
            return false;
        }

        pedidosPendientes.add(pedido);
        pedido.marcarEnCocina();

        return true;
    }

    public List<Pedido> listarPendientes() {
        return Collections.unmodifiableList(
            new ArrayList<>(pedidosPendientes)
        );
    }

    public void completarPedido(Pedido pedido) {
        if (pedido == null || !pedidosPendientes.contains(pedido)) {
            throw new IllegalArgumentException(
                "El pedido no está registrado en cocina."
            );
        }

        pedido.completar();
        pedidosPendientes.remove(pedido);
    }
}