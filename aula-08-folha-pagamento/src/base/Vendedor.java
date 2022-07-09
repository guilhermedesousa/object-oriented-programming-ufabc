package base;

public class Vendedor {
    private final String nome;
    private final String sobrenome;
    private final String cpf;
    private final double salarioBase;
    private final double planoSaude;
    private final double valeTransporte;
    private final double taxaComissao;
    private final double vendasBrutas;

    public Vendedor(String nome, String sobrenome, String cpf, double salarioBase, double planoSaude,
            double valeTransporte, double taxaComissao, double vendasBrutas) {
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
        if (taxaComissao < 0.0 && taxaComissao > 1.0) {
            throw new IllegalArgumentException("Taxa de comissao deve ser no intervalo [0.0,1.0]");
        }
        this.taxaComissao = taxaComissao;
        if (vendasBrutas < 0) {
            throw new IllegalArgumentException("Vendas brutas nao pode ser negativo");
        }
        this.vendasBrutas = vendasBrutas;
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

    public double getTaxaComissao() {
        return taxaComissao;
    }

    public double getVendasBrutas() {
        return vendasBrutas;
    }

    public double getComissao() {
        return getVendasBrutas() * getTaxaComissao();
    }

    public double getSalarioBruto() {
        return getSalarioBase() + getComissao();
    }

    public double getSalarioLiquido() {
        return getSalarioBruto() - getPlanoSaude() - getValeTransporte();
    }

    public String geraContracheque() {
        return String.format("Nome: %s %s\n", getNome(), getSobrenome()) +
                "CPF: " + getCpf() + "\n" +
                "Cargo: Vendedor\n" +
                String.format("Salario-base: R$%.2f\n", getSalarioBase()) +
                String.format("Vendas brutas: R$%.2f\n", getVendasBrutas()) +
                String.format("Taxa comissao: %.2f%%\n", getTaxaComissao() * 100) +
                String.format("Comissao: R$%.2f\n", getComissao()) +
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
