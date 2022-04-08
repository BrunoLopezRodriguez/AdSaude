package com.bruno.adsaude.service;

import java.util.List;

import com.bruno.adsaude.model.Familiar;
import com.bruno.adsaude.model.FamiliarDTO;
import com.bruno.adsaude.service.impl.FamiliarServiceImpl;

public class FamiliarServiceTest {
	
private FamiliarService familiarService = null;
	
	public FamiliarServiceTest() {
		familiarService= new FamiliarServiceImpl();	
	}
	
	public void testFindByAsistido(){
		try {
		List<FamiliarDTO> familiar = familiarService.findByAsistido(1);
		
		for(FamiliarDTO fa: familiar) {
			System.out.println(fa.getNombre()+" "+fa.getApellido1()+" "+fa.getApellido2());
		}
		}catch (Exception e){
			System.out.println("Por favor intentelo de nuevo más tarde.");
			e.printStackTrace();
		}
	}
	
	private void assertUser(String login, String password) {
		try {
			FamiliarDTO familiar = familiarService.login(login, password);
			if (familiar == null) {
				System.out.println("Usuario o password incorrecta");
			} else {
				System.out.println("Hola "+familiar.getNombre()+"!");
			}
		} catch (Exception e) {
			System.out.println("Por favor intentelo de nuevo más tarde.");
			e.printStackTrace();
		}
	}
	public void testLogin() {
		assertUser("kk@kk.com", "chantada");
		assertUser("josito@gmail.com", "kk");
		assertUser("josito@gmail.com", "chantada");		
	}
	
	public void testCreate(){
		try {
		Familiar f = new Familiar();
		f.setNombre("Bruno");
		f.setApellido1("Lopez");
		f.setApellido2("Rodriguez");
		f.setNif("43675227a");
		f.setTlf("666576576");
		f.setEmail("brunitosuper@hotmail.com");
		f.setPassword("patata");
		f.setDomicilio("Avelino Gomez Ledo 35 5ºA");
		f.setIdLocalidad(1);

		Integer idFamiliar = familiarService.create(f);
		System.out.println("Exito Create "+idFamiliar);
		}catch (Exception e){
			System.out.println("Por favor intentelo de nuevo más tarde.");
			e.printStackTrace();
		}
	}
	
	public void testUpdate(){
		try {
		Familiar f = new Familiar();
		f.setNombre("Bruno");
		f.setApellido1("Arias");
		f.setApellido2("Rodriguez");
		f.setNif("43675227a");
		f.setTlf("666576576");
		f.setEmail("brunitosuper@hotmail.com");
		f.setPassword("patata");
		f.setDomicilio("Avelino Gomez Ledo 35 5ºA");
		f.setIdLocalidad(1);
		
		f.setId(11);
		
		familiarService.update(f);
		System.out.println("Exito Update ");
		}catch (Exception e){
			System.out.println("Por favor intentelo de nuevo más tarde.");
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		FamiliarServiceTest test = new FamiliarServiceTest();
		//test.testFindByAsistido();
		//test.testLogin();
		//test.testCreate();
		test.testUpdate();
	}

}
