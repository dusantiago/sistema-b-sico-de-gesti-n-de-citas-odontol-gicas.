public class Asistente extends Persona {
    private String cargo;

    public Asistente(String nombre, String identificacion, String telefono, String cargo) {
        super(nombre, identificacion, telefono);
        this.cargo = cargo;
    }

    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }

    public String toString() {
        return "Asistente: " + super.toString() + " | Cargo: " + cargo;
    }
}
