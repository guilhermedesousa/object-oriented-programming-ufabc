import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.File
import java.io.FileNotFoundException
import java.util.Scanner

class SegmentRetaParaleloTest {
    private data class Case (
        val segmentoA: SegmentoReta,
        val segmentoB: SegmentoReta,
        val paraleloAB: Boolean,
        val paraleloBA: Boolean
    )
    private val parallelLinesFile = "src/test/resources/parallel_lines.csv";
    private val cases = mutableListOf<Case>()

    @BeforeEach
    private fun load() = try {
        Scanner(File(parallelLinesFile)).use {scanner ->
            while (scanner.hasNext()) {
                val segmentoA = SegmentoReta(
                    Ponto(scanner.nextDouble(), scanner.nextDouble()),
                    Ponto(scanner.nextDouble(), scanner.nextDouble()))

                for (i in 0 until scanner.nextInt()) {
                    val segmentoB = SegmentoReta(
                        Ponto(scanner.nextDouble(), scanner.nextDouble()),
                        Ponto(scanner.nextDouble(), scanner.nextDouble())
                    )
                    cases.add(
                        Case(
                            segmentoA = segmentoA,
                            segmentoB = segmentoB,
                            paraleloAB = scanner.nextBoolean(),
                            paraleloBA = scanner.nextBoolean()))
                }
            }
        }
    } catch (e: FileNotFoundException) {
        Assertions.fail("Falha ao abrir arquivos de casos para segmentos de reta", e)
    } catch (e: Exception) {
        TestUtil.unexpectedExceptionThrown(e)
    }

    @Test
    fun testParalelos() {
        cases.forEach {it.apply {
          Assertions.assertEquals(paraleloAB, segmentoA.paralelo(segmentoB),
          "Teste incorreto de paralelismo. Segmentos: " +
                  "${TestUtil.format(segmentoA)} e ${TestUtil.format(segmentoB)}")
        Assertions.assertEquals(paraleloBA, segmentoB.paralelo(segmentoA),
                "Teste incorreto de paralelismo. Segmentos: " +
                        "${TestUtil.format(segmentoB)} e ${TestUtil.format(segmentoA)}")
        } }
    }
}