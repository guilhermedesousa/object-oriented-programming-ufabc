import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Modifier;
import java.util.Scanner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tests for discount hierarchy.
 */
public class DiscountTest {

    private static final String dataFile = "src/test/resources/discounts.txt";
    private static final double tolerance = 0.01;

    private static class Params {

        final int quantity;
        final double itemPrice;
        final int minimum;
        final double percent;
        final int valueOfN;

        public Params(Scanner scanner) {
            quantity = scanner.nextInt();
            itemPrice = scanner.nextDouble();
            minimum = scanner.nextInt();
            percent = scanner.nextDouble();
            valueOfN = scanner.nextInt();
        }

        @Override
        public String toString() {

            return "{"
                + "quantity = "
                + quantity + ", "
                + "itemPrice = "
                + String.format("%.2f", itemPrice) + ","
                + "minimum = "
                + minimum + ", "
                + "percent = "
                + percent + ", "
                + "n = "
                + valueOfN + ", "
                + "}";
        }
    }

    @Test
    public void testApi() {
        Assertions.assertTrue(Modifier.isAbstract(DiscountPolicy.class.getModifiers()),
            "DiscountPolicy should be abstract");

        // check getDiscount method
        var found = false;
        for (var method : DiscountPolicy.class.getMethods()) {
            if ("getDiscount".equals(method.getName())) {
                found = true;
                Assertions.assertTrue(Modifier.isAbstract(method.getModifiers()),
                    "Method getDiscount from DiscountPolicy should be abstract");
            }
        }
        if (!found) {
            Assertions.fail("Missing abstract method getDiscount in DiscountPolicy");
        }

        // check getFinalPrice method
        found = false;
        for (var method : DiscountPolicy.class.getMethods()) {
            if ("getFinalPrice".equals(method.getName())) {
                found = true;
                Assertions.assertTrue(Modifier.isAbstract(method.getModifiers()),
                    "Method getFinalPrice from DiscountPolicy should be abstract");
            }
        }
        if (!found) {
            Assertions.fail("Missing abstract method getFinalPrice in DiscountPolicy");
        }

        // check hierarchy
        Assertions.assertEquals(BulkDiscount.class.getSuperclass(), DiscountPolicy.class,
            "BulkDiscount should be derived from DiscountPolicy");
        Assertions.assertEquals(BuySomeItemsGetOneFree.class.getSuperclass(), DiscountPolicy.class,
            "BuyNItemsGetOneFree should be derived from DiscountPolicy");
        Assertions.assertEquals(CombinedDiscount.class.getSuperclass(), DiscountPolicy.class,
            "CombinedDiscount should be derived from DiscountPolicy");

    }

    @Test
    public void testAll() {
        try (var scanner = new Scanner(new File(dataFile))) {
            var params = new Params(scanner);

            testBulkDiscount(scanner, params);
            testBuySomeItemsGetOneFree(scanner, params);
            testCombinedDiscount(scanner, params);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void testBulkDiscount(Scanner scanner, Params params) {
        var fullPrice = scanner.nextDouble();
        var discount = scanner.nextDouble();
        var finalPrice = scanner.nextDouble();
        var bulkDiscount = new BulkDiscount(params.quantity, params.itemPrice,
            params.minimum, params.percent);

        Assertions.assertEquals(fullPrice, bulkDiscount.getFullPrice(), tolerance,
            "BulkDiscount: full price for is incorrect. " + params);
        Assertions.assertEquals(discount, bulkDiscount.getDiscount(), tolerance,
            "BulkDiscount: discount is incorrect" + params);
        Assertions.assertEquals(finalPrice, bulkDiscount.getFinalPrice(), tolerance,
            "BulkDiscount: final price is incorrect" + params);
    }

    private void testBuySomeItemsGetOneFree(Scanner scanner, Params params) {
        var fullPrice = scanner.nextDouble();
        var discount = scanner.nextDouble();
        var finalPrice = scanner.nextDouble();
        var buySomeItemsGetOneFree = new BuySomeItemsGetOneFree(params.quantity, params.itemPrice,
            params.valueOfN);

        Assertions.assertEquals(fullPrice, buySomeItemsGetOneFree.getFullPrice(), tolerance,
            "BuyNItemsGetOneFree: full price for is incorrect. " + params);
        Assertions.assertEquals(discount, buySomeItemsGetOneFree.getDiscount(), tolerance,
            "BuyNItemsGetOneFree: discount is incorrect" + params);
        Assertions.assertEquals(finalPrice, buySomeItemsGetOneFree.getFinalPrice(), tolerance,
            "BuyNItemsGetOneFree: final price is incorrect" + params);
    }

    private void testCombinedDiscount(Scanner scanner, Params params) {
        var fullPrice = scanner.nextDouble();
        var discount = scanner.nextDouble();
        var finalPrice = scanner.nextDouble();
        var firstPolicy = parsePolicy(scanner, params);
        var secondPolicy = parsePolicy(scanner, params);

        var combinedDiscount = new CombinedDiscount(params.quantity, params.itemPrice, firstPolicy,
            secondPolicy);

        Assertions.assertEquals(fullPrice, combinedDiscount.getFullPrice(), tolerance,
            "CombinedDiscount: full price for is incorrect. " + params + "policy1: "
                + firstPolicy.getClass().getName() + "policy2: " + secondPolicy.getClass()
                .getName());
        Assertions.assertEquals(discount, combinedDiscount.getDiscount(), tolerance,
            "CombinedDiscount: discount is incorrect" + params + "policy1: "
                + firstPolicy.getClass().getName() + "policy2: " + secondPolicy.getClass()
                .getName());
        Assertions.assertEquals(finalPrice, combinedDiscount.getFinalPrice(), tolerance,
            "CombinedDiscount: final price is incorrect" + params + "policy1: "
                + firstPolicy.getClass().getName() + "policy2: " + secondPolicy.getClass()
                .getName());
    }

    private DiscountPolicy parsePolicy(Scanner scanner, Params params) {
        var policyName = scanner.next();

        if ("BulkDiscount".equals(policyName)) {
            return new BulkDiscount(params.quantity, params.itemPrice,
                params.minimum, params.percent);
        } else if ("BuyNItemsGetOneFree".equals(policyName)) {
            return new BuySomeItemsGetOneFree(params.quantity, params.itemPrice, params.valueOfN);
        }

        throw new IllegalArgumentException("Unknown policy for compound discount: " + policyName);
    }


}
