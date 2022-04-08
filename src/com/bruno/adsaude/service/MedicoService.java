package com.bruno.adsaude.service;

import com.bruno.adsaude.exception.DataException;
import com.bruno.adsaude.exception.ServiceException;
import com.bruno.adsaude.model.MedicoDTO;

public interface MedicoService {

	public  MedicoDTO login(String email, String password) throws DataException, ServiceException;
}
