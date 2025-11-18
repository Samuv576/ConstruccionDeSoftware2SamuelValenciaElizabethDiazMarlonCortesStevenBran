package Clinic.Clinic.adapter.in.client;

import Clinic.Clinic.adapter.in.builder.VitalSignsBuilder;
import Clinic.Clinic.application.usecases.VitalSignsUseCase;
import Clinic.Clinic.domain.model.VitalSigns;

import java.util.Scanner;
import org.springframework.stereotype.Component;

@Component
public class VitalSignsClient {

    private final VitalSignsBuilder builder;
    private final VitalSignsUseCase useCase;

    public VitalSignsClient(VitalSignsBuilder builder, VitalSignsUseCase useCase) {
        this.builder = builder;
        this.useCase = useCase;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("=== Gestión de Signos Vitales ===");
            System.out.println("1. Registrar signos vitales");
            System.out.println("2. Consultar signos por paciente");
            System.out.println("3. Actualizar signos");
            System.out.println("4. Eliminar signos");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            String option = scanner.nextLine();

            try {
                switch (option) {
                    case "1" -> {
                        System.out.print("Documento del paciente: ");
                        String document = scanner.nextLine();
                        VitalSigns signs = buildSigns(scanner);
                        useCase.createVitalSigns(signs, document);
                        System.out.println("✅ Signos vitales registrados.");
                    }
                    case "2" -> {
                        System.out.print("Documento del paciente: ");
                        String document = scanner.nextLine();
                        VitalSigns signs = useCase.findVitalSignsByPatient(document);
                        System.out.println("📊 Signos encontrados:");
                        System.out.println("Presión arterial: " + signs.getBloodPressure());
                        System.out.println("Temperatura: " + signs.getTemperature());
                        System.out.println("Pulso: " + signs.getPulse());
                        System.out.println("Oxígeno: " + signs.getOxygenLevel());
                    }
                    case "3" -> {
                        System.out.print("Documento del paciente: ");
                        String document = scanner.nextLine();
                        VitalSigns signs = buildSigns(scanner);
                        useCase.updateVitalSigns(signs, document);
                        System.out.println("✏️ Signos vitales actualizados.");
                    }
                    case "4" -> {
                        System.out.print("Documento del paciente: ");
                        String document = scanner.nextLine();
                        useCase.deleteVitalSigns(document);
                        System.out.println("🗑️ Signos vitales eliminados.");
                    }
                    case "0" -> {
                        running = false;
                        System.out.println("Saliendo de gestión de signos vitales...");
                    }
                    default -> System.out.println("❌ Opción inválida.");
                }
            } catch (Exception e) {
                System.out.println("⚠️ Error: " + e.getMessage());
            }
        }
    }

    private VitalSigns buildSigns(Scanner scanner) throws Exception {
        System.out.print("Presión arterial: ");
        String bp = scanner.nextLine();
        System.out.print("Temperatura corporal: ");
        String temp = scanner.nextLine();
        System.out.print("Pulso cardíaco: ");
        String pulse = scanner.nextLine();
        System.out.print("Nivel de oxígeno: ");
        String oxygen = scanner.nextLine();

        return builder.build(bp, temp, pulse, oxygen);
    }
}
