package renfe.com.pdf.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import renfe.com.model.dto.Tbasg104ExpedientDto;
import renfe.com.model.dto.Tbasg118EstadoexpDto;
import renfe.com.model.entity.Tbasg104Expedient;
import renfe.com.model.entity.Tbasg118Estadoexp;
import renfe.com.pdf.beans.ExpedientesDossierPersonalBean;
import renfe.com.pdf.datamanager.MIExpedientes;
import renfe.com.service.Tbasg104ExpedientService;
import renfe.com.service.Tbasg118EstadoexpService;
import renfe.com.util.ImprimirCts;

import java.util.ArrayList;
import java.util.List;
@Service
@Configurable
public class GetExpedientes {

	private static final Logger log = LoggerFactory.getLogger(GetExpedientes.class);

	private ArrayList objExpedientesDatos = null;
	private ArrayList objEstadosExpedientesDatos = null;
	private ExpedientesDossierPersonalBean objExpedientesWriter[] = null;
	@Autowired
	private Tbasg104ExpedientService tbasg104ExpedientService;
	@Autowired
	private Tbasg118EstadoexpService tbasg118EstadoexpService;
	@Autowired 
	private MIExpedientes miExpedientes;
	
	private Integer CdgoPersona;

	private int iExpedientes = 0;

	public GetExpedientes() {

	}

	public boolean GetEstatus() {
		if (objExpedientesDatos == null)
			return (false);
		else
			return (true);
	}

	public int GetNumExpedientes() {
		return (this.iExpedientes);
	}

	public String GetLinea_000(int Orden) {
		return (this.objExpedientesWriter[Orden].getLinea_000());
	}

	public String GetLinea_001(int Orden) {
		return (this.objExpedientesWriter[Orden].getLinea_001());
	}

	public String GetLinea_002(int Orden) {
		return (this.objExpedientesWriter[Orden].getLinea_002());
	}

	public String GetLinea_003(int Orden) {
		return (this.objExpedientesWriter[Orden].getLinea_003());
	}

	public String GetLinea_004(int Orden) {
		return (this.objExpedientesWriter[Orden].getLinea_004());
	}

	public String GetLinea_005(int Orden) {
		return (this.objExpedientesWriter[Orden].getLinea_005());
	}

	public String GetLinea_006(int Orden) {
		return (this.objExpedientesWriter[Orden].getLinea_006());
	}

	public String GetLinea_007(int Orden) {
		return (this.objExpedientesWriter[Orden].getLinea_007());
	}

	public String GetLinea_008(int Orden) {
		return (this.objExpedientesWriter[Orden].getLinea_008());
	}

	public String GetLinea_009(int Orden) {
		return (this.objExpedientesWriter[Orden].getLinea_009());
	}

	public String GetLinea_010(int Orden) {
		return (this.objExpedientesWriter[Orden].getLinea_010());
	}

	public void GF_Init() {
		this.objExpedientesDatos = this.cargaDatosExpedientes(this.CdgoPersona.toString());

		this.objEstadosExpedientesDatos = this.cargaDatosEstadosExpedientes(this.objExpedientesDatos);

		this.iExpedientes = this.objExpedientesDatos.size();

		this.objExpedientesWriter = new ExpedientesDossierPersonalBean[this.iExpedientes];
		
		if (this.objExpedientesDatos != null) {
			for (int i = 0; i < this.iExpedientes; i++) {
				this.miExpedientes.setObjEstadoExp((Tbasg118EstadoexpDto) this.objEstadosExpedientesDatos.get(i));	
				this.miExpedientes.setObjExpedient((Tbasg104ExpedientDto) this.objExpedientesDatos.get(i));
				
				
				this.objExpedientesWriter[i] = this.miExpedientes.MIE_Init();
			}
		}
	}

	private ArrayList cargaDatosExpedientes(String codPersona) {
		// Listado de datos de Formación
		ArrayList listExpedientes = null;
		if (null != codPersona && !"".equals(codPersona)) {
			try {
				listExpedientes = (ArrayList) tbasg104ExpedientService.getExpedientesPersona(codPersona);
			} catch (Exception e) {
				log.error("ERROR Carga Datos Formacion Modulo Imprimir", e.getMessage());
			}
		}
		return listExpedientes;
	}

	private ArrayList cargaDatosEstadosExpedientes(ArrayList listExpedientes) {
		ImprimirCts objCte = new ImprimirCts();

		ArrayList listEstadosExpedientes = null;
		List<String> listaCdgosExpedientes = null;
		ArrayList listSuspensionesExpedientes = new ArrayList();
		ArrayList listSuspensionesYReactivacionesExpedientes = new ArrayList();
		ArrayList listReactivacionesExpedientes = new ArrayList();
		Tbasg104ExpedientDto expedientAux = new Tbasg104ExpedientDto();

		int codigoEstado = 0;
		int codigoEstadoAnterior = 0;

		Tbasg118EstadoexpDto estadoExp = new Tbasg118EstadoexpDto();

		if (null != listExpedientes && !listExpedientes.isEmpty()) {
			listaCdgosExpedientes = new ArrayList<String>();
			for (int i = 0; i < listExpedientes.size(); i++) {
				expedientAux = (Tbasg104ExpedientDto) listExpedientes.get(i);
				// Listado de fechas suspensión y reactivación expediente
				ArrayList listSuspensionesExpediente = new ArrayList();

				try {
					listSuspensionesYReactivacionesExpedientes = (ArrayList) this.tbasg118EstadoexpService
							.findFechaSuspensionReactivacionExpByCdgoExp(expedientAux.getCdgoExpedient().toString());

				} catch (Exception e) {
					log.error("ERROR Carga Datos Formacion Modulo Imprimir", e.getMessage());

				}
				// Aquí proceso si el código es 3 o 20 o 7 y construyo los dos arrayList,uno con
				// las suspensiones y otro con
				// las reactivaciones.

				if (listSuspensionesYReactivacionesExpedientes != null
						&& listSuspensionesYReactivacionesExpedientes.size() > 0) { // Inicio existen
																					// anulaciones/reactivaciones
					listSuspensionesExpedientes = new ArrayList();
					listReactivacionesExpedientes = new ArrayList();

					int j = 0;
					estadoExp = new Tbasg118EstadoexpDto();
					estadoExp = (Tbasg118EstadoexpDto) listSuspensionesYReactivacionesExpedientes.get(0);
					codigoEstadoAnterior = estadoExp.getCdgoEstado();
					codigoEstado = estadoExp.getCdgoEstado();

					if ((codigoEstado == objCte.EXPEDIENTE_SUSPENSION_CAUTELAR)
							|| (codigoEstado == objCte.EXPEDIENTE_SUSPENSION)) {
						listSuspensionesExpedientes.add(estadoExp);
					}

					if (codigoEstado == objCte.EXPEDIENTE_REACTIVACION) {
						listReactivacionesExpedientes.add(estadoExp);
					}

					codigoEstadoAnterior = codigoEstado;
					j++;

					while (j < listSuspensionesYReactivacionesExpedientes.size()) {
						estadoExp = new Tbasg118EstadoexpDto();
						estadoExp = (Tbasg118EstadoexpDto) listSuspensionesYReactivacionesExpedientes.get(j);
						codigoEstado = estadoExp.getCdgoEstado();

						if (((codigoEstadoAnterior == objCte.EXPEDIENTE_SUSPENSION)
								|| (codigoEstadoAnterior == objCte.EXPEDIENTE_SUSPENSION_CAUTELAR))
								&& (codigoEstado == objCte.EXPEDIENTE_REACTIVACION)) {
							listReactivacionesExpedientes.add(estadoExp);
						}

						if ((codigoEstadoAnterior == objCte.EXPEDIENTE_REACTIVACION)
								&& ((codigoEstado == objCte.EXPEDIENTE_SUSPENSION_CAUTELAR)
										|| (codigoEstado == objCte.EXPEDIENTE_SUSPENSION))) {
							listSuspensionesExpedientes.add(estadoExp);
						}

						codigoEstadoAnterior = codigoEstado;
						j++;

					} // fin while

				} // Fin existen anulaciones/reactivaciones

				// En el caso que haya más suspensiones que reactivaciones,indica que la última
				// suspensión
				// está activa.Para evitar que falle insertamos en la primera posición de la
				// lista de
				// reactivaciones, una vacía para a la hora de mostrar el informe, muestre las
				// fechas cuadradas.
				if ((listReactivacionesExpedientes.size()) < (listSuspensionesExpedientes.size())) {
					estadoExp = new Tbasg118EstadoexpDto();
					listReactivacionesExpedientes.add(0, estadoExp);
				}

				expedientAux.setSuspensiones(listSuspensionesExpediente);
				expedientAux.setReactivaciones(listReactivacionesExpedientes);
				listaCdgosExpedientes.add(expedientAux.getCdgoExpedient().toString());

			}

			try {
				listEstadosExpedientes = (ArrayList) this.tbasg118EstadoexpService
						.getEstadosExpsMaxFecha(listaCdgosExpedientes);
			} catch (Exception e) {
				log.error("ERROR Carga Datos Formacion Modulo Imprimir", e.getMessage());
			}

		}
		return listEstadosExpedientes;
	}

	public Integer getCdgoPersona() {
		return CdgoPersona;
	}

	public void setCdgoPersona(Integer cdgoPersona) {
		CdgoPersona = cdgoPersona;
	}

}
