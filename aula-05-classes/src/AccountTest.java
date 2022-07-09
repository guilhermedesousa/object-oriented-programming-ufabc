public class AccountTest {
    public static void main(String[] args) {
        Account a1 = new Account();
        Account a2 = new Account();
        Account a3 = new Account();
        Account a4 = new Account("0000-X");
        Account a5 = new Account();
        System.out.println();

        a1.setNumber("1234-9");
        a2.setNumber("5678-x");
        a3.setNumber("3-0");

        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);
        System.out.println(a4);
        System.out.println(a5);
    }
}