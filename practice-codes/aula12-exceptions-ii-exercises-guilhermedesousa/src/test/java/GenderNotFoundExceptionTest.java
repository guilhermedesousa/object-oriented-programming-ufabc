import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test whether GenderNotFoundException is thrown at the proper places.
 */
public class GenderNotFoundExceptionTest extends GenericExceptionTest {

    private static final Class<GenderNotFoundException> exception = GenderNotFoundException.class;
    private static final int ranking = 1;
    private static final int year = 2001;
    private static final String[] names = new String[]{"Jacob", "Jacob", "Emily", "Emily"};
    private static final char[] validGenders = new char[]{'m', 'M', 'f', 'F'};
    private static final char[] invalidGenders = new char[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11,
        12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34,
        35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57,
        58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81,
        82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 103, 104,
        105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122,
        123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140,
        141, 142, 143, 144, 145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158,
        159, 160, 161, 162, 163, 164, 165, 166, 167, 168, 169, 170, 171, 172, 173, 174, 175, 176,
        177, 178, 179, 180, 181, 182, 183, 184, 185, 186, 187, 188, 189, 190, 191, 192, 193, 194,
        195, 196, 197, 198, 199, 200, 201, 202, 203, 204, 205, 206, 207, 208, 209, 210, 211, 212,
        213, 214, 215, 216, 217, 218, 219, 220, 221, 222, 223, 224, 225, 226, 227, 228, 229, 230,
        231, 232, 233, 234, 235, 236, 237, 238, 239, 240, 241, 242, 243, 244, 245, 246, 247, 248,
        249, 250, 251, 252, 253, 254, 255
    };

    @Test
    public void doesNotThrowAtGetName() {
        for (var gender : validGenders) {
            Assertions.assertDoesNotThrow(
                () -> namesPopularity.getName(year, gender, ranking),
                buildDoesNotThrowMessage(year, gender, ranking));
        }
    }

    @Test
    public void throwsAtGetName() {
        for (int i = 0; i < 256; i++) {
            final char gender = (char) i;
            if (Character.toUpperCase(gender) != 'M' && Character.toUpperCase(gender) != 'F') {
                Assertions.assertThrows(exception,
                    () -> namesPopularity.getName(year, gender, ranking),
                    buildThrowsMessage(exception.getName(), year, gender, ranking));
            }
        }
    }

    @Test
    public void doesNotThrowAtGetRanking() {
        for (var i = 0; i < validGenders.length; i++) {
            final var pos = i;
            Assertions.assertDoesNotThrow(
                () -> namesPopularity.getRanking(year, validGenders[pos], names[pos]),
                buildDoesNotThrowMessage(year, validGenders[pos], names[pos]));
        }
    }

    @Test
    public void throwsAtGetRanking() {
        for (var i = 0; i < validGenders.length; i++) {
            final var pos = i;
            if (Character.toUpperCase(validGenders[pos]) != 'M'
                && Character.toUpperCase(validGenders[pos]) != 'F') {
                Assertions.assertThrows(exception,
                    () -> namesPopularity.getRanking(year, validGenders[pos], names[pos]),
                    buildThrowsMessage(exception.getName(), year, validGenders[pos], names[pos]));
            }
        }
    }

    @Test
    public void throwsAtGetCount() {
        for (var i = 0; i < validGenders.length; i++) {
            final var pos = i;
            if (Character.toUpperCase(validGenders[pos]) != 'M'
                && Character.toUpperCase(validGenders[pos]) != 'F') {
                Assertions.assertThrows(exception,
                    () -> namesPopularity.getCount(year, validGenders[pos], names[pos]),
                    buildThrowsMessage(exception.getName(), year, validGenders[pos], names[pos]));
            }
        }
    }

    @Test
    public void doesNotThrowAtGetCount() {
        for (var i = 0; i < validGenders.length; i++) {
            final var pos = i;

            Assertions.assertDoesNotThrow(
                () -> namesPopularity.getCount(year, validGenders[pos], names[pos]),
                buildDoesNotThrowMessage(year, validGenders[pos], names[pos]));
        }
    }

    @Test
    public void doesNotThrowAtGetTotal() {
        for (var gender : validGenders) {
            Assertions.assertDoesNotThrow(() -> namesPopularity.getTotal(year, gender),
                buildDoesNotThrowMessage(year, gender));
        }
    }

    @Test
    public void throwsAtGetTotal() {
        final var year = 2001;

        for (var gender : invalidGenders) {
            if (Character.toUpperCase(gender) != 'M' && Character.toUpperCase(gender) != 'F') {
                Assertions.assertThrows(exception,
                    () -> namesPopularity.getTotal(year, gender),
                    buildThrowsMessage(exception.getName(), year, gender));
            }
        }
    }
}
