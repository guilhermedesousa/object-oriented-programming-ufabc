import TestUtil.format
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.File
import java.io.FileNotFoundException
import java.util.*

internal class ParalelogramoTest {
    private data class Case(
        val id: String,
        val p1: Ponto,
        val p2: Ponto,
        val p3: Ponto,
        val p4: Ponto,
        val paralelogramo: Paralelogramo,
        val largura: Double,
        val altura: Double,
        val area: Double,
        val perimetro: Double
    )
    private val parallelogramsFile = TestUtil.baseDir + "parallelograms.csv"
    private val cases = mutableListOf<Case>()

    @BeforeEach
    private fun load() {
        try {
            Scanner(File(parallelogramsFile)).use { scanner ->
                var id = 0
                while (scanner.hasNext()) {
                    val p1 = Ponto(scanner.next().toDouble(), scanner.next().toDouble())
                    val p2 = Ponto(scanner.next().toDouble(), scanner.next().toDouble())
                    val p3 = Ponto(scanner.next().toDouble(), scanner.next().toDouble())
                    val p4 = Ponto(scanner.next().toDouble(), scanner.next().toDouble())
                    val paralelogramo = Paralelogramo(p1, p2, p3, p4)
                    val largura = scanner.next().toDouble()
                    val altura = scanner.next().toDouble()
                    val area = scanner.next().toDouble()
                    val perimetro = scanner.next().toDouble()

                    cases.add(
                        Case(
                            id = "case${++id}",
                            p1 = p1,
                            p2 = p2,
                            p3 = p3,
                            p4 = p4,
                            paralelogramo = paralelogramo,
                            largura = largura,
                            altura = altura,
                            area = area,
                            perimetro = perimetro
                        )
                    )
                }
            }
        } catch (e: FileNotFoundException) {
            System.err.println("Falha ao abrir o arquivo de casos de paralelogramos")
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
                    Paralelogramo.existe(p1, p2, p3, p4), String.format(
                        "%s de paralelogramo: test de existencia falso negativo para pontos validos.\n %s ",
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
                    largura, paralelogramo.largura(), TestUtil.TOLERANCE, String.format(
                        "%s de paralelogramo: largura incorreta.\n %s ", id,
                        format(paralelogramo)
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
                    altura, paralelogramo.altura(), TestUtil.TOLERANCE, String.format(
                        "%s de paralelogramo: altura incorreta.\n %s ", id,
                        format(paralelogramo)
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
                    area, paralelogramo.area(), TestUtil.TOLERANCE, String.format(
                        "%s de paralelogramo: area incorreta.\n %s ", id,
                        format(paralelogramo)
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
                    perimetro, paralelogramo.perimetro(), TestUtil.TOLERANCE, String.format(
                        "%s de paralelogramo: perimetro incorreto.\n %s ", id,
                        format(paralelogramo)
                    )
                )
            }
        }
    }

    @Test
    fun testNaoExiste() {
        val falseShapes = arrayOf(
            arrayOf(
                Ponto(0.1, 0.25),
                Ponto(0.7, 0.25),
                Ponto(0.6, 0.0),
                Ponto(0.4, 0.0)
            ), arrayOf(
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
        for (shape in falseShapes) {
            Assertions.assertFalse(
                Paralelogramo.existe(
                    shape[0], shape[1], shape[2], shape[3]
                ), String.format(
                    "Paralelogramo: falso positivo no teste de existencia.\n %s ",
                    shape.contentToString()
                )
            )
        }
    }
}