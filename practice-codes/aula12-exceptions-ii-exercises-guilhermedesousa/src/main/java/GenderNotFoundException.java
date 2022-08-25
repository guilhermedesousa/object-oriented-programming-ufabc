public final class GenderNotFoundException extends Exception {
    public GenderNotFoundException(Character gender) {
        super("Gender character invalid: " + gender);
    }
}
