package com.bruno.adsaude.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.bruno.adsaude.model.Incidencia;
import com.bruno.adsaude.model.IncidenciaDTO;
import com.bruno.adsaude.service.impl.IncidenciaServiceImpl;

public class IncidenciaServiceTest {
	private IncidenciaService incidenciaService=null;

	public IncidenciaServiceTest() {
		incidenciaService= new IncidenciaServiceImpl();
	}

	public void testFindByDate(){
		try {

			Date fechaInicio = new Date();
			Calendar c2 = Calendar.getInstance();
			c2.set(2020,Calendar.JANUARY, 1);
			fechaInicio=c2.getTime();

			Date fechaFin = new Date();
			Calendar c3 = Calendar.getInstance();
			c3.set(2022,Calendar.NOVEMBER, 1);
			fechaFin=c3.getTime();
			List<IncidenciaDTO> incidencia = incidenciaService.findByDate(fechaInicio, fechaFin);

			for(IncidenciaDTO in: incidencia) {
				System.out.println(in.getIdAsistidoAfectado()+" "+in.getNombreAsistido()+" "+in.getDescripcion());
			}
		}catch (Exception e){
			System.out.println("Por favor intentelo de nuevo más tarde.");
			e.printStackTrace();
		}
	}
	
	public void testFindByAsistidoAfectado(){
		try {
			List<IncidenciaDTO> incidencia = incidenciaService.findByAsistidoAfectado(4);

			for(IncidenciaDTO in: incidencia) {
				System.out.println(in.getIdAsistidoAfectado()+" "+in.getNombreAsistido()+" "+in.getDescripcion());
			}
		}catch (Exception e){
			System.out.println("Por favor intentelo de nuevo más tarde.");
			e.printStackTrace();
		}
	}

	public void testFindByCreador(){
		try {
			List<IncidenciaDTO> incidencia = incidenciaService.findByCreador(1, null, null);

			for(IncidenciaDTO in: incidencia) {
				System.out.println(in.getIdAsistidoAfectado()+" "+in.getNombreAsistido()+" "+in.getDescripcion());
			}
		}catch (Exception e){
			System.out.println("Por favor intentelo de nuevo más tarde.");
			e.printStackTrace();
		}
	}
	public void testCreate(){
		try {
			Date	 fecha = new Date();
			Calendar c3 = Calendar.getInstance();
			c3.set(2022,Calendar.NOVEMBER, 1);
			fecha=c3.getTime();
		Incidencia i = new Incidencia();
		i.setResumen("Malos tratos hacia mi persona");
		i.setDescripcion("Se han recibido malos tratos asi como abusos y moratones de la brusquedad");
		i.setFechaHora(fecha);
		i.setIdTipoEstadoIncidencia(1);
		i.setIdTipoIncidencia(5);
		i.setIdAsistido(6);
		i.setIdAsistidoAfectado(6);
		
		Incidencia iCreada= incidenciaService.create(i);
		
		System.out.println("Exito Create ");
		}catch (Exception e){
			System.out.println("Por favor intentelo de nuevo más tarde.");
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		IncidenciaServiceTest test = new IncidenciaServiceTest();
		//test.testFindByDate(); //no saca datos
		//test.testFindByAsistidoAfectado(); //no saca datos
		test.testFindByCreador(); // no saca datos
		//test.testCreate();

	}

}
