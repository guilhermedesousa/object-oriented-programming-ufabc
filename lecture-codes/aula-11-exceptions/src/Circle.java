public class Circle {
    private double coordX;
    private double coordY;
    private double radius;

    /**
     * Inner class.
     */
    public static class InvalidCoordinateException extends Exception {
        public InvalidCoordinateException(double coord) {
            super("Coordinate is out of range (must be in [0,1]): " + coord);
        }
    }

    public static class InvalidRadiusException extends Exception {
        public InvalidRadiusException(double radius) {
            super("Radius is out of range (must be > 0): " + radius);
        }
    }

    public Circle(double coordX, double coordY, double radius) throws InvalidCoordinateException, InvalidRadiusException {
        setCoordX(coordX);
        setCoordY(coordY);
        setRadius(radius);
    }

    public double getCoordX() {
        return coordX;
    }

    public void setCoordX(double coordX) throws InvalidCoordinateException {
        if (coordX < 0.0 || coordX > 1.0) {
            throw new InvalidCoordinateException(coordX);
        }
        this.coordX = coordX;
    }

    public double getCoordY() {
        return coordY;
    }

    public void setCoordY(double coordY) throws InvalidCoordinateException {
        if (coordY < 0.0 || coordY > 1.0) {
            throw new InvalidCoordinateException(coordY);
        }
        this.coordY = coordY;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) throws InvalidRadiusException {
        if (radius < 0.0) {
            throw new InvalidRadiusException(radius);
        }
        this.radius = radius;
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    public static void main(String[] args) {
        try {
            Circle c1 = new Circle(0.0, 0.0, 10.0);

            System.out.println(c1.area());
        } catch (InvalidCoordinateException e) {
            System.err.println("Impossible to create Circle with invalid coordinates");
            e.printStackTrace();
        } catch (InvalidRadiusException e) {
            System.err.println("Impossible to create Circle with invalid radius");
            e.printStackTrace();
        }

        try {
            Circle c2 = new Circle(-1.0, 0.0, 10.0);

            System.out.println(c2.area());
        } catch (InvalidCoordinateException | InvalidRadiusException e) {
            e.printStackTrace();
        }
    }
}