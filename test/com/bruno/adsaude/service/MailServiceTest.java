package com.bruno.adsaude.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bruno.adsaude.service.impl.MailServiceImpl;

public class MailServiceTest {

	private static Logger logger = LogManager.getLogger(MailServiceTest.class);	
	
	private MailService mailservice=null;
	
	public MailServiceTest() {
		mailservice = new MailServiceImpl();
	}
	
	public void testSendPlain() {
		logger.trace("Entrando...");
		
		try {
			String from = "no-reply@gmail.com";
			String to = "brunitosuper@hotmail.com";
			mailservice.sendPlain(from , "Test", "Testeando el mail service", to);
			
			logger.info("Mail a "+to+": Enviado con éxito.");
		}catch (Exception e) {
			logger.error(e);			
		}
	}
	
	public static void main(String[] args) {
		MailServiceTest test = new MailServiceTest();
		test.testSendPlain();

	}

}
