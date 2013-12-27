package sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.core.PollableChannel;
import org.springframework.integration.message.GenericMessage;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith( SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = HelloIntegrationConfig.class)
public class HelloSpringIntegrationTest {
	@Autowired
	MessageChannel inputChannel;

	@Autowired
	PollableChannel outputChannel;

	@Test
	public void testHello() throws Exception {
		inputChannel.send(new GenericMessage<String>("World"));

		String actual = (String) outputChannel.receive().getPayload();

		assertThat(actual, is("Hello, World!!"));
	}

}
