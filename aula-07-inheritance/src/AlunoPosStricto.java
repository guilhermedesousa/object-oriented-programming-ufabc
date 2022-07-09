public class AlunoPosStricto extends AlunoPos {
    public AlunoPosStricto(String nome, String sobrenome, String ra, String orientador, String programa) {
        super(nome, sobrenome, ra, orientador, programa);

        System.out.println("AlunoPosStricto");
    }

    @Override
    public String toString() {
        return super.toString() + "Tipo do programa: " + "Stricto sensu\n";
    }
}
