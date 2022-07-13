/**
 * Abstraction of a single resistor.
 */
public class Resistor extends Circuit {
    private final double resistance;

    /**
     * Constructor of the Resistor class.
     *
     * @param resistance the resistance
     */
    public Resistor(double resistance) {
        if (resistance < 0) {
            throw new IllegalArgumentException("Resistance must be positive.");
        }
        this.resistance = resistance;
    }

    @Override
    public double getResistance() {
        return resistance;
    }
}
