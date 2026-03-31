public class Profesional extends Persona {
    private String especialidad;
    private String registroProfesional;

    public Profesional(String nombre, String identificacion, String telefono,
                       String especialidad, String registroProfesional) {
        super(nombre, identificacion, telefono);
        this.especialidad = especialidad;
        this.registroProfesional = registroProfesional;
    }

    public String getEspecialidad() { return especialidad; }
    public String getRegistroProfesional() { return registroProfesional; }
    public void setEspecialidad(String e) { this.especialidad = e; }
    public void setRegistroProfesional(String r) { this.registroProfesional = r; }

    public String toString() {
        return "Profesional: " + super.toString() + " | Especialidad: " + especialidad;
    }
}
