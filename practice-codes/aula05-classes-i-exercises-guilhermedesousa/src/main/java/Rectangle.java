/**
 * Abstraction of a rectangle with the central point, width and height.
 */
public class Rectangle {
    private final double xx;
    private final double yy;
    private final double width;
    private final double height;

    /**
     * Constructor of the object.
     *
     * @param xx the xx
     * @param yy the yy
     * @param width the width
     * @param height the height
     */
    public Rectangle(double xx, double yy, double width, double height) {
        this.xx = xx;
        this.yy = yy;
        this.width = width;
        this.height = height;
    }

    /**
     * Calculate the area of the rectangle.
     *
     * @return area of the rectangle
     */
    public double area() {
        return width * height;
    }

    /**
     * Calculare the perimeter of the rectangle.
     *
     * @return perimeter of the rectangle
     */
    public double perimeter() {
        return 2 * (width + height);
    }

    /**
     * Check if the current rectangle intersects with a given rectangle.
     *
     * @param rectangle the rectangle
     * @return true if it intersects, false otherwise
     */
    public boolean intersects(Rectangle rectangle) {
        double boundBottomB = rectangle.yy - (rectangle.height / 2);
        double boundTopA = this.yy + (this.height / 2);

        if (boundBottomB > boundTopA) {
            return false;
        }

        double boundLeftB = rectangle.xx - (rectangle.width / 2);
        double boundRightA = this.xx + (this.width / 2);

        if (boundLeftB > boundRightA) {
            return false;
        }

        double boundTopB = rectangle.yy + (rectangle.height / 2);
        double boundBottomA = this.yy - (this.height / 2);

        if (boundTopB < boundBottomA) {
            return false;
        }

        double boundRightB = rectangle.xx + (rectangle.width / 2);
        double boundLeftA = this.xx - (this.width / 2);      
      
        return boundRightB >= boundLeftA;
    }

    /**
     * Check if the current rectangle contains a given rectangle.
     *
     * @param rectangle the rectangle
     * @return true if it contains, false otherwise
     */
    public boolean contains(Rectangle rectangle) {
        double boundTopB = rectangle.yy + (rectangle.height / 2);
        double boundTopA = this.yy + (this.height / 2);

        if (boundTopB > boundTopA) {
            return false;
        }

        double boundRightB = rectangle.xx + (rectangle.width / 2);
        double boundRightA = this.xx + (this.width / 2);

        if (boundRightB > boundRightA) {
            return false;
        }

        double boundBottomB = rectangle.yy - (rectangle.height / 2);
        double boundBottomA = this.yy - (this.height / 2);

        if (boundBottomB < boundBottomA) {
            return false;
        }

        double boundLeftA = this.xx - (this.width / 2);
        double boundLeftB = rectangle.xx - (rectangle.width / 2);
        
        return boundLeftB >= boundLeftA;
    }
}
