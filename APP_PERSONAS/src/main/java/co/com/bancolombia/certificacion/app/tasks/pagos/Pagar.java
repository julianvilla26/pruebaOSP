package co.com.bancolombia.certificacion.app.tasks.pagos;

import co.com.bancolombia.certificacion.app.models.builders.CreditoBuilder;
import co.com.bancolombia.certificacion.app.models.builders.ProductoBuilder;
import co.com.bancolombia.certificacion.app.models.builders.TarjetaCreditoBuilder;
import net.serenitybdd.screenplay.Performable;

import static co.com.bancolombia.certificacion.app.utilidades.constantes.TipoClaseConstante.CLASE_TASK;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Pagar {
    public static Performable tarjetaCreditoNoPropia(TarjetaCreditoBuilder tarjetaCredito, ProductoBuilder productoDebitar) {
        return instrumented(NoPropia.class, tarjetaCredito.build(), productoDebitar.build());
    }

    public static Performable tarjetaCreditoPropia(TarjetaCreditoBuilder tarjetaCredito, ProductoBuilder productoDebitar) {
        return instrumented(Propia.class, tarjetaCredito.build(), productoDebitar.build());
    }

    public static Performable creditos(CreditoBuilder credito, ProductoBuilder productoDebitar){
        return instrumented(Creditos.class, credito.build(), productoDebitar.build());
    }

    public static Performable tarjetaCreditoPropiaMayorDeuda(TarjetaCreditoBuilder tarjetaCredito){
        return instrumented(PropiaMayorDeuda.class, tarjetaCredito.build());
    }

    private Pagar() {
        throw new IllegalStateException(CLASE_TASK);
    }
}
