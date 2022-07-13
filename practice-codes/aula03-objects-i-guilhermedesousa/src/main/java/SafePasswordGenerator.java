import java.util.Random;
import java.util.Scanner;

/**
 * Generate a safe password with the given length.
 */
public final class SafePasswordGenerator {
    private SafePasswordGenerator() {

    }

    private static char randomChar() {
        String ascii = " !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ" 
            + "[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~";
        Random random = new Random();

        return ascii.charAt(random.nextInt(ascii.length()));
    }

    private static String genPassword(int size) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < size; i++) {
            builder.append(randomChar());
        }

        return builder.toString();
    }

    /**
     * The main method.
     *
     * @param args the args
     */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);) {
            System.out.println("Password length: ");

            var passwordSize = scanner.nextInt();
            var password = "";

            while (!SafePasswordChecker.isSafePassword(password)) {
                password = genPassword(passwordSize);
            }

            System.out.println(password);
        } catch (Exception e) {
            throw e;
        }
    }
}
