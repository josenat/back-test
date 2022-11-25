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

import java.util.Iterator;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;

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

    	List confimList = tbasg100PersonaRepository.getPersonaEstadoList(mapPending);
		
		confimList = addCertPsicInfo(confimList, mapPending);
		if( mapPending.isNoSemaforosRojos() == true ){
	    	confimList = quitarSemaforosRojos(confimList);
	    } else if( mapPending.getTiempoLimiteRojo() != null && mapPending.getTiempoLimiteRojo() != 0 ){
	    	confimList = quitarTiempoLimiteRojo( confimList , mapPending.getTiempoLimiteRojo());
	    }
		
		List pendingList = addColor2(confimList);
		
		return confimList;

    }

    public List<Tbasg100PersonaDto> getMaxEstadoHabilitaCount() {
        return toDtos(tbasg100PersonaRepository.getMaxEstadoHabilitaCount());
    }

    public List<Tbasg100PersonaDto> getMaxEstadoProxRevListCount() {
        return toDtos(tbasg100PersonaRepository.getMaxEstadoProxRevListCount());
    }

    public List<GetPersonaCertificadosIdiomasListDTO> getPersonaCertificadosIdiomasList(SetPersonaCertificadosIdiomasList mapPending) {

    	List confimList = (tbasg100PersonaRepository.getPersonaCertificadosIdiomasList(mapPending));
		
		if( mapPending.isNoSemaforosRojos() == true ){
	    	confimList = quitarSemaforosRojos1(confimList);
	    } else if( mapPending.getTiempoLimiteRojo() != null && mapPending.getTiempoLimiteRojo() != 0 ){
	    	confimList = quitarTiempoLimiteRojo1( confimList , mapPending.getTiempoLimiteRojo());
	    }
		
		List pendingList = addColor1(confimList);
		
		return confimList;

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
		List confimList = tbasg100PersonaRepository.getMaxEstadoHabilitaList(mapPending);
		
		confimList = applyConditionsReciclaje(confimList, mapPending);
		if( mapPending.isNoSemaforosRojos() == true ){
	    	confimList = quitarSemaforosRojos(confimList);
	    } else if( mapPending.getTiempoLimiteRojo() != null && mapPending.getTiempoLimiteRojo() != 0 ){
	    	confimList = quitarTiempoLimiteRojo( confimList , mapPending.getTiempoLimiteRojo());
	    }
		
		confimList = addEstadoHabil(confimList, mapPending); 
        confimList = deleteSinManiobras(confimList);
        confimList = addTipoHabil(confimList);
        
        List pendingList = addColor(confimList);
        
        addAlcanceMap(pendingList);
		
		return confimList;
	}
	
	private void addAlcanceMap(List pendingList) {
		Integer cdgoAlcance = null;	
    	String  cdgoAlcanceCadena = null;	
    	String tablaAlcance = null;	
    	String descAlcance = null;	
    	Iterator confirmationItr = pendingList.iterator();
    	
    	while(confirmationItr.hasNext()){
    		GetMaxEstadoHabilitaListDTO confirmationMap = (GetMaxEstadoHabilitaListDTO)confirmationItr.next();	    

    		if(confirmationMap.getCdgoAlcanceot()!= null){
    			cdgoAlcance = confirmationMap.getCdgoAlcanceot();
    			List<Tbasg131AlcanceotDto> tbasg131 = tbasg131AlcanceotService.getAlcanceOt(cdgoAlcance);
    			
    			if(tbasg131!=null && tbasg131.size() > 0) {
    				descAlcance=tbasg131.get(0).getDesgNombre();    				
    			}
    			
    		}else if(confirmationMap.getCdgoEspec()!= null){
    			cdgoAlcance = (Integer)confirmationMap.getCdgoEspec();
    			List<Tbasg137EspecialiDto> tbasg137 = tbasg137EspecialiService.getEspeciali(cdgoAlcance);
    			
    			if(tbasg137!=null && tbasg137.size() > 0) {
    				descAlcance=tbasg137.get(0).getDesgNombre();
    			}
        			
    		}else if(confirmationMap.getCdgoAlcanceambito()!= null){
    			cdgoAlcance = (Integer)confirmationMap.getCdgoAlcanceambito();
    			List<Tbasg170VehiculoOvmDto> tbasg170 = tbasg170VehiculoOvmService.getVehiculoOVM(String.valueOf(cdgoAlcance));
    			
    			if(tbasg170!=null && tbasg170.size() > 0) {
    				descAlcance=tbasg170.get(0).getDesgNombre();
    			}
       		
    		}else if(confirmationMap.getCdgoEntorno()!= null){
        		cdgoAlcance = (Integer)confirmationMap.getCdgoEntorno();
        		List<Tbasg129EntornosDto> tbasg129 = tbasg129EntornosService.getEntornos(cdgoAlcance);

        		if(tbasg129!=null && tbasg129.size() > 0) {
    				descAlcance=tbasg129.get(0).getDesgNomcorto();
    			}
        		
        	}else if(confirmationMap.getCdgoLinea()!= null && !confirmationMap.getCdgoLinea().toString().trim().equals("")){
        		cdgoAlcanceCadena = confirmationMap.getCdgoLinea();
        		List<Tbasg128EstaclineDto> tbasg128Max = tbasg128EstaclineService.getEstacLineMax(cdgoAlcanceCadena);
        		
        		List<Tbasg128EstaclineDto> tbasg128Min = tbasg128EstaclineService.getEstacLineMin(cdgoAlcanceCadena);
        		
        		if(tbasg128Max != null && tbasg128Min != null) {
        			descAlcance = tbasg128Max.get(0).getDesgNomcorto() + " - " + tbasg128Min.get(0).getDesgNomcorto();
        		}
	        		
        	}else if(confirmationMap.getCdgoSerie()!= null && !confirmationMap.getCdgoSerie().toString().trim().equals("")){
	        	cdgoAlcanceCadena = confirmationMap.getCdgoSerie();
	        	List<Tbasg133SerieDto> tbasg133 = tbasg133SerieService.getSerie(cdgoAlcanceCadena);
	        	
	        	if(tbasg133!=null && tbasg133.size() > 0) {
    				descAlcance=tbasg133.get(0).getDesgNombre();
    			}				        	
	        }
    		
    		confirmationMap.setCdgoAlcance(cdgoAlcance);
    		confirmationMap.setDesgAlcance(descAlcance);
    	}
		
	}


	@Override
	public List<Tbasg100PersonaDto> getCertpsicCdgoPersona(Integer cdgoPersona) {
		// TODO Auto-generated method stub
		return null;
	}

    public List<Tbasg905OrganizationChartDto> getOrganizationalChart(Integer level, String id) {
        return tbasg100PersonaRepository.getOrganizationalChart(level, id);
    }  

    public int updateRevisionStatus(List<List<String>> expedientCodeList)  {
        return tbasg100PersonaRepository.updateRevisionStatus(expedientCodeList);
    } 
    
    private List addTipoHabil(List beanList) {
		//ViewAction objAction = null;
        List tipoHabList = null;
        List tipoHabListAux = new ArrayList();
        List cdgosHabil = new ArrayList();
        //metemos un cero por si la lista veine vacia
        cdgosHabil.add(new Integer(0));
        Iterator beanListIterator = beanList.iterator();
        Map cdgoHabilMap = new HashMap();
        //Metemos todos lis codigos de habilitacion en una lista
        while (beanListIterator.hasNext()){
            Integer cdgoHabil;
            GetMaxEstadoHabilitaListDTO pendingMap = (GetMaxEstadoHabilitaListDTO) beanListIterator.next();
            cdgoHabil = (Integer) pendingMap.getCdgoTipohab();
            cdgosHabil.add(cdgoHabil);
        }		
        
        cdgoHabilMap.put("cdgosHabil", cdgosHabil);
        try {
            tipoHabList = tbasg123TipohabilService.getTipoHabList(cdgoHabilMap);
        }
        catch (Exception e) {
        	logger.error("ERROR Getting list of PendingList", e.getMessage());
        }
        cdgoHabilMap.remove("cdgosHabil");	    
        
        beanListIterator = beanList.iterator();
        while (beanListIterator.hasNext()){
            String nombre = null;
            Integer cdgoHabil;
            GetMaxEstadoHabilitaListDTO pendingMap = (GetMaxEstadoHabilitaListDTO) beanListIterator.next();
            cdgoHabil = (Integer) pendingMap.getCdgoTipohab();
            nombre = getTipoHabil(cdgoHabil, tipoHabList);
            if (nombre != null)
                pendingMap.setDesgTipohab(nombre);
            tipoHabListAux.add(pendingMap);
        }
        return tipoHabListAux;
	}
    
    private String getTipoHabil(Integer cdgoExpedient, List estadoList) {
		Iterator estadoIterator = estadoList.iterator();
        Integer cdgoExpedientAux;
        while(estadoIterator.hasNext()) {
        	Tbasg123TipohabilDto mapaEstados = (Tbasg123TipohabilDto) estadoIterator.next();
            cdgoExpedientAux = (Integer) mapaEstados.getCdgoTipohab();
            if (cdgoExpedientAux.intValue() == cdgoExpedient.intValue())
                return (String) mapaEstados.getDesgNombre();
        }
        return null;
	}


    
	private List applyConditionsReciclaje(List confimList, SetMaxEstadoHabilitaList mapPending) {
			
			Iterator confrimListIterator = confimList.iterator();
			GetMaxEstadoHabilitaListDTO resultadoMap = null;
	        Date fchaCursoInc = null;
	        Integer cdgoTipoHab = null;
	        
	        mapPending.setMesDeControl(2);
	        Calendar fchaHoyMasNMCal = Calendar.getInstance();
	        fchaHoyMasNMCal.add(Calendar.MONTH, mapPending.getMesDeControl());
	        ArrayList nuevaList = new ArrayList();
	        
	        if( confimList != null ){
				for( int i = 0 ; i < confimList.size() ; i ++ ){
					resultadoMap = (GetMaxEstadoHabilitaListDTO) confimList.get(i);
					fchaCursoInc = resultadoMap.getFchaCursoinc();
					System.out.println(fchaCursoInc);
					cdgoTipoHab = resultadoMap.getCdgoTipohab();
					System.out.println(cdgoTipoHab);
					if(fchaCursoInc!=null) {
						if (((cdgoTipoHab.intValue() > 2 && (fchaCursoInc.before(fchaHoyMasNMCal.getTime()) || fchaCursoInc.equals(fchaHoyMasNMCal.getTime()))))) {
			                nuevaList.add(resultadoMap);    
			            } 
					}
				}
			}
	        
			return nuevaList;
		}
	
		private List quitarSemaforosRojos(List pendingList) {
			Calendar low = Calendar.getInstance();
			Calendar calendarObj = Calendar.getInstance(); 
			
			List pendingListAux = null;
	    	GetMaxEstadoHabilitaListDTO pendingMap = null;
	    	if( pendingList != null ){
	        	pendingListAux = new ArrayList();
	        	
	        	for( int i = 0 ; i < pendingList.size() ; i ++ ){
	        		
	        		pendingMap = (GetMaxEstadoHabilitaListDTO) pendingList.get(i);
	        		
	        		if(!calendarObj.before(low)){
	        			pendingListAux.add(pendingMap);
					}
	        	}
	    	}
			return pendingListAux;
		}

		private List addEstadoHabil(List beanList, SetMaxEstadoHabilitaList mapPending) {
			//ViewAction objAction = null;
	        List estadoList = null;
	        List expedientList = null;
	        List estadoListAux = new ArrayList();
	        List cdgosExpedient = new ArrayList();
	        //metemos un cero por si la lista veine vacia
	        cdgosExpedient.add(new Integer(0));
	        
	        for(int i = 0; i < beanList.size(); i++) {
	        	Integer cdgoExpedient = null;
	        	GetMaxEstadoHabilitaListDTO pendingMap = (GetMaxEstadoHabilitaListDTO) beanList.get(i);
	        	cdgoExpedient = pendingMap.getCdgoExpedient();
	        	cdgosExpedient.add(cdgoExpedient);
	        }
	        
	        mapPending.setCdgoExpedient(cdgosExpedient);

	        try {
	            estadoList = tbasg104ExpedientService.getEstadoList(mapPending);
	        }
	        catch (Exception e) {
	    		logger.error("ERROR Getting list of PendingList", e.getMessage());
	        }		
	        //mapPending.remove("cdgosExpedient");

	            for(int i = 0; i < beanList.size(); i++) {
	            	String nombre = null;
	                Integer cdgoExpedient = null;
	                
		            GetMaxEstadoHabilitaListDTO pendingMap = (GetMaxEstadoHabilitaListDTO) beanList.get(i);
		            cdgoExpedient = pendingMap.getCdgoExpedient();
		            //OBTENGO NOMBRE DEL ESTADO
		            nombre = getEstadoHabil(cdgoExpedient, estadoList);
		            if (nombre != null){
		                pendingMap.setEstadoTitulos(nombre);
		                estadoListAux.add(pendingMap);
		            }
		        }
		        return estadoListAux;
			}
		
		private String getEstadoHabil(Integer cdgoExpedient, List estadoList) {
	        
	        Integer cdgoExpedientAux;
	        for(int i = 0; i < estadoList.size(); i++) {
	        	GetEstadoListDTO mapaEstados = (GetEstadoListDTO) estadoList.get(i);
	            cdgoExpedientAux = mapaEstados.getCdgoExpedient();
	            if (cdgoExpedientAux.intValue() == cdgoExpedient.intValue())
	                return (String) mapaEstados.getDesgNombre();
	        }
	        return null;
	    }

		private List deleteSinManiobras(List lista) {
			GetMaxEstadoHabilitaListDTO mapConsulta = null;
			GetMaxEstadoHabilitaListDTO mapAOT = null;
			GetMaxEstadoHabilitaListDTO mapAOTOtroAOT = null;
	    	Integer cdgoPersona = null;
	    	Integer cdgoTipoHab = null;
	    	Integer cdgoAlcanceOt = null;
	    	int indice = 0;
	    	int numBorrados = 0;
	    	List listaAOT = new ArrayList();
	    	
	    	// Recorro la lista de habilitaciones quedándome con las de tipo auxiliar de operaciones de tren con código 
	    	// alcanceOT con maniobras o sin maniobras.
	    	for( int i = 0 ; i < lista.size() ; i ++ ){
	    		mapConsulta = (GetMaxEstadoHabilitaListDTO) lista.get(i);
	    		cdgoPersona = mapConsulta.getCdgoPersona();
	    		cdgoTipoHab = mapConsulta.getCdgoTipohab();
	    		cdgoAlcanceOt = mapConsulta.getCdgoAlcanceot();
	    		
	    		if(cdgoTipoHab != null && cdgoAlcanceOt != null) {
		    		if( cdgoTipoHab.intValue() == MultivalueCts.T123_TIPOHABIL_AUX_OPERACIONES_TREN.intValue() 
		    			&& ( cdgoAlcanceOt.intValue() == MultivalueCts.T131_ALCANCEOT_CON_MANIOBRAS.intValue() || cdgoAlcanceOt.intValue() == MultivalueCts.T131_ALCANCEOT_SIN_MANIOBRAS.intValue() )){
		    			mapAOT = new GetMaxEstadoHabilitaListDTO();
		    			mapAOT.setCdgoPersona(cdgoPersona);
		    			mapAOT.setCdgoAlcanceot(cdgoAlcanceOt);
		    			mapAOT.setIndice(new Integer(i));
		    			listaAOT.add( mapAOT );
		    		}
	    		}
	    	}
	    	
	    	// Recorro la lista de habilitaciones tipo auxiliar de operaciones de tren con alcances con y sin maniobras
	    	// y para cada habilitacion sin maniobras miro si existe una con maniobras.
	    	// Si existe, borro la de sin maniobras de la lista anterior.
	    	for( int i = 0 ; i < listaAOT.size() ; i ++ ){
	    		
	    		mapAOT = (GetMaxEstadoHabilitaListDTO) listaAOT.get(i);
	    		if( ((Integer)mapAOT.getCdgoAlcanceot()).intValue() == MultivalueCts.T131_ALCANCEOT_SIN_MANIOBRAS.intValue() ){
	    			for( int j = 0 ; j < listaAOT.size() ; j ++ ){
	    				mapAOTOtroAOT = (GetMaxEstadoHabilitaListDTO) listaAOT.get( j );
	    				cdgoPersona = (Integer) mapAOTOtroAOT.getCdgoPersona();
	    				cdgoAlcanceOt = (Integer) mapAOTOtroAOT.getCdgoAlcanceot();
	    				if( cdgoPersona.intValue() == ((Integer)mapAOT.getCdgoPersona()).intValue() 
	    					&& cdgoAlcanceOt.intValue() == MultivalueCts.T131_ALCANCEOT_CON_MANIOBRAS.intValue() ){
	    	    			indice = mapAOT.getIndice();
	    	    			indice -= numBorrados;
	    	    			lista.remove( indice );
	    	    			numBorrados ++;    
	    				}
	    			}
	    		}
	    	}
	    	
	    	return lista;
		}
		
		private List addColor(List pendingList) {
			java.util.Date lows, highs, mediums = null;
			Date fecha = null;
			Date fechaProxRev = null;
			Date fechaReciclaje = null;
			Date fechaCaducidad = null;
		    List<Tbasg199DatConf> HIGH, MEDIUM, LOW;
		    int High, Medium, Low;
			Integer CDGOHABIL1, CDGOHABIL2;
		    
		    HIGH = tbasg199DatConfService.SQL_LOAD_VALUES(MultivalueCts.PENDIENTE_NUMBER_MONTH_HIGH_LEVEL);
		    High = Integer.parseInt(HIGH.get(0).getValor().trim());
		    MEDIUM = tbasg199DatConfService.SQL_LOAD_VALUES(MultivalueCts.PENDIENTE_NUMBER_MONTH_MEDIUM_LEVEL);	
		    Medium = Integer.parseInt(MEDIUM.get(0).getValor().trim());
		    LOW = tbasg199DatConfService.SQL_LOAD_VALUES(MultivalueCts.PENDIENTE_NUMBER_MONTH_LOW_LEVEL);
		    Low = Integer.parseInt(LOW.get(0).getValor().trim());
		    
		    CDGOHABIL1 = MultivalueCts.T123_TIPOHABIL_CONDUCCION_INFRAESTRUCTURA;
		    CDGOHABIL2 = MultivalueCts.T123_TIPOHABIL_CONDUCCION_MATERIAL;
		    
		    Calendar calendarObj = Calendar.getInstance(); 
			String color = "";
			String mrcaActivo = "";
			Calendar low, medium, high;
			Calendar proxRevCalendar = Calendar.getInstance(); 
			Calendar fchaReciclajeCalendar = Calendar.getInstance(); 
			Calendar fchaActual = Calendar.getInstance(); 
			Calendar calendarAux = Calendar.getInstance();
			
			calendarAux = Calendar.getInstance();
			//comparamos la fecha actual con la fecha de expiracion mas tres meses
			calendarAux.add(Calendar.MONTH, (High));
			
			high = calendarAux;
			//inicializamos calendar aux 							
			calendarAux = Calendar.getInstance();
			calendarAux.add(Calendar.MONTH, (Medium));
			// menos de 1 mes
			medium = calendarAux;

			calendarAux = Calendar.getInstance();
			calendarAux.add(Calendar.MONTH, (Low));			
			// menor a la fecha actual
			low = calendarAux;
			lows = low.getTime();
			mediums = medium.getTime();
			highs =  high.getTime();
			
			Iterator pendingListIterator = pendingList.iterator();
			List pendingListAux = new ArrayList();
			
			calendarAux = Calendar.getInstance();
			calendarObj = Calendar.getInstance();
			
			while (pendingListIterator.hasNext()){
				GetMaxEstadoHabilitaListDTO pendingMap = (GetMaxEstadoHabilitaListDTO) pendingListIterator.next();
			    Integer cdgoTipoHabil = null;
			    if (pendingMap.getCdgoTipohab() != null ) {
			        cdgoTipoHabil = (Integer) pendingMap.getCdgoTipohab();
			    }

			    if (pendingMap.getFchaCursoinc()!=  null) {
					fechaReciclaje  = (Date)pendingMap.getFchaCursoinc();
					fchaReciclajeCalendar.setTimeInMillis(fechaReciclaje.getTime());
				}
			    
			    fecha = fechaReciclaje;
			    
			    if (fecha != null) {
					
				//	BigDecimal b = new BigDecimal("2207520000000");
				//	calendarObj.setTimeInMillis(fecha.getTime()-b.intValue());
					calendarObj.setTimeInMillis(fecha.getTime());
					//Si su mrca activo es  N entonces se muestra como rojo
					if (mrcaActivo != "" && mrcaActivo.equals("N"))
						color = "red";
					else if ((calendarObj.after(medium) || calendarObj.equals(medium)) && calendarObj.before(high)) {
						color = "yellow";
					}
					else if (calendarObj.before(medium) && (calendarObj.after(low) || calendarObj.equals(low))){
						color = "orange";
					} 
					else if (calendarObj.after(medium)){
						color = "green";
					} 
					else if(calendarObj.before(low)){
						color = "red";
					}										
				}
			    
			    if (!color.equals("")) {
				    pendingMap.setColor(color);
				    pendingListAux.add(pendingMap);	
				}
			    
			    fecha = null;
			}
			
			return pendingListAux;	
		}

		private List quitarTiempoLimiteRojo(List pendingList, Integer tiempoLimiteRojo) {
			Date fecha = null;
			java.util.Date fechaLimite = null;
			String cadenaFecha = null;
			GetMaxEstadoHabilitaListDTO pendingMap = null;
			List pendingListAux = null;
			Calendar fechaC = Calendar.getInstance();
			fechaC.add( Calendar.MONTH , - tiempoLimiteRojo.intValue());
			fechaLimite = fechaC.getTime();
			cadenaFecha = "fchaCursoinc"; 

			if( pendingList != null ){
				pendingListAux = new ArrayList();
				for( int i = 0 ; i < pendingList.size() ; i ++ ){
					pendingMap = (GetMaxEstadoHabilitaListDTO) pendingList.get(i);
					fecha = pendingMap.getFchaCursoinc();
					if( fechaLimite.before( fecha ) ){
	        			pendingListAux.add(pendingMap);
	        		}
				}
			}
			
			return pendingListAux;
		}
		
		private List addColor2(List pendingList) {
			java.util.Date lows, highs, mediums = null;
			Date fecha = null;
			Date fechaProxRev = null;
			Date fechaReciclaje = null;
			Date fechaCaducidad = null;
		    List<Tbasg199DatConf> HIGH, MEDIUM, LOW;
		    int High, Medium, Low;
			Integer CDGOHABIL1, CDGOHABIL2;
		    
		    HIGH = tbasg199DatConfService.SQL_LOAD_VALUES(MultivalueCts.PENDIENTE_NUMBER_MONTH_HIGH_LEVEL);
		    High = Integer.parseInt(HIGH.get(0).getValor().trim());
		    MEDIUM = tbasg199DatConfService.SQL_LOAD_VALUES(MultivalueCts.PENDIENTE_NUMBER_MONTH_MEDIUM_LEVEL);	
		    Medium = Integer.parseInt(MEDIUM.get(0).getValor().trim());
		    LOW = tbasg199DatConfService.SQL_LOAD_VALUES(MultivalueCts.PENDIENTE_NUMBER_MONTH_LOW_LEVEL);
		    Low = Integer.parseInt(LOW.get(0).getValor().trim());
		    
		    CDGOHABIL1 = MultivalueCts.T123_TIPOHABIL_CONDUCCION_INFRAESTRUCTURA;
		    CDGOHABIL2 = MultivalueCts.T123_TIPOHABIL_CONDUCCION_MATERIAL;
		    
		    Calendar calendarObj = Calendar.getInstance(); 
			String color = "";
			String mrcaActivo = "";
			Calendar low, medium, high;
			Calendar proxRevCalendar = Calendar.getInstance(); 
			Calendar fchaReciclajeCalendar = Calendar.getInstance(); 
			Calendar fchaActual = Calendar.getInstance(); 
			Calendar calendarAux = Calendar.getInstance();
			
			calendarAux = Calendar.getInstance();
			//comparamos la fecha actual con la fecha de expiracion mas tres meses
			calendarAux.add(Calendar.MONTH, (High));
			high = calendarAux;
			
			//inicializamos calendar aux 							
			calendarAux = Calendar.getInstance();
			calendarAux.add(Calendar.MONTH, (Medium));
			medium = calendarAux;

			calendarAux = Calendar.getInstance();
			calendarAux.add(Calendar.MONTH, (Low));			
			low = calendarAux;
			
			lows = low.getTime();
			mediums = medium.getTime();
			highs =  high.getTime();
			
			Iterator pendingListIterator = pendingList.iterator();
			List pendingListAux = new ArrayList();
			
			calendarAux = Calendar.getInstance();
			calendarObj = Calendar.getInstance();
			
			while (pendingListIterator.hasNext()){
				GetPersonaEstadoListDTO pendingMap = (GetPersonaEstadoListDTO) pendingListIterator.next();
			    Integer cdgoTipoHabil = null;
			    
		    	fechaProxRev  = (Date)pendingMap.getFchaProxrev();
		    	proxRevCalendar.setTimeInMillis(fechaProxRev.getTime());
			    
			    fecha = fechaProxRev;
			    
			    if (fecha != null) {
					
				//	BigDecimal b = new BigDecimal("2207520000000");
				//	calendarObj.setTimeInMillis(fecha.getTime()-b.intValue());
					calendarObj.setTimeInMillis(fecha.getTime());
					//Si su mrca activo es  N entonces se muestra como rojo
					if (mrcaActivo != "" && mrcaActivo.equals("N"))
						color = "red";
					else if ((calendarObj.after(medium) || calendarObj.equals(medium)) && calendarObj.before(high)) {
						color = "yellow";
					}
					else if (calendarObj.before(medium) && (calendarObj.after(low) || calendarObj.equals(low))){
						color = "orange";
					} 
					else if (calendarObj.after(medium)){
						color = "green";
					} 
					else if(calendarObj.before(low)){
						color = "red";
					}										
				}
			    
			    if (!color.equals("")) {
				    pendingMap.setColor(color);
				    pendingListAux.add(pendingMap);	
				}
			    
			    fecha = null;
			}
			
			return pendingListAux;	
		}
		
		private List addCertPsicInfo(List confimList, SetPersonaEstadoList mapPending) {
			List listCertPsic = null;
			List listCertPsicTodos = null;
			List confirmListFinal = null;
			List listCdgoPersonas = null;
			GetPersonaEstadoListDTO mapPersona = null;
			GetPersonaEstadoListDTO mapPersonaCompleto = null;
			GetCertsPsicByPersListDTO mapCertPsic = null;
			Date fchaProxRev = null;
			int cdgoPsicAmbAnterior = 0;
			int cdgoPsicAmb = 0;
			boolean activoDesuso = false;
			boolean insertar = false;
			boolean personaNueva = true;
			boolean existeNuevoIgual = false;
			Integer cdgoPersona = null;
			int introducidos = 0;
			//List confirmListFecha = null;
			
			if( confimList != null && !confimList.isEmpty() ){
				
				listCdgoPersonas = new ArrayList();
				for( int i = 0 ; i < confimList.size() ; i ++ ){
		    		mapPersona = (GetPersonaEstadoListDTO) confimList.get(i);
		    		listCdgoPersonas.add(mapPersona.getCdgoPersona());
				}
				listCertPsicTodos = tbasg101CertpsicRepository.getCertsPsicByPersList(listCdgoPersonas);
				
				for( int i = 0 ; i < confimList.size() ; i ++ ){
					mapPersona = (GetPersonaEstadoListDTO) confimList.get(i);
		    		cdgoPersona = mapPersona.getCdgoPersona();
		    		listCertPsic = new ArrayList();
		    		
		    		for( int j = 0 ; j < listCertPsicTodos.size() && introducidos != 2 ; j ++ ){
		    			mapCertPsic = (GetCertsPsicByPersListDTO) listCertPsicTodos.get(j);
		    			
		    			if( cdgoPersona.equals(mapCertPsic.getCdgoPersona())){
		    				listCertPsic.add( mapCertPsic );	
		    				listCertPsicTodos.remove(mapCertPsic);
		    				j--;
		    				introducidos = 1;
		    			} else if( listCertPsic != null && !listCertPsic.isEmpty() )
		    				introducidos = 2;
		    		}
		    		
		    		introducidos = 0;
		    		
		    		mapCertPsic = null;
		    		if( listCertPsic != null && !listCertPsic.isEmpty() ){
		    			for( int j = 0 ; j < listCertPsic.size() ; j ++ ){
		    				
		    				mapCertPsic = (GetCertsPsicByPersListDTO) listCertPsic.get(j);
		    				cdgoPsicAmb = mapCertPsic.getCdgoPsicamb();
		    				
		    				if( cdgoPsicAmb != cdgoPsicAmbAnterior ){
		    					
		    					if( cdgoPsicAmb == MultivalueCts.T109_PSICOAMBI_TIPO_1_EN_DESUSO  
		    							|| cdgoPsicAmb == MultivalueCts.T109_PSICOAMBI_TIPO_2_EN_DESUSO  
		    							|| cdgoPsicAmb == MultivalueCts.T109_PSICOAMBI_TIPO_3_EN_DESUSO  
		    							|| cdgoPsicAmb == MultivalueCts.T109_PSICOAMBI_TIPO_4_EN_DESUSO  
		    							|| cdgoPsicAmb == MultivalueCts.T109_PSICOAMBI_TIPO_5_EN_DESUSO
		    							|| cdgoPsicAmb == MultivalueCts.T109_PSICOAMBI_TIPO_6_EN_DESUSO ){
		    						
		    						existeNuevoIgual = existeCertPsicNuevoIgual( listCertPsic , cdgoPsicAmb );
		    						
		    						if((((fchaProxRev == null || (mapCertPsic.getFchaProxrev()).after(fchaProxRev) || (mapCertPsic.getMrcaActivo())==('S')) && !activoDesuso ) || 
										((mapCertPsic.getMrcaActivo())==('S') && (fchaProxRev == null || (mapCertPsic.getFchaProxrev()).after(fchaProxRev)) && activoDesuso)) 
											&&  !existeNuevoIgual ){
		    							
		    							fchaProxRev = mapCertPsic.getFchaProxrev();
		            					activoDesuso = mapCertPsic.getMrcaActivo()==('S');
		            					
		            					if( !personaNueva && confirmListFinal != null && !confirmListFinal.isEmpty() ){
		            						confirmListFinal.remove( confirmListFinal.size() - 1 );
		            					}
		            					
		            					personaNueva = false;
		            					insertar = true;
		            					
		    						}else {
		    							insertar = false;
		    						}
		    						
		    					}else{
		    						insertar = true;
		    					}
		    					
		    					if( insertar ){
		        					mapPersonaCompleto = (mapPersona);
		        					mapPersonaCompleto.setMrcaActivo(mapCertPsic.getMrcaActivo());
		        					mapPersonaCompleto.setFchaProxrev(mapCertPsic.getFchaProxrev());
		        					mapPersonaCompleto.setCdgoPsicamb(mapCertPsic.getCdgoPsicamb());
		        					mapPersonaCompleto.setDesgPsicamb(mapCertPsic.getDesgNombre());
		        					//mapPersonaCompleto.put( "psicAmb" , mapCertPsic.getCdgoPsicamb() );
		        					
		        					if( confirmListFinal == null )
		        						confirmListFinal = new ArrayList();
		        					
		        					confirmListFinal.add(mapPersonaCompleto);
		        					mapPersonaCompleto = null;
		        					cdgoPsicAmbAnterior = cdgoPsicAmb;
		    					}
		    				}
		    				
		    				mapCertPsic = null;
						}
		    			
		    			cdgoPsicAmb = 0;
		    			cdgoPsicAmbAnterior = 0;
		    			fchaProxRev = null;
		    			activoDesuso = false;
		    			personaNueva = true;
					}
		    		
		    		mapPersona = null;
		    		listCertPsic = null;
				}
			}
			
			List confirmListFecha = null;
	    	fchaProxRev = null;
	        Calendar fchaHoyMasNMCal = Calendar.getInstance();
	        fchaHoyMasNMCal.add(Calendar.MONTH, mapPending.getMesDeControl());
	    	if( confirmListFinal != null && !confirmListFinal.isEmpty() ){
	    		for( int i = 0 ; i < confirmListFinal.size() ; i ++ ){
	    			mapPersonaCompleto = (GetPersonaEstadoListDTO) confirmListFinal.get(i);
	                fchaProxRev  = (Date) mapPersonaCompleto.getFchaProxrev();
	                if (fchaProxRev.before(fchaHoyMasNMCal.getTime()) || fchaProxRev.equals(fchaHoyMasNMCal.getTime())){
	                	if( confirmListFecha == null )
	                		confirmListFecha = new ArrayList();
	                	confirmListFecha.add(mapPersonaCompleto);
	                }
	    			mapPersonaCompleto = null;
	    		}	
	    	}
			
			return confirmListFecha;
		}
		
		private List quitarSemaforosRojos1(List pendingList) {
			
			Integer HIGH, MEDIUM, LOW;
			Date fecha = null;
		    
			Calendar calendarAux = Calendar.getInstance();
			Calendar calendarObj = Calendar.getInstance(); 
			Calendar low;
				
	    	List pendingListAux = null;
	    	GetPersonaCertificadosIdiomasListDTO pendingMap = null;
	    	if( pendingList != null ){
	        	pendingListAux = new ArrayList();
	        	
	        	for( int i = 0 ; i < pendingList.size() ; i ++ ){
	        		
	        		pendingMap = (GetPersonaCertificadosIdiomasListDTO) pendingList.get(i);
					fecha = (Date) pendingMap.getFchaExpedicion();
					calendarObj.setTimeInMillis(fecha.getTime());
	        		
	        		if(!calendarObj.before(calendarAux)){
	        			pendingListAux.add( pendingMap );
					}
	        		
	        	}
	        	
	    	}
	    	
	    	return pendingListAux;
		}
		
		private List quitarTiempoLimiteRojo1(List pendingList, Integer tiempoLimiteRojo) {
			Date fecha = null;
			java.util.Date fechaLimite = null;
			String cadenaFecha = null;
			GetPersonaCertificadosIdiomasListDTO pendingMap = null;
			List pendingListAux = null;
			Calendar fechaC = Calendar.getInstance();
			fechaC.add( Calendar.MONTH , - tiempoLimiteRojo.intValue() );
			fechaLimite = fechaC.getTime();
			
			if( pendingList != null ){
				pendingListAux = new ArrayList();
				for( int i = 0 ; i < pendingList.size() ; i ++ ){
					pendingMap = (GetPersonaCertificadosIdiomasListDTO) pendingList.get(i);
					fecha = pendingMap.getFchaExpedicion();
					if( fechaLimite.before( fecha ) ){
	        			pendingListAux.add( pendingMap );
	        		}
				}
			}
			
			return pendingListAux;
		}

		private List addColor1(List pendingList) {
			java.util.Date lows, highs, mediums = null;
			java.util.Date fecha = null;
			Date fechaProxRev = null;
			Date fechaReciclaje = null;
			java.util.Date fechaCaducidad = null;
		    List<Tbasg199DatConf> HIGH, MEDIUM, LOW;
		    int High, Medium, Low;
			Integer CDGOHABIL1, CDGOHABIL2;
		    
		    HIGH = tbasg199DatConfService.SQL_LOAD_VALUES(MultivalueCts.PENDIENTE_NUMBER_MONTH_HIGH_LEVEL);
		    High = Integer.parseInt(HIGH.get(0).getValor().trim());
		    MEDIUM = tbasg199DatConfService.SQL_LOAD_VALUES(MultivalueCts.PENDIENTE_NUMBER_MONTH_MEDIUM_LEVEL);	
		    Medium = Integer.parseInt(MEDIUM.get(0).getValor().trim());
		    LOW = tbasg199DatConfService.SQL_LOAD_VALUES(MultivalueCts.PENDIENTE_NUMBER_MONTH_LOW_LEVEL);
		    Low = Integer.parseInt(LOW.get(0).getValor().trim());
		    
		    CDGOHABIL1 = MultivalueCts.T123_TIPOHABIL_CONDUCCION_INFRAESTRUCTURA;
		    CDGOHABIL2 = MultivalueCts.T123_TIPOHABIL_CONDUCCION_MATERIAL;
		    
		    Calendar calendarObj = Calendar.getInstance(); 
			String color = "";
			String mrcaActivo = "";
			Calendar low, medium, high;
			Calendar proxRevCalendar = Calendar.getInstance(); 
			Calendar fchaReciclajeCalendar = Calendar.getInstance(); 
			Calendar fchaActual = Calendar.getInstance(); 
			Calendar calendarAux = Calendar.getInstance();
			
			calendarAux = Calendar.getInstance();
			//comparamos la fecha actual con la fecha de expiracion mas tres meses
			calendarAux.add(Calendar.MONTH, (High));
			
			high = calendarAux;
			//inicializamos calendar aux 							
			calendarAux = Calendar.getInstance();
			calendarAux.add(Calendar.MONTH, (Medium));
			// menos de 1 mes
			medium = calendarAux;

			calendarAux = Calendar.getInstance();
			calendarAux.add(Calendar.MONTH, (Low));			
			// menor a la fecha actual
			low = calendarAux;
			
			lows = low.getTime();
			mediums = medium.getTime();
			highs =  high.getTime();
			
			Iterator pendingListIterator = pendingList.iterator();
			List pendingListAux = new ArrayList();
			
			calendarAux = Calendar.getInstance();
			calendarObj = Calendar.getInstance();
			
			while (pendingListIterator.hasNext()){
				GetPersonaCertificadosIdiomasListDTO pendingMap = (GetPersonaCertificadosIdiomasListDTO) pendingListIterator.next();

			    if (pendingMap.getFchaExpedicion()!=  null) {
			    	fechaCaducidad  = (Date)pendingMap.getFchaExpedicion();
					Calendar calendar = Calendar.getInstance();
					calendar.setTime(fechaCaducidad);
					
					if (pendingMap.getCdgoCategoria().equals(2)){
				    	Date fechaEquipos= new Date(2999,12,31);
						fchaReciclajeCalendar.setTimeInMillis(fechaEquipos.getTime());
						fechaCaducidad=fechaEquipos;
					// certificados idiomaticos caducan a los dos años 
				    } else {
					    calendar.add(Calendar.YEAR,MultivalueCts.CTE_CADUCIDAD_CERTIFICADOS);  // numero de años antes de caducar 2 en el caso de los certificados de idiomas
					    fechaCaducidad = calendar.getTime();
						fchaReciclajeCalendar.setTimeInMillis(fechaCaducidad.getTime());
				    	
				    }
					
				}
			    
			    fecha = fechaCaducidad;
			    
			    if (fecha != null) {
					
				//	BigDecimal b = new BigDecimal("2207520000000");
				//	calendarObj.setTimeInMillis(fecha.getTime()-b.intValue());
					calendarObj.setTimeInMillis(fecha.getTime());
					//Si su mrca activo es  N entonces se muestra como rojo
					if (mrcaActivo != "" && mrcaActivo.equals("N"))
						color = "red";
					else if ((calendarObj.after(medium) || calendarObj.equals(medium)) && calendarObj.before(high)) {
						color = "yellow";
					}
					else if (calendarObj.before(medium) && (calendarObj.after(low) || calendarObj.equals(low))){
						color = "orange";
					} 
					else if (calendarObj.after(medium)){
						color = "green";
					} 
					else if(calendarObj.before(low)){
						color = "red";
					}										
				}
			    
			    if (!color.equals("")) {
				    pendingMap.setColor(color);
				    pendingListAux.add(pendingMap);	
				}
			    
			    fecha = null;
			}
			
			return pendingListAux;	
		}


		private boolean existeCertPsicNuevoIgual(List listCertPsic, int cdgoPsicAmb) {

			GetCertsPsicByPersListDTO mapaCertPsic = null;
			int cdgoPsicAmbOtro = 0;
			boolean existe = false;
			
			for( int i = 0 ; i < listCertPsic.size() ; i ++ ){
				mapaCertPsic = (GetCertsPsicByPersListDTO) listCertPsic.get(i);
				cdgoPsicAmbOtro = mapaCertPsic.getCdgoPsicamb();
				
				switch( cdgoPsicAmb ){
				case( 1 ): 
					if( cdgoPsicAmbOtro == MultivalueCts.T109_PSICOAMBI_TIPO_1) {
						existe = true;
					}
					break;
				case( 2 ): 
					if( cdgoPsicAmbOtro == MultivalueCts.T109_PSICOAMBI_TIPO_2) {
						existe = true;
					}
					break;
				case( 3 ):
				case( 4 ):
				case( 5 ):
					if( cdgoPsicAmbOtro == MultivalueCts.T109_PSICOAMBI_TIPO_3|| cdgoPsicAmbOtro == MultivalueCts.T109_PSICOAMBI_TIPO_4) {
						existe = true;
					}
					break;
				case( 6 ): 
					if( cdgoPsicAmbOtro == MultivalueCts.T109_PSICOAMBI_TIPO_5) {
						existe = true;
					}
					break;
				}
			}
			return existe;
		}

    
}
