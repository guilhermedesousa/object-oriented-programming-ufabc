/**
 * Abstraction of a bulk discount.
 */
public class BulkDiscount extends DiscountPolicy {
    private int minQty;
    private double discountPercentage;

    /**
     * Create an instance from the params.
     *
     * @param qtyBuyed the quantity buyed
     * @param unitPrice the unit price
     * @param minQty the minimal quantity to apply the discount
     * @param discountPercentage the discount percentage
     */
    public BulkDiscount(int qtyBuyed, double unitPrice, int minQty, double discountPercentage) {
        super(qtyBuyed, unitPrice);
        setMinQty(minQty);
        setDiscountPercentage(discountPercentage);
    }

    public int getMinQty() {
        return minQty;
    }

    /**
     * Setter for the minimal quantity.
     *
     * @param minQty the minimal quantity
     */
    public void setMinQty(int minQty) {
        if (minQty < 0) {
            throw new IllegalArgumentException("Minimal quantity must be positive");
        }
        this.minQty = minQty;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    /**
     * Setter for the discount percentage.
     *
     * @param discountPercentage the percentage
     */
    public void setDiscountPercentage(double discountPercentage) {
        if (discountPercentage < 0.0 || discountPercentage > 1.0) {
            throw new IllegalArgumentException("Discount percentage must be in [0.0, 1.0]");
        }
        this.discountPercentage = discountPercentage;
    }

    /**
     * Get the discount value.
     *
     * @return the discount value
     */
    @Override
    public double getDiscount() {
        if (getQtyBuyed() >= this.minQty) {
            return getFullPrice() * discountPercentage;
        }
        
        return 0.0;
    }

    @Override
    public double getFinalPrice() {
        return getFullPrice() - getDiscount();
    }
}
