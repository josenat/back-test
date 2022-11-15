package renfe.com.repository;

import java.util.List;

import renfe.com.model.entity.Tbasg262TipoAcredita;

public interface Tbasg262TipoAcreditaRepositoryCustom {

	public List<Tbasg262TipoAcredita> getTipoAcreditacion(String cdgoTipoacr);
	
	public List<Tbasg262TipoAcredita> getValidezReciclaje(String cdgoTipoacr);

	public List<Tbasg262TipoAcredita> getListaTiposAcreditacion();

	public List<Tbasg262TipoAcredita> getListaTiposAcreditacionActiv();

	public List<Tbasg262TipoAcredita> getDescTipoAcreditacion(String cdgoTipoacr);

}
