package com.bruno.adsaude.service.impl;



import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.SimpleEmail;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bruno.adsaude.exception.MailException;
import com.bruno.adsaude.service.MailService;

public class MailServiceImpl implements MailService {

	private static Logger logger = LogManager.getLogger(MailServiceImpl.class);
	
	public MailServiceImpl() {

	}

	public void sendPlain(String from, String subject, String message, String... to) throws MailException {
		try {			
			if (logger.isDebugEnabled()) {
				logger.debug("Sending from "+from+" to "+to+"...");
			}
			Email email = new SimpleEmail();
			email.setHostName("smtp.gmail.com");
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator("calabacinpepinilloyberenjena@gmail.com", PASSWORD));
			email.setSSLOnConnect(true);
			email.setFrom(from);
			email.setSubject(subject);
			email.setMsg(message);

			email.addTo(to);
			email.send();
			logger.debug("Email sent");			
		}catch(EmailException e) {
			logger.error("Sending from "+from+" to "+to+"...", e);
			throw new MailException(e.getMessage(), e);
		}
	}

	public void sendHTML(String from, String subject, String htmlMessage, String... to) throws MailException{

		try {
			// Create the email message
			HtmlEmail email = new HtmlEmail();
			email.setHostName("smtp.gmail.com");
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator("calabacinpepinilloyberenjena@gmail.com", PASSWORD));
			email.setSSLOnConnect(true);
			email.setFrom(from);
			email.setSubject(subject);
			email.setHtmlMsg(htmlMessage);

			email.addTo(to);

			email.send();
			logger.debug("Email sent");			
		}
		catch(EmailException e) {
			logger.error("Sending from "+from+" to "+to+"...", e);
			throw new MailException();
		}
	}



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static final String PASSWORD ="Vegetables3";
}
