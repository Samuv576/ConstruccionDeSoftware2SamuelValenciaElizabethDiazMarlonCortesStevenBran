package Clinic.Clinic;

import Clinic.Clinic.adapter.in.client.UserClient;
import Clinic.Clinic.adapter.in.client.AppointmentClient;
import Clinic.Clinic.adapter.in.client.ClinicalRecordClient;
import Clinic.Clinic.adapter.in.client.EmergencyContactClient;
import Clinic.Clinic.adapter.in.client.InsurancePolicyClient;
import Clinic.Clinic.adapter.in.client.InventoryItemClient;
import Clinic.Clinic.adapter.in.client.InvoiceClient;
import Clinic.Clinic.adapter.in.client.MedicalHistoryClient;
import Clinic.Clinic.adapter.in.client.ClinicalOrderClient;
import Clinic.Clinic.adapter.in.client.MedicalNoteClient;
import Clinic.Clinic.adapter.in.client.PatientClient; // ✅ Nuevo import
import Clinic.Clinic.adapter.in.client.SpecialistTypeClient; // ✅ Nuevo import
import Clinic.Clinic.adapter.in.client.VitalSignsClient; // ✅ Nuevo import



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class ClinicApplication implements CommandLineRunner {

    private final UserClient userClient;
    private final AppointmentClient appointmentClient;
    private final ClinicalRecordClient clinicalRecordClient;
    private final EmergencyContactClient emergencyContactClient;
    private final InsurancePolicyClient insurancePolicyClient;
    private final InventoryItemClient inventoryItemClient;
    private final InvoiceClient invoiceClient;
    private final MedicalHistoryClient medicalHistoryClient;
    private final ClinicalOrderClient clinicalOrderClient;
    private final MedicalNoteClient medicalNoteClient;
    private final PatientClient patientClient; // ✅ Nuevo campo
    private final SpecialistTypeClient specialistTypeClient; // ✅ Nuevo campo
    private final VitalSignsClient vitalSignsClient; // ✅ Nuevo campo



    @Autowired
    public ClinicApplication(
        UserClient userClient,
        AppointmentClient appointmentClient,
        ClinicalRecordClient clinicalRecordClient,
        EmergencyContactClient emergencyContactClient,
        InsurancePolicyClient insurancePolicyClient,
        InventoryItemClient inventoryItemClient,
        InvoiceClient invoiceClient,
        MedicalHistoryClient medicalHistoryClient,
        ClinicalOrderClient clinicalOrderClient,
        MedicalNoteClient medicalNoteClient,
        PatientClient patientClient,
        SpecialistTypeClient specialistTypeClient,
        VitalSignsClient vitalSignsClient // ✅ Nuevo parámetro
    ) {
        this.userClient = userClient;
        this.appointmentClient = appointmentClient;
        this.clinicalRecordClient = clinicalRecordClient;
        this.emergencyContactClient = emergencyContactClient;
        this.insurancePolicyClient = insurancePolicyClient;
        this.inventoryItemClient = inventoryItemClient;
        this.invoiceClient = invoiceClient;
        this.medicalHistoryClient = medicalHistoryClient;
        this.clinicalOrderClient = clinicalOrderClient;
        this.medicalNoteClient = medicalNoteClient;
        this.patientClient = patientClient;
        this.specialistTypeClient = specialistTypeClient;
        this.vitalSignsClient = vitalSignsClient;
    }

    public static void main(String[] args) {
        SpringApplication.run(ClinicApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Menú Principal ===");
        System.out.println("1. Gestión de Usuarios");
        System.out.println("2. Gestión de Citas Médicas");
        System.out.println("3. Gestión de Registro Clínico");
        System.out.println("4. Gestión de Contactos de Emergencia");
        System.out.println("5. Gestión de Pólizas de Seguro");
        System.out.println("6. Gestión de Inventario Clínico");
        System.out.println("7. Registro de Facturas Médicas");
        System.out.println("8. Gestión de Historial Médico");
        System.out.println("9. Gestión de Órdenes Clínicas");
        System.out.println("10. Gestión de Notas Médicas");
        System.out.println("11. Gestión de Pacientes"); // ✅ Nuevo ítem
        System.out.println("12. Gestión de Tipos de Especialista"); // ✅ Nuevo ítem
        System.out.println("13. Gestión de Signos Vitales"); // ✅ Nuevo ítem

        System.out.print("Seleccione una opción: ");
        String option = scanner.nextLine();

        switch (option) {
            case "1" -> userClient.run();
            case "2" -> appointmentClient.run();
            case "3" -> clinicalRecordClient.run();
            case "4" -> emergencyContactClient.run();
            case "5" -> insurancePolicyClient.run();
            case "6" -> inventoryItemClient.run();
            case "7" -> invoiceClient.run();
            case "8" -> medicalHistoryClient.run();
            case "9" -> clinicalOrderClient.run();
            case "10" -> medicalNoteClient.run();
            case "11" -> patientClient.run(); // ✅ Nuevo caso
            case "12" -> specialistTypeClient.run(); // ✅ Nuevo caso
            case "13" -> vitalSignsClient.run(); // ✅ Nuevo caso

            
            default -> System.out.println("❌ Opción inválida.");
        }
    }
}
