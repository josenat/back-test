package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import renfe.com.dto.GetFindTituloConByCdgoPersonaActivo;
import renfe.com.dto.GetMaxEstadoHabilitaListDTO;
import renfe.com.dto.GetMaxEstadoTitCondBySociedadesListDTO;
import renfe.com.dto.GetMaxEstadoTitCondListAllDTO;
import renfe.com.dto.GetTituloConPersonaUltimoDTO;
import renfe.com.dto.MultivalueCts;
import renfe.com.dto.SetMaxEstadoHabilitaList;
import renfe.com.dto.SetMaxEstadoTitCondBySociedadesList;
import renfe.com.dto.SetMaxEstadoTitCondListAll;
import renfe.com.model.dto.Tbasg102TituloconDto;
import renfe.com.model.entity.Tbasg102Titulocon;
import renfe.com.model.entity.Tbasg199DatConf;
import renfe.com.repository.Tbasg102TituloconRepository;

@Service
public class Tbasg102TituloconServiceImpl implements Tbasg102TituloconService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg102TituloconRepository tbasg102TituloconRepository;
	
	@Autowired
	private Tbasg199DatConfService tbasg199DatConfService;

	public List<Tbasg102TituloconDto> getAllTbasg102Titulocon(Tbasg102TituloconDto filter) {

		logger.info("getAllTbasg102Titulocon " + filter);
		if (filter == null) {
			return this.toDtos(tbasg102TituloconRepository.findAll());
		}
		return this.toDtos(tbasg102TituloconRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg102TituloconDto findByCdgoTit(Integer cdgoTit) {

		Optional<Tbasg102Titulocon> tbasg102TituloconData = tbasg102TituloconRepository.findByCdgoTit(cdgoTit);

		if (tbasg102TituloconData.isPresent()) {
			return toDto(tbasg102TituloconData.get());
		}
		return null;
	}

	public Tbasg102TituloconDto createTbasg102Titulocon(Tbasg102TituloconDto tbasg102TituloconDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg102Titulocon dbTbasg102Titulocon = new Tbasg102Titulocon();
		BeanUtils.copyProperties(dbTbasg102Titulocon, tbasg102TituloconDto);
		Tbasg102Titulocon _tbasg102Titulocon = tbasg102TituloconRepository.save(dbTbasg102Titulocon);
		return toDto(_tbasg102Titulocon);
	}

	public Tbasg102TituloconDto updateTbasg102Titulocon(Integer cdgoTit, Tbasg102TituloconDto tbasg102TituloconDto) throws IllegalAccessException, InvocationTargetException {
		
		Optional<Tbasg102Titulocon> tbasg102TituloconData = tbasg102TituloconRepository.findById(cdgoTit);

		if (tbasg102TituloconData.isPresent()) {
			Tbasg102Titulocon dbTbasg102Titulocon = tbasg102TituloconData.get();
			BeanUtils.copyProperties(dbTbasg102Titulocon, tbasg102TituloconDto);
			return toDto(tbasg102TituloconRepository.save(dbTbasg102Titulocon));
		}
		return null;  
	}

	public int deleteTbasg102Titulocon(Integer cdgoTit) {

		tbasg102TituloconRepository.deleteById(cdgoTit);
		return 1;
	}

	public List<Tbasg102TituloconDto> findByCdgoTitIn(List<Integer> cdgoTit) {
		return toDtos(tbasg102TituloconRepository.findByCdgoTitIn(cdgoTit));
	}

	public List<Tbasg102TituloconDto> checkReciclajeTituloCond(String cdgoPersona) {
		return toDtos(tbasg102TituloconRepository.checkReciclajeTituloCond(cdgoPersona));
	}

	public List<GetMaxEstadoTitCondListAllDTO> getMaxEstadoTitCondListAll(SetMaxEstadoTitCondListAll mapPending) {
		List confimList = tbasg102TituloconRepository.getMaxEstadoTitCondListAll(mapPending);
		
		confimList = applyConditionsReciclaje1(confimList, mapPending);
		if( mapPending.isNoSemaforosRojos() == true ){
	    	confimList = quitarSemaforosRojos(confimList);
	    } else if( mapPending.getTiempoLimiteRojo() != null && mapPending.getTiempoLimiteRojo() != 0 ){
	    	confimList = quitarTiempoLimiteRojo( confimList , mapPending.getTiempoLimiteRojo() , mapPending.getTipoListado() );
	    }
		
		List pendingList = addColor1(confimList);
		
		return confimList;
	}
	
	private List addColor1(List pendingList) {
		Date lows, highs, mediums = null;
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
		lows = new Date(low.getTimeInMillis());
		mediums = new Date(medium.getTimeInMillis());
		highs =  new Date(high.getTimeInMillis());
		
		Iterator pendingListIterator = pendingList.iterator();
		List pendingListAux = new ArrayList();
		
		calendarAux = Calendar.getInstance();
		calendarObj = Calendar.getInstance();
		
		while (pendingListIterator.hasNext()){
			GetMaxEstadoTitCondListAllDTO pendingMap = (GetMaxEstadoTitCondListAllDTO) pendingListIterator.next();
		    Integer cdgoTipoHabil = null;

		    if (pendingMap.getFchaCursoInc()!=  null) {
				fechaReciclaje  = (Date)pendingMap.getFchaCursoInc();
				fchaReciclajeCalendar.setTimeInMillis(fechaReciclaje.getTime());
			}else if (pendingMap.getFchaOtorgadoInc()!=  null){
			    fechaReciclaje = (Date)pendingMap.getFchaOtorgadoInc();
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

	public List<GetMaxEstadoTitCondBySociedadesListDTO> getMaxEstadoTitCondBySociedadesList(SetMaxEstadoTitCondBySociedadesList mapPending) {
		List confimList = tbasg102TituloconRepository.getMaxEstadoTitCondBySociedadesList(mapPending);
		
		confimList = applyConditionsReciclaje(confimList, mapPending);
		if( mapPending.isNoSemaforosRojos() == true ){
	    	confimList = quitarSemaforosRojos(confimList);
	    } else if( mapPending.getTiempoLimiteRojo() != null && mapPending.getTiempoLimiteRojo() != 0 ){
	    	confimList = quitarTiempoLimiteRojo( confimList , mapPending.getTiempoLimiteRojo() , mapPending.getTipoListado() );
	    }
		
		List pendingList = addColor(confimList);
		
		return confimList;
	}
	
	private List addColor(List pendingList) {
		Date lows, highs, mediums = null;
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
		lows = new Date(low.getTimeInMillis());
		mediums = new Date(medium.getTimeInMillis());
		highs =  new Date(high.getTimeInMillis());
		
		Iterator pendingListIterator = pendingList.iterator();
		List pendingListAux = new ArrayList();
		
		calendarAux = Calendar.getInstance();
		calendarObj = Calendar.getInstance();
		
		while (pendingListIterator.hasNext()){
			GetMaxEstadoTitCondBySociedadesListDTO pendingMap = (GetMaxEstadoTitCondBySociedadesListDTO) pendingListIterator.next();
		    Integer cdgoTipoHabil = null;

		    if (pendingMap.getFchaCursoInc()!=  null) {
				fechaReciclaje  = (Date)pendingMap.getFchaCursoInc();
				fchaReciclajeCalendar.setTimeInMillis(fechaReciclaje.getTime());
			}else if (pendingMap.getFchaOtorgadoInc()!=  null){
			    fechaReciclaje = (Date)pendingMap.getFchaOtorgadoInc();
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

	public List<Tbasg102TituloconDto> getTituloCon(String cdgoTit) {
		return toDtos(tbasg102TituloconRepository.getTituloCon(cdgoTit));
	}

	public List<Tbasg102TituloconDto> getTituloConActiveByTitulo(String cdgoTit) {
		return toDtos(tbasg102TituloconRepository.getTituloConActiveByTitulo(cdgoTit));
	}

	public List<Tbasg102TituloconDto> checkTituloToInsert(String cdgoPersona) {
		return toDtos(tbasg102TituloconRepository.checkTituloToInsert(cdgoPersona));
	}

	public List<Tbasg102TituloconDto> getTituloConPersona(String cdgoPersona) {
		return toDtos(tbasg102TituloconRepository.getTituloConPersona(cdgoPersona));
	}


	public List<Tbasg102TituloconDto> getTituloConPersonaUltimo(String cdgoPersona) {
		return tbasg102TituloconRepository.getTituloConPersonaUltimo(cdgoPersona);
	}

	public List<GetFindTituloConByCdgoPersonaActivo> findTituloConByCdgoPersonaActivo(Integer cdgoPersona) {
		return tbasg102TituloconRepository.findTituloConByCdgoPersonaActivo(cdgoPersona);
	}

	public List<Tbasg102TituloconDto> getTituloCondActivoVigenteByPersona(String cdgoPersona) {
		return toDtos(tbasg102TituloconRepository.getTituloCondActivoVigenteByPersona(cdgoPersona));
	}

	public List<Tbasg102TituloconDto> getTituloCondActivoVigenteByTitulo(String cdgoTit) {
		return toDtos(tbasg102TituloconRepository.getTituloCondActivoVigenteByTitulo(cdgoTit));
	}

	public int insertTituloCon(Tbasg102Titulocon bean) {
		return tbasg102TituloconRepository.insertTituloCon(bean);
	}

	public int updateTituloCon(Tbasg102TituloconDto bean) {
		return tbasg102TituloconRepository.updateTituloCon(bean);
	}

	public Tbasg102TituloconDto toDto(Tbasg102Titulocon orig) {

		Tbasg102TituloconDto dest = new Tbasg102TituloconDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}
	
	public GetMaxEstadoTitCondListAllDTO toDto4(GetMaxEstadoTitCondListAllDTO origItem) {

		GetMaxEstadoTitCondListAllDTO dest = new GetMaxEstadoTitCondListAllDTO();
		try {
			BeanUtils.copyProperties(dest, origItem);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}
	
	public List<GetMaxEstadoTitCondListAllDTO> toDtos4(List<GetMaxEstadoTitCondListAllDTO> list) {

		List<GetMaxEstadoTitCondListAllDTO> dest = new ArrayList<>();
		if (list == null) {
			return dest;
		}
		list.forEach(origItem -> {
			dest.add(this.toDto4(origItem));
		});
		return dest;
	}
	
	public GetMaxEstadoTitCondBySociedadesListDTO toDto8(GetMaxEstadoTitCondBySociedadesListDTO origItem) {

		GetMaxEstadoTitCondBySociedadesListDTO dest = new GetMaxEstadoTitCondBySociedadesListDTO();
		try {
			BeanUtils.copyProperties(dest, origItem);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}
	
	public List<GetMaxEstadoTitCondBySociedadesListDTO> toDtos8(List<GetMaxEstadoTitCondBySociedadesListDTO> list) {

		List<GetMaxEstadoTitCondBySociedadesListDTO> dest = new ArrayList<>();
		if (list == null) {
			return dest;
		}
		list.forEach(origItem -> {
			dest.add(this.toDto8(origItem));
		});
		return dest;
	}

	public Tbasg102Titulocon toEntity(Tbasg102TituloconDto orig) {

		Tbasg102Titulocon dest = new Tbasg102Titulocon();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg102TituloconDto> toDtos(List<Tbasg102Titulocon> orig) {

		List<Tbasg102TituloconDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg102Titulocon> toEntities(List<Tbasg102TituloconDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg102Titulocon> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
	
	private List quitarTiempoLimiteRojo(List pendingList, Integer tiempoLimiteRojo, String tipoListado) {
		Date fecha = null;
		Date fechaLimite = null;
		String cadenaFecha = null;
		GetMaxEstadoHabilitaListDTO pendingMap = null;
		List pendingListAux = null;
		Calendar fechaC = Calendar.getInstance();
		fechaC.add( Calendar.MONTH , - tiempoLimiteRojo.intValue());
		fechaLimite = new Date(fechaC.getTimeInMillis());
		
		if ( tipoListado.equals("recHab")){
			cadenaFecha = "fchaCursoinc"; 
		} else if (tipoListado.equals("recTit")) {
			cadenaFecha = "fchaConjunta";
		} else if (tipoListado.equals("revPsic")) {
			cadenaFecha = "fchaProxRev";
		}
		
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

	private List applyConditionsReciclaje(List confimList, SetMaxEstadoTitCondBySociedadesList mapPending) {
		
		Iterator confrimListIterator = confimList.iterator();
		GetMaxEstadoTitCondBySociedadesListDTO resultadoMap = null;
        Date fchaCursoInc = null;
        Date fchaOtorInc = null;
        
        Calendar fchaHoyMasNMCal = Calendar.getInstance();
        fchaHoyMasNMCal.add(Calendar.MONTH, mapPending.getMesDeControl());
        ArrayList nuevaList = new ArrayList();
        
        if( confimList != null ){
			for( int i = 0 ; i < confimList.size() ; i ++ ){
				resultadoMap = (GetMaxEstadoTitCondBySociedadesListDTO) confimList.get(i);
				fchaCursoInc = resultadoMap.getFchaCursoInc();
				fchaOtorInc = resultadoMap.getFchaOtorgadoInc();
				if ((fchaCursoInc == null && (fchaOtorInc != null && fchaOtorInc.before(fchaHoyMasNMCal.getTime()))) ||
	                    (fchaCursoInc != null && (fchaCursoInc.before(fchaHoyMasNMCal.getTime()) || fchaCursoInc.equals(fchaHoyMasNMCal.getTime())))){
	                if (fchaCursoInc != null)
	                	resultadoMap.setFchaConjunta(fchaCursoInc);
	                else
	                	resultadoMap.setFchaConjunta(fchaOtorInc);
	                nuevaList.add(resultadoMap);               
	            }
			}
		}
        
		return nuevaList;
	}
	
	private List applyConditionsReciclaje1(List confimList, SetMaxEstadoTitCondListAll mapPending) {
		
		Iterator confrimListIterator = confimList.iterator();
		GetMaxEstadoTitCondListAllDTO resultadoMap = null;
        Date fchaCursoInc = null;
        Date fchaOtorInc = null;
        
        Calendar fchaHoyMasNMCal = Calendar.getInstance();
        fchaHoyMasNMCal.add(Calendar.MONTH, mapPending.getMesDeControl());
        ArrayList nuevaList = new ArrayList();
        
        if( confimList != null ){
			for( int i = 0 ; i < confimList.size() ; i ++ ){
				resultadoMap = (GetMaxEstadoTitCondListAllDTO) confimList.get(i);
				fchaCursoInc = resultadoMap.getFchaCursoInc();
				fchaOtorInc = resultadoMap.getFchaOtorgadoInc();
				if ((fchaCursoInc == null && (fchaOtorInc != null && fchaOtorInc.before(fchaHoyMasNMCal.getTime()))) ||
	                    (fchaCursoInc != null && (fchaCursoInc.before(fchaHoyMasNMCal.getTime()) || fchaCursoInc.equals(fchaHoyMasNMCal.getTime())))){
	                if (fchaCursoInc != null)
	                	resultadoMap.setFchaConjunta(fchaCursoInc);
	                else
	                	resultadoMap.setFchaConjunta(fchaOtorInc);
	                nuevaList.add(resultadoMap);               
	            }
			}
		}
        
		return nuevaList;
	}
	
}
