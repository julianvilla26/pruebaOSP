package co.com.bancolombia.certificacion.app.interactions.autenticacion;

import co.com.bancolombia.certificacion.app.models.entidades.CargarEntidadTransaccion;
import co.com.bancolombia.certificacion.app.models.entidades.CargarEntidadUsuario;
import co.com.bancolombia.certificacion.app.models.transaccion.ConfiguracionTransaccion;
import co.com.bancolombia.certificacion.app.models.usuario.Usuario;
import co.com.bancolombia.certificacion.app.utilidades.xml.UtilidadXml;
import co.com.bancolombia.certificacion.app.utilidades.constantes.AdministradorConstante;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import co.com.bancolombia.backend.utilidades.managers.DateManager;

public class PrepararYenviarAutenticacionXml implements Interaction{

	private static final Logger LOGGER = LogManager.getLogger(PrepararYenviarAutenticacionXml.class.getName());
	private static final UtilidadXml UTILIDAD_XML = new UtilidadXml();

	/**
	 * Prepare Authentication Xml interaction.
	 *
	 * @return the interaction
	 */
	public static Interaction prepararYenviarXml() {
	    return instrumented(PrepararYenviarAutenticacionXml.class);
	}

	@Override
	public <T extends Actor> void performAs(T actor) {

		Usuario usuario = CargarEntidadUsuario.getUsuario();
		ConfiguracionTransaccion transaction = CargarEntidadTransaccion.getConfiguracionTransaccion();
		String strUrlXml = "https://virtualesqa8.bancolombia.corp/APPQA8/OLBServlet";
		Serenity.setSessionVariable("UrlXml").to(strUrlXml);

		String strRequest = UTILIDAD_XML.buscarXml(AdministradorConstante.CHANNEL_SVP,
				AdministradorConstante.TRANSACTION_CODE_AUTHENTICATION);

		if (strRequest != null  ) {
			strRequest = strRequest.replace("_FECHA", DateManager.obtenerFechaSistema("YYYY/MM/dd"));
			strRequest = strRequest.replace("_TRNUID", DateManager.obtenerFechaSistema("yyyyMMddhhmmss"));
			strRequest = strRequest.replace("_SESSCOOKIE", "MHSB-7432-AJHF-9482");
			strRequest = strRequest.replace("_CLIENTID", usuario.getNumeroDocumento());
			strRequest = strRequest.replace("_CLAVE", usuario.getClave());
			Serenity.setSessionVariable("Request").to(strRequest);
			transaction.setHoraTransaccion(DateManager.obtenerFechaSistema("HHmmss"));
			String strResponse = UtilidadXml.enviarXml(strUrlXml, strRequest);
			Serenity.setSessionVariable("Response").to(strResponse);

			LOGGER.info("URL DE PRUEBAS \n" + strUrlXml + "\n");
			LOGGER.info("REQUEST Autenticacion Trn" + AdministradorConstante.TRANSACTION_CODE_AUTHENTICATION +
					" \n" + strRequest + "\n");
			LOGGER.info("RESPONSE Autenticacion Trn" + AdministradorConstante.TRANSACTION_CODE_AUTHENTICATION +
					" \n" + strResponse + "\n");
			
		}else {LOGGER.info("No se encontro el xml request parametrizado en la ruta");}
		Serenity.recordReportData().withTitle("Request Autenticacion").andContents(Serenity.sessionVariableCalled("Request"));
	}

}
