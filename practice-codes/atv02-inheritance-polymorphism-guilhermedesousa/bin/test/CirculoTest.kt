import TestUtil.format
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.function.Executable
import java.io.File
import java.io.FileNotFoundException
import java.util.*

internal class CirculoTest {
    private data class Case(
        val id: String,
        val centro: Ponto,
        val raio: Double,
        val circulo: Circulo,
        val largura: Double,
        val altura: Double,
        val area: Double,
        val perimetro: Double
    )

    private val cases = mutableListOf<Case>()
    private val circlesFile = TestUtil.baseDir + "circles.csv"

    @BeforeEach
    private fun load() {
        try {
            Scanner(File(circlesFile)).use { scanner ->
                var caseNumber = 0
                while (scanner.hasNext()) {
                    val centro = Ponto(scanner.nextDouble(), scanner.nextDouble())
                    val raio = scanner.nextDouble()
                    val circulo = Circulo(centro, raio)
                    val largura = scanner.nextDouble()
                    val altura = scanner.nextDouble()
                    val area = scanner.nextDouble()
                    val perimetro = scanner.nextDouble()

                    cases.add(
                        Case(
                            id = "case${++caseNumber}",
                            centro = centro,
                            raio = raio,
                            circulo = circulo,
                            largura = largura,
                            altura = altura,
                            area = area,
                            perimetro = perimetro
                        )
                    )
                }
            }
        } catch (e: FileNotFoundException) {
            Assertions.fail("Falha ao abrir arquivo de testes para circulos", e)
        } catch (e: Exception) {
            TestUtil.unexpectedExceptionThrown(e)
        }
    }

    @Test
    fun testLargura() {
        cases.forEach { it.apply {
                Assertions.assertEquals(
                    largura, circulo.largura(), TestUtil.TOLERANCE, String.format(
                        "${format(circulo)} de circulo: largura incorreta.\n %s ", id,
                        format(circulo)
                    )
                )
            } }
    }

    @Test
    fun testAltura() {
        cases.forEach { it.apply {
                Assertions.assertEquals(
                    altura, circulo.altura(), TestUtil.TOLERANCE,
                    "$id de circulo: altura incorreta.\n ${format(circulo)}")
            } }
    }

    @Test
    fun testArea() {
        cases.forEach { it.apply {
                Assertions.assertEquals(
                    area, circulo.area(), TestUtil.TOLERANCE,
                    "$id de circulo: area incorreta.\n ${format(circulo)} ")
            } }
    }

    @Test
    fun testPerimetro() {
        cases.forEach { it.apply {
            Assertions.assertEquals(
                perimetro, circulo.perimetro(), TestUtil.TOLERANCE,
                "$id de circulo: perimetro incorreto.\n ${format(circulo)}")
        } }
    }

    @Test
    fun testCircunferencia() {
        cases.forEach { it.apply {
            Assertions.assertEquals(
                perimetro, circulo.circunferencia(), TestUtil.TOLERANCE,
                "$id de circulo: circunferencia incorreta.\n ${format(circulo)} ")
        } }
    }

    @Test
    fun testRaio() {
        cases.forEach { it.apply {
            Assertions.assertThrows(
                IllegalArgumentException::class.java,
                Executable { Circulo(centro, -1.0) },
                "$id de circulo: nao deveria aceitar raio negativo\n ${format(circulo)}")
        } }
    }
}