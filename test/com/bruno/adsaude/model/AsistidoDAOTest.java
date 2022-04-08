package com.bruno.adsaude.model;

import java.sql.Connection;
import java.util.List;

import com.bruno.adsaude.dao.AsistidoDAO;
import com.bruno.adsaude.dao.impl.AsistidoDAOImpl;
import com.bruno.adsaude.dao.util.ConnectionManager;
import com.bruno.adsaude.dao.util.JDBCUtils;
import com.bruno.adsaude.exception.DataException;


public class AsistidoDAOTest {
	/*
	private AsistidoDAO asistidoDAO = null;
	
	public AsistidoDAOTest () {
		this.asistidoDAO = new AsistidoDAOImpl();
	}
	
	public  void testFindById(int id) throws DataException  {
		System.out.println("testing....id");
		Connection c = null;
		boolean commitOrRollback =false;
		try {
			c = ConnectionManager.getConnection();
			Asistido a = asistidoDAO.findById(c, id);
			System.out.println(a);
			commitOrRollback = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeConnection(c, commitOrRollback);
		}
	}

	public  void testFindByEmail(String email) {
		System.out.println("testing....email");

		AsistidoDTO a = asistidoDAO.findByEmail(email);
		System.out.println(a);
	}
	
	public  void testfindByFamiliar( int id ) {
		System.out.println("testing....familiar");

		List<AsistidoDTO> a = asistidoDAO.FindByFamiliar(id);
		
		for (AsistidoDTO a1 : a) {
			System.out.println(a1);
		}
		
	}
	
	public  void testfindByRuta(int idruta) {
		System.out.println("testing....ruta");

		List<AsistidoDTO> a = asistidoDAO.FindByRuta(idruta);
		
		for (AsistidoDTO a1 : a) {
			System.out.println(a1);
		}
		
	}
	
	public  void testupdate() {
		System.out.println("testing...update");
		Asistido a = asistidoDAO.findById(1);
		a.setApellido1("Fernandez");
		a.setApellido2("Fernandez");
		a.setTlf("632458691");
		asistidoDAO.update(a);
	}

	public  void testcerate() {
		System.out.println("testing...create");
		Asistido a = new Asistido();
		a.setNombre("Luis");
		a.setApellido1("Antonio");
		a.setApellido2("Perico");
		a.setNif("23455679o");
		a.setTlf("+34 657903456");
		a.setEmail("luisitocomunica@gmail.com");
		a.setPassword("joselitorey");
		a.setDomicilio("calle benito perez galdos nº7 piso 5");
		a.setIdMedico(1);
		a.setIdLocalidad(1);
		asistidoDAO.create(a);
		
	}
	
	
	public static void main(String args[]) {
		
		AsistidoDAOTest test = new AsistidoDAOTest();
		
		test.testFindById(1);
		test.testFindByEmail("pepitillo@gmail.com");
		test.testfindByFamiliar(1);
		test.testfindByRuta(1);
		test.testupdate();
		test.testcerate();
	};
*/
}
