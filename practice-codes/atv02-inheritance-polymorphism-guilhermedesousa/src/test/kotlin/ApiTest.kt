import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.lang.reflect.Method
import java.lang.reflect.Modifier
import java.util.*

/**
 * Test conformance to the expected API.
 */
internal class ApiTest {
    /*
     * Utility method to verify interface implementation.
     */
    private fun implementsInterface(childClass: String, theInterface: String): Boolean {
        try {
            val theClassObj = Class.forName(childClass)
            val interfaces = theClassObj.interfaces
            for (interf in interfaces) {
                if (interf.name == theInterface) {
                    return true
                }
            }
        } catch (e: ClassNotFoundException) {
            Assertions.fail<Any>("Class $childClass or $theInterface is not present")
        }
        return false
    }

    /*
     * Utility method to check if a class extends other class.
     */
    private fun extendsClass(theClass: String?, anotherClass: String): Boolean {
        try {
            val theClassObj = Class.forName(theClass)
            if (anotherClass == theClassObj.superclass.name) {
                return true
            }
        } catch (e: ClassNotFoundException) {
            Assertions.fail<Any>("Classe $theClass or $anotherClass nao esta presente")
        }
        return false
    }

    @Test
    fun testSegmentoReta() {
        Assertions.assertTrue(
            implementsInterface("SegmentoReta", "ObjetoGeometrico"),
            "SegmentoReta deve implementar ObjetoGeometrico"
        )
    }

    @Test
    fun testFormaGeometrica() {
        Assertions.assertTrue(
            implementsInterface("FormaGeometrica", "ObjetoGeometrico"),
            "FormaGeometrica deve implementar ObjetoGeometrico"
        )
        Assertions.assertTrue(
            Modifier.isAbstract(
                FormaGeometrica::class.java.modifiers
            ),
            "FormaGeometrica deve ser abstrata"
        )
        Assertions.assertTrue(
            Arrays.stream(FormaGeometrica::class.java.declaredMethods).anyMatch {
                    m: Method -> "largura" == m.name
                    && Modifier.isAbstract(m.modifiers)
                    && m.returnType == Double::class.javaPrimitiveType },
            "FormaGeometrica.largura() deve estar presente, ser abstrata e retornar um double"
        )
        Assertions.assertTrue(
            Arrays.stream(FormaGeometrica::class.java.declaredMethods).anyMatch {
                    m: Method -> "altura" == m.name
                    && Modifier.isAbstract(m.modifiers)
                    && m.returnType == Double::class.javaPrimitiveType },
            "FormaGeometrica.altura() deve estar presente, ser abstrata e retornar um double"
        )
        Assertions.assertTrue(
            Arrays.stream(
                FormaGeometrica::class.java.declaredMethods
            ).anyMatch {
                    m: Method -> "area" == m.name
                    && Modifier.isAbstract(m.modifiers)
                    && m.returnType == Double::class.javaPrimitiveType },
            "FormaGeometrica.area() deve estar presente, ser abstrata e retornar um double"
        )
        Assertions.assertTrue(
            Arrays.stream(
                FormaGeometrica::class.java.declaredMethods
            ).anyMatch {
                    m: Method -> "perimetro" == m.name
                    && Modifier.isAbstract(m.modifiers)
                    && m.returnType == Double::class.javaPrimitiveType },
            "FormaGeometrica.perimetro() deve estar presente, ser abstrata e retornar um double\""
        )
    }

    @Test
    fun testPoligono() {
        Assertions.assertTrue(
            implementsInterface("Poligono", "FormaGeometrica"),
            "Poligono deve implementar FormaGeometrica"
        )
        Assertions.assertTrue(Modifier.isAbstract(Poligono::class.java.modifiers),
        "Poligono deve ser abstrata")
    }

    @Test
    fun testTriangulo() {
        Assertions.assertTrue(extendsClass("Triangulo", "Poligono"),
        "Triangulo deve estender Polígono")
    }

    @Test
    fun testQuadrilatero() {
        Assertions.assertTrue(
            extendsClass("Quadrilatero", "Poligono"),
            "Quadrilatero deve estender Poligono"
        )
    }

    @Test
    fun testTrapezio() {
        Assertions.assertTrue(
            extendsClass("Trapezio", "Quadrilatero"),
            "Trapezio deve estender Quadrilatero"
        )
    }

    @Test
    fun testParalelogramo() {
        Assertions.assertTrue(
            extendsClass("Paralelogramo", "Trapezio"),
            "Trapezio deve estender Paralelogramo"
        )
    }

    @Test
    fun testRetangulo() {
        Assertions.assertTrue(
            extendsClass("Retangulo", "Paralelogramo"),
            "Retangulo deve estender Paralelogramo"
        )
    }

    @Test
    fun testEllipse() {
        Assertions.assertTrue(
            implementsInterface("Elipse", "FormaGeometrica"),
            "Elipse deve implementar FormaGeometrica"
        )
    }

    @Test
    fun testCircle() {
        Assertions.assertTrue(extendsClass("Circulo", "Elipse"),
            "Circle deve estender Ellipse")
    }

    @Test
    fun testSemiCirculo() {
        Assertions.assertTrue(
            implementsInterface("SemiCirculo", "FormaGeometrica"),
            "SemiCirculo deve implementar FormaGeometrica"
        )
    }
}