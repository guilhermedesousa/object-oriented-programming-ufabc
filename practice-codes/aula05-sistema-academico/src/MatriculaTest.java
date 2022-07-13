public class MatriculaTest {
    public static void main(String[] args) {
        Aluno a1 = new Aluno("Joao", "Silva", "12345");
        Aluno a2 = new Aluno("Maria", "Fernandes", "56789");

        Matricula m1 = new Matricula(a1);
        Matricula m2 = new Matricula(a2, 7);

        // m1.setNota(-1);

        System.out.println(m1);
        System.out.println(m2);
    }
}
