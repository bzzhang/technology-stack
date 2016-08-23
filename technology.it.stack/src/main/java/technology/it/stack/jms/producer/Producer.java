package technology.it.stack.jms.producer;

import org.springframework.stereotype.Component;
import java.io.File;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jca.cci.connection.SingleConnectionFactory;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.config.SimpleJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.util.FileSystemUtils;

@Component
public class Producer {
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Autowired
	private Destination destnantion;
	
	
	public void messageCreate(){
		 FileSystemUtils.deleteRecursively(new File("activemq-data"));
		 MessageCreator messageCreator = new MessageCreator() {
	            @Override
	            public Message createMessage(Session session) throws JMSException {
	                return session.createTextMessage("ping!");
	            }
	        };
	        System.out.println("Sending a new message.");
	        jmsTemplate.send(destnantion, messageCreator);
	        System.out.println("Sending a new message.");
		
	}	

}

