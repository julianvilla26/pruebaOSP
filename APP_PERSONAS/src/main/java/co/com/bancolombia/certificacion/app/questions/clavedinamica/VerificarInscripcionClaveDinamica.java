package co.com.bancolombia.certificacion.app.questions.clavedinamica;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

import static co.com.bancolombia.certificacion.app.userinterface.pages.registro.InscripcionClaveDinamicaPage.LNL_COMPROBANTE_CLAVE_DINAMICA;
import static co.com.bancolombia.certificacion.app.userinterface.pages.registro.InscripcionClaveDinamicaPage.LBL_VERIFICACION_CLAVE_DINAMICA;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.VariablesSesionConstantes.*;

public class VerificarInscripcionClaveDinamica implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        String nombrePersonalizado = actor.recall(NOMBRE_PERSONALIZADO_CLAVE_DINAMICA);
        String correo = actor.recall(CORREO_CLAVE_DINAMICA);
        String tipoCorreo = actor.recall(TIPO_CORREO_CLAVE_DINAMICA);
        return (Visibility.of(LNL_COMPROBANTE_CLAVE_DINAMICA).viewedBy(actor).asBoolean() &&
                Visibility.of(LBL_VERIFICACION_CLAVE_DINAMICA.of(NOMBRE_PERSONALIZADO_CLAVE_DINAMICA, nombrePersonalizado)).viewedBy(actor).asBoolean() &&
                Visibility.of(LBL_VERIFICACION_CLAVE_DINAMICA.of(CORREO_CLAVE_DINAMICA, correo)).viewedBy(actor).asBoolean() &&
                Visibility.of(LBL_VERIFICACION_CLAVE_DINAMICA.of(TIPO_CORREO_CLAVE_DINAMICA, tipoCorreo)).viewedBy(actor).asBoolean()
        );
    }

    public static VerificarInscripcionClaveDinamica exitosa() {
        return new VerificarInscripcionClaveDinamica();
    }
}