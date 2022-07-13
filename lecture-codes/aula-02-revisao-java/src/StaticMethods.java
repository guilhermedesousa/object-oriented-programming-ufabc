public class StaticMethods {
    public static long abs(long v) {
        return (v < 0) ? -v : v;
    }

    /**
     * Calcula a potencia de base b e expoente e,
     * ambos inteiros,
     * considerando expoente positivo
     * @param b base 
     * @param e expoente
     * @return b elevado a e
     */
    public static long power(long b, long e) {
        long p = 1;

        for (int i = 0; i < e; i++) {
            p *= b;
        }

        return p;
    }

    /**
     * Calcula a potencia de base b e expoente e,
     * ambos inteiros
     * @param b base
     * @param e expoente
     * @return b elevado a e
     */
    public static double power2(long b, long e) {
        if (b == 0 && e < 0) {
            throw new UnsupportedOperationException(
                "Zero raised to negative exponent is undefined"
            );
        }
        if (e >= 0) {
            return power(b, e);
        } else {
            return 1.0 / power(b, abs(e));
        }
    }

    public static void main(String[] args) {
        System.out.println(abs(-1));
        System.out.println(abs(1));
        System.out.println(abs(0));
        System.out.println();

        System.out.println(power(2, 3));
        System.out.println(power(10, 5));
        System.out.println(power(10, 0));
        System.out.println(power(0, 10));
        System.out.println(power(0, 0));
        System.out.println();

        System.out.println(power(-2, 3));
        System.out.println(power(2, -1));

        System.out.println();

        System.out.println(power2(2, -1));
        System.out.println(power2(2, -2));
        System.out.println(power2(10, -5));
        System.out.println(power2(0, -1));
    }
}
