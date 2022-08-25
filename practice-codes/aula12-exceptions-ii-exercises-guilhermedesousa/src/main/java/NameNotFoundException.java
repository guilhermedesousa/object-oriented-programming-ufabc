public final class NameNotFoundException extends Exception {
    public NameNotFoundException(String name) {
        super("Could not find the given name: " + name);
    }
}
