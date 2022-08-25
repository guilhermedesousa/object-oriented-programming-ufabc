import TestUtil.format
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.File
import java.io.FileNotFoundException
import java.util.*

internal class TrianguloTest {
    private data class Case(
        val id: String,
        val p1: Ponto,
        val p2: Ponto,
        val p3: Ponto,
        val triangulo: Triangulo,
        val largura: Double,
        val altura: Double,
        val area: Double,
        val perimetro: Double,
    )
    private val trianglesFile = TestUtil.baseDir + "triangles.csv"
    private val cases = mutableListOf<Case>()

    @BeforeEach
    private fun load() {
        try {
            Scanner(File(trianglesFile)).use { scanner ->
                var id = 0
                while (scanner.hasNext()) {
                    val p1 = Ponto(scanner.next().toDouble(), scanner.next().toDouble())
                    val p2 = Ponto(scanner.next().toDouble(), scanner.next().toDouble())
                    val p3 = Ponto(scanner.next().toDouble(), scanner.next().toDouble())
                    val triangulo = Triangulo(p1, p2, p3)
                    val largura = scanner.next().toDouble()
                    val altura = scanner.next().toDouble()
                    val area = scanner.next().toDouble()
                    val perimetro = scanner.next().toDouble()

                    cases.add(Case(
                        id = "case${++id}",
                        p1 = p1,
                        p2 = p2,
                        p3 = p3,
                        triangulo = triangulo,
                        largura = largura,
                        altura = altura,
                        area = area,
                        perimetro = perimetro
                    ))
                }
            }
        } catch (e: FileNotFoundException) {
            Assertions.fail(Exception("Falha ao abrir arquivo de casos de triangulos", e))
        } catch (e: Exception) {
            TestUtil.unexpectedExceptionThrown(e)
        }
    }

    @Test
    fun testLargura() {
        cases.forEach { it.apply {
            Assertions.assertEquals(
                largura, triangulo.largura(), TestUtil.TOLERANCE, String.format(
                    "%s de triangulo: largura incorreta.\n %s ", id,
                    format(triangulo)
                )
            )
        } }
    }

    @Test
    fun testAltura() {
        cases.forEach { it.apply {
            Assertions.assertEquals(
                altura, triangulo.altura(), TestUtil.TOLERANCE, String.format(
                    "%s de triangulo: altura incorreta.\n %s ", id,
                    format(triangulo)
                )
            )
        } }
    }

    @Test
    fun testArea() {
        cases.forEach { it.apply {
            Assertions.assertEquals(
                area, triangulo.area(), TestUtil.TOLERANCE, String.format(
                    "%s de triangulo: area incorreta.\n %s ", id,
                    format(triangulo)
                )
            )
        } }
    }

    @Test
    fun testPerimetro() {
        cases.forEach { it.apply {
            Assertions.assertEquals(
                perimetro, triangulo.perimetro(), TestUtil.TOLERANCE, String.format(
                    "%s de triangulo: perimetro incorreto.\n %s ", id,
                    format(triangulo)
                )
            )
        } }
    }
}