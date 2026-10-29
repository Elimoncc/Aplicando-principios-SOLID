package cafeteria.application.port;

public interface MetodoPago {
    boolean procesarPago(double monto);
    String getNombreMetodo();
}