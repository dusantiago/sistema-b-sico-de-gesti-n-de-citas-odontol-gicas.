import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static SistemaGestion sistema = new SistemaGestion();

    public  void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opcion: ");
            switch (opcion) {
                case 1: menuAgendarCita(); break;
                case 2: menuSolicitarCitaPaciente(); break;
                case 3: menuCancelarCita(); break;
                case 4: sistema.listarCitas(); break;
                case 5: menuCitasPorPaciente(); break;
                case 6: menuRegistrarPaciente(); break;
                case 7: menuRegistrarProfesional(); break;
                case 8: menuRegistrarAsistente(); break;
                case 9: menuRegistrarConsultorio(); break;
                case 0: System.out.println("Saliendo del sistema. Hasta luego!"); break;
                default: System.out.println("Opcion no valida.");
            }
        } while (opcion != 0);

        scanner.close();
    }

    static void mostrarMenu() {
        System.out.println("\n======================================");
        System.out.println("   SISTEMA DE GESTION ODONTOLOGICA   ");
        System.out.println("======================================");
        System.out.println(" 1. Agendar cita (manual)");
        System.out.println(" 2. Solicitar cita (paciente)");
        System.out.println(" 3. Cancelar cita");
        System.out.println(" 4. Listar todas las citas");
        System.out.println(" 5. Citas por paciente");
        System.out.println(" 6. Registrar paciente");
        System.out.println(" 7. Registrar profesional");
        System.out.println(" 8. Registrar asistente");
        System.out.println(" 9. Registrar consultorio");
        System.out.println(" 0. Salir");
        System.out.println("======================================");
    }

     void menuAgendarCita() {
        System.out.println("\n--- AGENDAR CITA MANUAL ---");
        if (sistema.getPacientes().isEmpty() || sistema.getProfesionales().isEmpty()
                || sistema.getAsistentes().isEmpty() || sistema.getConsultorios().isEmpty()) {
            System.out.println("Asegurese de tener pacientes, profesionales, asistentes y consultorios registrados.");
            return;
        }

        System.out.println("Pacientes:");
        for (int i = 0; i < sistema.getPacientes().size(); i++)
            System.out.println("  " + (i + 1) + ". " + sistema.getPacientes().get(i));
        int ip = leerEntero("Seleccione paciente: ") - 1;

        System.out.println("Profesionales:");
        for (int i = 0; i < sistema.getProfesionales().size(); i++)
            System.out.println("  " + (i + 1) + ". " + sistema.getProfesionales().get(i));
        int ipr = leerEntero("Seleccione profesional: ") - 1;

        System.out.println("Asistentes:");
        for (int i = 0; i < sistema.getAsistentes().size(); i++)
            System.out.println("  " + (i + 1) + ". " + sistema.getAsistentes().get(i));
        int ia = leerEntero("Seleccione asistente: ") - 1;

        System.out.println("Consultorios:");
        for (int i = 0; i < sistema.getConsultorios().size(); i++)
            System.out.println("  " + (i + 1) + ". " + sistema.getConsultorios().get(i));
        int ic = leerEntero("Seleccione consultorio: ") - 1;

        System.out.print("Fecha (ej: 2026-04-05): ");
        String fecha = scanner.nextLine().trim();
        System.out.print("Horario (ej: 10:00): ");
        String horario = scanner.nextLine().trim();
        System.out.print("Procedimiento: ");
        String procedimiento = scanner.nextLine().trim();

        sistema.agendarCita(fecha, horario, procedimiento,
                sistema.getPacientes().get(ip),
                sistema.getProfesionales().get(ipr),
                sistema.getAsistentes().get(ia),
                sistema.getConsultorios().get(ic));
    }

     void menuSolicitarCitaPaciente() {
        System.out.println("\n--- SOLICITAR CITA (PACIENTE) ---");
        if (sistema.getPacientes().isEmpty()) {
            System.out.println("No hay pacientes registrados.");
            return;
        }
        System.out.println("Pacientes:");
        for (int i = 0; i < sistema.getPacientes().size(); i++)
            System.out.println("  " + (i + 1) + ". " + sistema.getPacientes().get(i));
        int ip = leerEntero("Seleccione paciente: ") - 1;

        System.out.print("Fecha (ej: 2026-04-05): ");
        String fecha = scanner.nextLine().trim();
        System.out.print("Horario (ej: 10:00): ");
        String horario = scanner.nextLine().trim();
        System.out.print("Procedimiento: ");
        String procedimiento = scanner.nextLine().trim();

        sistema.solicitarCitaPaciente(fecha, horario, procedimiento,
                sistema.getPacientes().get(ip));
    }

     void menuCancelarCita() {
        System.out.println("\n--- CANCELAR CITA ---");
        System.out.print("ID de la cita a cancelar: ");
        String id = scanner.nextLine().trim();
        sistema.cancelarCita(id);
    }

     void menuCitasPorPaciente() {
        System.out.print("Identificacion del paciente: ");
        String id = scanner.nextLine().trim();
        sistema.listarCitasPorPaciente(id);
    }

     void menuRegistrarPaciente() {
        System.out.println("\n--- REGISTRAR PACIENTE ---");
        System.out.print("Nombre: "); String nombre = scanner.nextLine().trim();
        System.out.print("Identificacion: "); String id = scanner.nextLine().trim();
        System.out.print("Telefono: "); String tel = scanner.nextLine().trim();
        System.out.print("Historial medico: "); String hist = scanner.nextLine().trim();
        sistema.registrarPaciente(new Paciente(nombre, id, tel, hist));
    }

     void menuRegistrarProfesional() {
        System.out.println("\n--- REGISTRAR PROFESIONAL ---");
        System.out.print("Nombre: "); String nombre = scanner.nextLine().trim();
        System.out.print("Identificacion: "); String id = scanner.nextLine().trim();
        System.out.print("Telefono: "); String tel = scanner.nextLine().trim();
        System.out.print("Especialidad: "); String esp = scanner.nextLine().trim();
        System.out.print("Registro profesional: "); String reg = scanner.nextLine().trim();
        sistema.registrarProfesional(new Profesional(nombre, id, tel, esp, reg));
    }

     void menuRegistrarAsistente() {
        System.out.println("\n--- REGISTRAR ASISTENTE ---");
        System.out.print("Nombre: "); String nombre = scanner.nextLine().trim();
        System.out.print("Identificacion: "); String id = scanner.nextLine().trim();
        System.out.print("Telefono: "); String tel = scanner.nextLine().trim();
        System.out.print("Cargo: "); String cargo = scanner.nextLine().trim();
        sistema.registrarAsistente(new Asistente(nombre, id, tel, cargo));
    }

     void menuRegistrarConsultorio() {
        System.out.println("\n--- REGISTRAR CONSULTORIO ---");
        int num = leerEntero("Numero de consultorio: ");
        System.out.print("Ubicacion: "); String ub = scanner.nextLine().trim();
        sistema.registrarConsultorio(new Consultorio(num, ub));
    }

     int leerEntero(String mensaje) {
        int valor = -1;
        while (true) {
            System.out.print(mensaje);
            try {
                valor = Integer.parseInt(scanner.nextLine().trim());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Por favor ingrese un numero valido.");
            }
        }
        return valor;
    }
}
