package Clinic.Clinic.adapter.in.client;

import Clinic.Clinic.adapter.in.builder.UserBuilder;
import Clinic.Clinic.application.usecases.UserUseCase;
import Clinic.Clinic.domain.model.User;
import Clinic.Clinic.domain.model.enums.Role;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class UserClient {

	private final UserBuilder builder;
	private final UserUseCase useCase;

	public UserClient(UserBuilder builder, UserUseCase useCase) {
		this.builder = builder;
		this.useCase = useCase;
	}

	public void run() {
		Scanner scanner = new Scanner(System.in);
		boolean running = true;
		while (running) {
			System.out.println("=== Gestión de Usuarios ===");
			System.out.println("1. Crear usuario");
			System.out.println("2. Buscar por username");
			System.out.println("3. Buscar por documento");
			System.out.println("4. Actualizar contraseña");
			System.out.println("5. Asignar rol");
			System.out.println("6. Eliminar usuario");
			System.out.println("0. Salir");
			System.out.print("Seleccione una opción: ");
			String option = scanner.nextLine();

			try {
				switch (option) {
					case "1" -> {
						boolean firstUser = useCase.isEmpty();
						User creator = null;

						if (!firstUser) {
							System.out.print("Documento del creador: ");
							String creatorDoc = scanner.nextLine();
							creator = useCase.findUserByDocument(creatorDoc);
						}

						System.out.print("ID: ");
						String id = scanner.nextLine();
						System.out.print("Username: ");
						String username = scanner.nextLine();
						System.out.print("Password: ");
						String password = scanner.nextLine();
						System.out.print("Email: ");
						String email = scanner.nextLine();
						System.out.print("Role (ADMIN, DOCTOR, NURSE, SUPPORT, HRSTAFF, PATIENT): ");
						String role = scanner.nextLine();
						System.out.print("Fecha de nacimiento (yyyy-MM-dd): ");
						String dob = scanner.nextLine();

						User userToCreate = builder.build(id, username, password, email, role, dob);
						useCase.createUser(userToCreate, creator);
						System.out.println("✅ Usuario creado exitosamente.");
					}

					case "2" -> {
						System.out.print("Username: ");
						String username = scanner.nextLine();
						User user = useCase.findUserByUsername(username);
						System.out.println("👤 Usuario encontrado: " + user.getUsername() + " (" + user.getRole() + ")");
					}

					case "3" -> {
						System.out.print("Documento: ");
						String doc = scanner.nextLine();
						User user = useCase.findUserByDocument(doc);
						System.out.println("👤 Usuario encontrado: " + user.getUsername() + " (" + user.getRole() + ")");
					}

					case "4" -> {
						System.out.print("Documento: ");
						String doc = scanner.nextLine();
						System.out.print("Nueva contraseña: ");
						String newPass = scanner.nextLine();
						User user = new User();
						user.setId(Long.parseLong(doc));
						useCase.updateUserPassword(user, newPass);
						System.out.println("🔐 Contraseña actualizada.");
					}

					case "5" -> {
						System.out.print("Documento: ");
						String doc = scanner.nextLine();
						System.out.print("Nuevo rol: ");
						String roleStr = scanner.nextLine();
						Role role = Role.valueOf(roleStr.toUpperCase());
						User user = new User();
						user.setId(Long.parseLong(doc));
						useCase.assignUserRole(user, role);
						System.out.println("🛡️ Rol asignado correctamente.");
					}

					case "6" -> {
						System.out.print("Documento: ");
						String doc = scanner.nextLine();
						User user = new User();
						user.setId(Long.parseLong(doc));
						useCase.deleteUser(user);
						System.out.println("🗑️ Usuario eliminado.");
					}

					case "0" -> {
						running = false;
						System.out.println("Saliendo de gestión de usuarios...");
					}

					default -> System.out.println("❌ Opción inválida.");
				}
			} catch (Exception e) {
				System.out.println("⚠️ Error: " + e.getMessage());
			}
		}
		//scanner.close(); // No cerrar aquí si se usa en otros menús
	}
}
