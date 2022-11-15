//PPM102758 - Certificado Complementario AOT
package renfe.com.util;

import java.awt.Color;
import java.net.URL;

import com.lowagie.text.Element;
import com.lowagie.text.Image;

public abstract class CertificadoComplementarioAOTPdfCts {

	// IMAGES
	/// LogoRenfe.jpg
	public static final String logo = "img/logo.jpg";
	/// SelloCert.jpg
	public static final String sello = "img/sello.jpg";
	/// SelloMerc.jpg
	public static final String selloMerc = "img/selloMerc.jpg";

	// DEFAULT VALUES
	public static final String DEFAULT_FONT_FAMILY = "Arial";
	public static final float DEFAULT_FONT_SIZE = 10;
	public static final int DEFAULT_ALIGNMENT = Element.ALIGN_JUSTIFIED;
	public static final Color COLOR_FONDO = new Color(220, 240, 241);
	public static final int NUMERO_ELEMENTOS_PAGINA = 23;

	public static final String DATE_NOT_FILL = "__________";

	// CTS BUNDLE
	public static final String BUNDLE_NAME = "locale/CertificadoComplementarioAOT";

	public static final String BUNDLE_CTS_0_1 = "certificadoComplementarioAOT.text.0_1";
	public static final String BUNDLE_CTS_0_2 = "certificadoComplementarioAOT.text.0_2";
	public static final String BUNDLE_CTS_0_3_0 = "certificadoComplementarioAOT.text.0_3_0";
	public static final String BUNDLE_CTS_0_3_1 = "certificadoComplementarioAOT.text.0_3_1";
	public static final String BUNDLE_CTS_0_3_2 = "certificadoComplementarioAOT.text.0_3_2";
	public static final String BUNDLE_CTS_0_4 = "certificadoComplementarioAOT.text.0_4";

	public static final String BUNDLE_CTS_1_0 = "certificadoComplementarioAOT.text.1_0";
	public static final String BUNDLE_CTS_1_1 = "certificadoComplementarioAOT.text.1_1";
	public static final String BUNDLE_CTS_1_2 = "certificadoComplementarioAOT.text.1_2";
	public static final String BUNDLE_CTS_1_3 = "certificadoComplementarioAOT.text.1_3";
	public static final String BUNDLE_CTS_1_4 = "certificadoComplementarioAOT.text.1_4";
	public static final String BUNDLE_CTS_1_5 = "certificadoComplementarioAOT.text.1_5";
	public static final String BUNDLE_CTS_1_6 = "certificadoComplementarioAOT.text.1_6";
	public static final String BUNDLE_CTS_1_7 = "certificadoComplementarioAOT.text.1_7";
	public static final String BUNDLE_CTS_1_8 = "certificadoComplementarioAOT.text.1_8";

	public static final String BUNDLE_CTS_2_0 = "certificadoComplementarioAOT.text.2_0";
	public static final String BUNDLE_CTS_2_0_x = "certificadoComplementarioAOT.text.2_0_x";
	public static final String BUNDLE_CTS_2_0_1 = "certificadoComplementarioAOT.text.2_0_1";
	public static final String BUNDLE_CTS_2_0_2 = "certificadoComplementarioAOT.text.2_0_2";
	public static final String BUNDLE_CTS_2_0_3 = "certificadoComplementarioAOT.text.2_0_3";
	public static final String BUNDLE_CTS_2_0_4 = "certificadoComplementarioAOT.text.2_0_4";
	public static final String BUNDLE_CTS_2_0_5 = "certificadoComplementarioAOT.text.2_0_5";
	public static final String BUNDLE_CTS_2_0_6 = "certificadoComplementarioAOT.text.2_0_6";
	public static final String BUNDLE_CTS_2_0_7 = "certificadoComplementarioAOT.text.2_0_7";
	public static final String BUNDLE_CTS_2_0_8 = "certificadoComplementarioAOT.text.2_0_8";
	public static final String BUNDLE_CTS_2_0_9 = "certificadoComplementarioAOT.text.2_0_9";
	public static final String BUNDLE_CTS_2_0_10 = "certificadoComplementarioAOT.text.2_0_10";
	public static final String BUNDLE_CTS_2_0_11 = "certificadoComplementarioAOT.text.2_0_11";
	public static final String BUNDLE_CTS_2_1 = "certificadoComplementarioAOT.text.2_1";
	public static final String BUNDLE_CTS_2_2_1 = "certificadoComplementarioAOT.text.2_2_1";
	public static final String BUNDLE_CTS_2_2_2 = "certificadoComplementarioAOT.text.2_2_2";
	public static final String BUNDLE_CTS_2_3 = "certificadoComplementarioAOT.text.2_3";
	public static final String SELLO = "image.sello";
}