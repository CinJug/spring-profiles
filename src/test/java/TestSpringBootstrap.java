import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Sanity check that there are no broken references, etc.
 * 
 * @author Trey
 */
public class TestSpringBootstrap {

	@Test
	public void test_LoadContext() {
		new ClassPathXmlApplicationContext("spring.xml");
	}

}
