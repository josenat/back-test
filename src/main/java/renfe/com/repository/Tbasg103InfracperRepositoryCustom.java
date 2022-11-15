package renfe.com.repository;

import java.util.List;

import renfe.com.dto.GetInfractionListDTO;
import renfe.com.dto.GetInfractionParametersDTO;
import renfe.com.model.entity.Tbasg103Infracper;

public interface Tbasg103InfracperRepositoryCustom {

	public List<Tbasg103Infracper> getInfracPersonaListAscendente(String cdgoPersona);

	public List<Tbasg103Infracper> getInfracPersonaListDescendente(String cdgoPersona);

	public List<Tbasg103Infracper> getInfracPersonaActiveListAscendente(String cdgoPersona);

	public List<Tbasg103Infracper> getInfracPersonaActiveListDescendente(String cdgoPersona);

	public List<Tbasg103Infracper> getInfracPersonaCount(String cdgoPersona);

	public List<GetInfractionListDTO> getInfracPerList(GetInfractionParametersDTO params);

	public List<Tbasg103Infracper> getInfracPerCount();

	public List<Tbasg103Infracper> getInfracPerView(String cdgoInfrper);

	public List<Tbasg103Infracper> getInfracPersona(String cdgoInfrper);

	public int insertInfracPersona(GetInfractionParametersDTO bean);

	public int updateInfracPersona(GetInfractionParametersDTO bean);

	public int deleteInfracPersona(GetInfractionParametersDTO bean);

	public int updateInfrPerRefDoc(Tbasg103Infracper bean);

}
