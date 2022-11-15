package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.util.List;

import renfe.com.model.dto.Tbasg280MarcaGmmDto;
import renfe.com.model.entity.Tbasg280MarcaGmm;

public interface Tbasg280MarcaGmmService {

	public List<Tbasg280MarcaGmmDto> getAllTbasg280MarcaGmm(Tbasg280MarcaGmmDto filter);

	public Tbasg280MarcaGmmDto findByDesgMatriculaFchaAct(String desgMatricula, Date fchaAct);

	public Tbasg280MarcaGmmDto createTbasg280MarcaGmm(Tbasg280MarcaGmmDto tbasg280MarcaGmmDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg280MarcaGmmDto updateTbasg280MarcaGmm(String desgMatricula, Date fchaAct,
			Tbasg280MarcaGmmDto tbasg280MarcaGmmDto) throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg280MarcaGmm(String desgMatricula, Date fchaAct);

	public List<Tbasg280MarcaGmmDto> findByDesgMatriculaFchaActIn(List<String> desgMatricula, List<Date> fchaAct);

	public List<Tbasg280MarcaGmmDto> getASG280(String desgMatricula);

	public int insertFicheroASG280(Tbasg280MarcaGmm bean);

}
