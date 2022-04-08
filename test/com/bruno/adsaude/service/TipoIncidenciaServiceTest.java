package com.bruno.adsaude.service;

import java.util.List;

import com.bruno.adsaude.model.TipoIncidencia;
import com.bruno.adsaude.service.impl.TipoIncidenciaServiceImpl;

public class TipoIncidenciaServiceTest {

	private TipoIncidenciaService tipoIncidenciaService=null;
	
	public TipoIncidenciaServiceTest() {
		tipoIncidenciaService = new TipoIncidenciaServiceImpl();
	}
	 public void testFindBy() {
		 try {
			 List<TipoIncidencia> tipoIncidencia=tipoIncidenciaService.findBy();
			 for(TipoIncidencia ti : tipoIncidencia) {
				 System.out.println(ti.getId()+" "+ti.getNombre());
			 }
			 
		 }catch ( Exception e) {
			 e.printStackTrace();
			 System.out.println("error testfindby");
		 }
	 }
	
	
	public static void main(String[] args) {
		TipoIncidenciaServiceTest test= new TipoIncidenciaServiceTest();
		test.testFindBy();
	}

}
