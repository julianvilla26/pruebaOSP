package co.com.bancolombia.certificacion.app.questions.fabrica;

import co.com.bancolombia.certificacion.app.questions.basededatos.logcanal.*;
import net.serenitybdd.screenplay.Question;

/**
 * The type Data base fabrica.
 */
public class FabricaLogCanal {

    private FabricaLogCanal() {
    }

    /**
     * Verify channel log question TRN0322.
     *
     * @return the question
     */
    public static Question<Boolean> elLogCanal0369() { return new LogCanalParaTRN0369();}

    /**
     * Verify channel log question TRN0322.
     *
     * @return the question
     */
    public static Question<Boolean> elLogCanal0322() { return new LogCanalParaTRN0322();}

    /**
     * Verify channel log question TRN0325.
     *
     * @return the question
     */
    public static Question<Boolean> elLogCanal0325() {return new LogCanalParaTRN0325();
    }

    /**
     * Verify channel log question TRN0326.
     *
     * @return the question
     */
    public static Question<Boolean> elLogCanal0326() { return new LogCanalParaTRN0326();}

    /**
     * Verify channel log question TRN0326.
     *
     * @return the question
     */
    public static Question<Boolean> elLogCanal0533() { return new LogCanalParaTRN0533();}



}
