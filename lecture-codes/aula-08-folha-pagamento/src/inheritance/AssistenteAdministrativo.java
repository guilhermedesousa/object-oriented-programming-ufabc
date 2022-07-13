package inheritance;

public class AssistenteAdministrativo extends Funcionario {
    private final double horasExtra;

    public AssistenteAdministrativo(String nome, String sobrenome,
                                    String cpf, double salarioBase,
                                    double planoSaude,
                                    double valeTransporte, double horasExtra) {
        super(nome, sobrenome, cpf, salarioBase, planoSaude, valeTransporte);
        if (horasExtra < 0) {
            throw new IllegalArgumentException("Horas extra transporte de saude base nao pode ser negativo");
        }
        this.horasExtra = horasExtra;
    }

    public double getHorasExtra() {
        return horasExtra;
    }
    
    public double adicionalHorasExtra() {
        return getSalarioBase() / 220 * 1.5 * getHorasExtra();
    }

    @Override
    public double getSalarioBruto() {
        return getSalarioBase() + adicionalHorasExtra();
    }

    @Override
    public String geraContracheque() {
        return "Cargo: Assistente Administrativo\n" +
            String.format("Horas-extra: %.2f (R$%.2f)\n", getHorasExtra(), adicionalHorasExtra()) +
            super.geraContracheque();
    }
}
