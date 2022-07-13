public class Account {
    private String number; // instance variable

    static final String bank = "xyz";

    /**
     * Default constructor
     */
    public Account () {
        System.out.println(String.format("Objetct %s was created", System.identityHashCode(this)));
        this.number = "0";
    }

    // overloaded constructor
    public Account (String number) {
        setNumber(number);
    }

    /**
     * Getter for account number
     * @return the account number
     */
    public String getNumber() {
        return number;
    }

    /**
     * The account format is formed by two parts separated by hyphen:
     * the first part is composed by at least one digit and the second
     * is composed by a single digit or x or X.
     * e.g. 12345-x 12345-0 12345-X 3-0
     * @param number the account number
     */
    private void validateNumber(String number) {
        final String pattern = "\\d+-(\\d|x|X)";

        if (!number.matches(pattern)) {
            throw new IllegalArgumentException("Invalid account number");
        }
    }

    /**
     * Setter for account number
     * @param number number to set in the account
     */
    public void setNumber(String number) {
        validateNumber(number);
        this.number = number;
    }

    public String toString() {
        return "Account number: " + number + "\n" + "Back: " + Account.bank;
    }
}