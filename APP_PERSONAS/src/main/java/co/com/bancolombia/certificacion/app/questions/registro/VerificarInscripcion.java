package co.com.bancolombia.certificacion.app.questions.registro;

import co.com.bancolombia.certificacion.app.models.transaccion.Inscripcion;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.Visibility;

import static co.com.bancolombia.certificacion.app.userinterface.pages.registro.InscripcionProductoPage.*;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.ModeloConstantes.MODELO_INSCRIPCION;
import static co.com.bancolombia.certificacion.app.utilidades.string.UtileriaString.obtenerValorEntero;

public class VerificarInscripcion implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        Inscripcion inscripcion = actor.recall(MODELO_INSCRIPCION);
        String numeroProducto = obtenerValorEntero(Text.of(LBL_NUMERO_PRODUCTO).viewedBy(actor).asString());
        return (numeroProducto.equals(inscripcion.getProducto().getNumero()) &&
                Visibility.of(IMG_CONFIRMACION).viewedBy(actor).asBoolean() &&
                Visibility.of(LBL_TIPO_PRODUCTO.of(inscripcion.getProducto().getTipo())).viewedBy(actor).asBoolean() &&
                Visibility.of(LBL_TIPO_DOCUMENTO.of(inscripcion.getUsuario().getTipoDocumento())).viewedBy(actor).asBoolean() &&
                Visibility.of(LBL_NUMERO_DOCUMENTO.of(inscripcion.getUsuario().getNumeroDocumento())).viewedBy(actor).asBoolean() &&
                Visibility.of(LBL_BANCO.of(inscripcion.getNombreBanco().toLowerCase())).viewedBy(actor).asBoolean()
        );
    }

    public static VerificarInscripcion deProductos() {
        return new VerificarInscripcion();
    }
}