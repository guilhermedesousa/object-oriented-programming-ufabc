/**
 * Trapezium class.
 */
public class Trapezio extends Quadrilatero {
    private final Ponto p1;
    private final Ponto p2;
    private final Ponto p3;
    private final Ponto p4;

    /**
     * Create an instance of Trapezio class.
     *
     * @param p1 the first point
     * @param p2 the second point
     * @param p3 the third point
     * @param p4 the forth point
     */
    public Trapezio(Ponto p1, Ponto p2, Ponto p3, Ponto p4) {
        super(p1, p2, p3, p4);
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
    }

    /**
     * Get the smallest line segment between two bases.
     *
     * @return the smallest line segment
     */
    public SegmentoReta baseMenor() {
        SegmentoReta baseSuperior = new SegmentoReta(p1, p2);
        SegmentoReta baseInferior = new SegmentoReta(p4, p3);

        if (baseSuperior.comprimento() <= baseInferior.comprimento()) {
            return baseSuperior;
        }

        return baseInferior;
    }

    /**
     * Get the biggest line segment between two bases.
     *
     * @return the biggest line segment
     */
    public SegmentoReta baseMaior() {
        SegmentoReta baseSuperior = new SegmentoReta(p1, p2);
        SegmentoReta baseInferior = new SegmentoReta(p4, p3);

        if (baseInferior.comprimento() >= baseSuperior.comprimento()) {
            return baseInferior;
        }

        return baseSuperior;
    }

    /**
     * Check if the given points form a trapezium.
     *
     * @param p1 the first point
     * @param p2 the second point
     * @param p3 the third point
     * @param p4 the forth point
     *
     * @return true if it forms, false otherwise
     */
    public static boolean existe(Ponto p1, Ponto p2, Ponto p3, Ponto p4) {
        SegmentoReta segmento1 = new SegmentoReta(p1, p2);
        SegmentoReta segmento2 = new SegmentoReta(p1, p4);

        if (segmento1.paralelo(new SegmentoReta(p4, p3))) {
            return true;
        }

        return segmento2.paralelo(new SegmentoReta(p3, p2));
    }

    @Override
    public double largura() {
        return baseMaior().comprimento();
    }

    @Override
    public double altura() {
        return p1.getCoordY() - p4.getCoordY();
    }

    @Override
    public double area() {
        double baseMenor = baseMenor().comprimento();
        double baseMaior = baseMaior().comprimento();
        double altura = altura();

        return ((baseMenor + baseMaior) * altura) / 2;
    }

    @Override
    public double perimetro() {
        SegmentoReta lado1 = new SegmentoReta(p1, p2);
        SegmentoReta lado2 = new SegmentoReta(p4, p3);
        SegmentoReta lado3 = new SegmentoReta(p1, p4);
        SegmentoReta lado4 = new SegmentoReta(p2, p3);

        double comprimento1 = lado1.comprimento() + lado2.comprimento();
        double comprimento2 = lado3.comprimento() + lado4.comprimento();

        return comprimento1 + comprimento2;
    }
}
