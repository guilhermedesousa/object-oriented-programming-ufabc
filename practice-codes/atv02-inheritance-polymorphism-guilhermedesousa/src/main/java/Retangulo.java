/**
 * Rectangle class.
 */
public class Retangulo extends Paralelogramo {
    private final Ponto p1;
    private final Ponto p2;
    private final Ponto p3;
    private final Ponto p4;

    /**
     * Create an instance of Retangulo class.
     *
     * @param p1 the first point
     * @param p2 the second point
     * @param p3 the third point
     * @param p4 the forth point
     */
    public Retangulo(Ponto p1, Ponto p2, Ponto p3, Ponto p4) {
        super(p1, p2, p3, p4);
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
    }

    /**
     * Check if the given points form a rectangle.
     *
     * @param p1 the first point
     * @param p2 the second point
     * @param p3 the third point
     * @param p4 the forth point
     *
     * @return true if it forms, false otherwise
     */
    public static boolean existe(Ponto p1, Ponto p2, Ponto p3, Ponto p4) {
        if (p1.getCoordY() != p2.getCoordY()) {
            return false;
        }

        if (p1.getCoordX() != p4.getCoordX()) {
            return false;
        }

        if (p2.getCoordX() != p3.getCoordX()) {
            return false;
        }

        return p4.getCoordY() == p3.getCoordY();
    }

    /**
     * Check if it is a square.
     *
     * @return true if it is, false otherwise
     */
    public boolean quadrado() {
        if (!existe(p1, p2, p3, p4)) {
            return false;
        }

        double p1X = p1.getCoordX();
        double p1Y = p1.getCoordY();
        double p2X = p2.getCoordX();
        double p2Y = p2.getCoordY();
        double p3X = p3.getCoordX();
        double p3Y = p3.getCoordY();
        double p4X = p4.getCoordX();
        double p4Y = p4.getCoordY();

        double lado1 = Double.parseDouble(String.format("%.3f", Math.abs(p2X - p1X)));
        double lado2 = Double.parseDouble(String.format("%.3f", Math.abs(p2Y - p3Y)));
        double lado3 = Double.parseDouble(String.format("%.3f", Math.abs(p3X - p4X)));
        double lado4 = Double.parseDouble(String.format("%.3f", Math.abs(p1Y - p4Y)));

        if (lado2 != lado1) {
            return false;
        }

        if (lado3 != lado1) {
            return false;
        }

        return lado4 == lado1;
    }

    @Override
    public double largura() {
        return p2.getCoordX() - p1.getCoordX();
    }

    @Override
    public double altura() {
        if (p1.getCoordY() >= p4.getCoordY()) {
            return p1.getCoordY() - p4.getCoordY();
        }

        return p4.getCoordY() - p1.getCoordY();
    }

    @Override
    public double area() {
        return largura() * altura();
    }

    @Override
    public double perimetro() {
        return largura() * 2 + altura() * 2;
    }
}
