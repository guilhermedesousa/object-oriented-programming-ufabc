import TestUtil.format
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.function.Executable
import java.io.File
import java.io.FileNotFoundException
import java.util.*

internal class SemiCirculoTest {
    private data class Case(
        val id: String,
        val centro: Ponto,
        val raio: Double,
        val semiCirculo: SemiCirculo,
        val largura: Double,
        val altura: Double,
        val area: Double,
        val perimetro: Double
    )
    private val semiCirclesFile = TestUtil.baseDir + "semi_circles.csv"
    private val cases = mutableListOf<Case>()

    @BeforeEach
    private fun load() {
        try {
            Scanner(File(semiCirclesFile)).use {scanner ->
                var id = 0

                while (scanner.hasNext()) {
                    val centro = Ponto(scanner.next().toDouble(), scanner.next().toDouble())
                    val raio = scanner.next().toDouble()
                    val semiCirculo = SemiCirculo(centro, raio)

                    cases.add(Case(
                        id = "case${++id}",
                        centro = centro,
                        raio = raio,
                        semiCirculo = semiCirculo,
                        largura = scanner.next().toDouble(),
                        altura = scanner.next().toDouble(),
                        area = scanner.next().toDouble(),
                        perimetro = scanner.next().toDouble()
                    ))
                }
            }
        } catch (e: FileNotFoundException) {
            Assertions.fail(Exception("Falha ao abrir o arquivo de casos para semi-circulos", e))
        } catch (e: Exception) {
            TestUtil.unexpectedExceptionThrown(e)
        }
    }

    @Test
    fun testLargura() {
        cases.forEach { it.apply {
            Assertions.assertEquals(
                largura, semiCirculo.largura(), TestUtil.TOLERANCE,
                "$id de semi-circulo: largura incorreta.\n ${format(semiCirculo)} "
            )
        } }
    }

    @Test
    fun testAltura() {
        cases.forEach { it.apply {
            Assertions.assertEquals(
                altura, semiCirculo.altura(), TestUtil.TOLERANCE,
                "$id de semi-circulo: altura incorreta.\n ${format(semiCirculo)} ")
        } }
    }

    @Test
    fun testArea() {
        cases.forEach { it.apply {
            Assertions.assertEquals(
                area, semiCirculo.area(), TestUtil.TOLERANCE,
                "$id de semi-circulo: area incorreta.\n ${format(semiCirculo)} ")
        } }
    }

    @Test
    fun testPerimetro() {
        cases.forEach { it.apply {
            Assertions.assertEquals(
                perimetro, semiCirculo.perimetro(), TestUtil.TOLERANCE,
                "$id de semi-circulo: perimetro incorreto.\n ${format(semiCirculo)} ")
        } }
    }

    @Test
    fun testRaio() {
        cases.forEach { it.apply {
            Assertions.assertThrows(
                IllegalArgumentException::class.java,
                Executable { Circulo(centro, -1.0) },
                "$id de semi-circulo: nao deveria aceitar raio negativo.\n ${format(semiCirculo)} ")
        } }
    }
}