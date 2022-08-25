import TestUtil.format
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.File
import java.io.FileNotFoundException
import java.util.*

internal class SegmentoRetaTest {
    private data class Case (
        val id: String,
        val p1: Ponto,
        val p2: Ponto,
        val segmento: SegmentoReta,
        val comprimento: Double,
        val coeficienteAngular: Double,
    )
    private val linesFile = TestUtil.baseDir + "lines.csv"
    private val cases = mutableListOf<Case>()

    @BeforeEach
    private fun load() {
        try {
            Scanner(File(linesFile)).use { scanner ->
                var caseNumber = 0
                while (scanner.hasNext()) {
                    val p1 = Ponto(scanner.next().toDouble(), scanner.next().toDouble())
                    val p2 = Ponto(scanner.next().toDouble(), scanner.next().toDouble())
                    val segmento = SegmentoReta(p1, p2)
                    val comprimento = scanner.next().toDouble()
                    val coeficienteAngular = scanner.next().toDouble()

                    cases.add(Case(
                        id = "case${++caseNumber}",
                        p1 = p1,
                        p2 = p2,
                        segmento = segmento,
                        comprimento = comprimento,
                        coeficienteAngular = coeficienteAngular
                    ))
                }
            }
        } catch (e: FileNotFoundException) {
            Assertions.fail(Exception("Falha ao abrir arquivos de casos para segmentos de reta", e))
        } catch (e: Exception) {
            TestUtil.unexpectedExceptionThrown(e)
        }
    }

    @Test
    fun testComprimento() {
        cases.forEach { it.apply {
            Assertions.assertEquals(
                comprimento, segmento.comprimento(), TestUtil.TOLERANCE, String.format(
                    "%s de segmento de reta: comprimento incorreto.\n %s ", id,
                    format(segmento)
                )
            )
        } }
    }

    @Test
    fun testCoeficienteAngular() {
        cases.forEach { it.apply {
            Assertions.assertEquals(
                coeficienteAngular,
                segmento.coeficienteAngular(),
                TestUtil.TOLERANCE,
                String.format(
                    "%s de segmento de reta: coeficiente angular incorreto.\n %s ", id,
                    format(segmento)
                )
            )
        } }
    }

    @Test
    fun testAutoParalelo() {
        cases.forEach { it.apply {
            Assertions.assertEquals(true, segmento.paralelo(segmento),
            "Um segmento de reta eh sempre paralelo a si mesmo")
        }}
    }

}