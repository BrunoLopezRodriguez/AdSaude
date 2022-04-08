package com.bruno.adsaude.service;

import java.util.List;

import com.bruno.adsaude.model.Pais;
import com.bruno.adsaude.service.impl.PaisServiceImpl;

public class PaisServiceTest {

	private PaisService paisService=null;
	
	public PaisServiceTest() {
		paisService = new PaisServiceImpl();
	}
	
	public void testFindBy() {
		try {
			List <Pais> pais=paisService.findBy();
			for(Pais p : pais) {
				System.out.println(p.getId()+" "+p.getNombre());
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Fallo FindBy");
		}
	}
	
	
	public static void main(String[] args) {
		PaisServiceTest test = new PaisServiceTest();
		test.testFindBy();
		
		
	}

}
