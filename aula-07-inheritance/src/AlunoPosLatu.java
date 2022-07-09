public class AlunoPosLatu extends AlunoPos {
    public AlunoPosLatu(String nome, String sobrenome, String ra, String orientador, String programa) {
        super(nome, sobrenome, ra, orientador, programa);

        System.out.println("AlunoPosLatu");
    }

    @Override
    public String toString() {
        return super.toString() + "Tipo do programa: " + "Lato sensu\n";
    }
}
