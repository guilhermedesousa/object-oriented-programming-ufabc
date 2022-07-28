import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FileReadingUtil {

    public static class FilePermissionException extends IOException {
        public FilePermissionException(String message, File file) {
            super(message + ": " + file);
        }
    }

    public static void main(String[] args) {
        File file = new File("data/notas.csv");

        try {
            if (!file.exists()) {
                throw new FileNotFoundException("Cannot find file " + file.getName());
            }
            if (!file.canRead()) {
                throw new FilePermissionException("Cannot read file", file);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Check if the file is in the directory. Absolute path: " + file.getAbsolutePath());
            e.printStackTrace();
            System.exit(1);
        } catch (FilePermissionException e) {
            System.err.println("Failed to read the file");
            e.printStackTrace();
            System.exit(1);
        }

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                System.out.printf("%s %s %.3f\n", scanner.next(), scanner.next(), scanner.nextDouble());
            }
        } catch (FileNotFoundException e) {
            System.err.println("Failed to open the file for reading");
            e.printStackTrace();
        } catch (InputMismatchException e) {
            System.err.println("Failed to convert input data");
            e.printStackTrace();
        }
    }
}
