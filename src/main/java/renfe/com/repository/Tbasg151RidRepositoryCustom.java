package renfe.com.repository;

import java.util.List;

import renfe.com.model.entity.Tbasg151Rid;

public interface Tbasg151RidRepositoryCustom {

	public List<Tbasg151Rid> getRidList();

	public List<Tbasg151Rid> getRidCount();

	public List<Tbasg151Rid> getRid(String cdgoExpedient);

	public int insertRid(String cdgoExpedient, String fchaRid, String desgUsuact);

	public int updateRid(Tbasg151Rid bean);

}
