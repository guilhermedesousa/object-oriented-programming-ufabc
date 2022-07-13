import java.awt.Color;

public class ColorVisualizer {
    public static void main(String[] args) {
        if (args.length < 6) {
            throw new IllegalArgumentException("Usage: ColorVisualizer r1 g1 b1 r2 g2 b2");
        }

        StdDraw.setCanvasSize(800, 800);

        int r1 = Integer.parseInt(args[0]);
        int g1 = Integer.parseInt(args[1]);
        int b1 = Integer.parseInt(args[2]);

        int r2 = Integer.parseInt(args[3]);
        int g2 = Integer.parseInt(args[4]);
        int b2 = Integer.parseInt(args[5]);

        Color c1 = new Color(r1, g1, b1);
        Color c2 = new Color(r2, g2, b2);

        StdDraw.setPenColor(c1);
        StdDraw.filledSquare(0.25, 0.5, 0.2);

        StdDraw.setPenColor(c2);
        StdDraw.filledSquare(0.25, 0.5, 0.1);

        StdDraw.setPenColor(c2);
        StdDraw.filledSquare(0.75, 0.5, 0.2);
        
        StdDraw.setPenColor(c1);
        StdDraw.filledSquare(0.75, 0.5, 0.1);
    }
}
