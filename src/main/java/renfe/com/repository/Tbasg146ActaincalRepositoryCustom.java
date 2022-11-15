package renfe.com.repository;

import java.sql.Date;
import java.util.List;

import renfe.com.dto.GetDiferentValuesTipoDTO;
import renfe.com.dto.InsertActaincalParamDTO;
import renfe.com.model.dto.Tbasg146ActaincalDto;
import renfe.com.model.entity.Tbasg146Actaincal;

public interface Tbasg146ActaincalRepositoryCustom {

	public List<Tbasg146Actaincal> getActaInCal(String cdgoActaform, String desgTipocurso);

	public List<GetDiferentValuesTipoDTO> getDiferentValues();
	
	public List<Tbasg146Actaincal> getActaInCalList();

	public List<Tbasg146Actaincal> getActaInCalActaForma(String cdgoActaform);

	public List<Tbasg146Actaincal> getActaInCalActaFormaMantenimiento(String cdgoActaform);

	public List<Tbasg146Actaincal> getActasInCalActasFormaMantenimiento();

	public List<Tbasg146Actaincal> getActaInCalCount();

	public List<Tbasg146ActaincalDto> getActaInCalByActa(Integer cdgoActaform);

	public int insertActaInCal(Tbasg146Actaincal bean);

	public int updateActaInCal(String desgTipocurso, Integer cdgoCalifi, String cdgoIdinstru, String fchaCurso, String descUsuact, String mrcaActivo, String cdgoIdexa, Integer cdgoActaform, String desgTipocursoActual);

	public int updateActaInCalMantenimiento(Tbasg146Actaincal bean);

	public int inactiveByCdgoActaForm(String usuAct, Integer cdgoActaform);

	public int deleteActaInCal(Tbasg146Actaincal bean);

}
