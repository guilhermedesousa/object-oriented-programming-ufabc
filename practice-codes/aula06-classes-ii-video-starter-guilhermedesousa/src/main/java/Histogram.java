import java.util.Arrays;

/**
 * Histogram to count frequencies of integers between 0 and n-1.
 */
public class Histogram {
    private final int[] freqs;
    private int max;

    /**
     * Create a histogram with n positions
     * freqs[i] stores the frequency of the intensity i
     *
     * @param n the quantity of intensity values
     */
    public Histogram(int n) {
        freqs = new int[n];
        max = 0;
    }

    /**
     * Set the frequency of an intensity.
     *
     * @param i the intensity
     * @param frequency the frequency
     */
    public void setFrequency(int i, int frequency) {
        freqs[i] = frequency;
        if (frequency > max) {
            max = frequency;
        }
    }

    /**
     * Increment the frequency of and intensity.
     *
     * @param i the intensity
     */
    public void increment(int i) {
        freqs[i]++;
        if (freqs[i] > max) {
            max = freqs[i];
        }
    }

    public String toString() {
        return Arrays.toString(freqs);
    }

    public int getSize() {
        return freqs.length;
    }

    public int[] toArray() {
        return Arrays.copyOf(freqs, freqs.length);
    }

    private double[] toDoubleFreqs() {
        double[] aux = new double[freqs.length];

        for (int i = 0; i < aux.length; i++) {
            aux[i] = freqs[i];
        }

        return aux;
    }

    public void draw() {
        StdDraw.setYscale(-1, max + 1);
        StdStats.plotBars(toDoubleFreqs());
    }

    public static void main(String[] args) {
        Histogram histogram = new Histogram(10);

        for (int i = 0; i < histogram.getSize(); i++) {
            histogram.setFrequency(i, (int)(Math.random() * 100));
        }

        System.out.println(histogram);
        histogram.draw();
    }
}
