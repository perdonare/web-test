import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by perdonare on 2016/4/18.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration({"classpath:spring-config.xml"})
public class SpringCoreTest {
    @Test
    public void testSpringCore() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:src/test/spring-config.xml");
        System.out.println("start successful");
    }
}
