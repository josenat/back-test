package renfe.com.pdf.datamanager;

import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import renfe.com.model.dto.Tbasg104ExpedientDto;
import renfe.com.model.dto.Tbasg116EstadosDto;
import renfe.com.model.dto.Tbasg118EstadoexpDto;
import renfe.com.model.dto.Tbasg123TipohabilDto;
import renfe.com.model.dto.Tbasg124AmbitosDto;
import renfe.com.model.dto.Tbasg125EmpresaDto;
import renfe.com.model.dto.Tbasg127LineasDto;
import renfe.com.model.dto.Tbasg129EntornosDto;
import renfe.com.model.dto.Tbasg131AlcanceotDto;
import renfe.com.model.dto.Tbasg133SerieDto;
import renfe.com.model.dto.Tbasg137EspecialiDto;
import renfe.com.model.dto.Tbasg170VehiculoOvmDto;
import renfe.com.model.entity.Tbasg129Entornos;
import renfe.com.model.entity.Tbasg131Alcanceot;
import renfe.com.model.entity.Tbasg170VehiculoOvm;
import renfe.com.pdf.beans.ExpedientesDossierPersonalBean;
import renfe.com.service.Tbasg116EstadosService;
import renfe.com.service.Tbasg123TipohabilService;
import renfe.com.service.Tbasg124AmbitosService;
import renfe.com.service.Tbasg125EmpresaService;
import renfe.com.service.Tbasg127LineasService;
import renfe.com.service.Tbasg129EntornosService;
import renfe.com.service.Tbasg131AlcanceotService;
import renfe.com.service.Tbasg133SerieService;
import renfe.com.service.Tbasg137EspecialiService;
import renfe.com.service.Tbasg170VehiculoOvmService;
import renfe.com.util.ImprimirCts;
import renfe.com.util.Util;
@Service
@Configurable
public class MIExpedientes {

	private static final Logger log = LoggerFactory.getLogger(MIExpedientes.class);

	private boolean Accion = false;
	private Tbasg104ExpedientDto objExpedient = null;
	private Tbasg118EstadoexpDto objEstadoExp = null;

	private String sPre = "    ";

	@Autowired
	private Tbasg123TipohabilService tbasg123TipohabilService;
	@Autowired
	private Tbasg116EstadosService tbasg116EstadosService;
	@Autowired
	private Tbasg129EntornosService tbasg129EntornosService;
	@Autowired
	private Tbasg127LineasService tbasg127LineasService;
	@Autowired
	private Tbasg133SerieService tbasg133SerieService;
	@Autowired
	private Tbasg131AlcanceotService tbasg131AlcanceotService;
	@Autowired
	private Tbasg137EspecialiService tbasg137EspecialiService;
	@Autowired
	private Tbasg170VehiculoOvmService tbasg170VehiculoOvmService;
	@Autowired
	private Tbasg124AmbitosService tbasg124AmbitosService;
	@Autowired
	private Tbasg125EmpresaService tbasg125EmpresaService;

	public ExpedientesDossierPersonalBean MIE_Init() {
		ImprimirCts objCte = new ImprimirCts();
		String AAOVM = "";
		ExpedientesDossierPersonalBean dto = new ExpedientesDossierPersonalBean();
		if (this.objExpedient != null)
			Accion = true;

		if (this.Accion) {
			int iB = 0;
			String Texto = "";

			dto.setLinea_000(objCte.EXPEDIENTES_LT_LI_000);

			dto.setLinea_001(this.sPre); // Codigo + Tipo
			iB = objCte.PERSONA_MAX_TITULO - objCte.EXPEDIENTES_LT_LI_001.length();
			Texto = objCte.EXPEDIENTES_LT_LI_001 + (new Util().getPuntos(iB));
			Texto = Texto + this.objExpedient.getCdgoExpedient().intValue() + " - ";

			try {

				Tbasg123TipohabilDto objTipoHabil = tbasg123TipohabilService
						.findByCdgoTipohab(this.objExpedient.getCdgoTipohab());
				String nombreForma = objTipoHabil != null
						? (objTipoHabil.getDesgNombre() != null ? objTipoHabil.getDesgNombre() : "")
						: "";
				Texto = Texto + (!nombreForma.equals("") ? nombreForma.trim() : objCte.EXPEDIENTES_LT_LI_A01);
			} catch (Exception Ex) {
				log.error("ERROR Obteniendo Tipo Habilitacion Modulo Imprimir", Ex.getMessage());
				Texto = Texto + objCte.EXPEDIENTES_LT_LI_A03;

			}
			dto.addLinea_001(Texto);

			dto.setLinea_002(this.sPre); // Estado + Fecha Estado
			iB = objCte.PERSONA_MAX_TITULO - objCte.EXPEDIENTES_LT_LI_002.length();
			Texto = objCte.EXPEDIENTES_LT_LI_002 + (new Util().getPuntos(iB));

			try {
				// EstadoExp objEstadoExp = (EstadoExp) new
				// GetEstadoExpedieteAccion(this.objExpedient.getCdgoExpediente()).execute();
				if (objEstadoExp != null) {
					try {
						Tbasg116EstadosDto tbasg116 = tbasg116EstadosService
								.findByCdgoEstado(objEstadoExp.getCdgoEstado());
						String estados = tbasg116 != null
								? (tbasg116.getDesgNombre() != null ? tbasg116.getDesgNombre() : "")
								: "";
						Texto = Texto
								+ (!estados.equals("") ? estados.trim() + " / " : objCte.EXPEDIENTES_LT_LI_A01 + " / ");

					} catch (Exception Ex) {
						log.error("ERROR Obteniendo Estados Modulo Imprimir", Ex.getMessage());
						Texto = Texto + objCte.EXPEDIENTES_LT_LI_A03 + " / ";
					}

					if (objEstadoExp.getFchaEstado() != null)
						Texto = Texto + TextFormat.format(objEstadoExp.getFchaEstado());
					else
						Texto = Texto + objCte.EXPEDIENTES_LT_LI_A01;
				} else
					Texto = Texto + objCte.EXPEDIENTES_LT_LI_A02;
			} catch (Exception Ex) {
				log.error("ERROR Obteniendo Estado Expediente Modulo Imprimir", Ex.getMessage());
				Texto = Texto + objCte.EXPEDIENTES_LT_LI_A03;
			}
			dto.addLinea_002(Texto);

			dto.setLinea_003(this.sPre); // Alcances
			iB = objCte.PERSONA_MAX_TITULO - objCte.EXPEDIENTES_LT_LI_003.length();
			Texto = objCte.EXPEDIENTES_LT_LI_003 + (new Util().getPuntos(iB));

			if (this.objExpedient.getCdgoTipohab().intValue() == 1) // Conducción de Infraestructura
			{
				if (this.objExpedient.getCdgoEntorno() != null) {
					try {
						Tbasg129EntornosDto tbasg129 = tbasg129EntornosService
								.findByCdgoEntorno(this.objExpedient.getCdgoEntorno());
						String entornos = tbasg129 != null
								? (tbasg129.getDesgNomcorto() != null ? tbasg129.getDesgNomcorto() : "")
								: "";
						Texto = Texto + (!entornos.equals("") ? entornos.trim() : " - " + objCte.EXPEDIENTES_LT_LI_A01);

					} catch (Exception Ex) {
						log.error("ERROR Obteniendo Entornos Modulo Imprimir", Ex.getMessage());
						Texto = " - " + Texto + objCte.EXPEDIENTES_LT_LI_A03;
					}
				}
				if (this.objExpedient.getCdgoLinea() != null) {
					try {
						Tbasg127LineasDto tbasg127 = tbasg127LineasService
								.findByCdgoLinea(this.objExpedient.getCdgoLinea());
						String nombreLinea = tbasg127 != null
								? (tbasg127.getDesgNombre() != null ? tbasg127.getDesgNombre() : "")
								: "";
						Texto = Texto + (!nombreLinea.equals("") ? nombreLinea.trim() : " - " + objCte.EXPEDIENTES_LT_LI_A01);

					} catch (Exception Ex) {
						log.error("ERROR Obteniendo Lineas Modulo Imprimir", Ex.getMessage());
						Texto = " - " + Texto + objCte.EXPEDIENTES_LT_LI_A03;
					}
				}
			}

			if (this.objExpedient.getCdgoTipohab().intValue() == 2) // Conducción de Material
			{
				if (this.objExpedient.getCdgoSerie() != null) {
					try {
						Tbasg133SerieDto tbasg133 = tbasg133SerieService
								.findByCdgoSerie(this.objExpedient.getCdgoSerie());
						String nombreSerie = tbasg133 != null
								? (tbasg133.getDesgNombre() != null ? tbasg133.getDesgNombre() : "")
								: "";
						Texto = Texto + (!nombreSerie.equals("") ? nombreSerie.trim() : objCte.EXPEDIENTES_LT_LI_A01);
					} catch (Exception Ex) {
						log.error("ERROR Obteniendo Serie Modulo Imprimir", Ex.getMessage());
						Texto = Texto + objCte.EXPEDIENTES_LT_LI_A03;
					}
				}

				if (this.objExpedient.getCdgoSubserie() != null) {
					Texto = Texto + objCte.EXPEDIENTES_LT_LI_A04 + this.objExpedient.getCdgoSubserie().trim().toString();
				}
			}
			if (this.objExpedient.getCdgoTipohab().intValue() == 3) // Auxiliar de Operaciones de Tren
			{

				if (this.objExpedient.getCdgoAlcanceot() != null) {
					try {

						Tbasg131AlcanceotDto tbasg131 = tbasg131AlcanceotService
								.findByCdgoAlcanceot(this.objExpedient.getCdgoAlcanceot());
						String nombreAlcanceot = tbasg131 != null
								? (tbasg131.getDesgNombre() != null ? tbasg131.getDesgNombre() : "")
								: "";

						Texto = Texto + (!nombreAlcanceot.equals("") ? nombreAlcanceot.trim() : objCte.EXPEDIENTES_LT_LI_A01);

					} catch (Exception Ex) {
						log.error("ERROR Obteniendo Alcace OT Modulo Imprimir", Ex.getMessage());
						Texto = Texto + objCte.EXPEDIENTES_LT_LI_A03;
					}
				}
			}
			if (this.objExpedient.getCdgoTipohab().intValue() == 4) // Cargador
			{
				if (this.objExpedient.getCdgoEspec() != null) {
					try {

						Tbasg137EspecialiDto tbasg137 = this.tbasg137EspecialiService
								.findByCdgoEspec(this.objExpedient.getCdgoEspec());

						String nombreEspeciali = tbasg137 != null
								? (tbasg137.getDesgNombre() != null ? tbasg137.getDesgNombre() : "")
								: "";

						Texto = Texto + (!nombreEspeciali.equals("") ? nombreEspeciali.trim() : objCte.EXPEDIENTES_LT_LI_A01);

					} catch (Exception Ex) {
						log.error("ERROR Obteniendo Especialidad Modulo Imprimir", Ex.getMessage());
						Texto = Texto + objCte.EXPEDIENTES_LT_LI_A03;
					}
				}
			}

			if (this.objExpedient.getCdgoTipohab().intValue() == 5) // Habilitacion OVM Alcance = Ambito
			{ // Esta en la tabla 256 por codigo de alcances ambitos
				try {
					Tbasg170VehiculoOvmDto tbasg170 = this.tbasg170VehiculoOvmService
							.findByCdgoVehiculo(this.objExpedient.getCdgoAlcanceambito());
					String nombreVehi = tbasg170 != null
							? (tbasg170.getDesgNombre() != null ? tbasg170.getDesgNombre().trim() : "")
							: "";

					if (nombreVehi != null) {
						AAOVM = nombreVehi;
						if (AAOVM.length() > objCte.MAX_CC_LINEA)
							AAOVM = AAOVM.substring(0, (objCte.MAX_CC_LINEA - 3)) + "...";
						Texto = Texto + AAOVM;
					} else {
						Texto = Texto + objCte.EXPEDIENTES_LT_LI_A01;
						AAOVM = objCte.EXPEDIENTES_LT_LI_A01;
					}
				} catch (Exception Ex) {
					log.error("ERROR Obteniendo Alcances OVM Modulo Imprimir", Ex.getMessage());
					Texto = Texto + objCte.EXPEDIENTES_LT_LI_A03;
				}
			}
			dto.addLinea_003(Texto);

			dto.setLinea_004(this.sPre); // Ambitos
			iB = objCte.PERSONA_MAX_TITULO - objCte.EXPEDIENTES_LT_LI_004.length();
			Texto = objCte.EXPEDIENTES_LT_LI_004 + (new Util().getPuntos(iB));

			if (this.objExpedient.getCdgoTipohab().intValue() != 5) {
				try {
					Tbasg124AmbitosDto tbasg124 = this.tbasg124AmbitosService
							.findByCdgoAmbitos(this.objExpedient.getCdgoAmbitos());
					String nombreAmbito = tbasg124 != null
							? (tbasg124.getDesgNombre() != null ? tbasg124.getDesgNombre() : "")
							: "";

					Texto = Texto + (!nombreAmbito.equals("") ? nombreAmbito.trim() : objCte.EXPEDIENTES_LT_LI_A01);

				} catch (Exception Ex) {
					log.error("ERROR Obteniendo Ambitos 1,2,3,4 Modulo Imprimir", Ex.getMessage());
					Texto = Texto + objCte.EXPEDIENTES_LT_LI_A03;
				}
			}

			if (this.objExpedient.getCdgoTipohab().intValue() == 5) // Habilitacion OVM Alcance = Ambito
			{ // Esta en la tabla 256 por codigo de alcances ambitos ya se obtubo en Alcances
				Texto = Texto + AAOVM;
			}
			dto.addLinea_004(Texto);

			dto.setLinea_005(this.sPre); // Empresa
			iB = objCte.PERSONA_MAX_TITULO - objCte.EXPEDIENTES_LT_LI_005.length();
			Texto = objCte.EXPEDIENTES_LT_LI_005 + (new Util().getPuntos(iB));

			if (this.objExpedient.getCdgoEmpresa() != null) {
				try {
					Tbasg125EmpresaDto objEmpresa = this.tbasg125EmpresaService
							.findByCdgoEmpresa(this.objExpedient.getCdgoEmpresa());
					String nombreEmpresa = objEmpresa != null
							? (objEmpresa.getDesgNombre() != null ? objEmpresa.getDesgNombre().trim() : "")
							: "";

					Texto = Texto + (!nombreEmpresa.equals("") ? nombreEmpresa.trim() : objCte.EXPEDIENTES_LT_LI_A01);

				} catch (Exception Ex) {
					log.error("ERROR Obteniendo Empresa Modulo Imprimir", Ex.getMessage());
					Texto = Texto + objCte.EXPEDIENTES_LT_LI_A03;
				}
			} else {
				Texto = Texto + objCte.EXPEDIENTES_LT_LI_A01;
			}
			dto.addLinea_005(Texto);

			if (this.objExpedient.getSuspensiones() != null) {
				if (this.objExpedient.getSuspensiones().size() > 0) {
					Tbasg118EstadoexpDto objectEstadoExp = new Tbasg118EstadoexpDto();
					for (int i = 0; i < this.objExpedient.getSuspensiones().size(); i++) {
						// Añadimos el bloque de las suspensiones
						switch (i) {
						case 0:
							dto.setLinea_006(this.sPre); // Suspensiones línea 0(1..n))
							break;
						case 1:
							dto.setLinea_007(this.sPre); // Suspensiones línea 1(1..n))
							break;
						case 2:
							dto.setLinea_008(this.sPre); // Suspensiones línea 2(1..n))
							break;
						case 3:
							dto.setLinea_009(this.sPre); // Suspensiones línea 3(1..n))
							break;
						case 4:
							dto.setLinea_010(this.sPre); // Suspensiones línea 4(1..n))
							break;
						}

						iB = objCte.PERSONA_MAX_TITULO - objCte.EXPEDIENTES_LT_LI_S00.length();
						Texto = objCte.EXPEDIENTES_LT_LI_S00 + (new Util().getPuntos(iB));

						// Fecha suspensión
						Texto = Texto + objCte.EXPEDIENTES_LT_LI_S01;
						objectEstadoExp = new Tbasg118EstadoexpDto();
						objectEstadoExp = (Tbasg118EstadoexpDto) this.objExpedient.getSuspensiones().get(i);
						SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
						Texto = Texto + format.format(objectEstadoExp.getFchaEstado());

						// Añadimos las reactivaciones
						Texto = Texto + objCte.EXPEDIENTES_LT_LI_S02;
						if (this.objExpedient.getReactivaciones() != null) {
							if (this.objExpedient.getReactivaciones().size() > 0) {
								if (i < this.objExpedient.getReactivaciones().size()) {
									objectEstadoExp = new Tbasg118EstadoexpDto();
									objectEstadoExp = (Tbasg118EstadoexpDto) this.objExpedient.getReactivaciones()
											.get(i);
									format = new SimpleDateFormat("dd-MM-yyyy");
									if (objectEstadoExp.getFchaEstado() != null) {
										Texto = Texto + format.format(objectEstadoExp.getFchaEstado());
									}

								}
							}
						}
						// Añadimos el bloque de las suspensiones
						switch (i) {
						case 0:
							dto.addLinea_006(Texto);
							break;
						case 1:
							dto.addLinea_007(Texto);
							break;
						case 2:
							dto.addLinea_008(Texto);
							break;
						case 3:
							dto.addLinea_009(Texto);
							break;
						case 4:
							dto.addLinea_010(Texto);
							break;
						}
					}
				}
			}

		}

		return dto;

	}

	public Tbasg104ExpedientDto getObjExpedient() {
		return objExpedient;
	}

	public void setObjExpedient(Tbasg104ExpedientDto objExpedient) {
		this.objExpedient = objExpedient;
	}

	public Tbasg118EstadoexpDto getObjEstadoExp() {
		return objEstadoExp;
	}

	public void setObjEstadoExp(Tbasg118EstadoexpDto objEstadoExp) {
		this.objEstadoExp = objEstadoExp;
	}
}
