public class TurmaTest {
    public static void main(String[] args) {
        Turma poo = new Turma("mcta018", "na2", 4);

        Aluno a1 = new Aluno("Joao", "Silva", "12345");
        Aluno a2 = new Aluno("Maria", "Fernandes", "56789");
        Aluno a3 = new Aluno("Guilherme", "Santos", "112019");
        Aluno a4 = new Aluno("Lorena", "Santos", "112010");

        poo.addMatricula(new Matricula(a1, 7.0f));
        poo.addMatricula(new Matricula(a2, 5.5f));
        poo.addMatricula(new Matricula(a3, 10.0f));
        poo.addMatricula(new Matricula(a4));

        poo.setNotaStudent("112010", 9.9f);

        System.out.println(poo);
    }
}
