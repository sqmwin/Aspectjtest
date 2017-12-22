package annotation;

import com.sqm.aspectj.annotation.service.UserService;
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
public class AnnotationTest {
    private ApplicationContext context;
    @Before
    public void setUp() {
        context = new ClassPathXmlApplicationContext("aspectj/aspectj-spring-context.xml");
    }

    //前置增强,advice中可设方法参数JoinPoint,为切入点表达式,通过joinPoint可获得切入点表达式,方法签名,目标对象,目标方法实际参数
    @Test
    public void test01() {
        UserService service = (UserService) context.getBean("userServiceTarget");
        service.doSome();
        service.doOther(1, "b");
        service.doThird();
    }

    //后置增强,advice中除了可以设方法参数JoinPoint,也可以获取目标方法的返回值参数,并在注解中用returning表示
    @Test
    public void test02() {
        UserService service = (UserService) context.getBean("userServiceTarget");
        service.doThird();
    }

    //环绕通知,方法拦截器,目标方法必须有返回值,方法拦截器通过ProceedingJoinPoint的proceed()方法执行目标方法;在proceed()方法前的代码为目标方法前执行,反之在目标方法后执行
    @Test
    public void test03() {
        UserService service = (UserService) context.getBean("userServiceTarget");
        String result = service.doThird();
        System.out.println(result);
    }
}
