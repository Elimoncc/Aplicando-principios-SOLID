package cafeteria.infrastructure.payment;

import cafeteria.application.port.MetodoPago;

public class PagoEfectivo implements MetodoPago {

    private final double dineroRecibido;

    public PagoEfectivo(double dineroRecibido) {
        if (dineroRecibido < 0) {
            throw new IllegalArgumentException(
                "El dinero recibido no puede ser negativo."
            );
        }

        this.dineroRecibido = dineroRecibido;
    }

    @Override
    public boolean procesarPago(double monto) {
        return monto >= 0 && dineroRecibido >= monto;
    }

    public double calcularCambio(double monto) {
        if (!procesarPago(monto)) {
            throw new IllegalStateException(
                "El dinero recibido es insuficiente."
            );
        }

        return dineroRecibido - monto;
    }

    @Override
    public String getNombreMetodo() {
        return "Efectivo";
    }
}