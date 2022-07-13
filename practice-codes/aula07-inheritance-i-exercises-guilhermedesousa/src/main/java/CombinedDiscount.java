/**
 * Abstraction of a discount getting the max available discount.
 */
public class CombinedDiscount extends DiscountPolicy {
    private DiscountPolicy discount1;
    private DiscountPolicy discount2;

    /**
     * Create an instance from the params.
     *
     * @param qtyBuyed the quantity buyed
     * @param unitPrice the unit price
     * @param discount1 the first discount policy
     * @param discount2 the second discount policy
     */
    public CombinedDiscount(int qtyBuyed,
            double unitPrice, DiscountPolicy discount1,
            DiscountPolicy discount2) {
        super(qtyBuyed, unitPrice);
        setDiscount1(discount1);
        setDiscount2(discount2);
    }

    public DiscountPolicy getDiscount1() {
        return discount1;
    }

    public void setDiscount1(DiscountPolicy discount1) {
        this.discount1 = discount1;
    }

    public DiscountPolicy getDiscount2() {
        return discount2;
    }

    public void setDiscount2(DiscountPolicy discount2) {
        this.discount2 = discount2;
    }

    /**
     * Get the discount.
     *
     * @return the discount value.
     */
    @Override
    public double getDiscount() {
        double discountMethod1 = discount1.getDiscount();
        double discountMethod2 = discount2.getDiscount();

        if (discountMethod1 > discountMethod2) {
            return discountMethod1;
        }

        return discountMethod2;
    }

    @Override
    public double getFinalPrice() {
        return getFullPrice() - getDiscount();
    }
}
