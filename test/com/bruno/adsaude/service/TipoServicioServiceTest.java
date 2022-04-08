package com.bruno.adsaude.service;

import java.util.List;

import com.bruno.adsaude.model.TipoServicio;
import com.bruno.adsaude.model.TipoServicioDTO;
import com.bruno.adsaude.service.impl.TipoServicioServiceImpl;

public class TipoServicioServiceTest {
	
	private TipoServicioService tipoServicioService=null;
	 
	public TipoServicioServiceTest () {
		tipoServicioService = new TipoServicioServiceImpl();
	}
	
	public void testFindBy() {
		try {
			List<TipoServicio> tipoServicio = tipoServicioService.findBy();
			for(TipoServicio ts: tipoServicio) {
				System.out.println(ts.getId()+" "+ts.getNombre()+" "+ts.getTiempoEstimado()+" "+ts.getDescripcion()+" "+ts.getIdTipoServicio());
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error testfindby");
		}
	}
	public void testFindByPadre() {
		try {
			List<TipoServicio> tipoServicio = tipoServicioService.findByPadre();
			for(TipoServicio ts: tipoServicio) {
				System.out.println(ts.getId()+" "+ts.getNombre()+" "+ts.getTiempoEstimado()+" "+ts.getDescripcion()+" "+ts.getIdTipoServicio());
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error testfindby");
		}
	}
	public void testFindByHijas() {
		try {
			List<TipoServicioDTO> tipoServicio = tipoServicioService.findByHijas();
			for(TipoServicioDTO ts: tipoServicio) {
				System.out.println(ts.getId()+" "+ts.getNombre()+" "+ts.getTiempoEstimado()+" "+ts.getDescripcion()+" "+ts.getIdTipoServicio()+" "+ts.getNombrePadre());
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error testfindby");
		}
	}
	public void testFindByPadreId() {
		try {
			List<TipoServicio> tipoServicio = tipoServicioService.findByPadreId(1);
			for(TipoServicio ts: tipoServicio) {
				System.out.println(ts.getId()+" "+ts.getNombre()+" "+ts.getTiempoEstimado()+" "+ts.getDescripcion()+" "+ts.getIdTipoServicio());
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error testfindby");
		}
	}
	public static void main(String[] args) {
		TipoServicioServiceTest test = new TipoServicioServiceTest();
		//test.testFindBy();
		//test.testFindByPadre();
		//test.testFindByHijas();
		test.testFindByPadreId();
	}

}
