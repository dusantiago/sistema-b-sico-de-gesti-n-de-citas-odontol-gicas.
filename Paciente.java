public class Paciente extends Persona {
    private String historialMedico;

    public Paciente(String nombre, String identificacion, String telefono, String historialMedico) {
        super(nombre, identificacion, telefono);
        this.historialMedico = historialMedico;
    }

    public String getHistorialMedico() { return historialMedico; }
    public void setHistorialMedico(String h) { this.historialMedico = h; }

    public String toString() {
        return "Paciente: " + super.toString();
    }
}
