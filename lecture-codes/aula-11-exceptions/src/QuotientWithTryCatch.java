public class QuotientWithTryCatch {
    public static int divide(int a, int b) throws ArithmeticException {
        return a / b;
    }

    public static void main(String[] args) {
        try {
            if (args.length < 2) {
                throw new IllegalArgumentException("Usage: QuotientWithTryCatch <dividend> <divisor>");
            }

            int a = Integer.parseInt(args[0]);
            int b = Integer.parseInt(args[1]);
            int c = divide(a, b);

            System.out.printf("%d/%d = %d\n", a, b, c);
        } catch (NumberFormatException e) {
            System.err.println("We could not convert one or both of the arguments.");
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.err.println("We did not receive enough arguments. See usage.");
            e.printStackTrace();
        } catch (ArithmeticException e) {
            System.err.println("Divisor cannot be zero.");
            e.printStackTrace();
        } finally {
            System.out.println("I always execute");
        }
        System.out.println("Program flow reached here");
    }
}
