package co.com.bancolombia.certificacion.app.models.productos;


import java.util.Map;

import static co.com.bancolombia.certificacion.app.utilidades.constantes.FondoLibrerias.BIBLIOTECA_POR_CODIGO;

public class FondoInversion extends Producto {

    private String codigo;

    public FondoInversion(){
        super ();
    }

    public FondoInversion(String numero, String tipoProducto) {
        super(numero, tipoProducto);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigoFondo(String fundCode) {
        this.codigo = castTypeFundCode(fundCode);
    }

    private String castTypeFundCode(String typeFund) {
        typeFund = typeFund.toUpperCase();
        Map<String, String> map = BIBLIOTECA_POR_CODIGO;
        String type = map.get(typeFund);
        if (type == null) {
            throw new NullPointerException("NO EXISTE ESTE FONDO");
        } else {
            return type;
        }
    }


}
