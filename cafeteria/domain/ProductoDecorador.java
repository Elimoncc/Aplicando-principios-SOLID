package cafeteria.domain;

public abstract class ProductoDecorador extends Producto {

    protected final Producto productoEnvuelto;

    protected ProductoDecorador(Producto producto) {
        this(validarProducto(producto), true);
    }

    private ProductoDecorador(
            Producto producto, boolean validado) {

        super(
            producto.getNombre(),
            producto.getCategoria(),
            producto.getPrecio()
        );

        this.productoEnvuelto = producto;
    }

    private static Producto validarProducto(Producto producto) {
        if (producto == null) {
            throw new IllegalArgumentException(
                "El producto que se desea decorar es obligatorio."
            );
        }

        return producto;
    }

    @Override
    public String getNombre() {
        return productoEnvuelto.getNombre();
    }

    @Override
    public String getCategoria() {
        return productoEnvuelto.getCategoria();
    }

    @Override
    public double getPrecio() {
        return productoEnvuelto.getPrecio();
    }

    @Override
    public String getInformation() {
        return productoEnvuelto.getInformation();
    }

    @Override
    public void setNombre(String nombre) {
        throw new UnsupportedOperationException(
            "No se puede modificar directamente un producto decorado."
        );
    }

    @Override
    public void setCategoria(String categoria) {
        throw new UnsupportedOperationException(
            "No se puede modificar directamente un producto decorado."
        );
    }

    @Override
    public void setPrecio(double precio) {
        throw new UnsupportedOperationException(
            "No se puede modificar directamente un producto decorado."
        );
    }
}
