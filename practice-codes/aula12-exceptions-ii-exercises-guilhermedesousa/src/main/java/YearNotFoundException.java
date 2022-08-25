public final class YearNotFoundException extends Exception {
    public YearNotFoundException(int year) {
        super("Year must be in [2001,2010]: " + year);
    }
}
