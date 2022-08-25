import TestUtil.format
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.File
import java.io.FileNotFoundException
import java.util.*

internal class TrapezioTest {
    private data class Case(
        val id: String,
        val p1: Ponto,
        val p2: Ponto,
        val p3: Ponto,
        val p4: Ponto,
        val trapezio: Trapezio,
        val largura: Double,
        val altura: Double,
        val area: Double,
        val perimetro: Double,
        val baseMenor: Double,
        val baseMaior: Double
    )
    private val trapezoidsFile = TestUtil.baseDir + "trapezoids.csv"
    private val cases = mutableListOf<Case>()

    @BeforeEach
    private fun load() {
        try {
            Scanner(File(trapezoidsFile)).use { scanner ->
                var id = 0
                while (scanner.hasNext()) {
                    val p1 = Ponto(scanner.next().toDouble(), scanner.next().toDouble())
                    val p2 = Ponto(scanner.next().toDouble(), scanner.next().toDouble())
                    val p3 = Ponto(scanner.next().toDouble(), scanner.next().toDouble())
                    val p4 = Ponto(scanner.next().toDouble(), scanner.next().toDouble())
                    val trapezio = Trapezio(p1, p2, p3, p4)
                    val largura = scanner.next().toDouble()
                    val altura = scanner.next().toDouble()
                    val area = scanner.next().toDouble()
                    val perimetro = scanner.next().toDouble()
                    val baseMenor = scanner.next().toDouble()
                    val baseMaior = scanner.next().toDouble()

                    cases.add(
                        Case(
                            id = "case${++id}",
                            p1 = p1,
                            p2 = p2,
                            p3 = p3,
                            p4 = p4,
                            trapezio = trapezio,
                            largura = largura,
                            altura = altura,
                            area = area,
                            perimetro = perimetro,
                            baseMenor = baseMenor,
                            baseMaior = baseMaior
                        )
                    )
                }
            }
        } catch (e: FileNotFoundException) {
            System.err.println("Falha ao abrir arquivo de casos para trapezios")
            e.printStackTrace()
        } catch (e: Exception) {
            TestUtil.unexpectedExceptionThrown(e)
        }
    }

    @Test
    fun testExiste() {
        cases.forEach {
            it.apply {
                Assertions.assertTrue(
                    Trapezio.existe(p1, p2, p3, p4), String.format(
                        "%s de trapezio: teste de existencia falhou com pontos validos.\n %s ",
                        id,
                        arrayOf(p1, p2, p3, p4).contentToString()
                    )
                )
            }
        }
    }

    @Test
    fun testLargura() {
        cases.forEach {
            it.apply {
                Assertions.assertEquals(
                    largura, trapezio.largura(), TestUtil.TOLERANCE, String.format(
                        "%s de trapezio: largura incorreta.\n %s ", id,
                        format(trapezio)
                    )
                )
            }
        }
    }

    @Test
    fun testAltura() {
        cases.forEach {
            it.apply {
                Assertions.assertEquals(
                    altura, trapezio.altura(), TestUtil.TOLERANCE, String.format(
                        "%s de trapezio: altura incorreta.\n %s ", id,
                        format(trapezio)
                    )
                )
            }
        }
    }

    @Test
    fun testArea() {
        cases.forEach {
            it.apply {
                Assertions.assertEquals(
                    area, trapezio.area(), TestUtil.TOLERANCE, String.format(
                        "%s de trapezio: area incorreta.\n %s ", id,
                        format(trapezio)
                    )
                )
            }
        }
    }

    @Test
    fun testPerimetro() {
        cases.forEach {
            it.apply {
                Assertions.assertEquals(
                    perimetro, trapezio.perimetro(), TestUtil.TOLERANCE, String.format(
                        "%s de trapezio: perimetro incorreto.\n %s ", id,
                        format(trapezio)
                    )
                )
            }
        }
    }

    @Test
    fun testBaseMenor() {
        cases.forEach {
            it.apply {
                Assertions.assertEquals(
                    baseMenor,
                    trapezio.baseMenor().comprimento(),
                    TestUtil.TOLERANCE,
                    String.format(
                        "%s de trapezio: base menor incorreta.\n %s ", id,
                        format(trapezio)
                    )
                )
            }
        }
    }

    @Test
    fun testBaseMaior() {
        cases.forEach {
            it.apply {
                Assertions.assertEquals(
                    baseMaior,
                    trapezio.baseMaior().comprimento(),
                    TestUtil.TOLERANCE,
                    String.format(
                        "%s de trapezio: base maior incorreta.\n %s ", id,
                        format(trapezio)
                    )
                )
            }
        }
    }

    @Test
    fun testNaoExiste() {
        val falseShapes = arrayOf(
            arrayOf(
                Ponto(0.2, 0.6),
                Ponto(0.1, 0.5),
                Ponto(0.9, 0.2),
                Ponto(0.3, 0.4)
            ), arrayOf(
                Ponto(0.2, 0.6),
                Ponto(0.1, 0.5),
                Ponto(0.4, 0.45),
                Ponto(0.3, 0.4)
            )
        )

        for (points in falseShapes) {
            Assertions.assertFalse(
                Trapezio.existe(
                    points[0], points[1], points[2], points[3]
                ), String.format(
                    "Trapezio: falso positivo no teste de existencia.\n %s ",
                    points.contentToString()
                )
            )
        }

    }
}