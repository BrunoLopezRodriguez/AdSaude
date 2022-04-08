package com.bruno.adsaude.service;

import java.util.List;

import com.bruno.adsaude.model.Localidad;
import com.bruno.adsaude.service.impl.LocalidadServiceImpl;

public class LocalidadServiceTest {

	private LocalidadService localidadService=null;
	
	public LocalidadServiceTest() {
		localidadService = new LocalidadServiceImpl();
	}
	
	public void testFindByProvincia(){
		try {
		List<Localidad> localidad = localidadService.findByProvincia(1);
		
		for(Localidad l: localidad) {
			System.out.println(l.getId()+" "+l.getIdProvincia()+" "+l.getNombre()+" "+l.getNombreProvincia());
		}
		}catch (Exception e){
			System.out.println("Por favor intentelo de nuevo más tarde.");
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		LocalidadServiceTest test = new LocalidadServiceTest();
		test.testFindByProvincia();
	}

}
