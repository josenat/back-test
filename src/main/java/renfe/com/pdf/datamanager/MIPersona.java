package renfe.com.pdf.datamanager;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import renfe.com.model.dto.Tbasg100PersonaDto;
import renfe.com.model.dto.Tbasg105AreactiviDto;
import renfe.com.model.dto.Tbasg106ProvinciaDto;
import renfe.com.model.dto.Tbasg107TipoviaDto;
import renfe.com.model.dto.Tbasg134NacionDto;
import renfe.com.model.dto.Tbasg135CargoDto;
import renfe.com.service.Tbasg105AreactiviService;
import renfe.com.service.Tbasg106ProvinciaService;
import renfe.com.service.Tbasg107TipoviaService;
import renfe.com.service.Tbasg134NacionService;
import renfe.com.service.Tbasg135CargoService;
import renfe.com.util.ImprimirCts;
import renfe.com.util.Util;

@Service
@Configurable
public class MIPersona {

	private static final Logger log = LoggerFactory.getLogger(MIPersona.class);


	private String sPre = "    ";

	private String Linea_000 = "";
	private String Linea_000B = "";
	private String Linea_001 = "";
	private String Linea_001B = "";
	private String Linea_001C = "";
	private String Linea_002 = "";
	private String Linea_003 = "";
	private String Linea_003B = "";
	private String Linea_003C = "";
	private String Linea_000C = "";
	private String Linea_004 = "";
	private String Linea_005 = "";
	private String Linea_006 = "";

	private Tbasg100PersonaDto objPersona = null;
	@Autowired
	private Tbasg105AreactiviService tbasg105AreactiviService;
	@Autowired
	private Tbasg106ProvinciaService tbasg106ProvinciaService;
	@Autowired
	private Tbasg107TipoviaService tbasg107TipoviaService;
	@Autowired
	private Tbasg134NacionService tbasg134NacionService;
	@Autowired
	private Tbasg135CargoService tbasg135CargoService;

	public MIPersona() {
		
	}

	public String GetLinea_000() {
		return (this.Linea_000);
	}

	public String GetLinea_000B() {
		return (this.Linea_000B);
	}

	public String GetLinea_001() {
		return (this.Linea_001);
	}

	public String GetLinea_001B() {
		return (this.Linea_001B);
	}

	public String GetLinea_001C() {
		return (this.Linea_001C);
	}

	public String GetLinea_002() {
		return (this.Linea_002);
	}

	public String GetLinea_003() {
		return (this.Linea_003);
	}

	public String GetLinea_003B() {
		return (this.Linea_003B);
	}

	public String GetLinea_003C() {
		return (this.Linea_003C);
	}

	public String GetLinea_000C() {
		return (this.Linea_000C);
	}

	public String GetLinea_004() {
		return (this.Linea_004);
	}

	public String GetLinea_005() {
		return (this.Linea_005);
	}

	public String GetLinea_006() {
		return (this.Linea_006);
	}

	private void SetLinea_000(String Texto) {
		this.Linea_000 = Texto;
	}

	private void SetLinea_000B(String Texto) {
		this.Linea_000B = Texto;
	}

	private void SetLinea_001(String Texto) {
		this.Linea_001 = Texto;
	}

	private void SetLinea_001B(String Texto) {
		this.Linea_001B = Texto;
	}

	private void SetLinea_001C(String Texto) {
		this.Linea_001C = Texto;
	}

	private void SetLinea_002(String Texto) {
		this.Linea_002 = Texto;
	}

	private void SetLinea_003(String Texto) {
		this.Linea_003 = Texto;
	}

	private void SetLinea_003B(String Texto) {
		this.Linea_003B = Texto;
	}

	private void SetLinea_003C(String Texto) {
		this.Linea_003C = Texto;
	}

	private void SetLinea_000C(String Texto) {
		this.Linea_000C = Texto;
	}

	private void SetLinea_004(String Texto) {
		this.Linea_004 = Texto;
	}

	private void SetLinea_005(String Texto) {
		this.Linea_005 = Texto;
	}

	private void SetLinea_006(String Texto) {
		this.Linea_006 = Texto;
	}

	protected void AddLinea_000(String Texto) {
		this.Linea_000 = this.Linea_000 + Texto;
	}

	protected void AddLinea_000B(String Texto) {
		this.Linea_000B = this.Linea_000B + Texto;
	}

	protected void AddLinea_001(String Texto) {
		this.Linea_001 = this.Linea_001 + Texto;
	}

	protected void AddLinea_001B(String Texto) {
		this.Linea_001B = this.Linea_001B + Texto;
	}

	protected void AddLinea_001C(String Texto) {
		this.Linea_001C = this.Linea_001C + Texto;
	}

	protected void AddLinea_002(String Texto) {
		this.Linea_002 = this.Linea_002 + Texto;
	}

	protected void AddLinea_003(String Texto) {
		this.Linea_003 = this.Linea_003 + Texto;
	}

	protected void AddLinea_003B(String Texto) {
		this.Linea_003B = this.Linea_003B + Texto;
	}

	protected void AddLinea_003C(String Texto) {
		this.Linea_003C = this.Linea_003C + Texto;
	}

	protected void AddLinea_000C(String Texto) {
		this.Linea_000C = this.Linea_000C + Texto;
	}

	protected void AddLinea_004(String Texto) {
		this.Linea_004 = this.Linea_004 + Texto;
	}

	protected void AddLinea_005(String Texto) {
		this.Linea_005 = this.Linea_005 + Texto;
	}

	protected void AddLinea_006(String Texto) {
		this.Linea_006 = this.Linea_006 + Texto;
	}

	public void MIP_Init() {
		ImprimirCts objCte = new ImprimirCts();
		this.objPersona.setDesgNombre(this.objPersona.getDesgNombre() != null ? this.objPersona.getDesgNombre().trim()
				: this.objPersona.getDesgNombre());
		this.objPersona.setDesgApell1(this.objPersona.getDesgApell1() != null ? this.objPersona.getDesgApell1().trim()
				: this.objPersona.getDesgApell1());
		this.objPersona.setDesgApell2(this.objPersona.getDesgApell2() != null ? this.objPersona.getDesgApell2().trim()
				: this.objPersona.getDesgApell2());

		boolean Accion = false;

		if (this.objPersona != null)
			Accion = true;

		// Titulo
		this.SetLinea_000(objCte.PERSONA_LT_LI_000);
		if (Accion) {
			String Texto = this.objPersona.getDesgApell1() + " " + this.objPersona.getDesgApell2() + ", "
					+ this.objPersona.getDesgNombre();

			this.AddLinea_000(Texto);
		}

		// Nombre y Documento
		// Titulo
		this.SetLinea_000B(objCte.PERSONA_LT_LI_00B);
		// Contenido
		this.SetLinea_001((this.sPre + objCte.PERSONA_LT_LI_001));
		if (Accion) {
			int iB = objCte.PERSONA_MAX_TITULO - objCte.PERSONA_LT_LI_001.length();
			String Texto = this.objPersona.getDesgNombre() + " ";
			Texto = Texto + this.objPersona.getDesgApell1() + " ";
			if (this.objPersona.getDesgApell2() != null)
				Texto = Texto + this.objPersona.getDesgApell2();

			// Nombre
			this.AddLinea_001((new Util().getPuntos(iB)));
			this.AddLinea_001(Texto);

			// Documento

			// tipo de documento
			// Por defecto NIF
			String Doc = this.sPre + objCte.PERSONA_LT_LI_01B;
			int iDoc = objCte.PERSONA_MAX_TITULO - objCte.PERSONA_LT_LI_01B.length();
			if (this.objPersona.getCdgoTipodoc().intValue() == 2) // NIE
			{
				iDoc = objCte.PERSONA_MAX_TITULO - objCte.PERSONA_LT_LI_11B.length();
				Doc = this.sPre + objCte.PERSONA_LT_LI_11B;
			}
			if (this.objPersona.getCdgoTipodoc().intValue() == 3) // Pasaporte
			{
				iDoc = objCte.PERSONA_MAX_TITULO - objCte.PERSONA_LT_LI_21B.length();
				Doc = this.sPre + objCte.PERSONA_LT_LI_21B;
			}
			if (this.objPersona.getCdgoTipodoc().intValue() == 4) // Tarjeta de Residente UE
			{
				iDoc = objCte.PERSONA_MAX_TITULO - objCte.PERSONA_LT_LI_31B.length();
				Doc = this.sPre + objCte.PERSONA_LT_LI_31B;
			}
			if (this.objPersona.getCdgoTipodoc().intValue() == 5) // Tarjeta de Residente con permiso de trabajo
			{
				iDoc = objCte.PERSONA_MAX_TITULO - objCte.PERSONA_LT_LI_41B.length();
				Doc = this.sPre + objCte.PERSONA_LT_LI_41B;
			}

			this.SetLinea_001B(Doc);
			this.AddLinea_001B(new Util().getPuntos(iDoc));
			this.AddLinea_001B(this.objPersona.getDesgNifpas());

			// Matricula (Sale el texto siempre)
			this.SetLinea_001C(this.sPre);
			this.AddLinea_001C(objCte.PERSONA_LT_LI_01C);
			this.AddLinea_001C(new Util().getPuntos(objCte.PERSONA_MAX_TITULO - objCte.PERSONA_LT_LI_01C.length()));

			if (this.objPersona.getDesgMatricula() != null) {
				this.AddLinea_001C(this.objPersona.getDesgMatricula());
			}
		}
		// Fecha de nacimiento
		this.SetLinea_002((this.sPre + objCte.PERSONA_LT_LI_002));
		if (Accion) {
			int iB = objCte.PERSONA_MAX_TITULO - objCte.PERSONA_LT_LI_002.length();
			String Texto = TextFormat.format(this.objPersona.getFchaNacimiento());
			this.AddLinea_002((new Util().getPuntos(iB)));
			this.AddLinea_002(Texto);
		}

		// Direccion
		this.SetLinea_003((this.sPre + objCte.PERSONA_LT_LI_003));
		if (Accion) {
			int iB = objCte.PERSONA_MAX_TITULO - objCte.PERSONA_LT_LI_003.length();
			String Texto = this.objPersona.getDesgVia().trim() + " ";

			this.AddLinea_003((new Util().getPuntos(iB)));

			try {
				Tbasg107TipoviaDto objTV = this.tbasg107TipoviaService
						.findByCdgoTipovia(this.objPersona.getCdgoTipovia());
				this.AddLinea_003((objTV.getDesgNombre().trim() + " "));
			} catch (Exception Ex) {
				log.error("ERROR Obteniendo Tipo de Via en Modulo Imprimir", Ex.getMessage());
			}

			this.AddLinea_003(Texto);
			if (this.objPersona.getDesgNumvia() != null)
				this.AddLinea_003((this.objPersona.getDesgNumvia().trim() + " "));
			if (this.objPersona.getDesgPuerta() != null)
				this.AddLinea_003((this.objPersona.getDesgPuerta().trim() + " "));
			if (this.objPersona.getDesgEscalera() != null)
				this.AddLinea_003((this.objPersona.getDesgEscalera().trim() + " "));

			this.SetLinea_003B((this.sPre + new Util().getBlancos(objCte.PERSONA_MAX_TITULO)));
			this.AddLinea_003B((this.objPersona.getDesgMunicipio().trim()+ ", "));

			try {

				Tbasg106ProvinciaDto objP = this.tbasg106ProvinciaService
						.findByCdgoProvincia(this.objPersona.getCdgoProvincia().intValue());
				this.AddLinea_003B((objP.getDesgNombre().trim() + ", "));

			} catch (Exception Ex) {
				log.error("ERROR Obteniendo Provincia en Modulo Imprimir", Ex.getMessage());
			}

			this.SetLinea_003C((this.sPre + new Util().getBlancos(objCte.PERSONA_MAX_TITULO)));
			this.AddLinea_003C((this.objPersona.getDesgCodpostal().trim() + ", "));
			try {
				Tbasg134NacionDto objN = this.tbasg134NacionService
						.findByCdgoNacion(this.objPersona.getCdgoNacion().intValue());
				this.AddLinea_003C((objN.getDesgNombre().trim()));
			} catch (Exception Ex) {
				log.error("ERROR Obteniendo Nacion en Modulo Imprimir", Ex.getMessage());
			}
		}

		// Datos Laborales
		// Titulo
		this.SetLinea_000C(objCte.PERSONA_LT_LI_00C);
		// Contenido
		this.SetLinea_004((this.sPre + objCte.PERSONA_LT_LI_004));
		if (Accion) {
			int iB = objCte.PERSONA_MAX_TITULO - objCte.PERSONA_LT_LI_004.length();

			this.AddLinea_004((new Util().getPuntos(iB)));
			try {

				Tbasg105AreactiviDto objAA = this.tbasg105AreactiviService
						.findByCdgoAreact(this.objPersona.getCdgoAreact().intValue());
				this.AddLinea_004((objAA.getDesgNombre().trim()));
			} catch (Exception Ex) {
				log.error("ERROR Obteniendo Area de Actividad en Modulo Imprimir", Ex.getMessage());
			}
		}

		this.SetLinea_005((this.sPre + objCte.PERSONA_LT_LI_005));
		if (Accion) {
			int iB = objCte.PERSONA_MAX_TITULO - objCte.PERSONA_LT_LI_005.length();

			this.AddLinea_005((new Util().getPuntos(iB)));
			try {

				Tbasg135CargoDto objC = null;
				if (this.objPersona.getCdgoCargo() == null) // 999 - categoria sin definir

					objC = tbasg135CargoService.findByCdgoCargo("999");
				else
					objC = tbasg135CargoService.findByCdgoCargo(this.objPersona.getCdgoCargo());

				this.AddLinea_005((objC.getDesgNombre().trim()));
			} catch (Exception Ex) {
				log.error("ERROR Obteniendo Cargo en Modulo Imprimir", Ex.getMessage());

			}
		}

		if (this.objPersona.getFchaContrato() != null) {
			this.SetLinea_006((this.sPre + objCte.PERSONA_LT_LI_006));
			if (Accion) {
				int iB = objCte.PERSONA_MAX_TITULO - objCte.PERSONA_LT_LI_006.length();

				this.AddLinea_006((new Util().getPuntos(iB)));
				String Texto = TextFormat.format(this.objPersona.getFchaContrato());
				this.AddLinea_006(Texto);
			}
		}
	}

	public Tbasg100PersonaDto getObjPersona() {
		return objPersona;
	}

	public void setObjPersona(Tbasg100PersonaDto objPersona) {
		this.objPersona = objPersona;
	}
}
