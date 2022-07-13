public class TurtleGraphics {
    private double x, y;
    private double angle;

    public TurtleGraphics(double x0, double y0, double a0) {
        this.x = x0;
        this.y = y0;
        this.angle = a0;
    }

    public void turnLeft(double delta) {
        angle += delta;
    }

    public void goForward(double step) {
        double x = this.x;
        double y = this.y;

        this.x += step * Math.cos(Math.toRadians(this.angle));
        this.y += step * Math.sin(Math.toRadians(this.angle));

        StdDraw.line(x, y, this.x, this.y);
    }

    public void show() {
        StdDraw.show();
    }

    public static void main(String[] args) {
        double x0 = 0.5;
        double y0 = 0.0;
        double a0 = 60.0;
        double step = Math.sqrt(3)/2;

        TurtleGraphics turtleGraphics = new TurtleGraphics(x0, y0, a0);
        turtleGraphics.goForward(step);
        turtleGraphics.turnLeft(120.0);
        turtleGraphics.goForward(step);
        turtleGraphics.turnLeft(120.0);
        turtleGraphics.goForward(step);
        turtleGraphics.show();
    }
}
