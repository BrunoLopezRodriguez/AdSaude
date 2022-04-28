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
import com.bruno.adsaude.service.util.ConfigurationManager;

public class MailServiceImpl implements MailService {

	private static final String SERVICE_MAIL_PFX = "service.mail."; 
	private static final String ACCOUNT_PARAMETER_NAME = SERVICE_MAIL_PFX + "account";
	private static final String SERVER_PARAMETER_NAME = SERVICE_MAIL_PFX + "server";
	private static final String PASSWORD_PARAMETER_NAME = SERVICE_MAIL_PFX + "password";
	private static final String PORT_PARAMETER_NAME = SERVICE_MAIL_PFX + "port";
	private static Logger logger = LogManager.getLogger(MailServiceImpl.class);
	
	public MailServiceImpl() {

	}

	public void sendPlain(String from, String subject, String message, String... to) throws MailException {
		
		ConfigurationManager cfg = ConfigurationManager.getInstance();
		try {			
			if (logger.isDebugEnabled()) {
				logger.debug("Sending from "+from+" to "+to+"...");
			}
			Email email = new SimpleEmail();
			email.setHostName(cfg.getParameter(SERVER_PARAMETER_NAME));
			email.setSmtpPort(Integer.valueOf(cfg.getParameter(PORT_PARAMETER_NAME)));
			email.setAuthenticator(new DefaultAuthenticator(cfg.getParameter(ACCOUNT_PARAMETER_NAME), cfg.getParameter(PASSWORD_PARAMETER_NAME)));
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
		ConfigurationManager cfg = ConfigurationManager.getInstance();
		try {
			// Create the email message
			HtmlEmail email = new HtmlEmail();
			email.setHostName(cfg.getParameter(SERVER_PARAMETER_NAME));
			email.setSmtpPort(Integer.valueOf(cfg.getParameter(PORT_PARAMETER_NAME)));
			email.setAuthenticator(new DefaultAuthenticator(cfg.getParameter(ACCOUNT_PARAMETER_NAME), cfg.getParameter(PASSWORD_PARAMETER_NAME)));
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
}
