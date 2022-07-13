public abstract class Aluno {
    protected String nome;
    protected String sobrenome;
    private String ra;

    public Aluno(String nome, String sobrenome, String ra) {
        setNome(nome);
        setSobrenome(sobrenome);
        setRa(ra);

        System.out.println("Aluno");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        if (!ra.matches("\\d+")) {
            throw new IllegalArgumentException("RA must be digits");
        }

        this.ra = ra;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "\n"
                + "Sobrenome: " + sobrenome + "\n"
                + "RA: " + ra + "\n";
    }
}