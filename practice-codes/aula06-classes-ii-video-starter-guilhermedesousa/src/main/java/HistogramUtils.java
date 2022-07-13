import java.awt.Color;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HistogramUtils {
    public static Histogram fromGrayscalePicture(Picture picture) {
        int width = picture.width();
        int height = picture.height();
        Histogram histogram = new Histogram(256);

        for (int col = 0; col < width; col++) {
            for (int row = 0; row < height; row++) {
                Color color = picture.get(col, row);

                histogram.increment(color.getRed());
            }
        }

        return histogram;
    }

    /**
     * Save hitogram to text file.
     *
     * @param histogram the histogram
     * @param path the path to the text file
     */
    public static void toFile(Histogram histogram, String path) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(path))) {
            int[] freqs = histogram.toArray();

            writer.write(freqs.length + "");
            writer.newLine();

            for (Integer freq : histogram.toArray()) {
                writer.write(freq.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Failed to create histogram file");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String id = "41033";
        Picture picture = new Picture(String.format("data/%s.jpg", id));
        Histogram histogram = HistogramUtils.fromGrayscalePicture(picture);

        System.out.println(histogram);
        histogram.draw();
        HistogramUtils.toFile(histogram, String.format("data/%s.txt", id));
    }
}
