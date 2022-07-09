package inheritance;

public class Vendedor extends Funcionario {
    private final double taxaComissao;
    private final double vendasBrutas;

    public Vendedor(String nome, String sobrenome, String cpf,
                    double salarioBase, double planoSaude,
                    double valeTransporte, double taxaComissao, double vendasBrutas) {
        super(nome, sobrenome, cpf, salarioBase, planoSaude, valeTransporte);

        if (taxaComissao < 0.0 && taxaComissao > 1.0) {
            throw new IllegalArgumentException("Taxa de comissao deve ser no intervalo [0.0,1.0]");
        }
        this.taxaComissao = taxaComissao;
        if (vendasBrutas < 0) {
            throw new IllegalArgumentException("Vendas brutas nao pode ser negativo");
        }
        this.vendasBrutas = vendasBrutas;
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

    @Override
    public double getSalarioBruto() {
        return getSalarioBase() + getComissao();
    }

    @Override
    public String geraContracheque() {
        return "Cargo: Vendedor\n" +
                String.format("Vendas brutas: R$%.2f\n", getVendasBrutas()) +
                String.format("Taxa comissao: %.2f%%\n", getTaxaComissao() * 100) +
                String.format("Comissao: R$%.2f\n", getComissao()) +
                super.geraContracheque();
    }
}
