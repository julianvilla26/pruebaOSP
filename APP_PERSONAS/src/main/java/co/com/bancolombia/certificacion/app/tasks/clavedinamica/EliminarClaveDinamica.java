package co.com.bancolombia.certificacion.app.tasks.clavedinamica;

import co.com.bancolombia.certificacion.app.interactions.scroll.RealizarScroll;
import co.com.bancolombia.certificacion.app.models.usuario.Usuario;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.bancolombia.certificacion.app.userinterface.pages.registro.InscripcionClaveDinamicaPage.BTN_ELIMINAR_CLAVE_DINAMICA;
import static co.com.bancolombia.certificacion.app.userinterface.pages.registro.InscripcionClaveDinamicaPage.LNK_ELIMINAR_CLAVE_DINAMICA;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.VariablesSesionConstantes.NOMBRE_PERSONALIZADO_CLAVE_DINAMICA;

public class EliminarClaveDinamica implements Task {
    Usuario usuario;

    public EliminarClaveDinamica(Usuario usuario){
        this.usuario=usuario;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
      actor.attemptsTo(
              RealizarScroll.hastaPosicionDeTarget(LNK_ELIMINAR_CLAVE_DINAMICA.of(usuario.getNombrePersonalizado())),
              Click.on(LNK_ELIMINAR_CLAVE_DINAMICA.of(usuario.getNombrePersonalizado())),
              Click.on(BTN_ELIMINAR_CLAVE_DINAMICA)
      );
      actor.remember(NOMBRE_PERSONALIZADO_CLAVE_DINAMICA,usuario.getNombrePersonalizado());
    }
}