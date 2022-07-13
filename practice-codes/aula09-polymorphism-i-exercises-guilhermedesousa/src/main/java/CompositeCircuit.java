/**
 * Abstraction of a composite circuit.
 */
public abstract class CompositeCircuit extends Circuit {
    private final Circuit[] circuits;

    /**
     * Constructor of the CompositeCircuit class.
     *
     * @param circuits the circuits
     */
    public CompositeCircuit(Circuit[] circuits) {
        this.circuits = circuits;
    }

    public Circuit[] getCircuits() {
        return circuits;
    }
}
