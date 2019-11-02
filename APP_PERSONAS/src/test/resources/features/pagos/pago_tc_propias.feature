#language: es

Característica: Pago de tarjetas de credito propias

  Esquema del escenario: Pago de tarjetas de credito propias
    Dado que el Actor se autentica en la app
      | ID   | numeroDocumento   | tipoDocumento   | usuario   | clave   | segundaClave   | orientacion   | codigoError   | codigoTransaccion   | resultadoEsperado   | primeraPregunta   | validarClave   |
      | <ID> | <numeroDocumento> | <tipoDocumento> | <usuario> | <clave> | <segundaClave> | <orientacion> | <codigoError> | <codigoTransaccion> | <resultadoEsperado> | <primeraPregunta> | <validarClave> |
    Cuando el actor quiere PAGAR_TARJETAS_DE_CREDITO_PROPIAS
    Y quiere pagar la tarjeta de credito propia
      | tipoTarjeta   | numeroTarjeta   | tipoPago   | valorPago   | moneda   | tipoCuenta   | numeroCuenta   |
      | <tipoTarjeta> | <numeroTarjeta> | <tipoPago> | <valorPago> | <moneda> | <tipoCuenta> | <numeroCuenta> |
    Entonces deberia de ver el mensaje de confirmacion y la informacion de su pago
    Ejemplos:
      | ID | numeroDocumento | tipoDocumento | usuario  | clave | segundaClave | orientacion | codigoError | codigoTransaccion | resultadoEsperado | primeraPregunta | validarClave | nuevoUser   | correoUsuario     | tipoTarjeta               | numeroTarjeta | tipoPago   | valorPago | moneda | tipoCuenta | numeroCuenta  |
   ##@externaldata@./src/test/resources/datadriven/pagos/TarjetaCreditoPropia.xlsx@Datos@3
   |3   |22493944   |1   |pagotdc1   |1234   |4321   |Acierto   |000   |0369   |NO ERROR   |bolp   |ACTIVO   |pruebasqa99   |jalzate@todo1.net   |Empresarial Mastercard   |*3585   |Otro valor   |1000   |Pesos   |Ahorros   |406-738430-25|

  Esquema del escenario: Pago de tarjetas de credito propias mayor a la deuda
    Dado que el Actor se autentica en la app
      | ID   | numeroDocumento   | tipoDocumento   | usuario   | clave   | segundaClave   | orientacion   | codigoError   | codigoTransaccion   | resultadoEsperado   | primeraPregunta   | validarClave   |
      | <ID> | <numeroDocumento> | <tipoDocumento> | <usuario> | <clave> | <segundaClave> | <orientacion> | <codigoError> | <codigoTransaccion> | <resultadoEsperado> | <primeraPregunta> | <validarClave> |
    Cuando el actor quiere PAGAR_TARJETAS_DE_CREDITO_PROPIAS
    Y quiere pagar la tarjeta de credito propia mayor a la deuda
      | tipoTarjeta   | numeroTarjeta   | tipoPago   | valorPago   | moneda   | tipoCuenta   | numeroCuenta   |
      | <tipoTarjeta> | <numeroTarjeta> | <tipoPago> | <valorPago> | <moneda> | <tipoCuenta> | <numeroCuenta> |
    Entonces deberia de ver el mensaje de valor supera el total de la deuda
    Ejemplos:
      | ID | numeroDocumento | tipoDocumento | usuario  | clave | segundaClave | orientacion | codigoError | codigoTransaccion | resultadoEsperado | primeraPregunta | validarClave | nuevoUser   | correoUsuario     | tipoTarjeta               | numeroTarjeta | tipoPago   | valorPago | moneda | tipoCuenta | numeroCuenta  |
   ##@externaldata@./src/test/resources/datadriven/pagos/TarjetaCreditoPropia.xlsx@Datos@4
   |4   |22452521   |1   |invictus10   |1234   |4321   |Acierto   |000   |0369   |NO ERROR   |bolp   |ACTIVO   |pruebasqa99   |jalzate@todo1.net   |Personal Mastercard   |*6682   |Otro valor   |500000   |Pesos   |Ahorros   |406-725210-11|

  Esquema del escenario: Pago de tarjetas de credito propias desde cuenta sin saldo
    Dado que el Actor se autentica en la app
      | ID   | numeroDocumento   | tipoDocumento   | usuario   | clave   | segundaClave   | orientacion   | codigoError   | codigoTransaccion   | resultadoEsperado   | primeraPregunta   | validarClave   |
      | <ID> | <numeroDocumento> | <tipoDocumento> | <usuario> | <clave> | <segundaClave> | <orientacion> | <codigoError> | <codigoTransaccion> | <resultadoEsperado> | <primeraPregunta> | <validarClave> |
    Cuando el actor quiere PAGAR_TARJETAS_DE_CREDITO_PROPIAS
    Y quiere pagar la tarjeta de credito propia
      | tipoTarjeta   | numeroTarjeta   | tipoPago   | valorPago   | moneda   | tipoCuenta   | numeroCuenta   |
      | <tipoTarjeta> | <numeroTarjeta> | <tipoPago> | <valorPago> | <moneda> | <tipoCuenta> | <numeroCuenta> |
    Entonces deberia ver el mensaje de error: cuenta origen sin saldo
    Ejemplos:
      | ID | numeroDocumento | tipoDocumento | usuario  | clave | segundaClave | orientacion | codigoError | codigoTransaccion | resultadoEsperado | primeraPregunta | validarClave | nuevoUser   | correoUsuario     | tipoTarjeta               | numeroTarjeta | tipoPago   | valorPago | moneda | tipoCuenta | numeroCuenta  |
   ##@externaldata@./src/test/resources/datadriven/pagos/TarjetaCreditoPropia.xlsx@Datos@5
   |5   |22452521   |1   |invictus10   |1234   |4321   |Acierto   |000   |0369   |NO ERROR   |bolp   |ACTIVO   |pruebasqa99   |jalzate@todo1.net   |Personal Mastercard   |*6682   |Otro valor   |1000   |Pesos   |Ahorros   |406-725210-13|
