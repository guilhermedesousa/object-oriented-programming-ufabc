import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentCSVReader {
    private final String fileName;
    public StudentCSVReader(String fileName, String separator) {
        this.fileName = fileName;
    }

    private int countStudents() {
        int qtyStudents = 0;

        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                qtyStudents++;
                scanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            System.err.println("Could not read the input file");
            e.printStackTrace();
        }

        return qtyStudents;
    }

    public Student[] readAll() {
        Student[] students = new Student[countStudents()];

        try (Scanner scanner = new Scanner(new File(fileName)) ) {
            for (int i = 0; i < students.length; i++) {
                students[i] = new Student(scanner.next(), scanner.next(), scanner.nextDouble());
            }
        } catch (FileNotFoundException e) {
            System.err.println("Could not read the input file");
            e.printStackTrace();
        } catch (InputMismatchException e) {
            System.err.println("Could not parse grade value");
            e.printStackTrace();
        }

        return students;
    }

    public static void main(String[] args) {
        StudentCSVReader reader = new StudentCSVReader("data/students.csv", " ");

        for (Student student: reader.readAll()) {
            System.out.println(student);
        }
    }
}
