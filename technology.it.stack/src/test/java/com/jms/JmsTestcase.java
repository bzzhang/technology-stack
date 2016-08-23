package com.jms;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import technology.it.stack.jms.producer.Producer;
import technology.it.stack.jms.producer.VmProducer;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class JmsTestcase {
	
	@Autowired
	private Producer producter;
	
	@Autowired
	private VmProducer vmproducter;
	
	@Test
	public void jmsdemo(){
		producter.messageCreate();
	}
	
	@Test
	public void vmjmsdemo(){
		vmproducter.messageCreate();
	}
	

}
