import java.util.Date;

/**
 * Abstraction of a patient.    
 */
public class Patient extends Person {
    private String patientId;
    private Date dateOfBirth;

    /**
     * Constructor of Patient.
     *
     * @param fullName the full name
     * @param cpf the cpf
     * @param address the address
     * @param mobilePhone the mobile phone
     * @param email the email
     * @param patientId the patient id
     * @param dateOfBirth the date of birth
     */
    public Patient(String fullName, String cpf, String address, String mobilePhone,
                    String email, String patientId, Date dateOfBirth) {
        super(fullName, cpf, address, mobilePhone, email);
        setPatientId(patientId);
        setDateOfBirth(dateOfBirth);
    }

    public String getPatientId() {
        return patientId;
    }

    /**
     * Set the patient id.
     *
     * @param patientId the patient id
     */
    public void setPatientId(String patientId) {
        if (!patientId.trim().matches("\\d{15}")) {
            throw new IllegalArgumentException("patientId must have 15 digits");
        }
        this.patientId = patientId;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }    
}
