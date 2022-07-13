package academic;

public class AcademicEqualityTest {
    public static void main(String[] args) {
        Student s1 = new Student("Joao", "Cardoso", "124", "bcc", 20);
        Student s2 = new Student("Joao", "Cardoso", "123", "bcc", 21);

        System.out.println(s1.equals(s2));
    }
}
