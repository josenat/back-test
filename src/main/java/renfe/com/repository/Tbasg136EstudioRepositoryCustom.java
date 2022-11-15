package renfe.com.repository;

import java.util.List;

import renfe.com.model.entity.Tbasg136Estudio;

public interface Tbasg136EstudioRepositoryCustom {

	public List<Tbasg136Estudio> getEstudioCount();

	public List<Tbasg136Estudio> getEstudioListAscendente();

	public List<Tbasg136Estudio> getEstudioListDescendente();

	public List<Tbasg136Estudio> getEstudioActiveListAscendente();

	public List<Tbasg136Estudio> getEstudioActiveListDescendente();

	public List<Tbasg136Estudio> getEstudio(String cdgoEstudio);

	public int insertEstudio(Tbasg136Estudio bean);

	public int updateEstudio(Tbasg136Estudio bean);
	
	public int estadoEstudio(Tbasg136Estudio bean);

}
