/**
 * Polygon class.
 */
public abstract class Poligono implements FormaGeometrica {
    private final Ponto[] pontos;

    /**
     * Create an instance of Poligono class.
     *
     * @param pontos the array of points
     */
    public Poligono(Ponto[] pontos) {
        this.pontos = pontos;
    }

    public Ponto[] getPontos() {
        return pontos;
    }
}
