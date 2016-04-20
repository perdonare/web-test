import org.junit.Test;

/**
 * Created by perdonare on 2016/4/19.
 */
public class ExceptionTest {
    private Object o;
    @Test
    public void testException() {
        try {
            System.out.println(o);
        } catch (NullPointerException e) {
            System.out.println("null");
            throw e;
        } catch (Exception ex) {
            System.out.println("exception");
            ex.printStackTrace();
        }
    }
}
