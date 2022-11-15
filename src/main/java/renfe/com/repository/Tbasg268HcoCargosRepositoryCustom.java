package renfe.com.repository;

import java.sql.Date;
import java.util.List;

import renfe.com.model.entity.Tbasg268HcoCargos;

public interface Tbasg268HcoCargosRepositoryCustom {

	public List<Tbasg268HcoCargos> findByCdgoPersona(String cdgoPersona);

	public List<Tbasg268HcoCargos> findByCdgoPersonaCargo(String cdgoPersona);

	public List<Tbasg268HcoCargos> findCdgoCargoBeginningK(String cdgoPersona);

	public int insertHstoCargos(String cdgoPersona, Date fchaInicio, Date fchaFin, String desgUsuact, String cdgoCargo);

	public int updateHstoCargos(String cdgoCargo, Date fchaFin, String desgUsuact, String cdgoPersona, Date fchaInicio);

	public int deleteHstoCargos(Tbasg268HcoCargos bean);

}
