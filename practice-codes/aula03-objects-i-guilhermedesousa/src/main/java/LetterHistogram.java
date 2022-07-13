import java.util.Scanner;

/**
 * Build a letter histogram given a text in ASCII format.
 */
public final class LetterHistogram {
    private static final String ascii = " !\"#$%&'()*+,-./0123456789:;<=>?@" 
        + "ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~";
    
    private LetterHistogram() {

    }

    private static int[] buildHistogram(String s) {
        var histogram = new int[ascii.length()];

        for (var i = 0; i < s.length(); i++) {
            var pos = ascii.indexOf(s.charAt(i));

            if (pos >= 0) {
                histogram[pos]++;
            }
        }

        return histogram;
    }

    private static String loadText() {
        var builder = new StringBuilder();

        try (var scanner = new Scanner(System.in);) {
            scanner.useDelimiter("\n");
            while (scanner.hasNext()) {
                builder.append(scanner.next());
            }
        } catch (Exception e) {
            throw e;
        }

        return builder.toString();
    }

    private static String formatHistogram(int[] histogram) {
        if (histogram.length != ascii.length()) {
            throw new IllegalArgumentException("Invalid histogram size");
        }

        var builder = new StringBuilder();

        for (var i = 0; i < ascii.length(); i++) {
            if (histogram[i] > 0) {
                builder.append(String.format("%s\t%d\n", ascii.charAt(i), histogram[i]));
            }
        }

        return builder.toString();
    }

    /**
     * The main method.
     *
     * @param args the args
     */
    public static void main(String[] args) {
        System.out.println(formatHistogram(buildHistogram(loadText())));
    }
}
