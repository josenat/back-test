package renfe.com.repository;

import java.util.List;

import renfe.com.model.entity.Tbasg140Tidepenci;

public interface Tbasg140TidepenciRepositoryCustom {

	public List<Tbasg140Tidepenci> getTiDepenciCount();

	public List<Tbasg140Tidepenci> getTiDepenciListAscendente();

	public List<Tbasg140Tidepenci> getTiDepenciListDescendente();

	public List<Tbasg140Tidepenci> getTiDepenciListActiveAscendente();

	public List<Tbasg140Tidepenci> getTiDepenciListActiveDescendente();

	public List<Tbasg140Tidepenci> getTiDepenci(String cdgoTipodep);

	public int insertTiDepenci(Tbasg140Tidepenci bean);

	public int updateTiDepenci(Tbasg140Tidepenci bean);

	public int deleteTiDepenci(Tbasg140Tidepenci bean);

}
