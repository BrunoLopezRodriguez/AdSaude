package com.bruno.adsaude.service;

import java.util.List;

import com.bruno.adsaude.model.Empleado;
import com.bruno.adsaude.model.EmpleadoDTO;
import com.bruno.adsaude.service.impl.EmpleadoServiceImpl;

public class EmpleadoServiceTest {

private EmpleadoService empleadoService = null;
	
	public EmpleadoServiceTest() {
		empleadoService= new EmpleadoServiceImpl();	
	}
	
	private void assertUser(String login, String password) {
		try {
			EmpleadoDTO empleado = empleadoService.login(login, password);
			if (empleado == null) {
				System.out.println("Usuario o password incorrecta");
			} else {
				System.out.println("Hola "+empleado.getNombre()+"!");
			}
		} catch (Exception e) {
			System.out.println("Por favor intentelo de nuevo más tarde.");
			e.printStackTrace();
		}
	}
	public void testLogin() {
		assertUser("kk@kk.com", "chantada");
		assertUser("raulito@gmail.com", "kk");
		assertUser("raulito@gmail.com", "chantada");		
	}
	
	public void testFindByServicio(){
		try {
		List<EmpleadoDTO> empleado = empleadoService.findByServicio(5);
		
		for(EmpleadoDTO em: empleado) {
			System.out.println(em.getNombre()+" "+em.getApellido1()+" "+em.getApellido2());
		}
		}catch (Exception e){
			System.out.println("Por favor intentelo de nuevo más tarde.");
			e.printStackTrace();
		}
	}
	
	public void testUpdate(){
		try {
		Empleado e = new Empleado();
		e.setNombre("Raquel");
		e.setApellido1("Arias");
		e.setApellido2("Gomez");
		e.setNif("43675227a");
		e.setTlf("666576576");
		e.setEmail("raquelita@gmail.com");
		e.setPassword("patata");
		e.setDomicilio("Avelino Gomez Ledo 35 5ºA");
		e.setIdLocalidad(2);
		e.setIdTipoEmpleado(3);
		e.setId(4);
		
		 empleadoService.update(e);
		System.out.println("Exito Update ");
		}catch (Exception e){
			System.out.println("Por favor intentelo de nuevo más tarde.");
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		EmpleadoServiceTest test = new EmpleadoServiceTest();
		//test.testLogin();
		//test.testFindByServicio();
		test.testUpdate();
	}

}
