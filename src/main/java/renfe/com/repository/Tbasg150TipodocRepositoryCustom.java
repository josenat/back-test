package renfe.com.repository;

import java.util.List;

import renfe.com.model.entity.Tbasg150Tipodoc;

public interface Tbasg150TipodocRepositoryCustom {

	public List<Tbasg150Tipodoc> getDescTipoDocumento(String cdgoTipodoc);

	public List<Tbasg150Tipodoc> getTipoDocListByCodigo();

	public List<Tbasg150Tipodoc> getTipoDocCount();

}
