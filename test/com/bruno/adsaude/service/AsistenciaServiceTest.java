package com.bruno.adsaude.service;

import java.util.Date;

import com.bruno.adsaude.model.AsistenciaCriteria;
import com.bruno.adsaude.model.AsistenciaDTO;
import com.bruno.adsaude.model.Results;
import com.bruno.adsaude.service.impl.AsistenciaServiceImpl;

public class AsistenciaServiceTest {

private AsistenciaService asistenciaService = null;
	
	public AsistenciaServiceTest() {
		asistenciaService= new AsistenciaServiceImpl();	
	}
	
	public void testCriteria(){
		try {
			AsistenciaCriteria ac = new AsistenciaCriteria();
			Date d = new Date();
		
//			ac.setIdAsistido(1);
//			ac.setIdEmpleado(1);
//			ac.setIdServicio(14);
			ac.setFechaHoraFin(d);
//			ac.setFechaHoraInicio(null);
			int startIndex = 1;
			int pageSize = 5;
			Results<AsistenciaDTO> asistencia =new Results<AsistenciaDTO>();
			do {
				
		 asistencia = asistenciaService.findByCriteria(ac, startIndex, pageSize);
		 System.out.println("Encontrados "+asistencia.getTotal()+" resultados");
			System.out.println("Mostrando del "+startIndex+" al "+(startIndex+asistencia.getData().size()-1));
			startIndex = startIndex+asistencia.getData().size();
		for(AsistenciaDTO as: asistencia.getData()) {
			System.out.println(as.getNombreAsistido()+" "+as.getNombreEmpleado()+" "+as.getNombreServicio());
		}
			} while (startIndex<=asistencia.getTotal());
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
