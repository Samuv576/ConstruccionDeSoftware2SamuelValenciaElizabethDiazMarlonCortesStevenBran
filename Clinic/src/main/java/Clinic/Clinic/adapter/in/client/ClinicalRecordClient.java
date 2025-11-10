package Clinic.Clinic.adapter.in.client;

import Clinic.Clinic.adapter.in.builder.ClinicalRecordBuilder;
import Clinic.Clinic.application.usecases.ClinicalRecordUseCase;
import Clinic.Clinic.domain.model.ClinicalOrder;
import Clinic.Clinic.domain.model.ClinicalRecord;
import Clinic.Clinic.domain.model.MedicalNote;
import Clinic.Clinic.domain.model.VitalSigns;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ClinicalRecordClient {

	private final ClinicalRecordBuilder builder;
	private final ClinicalRecordUseCase useCase;

	public ClinicalRecordClient(ClinicalRecordBuilder builder, ClinicalRecordUseCase useCase) {
		this.builder = builder;
		this.useCase = useCase;
	}

	public void run() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("=== Gestión de Registro Clínico ===");
		System.out.println("1. Crear registro clínico");
		System.out.println("2. Consultar registro por paciente");
		System.out.println("3. Actualizar signos vitales");
		System.out.println("4. Adjuntar orden clínica");
		System.out.print("Seleccione una opción: ");
		String option = scanner.nextLine();

		try {
			switch (option) {
			case "1" -> {
				System.out.print("Documento del paciente: ");
				String document = scanner.nextLine();

				MedicalNote note = new MedicalNote();
				System.out.print("Nota médica: ");
				note.setNote(scanner.nextLine());

				ClinicalOrder order = new ClinicalOrder();
				System.out.print("Número de orden clínica: ");
				order.setOrderNumber(scanner.nextLine());

				VitalSigns signs = new VitalSigns();
				System.out.print("Presión arterial: ");
				signs.setBloodPressure(Double.parseDouble(scanner.nextLine()));
				System.out.print("Temperatura: ");
				signs.setTemperature(Double.parseDouble(scanner.nextLine()));
				System.out.print("Pulso: ");
				signs.setPulse(Integer.parseInt(scanner.nextLine()));
				System.out.print("Oxígeno: ");
				signs.setOxygenLevel(Double.parseDouble(scanner.nextLine()));

				ClinicalRecord record = builder.build(note, order, signs);
				useCase.createClinicalRecord(record, document);
				System.out.println("✅ Registro clínico creado.");
			}

			case "2" -> {
				System.out.print("Documento del paciente: ");
				String document = scanner.nextLine();
				ClinicalRecord record = useCase.findClinicalRecord(document);
				System.out.println("📋 Registro encontrado:");
				System.out.println("Nota médica: " + record.getMedicalNote().getNote());
				System.out.println("Orden clínica: " + record.getClinicalOrder().getOrderNumber());
				System.out.println("Signos vitales: PA " + record.getVitalSigns().getBloodPressure() + ", Temp "
						+ record.getVitalSigns().getTemperature() + ", Pulso " + record.getVitalSigns().getPulse()
						+ ", O2 " + record.getVitalSigns().getOxygenLevel());
			}

			case "3" -> {
				System.out.print("Documento del paciente: ");
				String document = scanner.nextLine();
				VitalSigns signs = new VitalSigns();
				System.out.print("Presión arterial: ");
				signs.setBloodPressure(Double.parseDouble(scanner.nextLine()));
				System.out.print("Temperatura: ");
				signs.setTemperature(Double.parseDouble(scanner.nextLine()));
				System.out.print("Pulso: ");
				signs.setPulse(Integer.parseInt(scanner.nextLine()));
				System.out.print("Oxígeno: ");
				signs.setOxygenLevel(Double.parseDouble(scanner.nextLine()));

				useCase.updateVitalSigns(document, signs);
				System.out.println("✏️ Signos vitales actualizados.");
			}

			case "4" -> {
				System.out.print("Documento del paciente: ");
				String document = scanner.nextLine();
				ClinicalOrder order = new ClinicalOrder();
				System.out.print("Número de orden clínica: ");
				order.setOrderNumber(scanner.nextLine());

				useCase.attachClinicalOrder(document, order);
				System.out.println("📎 Orden clínica adjuntada.");
			}

			default -> System.out.println("❌ Opción inválida.");
			}
		} catch (Exception e) {
			System.out.println("⚠️ Error: " + e.getMessage());
		}
	}
}
