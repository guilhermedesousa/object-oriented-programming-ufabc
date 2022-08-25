/**
 * Ellipse class.
 */
public class Elipse implements FormaGeometrica {
    private Ponto centro;
    private double eixoSemiMenor;
    private double eixoSemiMaior;

    /**
     * Create an instance of Elpise class.
     *
     * @param centro the central point
     * @param semiEixoA the semi-horizontal axis
     * @param semiEixoB the semi-vertical axis
     */
    public Elipse(Ponto centro, double semiEixoA, double semiEixoB) {
        this.centro = centro;

        if (semiEixoA < 0.0) {
            throw new IllegalArgumentException(
                String.format("semiEixoA must be positive: %f", semiEixoA));
        }

        if (semiEixoB < 0.0) {
            throw new IllegalArgumentException(
                String.format("semiEixoB must be positive: %f", semiEixoB));
        }

        if (semiEixoA >= semiEixoB) {
            this.eixoSemiMaior = semiEixoA;
            this.eixoSemiMenor = semiEixoB;
        } else {
            this.eixoSemiMaior = semiEixoB;
            this.eixoSemiMenor = semiEixoA;
        }
    }

    public Ponto getCentro() {
        return centro;
    }

    public double getEixoSemiMenor() {
        return eixoSemiMenor;
    }

    public double getEixoSemiMaior() {
        return eixoSemiMaior;
    }

    /**
     * Calculate the circumference.
     *
     * @return the circumference value
     */
    public double circunferencia() {
        double a2 = eixoSemiMaior * eixoSemiMaior;
        double b2 = eixoSemiMenor * eixoSemiMenor;

        return 2 * Math.PI * Math.sqrt((a2 + b2) / 2);
    }

    @Override
    public double largura() {
        return eixoSemiMaior * 2;
    }

    @Override
    public double altura() {
        return eixoSemiMenor * 2;
    }

    @Override
    public double area() {
        return Math.PI * eixoSemiMenor * eixoSemiMaior;
    }

    @Override
    public double perimetro() {
        double a2 = eixoSemiMaior * eixoSemiMaior;
        double b2 = eixoSemiMenor * eixoSemiMenor;

        return 2 * Math.PI * Math.sqrt((a2 + b2) / 2);
    }
}
