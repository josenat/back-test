package renfe.com.repository;

import java.sql.Date;
import java.util.List;

import renfe.com.model.entity.Tbasg258SocPersona;

public interface Tbasg258SocPersonaRepositoryCustom {

	public List<Tbasg258SocPersona> findByCdgoPersona(Integer cdgoPersona);

	public List<Tbasg258SocPersona> findByCdgoPersonaActivo(String cdgoPersona);

	public List<Tbasg258SocPersona> findByCdgoPersonaInActivo(String cdgoPersona);

	public int insertSocPersona(Integer cdgoPersona, String cdgoSociedad, Date fechAlta, Date fechBaja);

	public int updateSocPersona(Integer idSocPersona, String cdgoSociedad, Date fechAlta, Date fechBaja);

}
