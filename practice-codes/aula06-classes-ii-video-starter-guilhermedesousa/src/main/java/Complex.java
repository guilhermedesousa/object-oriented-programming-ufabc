public class Complex {
    private final double re;
    private final double imag;

    public Complex(double re, double imag) {
        this.re = re;
        this.imag = imag;
    }

    public Complex plus(Complex b) {
        double re = this.re + b.re;
        double imag = this.imag + b.imag;

        return new Complex(re, imag);
    }

    public Complex minus(Complex b) {
        double re = this.re - b.re;
        double imag = this.imag - b.imag;

        return new Complex(re, imag);
    }

    public Complex times(Complex b) {
        double re = this.re * b.re - this.imag * b.imag;
        double imag = this.imag * b.re + this.re * b.imag;

        return new Complex(re, imag);
    }

    public double abs() {
        return Math.sqrt(this.re * this.re + this.imag * this.imag);
    }

    public String toString() {
        return this.re + " + " + this.imag + "i";
    }

    public static void main(String[] args) {
        Complex a = new Complex(2.0, 3.0);
        Complex b = new Complex(4.0, 5.0);
        Complex c = a.plus(b);
        Complex d = a.times(b);

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(a.abs());
        System.out.println(b.abs());
        System.out.println(a.times(b).plus(c).plus(d).abs());
    }
}
