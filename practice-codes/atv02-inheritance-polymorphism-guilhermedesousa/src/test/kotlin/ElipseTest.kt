import TestUtil.format
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.File
import java.io.FileNotFoundException
import java.util.*
import java.util.function.Consumer

internal class ElipseTest {
    private data class Case(
        val id: String,
        val centro: Ponto,
        val semiEixoA: Double,
        val semiEixoB: Double,
        val elipse: Elipse,
        val largura: Double,
        val altura: Double,
        val area: Double,
        val perimetro: Double
    )
    private val cases = mutableListOf<Case>()
    private val ellipsesFile = TestUtil.baseDir + "ellipses.csv"

    @BeforeEach
    private fun load() {
        try {
            Scanner(File(ellipsesFile)).use { scanner ->
                var caseNumber = 0
                while (scanner.hasNext()) {
                    val id = "case${++caseNumber}"
                    val centro = Ponto(scanner.next().toDouble(), scanner.next().toDouble())
                    val semiEixoA = scanner.next().toDouble()
                    val semiEixoB = scanner.next().toDouble()
                    val largura = scanner.next().toDouble()
                    val altura = scanner.next().toDouble()
                    val area = scanner.next().toDouble()
                    val perimetro = scanner.next().toDouble()
                    val elipse = Elipse(centro, semiEixoA, semiEixoB)

                    cases.add(
                        Case(
                            id = id,
                            centro = centro,
                            semiEixoA = semiEixoA,
                            semiEixoB = semiEixoB,
                            largura = largura,
                            altura = altura,
                            area = area,
                            perimetro = perimetro,
                            elipse = elipse
                        )
                    )
                }
            }
        } catch (e: FileNotFoundException) {
            Assertions.fail(Exception("Falha ao abrir o arquivo de casos para elipses", e))
        } catch (e: Exception) {
            TestUtil.unexpectedExceptionThrown(Exception(e))
        }
    }

    @Test
    fun testLargura() {
        cases.forEach {
            it.apply {
                Assertions.assertEquals(
                    largura, elipse.largura(), TestUtil.TOLERANCE, String.format(
                        "%s de elipse: largura incorreta.\n %s ", id,
                        format(elipse)
                    )
                )
            }
        }
    }

    @Test
    fun testAltura() {
        cases.forEach(Consumer { c: Case ->
            Assertions.assertEquals(
                c.altura, c.elipse.altura(), TestUtil.TOLERANCE, String.format(
                    "%s de elipse: altura incorreta.\n %s ", c.id,
                    format(c.elipse)
                )
            )
        })
    }

    @Test
    fun testArea() {
        cases.forEach(Consumer { c: Case ->
            Assertions.assertEquals(
                c.area, c.elipse.area(), TestUtil.TOLERANCE, String.format(
                    "%s de elipse: area incorreta.\n %s ", c.id,
                    format(c.elipse)
                )
            )
        })
    }

    @Test
    fun testPerimetro() {
        cases.forEach(Consumer { c: Case ->
            Assertions.assertEquals(
                c.perimetro, c.elipse.perimetro(), TestUtil.TOLERANCE, String.format(
                    "%s de elipse: perimetro incorreto.\n %s ", c.id,
                    format(c.elipse)
                )
            )
        })
    }

    @Test
    fun testCircunferencia() {
        cases.forEach(Consumer { c: Case ->
            Assertions.assertEquals(
                c.perimetro, c.elipse.circunferencia(), TestUtil.TOLERANCE, String.format(
                    "%s de elipse: circunferencia incorreta.\n %s ", c.id,
                    format(c.elipse)
                )
            )
        })
    }

    @Test
    fun testEixoNegativo() {
        Assertions.assertThrows(
            IllegalArgumentException::class.java,
            { Elipse(Ponto(0.0, 0.0), -1.0, -1.0) },
            "Elipse nao deveria aceitar eixo negativo."
        )
    }

    @Test
    fun testSemiEixos() {
        val elipse1 = Elipse(Ponto(0.0, 0.0), 10.0, 20.0)
        val elipse2 = Elipse(Ponto(0.0, 0.0), 20.0, 10.0)
        Assertions.assertFalse(
            elipse1.eixoSemiMaior < elipse1.eixoSemiMenor, String.format(
                "Elipse: eixo semi-menor (%f) nao pode exceder eixo semi-maior (%f)",
                elipse1.eixoSemiMenor,
                elipse1.eixoSemiMaior
            )
        )
        Assertions.assertFalse(
            elipse2.eixoSemiMaior < elipse2.eixoSemiMenor, String.format(
                "Elipse: eixo semi-menor (%f) nao pode exceder eixo semi-maior (%f)",
                elipse2.eixoSemiMenor,
                elipse2.eixoSemiMaior
            )
        )
    }
}