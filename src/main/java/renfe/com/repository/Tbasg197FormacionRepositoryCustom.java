package renfe.com.repository;

import java.util.List;

import renfe.com.model.entity.Tbasg197Formacion;

public interface Tbasg197FormacionRepositoryCustom {

	public List<Tbasg197Formacion> getAlcaForma(String cdgoSolicitud);

	public List<Tbasg197Formacion> getFormacionByDniNif(String desgNifpas);

	public List<Tbasg197Formacion> getFormacionExpediente(Integer cdgoExpedient);

	public List<Tbasg197Formacion> getMaxFormacionExpediente(String cdgoExpedient);

	public List<Tbasg197Formacion> getReciclajeExpediente(Integer cdgoExpedient);

	public List<Tbasg197Formacion> getReciclajeTituloCond(String cdgoTit);

	public List<Tbasg197Formacion> getFormacionValores();

	public int insertFormacion(Tbasg197Formacion bean);

	public int deleteFormacion(Integer cdgoSolicitud);

}
