package co.com.bancolombia.certificacion.app.questions.consultas.saldos;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.List;

import static co.com.bancolombia.certificacion.app.utilidades.constantes.ModeloConstantes.MODELO_LISTA_CUENTAS_DEPOSITO;

public class RevisarProductos implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        List<String> productosCliente = actor.recall(MODELO_LISTA_CUENTAS_DEPOSITO);
        return productosCliente.size() > 1;
    }

    public static RevisarProductos pertenecientesAlUsuario() {
        return new RevisarProductos();
    }
}
