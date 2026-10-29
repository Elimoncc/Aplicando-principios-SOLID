package cafeteria.domain;

public class Agregado extends ProductoDecorador {

    private final String nombreAgregado;
    private final double precioAgregado;

    public Agregado(
            Producto producto,
            String nombreAgregado,
            double precioAgregado) {

        super(producto);

        if (nombreAgregado == null
                || nombreAgregado.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "El nombre del agregado es obligatorio."
            );
        }

        if (!Double.isFinite(precioAgregado)
                || precioAgregado < 0) {
            throw new IllegalArgumentException(
                "El precio del agregado no puede ser negativo."
            );
        }

        this.nombreAgregado = nombreAgregado.trim();
        this.precioAgregado = precioAgregado;
    }

    public String getNombreAgregado() {
        return nombreAgregado;
    }

    public double getPrecioAgregado() {
        return precioAgregado;
    }

    @Override
    public String getNombre() {
        return productoEnvuelto.getNombre()
                + " + " + nombreAgregado;
    }

    @Override
    public double getPrecio() {
        return productoEnvuelto.getPrecio()
                + precioAgregado;
    }

    @Override
    public String getInformation() {
        return productoEnvuelto.getInformation()
                + "\nAgregado: " + nombreAgregado
                + "\nPrecio del agregado: Bs " + precioAgregado
                + "\nPrecio con agregado: Bs " + getPrecio();
    }
}
