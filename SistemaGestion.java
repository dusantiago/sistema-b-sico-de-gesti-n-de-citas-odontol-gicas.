import java.util.ArrayList;

public class SistemaGestion {
    private ArrayList<Cita> citas;
    private ArrayList<Consultorio> consultorios;
    private ArrayList<Profesional> profesionales;
    private ArrayList<Asistente> asistentes;
    private ArrayList<Paciente> pacientes;
    private int contadorCitas;

    public SistemaGestion() {
        this.citas = new ArrayList<>();
        this.consultorios = new ArrayList<>();
        this.profesionales = new ArrayList<>();
        this.asistentes = new ArrayList<>();
        this.pacientes = new ArrayList<>();
        this.contadorCitas = 1;
    }

    // Registro
    public void registrarConsultorio(Consultorio c) {
        consultorios.add(c);
        System.out.println("Consultorio registrado: " + c);
    }

    public void registrarProfesional(Profesional p) {
        profesionales.add(p);
        System.out.println("Profesional registrado: " + p);
    }

    public void registrarAsistente(Asistente a) {
        asistentes.add(a);
        System.out.println("Asistente registrado: " + a);
    }

    public void registrarPaciente(Paciente p) {
        pacientes.add(p);
        System.out.println("Paciente registrado: " + p);
    }

    // Disponibilidad
    public boolean consultorioDisponible(Consultorio consultorio, String fecha, String horario) {
        for (Cita c : citas) {
            if (!c.isCancelada()
                    && c.getConsultorio().getNumero() == consultorio.getNumero()
                    && c.getFecha().equals(fecha)
                    && c.getHorario().equals(horario)) {
                return false;
            }
        }
        return true;
    }

    public Consultorio buscarConsultorioDisponible(String fecha, String horario) {
        for (Consultorio c : consultorios) {
            if (consultorioDisponible(c, fecha, horario)) {
                return c;
            }
        }
        return null;
    }

    // Agendar cita manual
    public Cita agendarCita(String fecha, String horario, String procedimiento,
                            Paciente paciente, Profesional profesional,
                            Asistente asistente, Consultorio consultorio) {

        if (!consultorioDisponible(consultorio, fecha, horario)) {
            System.out.println("El consultorio #" + consultorio.getNumero()
                    + " no esta disponible el " + fecha + " a las " + horario + ".");
            return null;
        }

        String id = "C" + String.format("%03d", contadorCitas++);
        Cita nueva = new Cita(id, fecha, horario, procedimiento,
                paciente, profesional, asistente, consultorio);
        citas.add(nueva);
        System.out.println("Cita agendada exitosamente:\n" + nueva);
        return nueva;
    }

    // El paciente solicita cita: el sistema asigna automáticamente
    public Cita solicitarCitaPaciente(String fecha, String horario,
                                      String procedimiento, Paciente paciente) {
        Consultorio consultorio = buscarConsultorioDisponible(fecha, horario);
        if (consultorio == null) {
            System.out.println("No hay consultorios disponibles para " + fecha + " a las " + horario + ".");
            return null;
        }
        if (profesionales.isEmpty()) {
            System.out.println("No hay profesionales registrados.");
            return null;
        }
        if (asistentes.isEmpty()) {
            System.out.println("No hay asistentes registrados.");
            return null;
        }
        Profesional profesional = profesionales.get(0);
        Asistente asistente = asistentes.get(0);
        return agendarCita(fecha, horario, procedimiento,
                paciente, profesional, asistente, consultorio);
    }

    // Cancelar
    public void cancelarCita(String idCita) {
        for (Cita c : citas) {
            if (c.getId().equals(idCita)) {
                if (c.isCancelada()) {
                    System.out.println("La cita " + idCita + " ya estaba cancelada.");
                } else {
                    c.cancelar();
                }
                return;
            }
        }
        System.out.println("No se encontro ninguna cita con ID: " + idCita);
    }

    // Listar
    public void listarCitas() {
        if (citas.isEmpty()) {
            System.out.println("No hay citas registradas.");
            return;
        }
        System.out.println("\n========== LISTA DE CITAS ==========");
        for (Cita c : citas) {
            System.out.println(c);
            System.out.println("-------------------------------------");
        }
    }

    public void listarCitasPorPaciente(String identificacion) {
        System.out.println("\n===== CITAS DEL PACIENTE " + identificacion + " =====");
        boolean encontrado = false;
        for (Cita c : citas) {
            if (c.getPaciente().getIdentificacion().equals(identificacion)) {
                System.out.println(c);
                System.out.println("-------------------------------------");
                encontrado = true;
            }
        }
        if (!encontrado) System.out.println("No se encontraron citas para ese paciente.");
    }

    // Getters
    public ArrayList<Consultorio> getConsultorios() { return consultorios; }
    public ArrayList<Profesional> getProfesionales() { return profesionales; }
    public ArrayList<Asistente> getAsistentes() { return asistentes; }
    public ArrayList<Paciente> getPacientes() { return pacientes; }
    public ArrayList<Cita> getCitas() { return citas; }
}
