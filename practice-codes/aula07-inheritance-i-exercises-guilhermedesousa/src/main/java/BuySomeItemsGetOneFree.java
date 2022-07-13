/**
 * Abstraction of a discount for each n products buyed.
 */
public class BuySomeItemsGetOneFree extends DiscountPolicy {
    private int range;

    public BuySomeItemsGetOneFree(int qtyBuyed, double unitPrice, int range) {
        super(qtyBuyed, unitPrice);
        setRange(range);
    }

    public int getRange() {
        return range;
    }

    /**
     * Setter for the param range.
     *
     * @param range the range
     */
    public void setRange(int range) {
        if (range < 0) {
            throw new IllegalArgumentException("Range must be positive");
        }
        this.range = range;
    }

    /**
     * Get the discount.
     *
     * @return the discount value
     */
    @Override
    public double getDiscount() {
        int qtyBuyed = getQtyBuyed();
        double unitPrice = getUnitPrice();

        if (qtyBuyed < range) {
            return unitPrice * qtyBuyed;
        }

        return getFullPrice() - (unitPrice * (qtyBuyed - (qtyBuyed / range)));
    }

    @Override
    public double getFinalPrice() {
        return getFullPrice() - getDiscount();
    }
}
