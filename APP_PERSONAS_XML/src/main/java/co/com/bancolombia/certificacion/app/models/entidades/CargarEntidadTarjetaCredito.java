package co.com.bancolombia.certificacion.app.models.entidades;

import co.com.bancolombia.certificacion.app.models.productos.TarjetaCredito;
import co.com.bancolombia.certificacion.app.utilidades.constantes.TipoClaseConstante;
import java.util.List;
import static co.com.bancolombia.certificacion.app.utilidades.administradores.AdministradorUtilidades.tipoTarjetaCreditoEnNumero;

public class CargarEntidadTarjetaCredito {
    private static TarjetaCredito tarjetaCredito = new TarjetaCredito();

    private CargarEntidadTarjetaCredito() {
        throw new IllegalStateException(TipoClaseConstante.ENTITY_CLASS);
    }

    public static void conEstos(List<String> data) {
        CargarEntidadTarjetaCredito.tarjetaCredito.setNumero(data.get(0));
        CargarEntidadTarjetaCredito.tarjetaCredito.setTipo(tipoTarjetaCreditoEnNumero(data.get(1)));
    }

    public static TarjetaCredito getTarjetaCredito() {
        return tarjetaCredito;
    }
}
