public class QuotientWithSelections {
    private static boolean isNumber(String s) {
        return s.matches("^\\d+$");
    }
    
    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Missing operands. Cannot proceed");
        } else if (!isNumber(args[0]) || !isNumber(args[1])) {
            System.err.println("All args must be numbers");
        } else {
            int a = Integer.parseInt(args[0]);
            int b = Integer.parseInt(args[1]);

            if (b == 0) {
                System.err.println("Divisor cannot be zero");
            } else {
                System.out.printf("%d/%d = %d\n", a, b, a/b);
            }
        }
    }
}
