package academic;

import java.util.Arrays;

public class AcademicComparisonTest {
    public static void main(String[] args) {
        Student s1 = new Student("Joao", "Cardoso", "124", "bcc", 19);
        Student s2 = new Student("Maria", "Nogueira", "567", "bcc", 20);
        Student s3 = new Student("Joana", "Dark", "383", "bcc", 21);

        Student[] students = new Student[] {s1, s2, s3};

        System.out.println(Arrays.toString(students));
        System.out.println();
        Arrays.sort(students);
        System.out.println(Arrays.toString(students));
    }
}
