package technology.it.stack.jms.producer;

import java.io.File;

import javax.annotation.PostConstruct;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.apache.activemq.broker.BrokerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;
import org.springframework.util.FileSystemUtils;

@Component
public class VmProducer {
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Autowired
	private Destination destnantion;
	
	@PostConstruct
	public void init(){
		BrokerService bs = new BrokerService();
		bs.setUseJmx(false);
		bs.setPersistent(false);
		try {
			bs.addConnector("tcp://localhost:61617");
			bs.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
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
