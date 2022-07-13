public class MethodOverload {
    public static int abs(int v) {
        System.out.println("int version");
        return (v < 0) ? -v : v;
    }

    public static long abs(long v) {
        System.out.println("long version");
        return (v < 0) ? -v : v;
    }

    public static short abs(short v) {
        System.out.println("short version");
        return (v < 0) ? (short )-v : v;
    }

    public static double abs(double v) {
        System.out.println("double version");
        return (v < 0) ? -v : v;
    }

    public static float abs(float v) {
        System.out.println("float version");
        return (v < 0) ? -v : v;
    }
    public static void main(String[] args) {
        System.out.println(abs(-1));
        System.out.println(abs(-1L));
        System.out.println(abs((short )-1));
        System.out.println(abs(-1.0));
        System.out.println(abs(-1.0f));
    }
}
