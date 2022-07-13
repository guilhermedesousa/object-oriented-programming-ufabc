public class Matricula {
    private Aluno aluno;
    private float nota;

    public Matricula(Aluno aluno) {
        setAluno(aluno);;
        setNota(0);
    }

    public Matricula(Aluno aluno, float nota) {
        this.aluno = aluno;
        setNota(nota);
    }

    public void setNota(float nota) {
        if (nota < 0 || nota > 10) {
            throw new IllegalArgumentException("Nota must be in [0, 10]");
        }

        this.nota = nota;
    }

    public float getNota() {
        return nota;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    @Override
    public String toString() {
        return "Matricula [aluno=" + aluno + ", nota=" + nota + "]";
    }
}
