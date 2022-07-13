import java.util.Scanner;

/**
 * Reverse all strings in an array of strings.
 */
public final class ReverseStrings {
    private static String reverse(String str) {
        var builder = new StringBuilder();

        for (var i = str.length() - 1; i >= 0; i--) {
            builder.append(str.charAt(i));
        }

        return builder.toString();
    }

    private static String[] reverse(String[] strArray) {
        var result = new String[strArray.length];

        for (var i = 0; i < result.length; i++) {
            result[i] = reverse(strArray[i]);
        }

        return result;
    }

    private static String[] loadArray() {
        var strArray = new String[0];

        try (var scanner = new Scanner(System.in);) {
            strArray = new String[scanner.nextInt()];

            for (int i = 0; i < strArray.length; i++) {
                strArray[i] = scanner.next();
            }
        } catch (Exception e) {
            throw e;
        }

        return strArray;
    }

    private static String toString(String[] strArray) {
        var builder = new StringBuilder();

        for (int i = 0; i < strArray.length; i++) {
            builder.append(String.format("%d\t%s\n", i, strArray[i]));
        }

        return builder.toString();
    }

    /**
     * The main method.
     *
     * @param args the args
     */
    public static void main(String[] args) {
        System.out.println(toString(reverse(loadArray())));
    }
}
