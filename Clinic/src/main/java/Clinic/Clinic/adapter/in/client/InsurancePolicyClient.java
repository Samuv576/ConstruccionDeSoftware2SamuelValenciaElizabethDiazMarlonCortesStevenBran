package Clinic.Clinic.adapter.in.client;

import Clinic.Clinic.adapter.in.builder.InsurancePolicyBuilder;
import Clinic.Clinic.application.usecases.InsurancePolicyUseCase;
import Clinic.Clinic.domain.model.InsurancePolicy;
import org.springframework.stereotype.Component;
import java.util.Scanner;

@Component
public class InsurancePolicyClient {

	private final InsurancePolicyBuilder builder;
	private final InsurancePolicyUseCase useCase;

	public InsurancePolicyClient(InsurancePolicyBuilder builder, InsurancePolicyUseCase useCase) {
		this.builder = builder;
		this.useCase = useCase;
	}

	public void run() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("=== Gestión de Pólizas de Seguro ===");
		System.out.println("1. Registrar póliza");
		System.out.println("2. Validar póliza");
		System.out.println("3. Consultar póliza");
		System.out.println("4. Verificar vencimiento");
		System.out.print("Seleccione una opción: ");
		String option = scanner.nextLine();

		try {
			switch (option) {
			case "1" -> {
				System.out.print("Nombre de la compañía: ");
				String company = scanner.nextLine();
				System.out.print("Número de póliza: ");
				String number = scanner.nextLine();
				System.out.print("¿Está activa? (true/false): ");
				String active = scanner.nextLine();
				System.out.print("Fecha de vencimiento (yyyy-MM-dd): ");
				String endDate = scanner.nextLine();

				InsurancePolicy policy = builder.build(company, number, active, endDate);
				useCase.createPolicy(policy);
				System.out.println("✅ Póliza registrada exitosamente.");
			}

			case "2" -> {
				System.out.print("Número de póliza: ");
				String number = scanner.nextLine();
				boolean valid = useCase.validatePolicy(number);
				System.out.println(valid ? "✅ La póliza es válida." : "❌ La póliza no es válida.");
			}

			case "3" -> {
				System.out.print("Número de póliza: ");
				String number = scanner.nextLine();
				InsurancePolicy policy = useCase.findPolicyByNumber(number);
				System.out.println("📄 Póliza encontrada:");
				System.out.println("Compañía: " + policy.getCompanyName());
				System.out.println("Activa: " + policy.isActive());
				System.out.println("Vence: " + policy.getEndDate());
			}

			case "4" -> {
				System.out.print("Número de póliza: ");
				String number = scanner.nextLine();
				InsurancePolicy policy = useCase.findPolicyByNumber(number);
				boolean expired = useCase.isPolicyExpired(policy);
				System.out.println(expired ? "⚠️ La póliza está vencida." : "✅ La póliza está vigente.");
			}

			default -> System.out.println("❌ Opción inválida.");
			}
		} catch (Exception e) {
			System.out.println("⚠️ Error: " + e.getMessage());
		}
	}
}
