import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.FileAlreadyExistsException;

public class FileWritingUtil {
    public static void main(String[] args) {
        File file = new File("data/notas.csv");

        try {
            if (file.exists()) {
                throw new FileAlreadyExistsException("I am not allowed to overwrite an existing file");
            }
        } catch (FileAlreadyExistsException e) {
            System.err.println("The file cannot be overwritten");
            e.printStackTrace();
            System.exit(1);
        }

        try (PrintWriter pw = new PrintWriter(file)) {
            String format = "%s %.3f\n";

            pw.printf(format, "Joao Silva", 10.0);
            pw.printf(format, "Mariana Ribeiro", 9.0);
            pw.printf(format, "Francisco Dornelles", 5.1);
            pw.printf(format, "Receba Ortega", 2.2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.err.println("Failed to create the file in order to write");
        }
    }
}
