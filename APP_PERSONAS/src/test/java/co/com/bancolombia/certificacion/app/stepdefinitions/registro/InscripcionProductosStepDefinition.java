package co.com.bancolombia.certificacion.app.stepdefinitions.registro;

import co.com.bancolombia.certificacion.app.exceptions.inscripcion.NoSeInscribioProductoException;
import co.com.bancolombia.certificacion.app.exceptions.inscripcion.ProductoPenditeteActivacionException;
import co.com.bancolombia.certificacion.app.questions.registro.VerificarInscripcion;
import co.com.bancolombia.certificacion.app.questions.registro.VerificarInscripcionExistente;
import co.com.bancolombia.certificacion.app.tasks.registro.InscribirProductos;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;

import java.util.List;

import static co.com.bancolombia.certificacion.app.exceptions.inscripcion.NoSeInscribioProductoException.PRODUCTO_NO_INSCRITO;
import static co.com.bancolombia.certificacion.app.exceptions.inscripcion.ProductoPenditeteActivacionException.NO_RECONOCE_PRODUCTO_PENDIENTE_ACTIVACION;
import static co.com.bancolombia.certificacion.app.models.builders.InscripcionBuilder.inscripcionProductos;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class InscripcionProductosStepDefinition {

    @Cuando("quiero realizar la inscripcion del producto con la informacion$")
    public void quieroRealizarInscripcionProductosConInformacion(List<String> datos) {
        theActorInTheSpotlight().attemptsTo(InscribirProductos.conInformacion(inscripcionProductos(datos)));
    }

    @Cuando("el deberia de mensaje (.*)$")
    public void quieroRealizarInscripcionProductos(String mensaje) {
        theActorInTheSpotlight().should(seeThat(VerificarInscripcionExistente.deProductos(mensaje)).orComplainWith(ProductoPenditeteActivacionException.class,NO_RECONOCE_PRODUCTO_PENDIENTE_ACTIVACION));
    }

    @Entonces("el deberia de ver el detalle del producto registrado$")
    public void deberiaVerDetalleProductoRegistrado(){
        theActorInTheSpotlight().should(seeThat(VerificarInscripcion.deProductos()).orComplainWith(NoSeInscribioProductoException.class,PRODUCTO_NO_INSCRITO));
    }
}
