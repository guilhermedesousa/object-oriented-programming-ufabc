import java.util.InputMismatchException;
import java.util.Scanner;

public class ReadCircleManualClose {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("x: ");
            double x = scanner.nextDouble();
            System.out.print("y: ");
            double y = scanner.nextDouble();
            System.out.print("radius: ");
            double radius = scanner.nextDouble();

            Circle c = new Circle(x, y, radius);

            System.out.printf("Area: %.3f\n", c.area());
        } catch (Circle.InvalidCoordinateException | Circle.InvalidRadiusException | InputMismatchException e) {
            e.printStackTrace();
        }
        System.out.println("Program ended successfuly");
    }
}
