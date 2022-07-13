import java.util.Random;

/**
 * Generate a random Isbn code.
 */
public final class IsbnGenerator {
    private IsbnGenerator() {

    }

    /**
     * Generate a random numeric code with the specified length.
     *
     * @param length the code length
     * @return the numeric code as a String
     */
    private static String genRandomCode(int length) {
        var builder = new StringBuilder();
        var random = new Random();

        for (int i = 0; i < length; i++) {
            builder.append(random.nextInt(10));
        }

        return builder.toString();
    }

    private static String genIsbn() {
        var partial = genRandomCode(9);

        return String.format("%s-%s", partial, IsbnUtils.genCheckDigit(partial));
    }

    /**
     * The main method.
     *
     * @param args the args
     */
    public static void main(String[] args) {
        System.out.println(genIsbn());
    }
}
