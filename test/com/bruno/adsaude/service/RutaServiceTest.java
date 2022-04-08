package com.bruno.adsaude.service;

import java.util.List;

import com.bruno.adsaude.model.RutaDTO;
import com.bruno.adsaude.service.impl.RutaServiceImpl;

public class RutaServiceTest {
	
	private RutaService rutaService=null;
	
	public RutaServiceTest() {
		rutaService = new RutaServiceImpl();
	}

	public void testFindByEmpleado() {
		try {
			List<RutaDTO> ruta = rutaService.findByEmpleado(1);
			for (RutaDTO r : ruta){
				System.out.println(r.getDescripcion()+" "+r.getDiaSemana()+" "+r.getId()+" "+r.getNombreEmpleado()+" "+r.getNombreAsistido());
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error testfindByempleado");
		}
	}
	public void testFindByAsistido() {
		try {
			List<RutaDTO> ruta = rutaService.findByAsistido(1);
			for (RutaDTO r : ruta){
				System.out.println(r.getDescripcion()+" "+r.getDiaSemana()+" "+r.getId()+" "+r.getNombreEmpleado()+" "+r.getNombreAsistido());
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error testfindByempleado");
		}
	}
	
	
	public static void main(String[] args) {
		RutaServiceTest test = new RutaServiceTest();
		//test.testFindByEmpleado();
		test.testFindByAsistido();
	}

}
