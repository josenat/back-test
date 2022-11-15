package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.util.List;

import renfe.com.dto.GetDiferentValuesTipoDTO;
import renfe.com.dto.InsertActaincalParamDTO;
import renfe.com.model.dto.Tbasg146ActaincalDto;
import renfe.com.model.entity.Tbasg146Actaincal;

public interface Tbasg146ActaincalService {

	public List<Tbasg146ActaincalDto> getAllTbasg146Actaincal(Tbasg146ActaincalDto filter);

	public Tbasg146ActaincalDto findByCdgoActaformDesgTipocurso(Integer cdgoActaform, String desgTipocurso);

	public Tbasg146ActaincalDto createTbasg146Actaincal(Tbasg146ActaincalDto tbasg146ActaincalDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg146ActaincalDto updateTbasg146Actaincal(Integer cdgoActaform, String desgTipocurso,
			Tbasg146ActaincalDto tbasg146ActaincalDto) throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg146Actaincal(Integer cdgoActaform, String desgTipocurso);

	public List<Tbasg146ActaincalDto> findByCdgoActaformDesgTipocursoIn(List<Integer> cdgoActaform,
			List<String> desgTipocurso);

	public List<Tbasg146ActaincalDto> getActaInCal(String cdgoActaform, String desgTipocurso);

	public List<GetDiferentValuesTipoDTO> getDiferentValues();
	
	public List<Tbasg146ActaincalDto> getActaInCalList();

	public List<Tbasg146ActaincalDto> getActaInCalActaForma(String cdgoActaform);

	public List<Tbasg146ActaincalDto> getActaInCalActaFormaMantenimiento(String cdgoActaform);

	public List<Tbasg146ActaincalDto> getActasInCalActasFormaMantenimiento();

	public List<Tbasg146ActaincalDto> getActaInCalCount();

	public List<Tbasg146ActaincalDto> getActaInCalByActa(Integer cdgoActaform);

	public int insertActaInCal(Tbasg146Actaincal bean);

	public int updateActaInCal(String desgTipocurso, Integer cdgoCalifi, String cdgoIdinstru, String fchaCurso, String descUsuact, String mrcaActivo, String cdgoIdexa, Integer cdgoActaform, String desgTipocursoActual);

	public int updateActaInCalMantenimiento(Tbasg146Actaincal bean);

	public int inactiveByCdgoActaForm(String usuAct, Integer cdgoActaform);

	public int deleteActaInCal(Tbasg146Actaincal bean);


}
