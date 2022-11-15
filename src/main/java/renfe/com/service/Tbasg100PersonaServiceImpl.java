package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;


import renfe.com.dto.GetActasActivasPersonaDTO;
import renfe.com.dto.GetActasNoActivasPersonaDTO;
import renfe.com.dto.GetExpStatusFilterParametersDTO;
import renfe.com.dto.GetFechaProxRecicTitConDTO;
import renfe.com.dto.GetFechaProxRecicTitConNoMarcaDTO;
import renfe.com.dto.GetFindPersonaAltasBajasDTO;
import renfe.com.dto.GetMaxEstadoExpListDTO;

import renfe.com.dto.GetActasActivasPersonaDTO;
import renfe.com.dto.GetActasNoActivasPersonaDTO;
import renfe.com.dto.GetCertsPsicByPersListDTO;
import renfe.com.dto.GetDatosPersonaAcreditaDTO;
import renfe.com.dto.GetEstadoListDTO;
import renfe.com.dto.GetExpStatusFilterParametersDTO;
import renfe.com.dto.GetMaxEstadoExpListDTO;
import renfe.com.dto.GetMaxEstadoHabilitaListDTO;
import renfe.com.dto.GetMaxEstadoProxRevListDTO;

import renfe.com.dto.GetPerByEstadoListResultDTO;
import renfe.com.dto.GetPersonaCertificadosIdiomasListDTO;
import renfe.com.dto.GetPersonaEmpresaInformeDTO;
import renfe.com.dto.GetPersonaEstadoListDTO;
import renfe.com.dto.GetPersonaResultDTO;

import renfe.com.dto.GetTituloConListAuxDTO;
import renfe.com.dto.SetExpedientesPersonaListDTO;

import renfe.com.dto.MultivalueCts;
import renfe.com.dto.SetExpedientesPersonaListDTO;
import renfe.com.dto.SetMaxEstadoHabilitaList;
import renfe.com.dto.SetPersonaCertificadosIdiomasList;
import renfe.com.dto.SetPersonaEstadoList;
import renfe.com.dto.setMaxEstadoProxRevList;
import renfe.com.model.dto.ActasPersonaDto;
import renfe.com.model.dto.RequisitosMinimosDto;
import renfe.com.model.dto.Tbasg100PersonaDto;
import renfe.com.model.dto.Tbasg123TipohabilDto;
import renfe.com.model.dto.Tbasg128EstaclineDto;
import renfe.com.model.dto.Tbasg129EntornosDto;
import renfe.com.model.dto.Tbasg131AlcanceotDto;
import renfe.com.model.dto.Tbasg133SerieDto;
import renfe.com.model.dto.Tbasg137EspecialiDto;
import renfe.com.model.dto.Tbasg170VehiculoOvmDto;
import renfe.com.model.dto.Tbasg905OrganizationChartDto;
import renfe.com.model.entity.Tbasg100Persona;
import renfe.com.model.entity.Tbasg199DatConf;
import renfe.com.pdf.beans.InformeAltaBajaBean;
import renfe.com.repository.Tbasg100PersonaRepository;
import renfe.com.repository.Tbasg101CertpsicRepository;


@Service
@Transactional
public class Tbasg100PersonaServiceImpl implements Tbasg100PersonaService {

    @Autowired
    protected Logger logger;


    @Autowired
    private Tbasg100PersonaRepository tbasg100PersonaRepository;
	
	@Autowired
	private Tbasg101CertpsicRepository tbasg101CertpsicRepository;
	
	@Autowired
	private Tbasg101CertpsicService tbasg101CertpsicService;
	
	@Autowired
	private Tbasg104ExpedientService tbasg104ExpedientService;
	
	@Autowired
	private Tbasg123TipohabilService tbasg123TipohabilService;
	
	@Autowired
	private Tbasg199DatConfService tbasg199DatConfService;
	
	@Autowired
	private Tbasg131AlcanceotService tbasg131AlcanceotService;
	
	@Autowired
	private Tbasg137EspecialiService tbasg137EspecialiService;
	
	@Autowired
	private Tbasg170VehiculoOvmService tbasg170VehiculoOvmService;
	
	@Autowired
	private Tbasg129EntornosService tbasg129EntornosService;
	
	@Autowired
	private Tbasg128EstaclineService tbasg128EstaclineService;
	
	@Autowired
	private Tbasg133SerieService tbasg133SerieService;

    @Autowired
    private Tbasg122InstruService tbasg122InstruService;

    public List<Tbasg100PersonaDto> getAllTbasg100Persona(Tbasg100PersonaDto filter) {

        logger.info("getAllTbasg100Persona " + filter);
        if (filter == null) {
            return this.toDtos(tbasg100PersonaRepository.findAll());
        }
        return this.toDtos(tbasg100PersonaRepository.findAll(Example.of(toEntity(filter))));
    }

    public Tbasg100PersonaDto findByCdgoPersona(Integer cdgoPersona) {

        Optional<Tbasg100Persona> tbasg100PersonaData = tbasg100PersonaRepository.findByCdgoPersona(cdgoPersona);

        if (tbasg100PersonaData.isPresent()) {
            return toDto(tbasg100PersonaData.get());
        }
        return null;
    }

    public Tbasg100PersonaDto createTbasg100Persona(Tbasg100PersonaDto tbasg100PersonaDto) throws IllegalAccessException, InvocationTargetException {

        Tbasg100Persona dbTbasg100Persona = new Tbasg100Persona();
        BeanUtils.copyProperties(dbTbasg100Persona, tbasg100PersonaDto);
        Tbasg100Persona tbasg100Persona = tbasg100PersonaRepository.save(dbTbasg100Persona);
        return toDto(tbasg100Persona);
    }

    public Tbasg100PersonaDto updateTbasg100Persona(Integer cdgoPersona, Tbasg100PersonaDto tbasg100PersonaDto) throws IllegalAccessException, InvocationTargetException {

        Optional<Tbasg100Persona> tbasg100PersonaData = tbasg100PersonaRepository.findById(cdgoPersona);

        if (tbasg100PersonaData.isPresent()) {
            Tbasg100Persona dbTbasg100Persona = tbasg100PersonaData.get();
            BeanUtils.copyProperties(dbTbasg100Persona, tbasg100PersonaDto);
            return toDto(tbasg100PersonaRepository.save(dbTbasg100Persona));
        }
        return null;
    }

    public int deleteTbasg100Persona(Integer cdgoPersona) {

        tbasg100PersonaRepository.deleteById(cdgoPersona);
        return 1;
    }

    public List<Tbasg100PersonaDto> findByCdgoPersonaIn(List<Integer> cdgoPersona) {
        return toDtos(tbasg100PersonaRepository.findByCdgoPersonaIn(cdgoPersona));
    }

    public List<Tbasg100PersonaDto> getAcreditacionesCaducadas() {
        return toDtos(tbasg100PersonaRepository.getAcreditacionesCaducadas());
    }

    public List<ActasPersonaDto> getActasPersona(String cdgoPersona) {
        return tbasg100PersonaRepository.getActasPersona(cdgoPersona);
    }

    public List<Tbasg100PersonaDto> getActasPersonaOrderByCdgoActaForm(String cdgoPersona) {
        return toDtos(tbasg100PersonaRepository.getActasPersonaOrderByCdgoActaForm(cdgoPersona));
    }

    public List<GetTituloConListAuxDTO> getTituloConListAux(Integer cdgoPersona) {

        return tbasg100PersonaRepository.getTituloConListAux(cdgoPersona);
    }

    public List<GetActasActivasPersonaDTO> getActasActivasPersona(String cdgoPersona) {
    	return tbasg100PersonaRepository.getActasActivasPersona(cdgoPersona);
    }

    public List<GetActasNoActivasPersonaDTO> getActasNoActivasPersona(String cdgoPersona) {
    	return tbasg100PersonaRepository.getActasNoActivasPersona(cdgoPersona);
    }

    public List<Tbasg100PersonaDto> getExaminForName(String desgApell1) {
        return toDtos(tbasg100PersonaRepository.getExaminForName(desgApell1));
    }

    public List<GetMaxEstadoExpListDTO> getMaxEstadoExpList(GetExpStatusFilterParametersDTO filter) {
        return tbasg100PersonaRepository.getMaxEstadoExpList(filter);
    }

    public List<Tbasg100PersonaDto> getReportList() {
        return toDtos(tbasg100PersonaRepository.getReportList());
    }

    public List<GetPerByEstadoListResultDTO> getPerByEstadoList() {
        return tbasg100PersonaRepository.getPerByEstadoList();
    }

    public List<Tbasg100PersonaDto> getReportHistoricoList() {
        return toDtos(tbasg100PersonaRepository.getReportHistoricoList());
    }

    public List<Tbasg100PersonaDto> getMaqByTramosList() {
        return toDtos(tbasg100PersonaRepository.getMaqByTramosList());
    }
    

    @Override
	public Object getPdfAltasBajasFicheroRefDoExecute(List<Integer> codigos, String fecDesde, String fecHasta, String alta, String baja) throws Exception {
    	
    	List<GetFindPersonaAltasBajasDTO> listaPersonas = new ArrayList<GetFindPersonaAltasBajasDTO>();
    	
    	if("S".equals(alta)) {
        	List<GetFindPersonaAltasBajasDTO> personaAltas = this.tbasg100PersonaRepository.findPersonaAltas(codigos, fecDesde, fecHasta);
        	listaPersonas.addAll(personaAltas);
    	}
    	if("S".equals(baja)) {
        	List<GetFindPersonaAltasBajasDTO> personaBajas = this.tbasg100PersonaRepository.findPersonaBajas(codigos, fecDesde, fecHasta);
        	listaPersonas.addAll(personaBajas);
    	}

    	
    	if(CollectionUtils.isNotEmpty(listaPersonas)) {
    		return listaPersonas;
    	}
    	
    	return null;   	
    	
	}

    public List<GetFechaProxRecicTitConDTO> getFechaProxRecicTitCon(String cdgoPersona) {
        //return toDtos(tbasg100PersonaRepository.getFechaProxRecicTitCon(cdgoPersona));
    	return tbasg100PersonaRepository.getFechaProxRecicTitCon(cdgoPersona);
    }

    public List<GetFechaProxRecicTitConDTO> getFechaProxRecicTitConByMatricula(String idMatricula) {

        return tbasg100PersonaRepository.getFechaProxRecicTitConByMatricula(idMatricula);
    }

    public List<GetFechaProxRecicTitConNoMarcaDTO> getFechaProxRecicTitConNoMarca(String cdgoPersona) {
        //return toDtos(tbasg100PersonaRepository.getFechaProxRecicTitConNoMarca(cdgoPersona));
    	return tbasg100PersonaRepository.getFechaProxRecicTitConNoMarca(cdgoPersona);
    }

    public List<GetFechaProxRecicTitConNoMarcaDTO> getFechaProxRecicTitConNoMarcaS(String cdgoPersona) {
        //return toDtos(tbasg100PersonaRepository.getFechaProxRecicTitConNoMarcaS(cdgoPersona));
    	return tbasg100PersonaRepository.getFechaProxRecicTitConNoMarcaS(cdgoPersona);
    }

    public List<Tbasg100PersonaDto> getPersonaExaminador(String cdgoNif) {
        return toDtos(tbasg100PersonaRepository.getPersonaExaminador(cdgoNif));
    }

    public List<Tbasg100PersonaDto> getPersonaInstructor(String cdgoNif) {
        return toDtos(tbasg100PersonaRepository.getPersonaInstructor(cdgoNif));
    }

    public List<GetPersonaEstadoListDTO> getPersonaEstadoList(SetPersonaEstadoList mapPending) {
        return tbasg100PersonaRepository.getPersonaEstadoList(mapPending);
    }

    public List<Tbasg100PersonaDto> getMaxEstadoHabilitaCount() {
        return toDtos(tbasg100PersonaRepository.getMaxEstadoHabilitaCount());
    }

    public List<Tbasg100PersonaDto> getMaxEstadoProxRevListCount() {
        return toDtos(tbasg100PersonaRepository.getMaxEstadoProxRevListCount());
    }

    public List<GetPersonaCertificadosIdiomasListDTO> getPersonaCertificadosIdiomasList(SetPersonaCertificadosIdiomasList mapPending) {
        return tbasg100PersonaRepository.getPersonaCertificadosIdiomasList(mapPending);
    }

    public List<Tbasg100PersonaDto> getPersonaAllList(SetExpedientesPersonaListDTO filter) {
		return toDtos(tbasg100PersonaRepository.getPersonaAllList(filter));
	}



    public List<Tbasg100PersonaDto> getPersonaBySociedadesList() {
        return toDtos(tbasg100PersonaRepository.getPersonaBySociedadesList());
    }


    public List<Tbasg100PersonaDto> getPersona(String cdgoPersona) {
        return toDtos(tbasg100PersonaRepository.getPersona(cdgoPersona));
    }


    public List<Tbasg100PersonaDto> findPersonaByMatricula(String desgMatricula) {
        return toDtos(tbasg100PersonaRepository.findPersonaByMatricula(desgMatricula));
    }

    public List<Tbasg100PersonaDto> findPersonaByNifPas(String desgNifpas) {
        return toDtos(tbasg100PersonaRepository.findPersonaByNifPas(desgNifpas));
    }

    public List<Tbasg100PersonaDto> getPersonaByMatricula(String idMatricula) {
        return toDtos(tbasg100PersonaRepository.getPersonaByMatricula(idMatricula));
    }

    public List<Tbasg100PersonaDto> geCdgoPersona(String desgNifpas) {
        return toDtos(tbasg100PersonaRepository.geCdgoPersona(desgNifpas));
    }

    public List<Tbasg100PersonaDto> getDiasILT(String cdgoPersona) {
        return toDtos(tbasg100PersonaRepository.getDiasILT(cdgoPersona));
    }

    public List<Tbasg100PersonaDto> getCdgoPersonaMatricula(String desgMatricula) {
        return toDtos(tbasg100PersonaRepository.getCdgoPersonaMatricula(desgMatricula));
    }

    public List<Tbasg100PersonaDto> existePersonaDNI(String desgNifpas) {
        return toDtos(tbasg100PersonaRepository.existePersonaDNI(desgNifpas));
    }

    public List<Tbasg100PersonaDto> existePersonaRENFEDNI(String desgNifpas) {
        return toDtos(tbasg100PersonaRepository.existePersonaRENFEDNI(desgNifpas));
    }


    public List<GetFindPersonaAltasBajasDTO> findPersonaAltas(List<Integer> codigos, String fecDesde, String fecHasta) {
        return tbasg100PersonaRepository.findPersonaAltas(codigos, fecDesde, fecHasta);
    }

    public List<GetMaxEstadoProxRevListDTO> getMaxEstadoProxRevList(setMaxEstadoProxRevList mapPending) {
		return tbasg100PersonaRepository.getMaxEstadoProxRevList(mapPending);
	}


    public List<GetFindPersonaAltasBajasDTO> findPersonaBajas(List<Integer> codigos, String fecDesde, String fecHasta) {
        return tbasg100PersonaRepository.findPersonaBajas(codigos, fecDesde, fecHasta);
    }


    public List<GetDatosPersonaAcreditaDTO> getDatosPersonaAcredita(Integer cdgoPersona) {
        return tbasg100PersonaRepository.getDatosPersonaAcredita(cdgoPersona);
    }


    public List<Tbasg100PersonaDto> getPersonaFormador(String desgNifpas) {
        return toDtos(tbasg100PersonaRepository.getPersonaFormador(desgNifpas));
    }


    public List<Tbasg100PersonaDto> getDni(String desgMatricula) {
        return toDtos(tbasg100PersonaRepository.getDni(desgMatricula));
    }
    
	public JSONObject getLeerJson(String tabla) {
		
		return tbasg100PersonaRepository.getLeerJson(tabla);
	}

    public int insertPersona(Tbasg100Persona bean) {
        return tbasg100PersonaRepository.insertPersona(bean);
    }

    public int updatePersonalAct(Tbasg100Persona bean) {
        return tbasg100PersonaRepository.updatePersonalAct(bean);
    }

    public int updatePersonaMantenimiento(Tbasg100Persona bean) {
        return tbasg100PersonaRepository.updatePersonaMantenimiento(bean);
    }

    public int deletePersona(Tbasg100Persona bean) {
        return tbasg100PersonaRepository.deletePersona(bean);
    }

    public int updateReqMinimosPersonaAct(RequisitosMinimosDto bean) {
        return tbasg100PersonaRepository.updateReqMinimosPersonaAct(bean);
    }

    public List<GetPersonaEmpresaInformeDTO> getPersonaEmpresaInforme(Integer cdgoPersona) {
        return tbasg100PersonaRepository.getPersonaEmpresaInforme(cdgoPersona);
    }

    public List<Tbasg100PersonaDto> getTituloConList(String cdgoEstado, String cdgoEstado_1, String cdgoEstado_2, String cdgoEstado_3, String cdgoEstado_4) {
        return toDtos(tbasg100PersonaRepository.getTituloConList(cdgoEstado, cdgoEstado_1, cdgoEstado_2, cdgoEstado_3, cdgoEstado_4));
    }

    public List<Tbasg100PersonaDto> getTituloConListCount(String cdgoEstado, String cdgoEstado_1, String cdgoEstado_2, String cdgoEstado_3, String cdgoEstado_4) {
        return toDtos(tbasg100PersonaRepository.getTituloConListCount(cdgoEstado, cdgoEstado_1, cdgoEstado_2, cdgoEstado_3, cdgoEstado_4));
    }


    public List<Tbasg100PersonaDto> getTituloConListCountPorEstado(String cdgoEstado, String cdgoEstado_1, String cdgoEstado_2, String cdgoEstado_3, String cdgoEstado_4) {
        return toDtos(tbasg100PersonaRepository.getTituloConListCountPorEstado(cdgoEstado, cdgoEstado_1, cdgoEstado_2, cdgoEstado_3, cdgoEstado_4));
    }


    public Tbasg100PersonaDto toDto(Tbasg100Persona orig) {
        Tbasg100PersonaDto dest = new Tbasg100PersonaDto();
        try {
            BeanUtils.copyProperties(dest, orig);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return dest;
    }


    public Tbasg100Persona toEntity(Tbasg100PersonaDto orig) {



        Tbasg100Persona dest = new Tbasg100Persona();
        try {
            BeanUtils.copyProperties(dest, orig);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return dest;
    }



    public List<Tbasg100PersonaDto> toDtos(List<Tbasg100Persona> orig) {


        List<Tbasg100PersonaDto> dest = new ArrayList<>();
        if (orig == null) {
            return dest;
        }
        orig.forEach(origItem -> {
            dest.add(this.toDto(origItem));
        });
        return dest;
    }


    public List<GetPersonaResultDTO> toDtos3(List<GetPersonaResultDTO> orig) {


        List<GetPersonaResultDTO> dest = new ArrayList<>();
        if (orig == null) {
            return dest;
        }
        orig.forEach(origItem -> {
            dest.add(this.toDto3(origItem));
        });
        return dest;
    }

    public GetPersonaResultDTO toDto3(GetPersonaResultDTO orig) {

        GetPersonaResultDTO dest = new GetPersonaResultDTO();
        try {
            BeanUtils.copyProperties(dest, orig);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return dest;
    }

    public List<Tbasg100Persona> toEntities(List<Tbasg100PersonaDto> orig) throws IllegalAccessException, InvocationTargetException {

        List<Tbasg100Persona> dest = new ArrayList<>();
        if (orig == null) {
            return dest;
        }
        orig.forEach(origItem -> {
            dest.add(this.toEntity(origItem));
        });
        return dest;
    }

	@Override
	public List<GetMaxEstadoHabilitaListDTO> getMaxEstadoHabilitaList(SetMaxEstadoHabilitaList mapPending) {
		// TODO Auto-generated method stub
		return tbasg100PersonaRepository.getMaxEstadoHabilitaList(mapPending);
	}

	@Override
	public List<Tbasg100PersonaDto> getCertpsicCdgoPersona(Integer cdgoPersona) {
		// TODO Auto-generated method stub
		return null;
	}

    public List<Tbasg905OrganizationChartDto> getOrganizationalChart(Integer level, Integer id) {
        return tbasg100PersonaRepository.getOrganizationalChart(level, id);
    }  

    public int updateRevisionStatus(List<List<String>> expedientCodeList)  {
        return tbasg100PersonaRepository.updateRevisionStatus(expedientCodeList);
    } 
    
}
