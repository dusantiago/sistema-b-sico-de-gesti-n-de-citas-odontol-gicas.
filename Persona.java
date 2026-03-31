public class Persona {
    private String nombre;
    private String identificacion;
    private String telefono;

    public Persona(String nombre, String identificacion, String telefono) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.telefono = telefono;
    }

    public String getNombre() { return nombre; }
    public String getIdentificacion() { return identificacion; }
    public String getTelefono() { return telefono; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setIdentificacion(String id) { this.identificacion = id; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String toString() {
        return nombre + " (ID: " + identificacion + ")";
    }
}
