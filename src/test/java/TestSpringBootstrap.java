import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Sanity check that there are no broken references, etc.
 * 
 * @author Trey
 */
public class TestSpringBootstrap {

	@Test(expected = Exception.class)
	public void test_Missing() {
		new ClassPathXmlApplicationContext("spring.xml");
	}

	@Test
	public void test_Workstation() {
		System.setProperty("spring.profiles.active", "workstation");
		new ClassPathXmlApplicationContext("spring.xml");
	}

	@Test
	public void test_Dev() {
		System.setProperty("spring.profiles.active", "dev");
		new ClassPathXmlApplicationContext("spring.xml");
	}

}
