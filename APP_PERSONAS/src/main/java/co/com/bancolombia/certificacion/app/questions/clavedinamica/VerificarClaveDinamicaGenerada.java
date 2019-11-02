package co.com.bancolombia.certificacion.app.questions.clavedinamica;

import co.com.bancolombia.certificacion.app.utilidades.administradores.Verificar;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.bancolombia.certificacion.app.userinterface.pages.clavedinamica.ClaveDinamicaPage.LBL_CLAVE_DINAMICA_GENERADA;

public class VerificarClaveDinamicaGenerada implements Question<Boolean> {
    private String nombreUsuario;

    public VerificarClaveDinamicaGenerada(String nombreUsuario){
        this.nombreUsuario = nombreUsuario;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return Verificar.elementoVisible(actor, LBL_CLAVE_DINAMICA_GENERADA.of(nombreUsuario));
    }

    public static VerificarClaveDinamicaGenerada existeAutomaticamente(String nombreUsuario){
        return new VerificarClaveDinamicaGenerada(nombreUsuario);
    }
}
