package com.bruno.adsaude.service;

import com.bruno.adsaude.model.AsistidoFamiliar;
import com.bruno.adsaude.service.impl.AsistidoFamiliarServiceImpl;

public class AsistidoFamiliarServiceTest {

	
private AsistidoFamiliarService asistidoFamiliarService = null;
	
	public AsistidoFamiliarServiceTest() {
		asistidoFamiliarService= new AsistidoFamiliarServiceImpl();	
	}
	
	public void testCreate(){
		try {
			AsistidoFamiliar af = new AsistidoFamiliar();
		af.setIdAsistido(10);
		af.setIdFamiliar(3);
		
		asistidoFamiliarService.create(af);
		
		System.out.println("Exito Create ");
		}catch (Exception e){
			System.out.println("Por favor intentelo de nuevo más tarde.");
			e.printStackTrace();
		}
	}

	
	public void testDelete(){
		try {
			AsistidoFamiliar af = new AsistidoFamiliar();
		af.setIdAsistido(10);
		af.setIdFamiliar(3);
		
		asistidoFamiliarService.delete(10,3);
		
		System.out.println("Exito delete ");
		}catch (Exception e){
			System.out.println("Por favor intentelo de nuevo más tarde.");
			e.printStackTrace();
		}
	}
	
	
	
	
	
	public static void main(String[] args) {
		AsistidoFamiliarServiceTest test = new AsistidoFamiliarServiceTest();
		test.testCreate();
		
		//test.testDelete();
		
	}

}
