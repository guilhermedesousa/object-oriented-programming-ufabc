/**
 * Abstraction of a healt care plan.
 */
public class HealthCarePlan {
    private String name;
    private String regulatorCode;
    private double refundPercent;
    
    /**
     * Constructor of HealthCarePlan.
     *
     * @param name the name
     * @param regulatorCode the regulator code
     * @param refundPercent the refund percent
     */
    public HealthCarePlan(String name, String regulatorCode, double refundPercent) {
        setName(name);
        setRefundPercent(refundPercent);
        setRegulatorCode(regulatorCode);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegulatorCode() {
        return regulatorCode;
    }

    public void setRegulatorCode(String regulatorCode) {
        this.regulatorCode = regulatorCode;
    }

    public double getRefundPercent() {
        return refundPercent;
    }
    
    /**
     * Set the refund percent.
     *
     * @param refundPercent the refund percent
     */
    public void setRefundPercent(double refundPercent) {
        if (refundPercent < 0.0 || refundPercent > 1.0) {
            throw new IllegalArgumentException("refundPercent must be in [0.0,1.0]");
        }
        this.refundPercent = refundPercent;
    }
}
