public class StringReferences {
    public static void main(String[] args) {
        String s1 = new String("String A");
        String s2 = new String("String A");

        // shallow equality
        System.out.println(s1 == s2);
        System.out.println();

        // deep equility
        System.out.println(s1.equals(s2));
        System.out.println(s2.equals(s1));
        System.out.println();

        // interning
        String s3 = "String B";
        String s4 = "String B";

        System.out.println(s3 == s4);
        System.out.println(s3.equals(s4));
    }
}
