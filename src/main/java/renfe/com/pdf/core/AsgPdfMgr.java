package renfe.com.pdf.core;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;

import renfe.com.pdf.data.GetInformeAltaBajaAction;
import renfe.com.util.DownloadPdfCts;
import renfe.com.util.InformesAltaBajaPdfCts;

public class AsgPdfMgr {
	public AsgPdfMgr() {
		super();
	}

	public List getInformeAltaBajaBean(Date fecDesde, Date fecHasta, String altas, String bajas, String esMercancias,
			String sViajeros, String smercancias, String salquiler, String sOperadora, String sfabricac)
			throws InternalErrorException {

		List listPersonas = null;
		String strFecDesde = null;
		String strFecHasta = null;
		ArrayList sociedades = new ArrayList();

		SimpleDateFormat formato = new SimpleDateFormat(InformesAltaBajaPdfCts.FORMATO_FECHA);
		try {

			HashMap parametros = new HashMap();
			// Formateamos las fechas
			if (fecDesde != null && !"".equals(fecDesde)) {
				strFecDesde = formato.format(fecDesde);
			}
			if (fecHasta != null && !"".equals(fecHasta)) {
				strFecHasta = formato.format(fecHasta);
			}

			parametros.put(DownloadPdfCts.PARAMETER_FEC_DESDE, strFecDesde);
			parametros.put(DownloadPdfCts.PARAMETER_FEC_HASTA, strFecHasta);
			parametros.put(DownloadPdfCts.PARAMETER_ALTAS, altas);
			parametros.put(DownloadPdfCts.PARAMETER_BAJAS, bajas);
			parametros.put(DownloadPdfCts.PARAMETER_MERCANCIAS, esMercancias);

			if (sViajeros.equals("S")) {
				sociedades.add("1400");
			}
			if (smercancias.equals("S")) {
				sociedades.add("1500");
			}
			if (salquiler.equals("S")) {
				sociedades.add("1700");
			}
			if (sOperadora.equals("S")) {
				sociedades.add("1000");
			}
			if (sfabricac.equals("S")) {
				sociedades.add("1600");
			}

			if (!sociedades.isEmpty()) {
				parametros.put(DownloadPdfCts.PARAMETER_SOCIEDADES, sociedades);
			}

			GetInformeAltaBajaAction objGetActasActivasPersonaAction = new GetInformeAltaBajaAction(parametros);
			listPersonas = (ArrayList) objGetActasActivasPersonaAction.doExecute();
			System.out.println("El tamaño de la lista es " + listPersonas.size());

		} catch (Exception e) {

			throw new InternalErrorException(e);
		}

		return listPersonas;
	}
}
