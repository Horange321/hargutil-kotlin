import hora.Hargs;
import org.junit.Test;
import org.junit.Assert;

public class Tester1 {
    @Test
    public void test1() {
        final Hargs a = new Hargs("-v -a=asd --force=true");
        a.add("v", "version", "v")
                .add("a", "", "asd")
                .add("", "force", "f")
                .add("", "none", "none");
        final var ar = a.toMap();

        Assert.assertEquals("", ar.get("v"));
        Assert.assertEquals("asd", ar.get("asd"));
        Assert.assertEquals("true", ar.get("f"));
        Assert.assertEquals(null, ar.get("none"));
    }
}
