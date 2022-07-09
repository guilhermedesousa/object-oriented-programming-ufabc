import inheritance.AssistenteAdministrativo;
import inheritance.Funcionario;
import inheritance.Vendedor;

public class FolhaPagamento {
    public static void main(String[] args) {
        AssistenteAdministrativo a1 = new AssistenteAdministrativo(
            "Joao",
            "Silva",
            "123456789-11",
            2500,
            330,
            300,
            2);

        AssistenteAdministrativo a2 = new AssistenteAdministrativo(
            "Maria",
            "Pereira",
            "123456789-12",
            3300,
            700,
            200,
            10);

        Vendedor v1 = new Vendedor(
            "Guilherme",
            "Santos",
            "123456789-14",
            2000,
            500,
            300,
            0.1,
            10000
        );

        Vendedor v2 = new Vendedor(
            "Pedro",
            "Targino",
            "123456789-15",
            5000,
            50,
            300,
            0.4,
            5000
        );

        Funcionario[] funcionarios = new Funcionario[]{a1,a2,v1,v2};

        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario.geraContracheque() + "\n");
        }
    }
}
