package co.com.bancolombia.certificacion.app.models.builders;

import co.com.bancolombia.certificacion.app.models.transaccion.ConfiguracionTransaccion;
import co.com.bancolombia.certificacion.app.models.usuario.Usuario;
import co.com.bancolombia.certificacion.app.utilidades.Builder;

import java.util.List;
import java.util.Map;

import static co.com.bancolombia.certificacion.app.models.builders.UsuarioBuilder.credenciales;

public class ConfiguracionTransaccionBuilder implements Builder<ConfiguracionTransaccion> {
    private String identificadorCaso;
    private String orientacionCaso;
    private String codigoTransaccion;
    private String codigoError;
    private String resultadoEsperado;
    private String codigoCanal;
    private String codigoSistema;
    private String tipoTransaccion;
    private String horaTransaccion;
    private String tipoLogCanal;
    private String codigoOperacion;
    private Usuario usuario = new Usuario();

    private ConfiguracionTransaccionBuilder() {
        this.identificadorCaso = "";
        this.orientacionCaso = "";
        this.codigoTransaccion = "";
        this.codigoError = "";
        this.resultadoEsperado = "";
        this.codigoCanal = "";
        this.codigoSistema = "";
        this.tipoTransaccion = "";
        this.horaTransaccion = "";
        this.tipoLogCanal = "";
        this.codigoOperacion = "";
    }

    public static ConfiguracionTransaccionBuilder informacion() {
        return new ConfiguracionTransaccionBuilder();
    }


    public ConfiguracionTransaccionBuilder deTransaccion(List<Map<String, String>> datos) {
        this.identificadorCaso = datos.get(0).get("ID");
        this.orientacionCaso = datos.get(0).get("orientacion");
        this.codigoError = datos.get(0).get("codigoError");
        this.codigoTransaccion = datos.get(0).get("codigoTransaccion");
        this.resultadoEsperado = datos.get(0).get("resultadoEsperado");
        this.usuario = credenciales()
                .conNumeroDocumento(datos.get(0).get("numeroDocumento"))
                .conTipoDocumento(datos.get(0).get("tipoDocumento"))
                .conNombreUsuario(datos.get(0).get("usuario"))
                .conClave(datos.get(0).get("clave"))
                .conSegundaClave(datos.get(0).get("segundaClave"))
                .conPrimeraPregunta(datos.get(0).get("primeraPregunta"))
                .conEstadoClave(datos.get(0).get("validarClave"))
                .build();
        return this;
    }

    public String getIdentificadorCaso() {
        return identificadorCaso;
    }

    public String getOrientacionCaso() {
        return orientacionCaso;
    }

    public String getCodigoTransaccion() {
        return codigoTransaccion;
    }

    public String getCodigoError() {
        return codigoError;
    }

    public String getResultadoEsperado() {
        return resultadoEsperado;
    }

    public String getCodigoCanal() {
        return codigoCanal;
    }

    public String getCodigoSistema() {
        return codigoSistema;
    }

    public String getTipoTransaccion() {
        return tipoTransaccion;
    }

    public String getHoraTransaccion() {
        return horaTransaccion;
    }

    public String getTipoLogCanal() {
        return tipoLogCanal;
    }

    public String getCodigoOperacion() {
        return codigoOperacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    @Override
    public ConfiguracionTransaccion build() {
        return new ConfiguracionTransaccion(this);
    }
}