package cafeteria.domain;

public class Bebida extends Producto {
    private String tamano;
    private boolean fria;

    public Bebida(String nombre, double precio,
                  String tamano, boolean fria) {
        super(nombre, "Bebida", precio);
        this.tamano = tamano;
        this.fria = fria;
    }

    public String getTamano() {
        return tamano;
    }

    public boolean isFria() {
        return fria;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    public void setFria(boolean fria) {
        this.fria = fria;
    }

    @Override
    public String getInformation() {
        return "Nombre: " + getNombre()
                + "\nCategoría: Bebida"
                + "\nPrecio: Bs " + getPrecio()
                + "\nTamaño: " + tamano
                + "\nTemperatura: " + (fria ? "Fría" : "Caliente");
    }
}