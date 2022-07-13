/**
 * Abstraction of a doctor.
 */
public class Doctor extends Person {
    private String specialty;
    private double officeVisitFee;

    /**
     * Constructor of Doctor.
     *
     * @param fullName the full name
     * @param cpf the cpf
     * @param address the address
     * @param mobilePhone the mobile phone
     * @param email the email
     * @param specialty the specialty
     * @param officeVisitFee the office visit fee
     */
    public Doctor(String fullName, String cpf, String address, String mobilePhone,
                    String email, String specialty, double officeVisitFee) {
        super(fullName, cpf, address, mobilePhone, email);
        setSpecialty(specialty);
        setOfficeVisitFee(officeVisitFee);
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public double getOfficeVisitFee() {
        return officeVisitFee;
    }

    /**
     * Set the doctor's office visit fee.
     *
     * @param officeVisitFee the office visit fee
     */
    public void setOfficeVisitFee(double officeVisitFee) {
        if (officeVisitFee < 0.0) {
            throw new IllegalArgumentException("officeVisitFee must be a positive value");
        }
        this.officeVisitFee = officeVisitFee;
    }
}
