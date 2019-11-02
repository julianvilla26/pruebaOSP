package co.com.bancolombia.certificacion.app.questions.transferencias;

import co.com.bancolombia.certificacion.app.models.entidades.CargarEntidadTransaccion;
import co.com.bancolombia.certificacion.app.models.transaccion.ConfiguracionTransaccion;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import co.com.bancolombia.certificacion.app.utilidades.xml.UtilidadXml;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class VerificarLaTransferenciaBancolombiaXml implements Question<Boolean> {

	private static final Logger LOGGER = LogManager.getLogger(VerificarLaTransferenciaBancolombiaXml.class.getName());
	
    @Override
    public Boolean answeredBy(Actor actor) {
    	
		boolean result = false;		
		UtilidadXml utilidadXml = new UtilidadXml();
		ConfiguracionTransaccion transaction = CargarEntidadTransaccion.getConfiguracionTransaccion();
		String strXMLCodObtenido = null;
		String strXMLMsgObtenido = null;
		
		try {
			strXMLCodObtenido = utilidadXml.leerXml(Serenity.sessionVariableCalled("Response"), "//STATUS/@CODE");
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		
		try {
			strXMLMsgObtenido = utilidadXml.leerXml(Serenity.sessionVariableCalled("Response"), "//STATUS/@DESC");
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}

		if (strXMLCodObtenido != null && strXMLMsgObtenido != null) {
			if (strXMLCodObtenido.equals(transaction.getCodigoError()) &&
					strXMLMsgObtenido.equals(transaction.getResultadoEsperado())) {
				result = true;
			}
		}else {LOGGER.info("Ruta relativa Xpath a buscar no se presenta en el response");}
		
		return result;
	}
    
}
