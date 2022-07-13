public class TestAlunosConstructorOrder {
    public static void main(String[] args) {
        AlunoGrad a1 = new AlunoGrad("Joao", "Silva", "1234", "bcc");
        System.out.println();
        AlunoPos a2 = new AlunoPos("Maria", "Pereira", "5678", "ppbcc", "Pedro Souza");
        System.out.println();
        AlunoPosLatu ap1 = new AlunoPosLatu("Guilherme", "Santos", "4567", "ppbcc", "Pedro Souza");
        System.out.println();
        AlunoPosStricto ap2 = new AlunoPosStricto("Letícia", "Sousa", "4389", "ppbcc", "Pedro Souza");
    }
}
