import java.lang.reflect.Modifier;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test cases.
 */
public class AllTests {
    private static final double tolerance = 0.001d;
    private final List<DatasetUtils.BillingDto> cases;

    private static class ValidDoctor {

        public static final String name = "James Handler";
        public static final String cpf = "123.456.789-12";
        public static final String address = "Whatever street";
        public static final String mobilePhone = "(11)91234-5678";
        private static final String email = "whatever@email.com";
        private static final String specialty = "General Practice";
        private static final double officeVisitFee = 300.00;
    }

    private static class InvalidDoctor {

        public static final String name = "James";
        public static final String cpf = "12.456,789_12";
        public static final String address = "Whatever street";
        public static final String mobilePhone = "(11)9234-5678";
        private static final String email = "whatever@email.com";
        private static final String specialty = "General Practice";
        private static final double officeVisitFee = -300.00;
    }

    private static class ValidPatient {

        public static final String name = "James Handler";
        public static final String cpf = "123.456.789-12";
        public static final String address = "Whatever street";
        public static final String mobilePhone = "(11)91234-5678";
        private static final String email = "whatever@email.com";
        private static final String patientId = "123456789123456";
        private static final Date dateOfBirth = new Date();
    }

    private static class InvalidPatient {

        public static final String name = "James";
        public static final String cpf = "12.456,789_12";
        public static final String address = "Whatever street";
        public static final String mobilePhone = "(11)9234-5678";
        private static final String email = "whatever@email.com";
        private static final String patientId = "12345789a2345";
        private static final Date dateOfBirth = new Date();
    }

    private static class ValidHealthCarePlan {

        public static final double refundPercent = 0.3;
        public static final String regulatorCode = "1234";
        public static final String name = "Whatever Plan";
    }


    public AllTests() {
        cases = DatasetUtils.loadCases();
    }

    @Test
    public void testInheritance() {
        Assertions.assertTrue(Modifier.isAbstract(Person.class.getModifiers()),
            "Person should be abstract");
        Assertions.assertEquals(Doctor.class.getSuperclass(), Person.class,
            "Doctor shound inherit from Person");
        Assertions.assertEquals(Patient.class.getSuperclass(), Person.class,
            "Patient shound inherit from Person");
        Assertions.assertEquals(HealthCarePlan.class.getSuperclass(), Object.class,
            "HealthCarePlan should not explicitly inherit from any class");
        Assertions.assertEquals(Billing.class.getSuperclass(), Object.class,
            "HealthCarePlan should not explicitly inherit from any class");
    }

    @Test
    public void testBilling() {
        for (var singleCase : cases) {
            Assertions.assertEquals(singleCase.bill, singleCase.toBilling().getBill(),
                tolerance,
                "Bill value is wrong");
        }
    }

    @Test
    public void testDoctorProperties() {
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> new Doctor(InvalidDoctor.name, ValidDoctor.cpf, ValidDoctor.address,
                ValidDoctor.mobilePhone, ValidDoctor.email, ValidDoctor.specialty,
                ValidDoctor.officeVisitFee),
            "Doctor constructor should throw exception when receiving invalid name");
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> new Doctor(ValidDoctor.name, InvalidDoctor.cpf, ValidDoctor.address,
                ValidDoctor.mobilePhone, ValidDoctor.email, ValidDoctor.specialty,
                ValidDoctor.officeVisitFee),
            "Doctor constructor should throw exception when receiving invalid cpf");
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> new Doctor(ValidDoctor.name, ValidDoctor.cpf, ValidDoctor.address,
                InvalidDoctor.mobilePhone, ValidDoctor.email, ValidDoctor.specialty,
                ValidDoctor.officeVisitFee),
            "Doctor constructor should throw exception when receiving invalid phone");
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> new Doctor(ValidDoctor.name, ValidDoctor.cpf, ValidDoctor.address,
                ValidDoctor.mobilePhone, ValidDoctor.email, ValidDoctor.specialty,
                InvalidDoctor.officeVisitFee),
            "Doctor constructor should throw exception when receiving invalid fee");

        var doctor = new Doctor(ValidDoctor.name, ValidDoctor.cpf, ValidDoctor.address,
            ValidDoctor.mobilePhone, ValidDoctor.email, ValidDoctor.specialty,
            ValidDoctor.officeVisitFee);

        Assertions.assertThrows(IllegalArgumentException.class,
            () -> doctor.setFullName(InvalidDoctor.name),
            "Doctor should throw exception when setting invalid name value");
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> doctor.setCpf(InvalidDoctor.cpf),
            "Doctor should throw exception when setting invalid cpf value");
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> doctor.setMobilePhone(InvalidDoctor.mobilePhone),
            "Doctor should throw exception when setting invalid mobile phone value");
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> doctor.setOfficeVisitFee(InvalidDoctor.officeVisitFee),
            "Doctor should throw exception when setting invalid fee value");
    }

    @Test
    public void testPatientProperties() {
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> new Patient(InvalidPatient.name, ValidPatient.cpf, ValidPatient.address,
                ValidPatient.mobilePhone, ValidPatient.email, ValidPatient.patientId,
                ValidPatient.dateOfBirth),
            "Patient constructor should throw exception when receiving invalid name");
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> new Patient(ValidPatient.name, InvalidPatient.cpf, ValidPatient.address,
                ValidPatient.mobilePhone, ValidPatient.email, ValidPatient.patientId,
                ValidPatient.dateOfBirth),
            "Patient constructor should throw exception when receiving invalid cpf");
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> new Patient(ValidPatient.name, ValidPatient.cpf, ValidPatient.address,
                InvalidPatient.mobilePhone, ValidPatient.email, ValidPatient.patientId,
                ValidPatient.dateOfBirth),
            "Patient constructor should throw exception when receiving invalid mobile phone");
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> new Patient(ValidPatient.name, ValidPatient.cpf, ValidPatient.address,
                ValidPatient.mobilePhone, ValidPatient.email, InvalidPatient.patientId,
                ValidPatient.dateOfBirth),
            "Patient constructor should throw exception when receiving invalid patient id");

        var patient = new Patient(ValidPatient.name, ValidPatient.cpf, ValidPatient.address,
            ValidPatient.mobilePhone, ValidPatient.email, ValidPatient.patientId,
            ValidPatient.dateOfBirth);

        Assertions.assertThrows(IllegalArgumentException.class,
            () -> patient.setFullName(InvalidDoctor.name),
            "Patient should throw exception when setting invalid name value");
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> patient.setCpf(InvalidDoctor.cpf),
            "Patient should throw exception when setting invalid cpf value");
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> patient.setMobilePhone(InvalidDoctor.mobilePhone),
            "Patient should throw exception when setting invalid mobile phone value");
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> patient.setPatientId(InvalidPatient.patientId),
            "Patient should throw exception when setting invalid patient id");
    }

    @Test
    public void testHealthCarePlanProperties() {
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> new HealthCarePlan(ValidHealthCarePlan.name, ValidHealthCarePlan.regulatorCode,
                -0.3),
            "HealthCarePlan constructor should thrown an exception with an invalid refund percent");
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> new HealthCarePlan(ValidHealthCarePlan.name, ValidHealthCarePlan.regulatorCode,
                1.2),
            "HealthCarePlan constructor should thrown an exception with an invalid refund percent");

        var healthCarePlan = new HealthCarePlan(ValidHealthCarePlan.name,
            ValidHealthCarePlan.regulatorCode, 0.4);

        Assertions.assertThrows(IllegalArgumentException.class,
            () -> healthCarePlan.setRefundPercent(-0.3),
            "HealthCarePlan constructor should thrown an exception with an invalid refund percent");
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> healthCarePlan.setRefundPercent(1.2),
            "HealthCarePlan constructor should thrown an exception with an invalid refund percent");
    }
}
