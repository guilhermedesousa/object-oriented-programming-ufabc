/**
 * Abstraction of a serial circuit.
 */
public class SerialCircuit extends CompositeCircuit {
    /**
     * Constructor of the SerialCircuit class.
     *
     * @param circuits the circuits
     */
    public SerialCircuit(Circuit[] circuits) {
        super(circuits);
    }

    @Override
    public double getResistance() {
        double totalResistance = 0.0;

        for (Circuit resistor : getCircuits()) {
            totalResistance += resistor.getResistance();
        }

        return totalResistance;
    }
}
