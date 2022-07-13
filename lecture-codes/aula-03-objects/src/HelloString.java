public class HelloString {
    public static void main(String[] args) {
        // declaration
        String s;

        // instantiation / creation
        s = new String("Hello, World!");

        // access the object API
        char c = s.charAt(4);

        System.out.println(c);

        System.out.println();

        String s1 = new String("Cat");
        System.out.println(System.identityHashCode(s1));
        String s2 = new String("Dog");
        System.out.println(System.identityHashCode(s2));
        String s3 = new String("Cat");
        System.out.println(System.identityHashCode(s3));
    }
}