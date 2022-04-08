package com.bruno.adsaude.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.bruno.adsaude.model.Contrato;
import com.bruno.adsaude.model.ContratoDTO;
import com.bruno.adsaude.model.ContratoTipoServicio;
import com.bruno.adsaude.service.impl.ContratoServiceImpl;

public class ContratoServiceTest {

private ContratoService contratoService = null;
	
	public ContratoServiceTest() {
		contratoService= new ContratoServiceImpl();	
	}
	
	public void testFindByAsistido(){
		ContratoDTO contrato = null;
		try {
			contrato=contratoService.findByAsistido(1);
			System.out.println(contrato.getNombreAsistido()+" "+contrato.getNombreTipoServicio());
		}
		catch (Exception e){
			System.out.println("Por favor intentelo de nuevo más tarde.");
			e.printStackTrace();
		}
		
		
	}
	
	public void testCreate(){
		Contrato contrato = new Contrato();
		ContratoTipoServicio cts= new ContratoTipoServicio();
		ContratoTipoServicio cts2= new ContratoTipoServicio();
		ContratoTipoServicio cts3= new ContratoTipoServicio();
		List<ContratoTipoServicio> ctsLista = new ArrayList();
		Date fechaInicio=null;
		Date fechaFin=null;
		Integer contratoId=null;
		
		fechaInicio = new Date();
		Calendar c2 = Calendar.getInstance();
		c2.set(2021,Calendar.NOVEMBER, 1);
		fechaInicio=c2.getTime();
		
		 fechaFin = new Date();
		Calendar c3 = Calendar.getInstance();
		c3.set(2022,Calendar.NOVEMBER, 1);
		fechaFin=c3.getTime();
		
		contrato.setFechaInicio(fechaInicio);
		contrato.setFechaFin(fechaFin);
		contrato.setIdAsistido(10);

		cts.setIdTipoServicio(7);
		cts.setDescripcion("Limpieza del aseo principal");
		
		ctsLista.add(cts);
		
		cts2.setIdTipoServicio(9);
		cts2.setDescripcion("Preparacion de una dieta normal sin alergias ni nada");
		
		ctsLista.add(cts2);
		
		cts3.setIdTipoServicio(12);
		cts3.setDescripcion("Cambio de pañales por necesidad");
		
		ctsLista.add(cts3);
		
		try {
			
			contratoId=contratoService.create(contrato, ctsLista);
			System.out.println("El id del ocntrato creado es: "+contratoId);
			
		}
		catch (Exception e){
			System.out.println("Por favor intentelo de nuevo más tarde.");
			e.printStackTrace();
		}
		
		
	}
	
	public static void main(String[] args) {
		ContratoServiceTest test = new ContratoServiceTest();
		test.testFindByAsistido();
		test.testCreate();
	}

}
