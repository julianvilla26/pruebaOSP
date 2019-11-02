package co.com.bancolombia.certificacion.app.questions.fabrica;

import co.com.bancolombia.certificacion.app.questions.basededatos.iseries.*;
import net.serenitybdd.screenplay.Question;

/**
 * The type Data base fabrica.
 */
public class FabricaBaseDeDatosIseries {

    private FabricaBaseDeDatosIseries() {
    }

    /**
     * Verify if the object returns records.
     *
     * @return the question
     */
    public static Question<Boolean> elArchivoEnIseriesPCCFFPPCLI() { return new ConsultarRegistroEnPCCFFPPCLI(); }

    /**
     * Verify if the object returns records.
     *
     * @return the question
     */
    public static Question<Boolean> elArchivoEnIseriesCABFFTARJ() {
        return new ConsultarRegistroEnCABFFTARJ();
    }

    /**
     * Verify result object wwwffusrsv question.
     *
     * @return the question
     */
    public static Question<Boolean> elArchivoEnIseriesWWWFFUSRSV() {
        return new ConsultarRegistroEnWWWFFUSRSV();
    }

    /**
     * Verify result object terminos y condiciones .
     *
     * @return the question
     */

    public static Question<Boolean> elArchivoEnIseriesTERMCONDITION() {
        return new ConsultarRegistroEnWWWFFLGTYC();
    }

    /**
     * Verify result object CABFFPPMAE question.
     *
     * @return the question
     */
    public static Question<Boolean> elArchivoEnIseriesCABFFPPMAE() {return new ConsultarRegistroEnCABFFPPMAE();}

    /**
     * Verify result debit SCIFFSALDO question.
     *
     * @return the question
     */
    public static Question<Boolean> elArchivoEnIseriesSCIFFSALDOdebit() {return new ConsultarDebitoEnSCIFFSALDO();}

    /**
     * Verify result debit SCIFFSALDO question.
     *
     * @return the question
     */
    public static Question<Boolean> elArchivoEnIseriesSCIFFSALDOcredit() {return new ConsultarCreditoEnSCIFFSALDO();}

    /**
     * Verify result debit TCBFFMAE question.
     *
     * @return the question
     */
    public static Question<Boolean> elArchivoEnIseriesTCBFFMAE() {return new ConsultarRegistroEnTCBFFMAE();}
    /**
     * Verify result object SCIFFMRCMV question.
     *
     * @return the question
     */
    public static Question<Boolean> elArchivoEnIseriesSCIFFMRCMVdebit() {return new ConsultarDebitoEnSCIFFMRCMV();}
    /**
     * Verify result object SCIFFMRCMV question.
     *
     * @return the question
     */
    public static Question<Boolean> elArchivoEnIseriesSCIFFMRCMVcredit() {return new ConsultarCreditoEnSCIFFMRCMV();}
    /**
     * Verify result object CABFFPPAUT question.
     *
     * @return the question
     */
    public static Question<Boolean> elArchivoEnIseriesCABFFPPAUT() {return new ConsultarRegistroEnCABFFPPAUT();}
    /**
     * Verify result object pccmovtflogtf question.
     *
     * @return the question
     */
    public static Question<Boolean> elArchivoEnIseriesPCCMOVTFLOGTFdebit() { return new ConsultarDebitoEnMOVTFLOGTF(); }
    /**
     * Verify result object pccmovtflogtf question.
     *
     * @return the question
     */
    public static Question<Boolean> elArchivoEnIseriesPCCMOVTFLOGTFcredit() { return new ConsultarCreditoEnMOVTFLOGTF(); }


}
