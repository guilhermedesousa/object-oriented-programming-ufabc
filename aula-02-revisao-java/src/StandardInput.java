import java.util.Scanner;

public class StandardInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        long b = scanner.nextLong();
        float c = scanner.nextFloat();
        double d = scanner.nextDouble();
        boolean e = scanner.nextBoolean();

        String s = scanner.next();

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(s);
    }
}