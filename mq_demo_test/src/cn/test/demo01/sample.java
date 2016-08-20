package cn.test.demo01;

import java.util.Hashtable;
import javax.jms.*;
import javax.naming.*;
import javax.naming.directory.*;

public class sample {
	protected QueueConnectionFactory factory = null;
	protected QueueConnection connection;
	protected QueueSession queueSession;
	protected TextMessage outMessage;
	protected QueueSender queueSender;
	protected QueueReceiver queueReceiver;

	public static final String qcfLookup = "EXAMPLEQCF";
	public static final String qLookup = "EXAMPLEQL";
	public static final String icf = "com.sun.jndi.fscontext.RefFSContextFactory";
	public String url = "file:/d:/temp";

	public void sampleInit() throws Exception {
		Hashtable environment = new Hashtable();
		environment.put(Context.INITIAL_CONTEXT_FACTORY, icf);
		environment.put(Context.PROVIDER_URL, url);
		environment.put(Context.REFERRAL, "throw");
		Context ctx = new InitialDirContext(environment);
		factory = (QueueConnectionFactory) ctx.lookup(qcfLookup);
		Queue q1 = null;
		q1 = (Queue) ctx.lookup(qLookup);
		connection = factory.createQueueConnection();
		queueSession = connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);

		queueSender = queueSession.createSender(q1);
		queueSender.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
		outMessage = queueSession.createTextMessage();
		queueReceiver = queueSession.createReceiver(q1);
		connection.start();
	}

	public void sendMessageOut(String message) throws JMSException {
		outMessage.setText(message);
		queueSender.send(outMessage);
	}

	public String receiveMessage() throws Exception {
		return ((TextMessage) queueReceiver.receive()).getText();
	}

	public void sampleClose() throws JMSException {
		queueSession.close();
		connection.close();
	}

	public static void main(String[] args) {
		String rec;
		sample sp = new sample();
		try {
			sp.sampleInit();
			sp.sendMessageOut("Hello World!");
			java.lang.Thread.sleep(4000);
			rec = sp.receiveMessage();
			System.out.println("Receive text is : " + rec);
			sp.sampleClose();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}