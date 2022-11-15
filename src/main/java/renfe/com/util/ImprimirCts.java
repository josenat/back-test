package renfe.com.util;

import com.lowagie.text.Element;

public class ImprimirCts {

    // DEFAULT VALUES
    public final String DEFAULT_FONT_FAMILY = "Courier";
    public final float DEFAULT_FONT_SIZE = 10;
    public final int DEFAULT_ALIGNMENT = Element.ALIGN_JUSTIFIED;
    
    public final String DATE_NOT_FILL = "__________";
   
    public final float FONT_SIZE_TITULO = 14;
    public final float FONT_SIZE_BASE   = 10;

    //CTS Generales
    public final int    PERSONA_MAX_TITULO     = this.PSICOFISICO_LT_LI_001.length() + 2;
    public final int    MAX_LINEAS_PAG         = 47; // Son 47 si hay otra cosa = pruebas
    public final int    MAX_CC_LINEA           = 57; // Son 57 si hay otra cosa = pruebas
                                                     // Es mayor o menor dependiendo de PERSONA_MAX_TITULO

    // CTS Titulo
    public final String PERSONA_LT_LI_000  = "Dossier de Personal ";

    // CTS Persona
    public final String PERSONA_LT_LI_00B      = "Datos Identificativos";
    public final String PERSONA_LT_LI_001      = "D./Dña.: ";
    public final String PERSONA_LT_LI_01B      = "NIF: ";
    public final String PERSONA_LT_LI_11B      = "NIE: ";
    public final String PERSONA_LT_LI_21B      = "Pasaporte: ";
    public final String PERSONA_LT_LI_31B      = "Tj. Res. UE: ";
    public final String PERSONA_LT_LI_41B      = "Tj. R/PT: ";
    public final String PERSONA_LT_LI_01C      = "Matrícula: ";
    public final String PERSONA_LT_LI_002      = "F.Nacimiento: ";
    public final String PERSONA_LT_LI_003      = "Domicilio: ";
    public final String PERSONA_LT_LI_00C      = "Datos Laborales";
    public final String PERSONA_LT_LI_004      = "Área Actividad: ";
    public final String PERSONA_LT_LI_005      = "Cargo Oficial: ";
    public final String PERSONA_LT_LI_006      = "F.Contratación: ";
    
    //CTS Certificado Psicofisico
    public final String PSICOFISICO_LT_LI_000  = "Certifícado Psicofísico";
    public final String PSICOFISICO_LT_LI_00B  = "No posee Certifícado Psicofísico Valido y Activo";
    public final String PSICOFISICO_LT_LI_001  = "F.Recon./F.Rev./Motivo: ";
    public final String PSICOFISICO_LT_LI_002  = "Calificación: ";
    public final String PSICOFISICO_LT_LI_003  = "Ámbito de Validez: ";
    public final String PSICOFISICO_LT_LI_004  = "Centro/Facultativo: ";
    
    public final String PSICOFISICO_LT_LI_A04  = "Sin Centro Médico";
    public final String PSICOFISICO_LT_LI_A14  = "Sin Facultativo";

    //CTS Titulo de Conduccion
    public final String TITULOCON_LT_LI_000    = "Licencia De Conducción";
    public final String TITULOCON_LT_LI_001    = "Licencia Conducción: ";
// IGC Rmdy 43521, Relacionado con 5511
    public final String TITULOCON_LT_LI_002    = "Fecha de Obtención: ";
// IGC Rmdy 43521, Relacionado con 5511
    
    //CTS Formacion
    public final String FORMACION_LT_LI_000    = "Formación";
    public final String FORMACION_LT_LI_001    = "Curso: "; //Codigo + descripcion
    public final String FORMACION_LT_LI_002    = " Expediente/Fecha: ";
    public final String FORMACION_LT_LI_003    = " Tipo/Calificación: ";
    public final String FORMACION_LT_LI_004    = " Centro/Instructor: ";
 
    public final String FORMACION_LT_LI_A01    = "Sin Expediente";
    public final String FORMACION_LT_LI_A02    = "Sin Fecha";
    public final String FORMACION_LT_LI_A03    = "Calificación NO Encontrada";
    public final String FORMACION_LT_LI_A04    = "Sin Centro";
    public final String FORMACION_LT_LI_A05    = "Sin Instructor";
    public final String FORMACION_LT_LI_A06    = "Tipo de curso S/C";
    
    //CTS Expedientes
    public final String EXPEDIENTES_LT_LI_000    = "Expedientes";
    public final String EXPEDIENTES_LT_LI_001    = "Expediente: "; // Codigo + Tipo
    public final String EXPEDIENTES_LT_LI_002    = " Estado/F.Estado: ";
    public final String EXPEDIENTES_LT_LI_003    = "  Alcance: ";
    public final String EXPEDIENTES_LT_LI_004    = "  Ámbito: ";
    public final String EXPEDIENTES_LT_LI_005    = "  Empresa: ";
    
    public final String EXPEDIENTES_LT_LI_A01    = "No Encontrado";
    public final String EXPEDIENTES_LT_LI_A02    = "Sin Estados Activos";
    public final String EXPEDIENTES_LT_LI_A03    = "Error en BBBDD";
    public final String EXPEDIENTES_LT_LI_A04    = " - SubSerie: ";
    
    
  //CTS Suspensiones
    public final String EXPEDIENTES_LT_LI_S00    = "  Suspensión";
    public final String EXPEDIENTES_LT_LI_S01    = "Desde "; 
    public final String EXPEDIENTES_LT_LI_S02    = " Hasta ";
    public final String EXPEDIENTES_LT_LI_S11    = " No existe";
    
    //CTS Formacion Complementaria
    public final String FORMACCOMPLEMENT_LT_LI_000	= "Formación Complementaria";
    public final String FORMACCOMPLEMENT_LT_LI_00B  = "No posee formación complementaria";
    public final String FORMACCOMPLEMENT_LT_LI_001	= "Categoría: ";
    public final String FORMACCOMPLEMENT_LT_LI_002	= "Cualificación: ";	
    public final String FORMACCOMPLEMENT_LT_LI_003	= "Fecha de realización: ";
    public final String FORMACCOMPLEMENT_LT_LI_004	= "Observaciones: ";
    
    public final String FORMACCOMPLEMENT_LT_LI_A01	= "Sin observaciones";
    
    public final int EXPEDIENTE_SUSPENSION  = 3;
    public final int EXPEDIENTE_SUSPENSION_CAUTELAR  = 20;
    public final int EXPEDIENTE_REACTIVACION  = 7;
    
  
    
    
    
    public ImprimirCts() {}
}
