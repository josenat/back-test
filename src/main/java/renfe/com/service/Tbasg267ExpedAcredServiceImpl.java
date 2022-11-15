package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import renfe.com.dto.GetDatosAcreditacionesDTO;
import renfe.com.dto.GetDatosPersonaAcreditaDTO;
import renfe.com.dto.GetExpeAcreTipoValidezReciclajeDTO;
import renfe.com.dto.GetExpedientesPersonaDTO;
import renfe.com.dto.GetFindFchaExpedienteOtorgadoParaAotDTO;
import renfe.com.dto.GetFormacionComplementariaPersonaListResultDTO;
import renfe.com.dto.GetPersonaEmpresaInformeDTO;
import renfe.com.dto.GetfindFchaHabilitacionParaAotDTO;
import renfe.com.dto.GetfindListAcreditaByCdgoPerDTO;
import renfe.com.model.dto.Tbasg265AmbitoLineaDto;
import renfe.com.model.dto.Tbasg267ExpedAcredDto;
import renfe.com.model.dto.Tbasg267PlanningAccredDTO;
import renfe.com.model.dto.Tbasg267PlanningAccredParamDTO;
import renfe.com.model.entity.Tbasg100Persona;
import renfe.com.model.entity.Tbasg101Certpsic;
import renfe.com.model.entity.Tbasg104Expedient;
import renfe.com.model.entity.Tbasg125Empresa;
import renfe.com.model.entity.Tbasg201ErrSalud;
import renfe.com.model.entity.Tbasg267ExpedAcred;
import renfe.com.pdf.beans.AcreditacionBean;
import renfe.com.pdf.beans.CertificadoComplementarioAOTBean;
import renfe.com.pdf.datamanager.TextFormat;
import renfe.com.repository.Tbasg100PersonaRepository;
import renfe.com.repository.Tbasg267ExpedAcredRepository;
import renfe.com.util.MultivalueCts;

@Transactional
@Service
public class Tbasg267ExpedAcredServiceImpl implements Tbasg267ExpedAcredService {

	@Autowired
	protected Logger logger;
	
	@Autowired
	private Tbasg100PersonaRepository tbasg100PersonaRepository;

	@Autowired
	private Tbasg267ExpedAcredRepository tbasg267ExpedAcredRepository;

	public List<Tbasg267ExpedAcredDto> getAllTbasg267ExpedAcred(Tbasg267ExpedAcredDto filter) {

		logger.info("getAllTbasg267ExpedAcred " + filter);
		if (filter == null) {
			return this.toDtos(tbasg267ExpedAcredRepository.findAll());
		}
		return this.toDtos(tbasg267ExpedAcredRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg267ExpedAcredDto findByCdgoAcredita(Integer cdgoAcredita) {

		Optional<Tbasg267ExpedAcred> tbasg267ExpedAcredData = tbasg267ExpedAcredRepository
				.findByCdgoAcredita(cdgoAcredita);

		if (tbasg267ExpedAcredData.isPresent()) {
			return toDto(tbasg267ExpedAcredData.get());
		}
		return null;
	}

	public Tbasg267ExpedAcredDto createTbasg267ExpedAcred(Tbasg267ExpedAcredDto tbasg267ExpedAcredDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg267ExpedAcred dbTbasg267ExpedAcred = new Tbasg267ExpedAcred();
		BeanUtils.copyProperties(dbTbasg267ExpedAcred, tbasg267ExpedAcredDto);
		Tbasg267ExpedAcred _tbasg267ExpedAcred = tbasg267ExpedAcredRepository.save(dbTbasg267ExpedAcred);
		return toDto(_tbasg267ExpedAcred);
	}

	public Tbasg267ExpedAcredDto updateTbasg267ExpedAcred(Integer cdgoAcredita,
			Tbasg267ExpedAcredDto tbasg267ExpedAcredDto) throws IllegalAccessException, InvocationTargetException {

		Optional<Tbasg267ExpedAcred> tbasg267ExpedAcredData = tbasg267ExpedAcredRepository.findById(cdgoAcredita);

		if (tbasg267ExpedAcredData.isPresent()) {
			Tbasg267ExpedAcred dbTbasg267ExpedAcred = tbasg267ExpedAcredData.get();
			BeanUtils.copyProperties(dbTbasg267ExpedAcred, tbasg267ExpedAcredDto);
			return toDto(tbasg267ExpedAcredRepository.save(dbTbasg267ExpedAcred));
		}
		return null;
	}

	public int deleteTbasg267ExpedAcred(Integer cdgoAcredita) {

		tbasg267ExpedAcredRepository.deleteById(cdgoAcredita);
		return 1;
	}

	public List<Tbasg267ExpedAcredDto> findByCdgoAcreditaIn(List<Integer> cdgoAcredita) {

		List<Tbasg267ExpedAcred> tbasg267ExpedAcreds = tbasg267ExpedAcredRepository.findByCdgoAcreditaIn(cdgoAcredita);

		return toDtos(tbasg267ExpedAcreds);
	}
	
	public int updateAcreditacion(Tbasg267ExpedAcred bean) {
		return tbasg267ExpedAcredRepository.updateAcreditacion(bean);
	}
	
	public List<Tbasg267ExpedAcredDto> getUltimaAcreditacion() {
		return toDtos(tbasg267ExpedAcredRepository.getUltimaAcreditacion());
	}

	public List<GetDatosAcreditacionesDTO> getDatosAcreditaciones(String cdgoPersona) {
		return tbasg267ExpedAcredRepository.getDatosAcreditaciones(cdgoPersona);
	}
	
	public List<Tbasg267ExpedAcredDto> getExpeAcredValPersona(Integer cdgoPersona) {
		return toDtos(tbasg267ExpedAcredRepository.getExpeAcredValPersona(cdgoPersona));
	}
	
	public List<Tbasg267ExpedAcredDto> getExpeCdgoAcredita(Integer cdgoAcredita) {
		return toDtos(tbasg267ExpedAcredRepository.getExpeCdgoAcredita(cdgoAcredita));
	}
	
	public List<GetExpeAcreTipoValidezReciclajeDTO> getExpeAcreTipoValidezReciclaje(Integer cdgoAcredita) {
		return tbasg267ExpedAcredRepository.getExpeAcreTipoValidezReciclaje(cdgoAcredita);
	}

	public List<GetfindListAcreditaByCdgoPerDTO> findListAcreditaByCdgoPer(Integer cdgoPersona) {
		return tbasg267ExpedAcredRepository.findListAcreditaByCdgoPer(cdgoPersona);
	}

	public List<Tbasg267PlanningAccredDTO> findDataPlanificacionAcreditaciones(Tbasg267PlanningAccredParamDTO bean) {
		return tbasg267ExpedAcredRepository.findDataPlanificacionAcreditaciones(bean);
	}

	public List<Tbasg267ExpedAcredDto> getAcreditacionesPersonaList(String cdgoPersona) {
		return toDtos(tbasg267ExpedAcredRepository.getAcreditacionesPersonaList(cdgoPersona));
	}

	public List<Tbasg267ExpedAcredDto> getAcreditacionesPersonaListCount(String cdgoPersona) {
		return toDtos(tbasg267ExpedAcredRepository.getAcreditacionesPersonaListCount(cdgoPersona));
	}

	public List<Tbasg267ExpedAcredDto> getAcreditacion(String cdgoAcredita) {
		return toDtos(tbasg267ExpedAcredRepository.getAcreditacion(cdgoAcredita));
	}

	public List<Tbasg267ExpedAcredDto> getAcreditacionesDeLaPersona(String cdgoPersona) {
		return toDtos(tbasg267ExpedAcredRepository.getAcreditacionesDeLaPersona(cdgoPersona));
	}

	public int insertAcreditacion(Tbasg267ExpedAcred bean) {
		return tbasg267ExpedAcredRepository.insertAcreditacion(bean);
	}

	public int updateAcreditacionMantenimiento(GetDatosAcreditacionesDTO bean) {
		return tbasg267ExpedAcredRepository.updateAcreditacionMantenimiento(bean);
	}

	public List<Tbasg267ExpedAcredDto> getAcrePersonaObject(String cdgoAcredita) {
		return toDtos(tbasg267ExpedAcredRepository.getAcrePersonaObject(cdgoAcredita));
	}

	public Tbasg267ExpedAcredDto toDto(Tbasg267ExpedAcred orig) {

		Tbasg267ExpedAcredDto dest = new Tbasg267ExpedAcredDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg267ExpedAcred toEntity(Tbasg267ExpedAcredDto orig) {

		Tbasg267ExpedAcred dest = new Tbasg267ExpedAcred();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg267ExpedAcredDto> toDtos(List<Tbasg267ExpedAcred> orig) {

		List<Tbasg267ExpedAcredDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg267ExpedAcred> toEntities(List<Tbasg267ExpedAcredDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg267ExpedAcred> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
	
    @Override
    public Object getAcreditacionesActionDoExecute(Integer codPersona) throws Exception {

    	// Obtengo la lista de acreditaciones de la persona en cuestion    	
        
        List<GetfindListAcreditaByCdgoPerDTO> acreditacionesList = this.tbasg267ExpedAcredRepository.findListAcreditaByCdgoPer(codPersona);
        
        if (acreditacionesList.isEmpty())
        {
        	return null;
        }
     
        AcreditacionBean bean = new AcreditacionBean(); 
     
        // Obtengo los datos personales      
        
         List<GetDatosPersonaAcreditaDTO> datosPersonaAcreObject = this.tbasg100PersonaRepository.getDatosPersonaAcredita(codPersona);
        
         GetDatosPersonaAcreditaDTO datosPersonaAcre = new GetDatosPersonaAcreditaDTO();        
         
         if (CollectionUtils.isNotEmpty(datosPersonaAcreObject)) {
        	 datosPersonaAcre = datosPersonaAcreObject.get(0);
         }
         
        //  Relleno el bean
        
        bean.setNombre(datosPersonaAcre.getDesgNombre());
        bean.setApellido1(datosPersonaAcre.getDesgApell1());
        bean.setApellido2(datosPersonaAcre.getDesgApell2());
        bean.setNif(datosPersonaAcre.getDesgNifPas());
        bean.setNacionalidad(datosPersonaAcre.getNacional());
        bean.setEntidad(datosPersonaAcre.getDescSociedad());
       
        bean.setAcreditaciones(acreditacionesList);
        
        
        //  Recupero la empresa
        
        List<GetPersonaEmpresaInformeDTO> empresa = this.tbasg100PersonaRepository.getPersonaEmpresaInforme(codPersona);
        
        if (empresa != null)
       	{
           bean.setEmpresa(empresa.get(0).getDesgNombre());
        }
        else
        {
        	 bean.setEmpresa("RENFE");
        }
        
        return bean;

    }    
        
}
