package co.com.bancolombia.certificacion.app.questions.crediagil;

import co.com.bancolombia.certificacion.app.models.productos.Producto;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.bancolombia.certificacion.app.userinterface.pages.crediagil.CrediagilPage.*;
import static co.com.bancolombia.certificacion.app.utilidades.administradores.Verificar.elementoVisible;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.ModeloConstantes.MODELO_PRODUCTO;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.VariablesSesionConstantes.VALOR_DESEMBOLSAR;
import static co.com.bancolombia.certificacion.app.utilidades.string.UtileriaString.darFormato;

public class DesembolsoCrediagil implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        Producto productoDestino = actor.recall(MODELO_PRODUCTO);
        String valorDesembolsar = actor.recall(VALOR_DESEMBOLSAR);
        return elementoVisible(actor, TXT_DESEMBOLSO_EXITOSO) &&
                elementoVisible(actor, TXT_PRODUCTO_DESTINO.of(productoDestino.getNumero())) &&
                elementoVisible(actor, TXT_VALOR_DESEMBOLSADOR.of(darFormato(valorDesembolsar)));
    }

    public static DesembolsoCrediagil exitoso() {
        return new DesembolsoCrediagil();
    }
}
