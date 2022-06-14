public class PrimitiveDataTypes {
    public static void main(String[] args) {
        byte byte_var = 0;            // 8-bit signed integer [-128, 127]
        char char_var = 0;            // 16-bit unsigned integer [0, 2^16-1]
        short short_var = 0;          // 16-bit signed integer [-2^15, 2^15-1]
        int int_var = 0;              // 32-bit signed integer [-2^31, 2^31-1]
        long long_var = 0L;           // 64-bit signed integer [-2^63, 2^63-1]

        float float_var = 0.0f;       // 32-bit floating point [6 to 7 decimal digits]
        double double_var = 0.0;      // 64-bit floating point [15 decimal digits]

        boolean boolean_var_1 = true; // true, false
        boolean boolean_var_2 = false;

        // protect against implicit lossy conversion
        int i1 = 256;
        short s1 = (short )i1;

        System.out.println(byte_var);
        System.out.println(char_var);
        System.out.println(short_var);
        System.out.println(int_var);
        System.out.println(long_var);

        System.out.println(float_var);
        System.out.println(double_var);

        System.out.println(boolean_var_1);
        System.out.println(boolean_var_2);

        System.out.println(i1);
        System.out.println(s1);
    }
}
