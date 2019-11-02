package co.com.bancolombia.certificacion.app.questions.fabrica;

import co.com.bancolombia.certificacion.app.questions.basededatos.iseries.autenticacion.ConsultarRegistroEnWWWFFUSRSV;
import co.com.bancolombia.certificacion.app.questions.basededatos.iseries.fondosdeinversion.ConsultarConsolidadoFiducias;
import co.com.bancolombia.certificacion.app.questions.basededatos.iseries.movimientos.ConsultarCreditoEnSCIFFMRCMV;
import co.com.bancolombia.certificacion.app.questions.basededatos.iseries.movimientos.ConsultarDebitoEnSCIFFMRCMV;
import co.com.bancolombia.certificacion.app.questions.basededatos.iseries.movimientos.ConsultarRegistroEnCABFFPPAUT;
import co.com.bancolombia.certificacion.app.questions.basededatos.iseries.saldos.*;
import co.com.bancolombia.certificacion.app.questions.basededatos.iseries.tarjetas.ConsultarEprepagoEnCABFFTARJ;
import co.com.bancolombia.certificacion.app.questions.basededatos.iseries.tarjetas.ConsultarRegistroEnCABFFPPMAE;
import co.com.bancolombia.certificacion.app.questions.basededatos.iseries.tarjetas.ConsultarRegistroEnTCBFFMAE;
import co.com.bancolombia.certificacion.app.questions.basededatos.iseries.terminos.ConsultarRegistroEnWWWFFLGTYC;
import co.com.bancolombia.certificacion.app.questions.basededatos.iseries.transversal.ConsultarCreditoEnMOVTFLOGTF;
import co.com.bancolombia.certificacion.app.questions.basededatos.iseries.transversal.ConsultarDebitoEnMOVTFLOGTF;
import co.com.bancolombia.certificacion.app.questions.basededatos.iseries.transversal.ConsultarRegistroEnPCCFFPPCLI;
import net.serenitybdd.screenplay.Question;


public class FabricaBaseDeDatosIseries {

    private FabricaBaseDeDatosIseries() { }

    public static Question<Boolean> elArchivoEnIseriesPCCFFPPCLI() {
        return new ConsultarRegistroEnPCCFFPPCLI();
    }
    public static Question<Boolean> elArchivoEnIseriesCABFFTARJ() {
        return new ConsultarEprepagoEnCABFFTARJ();
    }
    public static Question<Boolean> elArchivoEnIseriesWWWFFUSRSV() {
        return new ConsultarRegistroEnWWWFFUSRSV();
    }
    public static Question<Boolean> elArchivoEnIseriesTERMCONDITION() {
        return new ConsultarRegistroEnWWWFFLGTYC();
    }
    public static Question<Boolean> elArchivoEnIseriesCABFFPPMAE() {
        return new ConsultarRegistroEnCABFFPPMAE();
    }
    public static Question<Boolean> elArchivoEnIseriesSCIFFSALDOdebit() {
        return new ConsultarDebitoEnSCIFFSALDO();
    }
    public static Question<Boolean> elArchivoEnIseriesSCIFFSALDOcredit() {
        return new ConsultarCreditoEnSCIFFSALDO();
    }
    public static Question<Boolean> elArchivoEnIseriesTCBFFMAE() {
        return new ConsultarRegistroEnTCBFFMAE();
    }
    public static Question<Boolean> elArchivoEnIseriesSCIFFMRCMVdebit() {
        return new ConsultarDebitoEnSCIFFMRCMV();
    }
    public static Question<Boolean> elArchivoEnIseriesSCIFFMRCMVcredit() {
        return new ConsultarCreditoEnSCIFFMRCMV();
    }
    public static Question<Boolean> elArchivoEnIseriesCABFFPPAUT() {
        return new ConsultarRegistroEnCABFFPPAUT();
    }
    public static Question<Boolean> elArchivoEnIseriesPCCMOVTFLOGTFdebit() {
        return new ConsultarDebitoEnMOVTFLOGTF();
    }
    public static Question<Boolean> elArchivoEnIseriesPCCMOVTFLOGTFcredit() { return new ConsultarCreditoEnMOVTFLOGTF(); }
    public static Question<Boolean> elArchivoEnIseriesSCIFFSALDOdetalle() { return new ConsultarDetalleDepositos(); }
    public static Question<Boolean> elArchivoEnIseriesSCIFFSALDOConsolidado() { return new ConsultarConsolidadoDepositos(); }
    public static Question<Boolean> elArchivoEnIseriesCXREFCNAMELMBALconsultaSaldoCreditos() {return new ConsultarSaldosConsolidadosCreditos(); }
    public static Question<Boolean> elArchivoEnIseriesPCCFFLOGTFtarjetasCredito(){return new ConsultarConsolidadoTarjetasCredito();}
    public static Question<Boolean> elArchivoEnIseriesCXREFCNAMEtarjetasCredito(){return new ConsultarPertenenciaTarjetasCredito();}
    public static Question<Boolean> elArchivoEnIseriesENCARC() { return new ConsultarConsolidadoFiducias(); }
    public static Question<Boolean> elArchivoEnIseriesCABFFTARJeprepago() { return new ConsultarEprepagoEnCABFFTARJ(); }
}
