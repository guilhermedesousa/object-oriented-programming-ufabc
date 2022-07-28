public class QuotientWithFlag {
    public static class BooleanFlag {
        public boolean value;
    }

    private static boolean isNumber(String s) {
        return s.matches("^\\d+$");
    }

    private static int divide(int a, int b, BooleanFlag status) {
        if (b == 0) {
            status.value = false;
            return 0;
        }
        status.value = true;

        return a / b;
    }
    
    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Missing operands. Cannot proceed");
        } else if (!isNumber(args[0]) || !isNumber(args[1])) {
            System.err.println("All args must be numbers");
        } else {
            int a = Integer.parseInt(args[0]);
            int b = Integer.parseInt(args[1]);
            BooleanFlag flag = new BooleanFlag();

            int c = divide(a, b, flag);

            if (flag.value) {
                System.out.printf("%d/%d = %d\n", a, b, c);
            } else {
                System.err.println("Divisor cannot be zero");
            }
        }
    }
}
