/**
 * Semicircle class.
 */
public class SemiCirculo implements FormaGeometrica {
    private final Ponto centro;
    private final double raio;

    /**
     * Create an instance of SemiCirculo class.
     *
     * @param centro the central point
     * @param raio the radius
     */
    public SemiCirculo(Ponto centro, double raio) {
        this.centro = centro;
        this.raio = raio;
    }

    public Ponto getCentro() {
        return centro;
    }

    public double getRaio() {
        return raio;
    }

    @Override
    public double largura() {
        return raio * 2;
    }

    @Override
    public double altura() {
        return raio;
    }

    @Override
    public double area() {
        return Math.PI * raio * raio / 2;
    }

    @Override
    public double perimetro() {
        return Math.PI * raio + raio * 2;
    }
}
