package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.model.dto.Tbasg126AlchabinfDto;
import renfe.com.model.entity.Tbasg126Alchabinf;

public interface Tbasg126AlchabinfService {

	public List<Tbasg126AlchabinfDto> getAllTbasg126Alchabinf(Tbasg126AlchabinfDto filter);

	public Tbasg126AlchabinfDto findByCdgoAlchabinf(Integer cdgoAlchabinf);

	public Tbasg126AlchabinfDto createTbasg126Alchabinf(Tbasg126AlchabinfDto tbasg126AlchabinfDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg126AlchabinfDto updateTbasg126Alchabinf(Integer cdgoAlchabinf,
			Tbasg126AlchabinfDto tbasg126AlchabinfDto) throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg126Alchabinf(Integer cdgoAlchabinf);

	public List<Tbasg126AlchabinfDto> findByCdgoAlchabinfIn(List<Integer> cdgoAlchabinf);

	public List<Tbasg126AlchabinfDto> findAlcHabInfByCdgoExp(Integer cdgoExpedient);

	public List<Tbasg126AlchabinfDto> getAlcHabInf(String cdgoAlchabinf);

	public int insertAlcHabInf(Tbasg126Alchabinf bean);

	public int deleteAlcHabInfByCdgoExp(Tbasg126Alchabinf bean);

	public int deleteAlcHabInf(Tbasg126Alchabinf bean);

	public List<Tbasg126AlchabinfDto> getPreviousEstaHabInList(String cdgoAlchabinf);

	public List<Tbasg126AlchabinfDto> getMaxEntornosExpList(String cdgoExpedient);

	public List<Tbasg126AlchabinfDto> getMaxEntornosExpListDesc(String cdgoExpedient);

	public List<Tbasg126AlchabinfDto> findTramoByCodExpediente(String cdgoExpedient);

}
