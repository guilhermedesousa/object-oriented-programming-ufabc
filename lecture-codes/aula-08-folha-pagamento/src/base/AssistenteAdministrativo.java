package base;

public class AssistenteAdministrativo {
    private final String nome;
    private final String sobrenome;
    private final String cpf;
    private final double salarioBase;
    private final double planoSaude;
    private final double valeTransporte;
    private final double horasExtra;

    public AssistenteAdministrativo(String nome, String sobrenome, String cpf,
                                    double salarioBase, double planoSaude,
                                    double valeTransporte, double horasExtra) {
        if (nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome nao pode ser vazio");
        }
        this.nome = nome;
        if (sobrenome.trim().isEmpty()) {
            throw new IllegalArgumentException("Sobrenome nao pode ser vazio");
        }
        this.sobrenome = sobrenome;
        if (!cpf.trim().matches("\\d{3}\\.?\\d{3}\\.?\\d{3}-?\\d{2}")) {
            throw new IllegalArgumentException("CPF invalido");
        }
        this.cpf = cpf;
        if (salarioBase < 0) {
            throw new IllegalArgumentException("Salario base nao pode ser negativo");
        }
        this.salarioBase = salarioBase;
        if (planoSaude < 0) {
            throw new IllegalArgumentException("Plano de saude base nao pode ser negativo");
        }
        this.planoSaude = planoSaude;
        if (valeTransporte < 0) {
            throw new IllegalArgumentException("Vale transporte de saude base nao pode ser negativo");
        }
        this.valeTransporte = valeTransporte;
        if (horasExtra < 0) {
            throw new IllegalArgumentException("Horas extra transporte de saude base nao pode ser negativo");
        }
        this.horasExtra = horasExtra;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public double getPlanoSaude() {
        return planoSaude;
    }

    public double getValeTransporte() {
        return valeTransporte;
    }

    public double getHorasExtra() {
        return horasExtra;
    }

    public double adicionalHorasExtra() {
        return getSalarioBase() / 220 * 1.5 * getHorasExtra();
    }

    public double getSalarioBruto() {
        return getSalarioBase() + adicionalHorasExtra();
    }

    public double getSalarioLiquido() {
        return getSalarioBruto() - getValeTransporte() - getPlanoSaude();
    }

    public String geraContracheque() {
        return String.format("Nome: %s %s\n", getNome(), getSobrenome()) +
                "CPF: " + getCpf() + "\n" +
                "Cargo: Assistente Administrativo\n" +
                String.format("Salario-base: R$%.2f\n", getSalarioBase()) +
                String.format("Horas-extra: %.2f (R$%.2f)\n", getHorasExtra(), adicionalHorasExtra()) +
                String.format("Salario-bruto: R$%.2f\n", getSalarioBruto()) +
                "Descontos:\n" +
                String.format("   Vale transporte: -R$%.2f\n", getValeTransporte()) +
                String.format("   Plano de saude: -R$%.2f\n", getPlanoSaude()) +
                String.format("Salario-liquido: R$%.2f\n", getSalarioLiquido());
    }

    @Override
    public String toString() {
        return geraContracheque();
    }
}
