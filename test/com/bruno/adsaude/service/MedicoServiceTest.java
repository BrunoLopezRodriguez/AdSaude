package com.bruno.adsaude.service;

import com.bruno.adsaude.model.MedicoDTO;
import com.bruno.adsaude.service.impl.MedicoServiceImpl;

public class MedicoServiceTest {

	private MedicoService medicoService=null;
	
	public MedicoServiceTest() {
		medicoService = new MedicoServiceImpl();
	}
	
	private void assertUser(String login, String password) {
		try {
			MedicoDTO medico = medicoService.login(login, password);
			if (medico == null) {
				System.out.println("Usuario o password incorrecta");
			} else {
				System.out.println("Hola "+medico.getNombre()+"!");
			}
		} catch (Exception e) {
			System.out.println("Por favor intentelo de nuevo más tarde.");
			e.printStackTrace();
		}
	}
	public void testLogin() {
		assertUser("kk@kk.com", "chantada");
		assertUser("pablito@gmail.com", "kk");
		assertUser("pablito@gmail.com", "chantada");		
	}
	
	
	public static void main(String[] args) {
		MedicoServiceTest test = new MedicoServiceTest();
		test.testLogin();
	}

}
