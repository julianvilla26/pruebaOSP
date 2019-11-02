#language: es

Característica: Descarga monto tarjeta virtual ePrepago
  Yo como usuario de la app Personas Bancolombia quiero descargar mi tarjeta virtual ePrepago para tener mas saldo

  Esquema del escenario: Descarga exitosa tarjeta virtual ePrepago activa
    Dado que el Actor se autentica en la app
      | ID   | numeroDocumento   | tipoDocumento   | usuario   | clave   | segundaClave   | orientacion   | codigoError   | codigoTransaccion   | resultadoEsperado   | primeraPregunta   | validarClave   |
      | <ID> | <numeroDocumento> | <tipoDocumento> | <usuario> | <clave> | <segundaClave> | <orientacion> | <codigoError> | <codigoTransaccion> | <resultadoEsperado> | <primeraPregunta> | <validarClave> |
    Cuando el actor quiere DESCARGAR_EPREPAGO
    Y realiza la descarga por valor de <valorDescarga>
      | tipoCuenta   | numeroCuenta   |
      | <tipoCuenta> | <numeroCuenta> |
    Entonces el deberia de ver un mensaje descarga ePrepago exitosa
    Y cierra sesion en la app
    Ejemplos:
      | ID | numeroDocumento | tipoDocumento | usuario    | clave | segundaClave | orientacion | codigoError | codigoTransaccion | resultadoEsperado | primeraPregunta | validarClave | valorDescarga | tipoCuenta | numeroCuenta  |
    ##@externaldata@./src/test/resources/datadriven/eprepago/descargar_tarjeta_virtual_eprepago.xlsx@Datos@1
   |1   |93221453   |1   |autotest28   |1234   |4321   |Acierto   |000   |0369   |NO ERROR   |bolp   |ACTIVO   |1000   |Ahorros   |406-714530-17|
