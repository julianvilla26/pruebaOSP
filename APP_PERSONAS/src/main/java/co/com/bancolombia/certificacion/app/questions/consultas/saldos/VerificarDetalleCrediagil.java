package co.com.bancolombia.certificacion.app.questions.consultas.saldos;

import co.com.bancolombia.certificacion.app.models.productos.Crediagil;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.bancolombia.certificacion.app.utilidades.constantes.ModeloConstantes.MODELO_CREDIAGIL;

public class VerificarDetalleCrediagil implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        Crediagil crediagil = actor.recall(MODELO_CREDIAGIL);
        return !"".equals(crediagil.getCupoDisponible()) &&
                !"".equals(crediagil.getCupoAsignado()) &&
                !"".equals(crediagil.getCupoUtilizado()) &&
                !"".equals(crediagil.getCupoCanje()) &&
                !"".equals(crediagil.getCupoDisponibleSobrecupo()) &&
                !"".equals(crediagil.getValorMaximoDesembolsar()) &&
                !"".equals(crediagil.getValorMinimoDesembolsar());
    }

    public static VerificarDetalleCrediagil exitoso() {
        return new VerificarDetalleCrediagil();
    }
}
