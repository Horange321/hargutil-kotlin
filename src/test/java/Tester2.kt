import hora.Hargs
import org.junit.Assert
import org.junit.Test

class Tester2 {
    @Test
    fun test2() {
        val a = Hargs("-v -a=asd --force=true")
        a.add("v", "version", "v")
            .add("a", "", "asd")
            .add("", "force", "f")
            .add("", "none", "none")
        val ar = a.toMap()

        Assert.assertEquals("", ar["v"])
        Assert.assertEquals("asd", ar["asd"])
        Assert.assertEquals("true", ar["f"])
        Assert.assertEquals(null, ar["none"])
    }
}