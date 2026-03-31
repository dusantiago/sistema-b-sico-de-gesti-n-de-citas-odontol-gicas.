public class Consultorio {
    private int numero;
    private String ubicacion;

    public Consultorio(int numero, String ubicacion) {
        this.numero = numero;
        this.ubicacion = ubicacion;
    }

    public int getNumero() { return numero; }
    public String getUbicacion() { return ubicacion; }
    public void setNumero(int n) { this.numero = n; }
    public void setUbicacion(String u) { this.ubicacion = u; }

    public String toString() {
        return "Consultorio #" + numero + " | Ubicacion: " + ubicacion;
    }
}
