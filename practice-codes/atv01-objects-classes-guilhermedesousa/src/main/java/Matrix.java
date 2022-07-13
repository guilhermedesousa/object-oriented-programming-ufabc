/**
 * Abstraction of a matrix with real numbers.
 */
public class Matrix {
    private final double[][] cells;

    /**
     * Constructor of the Matrix class.
     *
     * @param cells the matrix
     */
    public Matrix(double[][] cells) {
        this.cells = cells;
    }

    public double[][] getCells() {
        return cells;
    }

    /**
     * Get the quantity of lines in the matrix.
     *
     * @return the number of lines
     */
    public int lines() {
        return getCells().length;
    }

    /**
     * Get the quantity of columns in the matrix.
     *
     * @return the number of columns
     */
    public int columns() {
        return getCells()[0].length;
    }

    /**
     * Get the value in a given position.
     *
     * @param line the line
     * @param column the column
     * @return the value in the position
     */
    public double get(int line, int column) {
        if (line < 0 || line > lines() - 1 || column < 0 || column > columns() - 1) {
            throw new IllegalArgumentException("Position out of the matrix");
        }

        return getCells()[line][column];
    }

    /**
     * Validate if the dimensions in both matrices are the same.
     *
     * @param a the first matrix
     * @param b the second matrix
     */
    private void isValidDimension(Matrix a, Matrix b) {
        if (a.lines() != b.lines()) {
            throw new IllegalArgumentException("The number of lines must be equal in both matrices");
        }

        if (a.columns() != b.columns()) {
            throw new IllegalArgumentException("The number of columns must be equal in both matrices");
        }
    }

    /**
     * Calculate the addition between two matrices.
     *
     * @param m the other matrix
     * @return the resulting matrix
     */
    public Matrix plus(Matrix m) {
        isValidDimension(this, m);

        double[][] c = new double[this.lines()][this.columns()];

        for (int i = 0; i < this.lines(); i++) {
            for (int j = 0; j < this.columns(); j++) {
                c[i][j] = this.get(i, j) + m.get(i, j);
            }
        }

        return new Matrix(c);
    }

    /**
     * Calculate the subtraction between two matrices.
     *
     * @param m the other matrix
     * @return the resulting matrix
     */
    public Matrix minus(Matrix m) {
        isValidDimension(this, m);

        double[][] c = new double[this.lines()][this.columns()];

        for (int i = 0; i < this.lines(); i++) {
            for (int j = 0; j < this.columns(); j++) {
                c[i][j] = this.get(i, j) - m.get(i, j);
            }
        }

        return new Matrix(c);
    }

    /**
     * Calculate the multiplication between a matrix and a scalar.
     *
     * @param scalar the scalar
     * @return the resulting matrix
     */
    public Matrix times(double scalar) {
        double[][] c = new double[this.lines()][this.columns()];

        for (int i = 0; i < this.lines(); i++) {
            for (int j = 0; j < this.columns(); j++) {
                c[i][j] = this.get(i, j) * scalar;
            }
        }

        return new Matrix(c);
    }

    /**
     * Calculate the multiplication between two matrices.
     *
     * @param m the other matrix
     * @return the resulting matrix
     */
    public Matrix times(Matrix m) {
        if (this.columns() != m.lines()) {
            throw new IllegalArgumentException("Invalid dimensions");
        }

        double[][] c = new double[this.lines()][m.columns()];

        for (int i = 0; i < this.lines(); i++) {
            for (int j = 0; j < m.columns(); j++) {
                for (int k = 0; k < this.columns(); k++) {
                    c[i][j] += this.get(i, k) * m.get(k, j);
                }
            }
        }

        return new Matrix(c);
    }

    /**
     * Transpose the matrix.
     *
     * @return the transposed matrix
     */
    public Matrix transpose() {
        double[][] c = new double[columns()][lines()];

        for (int i = 0; i < lines(); i++) {
            for (int j = 0; j < columns(); j++) {
                c[j][i] = get(i, j);
            }
        }

        return new Matrix(c);
    }

    /**
     * Check if the matrix is square.
     *
     * @return true if it is square, false otherwise
     */
    public boolean isSquare() {
        return this.columns() == this.lines();
    }

    /**
     * Check if the matrix is symetric.
     *
     * @return true if it is symetric, false otherwise
     */
    public boolean isSymmetric() {
        if (isSquare() == false) {
            return false;
        } else {
            Matrix b = this.transpose();

            for (int i = 0; i < this.lines(); i++) {
                for (int j = 0; j < this.columns(); j++) {
                    if (this.get(i, j) != b.get(i, j)) {
                        return false;
                    }
                }
            }
    
            return true;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < this.lines(); i++) {
            for (int j = 0; j < this.columns(); j++) {
                builder.append(String.format("%10.6f", this.get(i, j)));
            }
            builder.append("\n");
        }

        return builder.toString();
    }
}
