/**
 * Parallelogram class.
 */
public class Paralelogramo extends Trapezio {
    private final Ponto p1;
    private final Ponto p2;
    private final Ponto p3;
    private final Ponto p4;

    /**
     * Create an instance of Paralelogramo class.
     *
     * @param p1 the first point
     * @param p2 the second point
     * @param p3 the third point
     * @param p4 the forth point
     */
    public Paralelogramo(Ponto p1, Ponto p2, Ponto p3, Ponto p4) {
        super(p1, p2, p3, p4);
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
    }

    /**
     * Check if the given points form a parallelogram.
     *
     * @param p1 the first point
     * @param p2 the second point
     * @param p3 the third point
     * @param p4 the forth point
     *
     * @return true if forms, false otherwise
     */
    public static boolean existe(Ponto p1, Ponto p2, Ponto p3, Ponto p4) {
        SegmentoReta segmento1 = new SegmentoReta(p1, p2);
        SegmentoReta segmento2 = new SegmentoReta(p1, p4);
        SegmentoReta segmento3 = new SegmentoReta(p4, p3);
        SegmentoReta segmento4 = new SegmentoReta(p2, p3);

        double coef1 = Math.round(segmento1.coeficienteAngular());
        double coef2 = Math.round(segmento2.coeficienteAngular());
        double coef3 = Math.round(segmento3.coeficienteAngular());
        double coef4 = Math.round(segmento4.coeficienteAngular());

        return coef1 == coef3 && coef2 == coef4;
    }

    @Override
    public double largura() {
        if (p3.getCoordX() >= p2.getCoordX()) {
            return p3.getCoordX() - p1.getCoordX();
        }

        return p2.getCoordX() - p4.getCoordX();
    }

    @Override
    public double altura() {
        return p1.getCoordY() - p4.getCoordY();
    }

    @Override
    public double area() {
        SegmentoReta segmento = new SegmentoReta(p1, p2);

        return segmento.comprimento() * altura();
    }

    @Override
    public double perimetro() {
        SegmentoReta segmento1 = new SegmentoReta(p1, p2);
        SegmentoReta segmento2 = new SegmentoReta(p1, p4);

        return 2 * (segmento1.comprimento() + segmento2.comprimento());
    }
}
