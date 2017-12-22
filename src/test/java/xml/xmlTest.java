package xml;

import com.sqm.aspectj.xml.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <p>
 *
 * @author sqm
 * @version 1.0
 */
public class xmlTest {
    private ApplicationContext context;

    @Before
    public void setUp() {
        context = new ClassPathXmlApplicationContext("aspectj/aspectj-xml-context.xml");
    }

    @Test
    public void test01() {
        UserService userService = (UserService) context.getBean("userServiceTarget");
        userService.doSome();
        int other = userService.doOther(1, "b");
        System.out.println(other);
        String third = userService.doThird();
        System.out.println(third);
    }
}
