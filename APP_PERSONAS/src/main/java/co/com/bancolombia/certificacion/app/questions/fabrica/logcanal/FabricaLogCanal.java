package co.com.bancolombia.certificacion.app.questions.fabrica.logcanal;

import co.com.bancolombia.certificacion.app.questions.logcanal.*;
import net.serenitybdd.screenplay.Question;

public class FabricaLogCanal {

    private FabricaLogCanal() { }

    public static Question<Boolean> elLogCanal0369() {
        return new LogCanalParaTRN0369();
    }
    public static Question<Boolean> elLogCanal0360() {
        return new LogCanalParaTRN0360();
    }
    public static Question<Boolean> elLogCanal1756() { return new LogCanalParaTRN1756(); }
    public static Question<Boolean> elLogCanal0345() {
        return new LogCanalParaTRN0345();
    }
    public static Question<Boolean> elLogCanal0260() { return new LogCanalParaTRN0260(); }
    public static Question<Boolean> elLogCanal0410() {
        return new LogCanalParaTRN0410();
    }
    public static Question<Boolean> elLogCanal1228() { return new LogCanalParaTRN1228(); }
    public static Question<Boolean> elLogCanal0228() {return new  LogCanalParaTRN0228();}

}
