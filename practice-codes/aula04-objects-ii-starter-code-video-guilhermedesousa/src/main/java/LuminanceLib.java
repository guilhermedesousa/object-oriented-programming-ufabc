import java.awt.Color;

public class LuminanceLib {
    public static double intensity(Color color) {
        int r = color.getRed();
        int g = color.getGreen();
        int b = color.getBlue();

        if (r == g && g == b) {
            return r;
        }

        return 0.299 * r + 0.587 * g + 0.114 * b;
    }

    public static Color toGray(Color color) {
        int y = (int )Math.round(intensity(color));

        return new Color(y, y, y);
    }

    public static void main(String[] args) {
        if (args.length < 3) {
            throw new IllegalArgumentException("Usage: LuminanceLib r g b");
        }

        int r = Integer.parseInt(args[0]);
        int g = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);

        Color c = new Color(r, g, b);

        System.out.println(intensity(c));
    }
}
