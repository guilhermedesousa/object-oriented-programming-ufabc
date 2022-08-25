/**
 * Quadrilateral class.
 */
public abstract class Quadrilatero extends Poligono {
    private final Ponto p1;
    private final Ponto p2;
    private final Ponto p3;
    private final Ponto p4;

    /**
     * Create an instance of Quadrilatero class.
     *
     * @param p1 the first point.
     * @param p2 the second point.
     * @param p3 the third point.
     * @param p4 the forth point.
     */
    public Quadrilatero(Ponto p1, Ponto p2, Ponto p3, Ponto p4) {
        super(new Ponto[] {p1, p2, p3, p4});
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
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

    public Ponto getP4() {
        return p4;
    }
}
