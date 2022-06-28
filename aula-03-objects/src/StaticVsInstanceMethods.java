import java.util.Arrays;

public class StaticVsInstanceMethods {
    public static void main(String[] args) {
        // static methods
        System.out.println(String.format("%.6f", Math.PI));
        System.out.println(String.join(" ", "Hello","World"));
        String pi = String.valueOf(Math.PI);
        System.out.println(pi);

        System.out.println();

        // instance methods
        String a = new String("e hoje eh");
        String b = new String("aula de POO");
        String c = new String("vamos comemorar");

        System.out.println(a.length());
        System.out.println(a.substring(2, 6));
        System.out.println(b.startsWith("aula"));
        System.out.println(a.indexOf("eh"));
        System.out.println(a.concat(b));
        System.out.println(c.replace("v", "V"));
        System.out.println(Arrays.toString(b.split(" ")));
        System.out.println(a.equals(b));

        System.out.println();

        // string is a special type with special sintax
        String a1 = "e hoje eh";
        String b1 = "aula de POO";
        String c1 = "vamos comemorar";
        String d = a1 + " " + b1 + " " + c1;

        System.out.println(d);
    }
}
