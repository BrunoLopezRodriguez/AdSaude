package com.bruno.adsaude.service;

import com.bruno.adsaude.exception.MailException;

public interface MailService {
	
	public void sendPlain(String from,  String subject, String message, String... to) throws MailException;
	
	public void sendHTML(String from, String subject,  String htmlMessage, String... to)throws MailException;

}
