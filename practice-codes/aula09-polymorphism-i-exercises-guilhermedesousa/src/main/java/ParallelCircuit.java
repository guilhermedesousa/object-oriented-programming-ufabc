/**
 * Abstraction of a parallel circuit.
 */
public class ParallelCircuit extends CompositeCircuit {
    /**
     * Constructor of the ParallelCircuit class.
     *
     * @param circuits the circuits
     */
    public ParallelCircuit(Circuit[] circuits) {
        super(circuits);
    }

    @Override
    public double getResistance() {
        double totalResistance = 0.0;

        for (Circuit resistor : getCircuits()) {
            totalResistance += 1.0 / resistor.getResistance();
        }

        return 1.0 / totalResistance;
    }
}
