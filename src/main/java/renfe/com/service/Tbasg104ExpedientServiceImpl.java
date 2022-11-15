package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import com.renfe.webservicesoap.GetInfoHabilitacionResponse;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import renfe.com.dto.*;
import renfe.com.dto.CountGetTramosDTO;
import renfe.com.dto.DataGetExpedientesPersonaListDTO;
import renfe.com.dto.GetExpByCdgoPersonaAndCdgoExpedientDTO;
import renfe.com.dto.GetExpedientesPersonaLtDTO;
import renfe.com.dto.GetFechaExpFiltradaDTO;
import renfe.com.dto.GetFechaFinValidezDTO;
import renfe.com.dto.GetFechaProxRecicTitConDTO;
import renfe.com.dto.GetFechaProxRecicTitConNoMarcaDTO;
import renfe.com.dto.GetFindFchaExpedienteOtorgadoParaAotDTO;
import renfe.com.dto.GetFormacionComplementariaPersonaListResultDTO;
import renfe.com.dto.GetMaxEntornosExpCodListDTO;
import renfe.com.dto.GetRelHabPsicByCdgoCertPsicDTO;
import renfe.com.dto.GetTramosOrderByCodLineaDTO;
import renfe.com.dto.GetfindFchaHabilitacionParaAotDTO;
import renfe.com.dto.ParamCountGetTramos;
import renfe.com.dto.ParamExpedientesPersonaListDTO;

import renfe.com.dto.DataGetExpedientesPersonaListDTO;
import renfe.com.dto.GetEstadoListDTO;
import renfe.com.dto.ParamExpedientesPersonaListDTO;
import renfe.com.dto.SetMaxEstadoHabilitaList;

import renfe.com.model.dto.Tbasg104ExpedientDto;

import renfe.com.model.entity.*;
import renfe.com.repository.*;
import renfe.com.util.*;
import renfe.com.util.MultivalueCts;

import renfe.com.model.entity.Tbasg104Expedient;
import renfe.com.pdf.beans.CertificadoComplementarioAOTBean;
import renfe.com.pdf.beans.CertificadoComplementarioBean;
import renfe.com.pdf.beans.HabilitacionEstadoBean;
import renfe.com.pdf.core.InternalErrorException;
import renfe.com.pdf.datamanager.BundleMgr;
import renfe.com.pdf.datamanager.ConfigurationMgr;
import renfe.com.pdf.datamanager.TextFormat;
import renfe.com.repository.Tbasg104ExpedientRepository;
import renfe.com.repository.Tbasg129EntornosRepository;

@Transactional
@Service
public class Tbasg104ExpedientServiceImpl implements Tbasg104ExpedientService {

    @Autowired
    protected Logger logger;

    @Autowired
    private Tbasg104ExpedientRepository tbasg104ExpedientRepository;

    @Autowired
    private Tbasg100PersonaRepository tbasg100PersonaRepository;

    @Autowired
    private Tbasg101CertpsicRepository tbasg101CertpsicRepository;

    @Autowired
    private Tbasg102TituloconRepository tbasg102TituloconRepository;

    @Autowired
    private Tbasg107TipoviaRepository tbasg107TipoviaRepository;

    @Autowired
    private Tbasg108CentmedicRepository tbasg108CentmedicRepository;

    @Autowired
    private Tbasg109PsicoambiRepository tbasg109PsicoambiRepository;

    @Autowired
    private Tbasg110PsicomotiRepository tbasg110PsicomotiRepository;

    @Autowired
    private Tbasg111FacultatiRepository tbasg111FacultatiRepository;

    @Autowired
    private Tbasg115CalificacRepository tbasg115CalificacRepository;

    @Autowired
    private Tbasg118EstadoexpRepository tbasg118EstadoexpRepository;

    @Autowired
    private Tbasg121ActaformaRepository tbasg121ActaformaRepository;

    @Autowired
    private Tbasg124AmbitosRepository tbasg124AmbitosRepository;

    @Autowired
    private Tbasg125EmpresaRepository tbasg125EmpresaRepository;

    @Autowired
    private Tbasg127LineasRepository tbasg127LineasRepository;

    @Autowired
    private Tbasg128EstaclineRepository tbasg128EstaclineRepository;

    @Autowired
    private Tbasg129EntornosRepository tbasg129EntornosRepository;

    @Autowired
    private Tbasg131AlcanceotRepository tbasg131AlcanceotRepository;

    @Autowired
    private Tbasg133SerieRepository tbasg133SerieRepository;

    @Autowired
    private Tbasg134NacionRepository tbasg134NacionRepository;

    @Autowired
    private Tbasg137EspecialiRepository tbasg137EspecialiRepository;

    @Autowired
    private Tbasg153TarjetaRepository tbasg153TarjetaRepository;

    @Autowired
    private Tbasg157FormacComplemenRepository tbasg157FormacComplemenRepository;
	
	public List<GetExpByCdgoPersonaAndCdgoExpedientDTO> getExpByCdgoPersonaAndCdgoExpedient(Integer cdgoPersona,
			Integer cdgoExpediente) {
		return tbasg104ExpedientRepository.getExpByCdgoPersonaAndCdgoExpedient(cdgoPersona, cdgoExpediente);
	}

    @Autowired
    private Tbasg170VehiculoOvmRepository tbasg170VehiculoOvmRepository;

    @Autowired
    private Tbasg257AlcanauxcabRepository tbasg257AlcanauxcabRepository;


    public List<Tbasg104ExpedientDto> getAllTbasg104Expedient(Tbasg104ExpedientDto filter) {

        logger.info("getAllTbasg104Expedient " + filter);
        if (filter == null) {
            return this.toDtos(tbasg104ExpedientRepository.findAll());
        }
        return this.toDtos(tbasg104ExpedientRepository.findAll(Example.of(toEntity(filter))));
    }

    public Tbasg104ExpedientDto findByCdgoExpedient(Integer cdgoExpedient) {

        Optional<Tbasg104Expedient> tbasg104ExpedientData = tbasg104ExpedientRepository
                .findByCdgoExpedient(cdgoExpedient);

        if (tbasg104ExpedientData.isPresent()) {
            return toDto(tbasg104ExpedientData.get());
        }
        return null;
    }

    public Tbasg104ExpedientDto createTbasg104Expedient(Tbasg104ExpedientDto tbasg104ExpedientDto)
            throws IllegalAccessException, InvocationTargetException {

        Tbasg104Expedient dbTbasg104Expedient = new Tbasg104Expedient();
        BeanUtils.copyProperties(dbTbasg104Expedient, tbasg104ExpedientDto);
        Tbasg104Expedient _tbasg104Expedient = tbasg104ExpedientRepository.save(dbTbasg104Expedient);
        return toDto(_tbasg104Expedient);
    }

    public Tbasg104ExpedientDto updateTbasg104Expedient(Integer cdgoExpedient,
                                                        Tbasg104ExpedientDto tbasg104ExpedientDto) throws IllegalAccessException, InvocationTargetException {

        Optional<Tbasg104Expedient> tbasg104ExpedientData = tbasg104ExpedientRepository.findById(cdgoExpedient);

        if (tbasg104ExpedientData.isPresent()) {
            Tbasg104Expedient dbTbasg104Expedient = tbasg104ExpedientData.get();
            BeanUtils.copyProperties(dbTbasg104Expedient, tbasg104ExpedientDto);
            return toDto(tbasg104ExpedientRepository.save(dbTbasg104Expedient));
        }
        return null;
    }

    public int deleteTbasg104Expedient(Integer cdgoExpedient) {

        tbasg104ExpedientRepository.deleteById(cdgoExpedient);
        return 1;
    }

    public List<Tbasg104ExpedientDto> findByCdgoExpedientIn(List<Integer> cdgoExpedient) {

        List<Tbasg104Expedient> tbasg104Expedients = tbasg104ExpedientRepository.findByCdgoExpedientIn(cdgoExpedient);
	
        return toDtos(tbasg104Expedients);
    }
	
	public int updateExpedientExt(String descObservaExt, String descObserva, Character marcaActivo, String descUsuact, Integer cdgoPersona, Integer cdgoExpediente) {
		return tbasg104ExpedientRepository.updateExpedientExt(descObservaExt, descObserva, marcaActivo, descUsuact, cdgoPersona, cdgoExpediente);
	}


    public List<Tbasg104ExpedientDto> getTramosPersona(String cdgoPersona, String cdgoEmpresa, String cdgoTipohab,
                                                       String cdgoEntorno) {
        return toDtos(tbasg104ExpedientRepository.getTramosPersona(cdgoPersona, cdgoEmpresa, cdgoTipohab, cdgoEntorno));
    }

    public List<Tbasg104ExpedientDto> getTramosPersonaSinTramo(String cdgoPersona, String cdgoEmpresa,
                                                               String cdgoTipohab, String cdgoEntorno) {
        return toDtos(tbasg104ExpedientRepository.getTramosPersonaSinTramo(cdgoPersona, cdgoEmpresa, cdgoTipohab,
                cdgoEntorno));
    }

    public List<Tbasg104ExpedientDto> getFchaProxRevList(String cdgoExpedient) {
        return toDtos(tbasg104ExpedientRepository.getFchaProxRevList(cdgoExpedient));
    }

    public List<Tbasg104ExpedientDto> getFchaProxCursoList(String cdgoExpedient) {
        return toDtos(tbasg104ExpedientRepository.getFchaProxCursoList(cdgoExpedient));
    }

    public List<Tbasg104ExpedientDto> getMaxEstadoExpListCount() {
        return toDtos(tbasg104ExpedientRepository.getMaxEstadoExpListCount());
    }

    public List<Tbasg104ExpedientDto> getPreviousEstadoExpList(String cdgoExpedient) {
        return toDtos(tbasg104ExpedientRepository.getPreviousEstadoExpList(cdgoExpedient));
    }

    public List<Tbasg104ExpedientDto> getExpPersonaObject(String cdgoExpedient) {
        return toDtos(tbasg104ExpedientRepository.getExpPersonaObject(cdgoExpedient));
    }

    public List<Tbasg104ExpedientDto> getHistoricosEstadosExp(String cdgoExpedient) {
        return toDtos(tbasg104ExpedientRepository.getHistoricosEstadosExp(cdgoExpedient));
    }

    public List<Tbasg104ExpedientDto> getMaqByLineasEstacionesList(/** FIXME revisar tipo */
                                                                   Object cdgoLinea) {
        return toDtos(tbasg104ExpedientRepository.getMaqByLineasEstacionesList(cdgoLinea));
    }

    public List<Tbasg104ExpedientDto> getCdgoPersonaByExp(Integer cdgoExpedient) {
        return toDtos(tbasg104ExpedientRepository.getCdgoPersonaByExp(cdgoExpedient));
    }

    public List<Tbasg104ExpedientDto> getExpediente(Integer cdgoExpedient) {
        return toDtos(tbasg104ExpedientRepository.getExpediente(cdgoExpedient));
    }

    public List<Tbasg104ExpedientDto> getExpedientesByCdgoExp(List<Integer> cdgoExpedient) {
        return toDtos(tbasg104ExpedientRepository.getExpedientesByCdgoExp(cdgoExpedient));
    }

    public List<Tbasg104ExpedientDto> getExpedientesPersona(String cdgoPersona) {
        return toDtos(tbasg104ExpedientRepository.getExpedientesPersona(cdgoPersona));
    }

    public List<Tbasg104ExpedientDto> getExpedientesPersonaTodo(String cdgoPersona) {
        return toDtos(tbasg104ExpedientRepository.getExpedientesPersonaTodo(cdgoPersona));
    }

    public List<DataGetExpedientesPersonaListDTO> getExpedientesPersonaList(ParamExpedientesPersonaListDTO filtro) {
        return tbasg104ExpedientRepository.getExpedientesPersonaList(filtro);
    }
    
    public List<DataGetExpedientesPersonaListDTO> getExpedientesFiltro(ParamExpedientesPersonaListDTO filtro) {
 
        return tbasg104ExpedientRepository.getExpedientesFiltro(filtro);
    }

    public List<Tbasg104ExpedientDto> getExpedientesPersonaListCount(String cdgoPersona) {
        return toDtos(tbasg104ExpedientRepository.getExpedientesPersonaListCount(cdgoPersona));
    }

    public int getExistHabilitacion(Tbasg104ExpedientDto bean) {
        return tbasg104ExpedientRepository.getExistHabilitacion(bean);
    }

    public List<GetExpedientesPersonaDTO> getExpedientesPersonaParam(GetExpedientesPersonaParam filter) {

        return tbasg104ExpedientRepository.getExpedientesPersonaParam(filter);
    }

    public List<GetExpedientesPersonaLtDTO> getExpedientesPersonaListCod(String cdgoPersona, Integer cdgoEstado) {
        // return toDtos(tbasg104ExpedientRepository.getExpedientesPersonaListCod());
        return tbasg104ExpedientRepository.getExpedientesPersonaListCod(cdgoPersona, cdgoEstado);
    }

    public List<GetExpedientesPersonaLtDTO> getExpedientesPersonaListCodUserBaja(String cdgoPersona) {
        // return
        // toDtos(tbasg104ExpedientRepository.getExpedientesPersonaListCodUserBaja());
        return tbasg104ExpedientRepository.getExpedientesPersonaListCodUserBaja(cdgoPersona);
    }

    public List<Tbasg104ExpedientDto> findExpedientByCdgoPersonaAndTipoHab(String cdgoPersona, List<Integer>listaCodigosHab) {
        return toDtos(tbasg104ExpedientRepository.findExpedientByCdgoPersonaAndTipoHab(cdgoPersona, listaCodigosHab));
    }

    public List<GetFindFchaExpedienteOtorgadoParaAotDTO> findFchaExpedienteParaAOT(Integer cdgoPersona, Integer cdgoTipohab,
                                                                                   Integer cdgoAlcanceot) {
        //return toDtos(tbasg104ExpedientRepository.findFchaExpedienteParaAOT(cdgoPersona, cdgoTipohab, cdgoAlcanceot));
        return tbasg104ExpedientRepository.findFchaExpedienteParaAOT(cdgoPersona, cdgoTipohab, cdgoAlcanceot);
    }

    public List<GetFindFchaExpedienteOtorgadoParaAotDTO> findFchaExpedienteOtorgadoParaAOT(Integer cdgoPersona, Integer cdgoTipohab,
                                                                                           Integer cdgoAlcanceot) {
        //return toDtos(tbasg104ExpedientRepository.findFchaExpedienteOtorgadoParaAOT(cdgoPersona, cdgoTipohab, cdgoAlcanceot));
        return tbasg104ExpedientRepository.findFchaExpedienteOtorgadoParaAOT(cdgoPersona, cdgoTipohab, cdgoAlcanceot);
    }

    public List<GetFechaFinValidezDTO> getFechaFinValidez(Integer cdgoExpedient) {

        return tbasg104ExpedientRepository.getFechaFinValidez(cdgoExpedient);
    }
    
    public List<GetFechaFinValidezDTO> getFechaFinValidez2(Integer cdgoExpedient) {

        return tbasg104ExpedientRepository.getFechaFinValidez2(cdgoExpedient);
    }
    
    public List<GetFechaFinValidezDTO> getFechaFinValidez3(Integer cdgoExpedient) {

        return tbasg104ExpedientRepository.getFechaFinValidez3(cdgoExpedient);
    }

    public List<GetfindFchaHabilitacionParaAotDTO> findFchaHabilitacionParaAOT(Integer cdgoExpedient) {
        //return toDtos(tbasg104ExpedientRepository.findFchaHabilitacionParaAOT(cdgoExpedient));
        return tbasg104ExpedientRepository.findFchaHabilitacionParaAOT(cdgoExpedient);
    }
    
    public List<GetExpeTipoValidezReciclajeDTO> getExpeTipoValidezReciclaje(Integer cdgoExpedient) {

        return tbasg104ExpedientRepository.getExpeTipoValidezReciclaje(cdgoExpedient);
    }

    public List<Tbasg104ExpedientDto> findExpedientByCdgoPersonaAndLinea(String cdgoPersona, String cdgoTipohab) {
        return toDtos(tbasg104ExpedientRepository.findExpedientByCdgoPersonaAndLinea(cdgoPersona, cdgoTipohab));
    }

    public List<Tbasg104ExpedientDto> getObservaExt(String cdgoPersona) {
        return toDtos(tbasg104ExpedientRepository.getObservaExt(cdgoPersona));
    }

    public int insertExpediente(Tbasg104ExpedientDto bean) {
        return tbasg104ExpedientRepository.insertExpediente(bean);
    }

    public int updateExpedient(Tbasg104ExpedientDto bean) {
        return tbasg104ExpedientRepository.updateExpedient(bean);
    }

    public int updateExpedientMantenimiento(Tbasg104Expedient bean) {
        return tbasg104ExpedientRepository.updateExpedientMantenimiento(bean);
    }

    public int updateExpedientB(Tbasg104Expedient bean) {
        return tbasg104ExpedientRepository.updateExpedientB(bean);
    }

    public int deleteExpedient(Tbasg104Expedient bean) {
        return tbasg104ExpedientRepository.deleteExpedient(bean);
    }
    
    public int updateEmpresaExpedient(Tbasg104Expedient bean) {
        return tbasg104ExpedientRepository.updateEmpresaExpedient(bean);
    }

    public List<Tbasg104ExpedientDto> getMaxEstadoExpCount() {
        return toDtos(tbasg104ExpedientRepository.getMaxEstadoExpCount());
    }

    public List<GetEstadoListDTO> getEstadoList(SetMaxEstadoHabilitaList mapPending) {
        return tbasg104ExpedientRepository.getEstadoList(mapPending);
    }

    public Tbasg104ExpedientDto toDto(Tbasg104Expedient orig) {

        Tbasg104ExpedientDto dest = new Tbasg104ExpedientDto();
        try {
            BeanUtils.copyProperties(dest, orig);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return dest;
    }

    public Tbasg104Expedient toEntity(Tbasg104ExpedientDto orig) {

        Tbasg104Expedient dest = new Tbasg104Expedient();
        try {
            BeanUtils.copyProperties(dest, orig);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return dest;
    }

    public List<Tbasg104ExpedientDto> toDtos(List<Tbasg104Expedient> orig) {

        List<Tbasg104ExpedientDto> dest = new ArrayList<>();
        if (orig == null) {
            return dest;
        }
        orig.forEach(origItem -> {
            dest.add(this.toDto(origItem));
        });
        return dest;
    }

    public List<Tbasg104Expedient> toEntities(List<Tbasg104ExpedientDto> orig)
            throws IllegalAccessException, InvocationTargetException {

        List<Tbasg104Expedient> dest = new ArrayList<>();
        if (orig == null) {
            return dest;
        }
        orig.forEach(origItem -> {
            dest.add(this.toEntity(origItem));
        });
        return dest;
    }

    @Override
    public Object getCertificadoComplementarioActionbyMatricula(String idMatricula) throws Exception {

        CertificadoComplementarioBean bean = new CertificadoComplementarioBean();
        // PERSONA
        List<Tbasg100Persona> personaObject = this.tbasg100PersonaRepository.getPersonaByMatricula(this.convertirToString(idMatricula));
        Tbasg100Persona persona = new Tbasg100Persona();
        if (CollectionUtils.isNotEmpty(personaObject)) {
            persona = personaObject.get(0);
        }
        bean.setNifPas(persona.getDesgNifpas());

        boolean numEur = false;
        if (persona.getDesgEin() != null && !"".equals(persona.getDesgEin())) {
            bean.setNumRef(persona.getDesgEin());
            numEur = true;
        } else {
            bean.setNumRef(buildNumRef(persona.getDesgNifpas().trim()));
        }
        bean.setNumEin(numEur);
        bean.setApellidos(buildApellidos(persona));
        bean.setNombre(persona.getDesgNombre());
        bean.setMatricula(persona.getDesgMatricula());
        bean.setLugarNacimiento(persona.getDesgLugarnacimiento());
        bean.setCdgoAreaAct(persona.getCdgoAreact());

        if (persona.getFchaNacimiento() != null)
            bean.setFchaNacimiento(TextFormat.format(persona.getFchaNacimiento(), "/"));
        else
            bean.setFchaNacimiento("");
        bean.setLocalidad(persona.getDesgMunicipio());

        // TIPO VIA
        String descTipoVia = "";
        if (persona.getCdgoTipovia() != null) {
            List<Tbasg107Tipovia> tipoVia = this.tbasg107TipoviaRepository.getTipoVia(this.convertirToString(persona.getCdgoTipovia()));
            if (CollectionUtils.isNotEmpty(tipoVia))
                descTipoVia = tipoVia.get(0).getDesgNombre().trim();
        }
        bean.setDireccionPostal(buildDirPostal(persona, descTipoVia));

        // NACION
        List<Tbasg134Nacion> nacionObject = this.tbasg134NacionRepository.getNacion(this.convertirToString(persona.getCdgoNacion()));
        Tbasg134Nacion nacion = new Tbasg134Nacion();
        if (CollectionUtils.isNotEmpty(nacionObject)) {
            nacion = nacionObject.get(0);
        }

        bean.setNacionalidad(nacion.getDesgNombre());
        // LOCALIDAD - PAIS
        bean.setLocPais(buildLocPais(persona, nacion.getDesgNombre()));

        // TARJETA FECHAS
        List<Tbasg153Tarjeta> tarjeta = this.tbasg153TarjetaRepository.getTarjetaPer(this.convertirToString(persona.getCdgoPersona()));
        if (CollectionUtils.isNotEmpty(tarjeta)) {
            if (tarjeta.get(0).getFchaExpedicion() != null)
                bean.setFchaExpedicion(TextFormat.format(tarjeta.get(0).getFchaExpedicion(), "/"));
            else
                bean.setFchaExpedicion("");
            if (tarjeta.get(0).getFchaExpiracion() != null)
                bean.setFchaExpiracion(TextFormat.format(tarjeta.get(0).getFchaExpiracion(), "/"));
            else
                bean.setFchaExpiracion("");
        } else {
            bean.setFchaExpedicion("");
            bean.setFchaExpiracion("");
        }


        // CONOCIMIENTOS LINGUISTICOS

        Integer cdgoCategoria = MultivalueCts.T155_FC_CATEGORIA_CERTIF_IDIOMA;

        logger.debug("Certificado Complementario: Pasamos a getFormacComplemenPersonaList");
        List<GetFormacionComplementariaPersonaListResultDTO> lFormacComplemen = this.tbasg157FormacComplemenRepository.getFormacComplemenPersonaList(persona.getCdgoPersona(),cdgoCategoria, null);
        HashMap hsFormacion = null;
        List lConocimientos = new ArrayList();
        if (lFormacComplemen != null && !lFormacComplemen.isEmpty()) {
            for (int i = 0; i < lFormacComplemen.size(); i++) {
                lFormacComplemen.get(i);
                hsFormacion = new HashMap();
                if (lFormacComplemen.get(i).getFechaExpedicion() != null) {
                    hsFormacion.put("fchaExpedicion", TextFormat.format(lFormacComplemen.get(i).getFechaExpedicion(), "/"));
                } else {

                    hsFormacion.put("fchaExpedicion", "");
                }
                hsFormacion.put("lengua", lFormacComplemen.get(i).getCualificacion());
                if (lFormacComplemen.get(i).getObservaciones() != null)
                    hsFormacion.put("notas", lFormacComplemen.get(i).getObservaciones());
                else

                    hsFormacion.put("notas", "");

                lConocimientos.add(hsFormacion);
            }
        }
        bean.setListConocimientos(lConocimientos);


        // INFORMACIÓN ADICIONAL - FORMACIÓN COMPLEMENTARIA

        HashMap mapFiltroFormacionComp = new HashMap();
        Integer cdgoCategoria2 = MultivalueCts.T155_FC_CATEGORIA_CERTIF_SEGURIDAD_TREN;
        List<GetFormacionComplementariaPersonaListResultDTO> lFormacComplemenSeguridad = this.tbasg157FormacComplemenRepository.getFormacComplemenPersonaList(persona.getCdgoPersona(),cdgoCategoria2,null);

        HashMap hsInfoAdic = null;
        List lInfoAdic = new ArrayList();
        if (lFormacComplemenSeguridad != null && !lFormacComplemenSeguridad.isEmpty()) {
            for (int i = 0; i < lFormacComplemenSeguridad.size(); i++) {

                lFormacComplemenSeguridad.get(i);
                hsInfoAdic = new HashMap();
                if (lFormacComplemenSeguridad.get(i).getFechaExpedicion() != null) {
                    hsInfoAdic.put("fchaExpedicion", TextFormat.format(lFormacComplemenSeguridad.get(i).getFechaExpedicion(), "/"));
                } else {
                    hsInfoAdic.put("fchaExpedicion", "");
                }

                hsInfoAdic.put("descripcionCualificacion", lFormacComplemenSeguridad.get(i).getDesgCualificacion().substring(0, 1).toUpperCase() + lFormacComplemenSeguridad.get(i).getDesgCualificacion().substring(1).toLowerCase());

                lInfoAdic.add(hsInfoAdic);
            }
        }

        bean.setListInformacionAdic(lInfoAdic);

        List<Tbasg102Titulocon> tituloCon = this.tbasg102TituloconRepository.getTituloConPersona(this.convertirToString(persona.getCdgoPersona()));

        bean.setrestrinRam("RAM");

        if (CollectionUtils.isNotEmpty(tituloCon) && "RFIG".equals(tituloCon.get(0).getDesgSoloram())) {
            bean.setrestrinRam("RFIG");
        } else if (CollectionUtils.isNotEmpty(tituloCon) && "RAM+RFIG".equals(tituloCon.get(0).getDesgSoloram())) {
            bean.setrestrinRam("RAM+RFIG");
        }

        // Obtenemos las Habilitaciones

        List<Integer> lCdgoExpedientes = new ArrayList<Integer>();
        Map<Integer, Tbasg104Expedient> mapaExpedientes;

        List lMaterial = new ArrayList();
        List lLineas = new ArrayList();
        List lTramos = new ArrayList();

        logger.debug("Certificado Complementario: Pasamos a getExpedientesPersonaListCod");
        boolean isActivo = true;
        List<GetExpedientesPersonaLtDTO> lExpedientes;
        if (!isActivo) {
            lExpedientes = this.tbasg104ExpedientRepository.getExpedientesPersonaListCodUserBaja(this.convertirToString(persona.getCdgoPersona()));
        } else {
            lExpedientes = this.tbasg104ExpedientRepository.getExpedientesPersonaListCod(this.convertirToString(persona.getCdgoPersona()), null);
        }

        if (null != lExpedientes && !lExpedientes.isEmpty()) {
            logger.debug("lista de expedientes");

            for (int i = 0; i < lExpedientes.size(); i++) {

                lCdgoExpedientes.add(lExpedientes.get(i).getCdgoExpedient());
            }

            List<Tbasg104Expedient> getExpedientsByCdgoExpsAction = this.tbasg104ExpedientRepository.getExpedientesByCdgoExp(lCdgoExpedientes);

            List<Tbasg118Estadoexp> getFechasOtorgamientoAction = this.tbasg118EstadoexpRepository.getFechasOtorgamiento(lCdgoExpedientes);

            logger.debug("GetFechasOtorgamientoAction");

            Tbasg104Expedient objExpediente = null;
            Tbasg118Estadoexp mapaFechasOtorgamientosExp = null;

            logger.debug("Certificado Complementario: Pasamos a for expedientes");

            for (int i = 0; i < lExpedientes.size(); i++) {
                logger.debug("Entra correctamente en el bucle que recorre lExpedientes");

                List<GetMaxEntornosExpCodListDTO> lAlcanceAux = new ArrayList<>();
                Integer cdgoExp = lExpedientes.get(i).getCdgoExpedient();

                for (int j = 0; j < getExpedientsByCdgoExpsAction.size(); j++) {
                    if (Integer.valueOf(getExpedientsByCdgoExpsAction.get(j).getCdgoExpedient().toString()).equals(lExpedientes.get(i).getCdgoExpedient())) {
                        objExpediente = getExpedientsByCdgoExpsAction.get(j);
                        mapaFechasOtorgamientosExp = getFechasOtorgamientoAction.get(j);
                    }
                }

                if (objExpediente.getCdgoSerie() != null && "730".equals(objExpediente.getCdgoSerie())) {
                    logger.debug("Se comprueba que el ultimo vehiculo con codigo" + objExpediente.getCdgoSerie() + " esta llegando correctamente");
                }

                if (lExpedientes.get(i).getCdgoTipoHab() != null) {
                    Integer tipoHabil = lExpedientes.get(i).getCdgoTipoHab();
                    logger.debug("Tipo habilitacion" + tipoHabil);
                    if (tipoHabil.equals(MultivalueCts.T123_TIPOHABIL_CONDUCCION_INFRAESTRUCTURA)) {
                        if (objExpediente.getDesgTipoinfraestruc() != null && "L".equals(objExpediente.getDesgTipoinfraestruc())) {
                            logger.debug("Entra correctamente segun el tipo de infraestructura");
                            lLineas.add(getAlcanceLinea(objExpediente.getCdgoLinea(), mapaFechasOtorgamientosExp));

                        } else {
                            // Obtener habilitación por estado
                            if (null != cdgoExp && !"".equals(cdgoExp))

                                logger.debug("Obtiene habilitacion por estado");

                            lAlcanceAux = getAlcanceInfraestructuras(cdgoExp);

                            // Se obtiene la fecha de otorgamiento para cada línea de las habilitaciones
                            if (lAlcanceAux != null) {
                                logger.debug("Alcance auxiliar distinto de null");

                                GetMaxEntornosExpCodListDTO hmLinea = new GetMaxEntornosExpCodListDTO();

                                for (int l = 0; l < lAlcanceAux.size(); l++) {

                                    hmLinea = lAlcanceAux.get(l);

                                    if (hmLinea != null) {

                                        hmLinea = getFechaOtorgamiento(hmLinea, cdgoExp, mapaFechasOtorgamientosExp);

                                        lAlcanceAux.set(l, hmLinea);

                                        logger.debug("Obteniendo fecha otorgamiento");
                                    }
                                }
                            }

                            // Obtenemos el punto kilometrico de los tramos

                            if (lAlcanceAux != null) {

                                GetMaxEntornosExpCodListDTO hmLinea = new GetMaxEntornosExpCodListDTO();

                                for (int l = 0; l < lAlcanceAux.size(); l++) {

                                    hmLinea = lAlcanceAux.get(l);

                                    if (hmLinea != null) {
                                        hmLinea = getPuntoKilometricoTramo(hmLinea);

                                        lAlcanceAux.set(l, hmLinea);
                                        lTramos.add(hmLinea);

                                    }
                                }
                            }


                        }
                    } else if (tipoHabil.equals(MultivalueCts.T123_TIPOHABIL_CONDUCCION_MATERIAL)) {
                        logger.debug("Entra en el condicional segun el tipo de habilitacion");
                        lMaterial.add(getAlcanceMaterial(objExpediente, mapaFechasOtorgamientosExp));
                        logger.debug("Añadiendo a lista conduccion material");
                    }
                }
            }

            logger.debug("Certificado Complementario: Pasamos a ordenar los maps");
            HashMap[] arrayMaterial = (HashMap[]) lMaterial.toArray(new HashMap[lMaterial.size()]);
            Arrays.sort(arrayMaterial, new OrdenarMaterialComparator());
            bean.setListMaterial(new ArrayList(Arrays.asList(arrayMaterial)));
            logger.debug("ArrayMaterial");

            HashMap[] arrayLineas = (HashMap[]) lLineas.toArray(new HashMap[lLineas.size()]);
            Arrays.sort(arrayLineas, new OrdenarLineasComparator());
            bean.setListLineas(new ArrayList(Arrays.asList(arrayLineas)));
            logger.debug("ArrayLineas");

            // Obtengo de una tacada la lista de tramos
            List<GetTramosOrderByCodLineaDTO> listaTramos = new ArrayList<>();

            if (isActivo) {
                logger.debug("Persona activa tramos");
                listaTramos = getTramos(lCdgoExpedientes);
            } else {
                logger.debug("Persona inactiva tramos");
                listaTramos = getTramosPB(lCdgoExpedientes);
            }

            GetTramosOrderByCodLineaDTO[] arrayTramos;

            logger.debug("MARCA ELIMINA DUPLICADOS");
            arrayTramos = listaTramos.toArray(new GetTramosOrderByCodLineaDTO[listaTramos.size()]);

            GetTramosOrderByCodLineaDTO[] arrayTramosSinDupli = eliminaDuplicados(arrayTramos, lCdgoExpedientes);
            bean.setListTramos(new ArrayList(Arrays.asList(arrayTramosSinDupli)));

        }

        List<Tbasg101Certpsic> certComplem = this.tbasg101CertpsicRepository.getActiveCertPsicWithMaxFchaProxRev(this.convertirToString(persona.getCdgoPersona()));

        if (null != certComplem && "S".equals(certComplem.get(0).getMrcaCorrvisual())) {
            bean.setCorrVisual("S");
        } else {
            bean.setCorrVisual("N");
        }

        if (null != certComplem && "S".equals(certComplem.get(0).getMrcaProtaud())) {
            bean.setProtAudi("S");
        } else {
            bean.setProtAudi("N");
        }

        logger.debug("Certificado Complementario: Pasamos a getFechaExpFiltrada");
        List<GetFechaExpFiltradaDTO> fech = this.tbasg118EstadoexpRepository.getFechaExpFiltrada(this.convertirToString(persona.getCdgoPersona()));
        Date fechaExpAn = fech.get(0).getFchaEstado();

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String fechaaux1 = "02-01-2007";
        Date FechaAux = new Date(sdf.parse(fechaaux1).getTime());
        if (null != fechaExpAn) {
            if (fechaExpAn.before(FechaAux)) {
                String fechString = sdf.format(FechaAux);
                bean.setFechaexpedient(fechString);
            } else {
                String fechString = sdf.format(fechaExpAn);
                bean.setFechaexpedient(fechString);
            }
        }

        logger.debug("Certificado Complementario: Pasamos a getFechaProxReciTitCon");
        List<GetFechaProxRecicTitConDTO> fecha = this.tbasg100PersonaRepository.getFechaProxRecicTitCon(this.convertirToString(persona.getCdgoPersona()));
        Date fechaProx = fecha.get(0).getFchaCursoInc();

        SimpleDateFormat fds = new SimpleDateFormat("dd-MM-yyyy");
        String fechaaux2 = "02-01-2007";
        Date fechaproxaux = new Date(fds.parse(fechaaux2).getTime());
        if (null != fechaProx) {
            if ((fechaProx).before(fechaproxaux)) {
                String fechStringdos = fds.format(fechaproxaux);
                bean.setFchaExpiracion(fechStringdos);
            } else {
                String fechStringdos = fds.format(fechaProx);
                bean.setFchaExpiracion(fechStringdos);
            }
        }

        // Si no tiene activo no dejamos la de la ultima tarjeta, sino la fecha del ultimo titulo de conduccion
        if (isActivo) {
            logger.debug("Certificado Complementario: Pasamos a getFechaProxRecicTitConNoMarca");
            List<GetFechaProxRecicTitConNoMarcaDTO> fecha1 = this.tbasg100PersonaRepository.getFechaProxRecicTitConNoMarca(this.convertirToString(persona.getCdgoPersona()));
            Date fechaProx2 = fecha1.get(0).getFchaCursoInc();
            //Persona activa certificado
            SimpleDateFormat fds2 = new SimpleDateFormat("dd-MM-yyyy");
            String fechStringdos2 = fds.format(fechaProx2);
            bean.setFchaExpiracion(fechStringdos2);

        } else {
            logger.debug("Certificado Complementario: Pasamos a getFechaProxRecicTitConNoMarcaS");
            List<GetFechaProxRecicTitConNoMarcaDTO> fecha1 = this.tbasg100PersonaRepository.getFechaProxRecicTitConNoMarcaS(this.convertirToString(persona.getCdgoPersona()));
            Date fechaProx2 = fecha1.get(0).getFchaCursoInc();
            //Persona inactiva certificado
            SimpleDateFormat fds2 = new SimpleDateFormat("dd-MM-yyyy");
            String fechStringdos2 = fds.format(fechaProx2);
            bean.setFchaExpiracion(fechStringdos2);

        }

        if (!isActivo) {
            bean.setFchaExpiracion("XX-XX-XXXX");
        }

        return bean;

    } // ----- CIERRE ------

    @Override
    public Object getCertificadoComplementarioActionDoExecute(String codPersona) throws Exception {

        CertificadoComplementarioBean bean = new CertificadoComplementarioBean();
        // PERSONA
        List<Tbasg100Persona> personaObject = this.tbasg100PersonaRepository.getPersona(this.convertirToString(codPersona));
        Tbasg100Persona persona = new Tbasg100Persona();
        if(CollectionUtils.isNotEmpty(personaObject)) {
            persona = personaObject.get(0);
        }
        bean.setNifPas(persona.getDesgNifpas());

        boolean numEur = false;
        if (persona.getDesgEin() != null && !"".equals(persona.getDesgEin())) {
            bean.setNumRef(persona.getDesgEin());
            numEur = true;
        } else {
            bean.setNumRef(buildNumRef(persona.getDesgNifpas().trim()));
        }
        bean.setNumEin(numEur);
        bean.setApellidos(buildApellidos(persona));
        bean.setNombre(persona.getDesgNombre());
        bean.setMatricula(persona.getDesgMatricula());
        bean.setLugarNacimiento(persona.getDesgLugarnacimiento());
        bean.setCdgoAreaAct(persona.getCdgoAreact());

        if (persona.getFchaNacimiento() != null)
            bean.setFchaNacimiento(TextFormat.format(persona.getFchaNacimiento(), "/"));
        else
            bean.setFchaNacimiento("");
        bean.setLocalidad(persona.getDesgMunicipio());

        // TIPO VIA
        String descTipoVia = "";
        if (persona.getCdgoTipovia() != null) {
            List<Tbasg107Tipovia> tipoVia = this.tbasg107TipoviaRepository.getTipoVia(this.convertirToString(persona.getCdgoTipovia()));
            if (CollectionUtils.isNotEmpty(tipoVia))
                descTipoVia = tipoVia.get(0).getDesgNombre().trim();
        }
        bean.setDireccionPostal(buildDirPostal(persona, descTipoVia));

        // NACION
        List<Tbasg134Nacion> nacionObject = this.tbasg134NacionRepository.getNacion(this.convertirToString(persona.getCdgoNacion()));
        Tbasg134Nacion nacion = new Tbasg134Nacion();
        if(CollectionUtils.isNotEmpty(nacionObject)) {
            nacion = nacionObject.get(0);
        }

        bean.setNacionalidad(nacion.getDesgNombre());
        // LOCALIDAD - PAIS
        bean.setLocPais(buildLocPais(persona, nacion.getDesgNombre()));

        // TARJETA FECHAS
        List<Tbasg153Tarjeta> tarjeta = this.tbasg153TarjetaRepository.getTarjetaPer(this.convertirToString(persona.getCdgoPersona()));
        if (CollectionUtils.isNotEmpty(tarjeta)) {
            if (tarjeta.get(0).getFchaExpedicion() != null)
                bean.setFchaExpedicion(TextFormat.format(tarjeta.get(0).getFchaExpedicion(), "/"));
            else
                bean.setFchaExpedicion("");
            if (tarjeta.get(0).getFchaExpiracion() != null)
                bean.setFchaExpiracion(TextFormat.format(tarjeta.get(0).getFchaExpiracion(), "/"));
            else
                bean.setFchaExpiracion("");
        } else {
            bean.setFchaExpedicion("");
            bean.setFchaExpiracion("");
        }


        // CONOCIMIENTOS LINGUISTICOS

        Integer cdgoCategoria = MultivalueCts.T155_FC_CATEGORIA_CERTIF_IDIOMA;

        logger.debug("Certificado Complementario: Pasamos a getFormacComplemenPersonaList");
        List<GetFormacionComplementariaPersonaListResultDTO> lFormacComplemen = this.tbasg157FormacComplemenRepository.getFormacComplemenPersonaList(persona.getCdgoPersona(),cdgoCategoria, null);
        HashMap hsFormacion = null;
        List lConocimientos = new ArrayList();
        if (lFormacComplemen != null && !lFormacComplemen.isEmpty()) {
            for (int i=0;i<lFormacComplemen.size();i++) {
                lFormacComplemen.get(i);
                hsFormacion = new HashMap();
                if (lFormacComplemen.get(i).getFechaExpedicion() != null){
                    hsFormacion.put("fchaExpedicion", TextFormat.format(lFormacComplemen.get(i).getFechaExpedicion(),"/"));
                } else {

                    hsFormacion.put("fchaExpedicion", "");
                }
                hsFormacion.put("lengua", lFormacComplemen.get(i).getCualificacion());
                if (lFormacComplemen.get(i).getObservaciones() != null)
                    hsFormacion.put("notas", lFormacComplemen.get(i).getObservaciones());
                else

                    hsFormacion.put("notas", "");

                lConocimientos.add(hsFormacion);
            }
        }
        bean.setListConocimientos(lConocimientos);


        // INFORMACIÓN ADICIONAL - FORMACIÓN COMPLEMENTARIA

        HashMap mapFiltroFormacionComp = new HashMap();
        Integer cdgoCategoria2 = MultivalueCts.T155_FC_CATEGORIA_CERTIF_SEGURIDAD_TREN;
        List<GetFormacionComplementariaPersonaListResultDTO> lFormacComplemenSeguridad = this.tbasg157FormacComplemenRepository.getFormacComplemenPersonaList(persona.getCdgoPersona(),cdgoCategoria2,null);

        HashMap hsInfoAdic = null;
        List lInfoAdic = new ArrayList();
        if (lFormacComplemenSeguridad != null && !lFormacComplemenSeguridad.isEmpty()) {
            for (int i=0;i<lFormacComplemenSeguridad.size();i++) {

                lFormacComplemenSeguridad.get(i);
                hsInfoAdic = new HashMap();
                if (lFormacComplemenSeguridad.get(i).getFechaExpedicion() != null){
                    hsInfoAdic.put("fchaExpedicion", TextFormat.format(lFormacComplemenSeguridad.get(i).getFechaExpedicion(),"/"));
                } else {
                    hsInfoAdic.put("fchaExpedicion", "");
                }

                hsInfoAdic.put("descripcionCualificacion", lFormacComplemenSeguridad.get(i).getDesgCualificacion().substring(0, 1).toUpperCase() + lFormacComplemenSeguridad.get(i).getDesgCualificacion().substring(1).toLowerCase());

                lInfoAdic.add(hsInfoAdic);
            }
        }

        bean.setListInformacionAdic(lInfoAdic);

        List<Tbasg102Titulocon> tituloCon = this.tbasg102TituloconRepository.getTituloConPersona(this.convertirToString(persona.getCdgoPersona()));

        bean.setrestrinRam("RAM");

        if (CollectionUtils.isNotEmpty(tituloCon) && "RFIG".equals(tituloCon.get(0).getDesgSoloram())) {
            bean.setrestrinRam("RFIG");
        } else if (CollectionUtils.isNotEmpty(tituloCon) && "RAM+RFIG".equals(tituloCon.get(0).getDesgSoloram())) {
            bean.setrestrinRam("RAM+RFIG");
        }

        // Obtenemos las Habilitaciones

        List<Integer> lCdgoExpedientes = new ArrayList<Integer>();
        Map<Integer,Tbasg104Expedient> mapaExpedientes;

        List lMaterial = new ArrayList();
        List lLineas = new ArrayList();
        List lTramos = new ArrayList();

        logger.debug("Certificado Complementario: Pasamos a getExpedientesPersonaListCod");
        boolean isActivo = true;
        List<GetExpedientesPersonaLtDTO> lExpedientes;
        if(!isActivo){
            lExpedientes = this.tbasg104ExpedientRepository.getExpedientesPersonaListCodUserBaja(this.convertirToString(persona.getCdgoPersona()));
        } else {
            lExpedientes = this.tbasg104ExpedientRepository.getExpedientesPersonaListCod(this.convertirToString(persona.getCdgoPersona()),null);
        }

        if ( null != lExpedientes && !lExpedientes.isEmpty()){
            logger.debug("lista de expedientes" );

            for( int i = 0  ; i < lExpedientes.size() ; i++ ){

                lCdgoExpedientes.add(lExpedientes.get(i).getCdgoExpedient());
            }

            List<Tbasg104Expedient> getExpedientsByCdgoExpsAction = this.tbasg104ExpedientRepository.getExpedientesByCdgoExp(lCdgoExpedientes);

            List<Tbasg118Estadoexp> getFechasOtorgamientoAction = this.tbasg118EstadoexpRepository.getFechasOtorgamiento(lCdgoExpedientes);

            logger.debug("GetFechasOtorgamientoAction" );

            Tbasg104Expedient objExpediente = null;
            Tbasg118Estadoexp mapaFechasOtorgamientosExp = null;

            logger.debug("Certificado Complementario: Pasamos a for expedientes");

            for(int i=0;i<lExpedientes.size();i++)
            {
                logger.debug("Entra correctamente en el bucle que recorre lExpedientes" );

                List<GetMaxEntornosExpCodListDTO> lAlcanceAux = new ArrayList<>();
                Integer cdgoExp = lExpedientes.get(i).getCdgoExpedient();

                for(int j=0;j<getExpedientsByCdgoExpsAction.size();j++){
                    if(Integer.valueOf(getExpedientsByCdgoExpsAction.get(j).getCdgoExpedient().toString()).equals(lExpedientes.get(i).getCdgoExpedient())) {
                        objExpediente = getExpedientsByCdgoExpsAction.get(j);
                        mapaFechasOtorgamientosExp = getFechasOtorgamientoAction.get(j);
                    }
                }

                if (objExpediente.getCdgoSerie()!=null && "730".equals(objExpediente.getCdgoSerie())) {
                    logger.debug("Se comprueba que el ultimo vehiculo con codigo" + objExpediente.getCdgoSerie() + " esta llegando correctamente");
                }

                if (lExpedientes.get(i).getCdgoTipoHab() != null){
                    Integer tipoHabil = lExpedientes.get(i).getCdgoTipoHab();
                    logger.debug("Tipo habilitacion" + tipoHabil );
                    if(tipoHabil.equals(MultivalueCts.T123_TIPOHABIL_CONDUCCION_INFRAESTRUCTURA))
                    {
                        if ( objExpediente.getDesgTipoinfraestruc() != null && "L".equals(objExpediente.getDesgTipoinfraestruc())){
                            logger.debug("Entra correctamente segun el tipo de infraestructura" );
                            lLineas.add(getAlcanceLinea(objExpediente.getCdgoLinea(),mapaFechasOtorgamientosExp));

                        }
                        else{
                            // Obtener habilitación por estado
                            if (null != cdgoExp && !"".equals(cdgoExp) )

                                logger.debug("Obtiene habilitacion por estado" );

                            lAlcanceAux = getAlcanceInfraestructuras(cdgoExp);

                            // Se obtiene la fecha de otorgamiento para cada línea de las habilitaciones
                            if (lAlcanceAux != null){
                                logger.debug("Alcance auxiliar distinto de null" );

                                GetMaxEntornosExpCodListDTO hmLinea 	= new GetMaxEntornosExpCodListDTO();

                                for (int l=0; l<lAlcanceAux.size(); l++){

                                    hmLinea =  lAlcanceAux.get(l);

                                    if (hmLinea != null){

                                        hmLinea = getFechaOtorgamiento(hmLinea, cdgoExp, mapaFechasOtorgamientosExp);

                                        lAlcanceAux.set(l,hmLinea);

                                        logger.debug("Obteniendo fecha otorgamiento" );
                                    }
                                }
                            }

                            // Obtenemos el punto kilometrico de los tramos

                            if (lAlcanceAux != null) {

                                GetMaxEntornosExpCodListDTO hmLinea 	= new GetMaxEntornosExpCodListDTO();

                                for (int l=0; l<lAlcanceAux.size(); l++){

                                    hmLinea =  lAlcanceAux.get(l);

                                    if (hmLinea != null){
                                        hmLinea = getPuntoKilometricoTramo(hmLinea);

                                        lAlcanceAux.set(l,hmLinea);
                                        lTramos.add(hmLinea);

                                    }
                                }
                            }


                        }
                    }
                    else if(tipoHabil.equals(MultivalueCts.T123_TIPOHABIL_CONDUCCION_MATERIAL))
                    {
                        logger.debug("Entra en el condicional segun el tipo de habilitacion" );
                        lMaterial.add(getAlcanceMaterial(objExpediente, mapaFechasOtorgamientosExp));
                        logger.debug("Añadiendo a lista conduccion material" );
                    }
                }
            }

            logger.debug("Certificado Complementario: Pasamos a ordenar los maps");
            HashMap [] arrayMaterial = (HashMap[])lMaterial.toArray(new HashMap[lMaterial.size()]);
            Arrays.sort(arrayMaterial, new OrdenarMaterialComparator());
            bean.setListMaterial(new ArrayList(Arrays.asList(arrayMaterial)));
            logger.debug("ArrayMaterial" );

            HashMap [] arrayLineas = (HashMap[])lLineas.toArray(new HashMap[lLineas.size()]);
            Arrays.sort(arrayLineas, new OrdenarLineasComparator());
            bean.setListLineas(new ArrayList(Arrays.asList(arrayLineas)));
            logger.debug("ArrayLineas" );

            // Obtengo de una tacada la lista de tramos
            List<GetTramosOrderByCodLineaDTO> listaTramos = new ArrayList<>();

            if(isActivo){
                logger.debug("Persona activa tramos" );
                listaTramos = getTramos(lCdgoExpedientes);
            }
            else{
                logger.debug("Persona inactiva tramos" );
                listaTramos = getTramosPB(lCdgoExpedientes);
            }

            GetTramosOrderByCodLineaDTO[] arrayTramos;

            logger.debug("MARCA ELIMINA DUPLICADOS");
            arrayTramos = listaTramos.toArray( new GetTramosOrderByCodLineaDTO[listaTramos.size()]);

            GetTramosOrderByCodLineaDTO[] arrayTramosSinDupli = eliminaDuplicados(arrayTramos,lCdgoExpedientes);
            bean.setListTramos(new ArrayList(Arrays.asList(arrayTramosSinDupli)));

        }

        List<Tbasg101Certpsic> certComplem = this.tbasg101CertpsicRepository.getActiveCertPsicWithMaxFchaProxRev(this.convertirToString(persona.getCdgoPersona()));

        if (null != certComplem && "S".equals(certComplem.get(0).getMrcaCorrvisual()))
        {
            bean.setCorrVisual("S");
        }
        else {
            bean.setCorrVisual("N");
        }

        if (null != certComplem && "S".equals(certComplem.get(0).getMrcaProtaud())){
            bean.setProtAudi("S");
        }
        else{
            bean.setProtAudi("N");
        }

        logger.debug("Certificado Complementario: Pasamos a getFechaExpFiltrada");
        List<GetFechaExpFiltradaDTO> fech = this.tbasg118EstadoexpRepository.getFechaExpFiltrada(this.convertirToString(persona.getCdgoPersona()));
        Date fechaExpAn = fech.get(0).getFchaEstado();

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String fechaaux1= "02-01-2007";
        Date FechaAux = new Date(sdf.parse(fechaaux1).getTime()) ;
        if (null != fechaExpAn){
            if (fechaExpAn.before(FechaAux)){
                String fechString = sdf.format(FechaAux);
                bean.setFechaexpedient(fechString);
            }
            else{
                String fechString = sdf.format(fechaExpAn);
                bean.setFechaexpedient(fechString);
            }
        }

        logger.debug("Certificado Complementario: Pasamos a getFechaProxReciTitCon");
        List<GetFechaProxRecicTitConDTO> fecha = this.tbasg100PersonaRepository.getFechaProxRecicTitCon(this.convertirToString(persona.getCdgoPersona()));
        Date fechaProx = fecha.get(0).getFchaCursoInc();

        SimpleDateFormat fds = new SimpleDateFormat("dd-MM-yyyy");
        String fechaaux2= "02-01-2007";
        Date fechaproxaux = new Date(fds.parse(fechaaux2).getTime()) ;
        if (null != fechaProx){
            if ((fechaProx).before(fechaproxaux)){
                String fechStringdos = fds.format(fechaproxaux);
                bean.setFchaExpiracion(fechStringdos);
            }
            else{
                String fechStringdos = fds.format(fechaProx);
                bean.setFchaExpiracion(fechStringdos);
            }
        }

        // Si no tiene activo no dejamos la de la ultima tarjeta, sino la fecha del ultimo titulo de conduccion
        if(isActivo) {
            logger.debug("Certificado Complementario: Pasamos a getFechaProxRecicTitConNoMarca");
            List<GetFechaProxRecicTitConNoMarcaDTO> fecha1 = this.tbasg100PersonaRepository.getFechaProxRecicTitConNoMarca(this.convertirToString(persona.getCdgoPersona()));
            Date fechaProx2 = fecha1.get(0).getFchaCursoInc();
            //Persona activa certificado
            SimpleDateFormat fds2 = new SimpleDateFormat("dd-MM-yyyy");
            String fechStringdos2 = fds.format(fechaProx2);
            bean.setFchaExpiracion(fechStringdos2);

        }
        else {
            logger.debug("Certificado Complementario: Pasamos a getFechaProxRecicTitConNoMarcaS");
            List<GetFechaProxRecicTitConNoMarcaDTO> fecha1 = this.tbasg100PersonaRepository.getFechaProxRecicTitConNoMarcaS(this.convertirToString(persona.getCdgoPersona()));
            Date fechaProx2 = fecha1.get(0).getFchaCursoInc();
            //Persona inactiva certificado
            SimpleDateFormat fds2 = new SimpleDateFormat("dd-MM-yyyy");
            String fechStringdos2 = fds.format(fechaProx2);
            bean.setFchaExpiracion(fechStringdos2);

        }

        if(!isActivo){
            bean.setFchaExpiracion("XX-XX-XXXX");
        }

        return bean;

    } // ----- CIERRE ------

    private String buildNumRef(String nifPas) {
        String numRef = "";
        if (nifPas != null && !nifPas.equals(" ")) {
            numRef = nifPas + "-B";
        }
        return numRef;
    }

    private String buildApellidos(Tbasg100Persona persona) {
        StringBuffer sb = new StringBuffer();
        sb.append(persona.getDesgApell1().trim()).append(" ").append(persona.getDesgApell2().trim());

        return sb.toString();
    }

    private String buildDirPostal(Tbasg100Persona persona, String descTipoVia) {
        StringBuffer sb = new StringBuffer();
        sb.append(descTipoVia);
        if (StringUtils.isNotBlank(persona.getDesgVia())) {
            sb.append(" ").append(persona.getDesgVia().trim());
        }
        if (StringUtils.isNotBlank(persona.getDesgNumvia())) {
            sb.append(" ").append(persona.getDesgNumvia().trim());
        }
        if (StringUtils.isNotBlank(persona.getDesgPlanta())) {
            sb.append(" ").append(persona.getDesgPlanta().trim());
        }
        if (StringUtils.isNotBlank(persona.getDesgPuerta())) {
            sb.append(" ").append(persona.getDesgPuerta().trim());
        }
        if (StringUtils.isNotBlank(persona.getDesgEscalera())) {
            sb.append(" ").append(persona.getDesgEscalera().trim());
        }
        if (StringUtils.isNotBlank(persona.getDesgCodpostal())) {
            sb.append(" CP ").append(persona.getDesgCodpostal().trim());
        }
        return sb.toString();
    }

    private String buildLocPais(Tbasg100Persona persona, String nacion) {
        StringBuffer sb = new StringBuffer();
        sb.append(persona.getDesgMunicipio().trim()).append(" - ").append(nacion);
        return sb.toString();
    }

    private Map getAlcanceLinea(String cdgoLinea, Tbasg118Estadoexp otorgamiento) throws SQLException, InternalErrorException
    {
        HashMap hmAlcance = new HashMap();

        String descLinea = "";
        if ( null != cdgoLinea){
            //Tbasg127Lineas lineas = DatosFijosBD.getInstance().getMap127Linea().get( cdgoLinea );
            Optional<Tbasg127Lineas> lineas = this.tbasg127LineasRepository.findByCdgoLinea(cdgoLinea);
            cdgoLinea = this.convertirToString(lineas.get().getCdgoLinea());
            descLinea = lineas.get().getDesgNombre();
        }
        hmAlcance.put("cdgoLinea", cdgoLinea);
        hmAlcance.put("descripcion", descLinea);

        Date dFechaOtorgamiento = otorgamiento.getFchaAct();
        if (dFechaOtorgamiento != null){
            hmAlcance.put("fchaEstado", TextFormat.format(dFechaOtorgamiento,"/"));
        } else {
            hmAlcance.put("fchaEstado", "");
        }

        return hmAlcance;
    }

    private List<GetMaxEntornosExpCodListDTO> getAlcanceInfraestructuras(Integer cdgoExpediente) throws SQLException, InternalErrorException {

        List<GetMaxEntornosExpCodListDTO> listEntornos = new ArrayList();
        try {
            listEntornos = this.tbasg118EstadoexpRepository.getMaxEntornosExpCodList(cdgoExpediente, null);
        }
        catch (Exception e) {
            logger.error("ERROR Getting list of GetMaxEntornosExpCodListAction", e);
        }
        return listEntornos;
    }

    private List getTramos(List<Integer> listCdgos) throws SQLException, InternalErrorException {

        List<GetTramosOrderByCodLineaDTO> listTramos = new ArrayList();

        try {
            listTramos = this.tbasg118EstadoexpRepository.getTramosOrderByCodLinea(listCdgos);
        }
        catch (Exception e) {
            logger.error("ERROR Getting list of GetMaxEntornosExpCodListAction", e);
        }
        return listTramos;
    }

    private List getTramosPB(List<Integer> listCdgos) throws SQLException, InternalErrorException {

        List<GetTramosOrderByCodLineaDTO> listTramos = new ArrayList();
        try {
            listTramos = this.tbasg118EstadoexpRepository.getFechasOtorgamientoPB(listCdgos);
        }
        catch (Exception e) {
            logger.error("ERROR Getting list of GetMaxEntornosExpCodListAction", e);
        }
        return listTramos;
    }

    private class OrdenarMaterialComparator implements Comparator {
        public int compare(Object o1, Object o2) {
            HashMap map1 = (HashMap) o1;
            HashMap map2 = (HashMap) o2;
            String cod1 = "";
            String cod2 = "";
            if (map1.containsKey("cdgoSerie") && map2.containsKey("cdgoSerie")) {
                cod1 = (String)map1.get("cdgoSerie");
                cod2 = (String)map2.get("cdgoSerie");
                int resultado = cod1.compareTo(cod2);
                if (resultado == 0) {
                    if (map1.containsKey("cdgoSubSerie") && map2.containsKey("cdgoSubSerie")) {
                        cod1 = (String)map1.get("cdgoSubSerie");
                        cod2 = (String)map2.get("cdgoSubSerie");
                        return cod1.compareTo(cod2);
                    } else {
                        if (map1.containsKey("cdgoSubSerie")) {
                            return +1;
                        } else if (map2.containsKey("cdgoSubSerie")) {
                            return -1;
                        } else {
                            return 0;
                        }
                    }
                } else {
                    return resultado;
                }
            }
            return 0;
        }
    }

    private Map getAlcanceMaterial(Tbasg104Expedient expedient, Tbasg118Estadoexp otorgamiento) throws SQLException, InternalErrorException {

        HashMap hmAlcance = new HashMap();

        if(expedient.getCdgoSerie() != null && expedient.getCdgoSubSerie() == null)
        {
            Optional<Tbasg133Serie> serie = this.tbasg133SerieRepository.findByCdgoSerie(expedient.getCdgoSerie().trim());

            if(serie.isPresent()) {

                hmAlcance.put("serie", serie.get().getDesgNombre().trim());
                hmAlcance.put("cdgoSerie", serie.get().getCdgoSerie().trim());

            }

        }

        else if(expedient.getCdgoSerie() != null && expedient.getCdgoSubSerie() != null)
        {

            Optional<Tbasg133Serie> serie = this.tbasg133SerieRepository.findByCdgoSerie(expedient.getCdgoSerie().trim());

            if(serie.isPresent()) {

                hmAlcance.put("serie", serie.get().getDesgNombre().trim());
                hmAlcance.put("cdgoSerie", serie.get().getCdgoSerie().trim());
                hmAlcance.put("subSerie", expedient.getCdgoSubSerie().trim());
                hmAlcance.put("cdgoSubSerie", expedient.getCdgoSubSerie().trim());

            }

        }
        else {
            logger.error("ERROR HABILITACIÓN DE MATERIAL");
        }

        Date dFechaOtorgamiento = otorgamiento.getFchaAct();

        if (dFechaOtorgamiento != null){
            hmAlcance.put("fchaEstado", TextFormat.format(dFechaOtorgamiento,"/"));
        } else {
            hmAlcance.put("fchaEstado", "");
        }

        return hmAlcance;
    }

    private class OrdenarLineasComparator implements Comparator {
        public int compare(Object o1, Object o2) {
            HashMap map1 = (HashMap) o1;
            HashMap map2 = (HashMap) o2;
            String cod1 = "";
            String cod2 = "";
            if (map1.containsKey("cdgoLinea") && map2.containsKey("cdgoLinea")) {
                cod1 = (String)map1.get("cdgoLinea");
                cod2 = (String)map2.get("cdgoLinea");
                return cod1.compareTo(cod2);
            } else {
                if (map1.containsKey("cdgoLinea")) {
                    return +1;
                } else if (map2.containsKey("cdgoLinea")) {
                    return -1;
                } else {
                    return 0;
                }
            }
        }
    }

    private GetTramosOrderByCodLineaDTO[] eliminaDuplicados(GetTramosOrderByCodLineaDTO[] arrayTramos,List codExp) throws SQLException
    {

        GetTramosOrderByCodLineaDTO[] sinDup;
        List<GetTramosOrderByCodLineaDTO> lTramosNoDuplicados = new ArrayList<>();
        String codLinea = "";
        String codEstaOrigen =  "";
        String codEstaDestino =  "";
        List lTramosTratados = new ArrayList();
        boolean tratado = false;

        for (GetTramosOrderByCodLineaDTO entry : arrayTramos)
        {
            Tbasg145AlchaestaPK alchaestapktramo = new Tbasg145AlchaestaPK();
            Tbasg145AlchaestaPK alchaestapktramoinv = new Tbasg145AlchaestaPK();

            Tbasg145Alchaesta tramo = new Tbasg145Alchaesta();
            Tbasg145Alchaesta tramoinverso = new Tbasg145Alchaesta();

            codLinea = entry.getCdgoLinea();
            codEstaOrigen = entry.getCdgoPkOrigen();
            codEstaDestino = entry.getCdgoEstacionDestino();

            alchaestapktramo.setCdgoLinea(codLinea);
            alchaestapktramo.setCdgoDestino(codEstaDestino);

            tramo.setTbasg145alchaestapk(alchaestapktramo);

            alchaestapktramoinv.setCdgoLinea(codLinea);
            alchaestapktramoinv.setCdgoOrigen(codEstaOrigen);
            alchaestapktramoinv.setCdgoDestino(codEstaDestino);

            tramoinverso.setTbasg145alchaestapk(alchaestapktramoinv);

            ParamCountGetTramos tramosParametros = new ParamCountGetTramos();
            tramosParametros.setListaExpedientes(codExp);
            tramosParametros.setCodLinea(codLinea);
            tramosParametros.setCodEstacOrigen(codEstaDestino);
            tramosParametros.setCodEstacDestino(codEstaDestino);

            List<CountGetTramosDTO> cuentaDuplicados = this.tbasg118EstadoexpRepository.countGetTramos(tramosParametros);

            if (cuentaDuplicados.get(0).getNumeroFilas() > 1)
            {
                tratado = yaTratado(tramo,lTramosTratados);
                if (tratado == true)
                {
                    continue;
                }
            }

            lTramosNoDuplicados.add(entry);

            lTramosTratados.add(tramo);
            lTramosTratados.add(tramoinverso);

        }

        sinDup = lTramosNoDuplicados.toArray(new GetTramosOrderByCodLineaDTO[lTramosNoDuplicados.size()]);

        return sinDup;

    }

    private boolean yaTratado(Tbasg145Alchaesta tramo,List lTramosTratados)
    {
        Tbasg145Alchaesta tra = new Tbasg145Alchaesta() ;
        Tbasg145AlchaestaPK alchaestapk = new Tbasg145AlchaestaPK();

        for (int i=0; i<lTramosTratados.size(); i++)
        {
            tra = (Tbasg145Alchaesta) lTramosTratados.get(i);
            if ( (tra.getTbasg145alchaestapk().getCdgoLinea().equals(tramo.getTbasg145alchaestapk().getCdgoLinea()))
                    &&  (tra.getTbasg145alchaestapk().getCdgoOrigen().equals(tramo.getTbasg145alchaestapk().getCdgoOrigen()))
                    &&  (tra.getTbasg145alchaestapk().getCdgoDestino().equals(tramo.getTbasg145alchaestapk().getCdgoDestino())) )
            {
                tra = null;
                return true;
            }
            tra = null;
        }

        return false;
    }

    private class OrdenarTramosComparator implements Comparator {
        public int compare(Object o1, Object o2) {
            HashMap map1 = (HashMap) o1;
            HashMap map2 = (HashMap) o2;
            String cod1 = "";
            String cod2 = "";
            if (map1.containsKey("cdgoLinea") && map2.containsKey("cdgoLinea")) {
                cod1 = (String)map1.get("cdgoLinea");
                cod2 = (String)map2.get("cdgoLinea");
                int resultado = cod1.compareTo(cod2);
                if (resultado == 0) {
                    if (map1.containsKey("cdgoPK") && map2.containsKey("cdgoPK")) {
                        Float codPk1 = (Float)map1.get("cdgoPK");
                        Float codPk2 = (Float)map2.get("cdgoPK");
                        return codPk1.compareTo(codPk2);
                    } else {
                        if (map1.containsKey("cdgoPK")) {
                            return +1;
                        } else if (map2.containsKey("cdgoPK")) {
                            return -1;
                        } else {
                            return 0;
                        }
                    }
                } else {
                    return resultado;
                }
            }
            return 0;
        }
    }

    private GetMaxEntornosExpCodListDTO getPuntoKilometricoTramo(GetMaxEntornosExpCodListDTO hmLinea)
            throws SQLException, InternalErrorException
    {

        String cdline = hmLinea.getCdgoLinea();
        String cdOrigen = hmLinea.getCodEstOrigen();

        Tbasg128EstaclinePK estaclinePK = new Tbasg128EstaclinePK();
        estaclinePK.setCdgoLinea(cdline);
        estaclinePK.setCdgoEstacion(cdOrigen);

        if(cdline.contains("G")){
            cdline = cdline.trim();
        }

        Optional<Tbasg128Estacline> objEstacLine = this.tbasg128EstaclineRepository.findById(estaclinePK);

        if (objEstacLine != null){
            String cdgoPK = objEstacLine.get().getCdgoPk();
            hmLinea.setPkOrigen(cdgoPK);
            hmLinea.setPkDestino(cdgoPK);
        }
        return hmLinea;
    }

    private GetMaxEntornosExpCodListDTO getFechaOtorgamiento(GetMaxEntornosExpCodListDTO hmLinea, Integer sCdgoExpediente, Tbasg118Estadoexp otorgamiento)
            throws SQLException, InternalErrorException, ParseException
    {

        Date dFechaOtorgamiento = otorgamiento.getFchaAct();
        String dFecha = TextFormat.format(dFechaOtorgamiento,"/");

        SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy");

        Date date1= new Date(formatter1.parse(dFecha).getTime());

        if (dFechaOtorgamiento != null){
            hmLinea.setFchaestado(date1);
        } else {
            hmLinea.setFchaestado(null);
        }

        return hmLinea;
    }



    public <T> String convertirToString(T value) {

        return value != null ? value.toString() : null;

    }

    @Override
    public Object getCertificadoComplementarioAOTActionDoExecute(Integer codPersona) throws Exception {

        CertificadoComplementarioAOTBean bean = new CertificadoComplementarioAOTBean();

        // PERSONA
        //Persona persona = (Persona) sqlMap.queryForObject("Persona.getPersona", this.codPersona.toString());

        List<Tbasg100Persona> personaObject = this.tbasg100PersonaRepository.getPersona(this.convertirToString(codPersona));
        Tbasg100Persona persona = new Tbasg100Persona();
        if (CollectionUtils.isNotEmpty(personaObject)) {
            persona = personaObject.get(0);
        }

        bean.setNifPas(persona.getDesgNifpas());
        bean.setMatricula(persona.getDesgMatricula());
        bean.setApellidos(buildApellidos(persona));
        bean.setNombre(persona.getDesgNombre());
        bean.setCdgoAreaAct(persona.getCdgoAreact());

        if (persona.getFchaNacimiento() != null)
            bean.setFchaNacimiento(TextFormat.format(persona.getFchaNacimiento(), "/"));
        else
            bean.setFchaNacimiento("");

        Integer cdgoPersona = persona.getCdgoPersona();


        //EMPRESA

        //Recuperamos el expediente con estado otorgado

        List<GetFindFchaExpedienteOtorgadoParaAotDTO> expediente = this.tbasg104ExpedientRepository.findFchaExpedienteOtorgadoParaAOT(cdgoPersona, 3, 2);

        if (expediente.isEmpty()) {
            expediente = this.tbasg104ExpedientRepository.findFchaExpedienteParaAOT(cdgoPersona, 3, 2);
        }

        List<GetfindFchaHabilitacionParaAotDTO> fchasCursos = this.tbasg104ExpedientRepository.findFchaHabilitacionParaAOT(expediente.get(0).getCdgoExpedient());

        Integer cdgoEmpresa = expediente.get(0).getCdgoEmpresa();

        List<Tbasg125Empresa> empresa = this.tbasg125EmpresaRepository.getEmpresa(cdgoEmpresa);
        String nombreEmpresa = empresa.get(0).getDesgNombre();
        bean.setEmpresa(nombreEmpresa);

        //FECHA FIN PSICO-FISICO

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        List<Tbasg101Certpsic> listaCertPsicoFisic = this.tbasg101CertpsicRepository.getCertPsicWithFchaProxRevActiveList(this.convertirToString(persona.getCdgoPersona()));

        //Cogemos la primera fecha que viene, que concidirá con la fecha más lejana

        Date fechaPsicoFisic = listaCertPsicoFisic.get(0).getFchaProxrev();

        String fechaPsicoFis = df.format(fechaPsicoFisic);
        bean.setFchaFinPsicoFisico(fechaPsicoFis);

        //OBSERVACIONES

        List<Tbasg104Expedient> listObservacionesExt = this.tbasg104ExpedientRepository.getObservaExt(this.convertirToString(persona.getCdgoPersona()));

        List listObsAux = new ArrayList();
        HashMap observacExtAux = null;
        Tbasg104Expedient expedient = null;

        for (int i = 0; i < listObservacionesExt.size(); i++) {
            expedient = listObservacionesExt.get(i);
            observacExtAux = new HashMap();
            observacExtAux.put("observacionExt", expedient.getDesgObservaExt());
            listObsAux.add(observacExtAux);
        }

        bean.setListObservaciones(listObsAux);

        //FECHA EXPEDICIÓN HABILITACIÓN

        String fchaExpedicionHabil = "";
        if (expediente.get(0).getFchaExpediente() == null) {
            logger.debug("No hay datos");
        } else {
            Date fecha = expediente.get(0).getFchaExpediente();
            fchaExpedicionHabil = df.format(fecha);
        }

        if (fchasCursos.get(0).getFchaCurso() == null) {
            logger.debug("No hay datos");
        } else {
            Date fecha = fchasCursos.get(0).getFchaCurso();
            fchaExpedicionHabil = df.format(fecha);
        }

        bean.setFchaExpedicion(fchaExpedicionHabil);


        //FECHA EXPIRACIÓN HABILITACIÓN (FECHA FIN PSICOFÍSICO AOT ambito 1,2,3,4,5,8,9,10)

        String fchaExpiracionHabil = "";

        //List<Tbasg101Certpsic> listaFechas = this.tbasg101CertpsicRepository.getFchaProxRevAOTByCdgoPersona(this.convertirToString(persona.getCdgoPersona()));

        //Cogemos la primera fecha

        Calendar c = Calendar.getInstance();

        Date fechaDate = new Date(df.parse(fchaExpedicionHabil).getTime());
        c.setTime(fechaDate);
        c.add(Calendar.YEAR, +3);
        Date fechaProxRev = new Date(c.getTimeInMillis());
        fchaExpiracionHabil = df.format(fechaProxRev);

        bean.setFchaExpiracion(fchaExpiracionHabil);


        // CONOCIMIENTOS LINGUISTICOS E INFORMACIÓN ADICIONAL

        Integer cdgoCategoria = MultivalueCts.T155_FC_CATEGORIA_CERTIF_IDIOMA_AOT;

        //lFormacComplemen = sqlMap.queryForList("FormacComplemen.getFormacComplemenPersonaList", mapFiltroConocimientos);
        List<GetFormacionComplementariaPersonaListResultDTO> lFormacComplemen = this.tbasg157FormacComplemenRepository.getFormacComplemenPersonaList(codPersona, cdgoCategoria, null);
        //FormacComplemenView oFormacion = null;
        HashMap hsFormacion = null;
        List lConocimientos = new ArrayList();

        if (lFormacComplemen != null && !lFormacComplemen.isEmpty()) {
            for (int i = 0; i < lFormacComplemen.size(); i++) {
                GetFormacionComplementariaPersonaListResultDTO oFormacion = lFormacComplemen.get(i);
                hsFormacion = new HashMap();
                hsFormacion.put("lengua", oFormacion.getCualificacion());
                String descripcion = oFormacion.getDesgCualificacion();
                String nivel = descripcion.substring(descripcion.indexOf("NIVEAU"), descripcion.length());
                hsFormacion.put("nivel", nivel);
                lConocimientos.add(hsFormacion);
            }
        }

        bean.setListInformacionAdic(lConocimientos);

        return bean;

    }

    @Override
    public Object GetHabilitacionEstadoActionDoExecute(String codPersona, Integer codEstado) throws Exception {

        HabilitacionEstadoBean bean = new HabilitacionEstadoBean();

        // DESTINATARIO
        bean.setDestinatario(ConfigurationMgr.PDF_SOLICITUD_HAB_DESTINATARIO);

        // PERSONA
        List<Tbasg100Persona> personaObject = this.tbasg100PersonaRepository.getPersona(this.convertirToString(codPersona));
        Tbasg100Persona persona = new Tbasg100Persona();
        if(CollectionUtils.isNotEmpty(personaObject)) {
            persona = personaObject.get(0);
        }

        bean.setNifPas(persona.getDesgNifpas());
        bean.setAreaActividad(persona.getDescAreaAct());
        bean.setNomTrabajador(buildName(persona));
        bean.setcdgoAreaAct(persona.getCdgoAreact());

        List<Tbasg102Titulocon> tituloCon = this.tbasg102TituloconRepository.getTituloConPersona(this.convertirToString(persona.getCdgoPersona()));

        bean.setrestrinRam("N");

        if (CollectionUtils.isNotEmpty(tituloCon) && "S".equals(tituloCon.get(0).getDesgSoloram())) {
            bean.setrestrinRam("S");
        }

        // NACION
        List<Tbasg134Nacion> nacionObject = this.tbasg134NacionRepository.getNacion(this.convertirToString(persona.getCdgoNacion()));
        Tbasg134Nacion nacion = new Tbasg134Nacion();
        if(CollectionUtils.isNotEmpty(nacionObject)) {
            nacion = nacionObject.get(0);
        }

        bean.setNacionalidad(nacion.getDesgNombre());


        List lFechaValidez = new ArrayList();

        List<Tbasg101Certpsic> lCertificados = this.tbasg101CertpsicRepository.getCertPsicWithFchaProxRevActiveList(this.convertirToString(persona.getCdgoPersona()));

        if ( null != lCertificados && !lCertificados.isEmpty()){
            for(int i=0;i<lCertificados.size();i++)
            {
                Tbasg101Certpsic cert = lCertificados.get(i);

                HashMap mapCertificado = new HashMap();

                List<GetRelHabPsicByCdgoCertPsicDTO> lTiposHab = this.tbasg101CertpsicRepository.getRelHabPsicByCdgoCertPsic(cert.getCdgoCertpsic());

                if (lTiposHab != null && !lTiposHab.isEmpty()) {
                    String sTipoHab = "";
                    for(int j=0;j<lTiposHab.size();j++) {
                        GetRelHabPsicByCdgoCertPsicDTO mapTipos = lTiposHab.get(j);
                        if (j > 0)
                            sTipoHab += ", ";
                        sTipoHab += mapTipos.getDesgNombre().trim();
                    }
                    mapCertificado.put("tipoHab", sTipoHab);
                } else {
                    mapCertificado.put("tipoHab", "");
                }


                if (cert.getFchaProxrev() != null) {
                    mapCertificado.put("fchaValidez", TextFormat.format(cert.getFchaProxrev(),"/"));
                } else {
                    mapCertificado.put("fchaValidez", "");
                }
                lFechaValidez.add(mapCertificado);
            }
            bean.setListFechaValidez(lFechaValidez);
        }


        // Obtenemos las Habilitaciones
        // Obtener habilitación por estado
        HashMap mapFiltroHabEstado = new HashMap();
        if (null != codEstado)
            mapFiltroHabEstado.put("codEstado" , codEstado);

        List<GetExpedientesPersonaLtDTO> lExpedientes;
        List listCodSociedadesPrevia = new ArrayList();
        List listCodSociedades = new ArrayList();
        List<Integer> lCdgoExpedientes = new ArrayList<Integer>();
        List lAlcance = new ArrayList();

        lExpedientes = this.tbasg104ExpedientRepository.getExpedientesPersonaListCod(this.convertirToString(persona.getCdgoPersona()), codEstado);

        if ( null != lExpedientes && !lExpedientes.isEmpty()){

            for( int i = 0  ; i < lExpedientes.size() ; i++ ){
                lCdgoExpedientes.add(lExpedientes.get(i).getCdgoExpedient());
            }

            List<Tbasg104Expedient> getExpedientsByCdgoExpsAction = this.tbasg104ExpedientRepository.getExpedientesByCdgoExp(lCdgoExpedientes);

            List<Tbasg118Estadoexp> getFechasOtorgamientoAction = this.tbasg118EstadoexpRepository.getFechasOtorgamiento(lCdgoExpedientes);

            Tbasg104Expedient objExpediente = null;
            Tbasg118Estadoexp mapaFechasOtorgamientosExp = null;

            int tipoAlcance = 0;
            HashSet hsTipoHabil = new HashSet();
            for(int i=0;i<lExpedientes.size();i++)
            {
                GetExpedientesPersonaLtDTO mapBean = lExpedientes.get(i);
                Map mapAlcance = new HashMap();
                List lAlcanceAux = new ArrayList();

                Integer cdgoExp = lExpedientes.get(i).getCdgoExpedient();

                for(int j=0;j<getExpedientsByCdgoExpsAction.size();j++){
                    if(Integer.valueOf(getExpedientsByCdgoExpsAction.get(j).getCdgoExpedient().toString()).equals(lExpedientes.get(i).getCdgoExpedient())) {
                        objExpediente = getExpedientsByCdgoExpsAction.get(j);
                        mapaFechasOtorgamientosExp = getFechasOtorgamientoAction.get(j);
                    }
                }

                String dsgSociedad = mapBean.getDescSociedad();

                listCodSociedadesPrevia.add(objExpediente.getCdgoSociotor());

                List<GetFechaFinValidezDTO> fechaFinValidezFinal = null;

                if (mapBean.getCdgoTipoHab() != null){
                    Integer tipoHabil = lExpedientes.get(i).getCdgoTipoHab();

                    if(tipoHabil.equals(MultivalueCts.T123_TIPOHABIL_CONDUCCION_INFRAESTRUCTURA))
                    {
                    	
                    	fechaFinValidezFinal = this.tbasg104ExpedientRepository.getFechaFinValidez2(mapBean.getCdgoExpedient());
                        if ( null != objExpediente.getDesgTipoinfraestruc() && "L".equals(objExpediente.getDesgTipoinfraestruc())){
                            lAlcanceAux.add(getAlcanceLinea(objExpediente.getCdgoLinea(), mapaFechasOtorgamientosExp /*objExpediente.getCdgoSociedad()*/));

                            tipoAlcance = HabilitacionEstadoBean.TIPO_ALC_INFRAESTRUCTURA_LINEA;
                        }
                        else{
                            //Obtener habilitación por estado
                            if (null != cdgoExp && !"".equals(cdgoExp) )

                                lAlcanceAux = getAlcanceInfraestructuras1(cdgoExp);

                            //  Fecha otorgamiento por línea
                            // Se obtiene la fecha de otorgamiento para cada línea de las habilitaciones
                            if (lAlcanceAux != null){
                                // Objeto con la línea que se recupera de la lista de líneas lAlcanceAux
                                GetMaxEntornosExpCodListDTO hmLinea = new GetMaxEntornosExpCodListDTO();

                                for (int l=0; l<lAlcanceAux.size(); l++){

                                    hmLinea =   (GetMaxEntornosExpCodListDTO) lAlcanceAux.get(l);

                                    if (hmLinea != null){

                                        hmLinea = getFechaOtorgamiento1(hmLinea, cdgoExp,mapaFechasOtorgamientosExp);
                                        lAlcanceAux.set(l,hmLinea);
                                    }
                                }
                            }

                            tipoAlcance = HabilitacionEstadoBean.TIPO_ALC_INFRAESTRUCTURA_TRAMOS;
                        }
                    }
                    else if (tipoHabil.equals(MultivalueCts.T123_TIPOHABIL_AUX_CABINA_ALCANCE_AMPLIADO))
                    {
                    	fechaFinValidezFinal = this.tbasg104ExpedientRepository.getFechaFinValidez(mapBean.getCdgoExpedient());
                    	
                        if ( null != objExpediente.getDesgTipoinfraestruc() && "L".equals(objExpediente.getDesgTipoinfraestruc())){
                            lAlcanceAux.add(getAlcanceLinea(objExpediente.getCdgoLinea(), mapaFechasOtorgamientosExp /*objExpediente.getCdgoSociedad()*/));

                            tipoAlcance = HabilitacionEstadoBean.TIPO_ALC_AUXCAB_ALCANCE_AMP_LINEA;
                        }
                        else{
                            // Obtener habilitación por estado
                            if (null != cdgoExp && !"".equals(cdgoExp) )

                                lAlcanceAux = getAlcanceInfraestructuras1(cdgoExp);

                            // Fecha otorgamiento por línea
                            // Se obtiene la fecha de otorgamiento para cada línea de las habilitaciones
                            if (lAlcanceAux != null){

                                // Objeto con la línea que se recupera de la lista de líneas lAlcanceAux
                                GetMaxEntornosExpCodListDTO hmLinea = new GetMaxEntornosExpCodListDTO();


                                for (int l=0; l<lAlcanceAux.size(); l++){

                                    hmLinea = (GetMaxEntornosExpCodListDTO) lAlcanceAux.get(l);

                                    if (hmLinea != null){

                                        hmLinea = getFechaOtorgamiento1(hmLinea, cdgoExp,mapaFechasOtorgamientosExp);

                                        lAlcanceAux.set(l,hmLinea);
                                    }
                                }
                            }

                            tipoAlcance = HabilitacionEstadoBean.TIPO_ALC_AUXCAB_ALCANCE_AMP_TRAMOS;
                        }
                    }
                    else if (tipoHabil.equals(MultivalueCts.T123_TIPOHABIL_AUXILIAR_CABINA))
                    {
                    	fechaFinValidezFinal = this.tbasg104ExpedientRepository.getFechaFinValidez(mapBean.getCdgoExpedient());
                    	
                        tipoAlcance = HabilitacionEstadoBean.TIPO_ALC_AUXILIAR_CABINA;
                        lAlcanceAux.add(getAlcanceAuxCab(objExpediente, mapBean,mapaFechasOtorgamientosExp));

                    }
                    else if (tipoHabil.equals(MultivalueCts.T123_TIPOHABIL_AOT_MANIOBRAS_AYUDA_CABINA))
                    {
                   
                    	fechaFinValidezFinal = this.tbasg104ExpedientRepository.getFechaFinValidez(mapBean.getCdgoExpedient());
                    	
                        if ( null != objExpediente.getDesgTipoinfraestruc() && "L".equals(objExpediente.getDesgTipoinfraestruc())){
                            lAlcanceAux.add(getAlcanceLinea(objExpediente.getCdgoLinea(),mapaFechasOtorgamientosExp/* objExpediente.getCdgoSociedad()*/));
                            tipoAlcance = HabilitacionEstadoBean.TIPO_ALC_AOT_MANIOBRAS_AYUDACAB_LINEA;

                        }
                        else{
                            //  Obtener habilitación por estado
                            if (null != cdgoExp && !"".equals(cdgoExp) )

                                lAlcanceAux = getAlcanceInfraestructuras1(cdgoExp);

                            // Fecha otorgamiento por línea
                            // Se obtiene la fecha de otorgamiento para cada línea de las habilitaciones
                            if (lAlcanceAux != null){

                                // Objeto con la línea que se recupera de la lista de líneas lAlcanceAux
                                GetMaxEntornosExpCodListDTO hmLinea = new GetMaxEntornosExpCodListDTO();

                                for (int l=0; l<lAlcanceAux.size(); l++){

                                    hmLinea =   (GetMaxEntornosExpCodListDTO) lAlcanceAux.get(l);

                                    if (hmLinea != null){

                                        hmLinea = getFechaOtorgamiento1(hmLinea, cdgoExp,mapaFechasOtorgamientosExp);

                                        lAlcanceAux.set(l,hmLinea);
                                    }
                                }
                            }

                            tipoAlcance = HabilitacionEstadoBean.TIPO_ALC_AOT_MANIOBRAS_AYUDACAB_TRAMOS;
                        }
                    }
                    else if(tipoHabil.equals(MultivalueCts.T123_TIPOHABIL_CONDUCCION_MATERIAL))
                    {
                    	fechaFinValidezFinal = this.tbasg104ExpedientRepository.getFechaFinValidez2(mapBean.getCdgoExpedient());
                    	
                        tipoAlcance = HabilitacionEstadoBean.TIPO_ALC_MATERIAL;
                        lAlcanceAux.add(getAlcanceMaterial(objExpediente, mapaFechasOtorgamientosExp));

                    }
                    else if(tipoHabil.equals(MultivalueCts.T123_TIPOHABIL_AUX_OPERACIONES_TREN))
                    {
                    	fechaFinValidezFinal = this.tbasg104ExpedientRepository.getFechaFinValidez(mapBean.getCdgoExpedient());
                    	
                        tipoAlcance = HabilitacionEstadoBean.TIPO_ALC_AUX_OPERACIONES;
                        lAlcanceAux.add(getAlcanceAuxOpTren(objExpediente, mapBean,mapaFechasOtorgamientosExp));
                    }
                    else if(tipoHabil.equals(MultivalueCts.T123_TIPOHABIL_CARGADOR)

                            // Responsable operaciones de carga
                            || tipoHabil.equals(MultivalueCts.T123_TIPOHABIL_RESPONSABLE_OP_CARGA))

                    {
                    	fechaFinValidezFinal = this.tbasg104ExpedientRepository.getFechaFinValidez(mapBean.getCdgoExpedient());
                    	
                        if (tipoHabil.equals(MultivalueCts.T123_TIPOHABIL_RESPONSABLE_OP_CARGA))
                            tipoAlcance = HabilitacionEstadoBean.TIPO_RESPNSABLE_OP_CARGA;
                        else
                            tipoAlcance = HabilitacionEstadoBean.TIPO_ALC_CARGADOR;
                        lAlcanceAux.add(getAlcanceCargador(objExpediente, mapBean,mapaFechasOtorgamientosExp));

                    }
                    else if(tipoHabil.equals(MultivalueCts.T123_TIPOHABIL_OPERADOR_VEHICULO_MANIOBRAS))
                    {
                    	fechaFinValidezFinal = this.tbasg104ExpedientRepository.getFechaFinValidez(mapBean.getCdgoExpedient());
                    	
                        tipoAlcance = HabilitacionEstadoBean.TIPO_ALC_OPERADOR_VEHIC_MANIOBRAS;
                        lAlcanceAux.add(getAlcanceOperadorVehicMan(objExpediente, mapBean,mapaFechasOtorgamientosExp));

                    }
                    else if(tipoHabil.equals(MultivalueCts.T123_TIPOHABIL_RECICLAJE_TITULO_CONDUCCION))
                    {
                    	fechaFinValidezFinal = this.tbasg104ExpedientRepository.getFechaFinValidez3(mapBean.getCdgoExpedient());
                    }
                }

                SimpleDateFormat formatter2=new SimpleDateFormat("yyyy-MM-dd");
                if (fechaFinValidezFinal != null && !fechaFinValidezFinal.isEmpty()) {
                    Date date = fechaFinValidezFinal.get(0).getFchaFinValidez();
                    mapAlcance.put("fechaFinValidez", TextFormat.format(date,"/"));
                }
                if (mapBean.getFchaIniValidez() != null) {
                    Date date2 = new Date(formatter2.parse(mapBean.getFchaIniValidez().toString()).getTime());
                    mapAlcance.put("fechaIniValidez", TextFormat.format(date2,"/"));
                }

                mapAlcance.put("expediente", objExpediente);
                mapAlcance.put("alcance", lAlcanceAux);
                mapAlcance.put("tipoAlcance", Integer.valueOf(tipoAlcance));
                mapAlcance.put("dsgSociedad", dsgSociedad.trim());
                hsTipoHabil.add(Integer.valueOf(tipoAlcance));
                lAlcance.add(mapAlcance);
            }
            lAlcance = orderListAlcance( lAlcance );
            String codSociAnterior = null;
            for(int i=0;i<listCodSociedadesPrevia.size();i++)
            {
                String codSoci = (String) listCodSociedadesPrevia.get(i);

                if (!codSoci.equals(codSociAnterior))
                    listCodSociedades.add(codSoci);

                codSociAnterior = codSoci;
            }
            bean.setListCodSociedades(listCodSociedades);
            bean.setListAlcance(lAlcance);
            bean.setHsTiposHabil(hsTipoHabil);
        }

        return bean;
    }

    private List orderListAlcance( List lAlcance ){

        Map map = null;
        Map mapAlcance = null;
        Map mapAlcance2 = null;
        Map mapOrdenado = null;
        Map mapAux = null;
        List list = null;
        List lAlcanceInfrTramos = new ArrayList();
        List lAlcanceInfrTramosOrdenados = new ArrayList();

        List lAlcanceInfrTramosAlcAux = new ArrayList();
        List lAlcanceInfrTramosAlcAuxOrdenados = new ArrayList();

        List lAlcanceInfrTramosAotMan = new ArrayList<>();
        List lAlcanceInfrTramosAotManOrdenados = new ArrayList<>();

        List lAlcanceInfrLinea = new ArrayList();
        List lAlcanceInfrLineaOrdenados = new ArrayList();

        List lAlcanceInfrLineaAlcAux = new ArrayList();
        List lAlcanceInfrLineaAlcAuxOrdenados = new ArrayList();

        List lAlcanceInfrLineaAotMan = new ArrayList();
        List lAlcanceInfrLineaAotManOrdenados = new ArrayList();

        List lAlcanceMaterial = new ArrayList();
        List lAlcanceMaterialOrdenados = new ArrayList();
        List lAlcanceAuxOper = new ArrayList();
        List lAlcanceCargador = new ArrayList();
        List lAlcanceOperVManio = new ArrayList();
        List lAlcanceAuxCab = new ArrayList();

        List listAlcances = null;
        List lOrdenada = null;

        int tipoAlcance = 0;
        boolean insertado;
        float pkOrigen;
        float pkOrigen2;
        String cdgoLinea = null;
        String cdgoLinea2 = null;
        String serie = null;
        String serie2 = null;
        String subSerie = null;
        String subSerie2 = null;

        for( int i = 0 ; i < lAlcance.size() ; i ++ ){
            map = (HashMap) lAlcance.get(i);
            tipoAlcance = ((Integer) map.get("tipoAlcance")).intValue();
            switch( tipoAlcance ){
                case( HabilitacionEstadoBean.TIPO_ALC_INFRAESTRUCTURA_TRAMOS ):
                    lAlcanceInfrTramos.add( map );
                    break;
                case( HabilitacionEstadoBean.TIPO_ALC_AUXCAB_ALCANCE_AMP_TRAMOS):
                    lAlcanceInfrTramosAlcAux.add( map );
                    break;
                case( HabilitacionEstadoBean.TIPO_ALC_AOT_MANIOBRAS_AYUDACAB_TRAMOS):
                    lAlcanceInfrTramosAotMan.add(map);
                    break;
                case( HabilitacionEstadoBean.TIPO_ALC_INFRAESTRUCTURA_LINEA ):
                    lAlcanceInfrLinea.add( map );
                    break;
                case( HabilitacionEstadoBean.TIPO_ALC_AUXCAB_ALCANCE_AMP_LINEA):
                    lAlcanceInfrLineaAlcAux.add( map );
                    break;
                case( HabilitacionEstadoBean.TIPO_ALC_AOT_MANIOBRAS_AYUDACAB_LINEA):
                    lAlcanceInfrLineaAotMan.add( map );
                    break;
                case( HabilitacionEstadoBean.TIPO_ALC_MATERIAL ):
                    lAlcanceMaterial.add( map );
                    break;
                case( HabilitacionEstadoBean.TIPO_ALC_AUX_OPERACIONES ):
                    lAlcanceAuxOper.add( map );
                    break;
                case( HabilitacionEstadoBean.TIPO_ALC_CARGADOR ):
                    lAlcanceCargador.add( map );
                    break;
                case( HabilitacionEstadoBean.TIPO_ALC_OPERADOR_VEHIC_MANIOBRAS ):
                    lAlcanceOperVManio.add( map );
                    break;
                case( HabilitacionEstadoBean.TIPO_RESPNSABLE_OP_CARGA ):
                    lAlcanceCargador.add( map );
                    break;
                case( HabilitacionEstadoBean.TIPO_ALC_AUXILIAR_CABINA ):
                    lAlcanceAuxCab.add( map );
                    break;
            }
        }

        for( int i = 0 ; i < lAlcanceInfrTramos.size() ; i ++ ){
            ObjectMapper mapObject = new ObjectMapper();
            Map < String, Object > mapObj = mapObject.convertValue(lAlcanceInfrTramos.get(i), Map.class);
            map = mapObj;
            listAlcances = (ArrayList) map.get( "alcance" );
            for( int j = 0 ; j < listAlcances.size() ; j ++ ){
                mapAlcance = (HashMap) listAlcances.get(j);
                mapOrdenado = new HashMap();
                mapOrdenado.put("expediente", map.get("expediente"));
                mapOrdenado.put("tipoAlcance", map.get("tipoAlcance"));
                list = new ArrayList();
                list.add( mapAlcance );
                mapOrdenado.put("alcance", list);
                cdgoLinea = (String) mapAlcance.get("cdgoLinea");
                pkOrigen = Float.parseFloat((String) mapAlcance.get("pkOrigen"));
                mapOrdenado.put("dsgSociedad", map.get("dsgSociedad"));
                mapOrdenado.put("fechaFinValidez", map.get("fechaFinValidez"));
                mapOrdenado.put("fechaIniValidez", map.get("fechaIniValidez"));
                insertado = false;
                if( lAlcanceInfrTramosOrdenados.isEmpty() )
                    lAlcanceInfrTramosOrdenados.add( mapOrdenado );
                else{
                    for( int k = 0 ; k < lAlcanceInfrTramosOrdenados.size() ; k ++ ){
                        mapAlcance2 = (HashMap) lAlcanceInfrTramosOrdenados.get(k);
                        mapAux = (HashMap) ((ArrayList) mapAlcance2.get("alcance")).get(0);
                        cdgoLinea2 = (String) mapAux.get("cdgoLinea");
                        pkOrigen2 = Float.parseFloat((String) mapAlcance.get("pkOrigen"));
                        if( ( cdgoLinea.equals(cdgoLinea2) && pkOrigen < pkOrigen2 ) ||
                                cdgoLinea.compareTo(cdgoLinea2) < 0 ){
                            lAlcanceInfrTramosOrdenados.add( k , mapOrdenado );
                            insertado = true;
                            break;
                        }
                    }
                    if( !insertado )
                        lAlcanceInfrTramosOrdenados.add( mapOrdenado );
                }

            }
        }

        for( int i = 0 ; i < lAlcanceInfrTramosAlcAux.size() ; i ++ ){
            ObjectMapper mapObject = new ObjectMapper();
            Map < String, Object > mapObj = mapObject.convertValue(lAlcanceInfrTramosAlcAux.get(i), Map.class);
            map = mapObj;
            listAlcances = (ArrayList) map.get( "alcance" );
            for( int j = 0 ; j < listAlcances.size() ; j ++ ){
                mapAlcance = (HashMap) listAlcances.get(j);
                mapOrdenado = new HashMap();
                mapOrdenado.put("expediente", map.get("expediente"));
                mapOrdenado.put("tipoAlcance", map.get("tipoAlcance"));
                list = new ArrayList();
                list.add( mapAlcance );
                mapOrdenado.put("alcance", list);
                cdgoLinea = (String) mapAlcance.get("cdgoLinea");
                pkOrigen = Float.parseFloat((String) mapAlcance.get("pkOrigen"));
                mapOrdenado.put("dsgSociedad", map.get("dsgSociedad"));
                mapOrdenado.put("fechaFinValidez", map.get("fechaFinValidez"));
                mapOrdenado.put("fechaIniValidez", map.get("fechaIniValidez"));
                insertado = false;
                if( lAlcanceInfrTramosAlcAuxOrdenados.isEmpty() )
                    lAlcanceInfrTramosAlcAuxOrdenados.add( mapOrdenado );
                else{
                    for( int k = 0 ; k < lAlcanceInfrTramosAlcAuxOrdenados.size() ; k ++ ){
                        mapAlcance2 = (HashMap) lAlcanceInfrTramosAlcAuxOrdenados.get(k);
                        mapAux = (HashMap) ((ArrayList) mapAlcance2.get("alcance")).get(0);
                        cdgoLinea2 = (String) mapAux.get("cdgoLinea");
                        pkOrigen2 = Float.parseFloat((String) mapAlcance.get("pkOrigen"));
                        if( ( cdgoLinea.equals(cdgoLinea2) && pkOrigen < pkOrigen2 ) ||
                                cdgoLinea.compareTo(cdgoLinea2) < 0 ){
                            lAlcanceInfrTramosAlcAuxOrdenados.add( k , mapOrdenado );
                            insertado = true;
                            break;
                        }
                    }
                    if( !insertado )
                        lAlcanceInfrTramosAlcAuxOrdenados.add( mapOrdenado );
                }

            }
        }

        for( int i = 0 ; i < lAlcanceInfrTramosAotMan.size() ; i ++ ){
            ObjectMapper mapObject = new ObjectMapper();
            Map < String, Object > mapObj = mapObject.convertValue(lAlcanceInfrTramosAotMan.get(i), Map.class);
            map = mapObj;
            listAlcances = (ArrayList) map.get( "alcance" );
            for( int j = 0 ; j < listAlcances.size() ; j ++ ){
                mapAlcance = (HashMap) listAlcances.get(j);
                mapOrdenado = new HashMap();
                mapOrdenado.put("expediente", map.get("expediente"));
                mapOrdenado.put("tipoAlcance", map.get("tipoAlcance"));
                list = new ArrayList();
                list.add( mapAlcance );
                mapOrdenado.put("alcance", list);
                cdgoLinea = (String) mapAlcance.get("cdgoLinea");
                pkOrigen = Float.parseFloat((String) mapAlcance.get("pkOrigen"));
                mapOrdenado.put("dsgSociedad", map.get("dsgSociedad"));
                mapOrdenado.put("fechaFinValidez", map.get("fechaFinValidez"));
                mapOrdenado.put("fechaIniValidez", map.get("fechaIniValidez"));
                insertado = false;
                if( lAlcanceInfrTramosAotManOrdenados.isEmpty() )
                    lAlcanceInfrTramosAotManOrdenados.add( mapOrdenado );
                else{
                    for( int k = 0 ; k < lAlcanceInfrTramosAotManOrdenados.size() ; k ++ ){
                        mapAlcance2 = (HashMap) lAlcanceInfrTramosAotManOrdenados.get(k);
                        mapAux = (HashMap) ((ArrayList) mapAlcance2.get("alcance")).get(0);
                        cdgoLinea2 = (String) mapAux.get("cdgoLinea");
                        pkOrigen2 = Float.parseFloat((String) mapAlcance.get("pkOrigen"));
                        if( ( cdgoLinea.equals(cdgoLinea2) && pkOrigen < pkOrigen2 ) ||
                                cdgoLinea.compareTo(cdgoLinea2) < 0 ){
                            lAlcanceInfrTramosAotManOrdenados.add( k , mapOrdenado );
                            insertado = true;
                            break;
                        }
                    }
                    if( !insertado )
                        lAlcanceInfrTramosAotManOrdenados.add( mapOrdenado );
                }

            }
        }

        for( int i = 0 ; i < lAlcanceInfrLinea.size() ; i ++ ){
            ObjectMapper mapObject = new ObjectMapper();
            Map < String, Object > mapObj = mapObject.convertValue(lAlcanceInfrLinea.get(i), Map.class);
            map = mapObj;
            listAlcances = (ArrayList) map.get( "alcance" );
            for( int j = 0 ; j < listAlcances.size() ; j ++ ){
                mapAlcance = (HashMap) listAlcances.get(j);
                mapOrdenado = new HashMap();
                mapOrdenado.put("expediente", map.get("expediente"));
                mapOrdenado.put("tipoAlcance", map.get("tipoAlcance"));
                list = new ArrayList();
                list.add( mapAlcance );
                mapOrdenado.put("alcance", list);
                cdgoLinea = (String) mapAlcance.get("cdgoLinea");
                mapOrdenado.put("dsgSociedad", map.get("dsgSociedad"));
                mapOrdenado.put("fechaFinValidez", map.get("fechaFinValidez"));
                mapOrdenado.put("fechaIniValidez", map.get("fechaIniValidez"));
                insertado = false;
                if( lAlcanceInfrLineaOrdenados.isEmpty() )
                    lAlcanceInfrLineaOrdenados.add( mapOrdenado );
                else{
                    for( int k = 0 ; k < lAlcanceInfrLineaOrdenados.size() ; k ++ ){
                        mapAlcance2 = (HashMap) lAlcanceInfrLineaOrdenados.get(k);
                        mapAux = (HashMap) ((ArrayList) mapAlcance2.get("alcance")).get(0);
                        cdgoLinea2 = (String) mapAux.get("cdgoLinea");
                        if( cdgoLinea.compareTo( cdgoLinea2 ) < 0 ){
                            lAlcanceInfrLineaOrdenados.add( k , mapOrdenado );
                            insertado = true;
                            break;
                        }
                    }
                    if( !insertado )
                        lAlcanceInfrLineaOrdenados.add( mapOrdenado );
                }

            }
        }

        for( int i = 0 ; i < lAlcanceInfrLineaAlcAux.size() ; i ++ ){
            ObjectMapper mapObject = new ObjectMapper();
            Map < String, Object > mapObj = mapObject.convertValue(lAlcanceInfrLineaAlcAux.get(i), Map.class);
            map = mapObj;
            listAlcances = (ArrayList) map.get( "alcance" );
            for( int j = 0 ; j < listAlcances.size() ; j ++ ){
                mapAlcance = (HashMap) listAlcances.get(j);
                mapOrdenado = new HashMap();
                mapOrdenado.put("expediente", map.get("expediente"));
                mapOrdenado.put("tipoAlcance", map.get("tipoAlcance"));
                list = new ArrayList();
                list.add( mapAlcance );
                mapOrdenado.put("alcance", list);
                cdgoLinea = (String) mapAlcance.get("cdgoLinea");
                mapOrdenado.put("dsgSociedad", map.get("dsgSociedad"));
                mapOrdenado.put("fechaFinValidez", map.get("fechaFinValidez"));
                mapOrdenado.put("fechaIniValidez", map.get("fechaIniValidez"));
                insertado = false;
                if( lAlcanceInfrLineaAlcAuxOrdenados.isEmpty() )
                    lAlcanceInfrLineaAlcAuxOrdenados.add( mapOrdenado );
                else{
                    for( int k = 0 ; k < lAlcanceInfrLineaAlcAuxOrdenados.size() ; k ++ ){
                        mapAlcance2 = (HashMap) lAlcanceInfrLineaAlcAuxOrdenados.get(k);
                        mapAux = (HashMap) ((ArrayList) mapAlcance2.get("alcance")).get(0);
                        cdgoLinea2 = (String) mapAux.get("cdgoLinea");
                        if( cdgoLinea.compareTo( cdgoLinea2 ) < 0 ){
                            lAlcanceInfrLineaAlcAuxOrdenados.add( k , mapOrdenado );
                            insertado = true;
                            break;
                        }
                    }
                    if( !insertado )
                        lAlcanceInfrLineaAlcAuxOrdenados.add( mapOrdenado );
                }

            }
        }

        for( int i = 0 ; i < lAlcanceInfrLineaAotMan.size() ; i ++ ){
            ObjectMapper mapObject = new ObjectMapper();
            Map < String, Object > mapObj = mapObject.convertValue(lAlcanceInfrLineaAotMan.get(i), Map.class);
            map = mapObj;
            listAlcances = (ArrayList) map.get( "alcance" );
            for( int j = 0 ; j < listAlcances.size() ; j ++ ){
                mapAlcance = (HashMap) listAlcances.get(j);
                mapOrdenado = new HashMap();
                mapOrdenado.put("expediente", map.get("expediente"));
                mapOrdenado.put("tipoAlcance", map.get("tipoAlcance"));
                list = new ArrayList();
                list.add( mapAlcance );
                mapOrdenado.put("alcance", list);
                cdgoLinea = (String) mapAlcance.get("cdgoLinea");
                mapOrdenado.put("dsgSociedad", map.get("dsgSociedad"));
                mapOrdenado.put("fechaFinValidez", map.get("fechaFinValidez"));
                mapOrdenado.put("fechaIniValidez", map.get("fechaIniValidez"));
                insertado = false;
                if( lAlcanceInfrLineaAotManOrdenados.isEmpty() )
                    lAlcanceInfrLineaAotManOrdenados.add( mapOrdenado );
                else{
                    for( int k = 0 ; k < lAlcanceInfrLineaAotManOrdenados.size() ; k ++ ){
                        mapAlcance2 = (HashMap) lAlcanceInfrLineaAotManOrdenados.get(k);
                        mapAux = (HashMap) ((ArrayList) mapAlcance2.get("alcance")).get(0);
                        cdgoLinea2 = (String) mapAux.get("cdgoLinea");
                        if( cdgoLinea.compareTo( cdgoLinea2 ) < 0 ){
                            lAlcanceInfrLineaAotManOrdenados.add( k , mapOrdenado );
                            insertado = true;
                            break;
                        }
                    }
                    if( !insertado )
                        lAlcanceInfrLineaAotManOrdenados.add( mapOrdenado );
                }

            }
        }

        for( int i = 0 ; i < lAlcanceMaterial.size() ; i ++ ){
            ObjectMapper mapObject = new ObjectMapper();
            Map < String, Object > mapObj = mapObject.convertValue(lAlcanceMaterial.get(i), Map.class);
            map = mapObj;
            listAlcances = (ArrayList) map.get( "alcance" );
            for( int j = 0 ; j < listAlcances.size() ; j ++ ){
                mapAlcance = (HashMap) listAlcances.get(j);
                mapOrdenado = new HashMap();
                mapOrdenado.put("expediente", map.get("expediente"));
                mapOrdenado.put("tipoAlcance", map.get("tipoAlcance"));
                list = new ArrayList();
                list.add( mapAlcance );
                mapOrdenado.put("alcance", list);
                serie = (String) mapAlcance.get("serie");
                subSerie = (String) mapAlcance.get("subSerie");
                if( subSerie == null ) subSerie = "";
                mapOrdenado.put("dsgSociedad", map.get("dsgSociedad"));
                mapOrdenado.put("fechaFinValidez", map.get("fechaFinValidez"));
                mapOrdenado.put("fechaIniValidez", map.get("fechaIniValidez"));
                insertado = false;
                if( lAlcanceMaterialOrdenados.isEmpty() )
                    lAlcanceMaterialOrdenados.add( mapOrdenado );
                else{
                    for( int k = 0 ; k < lAlcanceMaterialOrdenados.size() ; k ++ ){
                        mapAlcance2 = (HashMap) lAlcanceMaterialOrdenados.get(k);
                        mapAux = (HashMap) ((ArrayList) mapAlcance2.get("alcance")).get(0);
                        serie2 = (String) mapAux.get("serie");
                        subSerie2 = (String) mapAux.get("subSerie");
                        if( subSerie2 == null ) subSerie2 = "";
                        if ((serie.equals(serie2)
                                && subSerie.compareTo( subSerie2 ) < 0 )
                                || serie.compareTo( serie2 ) < 0 ) {
                            lAlcanceMaterialOrdenados.add( k , mapOrdenado );
                            insertado = true;
                            break;
                        }
                    }
                    if( !insertado )
                        lAlcanceMaterialOrdenados.add( mapOrdenado );
                }

            }
        }

        lOrdenada = new ArrayList();
        lOrdenada.addAll( lAlcanceInfrTramosOrdenados );
        lOrdenada.addAll( lAlcanceInfrLineaOrdenados );
        lOrdenada.addAll( lAlcanceInfrTramosAlcAuxOrdenados );
        lOrdenada.addAll( lAlcanceInfrLineaAlcAuxOrdenados );
        lOrdenada.addAll( lAlcanceInfrTramosAotManOrdenados );
        lOrdenada.addAll( lAlcanceInfrLineaAotManOrdenados );
        lOrdenada.addAll( lAlcanceMaterialOrdenados );
        lOrdenada.addAll( lAlcanceAuxOper );
        lOrdenada.addAll( lAlcanceCargador );
        lOrdenada.addAll( lAlcanceOperVManio );
        lOrdenada.addAll( lAlcanceAuxCab );

        return lOrdenada;
    }

    //Fecha otorgamiento por línea
    private GetMaxEntornosExpCodListDTO getFechaOtorgamiento1(GetMaxEntornosExpCodListDTO hmLinea, Integer sCdgoExpediente, Tbasg118Estadoexp otorgamiento) {        
        if (otorgamiento.getFchaAct() != null){
        	SimpleDateFormat geek = new SimpleDateFormat("dd/MM/yyyy");
            String formattedDate = geek.format(otorgamiento.getFchaAct());
            hmLinea.setFchaestadoString(formattedDate);
        } else {
            hmLinea.setFchaestadoString(null);
        }        
        return hmLinea;
    }

    private Map getAlcanceAuxCab(Tbasg104Expedient expedient, GetExpedientesPersonaLtDTO mapBean, Tbasg118Estadoexp otorgamiento)
    {
        HashMap hmAlcance = new HashMap();

        Optional<Tbasg257Alcanauxcab> alcanceAux = this.tbasg257AlcanauxcabRepository.findByCdgoAlcanauxcab(expedient.getCdgoAlcanauxcab());


        if(alcanceAux.isPresent()) {
            hmAlcance.put("descripcion", alcanceAux.get().getDesgNombre().trim());
        }

        Date dFechaOtorgamiento = otorgamiento.getFchaAct();

        if (dFechaOtorgamiento != null){
            hmAlcance.put("fchaEstado", TextFormat.format(dFechaOtorgamiento,"/"));
        } else {
            hmAlcance.put("fchaEstado", "");
        }

        Date dFecIniValidez = mapBean.getFchaFinValidez();
        if ( null != dFecIniValidez )
            hmAlcance.put("fchaIniValidez", TextFormat.format(dFecIniValidez));

        Date dFecFinValidez = mapBean.getFchaFinValidez();
        if ( null != dFecFinValidez )
            hmAlcance.put("fchaFinValidez", TextFormat.format(dFecFinValidez));

        hmAlcance.put("cdgoExped",expedient.getCdgoExpedient());

        return hmAlcance;
    }

    private Map getAlcanceAuxOpTren(Tbasg104Expedient expedient, GetExpedientesPersonaLtDTO mapBean, Tbasg118Estadoexp otorgamiento)
    {
        HashMap hmAlcance = new HashMap();

        List<Tbasg131Alcanceot> alcanceOt = this.tbasg131AlcanceotRepository.getAlcanceOtNombre(convertirToString(expedient.getCdgoAlcanceot()));
        hmAlcance.put("descripcion", alcanceOt.get(0).getDesgNombre().trim().toUpperCase());

        Date dFechaOtorgamiento = otorgamiento.getFchaAct();

        if (dFechaOtorgamiento != null){
            hmAlcance.put("fchaEstado", TextFormat.format(dFechaOtorgamiento,"/"));
        } else {
            hmAlcance.put("fchaEstado", "");
        }

        Date dFecIniValidez = mapBean.getFchaIniValidez();
        if ( null != dFecIniValidez )
            hmAlcance.put("fchaIniValidez", TextFormat.format(dFecIniValidez));

        Date dFecFinValidez = mapBean.getFchaFinValidez();
        if ( null != dFecFinValidez )
            hmAlcance.put("fchaFinValidez", TextFormat.format(dFecFinValidez));

        hmAlcance.put("cdgoExped",expedient.getCdgoExpedient());

        return hmAlcance;
    }

    private Map getAlcanceCargador(Tbasg104Expedient expedient, GetExpedientesPersonaLtDTO mapBean, Tbasg118Estadoexp otorgamiento)
    {
        HashMap hmAlcance = new HashMap();

        if(expedient.getCdgoEspec() == null) {
            logger.debug("No hay dato");
        }else {

            Optional<Tbasg137Especiali> especiali = this.tbasg137EspecialiRepository.findByCdgoEspec(expedient.getCdgoEspec());

            if(especiali.isPresent()) {
                hmAlcance.put("descripcion", especiali.get().getDesgNombre());
            }

        }

        Date dFechaOtorgamiento = otorgamiento.getFchaAct();

        if (dFechaOtorgamiento != null){
            hmAlcance.put("fchaEstado", TextFormat.format(dFechaOtorgamiento,"/"));
        } else {
            hmAlcance.put("fchaEstado", "");
        }

        Date dFecIniValidez = mapBean.getFchaIniValidez();
        if ( null != dFecIniValidez )
            hmAlcance.put("fchaIniValidez", TextFormat.format(dFecIniValidez));

        Date dFecFinValidez = mapBean.getFchaFinValidez();
        if ( null != dFecFinValidez )
            hmAlcance.put("fchaFinValidez", TextFormat.format(dFecFinValidez));

        hmAlcance.put("sociedad", expedient.getCdgoSociotor());
        hmAlcance.put("cdgoExped",expedient.getCdgoExpedient());

        return hmAlcance;
    }

    private Map getAlcanceOperadorVehicMan(Tbasg104Expedient expedient, GetExpedientesPersonaLtDTO mapBean, Tbasg118Estadoexp otorgamiento)
    {
        HashMap hmAlcance = new HashMap();

        if(expedient.getCdgoAlcanceambito() == null) {
            logger.debug("No hay dato");
        }else {

            Optional<Tbasg170VehiculoOvm> vehiculoOVM = this.tbasg170VehiculoOvmRepository.findByCdgoVehiculo(expedient.getCdgoAlcanceambito());

            if(vehiculoOVM.isPresent()) {
                hmAlcance.put("descripcion", (mapBean.getDesgNombreAmbito()) + " / Vehículo: " + vehiculoOVM.get().getDesgNombre());
            }

        }

        Date dFechaOtorgamiento = otorgamiento.getFchaAct();

        if (dFechaOtorgamiento != null){
            hmAlcance.put("fchaEstado", TextFormat.format(dFechaOtorgamiento,"/"));
        } else {
            hmAlcance.put("fchaEstado", "");
        }

        Date dFecIniValidez = mapBean.getFchaIniValidez();
        if ( null != dFecIniValidez )
            hmAlcance.put("fchaIniValidez", TextFormat.format(dFecIniValidez));

        Date dFecFinValidez = mapBean.getFchaFinValidez();
        if ( null != dFecFinValidez )
            hmAlcance.put("fchaFinValidez", TextFormat.format(dFecFinValidez));

        hmAlcance.put("sociedad", expedient.getCdgoSociotor());
        hmAlcance.put("cdgoExped",expedient.getCdgoExpedient());

        return hmAlcance;
    }

    private List getAlcanceInfraestructuras1(Integer cdgoExpediente) {

        List listEntornos = new ArrayList();
        try {
            listEntornos = this.tbasg118EstadoexpRepository.getMaxEntornosExpCodList(cdgoExpediente, null);
        }
        catch (Exception e) {
            logger.error("ERROR Getting list of GetMaxEntornosExpCodListAction", e);
        }

        return listEntornos;
    }

    private String buildName(Tbasg100Persona persona) {
        StringBuffer sb = new StringBuffer();
        sb.append(persona.getDesgNombre().trim()).append(" ").append(persona.getDesgApell1().trim()).append(" ").append(persona.getDesgApell2().trim());

        return sb.toString();
    }


    private static final int INFO_SERVICE_TIPO_ID_MATRICULA = 4;

    @Override
    public GetInfoHabilitacionResponse getInfoHabilitacionAction(int tipoId, String id, Boolean indActaPsico, Boolean indActaForm,
                                            Boolean indHistoric, BigInteger codTipoHabil, String tipoInfra, String codAlcanceHab, BigInteger codEstado) throws Exception {

        GetInfoHabilitacionResponse objResponse = new GetInfoHabilitacionResponse();
        GetInfoHabilitacionResponse.GetInfoHabilitacionReturn objReturn = new GetInfoHabilitacionResponse.GetInfoHabilitacionReturn();

        List<Tbasg100Persona> personaObject = null;
        Tbasg100Persona persona = new Tbasg100Persona();

        System.out.println("Comprobando ID");

        if (tipoId == INFO_SERVICE_TIPO_ID_MATRICULA) {
            personaObject = this.tbasg100PersonaRepository.findPersonaByMatricula(id);
            System.out.println("Comprobando ID por matricula");
        } else {
            personaObject = this.tbasg100PersonaRepository.findPersonaByNifPas(id);
            System.out.println("Comprobando ID por NIF");
        }

        if (CollectionUtils.isNotEmpty(personaObject)) {
            persona = personaObject.get(0);
        }

        if (persona == null) {

            objReturn.setStatus(ResponseCts.NIF_PAS_NOT_FOUND.intValue());

            // RNF10-00003778 ASGRF001 Error Servicio Web Habilita Producción
            // Inicializamos el atributo message porque no puede ser nulo
            String msg = BundleMgr.getInstance().resolve(ResponseCts.NIF_PAS_NOT_FOUND.toString());
            if (msg == null) msg = "";
            objReturn.setMessage(msg);
            // Fin RNF10-00003778 ASGRF001
            System.out.println("Comprobando que la persona esta activa" + persona);
        } else {

            // Datos Personales siempre se envían
            GetInfoHabilitacionResponse.GetInfoHabilitacionReturn.InfoHabil objInfoHabil = new GetInfoHabilitacionResponse.GetInfoHabilitacionReturn.InfoHabil();

            objInfoHabil.setPersona(setObjPersona(persona));

            // Comprobamos si quieren Datos Psicofísicos
            if (null != indActaPsico && indActaPsico.booleanValue()) {
                System.out.println("Comprobando indice actaPsico" + indActaPsico);
                List<Tbasg101Certpsic> lDatosPsico = null;
                // Ahora comprobamos si quiere el Actual o los Históricos
                if (null != indHistoric && indHistoric.booleanValue()) {
                    System.out.println("Comprobando indice historico" + indHistoric);
                    lDatosPsico = this.tbasg101CertpsicRepository.getHistoricCertPsicPersonaInfSer(persona.getCdgoPersona());
                } else {
                    lDatosPsico = this.tbasg101CertpsicRepository.getActiveCertPsicWithMaxFchaReconoc(persona.getCdgoPersona());
                }

                //objInfoHabil.setDatosPsico(setListObjDatosPsicofisico(lDatosPsico));

                GetInfoHabilitacionResponse.GetInfoHabilitacionReturn.InfoHabil.Psicofisico[] psicoArray = new GetInfoHabilitacionResponse.GetInfoHabilitacionReturn.InfoHabil.Psicofisico[lDatosPsico.size()];
                //objInfoHabil.getPsicofisico().toArray(lDatosPsico.toArray(psicoArray));

                objInfoHabil.getPsicofisico().addAll(Arrays.asList(setListObjDatosPsicofisico(lDatosPsico)));

            }

            // Comprobamos el resto de parámetros para coger las Habilitaciones
            //HashMap paramMap = new HashMap();
            GetExpedientesPersonaParam param = new GetExpedientesPersonaParam();

            param.setCdgoPersona(persona.getCdgoPersona());
            //paramMap.put("cdgoPersona", persona.getCdgoPersona());

            if (null != codTipoHabil) {
                Integer aux = new Integer(codTipoHabil.intValue());
                param.setCodTipoHabil(BigInteger.valueOf(aux));
                System.out.println("Comprobando el tipo de habilitacion" + codTipoHabil);

            }

            if (null != tipoInfra && !"".equals(tipoInfra))
                param.setTipoInfra(tipoInfra);
            System.out.println("Comprobando tipo de infraestructura" + tipoInfra);


            if (null != codAlcanceHab && !"".equals(codAlcanceHab)) {

                System.out.println("Comprobando el codigo alcance" + codAlcanceHab);

                if (codTipoHabil.intValue() == MultivalueCts.T123_TIPOHABIL_CONDUCCION_INFRAESTRUCTURA.intValue()
                        && tipoInfra.equals(MultivalueCts.T104_TIPO_INFR_ENTORNO)) {

                    List<Tbasg129Entornos> entornoObject = this.tbasg129EntornosRepository.getEntornosByNomCorto(codAlcanceHab);
                    Tbasg129Entornos entorno = new Tbasg129Entornos();

                    if (CollectionUtils.isNotEmpty(entornoObject)) {
                        entorno = entornoObject.get(0);
                    }

                    param.setCodAlcanceHab(String.valueOf(entorno.getCdgoEntorno()));
                    System.out.println("Comprobando el codigo alcance" + entorno);

                } else {
                    param.setCodAlcanceHab(codAlcanceHab);
                }
            }

            if (null != codEstado) {
                Integer aux = new Integer(codEstado.intValue());
                param.setCodEstado(BigInteger.valueOf(aux));
                System.out.println("Comprobando el codigo estado " + aux);

            }

            if (null != indHistoric && indHistoric.booleanValue())
                param.setIndHistoric(indHistoric);
            System.out.println("Comprobando el indice historico" + indHistoric);

            //objInfoHabil.setHabilitacion(getDatosHabilitacion(param, indActaForm, indHistoric));

            //objInfoHabil.getHabilitacion().toArray(new ArrayList<>().toArray(getDatosHabilitacion(param, indActaForm, indHistoric)));

            objInfoHabil.getHabilitacion().addAll(Arrays.asList(getDatosHabilitacion(param, indActaForm, indHistoric)));

            // Cargamos las Habilitaciones al objeto Respuesta
            objReturn.setInfoHabil(objInfoHabil);
            System.out.println("Cargando habilitaciones");

            // Inicializamos el atributo message porque no puede ser nulo
            String msg = BundleMgr.getInstance().resolve(new Integer(objReturn.getStatus()).toString());
            if (msg == null) msg = "";

            objReturn.setMessage(msg);

        }

        objResponse.setGetInfoHabilitacionReturn(objReturn);
        return objResponse;

    }

    private GetInfoHabilitacionResponse.GetInfoHabilitacionReturn.InfoHabil.Habilitacion[] getDatosHabilitacion(GetExpedientesPersonaParam param, Boolean indActaForm, Boolean indHistoric) throws Exception {

        List<GetExpedientesPersonaDTO> expedientListObject = this.tbasg104ExpedientRepository.getExpedientesPersonaParam(param);

        GetInfoHabilitacionResponse.GetInfoHabilitacionReturn.InfoHabil.Habilitacion[] result = new GetInfoHabilitacionResponse.GetInfoHabilitacionReturn.InfoHabil.Habilitacion[expedientListObject.size()];

        GetExpedientesPersonaDTO expedientList = new GetExpedientesPersonaDTO();

        if (CollectionUtils.isNotEmpty(expedientListObject)) {
            expedientList = expedientListObject.get(0);
        }

        String aux = null;
        Date fchaExp = expedientList.getFchaExpediente();
        String fchaExpediente = "";

        if(fchaExp != null) {
            fchaExpediente = TextFormat.format(fchaExp, "/");
        }

        Date fchaEst = expedientList.getFchaEstado();
        String fchaEstado = "";
        if(fchaExp != null) {
            fchaEstado = TextFormat.format(fchaEst, "/");
        }

        if(CollectionUtils.isNotEmpty(expedientListObject)){
            for (int i = 0; i < expedientListObject.size(); i++) {

                GetInfoHabilitacionResponse.GetInfoHabilitacionReturn.InfoHabil.Habilitacion hab = new GetInfoHabilitacionResponse.GetInfoHabilitacionReturn.InfoHabil.Habilitacion();
                hab.setCdgoExpedient(expedientList.getCdgoExpediente());
                hab.setFecExpedient(fchaExpediente);
                hab.setEmpresa(expedientList.getEmpresa());
                hab.setTipoHab(expedientList.getTipoHabilita());
                hab.setSerie(expedientList.getCdgoSerie());
                hab.setSubserie(expedientList.getCdgoSubSerie());
                hab.setEstado(expedientList.getEstado());
                hab.setFecEstado(fchaEstado);
                hab.setObserva(expedientList.getDesgObserva());

                Integer cdgoAmbitos = expedientList.getCdgoAmbitos();
                System.out.println("Comprobando el codigo ambito" + cdgoAmbitos);

                if (cdgoAmbitos != null) {

                    List<Tbasg124Ambitos> ambitos = this.tbasg124AmbitosRepository.getAlcanceAmbito(cdgoAmbitos);
                    aux = ambitos.get(0).getDesgNombre();
                    hab.setAmbito(aux);
                    System.out.println("Comprobando el codigo alcance ambito" + cdgoAmbitos);
                }

                System.out.println("Comprobando parametros vacios ");
                Integer cdgoAlcanceOt = expedientList.getCdgoAlcanceOt();
                System.out.println("Comprobando el codigo alcance " + cdgoAlcanceOt);

                if (cdgoAlcanceOt != null) {

                    List<Tbasg131Alcanceot> alcance = this.tbasg131AlcanceotRepository.getAlcanceOtInfSer(cdgoAlcanceOt);
                    aux = alcance.get(0).getDesgNombre();
                    hab.setAlcanceOT(aux);
                    System.out.println("Comprobando el alcance auxiliar " + aux);

                }

                Integer cdgoAlcanceAmbito = expedientList.getCdgoAcanceAmbito();

                System.out.println("Comprobando el alcance ambito " + cdgoAlcanceAmbito);
                if (cdgoAlcanceAmbito != null) {

                    List<Tbasg124Ambitos> alcanceAmbi = this.tbasg124AmbitosRepository.getAlcanceAmbito(cdgoAlcanceAmbito);
                    aux = alcanceAmbi.get(0).getDesgNombre();
                    hab.setAlcanceAmbito(aux);
                    System.out.println("Comprobando el alcance ambito " + aux);

                }

                Integer cdgoEntorno = expedientList.getCdgoEntorno();
                System.out.println("Comprobando el codigo entorno " + cdgoEntorno);

                if (cdgoEntorno != null) {

                    List<Tbasg129Entornos> entorno = this.tbasg129EntornosRepository.getAlcanceEntorno(cdgoEntorno);
                    aux = entorno.get(0).getDesgNomcorto();
                    hab.setEntorno(aux);

                    System.out.println("Comprobando el codigo entorno auxiliar " + aux);

                }

                String cdgoLinea = expedientList.getCdgoLinea();

                System.out.println("Comprobando el codigo linea " + cdgoLinea);
                if (cdgoLinea != null) {
                    logger.info("Comprobamos el codigo linea " + cdgoLinea);
                    List<Tbasg127Lineas> alcanceLinea = this.tbasg127LineasRepository.getAlcanceLinea(cdgoLinea);
                    aux = alcanceLinea.get(0).getDesgNombre();
                    hab.setLinea(aux);
                    System.out.println("Comprobando el codigo auxiliar " + aux);

                }

                Integer cdgoEspec = expedientList.getCdgoEspec();
                System.out.println("Comprobando el codigo especial " + cdgoEspec);

                if (cdgoEspec != null) {

                    List<Tbasg137Especiali> espec = this.tbasg137EspecialiRepository.getAlcanceEspeciali(cdgoEspec);
                    aux = espec.get(0).getDesgNombre();
                    hab.setEspecialidad(aux);
                    System.out.println("Comprobando el codigo especial auxiliar " + aux);

                }

                // Cargar tramos si fuese necesario
                Integer cdgoTipoHab = expedientList.getCdgoTipoHab();
                String tipoInfr = expedientList.getDesgTipoInfraestruc();
                System.out.println("Comprobando indice actaPsico");

                if (cdgoTipoHab.intValue() == MultivalueCts.T123_TIPOHABIL_CONDUCCION_INFRAESTRUCTURA.intValue()
                        && (tipoInfr.equals(MultivalueCts.T104_TIPO_INFR_ENTORNO)
                        || tipoInfr.equals(MultivalueCts.T104_TIPO_INFR_TRAMOS))) {
                    System.out.println("Comprobando tipo habilitacion");

                    List<GetTramoListByCdgoExpDTO> tramoList = this.tbasg118EstadoexpRepository.getTramoListByCdgoExp(hab.getCdgoExpedient());

                    hab.getTramo().addAll(tramoList.stream().map(element ->
                    {
                        GetInfoHabilitacionResponse.GetInfoHabilitacionReturn.InfoHabil.Habilitacion.Tramo tramo = new GetInfoHabilitacionResponse.GetInfoHabilitacionReturn.InfoHabil.Habilitacion.Tramo();

                        tramo.setCdgoLinea(element.getCdgoLinea());
                        tramo.setDescLinea(element.getDesgNombreLinea());
                        tramo.setCdgoEstOrigen(element.getCdgoOrigen());
                        tramo.setDescEstOrigen(element.getOrigen());
                        tramo.setCdgoEstDestino(element.getCdgoDestino());
                        tramo.setDescEstDestino(element.getDestino());
                        tramo.setEstado(element.getDesgNombreEstado());

                        return  tramo;
                    } ).collect(Collectors.toList()));
                }

                // Comprobamos si quieren Datos de Formación
                if (indActaForm != null && indActaForm.booleanValue()) {
                    System.out.println("Comprobando indice actaform");

                    List<GetActaFormaDTO> formacionList = null;
                    if (indHistoric != null && indHistoric.booleanValue()) {
                        System.out.println("Comprobando indice historico");
                        formacionList = this.tbasg121ActaformaRepository.getHistoricActaFormaPersona(hab.getCdgoExpedient());

                    } else {
                        formacionList = this.tbasg121ActaformaRepository.getLastActaForma(hab.getCdgoExpedient());
                        System.out.println("Entra en el else");
                    }

                    GetInfoHabilitacionResponse.GetInfoHabilitacionReturn.InfoHabil.Habilitacion.Formacion[] formacionArray = new GetInfoHabilitacionResponse.GetInfoHabilitacionReturn.InfoHabil.Habilitacion.Formacion[formacionList.size()];

                    hab.getFormacion().addAll(formacionList.stream().map(element ->
                    {
                        GetInfoHabilitacionResponse.GetInfoHabilitacionReturn.InfoHabil.Habilitacion.Formacion formacion = new GetInfoHabilitacionResponse.GetInfoHabilitacionReturn.InfoHabil.Habilitacion.Formacion();

                        formacion.setCdgoCurso(element.getCdgoCurso());
                        formacion.setDescCurso(element.getDescCurso());
                        formacion.setObserva(element.getObserva());
                        formacion.setCentroFor(element.getCentroFor());
                        formacion.setTipoCurso(element.getTipoCurso());
                        formacion.setCalifi(element.getCalifi());
                        formacion.setInstructor(element.getInstructor());

                        Date fecCur = element.getFecCurso();
                        String fecCurso = TextFormat.format(fecCur, "/");

                        formacion.setFecCurso(fecCurso);

                        return  formacion;
                    } ).collect(Collectors.toList()));

                    System.out.println("Comprobaciones realizadas");
                }

                result[i] = hab;
            }
        }

        return result;
    }

    private GetInfoHabilitacionResponse.GetInfoHabilitacionReturn.InfoHabil.Psicofisico[] setListObjDatosPsicofisico(List<Tbasg101Certpsic> lDatosPsico) throws Exception {

        logger.info("Listado datos Psicofisico");

        GetInfoHabilitacionResponse.GetInfoHabilitacionReturn.InfoHabil.Psicofisico[] arrPsico = new GetInfoHabilitacionResponse.GetInfoHabilitacionReturn.InfoHabil.Psicofisico[lDatosPsico.size()];

        if (null != lDatosPsico && !lDatosPsico.isEmpty()) {

            //CertPsic objCertPsic = null;
            Tbasg101Certpsic objCertPsic = null;

            for (int i = 0; i < lDatosPsico.size(); i++) {

                objCertPsic = (Tbasg101Certpsic) lDatosPsico.get(i);

                //Psicofisico objPsicoSend = new Psicofisico();
                GetInfoHabilitacionResponse.GetInfoHabilitacionReturn.InfoHabil.Psicofisico objPsicoSend = new GetInfoHabilitacionResponse.GetInfoHabilitacionReturn.InfoHabil.Psicofisico();

                Date fchaProx = objCertPsic.getFchaProxrev();
                String fchaProxrev = TextFormat.format(fchaProx, "/");

                objPsicoSend.setFecProxRev(fchaProxrev);

                Date fchaReco = objCertPsic.getFchaReconoc();
                String fchaReconoc = TextFormat.format(fchaReco, "/");

                if (null != objCertPsic.getFchaReconoc())

                    objPsicoSend.setFecReconoc(fchaReconoc);

                if (null != objCertPsic.getCdgoDeobs())
                    objPsicoSend.setObserva(objCertPsic.getCdgoDeobs());

                objPsicoSend.setMrcaCorrVisual(objCertPsic.getMrcaCorrvisual());
                objPsicoSend.setMrcaProtAud(objCertPsic.getMrcaProtaud());

                if (null != objCertPsic.getCdgoCenmed()) {

                    List<Tbasg108Centmedic> centMedicObject = this.tbasg108CentmedicRepository.getCentMedic(Integer.valueOf(objCertPsic.getCdgoCenmed()));
                    Tbasg108Centmedic centMedic = new Tbasg108Centmedic();

                    if (CollectionUtils.isNotEmpty(centMedicObject)) {
                        centMedic = centMedicObject.get(0);

                        objPsicoSend.setCentMed(centMedic.getDesgNombre());
                    }
                }

                if (null != objCertPsic.getCdgoMotivo()) {

                    List<Tbasg110Psicomoti> psicoMotiObject = this.tbasg110PsicomotiRepository.getPsicoMoti(Integer.valueOf(objCertPsic.getCdgoMotivo()));
                    Tbasg110Psicomoti psicoMoti = new Tbasg110Psicomoti();

                    if (CollectionUtils.isNotEmpty(psicoMotiObject)) {
                        psicoMoti = psicoMotiObject.get(0);

                        objPsicoSend.setMotivo(psicoMoti.getDesgNombre());
                    }

                }

                if (null != objCertPsic.getCdgoPsicamb()) {

                    List<Tbasg109Psicoambi> psicoAmbiObject = this.tbasg109PsicoambiRepository.getPsicoAmbi(Integer.valueOf(objCertPsic.getCdgoPsicamb()));
                    Tbasg109Psicoambi psicoAmbi = new Tbasg109Psicoambi();

                    if (CollectionUtils.isNotEmpty(psicoAmbiObject)) {
                        psicoAmbi = psicoAmbiObject.get(0);

                        objPsicoSend.setPsicoAmb(psicoAmbi.getDesgNombre());
                    }

                }

                if (null != objCertPsic.getCdgoFacult()) {

                    List<Tbasg111Facultati> facultatiObject = this.tbasg111FacultatiRepository.getFacultati(Integer.valueOf(objCertPsic.getCdgoFacult()));
                    Tbasg111Facultati facultat = new Tbasg111Facultati();

                    if (CollectionUtils.isNotEmpty(facultatiObject)) {
                        facultat = facultatiObject.get(0);

                        String facultati = facultat.getDesgNombre().trim() + " " + facultat.getDesgApell1().trim() + " " + facultat.getDesgApell2().trim();
                        objPsicoSend.setFacultativo(facultati);
                    }

                }

                if (null != objCertPsic.getCdgoCalifi()) {

                    List<Tbasg115Calificac> calificaObject = this.tbasg115CalificacRepository.getCalificac(Integer.valueOf(objCertPsic.getCdgoCalifi()));
                    Tbasg115Calificac califica = new Tbasg115Calificac();

                    if (CollectionUtils.isNotEmpty(calificaObject)) {
                        califica = calificaObject.get(0);

                        objPsicoSend.setCalifi(califica.getDesgNombre());
                    }

                }
                arrPsico[i] = objPsicoSend;
            }
        }
        return arrPsico;
    }

	private GetInfoHabilitacionResponse.GetInfoHabilitacionReturn.InfoHabil.Persona setObjPersona(Tbasg100Persona objPersona) throws SQLException {

        GetInfoHabilitacionResponse.GetInfoHabilitacionReturn.InfoHabil.Persona objPersonaSend = new GetInfoHabilitacionResponse.GetInfoHabilitacionReturn.InfoHabil.Persona();

        List<GetTituloConListAuxDTO> tituloConObject = null;

		objPersonaSend.setDni(objPersona.getDesgNifpas());
		objPersonaSend.setNombre(objPersona.getDesgNombre());
		objPersonaSend.setApellido1(objPersona.getDesgApell1());
		objPersonaSend.setApellido2(objPersona.getDesgApell2());


		logger.info("El codigo persona es: " + objPersona.getCdgoPersona());
        tituloConObject = this.tbasg100PersonaRepository.getTituloConListAux(objPersona.getCdgoPersona());
        GetTituloConListAuxDTO tituloCon = new GetTituloConListAuxDTO();

        if (CollectionUtils.isNotEmpty(tituloConObject)) {

            tituloCon = tituloConObject.get(0);

            Date fchaCursoIn = tituloCon.getFchaCursoInc();
            String fchaCursoInc = TextFormat.format(fchaCursoIn, "/");

            objPersonaSend.setEstadoTit(tituloCon.getEstado());
            objPersonaSend.setFchaProxReci(fchaCursoInc);
        }

		return objPersonaSend;
	}

	@Override
	public List<Tbasg104ExpedientDto> getEstadoList(String cdgoExpedient, String cdgoEstado, String cdgoEstado_1,
			String cdgoEstado_2, String cdgoEstado_3, String cdgoEstado_4, String cdgoEstado_5, String cdgoEstado_6,
			String cdgoEstado_7, String cdgoEstado_8, String cdgoEstado_9) {
		// TODO Auto-generated method stub
		return null;
	}
}
