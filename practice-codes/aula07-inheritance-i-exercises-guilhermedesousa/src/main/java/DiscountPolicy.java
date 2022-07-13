/**
 * Abstraction of a discount policy.
 */
public abstract class DiscountPolicy {
    private int qtyBuyed;
    private double unitPrice;

    /**
     * Constructor.
     *
     * @param qtyBuyed the quantity buyed
     * @param unitPrice the unit price
     */
    public DiscountPolicy(int qtyBuyed, double unitPrice) {
        setQtyBuyed(qtyBuyed);
        setUnitPrice(unitPrice);
    }

    public int getQtyBuyed() {
        return qtyBuyed;
    }

    /**
     * Setter for the quantity buyed.
     *
     * @param qtyBuyed the quantity buyed
     */
    public void setQtyBuyed(int qtyBuyed) {
        if (qtyBuyed < 0) {
            throw new IllegalArgumentException("Quantity buyed must be positive");
        }
        this.qtyBuyed = qtyBuyed;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    /**
     * Setter for the unity price.
     *
     * @param unitPrice the unit price
     */
    public void setUnitPrice(double unitPrice) {
        if (unitPrice < 0.0) {
            throw new IllegalArgumentException("Unit price must be positive");
        }
        this.unitPrice = unitPrice;
    } 

    /**
     * Calculate the discount of an order.
     *
     * @return the discount value
     */
    public abstract double getDiscount();

    /**
     * Calculate the full price of an order.
     *
     * @return the full price
     */
    public double getFullPrice() {
        return qtyBuyed * unitPrice;
    }

    /**
     * Get the final price after the applied discount.
     *
     * @return the final price to pay
     */
    public abstract double getFinalPrice();
}
