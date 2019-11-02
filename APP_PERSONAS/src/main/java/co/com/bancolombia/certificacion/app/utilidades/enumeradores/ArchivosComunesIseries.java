package co.com.bancolombia.certificacion.app.utilidades.enumeradores;

import co.com.bancolombia.certificacion.app.exceptions.productos.AfirmacionDelProducto;
import co.com.bancolombia.certificacion.app.questions.fabrica.FabricaBaseDeDatosIseries;
import net.serenitybdd.screenplay.Question;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public enum ArchivosComunesIseries {

    SCIFFSALDO_DEBITO(FabricaBaseDeDatosIseries.elArchivoEnIseriesSCIFFSALDOdebit(), AfirmacionDelProducto.class, AfirmacionDelProducto.NO_FUNCIONA),
    SCIFFSALDO_CREDITO(FabricaBaseDeDatosIseries.elArchivoEnIseriesSCIFFSALDOcredit(), AfirmacionDelProducto.class, AfirmacionDelProducto.NO_FUNCIONA),
    CABFFPPAUT(FabricaBaseDeDatosIseries.elArchivoEnIseriesCABFFPPAUT(), AfirmacionDelProducto.class, AfirmacionDelProducto.NO_FUNCIONA),
    PCCFFPPCLI(FabricaBaseDeDatosIseries.elArchivoEnIseriesPCCFFPPCLI(), AfirmacionDelProducto.class, AfirmacionDelProducto.NO_FUNCIONA),
    CABFFTARJ(FabricaBaseDeDatosIseries.elArchivoEnIseriesCABFFTARJ(), AfirmacionDelProducto.class, AfirmacionDelProducto.NO_FUNCIONA),
    WWWFFUSRSV(FabricaBaseDeDatosIseries.elArchivoEnIseriesWWWFFUSRSV(), AfirmacionDelProducto.class, AfirmacionDelProducto.NO_FUNCIONA),
    TERMCONDITION(FabricaBaseDeDatosIseries.elArchivoEnIseriesTERMCONDITION(), AfirmacionDelProducto.class, AfirmacionDelProducto.NO_FUNCIONA),
    CABFFPPMAE(FabricaBaseDeDatosIseries.elArchivoEnIseriesCABFFPPMAE(), AfirmacionDelProducto.class, AfirmacionDelProducto.NO_FUNCIONA),
    TCBFFMAE(FabricaBaseDeDatosIseries.elArchivoEnIseriesTCBFFMAE(), AfirmacionDelProducto.class, AfirmacionDelProducto.NO_FUNCIONA),
    SCIFFMRCMV_DEBITO(FabricaBaseDeDatosIseries.elArchivoEnIseriesSCIFFMRCMVdebit(), AfirmacionDelProducto.class, AfirmacionDelProducto.NO_FUNCIONA),
    SCIFFMRCMV_CREDITO(FabricaBaseDeDatosIseries.elArchivoEnIseriesSCIFFMRCMVcredit(), AfirmacionDelProducto.class, AfirmacionDelProducto.NO_FUNCIONA),
    PCCFFMOVTFLOGTF_DEBITO(FabricaBaseDeDatosIseries.elArchivoEnIseriesPCCMOVTFLOGTFdebit(), AfirmacionDelProducto.class, AfirmacionDelProducto.NO_FUNCIONA),
    PCCFFMOVTFLOGTF_CREDITO(FabricaBaseDeDatosIseries.elArchivoEnIseriesPCCMOVTFLOGTFcredit(), AfirmacionDelProducto.class, AfirmacionDelProducto.NO_FUNCIONA),
    SCIFFSALDO_DETALLE(FabricaBaseDeDatosIseries.elArchivoEnIseriesSCIFFSALDOdetalle(), AfirmacionDelProducto.class, AfirmacionDelProducto.NO_FUNCIONA),
    SCIFFSALDO_CONSOLIDADO(FabricaBaseDeDatosIseries.elArchivoEnIseriesSCIFFSALDOConsolidado(), AfirmacionDelProducto.class, AfirmacionDelProducto.NO_FUNCIONA),
    CXREF_CNAME_LMBAL_SALDO_CREDITOS(FabricaBaseDeDatosIseries.elArchivoEnIseriesCXREFCNAMELMBALconsultaSaldoCreditos(), AfirmacionDelProducto.class, AfirmacionDelProducto.NO_FUNCIONA),
    PCCFFLOGTF_TDCCONSOLIDADO(FabricaBaseDeDatosIseries.elArchivoEnIseriesPCCFFLOGTFtarjetasCredito(), AfirmacionDelProducto.class, AfirmacionDelProducto.NO_FUNCIONA),
    CXREF_CNAME_CONSOLIDADOTDC(FabricaBaseDeDatosIseries.elArchivoEnIseriesCXREFCNAMEtarjetasCredito(), AfirmacionDelProducto.class, AfirmacionDelProducto.NO_FUNCIONA),
    ENCARC(FabricaBaseDeDatosIseries.elArchivoEnIseriesENCARC(), AfirmacionDelProducto.class, AfirmacionDelProducto.NO_FUNCIONA),
    CABFFTARJ_EPREPAGO(FabricaBaseDeDatosIseries.elArchivoEnIseriesCABFFTARJeprepago(), AfirmacionDelProducto.class, AfirmacionDelProducto.NO_FUNCIONA),

    ;

    private static final Logger LOGGER = LogManager.getLogger();

    Question<Boolean> question;
    Class clase;
    String mensaje;

    ArchivosComunesIseries(Question<Boolean> question, Class clase, String mensaje) {
        this.question = question;
        this.clase = clase;
        this.mensaje = mensaje;
    }

    public static ArchivosComunesIseries getSearchFile(String nombre) {

        ArchivosComunesIseries[] lista = ArchivosComunesIseries.values();
        boolean existe = Arrays.stream(lista).anyMatch(x -> x.name().equalsIgnoreCase(nombre));
        if (!existe) {
            LOGGER.error(new RuntimeException("".concat(nombre) + "'s question not exits"));
        }
        return ArchivosComunesIseries.valueOf(nombre);
    }

    public Question<Boolean> delArchivo() {
        return question;
    }

    public Class<AssertionError> getException() {
        return clase;
    }

    public String getMessage() {
        return mensaje;
    }
}
