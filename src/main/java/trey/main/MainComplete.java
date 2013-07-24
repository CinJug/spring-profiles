package trey.main;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import trey.service.EventService;

public class MainComplete {

	private static final Logger LOG = Logger.getLogger(MainComplete.class);

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

		if (context.containsBean("quarantinedDataSource")) {
			LOG.info("Using quarantinedDataSource");
		}

		EventService service = context.getBean(EventService.class);

		while (true) {
			service.completePendingEvent();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				break;
			}
		}
	}

}
