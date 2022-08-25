/**
 * Circle class.
 */
public class Circulo extends Elipse {
    private final Ponto centro;
    private final double raio;

    /**
     * Create an instance of Circulo class.
     *
     * @param centro the central point
     * @param raio the radius
     */
    public Circulo(Ponto centro, double raio) {
        super(centro, raio, raio);
        this.centro = centro;

        if (raio < 0.0) {
            throw new IllegalArgumentException(String.format("Raio must be positive: %f", raio));
        }
        this.raio = raio;
    }

    @Override
    public Ponto getCentro() {
        return centro;
    }

    public double getRaio() {
        return raio;
    }

    @Override
    public double circunferencia() {
        return 2 * Math.PI * raio;
    }

    @Override
    public double largura() {
        return raio * 2;
    }

    @Override
    public double altura() {
        return raio * 2;
    }

    @Override
    public double area() {
        return Math.PI * raio * raio;
    }

    @Override
    public double perimetro() {
        return 2 * Math.PI * raio;
    }
}
