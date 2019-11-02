package co.com.bancolombia.certificacion.app.questions.inversionvirtual;

import co.com.bancolombia.certificacion.app.models.entidades.CargarEntidadTransaccion;
import co.com.bancolombia.certificacion.app.models.transaccion.ConfiguracionTransaccion;
import co.com.bancolombia.certificacion.app.utilidades.xml.UtilidadXml;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class VerificarLaAperturaDeInversionVirtualXml implements Question<Boolean> {

	private static final Logger LOGGER = LogManager.getLogger(VerificarLaAperturaDeInversionVirtualXml.class.getName());
	private static String response="Response";
	
    @Override
    public Boolean answeredBy(Actor actor) {
    	
		boolean result = false;		
		UtilidadXml utilidadXml = new UtilidadXml();
		ConfiguracionTransaccion transaction = CargarEntidadTransaccion.getConfiguracionTransaccion();
		String strXMLCodObtenido = null;
		String strXMLMsgObtenido = null;
		String strNumInversion=null;
		
		try {
			strXMLCodObtenido = utilidadXml.leerXml(Serenity.sessionVariableCalled(response), "//STATUS/@CODE");
			strXMLMsgObtenido = utilidadXml.leerXml(Serenity.sessionVariableCalled(response), "//STATUS/@DESC");
			strNumInversion = utilidadXml.leerXml(Serenity.sessionVariableCalled(response), "//INVESTNUMBER");
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}

		if (strXMLCodObtenido != null && strXMLMsgObtenido != null && strNumInversion != null) {
			if (strXMLCodObtenido.equals(transaction.getCodigoError()) &&
					strXMLMsgObtenido.equals(transaction.getResultadoEsperado())) {
				result = true;
				Serenity.setSessionVariable("NumeroInversion").to(strNumInversion);
			}
		}else {LOGGER.info("Ruta relativa Xpath a buscar no se presenta en el response");}
		Serenity.recordReportData().withTitle("Response Apertura Inversion Virtual").andContents(Serenity.sessionVariableCalled(response));
		return result;
	}
    
}
