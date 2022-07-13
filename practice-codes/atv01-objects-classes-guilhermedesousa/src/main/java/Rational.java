/**
 * Abstraction of a immutable rational numbers
 */
public class Rational {
    private final int numerator;
    private final int denominator;

    /**
     * Constructor of the Rational class given numerator and denominator.
     *
     * @param numerator the numerator
     * @param denominator the denominator
     */
    public Rational(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    /**
     * Construct of the Rational class given a string rational.
     *
     * @param rational the rational
     */
    public Rational(String rational) {
        String[] rationalArr = rational.split("/");

        this.numerator = Integer.parseInt(rationalArr[0]);
        this.denominator = Integer.parseInt(rationalArr[1]);
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    @Override
    public String toString() {
        if (numerator < 0 && denominator < 0) {
            return String.format("%d/%d", Math.abs(numerator), Math.abs(denominator));
        } else if (numerator > 0 && denominator < 0) {
            return String.format("-%d/%d", numerator, Math.abs(denominator));
        }
        
        return String.format("%d/%d", numerator, denominator);
    }

    /**
     * Overload java internal equality semantics.
     *
     * @param o the other parameter
     * @return true if both are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Rational rational = (Rational) o;

        return this.isEqual(rational);
    }

    @Override
    public int hashCode() {
        return 0;
    }

    /**
     * Format a rational number to the right form.
     *
     * @param numerator the numerator
     * @param denominator the denominator
     * @return the formated rational number
     */
    private Rational formatRationalNumber(int numerator, int denominator) {
        if (numerator < 0 && denominator < 0) {
            return new Rational(Math.abs(numerator), Math.abs(denominator));
        } else if (numerator > 0 && denominator < 0) {
            return new Rational((-1) * numerator, Math.abs(denominator));
        }

        return new Rational(numerator, denominator);
    }

    /**
     * Calculate the least common mutiple between two numbers.
     *
     * @param a the first number
     * @param b the second number
     * @return the least common multiple
     */
    private int lmc(int a, int b) {
        int n = 2;
        int leastValue = 1;
        
        while (a != 1 || b != 1) {
            while (a % n != 0 && b % n != 0) {
                n++;
            }
            if (a % n == 0) {
                a = a / n;
            }
            if (b % n == 0) {
                b = b / n;
            }
            leastValue *= n;
        }
        return leastValue;
    }

    /**
     * Calculate the greast common divisor between two numbers.
     *
     * @param a the first number
     * @param b the second number
     * @return the greast common divisor
     */
    private String gcd(int numerator, int denominator) {
        int gcd = 1;

        for (int i = 1; i <= Math.abs(numerator) && i <= Math.abs(denominator); i++) {
            if (numerator % i == 0 && denominator % i == 0) {
                gcd = i;
            }
        }

        if (numerator == 0) {
            gcd = denominator;
        }

        if (denominator == 0) {
            gcd = numerator;
        }

        return String.format("%d/%d", numerator / gcd, denominator / gcd);
    }

    /**
     * Addition between two rational numbers.
     *
     * @param b the second rational number
     * @return the result of the addition
     */
    public Rational plus(Rational b) {
        return new Rational(plus(this.numerator, this.denominator, b.numerator, b.denominator));
    }

    public String plus(int numeratorA, int denominatorA, int numeratorB, int denominatorB) {
        Rational a2 = formatRationalNumber(numeratorA, denominatorA);
        Rational b2 = formatRationalNumber(numeratorB, denominatorB);

        int lmc = lmc(a2.denominator, b2.denominator);
        int operatorA = (lmc / a2.denominator) * a2.numerator;
        int operatorB = (lmc / b2.denominator) * b2.numerator;
        int numerator = operatorA + operatorB;
        
        return gcd(numerator, lmc);
    }

    /**
     * Subtraction between two rational numbers.
     *
     * @param b the second rational number
     * @return the result of the subtraction
     */
    public Rational minus(Rational b) {
        return new Rational(minus(this.numerator, this.denominator, b.numerator, b.denominator));
    }

    public String minus(int numeratorA, int denominatorA, int numeratorB, int denominatorB) {
        Rational a2 = formatRationalNumber(numeratorA, denominatorA);
        Rational b2 = formatRationalNumber(numeratorB, denominatorB);

        int lmc = lmc(a2.denominator, b2.denominator);
        int operatorA = (lmc / a2.denominator) * a2.numerator;
        int operatorB = (lmc / b2.denominator) * b2.numerator;
        int numerator = operatorA - operatorB;

        return gcd(numerator, lmc);
    }

    /**
     * Multiplication between two rational numbers.
     *
     * @param b the second rational number
     * @return the result of the multiplication
     */
    public Rational times(Rational b) {
        return new Rational(times(this.numerator, this.denominator, b.numerator, b.denominator));
    }

    public String times(int numeratorA, int denominatorA, int numeratorB, int denominatorB) {
        Rational a2 = formatRationalNumber(numeratorA, denominatorA);
        Rational b2 = formatRationalNumber(numeratorB, denominatorB);

        int numerator = a2.numerator * b2.numerator;
        int denominator = a2.denominator * b2.denominator;

        return gcd(numerator, denominator);
    }

    /**
     * Division between two rational numbers.
     *
     * @param b the second rational number
     * @return the result of the division
     */
    public Rational divides(Rational b) {
        return new Rational(divides(this.numerator, this.denominator, b.numerator, b.denominator));
    }

    public String divides(int numeratorA, int denominatorA, int numeratorB, int denominatorB) {
        Rational a2 = formatRationalNumber(numeratorA, denominatorA);
        Rational b2 = formatRationalNumber(numeratorB, denominatorB);

        int numerator = a2.numerator * b2.denominator;
        int denominator = a2.denominator * b2.numerator;

        return gcd(numerator, denominator);
    }

    /**
     * Equality between two rational numbers.
     *
     * @param b the second rational number
     * @return the result of the equality
     */
    public boolean isEqual(Rational b) {
        Rational a2 = formatRationalNumber(this.numerator, this.denominator);
        Rational b2 = formatRationalNumber(b.numerator, b.denominator);

        Rational c = new Rational(gcd(a2.numerator, a2.denominator));
        Rational d = new Rational(gcd(b2.numerator, b2.denominator));

        return c.numerator == d.numerator && c.denominator == d.denominator;
    }
}
