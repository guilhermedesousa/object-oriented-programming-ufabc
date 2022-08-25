import com.github.javafaker.Faker;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Testes para a classe Mapa.
 */
public class MapaTest {

    public final Faker faker = new Faker();

    private final Long[] chaves;
    private final String[] valores;
    private Mapa<Long, String> mapa;

    /**
     * Constroi os testes.
     */
    public MapaTest() {
        chaves = new Long[]{
            faker.number().randomNumber(),
            faker.number().randomNumber(),
            faker.number().randomNumber()
        };
        valores = new String[]{
            faker.name().name(),
            faker.name().name(),
            faker.name().name(),
        };
        Arrays.sort(chaves);
        Arrays.sort(valores);
    }

    @BeforeEach
    public void setUp() {
        mapa = new Mapa<>();
    }

    private void populate() {
        try {
            for (var i = 0; i < chaves.length; i++) {
                mapa.inserir(chaves[i], valores[i]);
            }
        } catch (ElementoJaExisteException e) {
            Assertions.fail("Excecao inesperada ao inserir elemento na mapa", e);
        }
    }

    @Test
    public void testExceptionHierarchy() {
        Assertions.assertEquals(ElementoJaExisteException.class.getSuperclass(), Exception.class,
            "ElementoJaExisteException deve herdar de Exception");
        Assertions.assertEquals(ElementoNaoEncontradoException.class.getSuperclass(),
            Exception.class,
            "ElementoNaoEncontrado deve herdar de Exception");
    }

    @Test
    public void testRecuperar() {
        populate();
        for (var i = 0; i < chaves.length; i++) {
            try {
                Assertions.assertEquals(valores[i], mapa.recuperar(chaves[i]),
                    "Mapa retorna valor incorreto para chave %d " + chaves[i]);
            } catch (ElementoNaoEncontradoException e) {
                Assertions.fail("Excecao inesperada ao recuperar elemento pela chave", e);
            }
        }
    }

    @Test
    public void testInserir() {
        var messageFormat = "Apos %d insercoes, o tamanho do mapa deve ser %d";

        for (var i = 0; i < chaves.length; i++) {
            Assertions.assertEquals(i, mapa.tamanho(),
                String.format(messageFormat, i, i));
            try {
                mapa.inserir(chaves[i], valores[i]);
            } catch (ElementoJaExisteException e) {
                Assertions.fail("Excecao insperada ao testar insercao", e);
            }
            Assertions.assertEquals(i + 1, mapa.tamanho(),
                String.format(messageFormat, i + 1, i + 1));
        }
    }

    @Test
    public void testSubstituir() {
        populate();
        try {
            mapa.substituir(chaves[0], valores[2]);
        } catch (ElementoNaoEncontradoException e) {
            Assertions.fail(String.format(
                "Excecao inesperada ao substituir elemento valido. Original: (%d, %s). "
                    + "Substituicao: (%d, %s)", chaves[0], valores[0], chaves[2], valores[2]), e);
        }
    }

    @Test
    public void testRemover() {
        populate();
        try {
            mapa.remover(chaves[0]);
        } catch (ElementoNaoEncontradoException e) {
            Assertions.fail(
                String.format("Excecao inesperada ao remove elemento valido. Chave: %s", chaves[0]),
                e);
        }
    }

    @Test
    public void testContemChave() {
        populate();
        for (var chave : chaves) {
            Assertions.assertTrue(mapa.contemChave(chave),
                "Mapa deve conter a chave " + chave);
        }

        var chave = faker.number().randomNumber();

        Assertions.assertFalse(mapa.contemChave(chave),
            "Mapa nao deve conter a chave " + chave);
    }

    @Test
    public void testContemValor() {
        populate();
        for (var chave : chaves) {
            Assertions.assertTrue(mapa.contemChave(chave),
                "Mapa deve conter a chave " + chave);
        }

        var valor = faker.name().name();

        Assertions.assertFalse(mapa.contemValor(valor),
            "Mapa nao deve conter o valor " + valor);
    }

    @Test
    public void testChaves() {
        Assertions.assertEquals(new ArrayList<Long>(), mapa.chaves(),
            "Mapa vazio deve retornar lista vazia de chaves");

        populate();
        Assertions.assertEquals(List.of(chaves),
            mapa.chaves().stream().sorted().collect(Collectors.toList()),
            "Apos tres insercoes, Mapa retorna chaves incorretas");
    }

    @Test
    public void testValores() {
        Assertions.assertEquals(new ArrayList<String>(), mapa.valores(),
            "Mapa vazio deve retornar lista vazia de valores");
        populate();
        Assertions.assertEquals(List.of(valores),
            mapa.valores().stream().sorted().collect(Collectors.toList()),
            "Apos tres insercoes, Mapa retorna valores incorretos");
    }

    @Test
    public void testExceptionOnRecuperar() {
        Assertions.assertThrows(ElementoNaoEncontradoException.class, () ->
                mapa.recuperar(faker.number().randomNumber()),
            "Esperada excecao ElementoNaoEncontradoException ao recuperar "
                + "elemento com chave inexistente");
        populate();

        for (var chave : chaves) {
            Assertions.assertDoesNotThrow(() -> {
                mapa.recuperar(chave);
            }, "Excecao inesperada ao recuperar elemento com chave valida");
        }
    }

    @Test
    public void testExceptionOnInserir() {
        populate();
        for (var i = 0; i < chaves.length; i++) {
            final var pos = i;
            Assertions.assertThrows(ElementoJaExisteException.class,
                () -> mapa.inserir(chaves[pos], valores[pos]),
                "Esperada excecao ElementoJaExisteException ao inserir "
                    + "elemento com chave pre-existente");
        }
        Assertions.assertDoesNotThrow(
            () -> mapa.inserir(faker.number().randomNumber(), faker.name().name()),
            "Excecao inesperada ao inserir elemento com chave inexistente");
    }

    @Test
    public void testExceptionOnSubstituir() {
        populate();
        for (var chave : chaves) {
            Assertions.assertDoesNotThrow(() -> mapa.substituir(chave, faker.name().name()),
                "Excecao inesperada ao substituir elemento com chave existente");
        }
        Assertions.assertThrows(ElementoNaoEncontradoException.class,
            () -> mapa.substituir(faker.number().randomNumber(), faker.name().name()),
            "Excecao esperada ao substituir elemento com chave inexistente");
    }

    @Test
    public void testExceptionOnRemover() {
        populate();
        for (var chave : chaves) {
            Assertions.assertDoesNotThrow(() -> mapa.remover(chave),
                "Excecao inesperada ao remover elemento com chave existente");
        }
        populate();
        Assertions.assertThrows(ElementoNaoEncontradoException.class,
            () -> mapa.remover(faker.number().randomNumber()),
            "Esperada excecao ao remover elemento com chave inexistente");
    }
}
