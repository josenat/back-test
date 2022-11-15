package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.model.dto.Tbasg262TipoAcreditaDto;

public interface Tbasg262TipoAcreditaService {

	public List<Tbasg262TipoAcreditaDto> getAllTbasg262TipoAcredita(Tbasg262TipoAcreditaDto filter);

	public Tbasg262TipoAcreditaDto findByCdgoTipoacr(String cdgoTipoacr);

	public Tbasg262TipoAcreditaDto createTbasg262TipoAcredita(Tbasg262TipoAcreditaDto tbasg262TipoAcreditaDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg262TipoAcreditaDto updateTbasg262TipoAcredita(String cdgoTipoacr,
			Tbasg262TipoAcreditaDto tbasg262TipoAcreditaDto) throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg262TipoAcredita(String cdgoTipoacr);

	public List<Tbasg262TipoAcreditaDto> findByCdgoTipoacrIn(List<String> cdgoTipoacr);

	public List<Tbasg262TipoAcreditaDto> getTipoAcreditacion(String cdgoTipoacr);

	public List<Tbasg262TipoAcreditaDto> getListaTiposAcreditacion();

	public List<Tbasg262TipoAcreditaDto> getListaTiposAcreditacionActiv();

	public List<Tbasg262TipoAcreditaDto> getDescTipoAcreditacion(String cdgoTipoacr);

	public List<Tbasg262TipoAcreditaDto> getValidezReciclaje(String cdgoTipoacr);

}
