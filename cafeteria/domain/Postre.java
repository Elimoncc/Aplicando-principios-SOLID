package cafeteria.domain;

public class Postre extends Producto {
    private boolean contieneAzucar;
    private boolean vegetariano;

    public Postre(String nombre, double precio,
                  boolean contieneAzucar, boolean vegetariano) {
        super(nombre, "Postre", precio);
        this.contieneAzucar = contieneAzucar;
        this.vegetariano = vegetariano;
    }

    public boolean isContieneAzucar() {
        return contieneAzucar;
    }

    public boolean isVegetariano() {
        return vegetariano;
    }

    public void setContieneAzucar(boolean contieneAzucar) {
        this.contieneAzucar = contieneAzucar;
    }

    public void setVegetariano(boolean vegetariano) {
        this.vegetariano = vegetariano;
    }

    @Override
    public String getInformation() {
        return "Nombre: " + getNombre()
                + "\nCategoría: Postre"
                + "\nPrecio: Bs " + getPrecio()
                + "\nContiene azúcar: " + (contieneAzucar ? "Sí" : "No")
                + "\nVegetariano: " + (vegetariano ? "Sí" : "No");
    }
}