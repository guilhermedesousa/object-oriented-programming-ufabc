import java.util.Scanner;

/**
 * Check if a password is safe according to fixed criteria.
 */
public final class SafePasswordChecker {
    private SafePasswordChecker() {

    }

    /**
     * Check if the password has some digit.
     *
     * @param password the password
     * @return true if it has a digit, false otherwise
     */
    public static boolean hasDigit(String password) {
        for (var i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                return true;
            }
        }

        return false;
    }


    /**
     * Check if the password has some lowercase letter.
     *
     * @param password the password
     * @return true if it has a lowercase letter, false otherwise
     */
    public static boolean hasLowerCase(String password) {
        for (var i = 0; i < password.length(); i++) {
            if (Character.isLowerCase(password.charAt(i))) {
                return true;
            }
        }

        return false;
    }

    /**
     * Check if the password has some uppercase letter.
     *
     * @param password the password
     * @return true if it has a uppercase letter, false otherwise
     */
    public static boolean hasUpperCase(String password) {
        for (var i = 0; i < password.length(); i++) {
            if (Character.isUpperCase(password.charAt(i))) {
                return true;
            }
        }

        return false;
    }

    /**
     * Check if the password has some non alphanumeric.
     *
     * @param password the password
     * @return true if it has a non alphanumeric, false otherwise
     */
    public static boolean hasNonAlphanumeric(String password) {
        for (var i = 0; i < password.length(); i++) {
            var isAlphabetic = Character.isAlphabetic(password.charAt(i));
            var isDigit = Character.isDigit(password.charAt(i));

            if (!isAlphabetic && !isDigit) {
                return true;
            }
        }

        return false;
    }

    /**
     * Check if the password is safe.
     * Version that uses multi-pass strategy with helper methods.
     *
     * @param password the password
     * @return true if it is valid, false otherwise
     */
    public static boolean isSafePassword(String password) {
        if (password.length() < 8) {
            return false;
        }

        if (!hasDigit(password)) {
            return false;
        }

        if (!hasLowerCase(password)) {
            return false;
        }

        if (!hasUpperCase(password)) {
            return false;
        }

        return hasNonAlphanumeric(password);
    }

    /**
     * Check if the password is safe.
     * This version uses regular expressions.
     *
     * @param password the password
     * @return true if it is valid, false otherwise
     */
    public static boolean isSafePassword2(String password) {
        return password.length() >= 8
            && password.matches(".*\\d+.*")
            && password.matches(".*\\p{Lower}+.*")
            && password.matches(".*\\p{Upper}+.*")
            && password.matches(".*\\W+.*");
    }

    /**
     * The main method.
     *
     * @param args the args
     */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Password: ");
            var password = scanner.next();

            System.out.println(isSafePassword(password) ? "Safe" : "Not safe");
            System.out.println(isSafePassword2(password) ? "Safe" : "Not safe");
        } catch (Exception e) {
            throw e;
        }
    }
}
