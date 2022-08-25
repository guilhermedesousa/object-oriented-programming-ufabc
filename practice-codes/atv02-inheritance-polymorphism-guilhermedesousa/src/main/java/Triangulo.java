/**
 * Triangle class.
 */
public class Triangulo extends Poligono {
    private final Ponto p1;
    private final Ponto p2;
    private final Ponto p3;
    
    /**
     * Create an instance of Triangulo class.
     *
     * @param p1 the first point
     * @param p2 the second point
     * @param p3 the third point
     */
    public Triangulo(Ponto p1, Ponto p2, Ponto p3) {
        super(new Ponto[] {p1, p2, p3});
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    public Ponto getP1() {
        return p1;
    }

    public Ponto getP2() {
        return p2;
    }

    public Ponto getP3() {
        return p3;
    }

    @Override
    public double largura() {
        SegmentoReta base = new SegmentoReta(p3, p2);

        return base.comprimento();
    }

    @Override
    public double altura() {
        return p1.getCoordY() - p2.getCoordY();
    }

    @Override
    public double area() {
        return largura() * altura() / 2;
    }

    @Override
    public double perimetro() {
        SegmentoReta lado1 = new SegmentoReta(p1, p3);
        SegmentoReta lado2 = new SegmentoReta(p1, p2);
        SegmentoReta lado3 = new SegmentoReta(p3, p2);

        return lado1.comprimento() + lado2.comprimento() + lado3.comprimento();
    }
}
