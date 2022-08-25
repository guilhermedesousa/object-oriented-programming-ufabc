import TestUtil.format
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.File
import java.io.FileNotFoundException
import java.util.*

internal class RetanguloTest {
    private data class Case(
        val id: String,
        val p1: Ponto,
        val p2: Ponto,
        val p3: Ponto,
        val p4: Ponto,
        val retangulo: Retangulo,
        val largura: Double,
        val altura: Double,
        val area: Double,
        val perimetro: Double,
        val ehQuadrado: Boolean
    )
    private val rectanglesFile = TestUtil.baseDir + "rectangles.csv"
    private val squaresFile = TestUtil.baseDir + "squares.csv"
    private val cases = mutableListOf<Case>()

    @BeforeEach
    fun load() {
        try {
            for (file in listOf(rectanglesFile, squaresFile)) {
                Scanner(File(file)).use { scanner ->
                    var id = 0

                    while (scanner.hasNext()) {
                        val p1 = Ponto(scanner.next().toDouble(), scanner.next().toDouble())
                        val p2 = Ponto(scanner.next().toDouble(), scanner.next().toDouble())
                        val p3 = Ponto(scanner.next().toDouble(), scanner.next().toDouble())
                        val p4 = Ponto(scanner.next().toDouble(), scanner.next().toDouble())
                        val retangulo = Retangulo(p1, p2, p3, p4)
                        val largura: Double = scanner.next().toDouble()
                        val altura: Double = scanner.next().toDouble()
                        val area: Double = scanner.next().toDouble()
                        val perimetro: Double = scanner.next().toDouble()
                        val ehQuadrado = java.lang.Boolean.parseBoolean(scanner.next())

                        cases.add(
                            Case(
                                id = "case${++id}",
                                p1 = p1,
                                p2 = p2,
                                p3 = p3,
                                p4 = p4,
                                retangulo = retangulo,
                                largura = largura,
                                altura = altura,
                                area = area,
                                perimetro = perimetro,
                                ehQuadrado = ehQuadrado
                            )
                        )
                    }
                }
            }

        } catch (e: FileNotFoundException) {
            Assertions.fail("Falha ao abrir arquivos de casos para retangulos", e)
        } catch (e: Exception) {
            TestUtil.unexpectedExceptionThrown(e)
        }
    }

    @Test
    fun testExiste() {
       cases.forEach { it.apply {
           Assertions.assertTrue(
               Retangulo.existe(p1, p2, p3, p4), String.format(
                   "%s de retangulo: falso negativo para teste de existencia.\n %s ",
                   id,
                   arrayOf(p1, p2, p3, p4).contentToString()
               )
           )
       } }
    }

    @Test
    fun testLargura() {
        cases.forEach { it.apply {
            Assertions.assertEquals(
                largura, retangulo.largura(), TestUtil.TOLERANCE, String.format(
                    "%s de retangulo: largura incorreta.\n %s ", id,
                    format(retangulo)
                )
            )
        } }
    }

    @Test
    fun testAltura() {
        cases.forEach { it.apply {
            Assertions.assertEquals(
                altura, retangulo.altura(), TestUtil.TOLERANCE, String.format(
                    "%s de retangulo: altura incorreta.\n %s ", id,
                    format(retangulo)
                )
            )
        } }
    }

    @Test
    fun testArea() {
        cases.forEach { it.apply {
            Assertions.assertEquals(
                area, retangulo.area(), TestUtil.TOLERANCE, String.format(
                    "%s de retangulo: area incorreta.\n %s ", id,
                    format(retangulo)
                )
            )
        } }
    }

    @Test
    fun testPerimetro() {
        cases.forEach { it.apply {
            Assertions.assertEquals(
                perimetro, retangulo.perimetro(), TestUtil.TOLERANCE, String.format(
                    "%s de retangulo: perimetro incorreto.\n %s ", id,
                    format(retangulo)
                )
            )
        } }
    }

    @Test
    fun testQuadrado() {
        cases.forEach { it.apply {
            Assertions.assertEquals(
                ehQuadrado, retangulo.quadrado(), String.format(
                    "%s de retangulo: teste de quadrado com falso negativo.\n %s ",
                    id,
                    format(retangulo)
                )
            )
        } }
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
            ), arrayOf(
                Ponto(0.2, 0.2),
                Ponto(0.8, 0.2),
                Ponto(0.6, 0.5),
                Ponto(0.0, 0.0)
            )
        )

        for (points in falseShapes) {
            Assertions.assertFalse(
                Retangulo.existe(
                    points[0], points[1], points[2], points[3]
                ),
                java.lang.String.format(
                    "Retangulo: teste de existencia retorna verdadeiro com pontos invalidos.\n %s ",
                    points.contentToString()
                )
            )
        }
    }
}