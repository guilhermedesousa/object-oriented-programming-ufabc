/**
 * Abstraction of a billing.
 */
public class Billing {
    private Doctor doctor;
    private Patient patient;
    private HealthCarePlan healthCarePlan;
    private int hours;

    /**
     * Construct of Billing.
     *
     * @param doctor the doctor
     * @param patient the patient
     * @param healthCarePlan the health care plan
     * @param hours the hours
     */
    public Billing(Doctor doctor, Patient patient, HealthCarePlan healthCarePlan, int hours) {
        setDoctor(doctor);
        setPatient(patient);
        setHealthCarePlan(healthCarePlan);
        setHours(hours);
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public HealthCarePlan getHealthCarePlan() {
        return healthCarePlan;
    }

    public void setHealthCarePlan(HealthCarePlan healthCarePlan) {
        this.healthCarePlan = healthCarePlan;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }
    
    /**
     * Get the bill.
     *
     * @return the bill
     */
    public double getBill() {
        double discount = hours * doctor.getOfficeVisitFee() * healthCarePlan.getRefundPercent();
        double finalValue = hours * doctor.getOfficeVisitFee() - discount;

        return Double.parseDouble(String.format("%.2f", finalValue));
    }
}
