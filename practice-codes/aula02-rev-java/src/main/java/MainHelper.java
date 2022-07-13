/**
 * App class.
 */
public final class MainHelper {
    private MainHelper() {}

    /**
     * Retorna a quantidade de dígitos presente no inteiro.
     *
     * @param n o inteiro
     * @return a quantidade de dígitos
     */
    public static int contaDigitos(int n) {
        int qtyDigits = 0;

        if (n == 0) {
            return 1;
        } else {
            while (n != 0) {
                qtyDigits++;
                n = n / 10;
            }

            return qtyDigits;
        }
    }

    /**
     * Retorna um array contendo os maximos das colunas da matriz.
     *
     * @param v a matriz
     * @return o array de maximos
     */
    public static int[] maximosColunas(int[][] v) {
        int qtyRows = v.length;
        int qtyColumns = v[0].length;

        int[] maxValuesColumns = new int[qtyColumns];

        int maxValue = v[0][0];

        for (int j = 0; j < qtyColumns; j++) {
            for (int i = 0; i < qtyRows; i++) {
                if (i == 0) {
                    maxValue = v[i][j];
                } else if (v[i][j] > maxValue) {
                    maxValue = v[i][j];
                }
            }

            maxValuesColumns[j] = maxValue;
        }

        return maxValuesColumns;
    }

}
