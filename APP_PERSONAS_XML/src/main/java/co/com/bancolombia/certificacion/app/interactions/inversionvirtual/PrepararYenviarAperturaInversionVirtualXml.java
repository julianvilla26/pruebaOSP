package co.com.bancolombia.certificacion.app.interactions.inversionvirtual;

import co.com.bancolombia.backend.utilidades.managers.DateManager;
import co.com.bancolombia.certificacion.app.models.entidades.*;
import co.com.bancolombia.certificacion.app.models.productos.CuentaDeposito;
import co.com.bancolombia.certificacion.app.models.productos.InversionVirtual;
import co.com.bancolombia.certificacion.app.models.transaccion.ConfiguracionTransaccion;
import co.com.bancolombia.certificacion.app.models.transaccion.TerminosCondiciones;
import co.com.bancolombia.certificacion.app.models.usuario.Usuario;
import co.com.bancolombia.certificacion.app.utilidades.xml.UtilidadXml;
import co.com.bancolombia.certificacion.app.utilidades.administradores.AdministradorUtilidades;
import co.com.bancolombia.certificacion.app.utilidades.constantes.AdministradorConstante;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static net.serenitybdd.screenplay.Tasks.instrumented;


public class PrepararYenviarAperturaInversionVirtualXml implements Interaction{
	
	private static final Logger LOGGER = LogManager.getLogger(PrepararYenviarAperturaInversionVirtualXml.class.getName());
	private static final UtilidadXml UTILIDAD_XML = new UtilidadXml();
	
	/**
	 * Prepare Transferencias Bancolombia Xml interaction.
	 *
	 * @return the interaction
	 */
	public static Interaction prepararYenviarXml() {
	    return instrumented(PrepararYenviarAperturaInversionVirtualXml.class);
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		Usuario usuario = CargarEntidadUsuario.getUsuario();
		ConfiguracionTransaccion transaction = CargarEntidadTransaccion.getConfiguracionTransaccion();
		CuentaDeposito depositos = CargarEntidadDepositos.getCuentaDeposito();
		InversionVirtual virtualInvestment = CargarEntidadInversionVirtual.getVirtualInvestment();
		TerminosCondiciones terminosCondiciones = CargarEntidadTerminos.getTermsAndConditions();

		String strUrlXml = Serenity.sessionVariableCalled("UrlXml");
		String strRequest = UTILIDAD_XML.buscarXml(AdministradorConstante.CHANNEL_APP,
				transaction.getCodigoTransaccion());
		
		if (strRequest != null  ) {
			strRequest = strRequest.replace("_FECHA", DateManager.obtenerFechaSistema("YYYY/MM/dd"));
			strRequest = strRequest.replace("_TRNUID", DateManager.obtenerFechaSistema("yyyyMMddhhmmss"));
			strRequest = strRequest.replace("_SESSCOOKIE", AdministradorConstante.SESSCOOKIE);
			strRequest = strRequest.replace("_CLIENTID", usuario.getNumeroDocumento());

			strRequest = strRequest.replace("_Cuenta", AdministradorUtilidades.formatoCuentaDeposito(depositos.getNumero()));
			strRequest = strRequest.replace("_TipoCuenta", AdministradorUtilidades.formatoTipoCuentaNumero(depositos.getTipo()));

			strRequest = strRequest.replace("_Valor", CargarEntidadTransferencias.getTransferencias().getAmount() + ".00");
			strRequest = strRequest.replace("_Periodicidad", virtualInvestment.getPeriodicityPaymentInterest());
			strRequest = strRequest.replace("_Plazo", virtualInvestment.getDaysTerm());
			strRequest = strRequest.replace("_TasaEfectiva", virtualInvestment.getAnnualEffectiveRate());

			strRequest = strRequest.replace("_VersionTerminos", terminosCondiciones.getVersionTermCond());

			Serenity.setSessionVariable("Request").to(strRequest);

			transaction.setHoraTransaccion(DateManager.obtenerFechaSistema("HHmmss"));
			String strResponse = UtilidadXml.enviarXml(strUrlXml, strRequest);
			Serenity.setSessionVariable("Response").to(strResponse);

			LOGGER.info("REQUEST Opening Inversion Virtual Trn" + transaction.getCodigoTransaccion() +
					" \n" + strRequest + "\n");
			LOGGER.info("RESPONSE Opening Inversion Virtual Trn" + transaction.getCodigoTransaccion() +
					" \n" + strResponse + "\n");
			
		}else {LOGGER.info("No se encontro el xml request parametrizado en la ruta");}
		Serenity.recordReportData().withTitle("Request Apertura Inversion Virtual").andContents(Serenity.sessionVariableCalled("Request"));
	}

}
