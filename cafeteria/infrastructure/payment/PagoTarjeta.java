package cafeteria.infrastructure.payment;

import cafeteria.application.port.MetodoPago;

public class PagoTarjeta implements MetodoPago {

    private final boolean autorizacionAprobada;

    public PagoTarjeta(boolean autorizacionAprobada) {
        this.autorizacionAprobada = autorizacionAprobada;
    }

    @Override
    public boolean procesarPago(double monto) {
        return monto > 0 && autorizacionAprobada;
    }

    @Override
    public String getNombreMetodo() {
        return "Tarjeta de crédito";
    }
}