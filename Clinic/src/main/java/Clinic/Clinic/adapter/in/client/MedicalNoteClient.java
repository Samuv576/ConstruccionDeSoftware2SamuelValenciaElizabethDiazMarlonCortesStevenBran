package Clinic.Clinic.adapter.in.client;

import Clinic.Clinic.adapter.in.builder.MedicalNoteBuilder;
import Clinic.Clinic.application.usecases.MedicalNoteUseCase;
import Clinic.Clinic.domain.model.MedicalNote;

import java.util.Scanner;
import org.springframework.stereotype.Component;

@Component

public class MedicalNoteClient {

    private final MedicalNoteBuilder builder;
    private final MedicalNoteUseCase useCase;

    public MedicalNoteClient(MedicalNoteBuilder builder, MedicalNoteUseCase useCase) {
        this.builder = builder;
        this.useCase = useCase;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Gestión de Notas Médicas ===");
        System.out.println("1. Registrar nota médica");
        System.out.println("2. Consultar nota por paciente");
        System.out.println("3. Actualizar nota");
        System.out.println("4. Eliminar nota");
        System.out.print("Seleccione una opción: ");
        String option = scanner.nextLine();

        try {
            switch (option) {
                case "1" -> {
                    System.out.print("ID del paciente: ");
                    String patientId = scanner.nextLine();
                    System.out.print("ID del médico: ");
                    String doctorId = scanner.nextLine();
                    System.out.print("Contenido de la nota: ");
                    String content = scanner.nextLine();
                    System.out.print("Fecha y hora (yyyy-MM-dd HH:mm): ");
                    String dateTime = scanner.nextLine();

                    MedicalNote note = builder.build(patientId, doctorId, content, dateTime);
                    useCase.createMedicalNote(note);
                    System.out.println("✅ Nota médica registrada.");
                }

                case "2" -> {
                    System.out.print("ID del paciente: ");
                    long patientId = Long.parseLong(scanner.nextLine());
                    MedicalNote note = useCase.findMedicalNoteByPatient(patientId);
                    System.out.println("📄 Nota encontrada: " + note.getNote() + " (por médico " + note.getDoctor().getId() + ")");
                }

                case "3" -> {
                    System.out.print("ID de la nota a actualizar: ");
                    long noteId = Long.parseLong(scanner.nextLine());
                    System.out.print("Nuevo contenido: ");
                    String newContent = scanner.nextLine();

                    MedicalNote note = new MedicalNote();
                    note.setId(noteId);
                    note.setNote(newContent);
                    useCase.updateMedicalNote(note);
                    System.out.println("✏️ Nota actualizada.");
                }

                case "4" -> {
                    System.out.print("ID de la nota a eliminar: ");
                    long noteId = Long.parseLong(scanner.nextLine());

                    MedicalNote note = new MedicalNote();
                    note.setId(noteId);
                    useCase.deleteMedicalNote(note);
                    System.out.println("🗑️ Nota médica eliminada.");
                }

                default -> System.out.println("❌ Opción inválida.");
            }
        } catch (Exception e) {
            System.out.println("⚠️ Error: " + e.getMessage());
        }
    }
}
