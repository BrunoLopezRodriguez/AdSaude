package com.bruno.adsaude.service;

import java.util.List;

import com.bruno.adsaude.exception.DataException;
import com.bruno.adsaude.exception.ServiceException;
import com.bruno.adsaude.model.Pais;

public interface PaisService {

	public  List<Pais> findBy()throws DataException, ServiceException;
}
