package co.com.bancolombia.certificacion.app.questions.consultas;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

import static co.com.bancolombia.certificacion.app.userinterface.pages.consultas.saldos.SaldosMovimientosPage.LBL_SIN_MOVIMIENTOS;

public class VerificarProducto implements Question<Boolean> {
private String mensaje;

private VerificarProducto(String mensaje){
    this.mensaje=mensaje;
}

    @Override
    public Boolean answeredBy(Actor actor) {
        return Visibility.of(LBL_SIN_MOVIMIENTOS.of(mensaje)).viewedBy(actor).asBoolean();
    }

    public static VerificarProducto sinMovimientos(String mensaje) {
        return new VerificarProducto(mensaje);
    }
}