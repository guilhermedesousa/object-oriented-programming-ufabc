import java.util.Scanner;

/**
 * Check if a ISBN code is valid.
 */
public final class IsbnChecker {
    private IsbnChecker() {

    }

    /**
     * The main method.
     *
     * @param args the args
     */
    public static void main(String[] args) {
        try (var scanner = new Scanner(System.in)) {
            var isbn = scanner.next();

            scanner.close();
            System.out.println(IsbnUtils.isValidIsbn(isbn) ? "Valid" : "Invalid");
        } catch (Exception e) {
            throw e;
        }
    }
}
