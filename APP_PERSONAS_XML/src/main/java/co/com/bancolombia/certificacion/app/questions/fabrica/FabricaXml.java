package co.com.bancolombia.certificacion.app.questions.fabrica;

import co.com.bancolombia.certificacion.app.questions.autenticacion.VerificarLaAutenticacionXml;
import co.com.bancolombia.certificacion.app.questions.inversionvirtual.VerificarLaAperturaDeInversionVirtualXml;
import co.com.bancolombia.certificacion.app.questions.inversionvirtual.VerificarLaConsultaDeTasasDeInversionVirtualXml;
import co.com.bancolombia.certificacion.app.questions.inversionvirtual.VerificarLaSimulacionDeInversionVirtualXml;
import co.com.bancolombia.certificacion.app.questions.tarjetadecredito.VerificarLaConsultaDeCostoDeAvanceDeTarjetaXml;
import co.com.bancolombia.certificacion.app.questions.transferencias.VerificarLaTransferenciaBancolombiaXml;
import net.serenitybdd.screenplay.Question;

public class FabricaXml {

    private FabricaXml() {
    }
	
    /**
     * Verify result object Xml Authentication.
     *
     * @return the question
     */

    public static Question<Boolean> verificaElResultadoDeLaAuntenticacionPorXml() {
        return new VerificarLaAutenticacionXml();
    }
    
    /**
     * Verify result object Xml Transfers Bancolombia.
     *
     * @return the question
     */

    public static Question<Boolean> verificaElResultadoDeLaTransferenciaBancolombiaPorXml() {
        return new VerificarLaTransferenciaBancolombiaXml();
    }

    /**
     * Verify result object Xml Consult the rates virtual investmen.
     *
     * @return the question
     */

    public static Question<Boolean> verificaElResultadoDeLaConsultaDeTasasDeInversionVirtualPorXml() {
        return new VerificarLaConsultaDeTasasDeInversionVirtualXml();
    }

    /**
     * Verify result object Xml Opening virtual investmen.
     *
     * @return the question
     */

    public static Question<Boolean> verificaElResultadoDeLaAperturaDeInversionVirtualPorXml() {
        return new VerificarLaAperturaDeInversionVirtualXml();
    }


    /**
     * Verify result object Xml Simulate virtual investmen.
     *
     * @return the question
     */

    public static Question<Boolean> verificaElResultadoDelaSimulacionDeInversionVirtualPorXML() {
        return new VerificarLaSimulacionDeInversionVirtualXml();
    }

    /**
     * Verify result object Xml Consult the rates virtual investmen.
     *
     * @return the question
     */

    public static Question<Boolean> verificaElResultadoDeLaConsultaDeCostoDeAvanceDeTarjetaPorXml() {
        return new VerificarLaConsultaDeCostoDeAvanceDeTarjetaXml();
    }

}
