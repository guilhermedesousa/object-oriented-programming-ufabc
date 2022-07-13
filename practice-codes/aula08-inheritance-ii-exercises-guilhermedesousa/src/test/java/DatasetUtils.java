import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Utils for processing the dataset.
 */
public final class DatasetUtils {
    private static final String billingsFile = "src/test/resources/billings.json";

    private DatasetUtils() {

    }

    /**
     * Billing DTO.
     */
    public static class BillingDto {

        public DoctorDto doctor;
        public PatientDto patient;
        public HealthCarePlanDto healthCarePlan;
        public int hours;
        public double bill;

        public Billing toBilling() {
            return new Billing(doctor.toDoctor(), patient.toPatient(),
                healthCarePlan.toHealthCarePlan(), hours);
        }
    }

    /**
     * Doctor DTO.
     */
    public static class DoctorDto {

        public String fullName;
        public String cpf;
        public String address;
        public String mobilePhone;
        public String email;
        public String specialty;
        public double officeVisitFee;

        public Doctor toDoctor() {
            return new Doctor(fullName, cpf, address, mobilePhone, email, specialty,
                officeVisitFee);
        }
    }

    /**
     * Patient DTO.
     */
    public static class PatientDto {

        public String fullName;
        public String cpf;
        public String address;
        public String mobilePhone;
        public String email;
        public String patientId;
        public Date dateOfBirth;

        public Patient toPatient() {
            return new Patient(fullName, cpf, address, mobilePhone, email, patientId, dateOfBirth);
        }
    }

    /**
     * Healthcare plan DTO.
     */
    public static class HealthCarePlanDto {

        public double refundPercent;
        public String regulatorCode;
        public String name;

        public HealthCarePlan toHealthCarePlan() {
            return new HealthCarePlan(name, regulatorCode, refundPercent);
        }
    }

    /**
     * Load cases from file.
     *
     * @return a list of billing dtos
     */
    public static List<BillingDto> loadCases() {
        var mapper = new ObjectMapper();

        try {
            return mapper.readValue(new File(billingsFile),
                new TypeReference<>() {
                });
        } catch (IOException e) {
            throw new RuntimeException("Failed to open JSON file", e);
        }
    }

    /**
     * Show the billing values for a specific healthcare plan.
     *
     * @param code the healthcare plan code
     * @return the report of billings
     */
    public static String showBillingValuesForHealthCarePlan(String code) {
        var cases = loadCases();
        var builder = new StringBuilder();

        for (var singleCase : cases) {
            if (singleCase.healthCarePlan.regulatorCode.equals(code)) {
                builder.append(singleCase.bill).append("\n");
            }
        }

        return builder.toString();
    }

    /**
     * Show billings for a specific doctor.
     *
     * @param cpf the cpf
     * @return the report
     */
    public static String showBillingValuesForDoctor(String cpf) {
        var cases = loadCases();
        var builder = new StringBuilder();

        for (var singleCase : cases) {
            if (singleCase.doctor.cpf.equals(cpf)) {
                builder.append(singleCase.bill).append("\n");
            }
        }

        return builder.toString();
    }

    /**
     * The main method.
     *
     * @param args the args
     */
    public static void main(String[] args) {
        if (args.length < 2) {
            throw new IllegalArgumentException("Usage: DatasetUtils <plan|doctor> <code|cpf>");
        }

        if ("plan".equals(args[0])) {
            System.out.println(DatasetUtils.showBillingValuesForHealthCarePlan(args[1]));
        } else if ("doctor".equals(args[0])) {
            System.out.println(DatasetUtils.showBillingValuesForDoctor(args[1]));
        } else {
            throw new IllegalArgumentException("Unknown command: " + args[0]);
        }
    }
}
