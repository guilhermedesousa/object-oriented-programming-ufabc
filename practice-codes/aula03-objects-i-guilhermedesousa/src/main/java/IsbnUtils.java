/**
 * Utility library to work with ISBN codes.
 */
public final class IsbnUtils {
    private IsbnUtils() {

    }

    private static boolean isValidFormat(String isbn) {
        if (isbn.length() != 11) {
            return false;
        }

        for (var i = 0; i < 9; i++) {
            if (!Character.isDigit(isbn.charAt(i))) {
                return false;
            }
        }

        if (isbn.charAt(9) != '-') {
            return false;
        }

        return Character.isDigit(isbn.charAt(10)) || isbn.charAt(10) == 'X';
    }

    /**
     * Generate a ISBN check digit given the book identifier.
     *
     * @param identifier the book identifier
     * @return the check digit as a char
     */
    public static char genCheckDigit(String identifier) {
        if (identifier.length() < 9) {
            throw new IllegalArgumentException("Input code must have 9 digits");
        }

        var sum = 0;
        var coeff = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};

        for (var i = 0; i < coeff.length; i++) {
            sum += Character.getNumericValue(identifier.charAt(i)) * coeff[i];
        }

        if (sum % 11 > 9) {
            return 'X';
        }

        return Character.forDigit(sum % 11, 10);
    }

    /**
     * Extract the book identifier from the ISBN code.
     *
     * @param isbn the ISBN code
     * @return the book identifier
     */
    public static String extractId(String isbn) {
        return isbn.substring(0, 9);
    }

    /**
     * Extract the check digit from a ISBN code.
     *
     * @param isbn the ISBN code
     * @return the check digit
     */
    public static char extractCheckDigit(String isbn) {
        return isbn.charAt(isbn.length() - 1);
    }

    /**
     * Check if a ISBN code is valid.
     *
     * @param isbn the ISBN code
     * @return true if it is valid, false otherwise
     */
    public static boolean isValidIsbn(String isbn) {
        if (!isValidFormat(isbn)) {
            throw new IllegalArgumentException("Illegal ISBN");
        }

        return genCheckDigit(extractId(isbn)) == extractCheckDigit(isbn);
    }
}
