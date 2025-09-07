package Clinic.Clinic.adapter.in.client;

import Clinic.Clinic.adapter.in.builder.MedicalHistoryBuilder;
import Clinic.Clinic.application.usecases.MedicalHistoryUseCase;
import Clinic.Clinic.domain.model.MedicalHistory;
import Clinic.Clinic.domain.model.MedicalHistoryEntry;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MedicalHistoryClient {

    private final MedicalHistoryBuilder builder;
    private final MedicalHistoryUseCase useCase;

    public MedicalHistoryClient(MedicalHistoryBuilder builder, MedicalHistoryUseCase useCase) {
        this.builder = builder;
        this.useCase = useCase;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Gestión de Historial Médico ===");
        System.out.println("1. Crear historial médico");
        System.out.println("2. Agregar entrada");
        System.out.println("3. Consultar entradas");
        System.out.println("4. Eliminar entrada");
        System.out.print("Seleccione una opción: ");
        String option = scanner.nextLine();

        try {
            switch (option) {
                case "1" -> {
                    System.out.print("Documento del paciente: ");
                    String document = scanner.nextLine();

                    MedicalHistory history = builder.build(document, new HashMap<>());
                    useCase.createMedicalHistory(history);
                    System.out.println("✅ Historial médico creado.");
                }

                case "2" -> {
                    System.out.print("Documento del paciente: ");
                    String document = scanner.nextLine();
                    System.out.print("Fecha de entrada (yyyy-MM-dd): ");
                    String dateStr = scanner.nextLine();
                    LocalDate date = LocalDate.parse(dateStr);

                    // Simulación de entrada médica (en producción usarías MedicalHistoryEntryBuilder)
                    MedicalHistoryEntry entry = new MedicalHistoryEntry();
                    System.out.print("Motivo: ");
                    entry.setReason(scanner.nextLine());
                    System.out.print("Síntomas: ");
                    entry.setSymptoms(scanner.nextLine());
                    System.out.print("Diagnóstico: ");
                    entry.setDiagnosis(scanner.nextLine());
                    System.out.print("Documento del médico: ");
                    entry.setDoctorDocument(scanner.nextLine());

                    useCase.addEntryToHistory(document, date, entry);
                    System.out.println("📝 Entrada agregada al historial.");
                }

                case "3" -> {
                    System.out.print("Documento del paciente: ");
                    String document = scanner.nextLine();
                    Map<LocalDate, MedicalHistoryEntry> entries = useCase.getHistoryEntries(document);

                    System.out.println("📚 Entradas encontradas:");
                    for (Map.Entry<LocalDate, MedicalHistoryEntry> entry : entries.entrySet()) {
                        System.out.println("Fecha: " + entry.getKey() + " | Motivo: " + entry.getValue().getReason());
                    }
                }

                case "4" -> {
                    System.out.print("Documento del paciente: ");
                    String document = scanner.nextLine();
                    System.out.print("Fecha de la entrada a eliminar (yyyy-MM-dd): ");
                    String dateStr = scanner.nextLine();
                    LocalDate date = LocalDate.parse(dateStr);

                    useCase.deleteEntryFromHistory(document, date);
                    System.out.println("🗑️ Entrada eliminada.");
                }

                default -> System.out.println("❌ Opción inválida.");
            }
        } catch (Exception e) {
            System.out.println("⚠️ Error: " + e.getMessage());
        }
    }
}
