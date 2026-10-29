package cafeteria.application.port;

import cafeteria.domain.Pedido;

public interface ServicioCocina {
    boolean enviarPedido(Pedido pedido);
}