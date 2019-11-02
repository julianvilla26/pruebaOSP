package co.com.bancolombia.certificacion.app.interactions.inversionvirtual;

import co.com.bancolombia.certificacion.app.models.entidades.CargarEntidadTransaccion;
import co.com.bancolombia.certificacion.app.models.entidades.CargarEntidadUsuario;
import co.com.bancolombia.certificacion.app.models.transaccion.ConfiguracionTransaccion;
import co.com.bancolombia.certificacion.app.models.usuario.Usuario;
import co.com.bancolombia.certificacion.app.utilidades.xml.UtilidadXml;
import co.com.bancolombia.certificacion.app.utilidades.constantes.AdministradorConstante;
import co.com.bancolombia.backend.utilidades.managers.DateManager;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static net.serenitybdd.screenplay.Tasks.instrumented;


public class PrepararYenviarConsultaTasasInversionVirtualXml implements Interaction{
	
	private static final Logger LOGGER = LogManager.getLogger(PrepararYenviarConsultaTasasInversionVirtualXml.class.getName());
	private static final UtilidadXml UTILIDAD_XML = new UtilidadXml();
	
	/**
	 * Prepare Transferencias Bancolombia Xml interaction.
	 *
	 * @return the interaction
	 */
	public static Interaction prepararYenviarXml() {
	    return instrumented(PrepararYenviarConsultaTasasInversionVirtualXml.class);
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		Usuario usuario = CargarEntidadUsuario.getUsuario();
		ConfiguracionTransaccion transaction = CargarEntidadTransaccion.getConfiguracionTransaccion();

		String strUrlXml = Serenity.sessionVariableCalled("UrlXml");
		String strRequest = UTILIDAD_XML.buscarXml(AdministradorConstante.CHANNEL_APP,
				transaction.getCodigoTransaccion());
		
		if (strRequest != null  ) {
			strRequest = strRequest.replace("_FECHA", DateManager.obtenerFechaSistema("YYYY/MM/dd"));
			strRequest = strRequest.replace("_TRNUID", DateManager.obtenerFechaSistema("yyyyMMddhhmmss"));
			strRequest = strRequest.replace("_SESSCOOKIE", AdministradorConstante.SESSCOOKIE);
			strRequest = strRequest.replace("_CLIENTID", usuario.getNumeroDocumento());
			Serenity.setSessionVariable("Request").to(strRequest);

			transaction.setHoraTransaccion(DateManager.obtenerFechaSistema("HHmmss"));
			String strResponse = UtilidadXml.enviarXml(strUrlXml, strRequest);
			Serenity.setSessionVariable("Response").to(strResponse);

			LOGGER.info("REQUEST Inversion Virtual Trn" + transaction.getCodigoTransaccion() +
					" \n" + strRequest + "\n");
			LOGGER.info("RESPONSE Inversion Virtual Trn" + transaction.getCodigoTransaccion() +
					" \n" + strResponse + "\n");
			
		}else {LOGGER.info("No se encontro el xml request parametrizado en la ruta");}

		Serenity.recordReportData().withTitle("Request Consulta de tasas").andContents(Serenity.sessionVariableCalled("Request"));
	}

}
