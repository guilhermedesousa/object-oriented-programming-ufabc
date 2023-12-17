public class Arrays {
    public static void main(String[] args) {
        // declaration
        double[] a;

        // memory allocation
        a = new double[10];
        
        for (int i = 0; i < a.length; i++) {
            a[i] = i + i / 10.0;
        }

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

        System.out.println();

        double[] b = {1.1, 1.2, 1.3, 1.4};

        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + " ");
        }

        System.out.println();

        // shallow copy (aliasing)
        double[] c = a;

        c[1] = 10.5;

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

        System.out.println();

        for (int i = 0; i < c.length; i++) {
            System.out.print(c[i] + " ");
        }

        System.out.println();
    }
}
