/**
 * Generic algorithms to process arrays.
 */
public final class ArraysUtil {

    private ArraysUtil() {}

    /**
     * Convert a generic array to a string.
     *
     * @param elements the elements.
     * @param <T> the generic type.
     * @return the string representation of the array
     */
    public static <T> String toString(T[] elements) {
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        for (int i = 0; i < elements.length; i++) {
            sb.append(elements[i]);
            if (i < elements.length - 1) {
                sb.append(",");
            }

        }
        sb.append("]");

        return sb.toString();
    }

    /**
     * Selection sort (inline).
     * WARN: Performing some redundant checks to simplify the algorithm.
     *
     * @param elements the array of elements
     * @param <E> the generic type
     */
    public static <E extends Comparable<E>> void sort(E[] elements) {
        for (int i = 0; i < elements.length; i++) {
            int min = i;

            for (int j = i; j < elements.length; j++) {
                if (elements[j].compareTo(elements[min]) < 0) {
                    min = j;
                }
            }
            E temp = elements[i];
            elements[i] = elements[min];
            elements[min] = temp;
        }
    }

    /**
     * Deep array equality checking using Comparable interface.
     *
     * @param v1 the first array
     * @param v2 the second array
     * @param <E> the array types
     * @return true if arrays are equal, false otherwise
     */
    public static <E extends Comparable<E>> boolean equals(E[] v1, E[] v2) {
        if (v1.length != v2. length) {
            return false;
        }

        for (int i = 0; i < v1.length; i++) {
            if (v1[i].compareTo(v2[i]) != 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * Check if the given array is sorted.
     *
     * @param elements the array of elements
     * @param <T> the generic type
     * @return true if it is sorted, false otherwise
     */
    public static <T extends Comparable<T>> boolean isSorted(T[] elements) {
        for (int i = 1; i < elements.length; i++) {
            if (elements[i].compareTo(elements[i - 1]) < 0) {
                return false;
            }
        }

        return true;
    }
}
