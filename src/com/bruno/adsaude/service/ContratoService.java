package com.bruno.adsaude.service;

import java.util.List;

import com.bruno.adsaude.exception.DataException;
import com.bruno.adsaude.exception.ServiceException;
import com.bruno.adsaude.model.Contrato;
import com.bruno.adsaude.model.ContratoDTO;
import com.bruno.adsaude.model.ContratoTipoServicio;

public interface ContratoService {

	public ContratoDTO findByAsistido (int idAsistido)throws DataException, ServiceException;

	public Integer create(Contrato contrato, List<ContratoTipoServicio> contratoTS) throws DataException, ServiceException;
}
