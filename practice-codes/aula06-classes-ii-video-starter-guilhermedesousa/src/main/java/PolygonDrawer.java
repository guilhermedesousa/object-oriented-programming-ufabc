import java.security.cert.TrustAnchor;

public class PolygonDrawer {
    public static void main(String[] args) {
        if (args.length < 1) {
            throw new IllegalArgumentException("Usage: PolygonDrawer <nsides>");
        }

        var sides = Integer.parseInt(args[0]);
        var angle = 360.0 / sides;
        var sideLength = Math.sin(Math.PI / sides);
        var turtle = new TurtleGraphics(0.5, 0.0, angle / 2);

        StdDraw.setCanvasSize(600, 600);
        
        for (int i = 0; i < sides; i++) {
            turtle.goForward(sideLength);
            turtle.turnLeft(angle);
        }

        turtle.show();
    }
}
