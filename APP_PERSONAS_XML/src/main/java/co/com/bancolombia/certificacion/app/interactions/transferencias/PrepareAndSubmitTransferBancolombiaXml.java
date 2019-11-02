package co.com.bancolombia.certificacion.app.interactions.transferencias;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import co.com.bancolombia.certificacion.app.models.entidades.CargarEntidadTransferencias;
import co.com.bancolombia.certificacion.app.models.entidades.CargarEntidadTransaccion;
import co.com.bancolombia.certificacion.app.models.entidades.CargarEntidadUsuario;
import co.com.bancolombia.certificacion.app.models.transaccion.ConfiguracionTransaccion;
import co.com.bancolombia.certificacion.app.models.transaccion.Transferencias;
import co.com.bancolombia.certificacion.app.models.usuario.Usuario;
import co.com.bancolombia.certificacion.app.utilidades.xml.UtilidadXml;
import co.com.bancolombia.certificacion.app.utilidades.administradores.AdministradorUtilidades;
import co.com.bancolombia.certificacion.app.utilidades.constantes.AdministradorConstante;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import co.com.bancolombia.backend.utilidades.managers.DateManager;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;


public class PrepareAndSubmitTransferBancolombiaXml implements Interaction{
	
	private static final Logger LOGGER = LogManager.getLogger(PrepareAndSubmitTransferBancolombiaXml.class.getName());
	private static final UtilidadXml UTILIDAD_XML = new UtilidadXml();
	
	/**
	 * Prepare Transferencias Bancolombia Xml interaction.
	 *
	 * @return the interaction
	 */
	public static Interaction prepareAndSubmitXml() {
	    return instrumented(PrepareAndSubmitTransferBancolombiaXml.class);
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		Usuario usuario = CargarEntidadUsuario.getUsuario();
		ConfiguracionTransaccion transaction = CargarEntidadTransaccion.getConfiguracionTransaccion();
		Transferencias transferencia = CargarEntidadTransferencias.getTransferencias();

		String strUrlXml = Serenity.sessionVariableCalled("UrlXml");
		String strRequest = UTILIDAD_XML.buscarXml(AdministradorConstante.CHANNEL_SVP,
				transaction.getCodigoTransaccion());
		
		if (strRequest != null  ) {
			strRequest = strRequest.replace("_FECHA", DateManager.obtenerFechaSistema("YYYY/MM/dd"));
			strRequest = strRequest.replace("_TRNUID", DateManager.obtenerFechaSistema("yyyyMMddhhmmss"));
			strRequest = strRequest.replace("_SESSCOOKIE", AdministradorConstante.SESSCOOKIE);
			strRequest = strRequest.replace("_CLIENTID", usuario.getNumeroDocumento());
			strRequest = strRequest.replace("CtaOrigen", AdministradorUtilidades.formatoCuentaDeposito(String.valueOf(transferencia.getOriginProduct().getNumero())));
			strRequest = strRequest.replace("TipOrigen", AdministradorUtilidades.formatoTipoCuentaNumero(transferencia.getOriginProduct().getTipo()));
			strRequest = strRequest.replace("CtaDestino", AdministradorUtilidades.formatoCuentaDeposito(String.valueOf(transferencia.getDestinationProduct().getNumero())));
			strRequest = strRequest.replace("TipDestino", AdministradorUtilidades.formatoTipoCuentaNumero(transferencia.getDestinationProduct().getTipo()));
			strRequest = strRequest.replace("ValorTransferir", transferencia.getAmount() + ".00");
			Serenity.setSessionVariable("Request").to(strRequest);
			

			transaction.setHoraTransaccion(DateManager.obtenerFechaSistema("HHmmss"));
			String strResponse = UtilidadXml.enviarXml(strUrlXml, strRequest);
			Serenity.setSessionVariable("Response").to(strResponse);

			LOGGER.info("REQUEST Tranferencias Bancolombia Trn" + transaction.getCodigoTransaccion() +
					" \n" + strRequest + "\n");
			LOGGER.info("RESPONSE Tranferencias Bancolombia Trn" + transaction.getCodigoTransaccion() +
					" \n" + strResponse + "\n");
			
		}else {LOGGER.info("No se encontro el xml request parametrizado en la ruta");}
		
	}

}
