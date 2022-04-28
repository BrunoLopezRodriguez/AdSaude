package com.bruno.adsaude.service;

import java.util.List;

import com.bruno.adsaude.model.Asistido;
import com.bruno.adsaude.model.AsistidoDTO;
import com.bruno.adsaude.service.impl.AsistidoServiceImpl;

public class AsistidoServiceTest {
	
	private AsistidoService asistidoService = null;
	
	public AsistidoServiceTest() {
		asistidoService= new AsistidoServiceImpl();	
	}
	
	
	private void assertUser(String login, String password) {
		try {
			AsistidoDTO asistido = asistidoService.login(login, password);
			if (asistido == null) {
				System.out.println("Usuario o password incorrecta");
			} else {
				System.out.println("Hola "+asistido.getNombre()+"!");
			}
		} catch (Exception e) {
			System.out.println("Por favor intentelo de nuevo más tarde.");
			e.printStackTrace();
		}
	}
	public void testLogin() {
		assertUser("kk@kk.com", "chantada");
		assertUser("pepitillo@gmail.com", "kk");
		assertUser("pepitillo@gmail.com", "chantada");		
	}
	public void testFindByFamiliar(){
		try {
		List<AsistidoDTO> asistido = asistidoService.findByFamiliar(1);
		
		for(AsistidoDTO as: asistido) {
			System.out.println(as.getNombre()+" "+as.getApellido1()+" "+as.getApellido2());
		}
		}catch (Exception e){
			System.out.println("Por favor intentelo de nuevo más tarde.");
			e.printStackTrace();
		}
	}
	
	public void testFindByRuta(){
		try {
		List<AsistidoDTO> asistido = asistidoService.findByRuta(1);
		
		for(AsistidoDTO as: asistido) {
			System.out.println(as.getNombre()+" "+as.getApellido1()+" "+as.getApellido2());
		}
		}catch (Exception e){
			System.out.println("Por favor intentelo de nuevo más tarde.");
			e.printStackTrace();
		}
	}

	public void testCreate(){
		try {
		Asistido a = new Asistido();
		a.setNombre("Bruno");
		a.setApellido1("Lopez");
		a.setApellido2("Rodriguez");
		a.setNif("43675227a");
		a.setTlf("666576576");
		a.setEmail("brunitosuper@hotmail.com");
		a.setPassword("patata");
		a.setDomicilio("Avelino Gomez Ledo 35 5ºA");
		a.setIdLocalidad(1);
		a.setIdMedico(1);
		
		Integer idAsistido = asistidoService.create(a);
		System.out.println("Exito Create "+idAsistido);
		}catch (Exception e){
			System.out.println("Por favor intentelo de nuevo más tarde.");
			e.printStackTrace();
		}
	}
	
	public void testUpdate(){
		try {
		Asistido a = new Asistido();
		a.setNombre("Bruno");
		a.setApellido1("Arias");
		a.setApellido2("Rodriguez");
		a.setNif("43675227a");
		a.setTlf("666576576");
		a.setEmail("brunitosuper@hotmail.com");
		a.setPassword("patata");
		a.setDomicilio("Avelino Gomez Ledo 35 5ºA");
		a.setIdLocalidad(1);
		a.setIdMedico(1);
		a.setId(10);
		
		 asistidoService.update(a);
		System.out.println("Exito Create ");
		}catch (Exception e){
			System.out.println("Por favor intentelo de nuevo más tarde.");
			e.printStackTrace();
		}
	}
	
	public static void main(String args[] ) {
		AsistidoServiceTest test = new AsistidoServiceTest();
		//test.testLogin();
		test.testFindByFamiliar();
		//test.testFindByRuta();
		//test.testCreate();
		//test.testUpdate();
	}
	
}
