import java.util.ArrayList;
import java.util.List;

public class Turma {
    private String codDisciplina;
    private String codTurma;
    private int tamanho;
    private List<Matricula> matriculas;

    public Turma(String codDisciplina, String codTurma, int tamanho) {
        this.codDisciplina = codDisciplina;
        this.codTurma = codTurma;
        setTamanho(tamanho);
        this.matriculas = new ArrayList<>();
    }

    private void setTamanho(int tamanho) {
        if (tamanho < 0) {
            throw new IllegalArgumentException("Tamanho must be positive or zero");
        }

        this.tamanho = tamanho;
    }

    public boolean cheia() {
        return matriculas.size() == tamanho;
    }

    public boolean temVagas() {
        return !cheia();
    }

    public void addMatricula(Matricula matricula) {
        if (!temVagas()) {
            System.err.print("Capacidade da turma excedida");
        } else {
            this.matriculas.add(matricula);
        }
    }

    public void setNotaStudent(String ra, float nota) {
        for (Matricula matricula : matriculas) {
            if (matricula.getAluno().getRa() == ra) {
                matricula.setNota(nota);
            }
        }
    }

    public float getMediaTurma() {
        float sum = 0.0f;

        for (Matricula matricula : matriculas) {
            sum += matricula.getNota();
        }

        return sum / this.tamanho;
    }

    private String buildRelatorioTurma() {
        StringBuilder builder = new StringBuilder();

        builder.append("Disciplina: " + codDisciplina + "\n")
            .append("Turma: " + codTurma + "\n");

        System.out.println();

        builder.append(String.format("%-10s", "RA"));
        builder.append(String.format("%-30s", "Nome"));
        builder.append(String.format("%-7s", "Nota"));
        builder.append("\n");

        for (Matricula matricula : matriculas) {
            builder.append(String.format("%-10s", matricula.getAluno().getRa()));
            builder.append(String.format("%-30s", matricula.getAluno().getNome() + " " + matricula.getAluno().getSobrenome()));
            builder.append(String.format("%-7.2f", matricula.getNota()));
            builder.append("\n");
        }

        builder.append("Média turma: " + getMediaTurma() + "\n");

        return builder.toString();
    }

    @Override
    public String toString() {
        return buildRelatorioTurma();
    }
}
