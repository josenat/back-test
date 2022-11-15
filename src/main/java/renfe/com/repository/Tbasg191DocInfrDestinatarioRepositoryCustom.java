package renfe.com.repository;

import java.util.List;

import renfe.com.model.entity.Tbasg191DocInfrDestinatario;

public interface Tbasg191DocInfrDestinatarioRepositoryCustom {

	public List<Tbasg191DocInfrDestinatario> getDocInfrDestinatarioList();

	public List<Tbasg191DocInfrDestinatario> getDocInfrDestinatarioByCdgoDestinatario(String cdgoDestinatario);

}
