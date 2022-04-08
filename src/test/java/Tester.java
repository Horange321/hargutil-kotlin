import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

public class Tester {
    public static Result test(Class<?>... c) {
        Result r = JUnitCore.runClasses(c);
        for (var i : r.getFailures()) {
            System.out.println(i);
        }
        System.out.println("* " + (r.wasSuccessful() ? "Success" : "Failure"));
        return r;
    }

    public static void main(String[] args) {
        test(Tester1.class);
//        test(Tester2.class);
    }
}
