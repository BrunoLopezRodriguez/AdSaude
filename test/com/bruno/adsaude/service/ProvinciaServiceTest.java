package com.bruno.adsaude.service;

import java.util.List;

import com.bruno.adsaude.model.Provincia;
import com.bruno.adsaude.service.impl.ProvinciaServiceImpl;

public class ProvinciaServiceTest {
	
	private ProvinciaService provinciaService=null;
	
	public ProvinciaServiceTest() {
		provinciaService = new ProvinciaServiceImpl();
	}
	
	public void testFindByPais() {
		try {
			List <Provincia> provincia = provinciaService.findByPais(1);
			for (Provincia p : provincia) {
				System.out.println(p.getId()+" "+p.getIdPais()+" "+p.getNombre()+" "+p.getNombrePais());
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("error test findbyPais");
		}
	}

	public static void main(String[] args) {
		ProvinciaServiceTest test = new ProvinciaServiceTest();
		test.testFindByPais();
	}

}
