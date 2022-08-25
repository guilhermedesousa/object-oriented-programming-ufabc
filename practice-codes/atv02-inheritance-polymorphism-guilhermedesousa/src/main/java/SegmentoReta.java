import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Line segment class.
 */
public class SegmentoReta implements ObjetoGeometrico {
    private final Ponto p1;
    private final Ponto p2;

    /**
     * Create an instance of SegmentoReta class.
     *
     * @param p1 the first point
     * @param p2 the second point
     */
    public SegmentoReta(Ponto p1, Ponto p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Ponto getP1() {
        return p1;
    }

    public Ponto getP2() {
        return p2;
    }

    /**
     * Calculate the distance between two points.
     *
     * @return the distance value
     */
    public double comprimento() {
        double p1X = p1.getCoordX();
        double p1Y = p1.getCoordY();
        double p2X = p2.getCoordX();
        double p2Y = p2.getCoordY();

        return Math.sqrt((p2X - p1X) * (p2X - p1X) + (p2Y - p1Y) * (p2Y - p1Y));
    }

    /**
     * Check if a line segment is parallel to y axis.
     *
     * @param p1 the first point
     * @param p2 the second point
     * @return true if it is parallel, false otherwise
     */
    private boolean isParallelToYaxis(Ponto p1, Ponto p2) {
        return p1.getCoordX() == p2.getCoordX();
    }

    /**
     * Calculate the declive of a line segment.
     *
     * @return the declive value
     */
    public double coeficienteAngular() {
        if (isParallelToYaxis(p1, p2)) {
            return Double.POSITIVE_INFINITY;
        }

        double deltaY = p2.getCoordY() - p1.getCoordY();
        double deltaX = p2.getCoordX() - p1.getCoordX();

        BigDecimal coef = new BigDecimal(deltaY / deltaX);

        BigDecimal coef2 = coef.setScale(6, RoundingMode.HALF_UP);

        return coef2.doubleValue();
    }

    /**
     * Check if the current line segment is parallel to the other one.
     *
     * @param s the other line segment
     * @return true if it is parallel, false otherwise
     */
    public boolean paralelo(SegmentoReta s) {
        return coeficienteAngular() == s.coeficienteAngular();
    }
}
