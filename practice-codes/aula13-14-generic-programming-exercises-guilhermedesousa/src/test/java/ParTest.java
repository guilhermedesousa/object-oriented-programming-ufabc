import com.github.javafaker.Faker;
import java.util.Objects;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Testes para a classe Par.
 */
public class ParTest {
    private Faker faker;

    private static class InternalClass {
        private final long pp;

        private InternalClass(long pp) {
            this.pp = pp;
        }

        public long getPp() {
            return pp;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            InternalClass that = (InternalClass) o;
            return pp == that.pp;
        }

        @Override
        public int hashCode() {
            return Objects.hash(pp);
        }
    }

    @BeforeEach
    public void init() {
        faker = new Faker();
    }

    @Test
    public void testGenerics() {
        var parameters = Par.class.getTypeParameters();

        if (parameters.length < 2) {
            Assertions.fail("Classe Par tem uma quantidade insuficiente "
                + "de tipos de parametros genericos");
        } else if (parameters.length > 2) {
            Assertions.fail("Classe Par tem uma quantidade excessiva de "
                + "tipos de parametros genericos");
        }
    }

    @Test
    public void testGetter() {
        var string = faker.name().fullName();
        var integer = faker.number().randomNumber();

        var p1 = new Par<>(string, integer);

        Assertions.assertEquals(string, p1.getChave(),
            String.format("Chave fora do esperado. Chave: %s ; Valor: %s",
                string, integer));
        Assertions.assertEquals(integer, p1.getValor(),
            String.format("Valor fora do esperado. Chave: %s ; Valor: %s",
                string, integer));

        var p2 = new Par<>(integer, string);

        Assertions.assertEquals(integer, p2.getChave(),
            String.format("Chave fora do esperado. Chave: %s ; Valor: %s",
                integer, string));
        Assertions.assertEquals(string, p2.getValor(),
            String.format("Valor fora do esperado. Chave: %s ; Valor: %s",
                integer, string));

        var bool = faker.random().nextBoolean();
        var obj = new InternalClass(faker.number().randomNumber());

        var p3 = new Par<>(bool, obj);

        Assertions.assertEquals(bool, p3.getChave(),
            String.format("Chave fora do esperado. Chave: %s ; Valor: %s",
                bool, obj));
        Assertions.assertEquals(obj, p3.getValor(),
            String.format("Valor fora do esperado. Chave: %s ; Valor: %s",
                bool, obj));

        var p4 = new Par<>(obj, bool);

        Assertions.assertEquals(obj, p4.getChave(),
            String.format("Chave fora do esperado. Chave: %s ; Valor: %s",
                obj, bool));
        Assertions.assertEquals(bool, p4.getValor(),
            String.format("Valor fora do esperado. Chave: %s ; Valor: %s",
                obj, bool));

    }

    @Test
    public void testIgualdade() {
        var k = faker.number();
        var v = faker.funnyName().name();
        var p1 = new Par<>(k, v);
        var p2 = new Par<>(k, v);
        var message = "Pares com mesmos valores de chave e valor sao iguais";

        Assertions.assertEquals(p1, p2, message);
        Assertions.assertEquals(p2, p1, message);
    }
}
