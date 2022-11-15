package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import renfe.com.dto.GetAreActiviListAscendenteDTO;
import renfe.com.dto.GetAreActiviListComboDTO;
import renfe.com.dto.GetSociedadesByCodAreaActivListDTO;
import renfe.com.model.dto.Tbasg105AreactiviDto;
import renfe.com.model.entity.Tbasg105Areactivi;
import renfe.com.repository.Tbasg105AreactiviRepository;

@Transactional
@Service
public class Tbasg105AreactiviServiceImpl implements Tbasg105AreactiviService {

    @Autowired
    protected Logger logger;

    @Autowired
    private Tbasg105AreactiviRepository tbasg105AreactiviRepository;

    public List<Tbasg105AreactiviDto> getAllTbasg105Areactivi(Tbasg105AreactiviDto filter) {

        logger.info("getAllTbasg105Areactivi " + filter);
        if (filter == null) {
            return this.toDtos(tbasg105AreactiviRepository.findAll());
        }
        return this.toDtos(tbasg105AreactiviRepository.findAll(Example.of(toEntity(filter))));
    }

    public Tbasg105AreactiviDto findByCdgoAreact(Integer cdgoAreact) {

        Optional<Tbasg105Areactivi> tbasg105AreactiviData = tbasg105AreactiviRepository.findByCdgoAreact(cdgoAreact);

        if (tbasg105AreactiviData.isPresent()) {
            return toDto(tbasg105AreactiviData.get());
        }
        return null;
    }

    public Tbasg105AreactiviDto createTbasg105Areactivi(Tbasg105AreactiviDto tbasg105AreactiviDto)
            throws IllegalAccessException, InvocationTargetException {

        Tbasg105Areactivi dbTbasg105Areactivi = new Tbasg105Areactivi();
        BeanUtils.copyProperties(dbTbasg105Areactivi, tbasg105AreactiviDto);
        Tbasg105Areactivi _tbasg105Areactivi = tbasg105AreactiviRepository.save(dbTbasg105Areactivi);
        return toDto(_tbasg105Areactivi);
    }

    public Tbasg105AreactiviDto updateTbasg105Areactivi(Integer cdgoAreact, Tbasg105AreactiviDto tbasg105AreactiviDto)
            throws IllegalAccessException, InvocationTargetException {

        Optional<Tbasg105Areactivi> tbasg105AreactiviData = tbasg105AreactiviRepository.findById(cdgoAreact);

        if (tbasg105AreactiviData.isPresent()) {
            Tbasg105Areactivi dbTbasg105Areactivi = tbasg105AreactiviData.get();
            BeanUtils.copyProperties(dbTbasg105Areactivi, tbasg105AreactiviDto);
            return toDto(tbasg105AreactiviRepository.save(dbTbasg105Areactivi));
        }
        return null;
    }

    public int deleteTbasg105Areactivi(Integer cdgoAreact) {

        tbasg105AreactiviRepository.deleteById(cdgoAreact);
        return 1;
    }

    public List<Tbasg105AreactiviDto> findByCdgoAreactIn(List<Integer> cdgoAreact) {

        List<Tbasg105Areactivi> tbasg105Areactivis = tbasg105AreactiviRepository.findByCdgoAreactIn(cdgoAreact);

        return toDtos(tbasg105Areactivis);
    }

    public List<Tbasg105AreactiviDto> getAreActiviCount() {
        return toDtos(tbasg105AreactiviRepository.getAreActiviCount());
    }

    public List<GetAreActiviListComboDTO> getAreActiviListCombo() {
        return tbasg105AreactiviRepository.getAreActiviListCombo();
    }

    public List<GetAreActiviListAscendenteDTO> getAreActiviListAscendente() {
        return tbasg105AreactiviRepository.getAreActiviListAscendente();
    }

    public List<Tbasg105AreactiviDto> getAreActiviListDescendente() {
        return toDtos(tbasg105AreactiviRepository.getAreActiviListDescendente());
    }

    public List<Tbasg105AreactiviDto> getAreActiviActiveListAscendente() {
        return toDtos(tbasg105AreactiviRepository.getAreActiviActiveListAscendente());
    }

    public List<Tbasg105AreactiviDto> getAreActiviActiveListDescendente() {
        return toDtos(tbasg105AreactiviRepository.getAreActiviActiveListDescendente());
    }

    public List<Tbasg105AreactiviDto> getAreActiviListAscendenteDESG_NOMBRE() {
        return toDtos(tbasg105AreactiviRepository.getAreActiviListAscendenteDESG_NOMBRE());
    }

    public List<Tbasg105AreactiviDto> getAreActiviListAscendenteSelectedByLevel() {
        return toDtos(tbasg105AreactiviRepository.getAreActiviListAscendenteSelectedByLevel());
    }

    public List<Tbasg105AreactiviDto> getAreActiviActiveListAscendenteDESG_NOMBRE() {
        return toDtos(tbasg105AreactiviRepository.getAreActiviActiveListAscendenteDESG_NOMBRE());
    }

    public List<Tbasg105AreactiviDto> getAreActiviActiveListDescendenteDESG_NOMBRE() {
        return toDtos(tbasg105AreactiviRepository.getAreActiviActiveListDescendenteDESG_NOMBRE());
    }

	public List<Tbasg105AreactiviDto> getAreActivi(String cdgoAreact) {
		return toDtos(tbasg105AreactiviRepository.getAreActivi(cdgoAreact));
	}
		
	public List<Tbasg105AreactiviDto> getAllAreAct() {		
		return toDtos(tbasg105AreactiviRepository.getAllAreAct());

	}

    public List<Tbasg105AreactiviDto> getAreActiviActiveListCodes() {
        return toDtos(tbasg105AreactiviRepository.getAreActiviActiveListCodes());
    }


    public List<Tbasg105AreactiviDto> getAreActiviListByAreTerList(List<Integer>estadosList) {
        return toDtos(tbasg105AreactiviRepository.getAreActiviListByAreTerList(estadosList));
    }


    public List<Tbasg105AreactiviDto> getAreActiviListByAreTerListAll() {
        return toDtos(tbasg105AreactiviRepository.getAreActiviListByAreTerListAll());
    }

    public List<Tbasg105AreactiviDto> getCodAreActiviListByAreTerList() {
        return toDtos(tbasg105AreactiviRepository.getCodAreActiviListByAreTerList());
    }

    public int insertAreActivi(Tbasg105Areactivi bean) {
        return tbasg105AreactiviRepository.insertAreActivi(bean);
    }

    public int updateAreActivi(Tbasg105Areactivi bean) {
        return tbasg105AreactiviRepository.updateAreActivi(bean);
    }
    
    public int estadoAreActivi(Tbasg105Areactivi bean) {
        return tbasg105AreactiviRepository.estadoAreActivi(bean);
    }

    public List<Tbasg105AreactiviDto> getAreTerListAscendenteCDGO_ARETER() {
        return toDtos(tbasg105AreactiviRepository.getAreTerListAscendenteCDGO_ARETER());
    }

    public List<Tbasg105AreactiviDto> getAreTerActiveListAscendenteCDGO_ARETER() {
        return toDtos(tbasg105AreactiviRepository.getAreTerActiveListAscendenteCDGO_ARETER());
    }

    public List<Tbasg105AreactiviDto> getSociedadesByCodAreaActiv() {
        return toDtos(tbasg105AreactiviRepository.getSociedadesByCodAreaActiv());
    }

    public List<Tbasg105AreactiviDto> getSociedadesByCodAreaActivAll() {
        return toDtos(tbasg105AreactiviRepository.getSociedadesByCodAreaActivAll());
    }
 

    public List<GetSociedadesByCodAreaActivListDTO> getSociedadesByCodAreaActivList() {
        return tbasg105AreactiviRepository.getSociedadesByCodAreaActivList();
    }    

    public Tbasg105AreactiviDto toDto(Tbasg105Areactivi orig) {

        Tbasg105AreactiviDto dest = new Tbasg105AreactiviDto();
        try {
            BeanUtils.copyProperties(dest, orig);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return dest;
    }

    public Tbasg105Areactivi toEntity(Tbasg105AreactiviDto orig) {

        Tbasg105Areactivi dest = new Tbasg105Areactivi();
        try {
            BeanUtils.copyProperties(dest, orig);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return dest;
    }

    public List<Tbasg105AreactiviDto> toDtos(List<Tbasg105Areactivi> orig) {

        List<Tbasg105AreactiviDto> dest = new ArrayList<>();
        if (orig == null) {
            return dest;
        }
        orig.forEach(origItem -> {
            dest.add(this.toDto(origItem));
        });
        return dest;
    }

    public List<Tbasg105Areactivi> toEntities(List<Tbasg105AreactiviDto> orig)
            throws IllegalAccessException, InvocationTargetException {

        List<Tbasg105Areactivi> dest = new ArrayList<>();
        if (orig == null) {
            return dest;
        }
        orig.forEach(origItem -> {
            dest.add(this.toEntity(origItem));
        });
        return dest;
    }
	@Override
	public List<Tbasg105AreactiviDto> getSociedadesByCodAreaActiv(List<Integer> listAreaActi) {
		return toDtos(tbasg105AreactiviRepository.getSociedadesByCodAreaActiv(listAreaActi));
	}

	

}
