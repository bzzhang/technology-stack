package technology.it.stack.jms.customer;

import java.io.File;

import javax.jms.Message;
import javax.jms.MessageListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.util.FileSystemUtils;

@Component
public class Receiver implements MessageListener {

    /**
     * Get a copy of the application context
     */
  /*  @Autowired
    ConfigurableApplicationContext context;*/

    /**
     * When you receive a message, print it out, then shut down the application.
     * Finally, clean up any ActiveMQ server stuff.
     */
    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
//        context.close();
        FileSystemUtils.deleteRecursively(new File("activemq-data"));
    }

	@Override
	public void onMessage(Message message) {
	     System.out.println("Received <" + message.DEFAULT_PRIORITY + ">");
	}
}