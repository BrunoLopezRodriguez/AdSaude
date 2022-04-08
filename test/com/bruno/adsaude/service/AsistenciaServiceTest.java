package com.bruno.adsaude.service;

import java.util.List;

import com.bruno.adsaude.model.AsistenciaCriteria;
import com.bruno.adsaude.model.AsistenciaDTO;
import com.bruno.adsaude.service.impl.AsistenciaServiceImpl;

public class AsistenciaServiceTest {

private AsistenciaService asistenciaService = null;
	
	public AsistenciaServiceTest() {
		asistenciaService= new AsistenciaServiceImpl();	
	}
	
	public void testCriteria(){
		try {
			AsistenciaCriteria ac = new AsistenciaCriteria();
			
		
			ac.setIdAsistido(1);
			
		List<AsistenciaDTO> asistencia = asistenciaService.findByCriteria(ac);
		
		for(AsistenciaDTO as: asistencia) {
			System.out.println(as.getNombreAsistido()+" "+as.getNombreEmpleado()+" "+as.getNombreServicio());
		}
		}catch (Exception e){
			System.out.println("Por favor intentelo de nuevo más tarde.");
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		AsistenciaServiceTest test = new AsistenciaServiceTest();
		test.testCriteria();
		
	
	}

}
