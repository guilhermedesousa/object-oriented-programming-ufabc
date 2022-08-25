import org.junit.jupiter.api.Assertions

object TestUtil {
    const val baseDir = "src/test/resources/"
    const val TOLERANCE = 0.001

    fun unexpectedExceptionThrown(e: Exception) {
        e.printStackTrace()
        Assertions.fail<Any>(
            "Uma excecao nao prevista ocorreu durante os testes. Verifique o stacktrace e conserte seu codigo."
        )
    }

    fun format(elipse: Elipse): String {
        return (elipse.javaClass.name + " {"
                + "centro=" + elipse.centro
                + ", eixoSemiMenor=" + elipse.eixoSemiMenor
                + ", eixoSemiMaior=" + elipse.eixoSemiMaior
                + "} ")
    }

    fun format(circulo: Circulo): String {
        return (circulo.javaClass.name + " {"
                + "centro=" + circulo.centro
                + "raio=" + circulo.raio
                + "} ")
    }

    fun format(semiCirculo: SemiCirculo): String {
        return (semiCirculo.javaClass.name + " {"
                + "centro=" + semiCirculo.centro
                + "raio=" + semiCirculo.raio
                + "} ")
    }

    fun format(segmentoReta: SegmentoReta): String {
        return (segmentoReta.javaClass.name + " {"
                + "p1=" + segmentoReta.p1
                + ", p2=" + segmentoReta.p2
                + "} ")
    }

    fun format(quadrilatero: Quadrilatero): String {
        return (quadrilatero.javaClass.name + " {"
                + "p1=" + quadrilatero.p1
                + ", p2=" + quadrilatero.p2
                + ", p3=" + quadrilatero.p3
                + ", p4=" + quadrilatero.p4
                + "} ")
    }

    fun format(triangulo: Triangulo): String {
        return (triangulo.javaClass.name + " {"
                + "p1=" + triangulo.p1
                + ", p2=" + triangulo.p2
                + ", p3=" + triangulo.p3
                + "} ")
    }
}