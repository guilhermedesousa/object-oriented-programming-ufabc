/**
 * Check if string is palindrome
 */
public class PalindromeChecker {
    static boolean isPalindrome(String s) {
        int n = s.length();

        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - i - 1)) {
                return false;
            }
        }

        return true;
    }
    public static void main(String[] args) {
        if (args.length < 1) {
            throw new IllegalArgumentException("Usage: PalindromeChecker <string>");
        }

        System.out.printf("%s palindrome\n", (isPalindrome(args[0]) ? "It is" : "It is not"));
    }
}
