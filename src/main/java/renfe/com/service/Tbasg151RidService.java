package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.model.dto.Tbasg151RidDto;
import renfe.com.model.entity.Tbasg151Rid;

public interface Tbasg151RidService {

	public List<Tbasg151RidDto> getAllTbasg151Rid(Tbasg151RidDto filter);

	public Tbasg151RidDto findByCdgoExpedient(Integer cdgoExpedient);

	public Tbasg151RidDto createTbasg151Rid(Tbasg151RidDto tbasg151RidDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg151RidDto updateTbasg151Rid(Integer cdgoExpedient, Tbasg151RidDto tbasg151RidDto)
			throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg151Rid(Integer cdgoExpedient);

	public List<Tbasg151RidDto> findByCdgoExpedientIn(List<Integer> cdgoExpedient);

	public List<Tbasg151RidDto> getRidList();

	public List<Tbasg151RidDto> getRidCount();

	public List<Tbasg151RidDto> getRid(String cdgoExpedient);

	public int insertRid(String cdgoExpedient, String fchaRid, String desgUsuact);

	public int updateRid(Tbasg151Rid bean);

}
