public class Cita {
    private String id;
    private String fecha;
    private String horario;
    private String procedimiento;
    private boolean cancelada;

    private Paciente paciente;
    private Profesional profesional;
    private Asistente asistente;
    private Consultorio consultorio;

    public Cita(String id, String fecha, String horario, String procedimiento,
                Paciente paciente, Profesional profesional,
                Asistente asistente, Consultorio consultorio) {
        this.id = id;
        this.fecha = fecha;
        this.horario = horario;
        this.procedimiento = procedimiento;
        this.paciente = paciente;
        this.profesional = profesional;
        this.asistente = asistente;
        this.consultorio = consultorio;
        this.cancelada = false;
    }

    public String getId() { return id; }
    public String getFecha() { return fecha; }
    public String getHorario() { return horario; }
    public String getProcedimiento() { return procedimiento; }
    public boolean isCancelada() { return cancelada; }
    public Paciente getPaciente() { return paciente; }
    public Profesional getProfesional() { return profesional; }
    public Asistente getAsistente() { return asistente; }
    public Consultorio getConsultorio() { return consultorio; }

    public void cancelar() {
        this.cancelada = true;
        System.out.println("Cita " + id + " cancelada exitosamente.");
    }

    public String toString() {
        String estado = cancelada ? "CANCELADA" : "ACTIVA";
        return "=== Cita ID: " + id + " [" + estado + "] ===\n" +
               "  Fecha: " + fecha + " | Horario: " + horario + "\n" +
               "  Procedimiento: " + procedimiento + "\n" +
               "  " + paciente + "\n" +
               "  " + profesional + "\n" +
               "  " + asistente + "\n" +
               "  " + consultorio;
    }
}
