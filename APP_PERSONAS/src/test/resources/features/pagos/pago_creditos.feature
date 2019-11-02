#language: es

Característica: Pago de creditos
  Yo como usuario de la app Bancolombia
  Quiero realizar el pago de mis creditos
  Para estar a paz y salvo

  Esquema del escenario: Pago de creditos
    Dado que el Actor se autentica en la app
      | ID   | numeroDocumento   | tipoDocumento   | usuario   | clave   | segundaClave   | orientacion   | codigoError   | codigoTransaccion   | resultadoEsperado   | primeraPregunta   | validarClave   |
      | <ID> | <numeroDocumento> | <tipoDocumento> | <usuario> | <clave> | <segundaClave> | <orientacion> | <codigoError> | <codigoTransaccion> | <resultadoEsperado> | <primeraPregunta> | <validarClave> |
    Cuando el actor quiere PAGAR_CREDITOS
    Y quiere pagar el credito
      | tipoPrestamo   | numeroPrestamo   | tipoPago   | valorPago   | tipoCuenta   | numeroCuenta   |
      | <tipoPrestamo> | <numeroPrestamo> | <tipoPago> | <valorPago> | <tipoCuenta> | <numeroCuenta> |
    Entonces deberia de ver el mensaje de confirmacion y la informacion del pago de su credito
    Ejemplos:
      | ID | numeroDocumento | tipoDocumento | usuario      | clave | segundaClave | orientacion | codigoError | codigoTransaccion | resultadoEsperado | primeraPregunta | validarClave | nuevoUser   | correoUsuario     | tipoPrestamo      | numeroPrestamo | tipoPago   | valorPago | tipoCuenta | numeroCuenta  |
   ##@externaldata@./src/test/resources/datadriven/pagos/Creditos.xlsx@Datos@3
   |3   |22493944   |1   |pruebauser01   |6789   |4321   |Acierto   |000   |0369   |NO ERROR   |bolp   |ACTIVO   |pruebasqa99   |jalzate@todo1.net   |Prestamo Personal Ta   |29281023961   |Otro valor   |1000   |Corriente   |406-182800-03|

  Esquema del escenario: Pago de creditos desde una cuenta sin saldo
    Dado que el Actor se autentica en la app
      | ID   | numeroDocumento   | tipoDocumento   | usuario   | clave   | segundaClave   | orientacion   | codigoError   | codigoTransaccion   | resultadoEsperado   | primeraPregunta   | validarClave   |
      | <ID> | <numeroDocumento> | <tipoDocumento> | <usuario> | <clave> | <segundaClave> | <orientacion> | <codigoError> | <codigoTransaccion> | <resultadoEsperado> | <primeraPregunta> | <validarClave> |
    Cuando el actor quiere PAGAR_CREDITOS
    Y quiere pagar el credito
      | tipoPrestamo   | numeroPrestamo   | tipoPago   | valorPago   | tipoCuenta   | numeroCuenta   |
      | <tipoPrestamo> | <numeroPrestamo> | <tipoPago> | <valorPago> | <tipoCuenta> | <numeroCuenta> |
    Entonces deberia ver el mensaje de error: cuenta origen sin saldo
    Ejemplos:
      | ID | numeroDocumento | tipoDocumento | usuario      | clave | segundaClave | orientacion | codigoError | codigoTransaccion | resultadoEsperado | primeraPregunta | validarClave | nuevoUser   | correoUsuario     | tipoPrestamo      | numeroPrestamo | tipoPago   | valorPago | tipoCuenta | numeroCuenta  |
   ##@externaldata@./src/test/resources/datadriven/pagos/Creditos.xlsx@Datos@4
   |4   |22493944   |1   |pruebauser01   |6789   |4321   |Acierto   |000   |0369   |NO ERROR   |bolp   |ACTIVO   |pruebasqa99   |jalzate@todo1.net   |Prestamo Personal Ta   |29281023961   |Otro valor   |1000   |Ahorros   |406-782800-09|
