#language: es

Característica: Generacion de codigo QR con valor
  Yo como usuario de Bancolombia
  Quiero generar un codigo QR con valor
  Para recibir transferencias a mi cuenta

  Esquema del escenario: Generacion de codigo QR con valor exitoso
    Dado que el Actor se autentica en la app
      | ID   | numeroDocumento   | tipoDocumento   | usuario   | clave   | segundaClave   | orientacion   | codigoError   | codigoTransaccion   | resultadoEsperado   | primeraPregunta   | validarClave   |
      | <ID> | <numeroDocumento> | <tipoDocumento> | <usuario> | <clave> | <segundaClave> | <orientacion> | <codigoError> | <codigoTransaccion> | <resultadoEsperado> | <primeraPregunta> | <validarClave> |
    Cuando el actor quiere GENERAR_CODIGO_QR
    Y quiere generar un codigo QR con valor
      | tipoCuenta   | numeroCuenta   | monto   | descripcion   |
      | <tipoCuenta> | <numeroCuenta> | <monto> | <descripcion> |
    Entonces el deberia de ver un mensaje de confirmacion y el codigo QR
    Y cierra sesion en la app
    Ejemplos:
      | ID | numeroDocumento | tipoDocumento | usuario   | clave | segundaClave | orientacion | codigoError | codigoTransaccion | resultadoEsperado | primeraPregunta | validarClave | nombrePersonalizado | tipoCuenta | numeroCuenta  | monto  | descripcion     |
   ##@externaldata@./src/test/resources/datadriven/codigoqr/GenerarCodigoQr.xlsx@Datos@2
   |2   |43024987   |1   |testing10   |1234   |4321   |Acierto   |0   |369   |NO ERROR   |bolp   |ACTIVO   |conValor   |Ahorros   |406-139740-02   |150000   |qr automatizado|

  Esquema del escenario: Generacion de codigo QR sin inicio de sesion con valor
    Dado que el Actor carga los datos para la prueba
      | ID   | numeroDocumento   | tipoDocumento   | usuario   | clave   | segundaClave   | orientacion   | codigoError   | codigoTransaccion   | resultadoEsperado   | primeraPregunta   | validarClave   |
      | <ID> | <numeroDocumento> | <tipoDocumento> | <usuario> | <clave> | <segundaClave> | <orientacion> | <codigoError> | <codigoTransaccion> | <resultadoEsperado> | <primeraPregunta> | <validarClave> |
    Cuando quiere generar un codigo QR con valor sin iniciar sesion con nombre <nombrePersonalizado>
      | tipoCuenta   | numeroCuenta   | monto   | descripcion   |
      | <tipoCuenta> | <numeroCuenta> | <monto> | <descripcion> |
    Entonces el deberia de ver un mensaje de confirmacion y el codigo QR
    Ejemplos:
      | ID | numeroDocumento | tipoDocumento | usuario   | clave | segundaClave | orientacion | codigoError | codigoTransaccion | resultadoEsperado | primeraPregunta | validarClave | nombrePersonalizado | tipoCuenta | numeroCuenta  | monto  | descripcion     |
   ##@externaldata@./src/test/resources/datadriven/codigoqr/GenerarCodigoQr.xlsx@Datos@3
   |3   |43024987   |1   |testing10   |1234   |4321   |Acierto   |0   |369   |NO ERROR   |bolp   |ACTIVO   |conValor   |Corriente   |406-139740-01   |134000   |qr automatizado|

  Esquema del escenario: Generacion de codigo QR con unica cuenta deposito
    Dado que el Actor se autentica en la app
      | ID   | numeroDocumento   | tipoDocumento   | usuario   | clave   | segundaClave   | orientacion   | codigoError   | codigoTransaccion   | resultadoEsperado   | primeraPregunta   | validarClave   |
      | <ID> | <numeroDocumento> | <tipoDocumento> | <usuario> | <clave> | <segundaClave> | <orientacion> | <codigoError> | <codigoTransaccion> | <resultadoEsperado> | <primeraPregunta> | <validarClave> |
    Cuando el actor quiere GENERAR_CODIGO_QR
    Y quiere generar un codigo QR sin valor
      | tipoCuenta   | numeroCuenta   | descripcion   |
      | <tipoCuenta> | <numeroCuenta> | <descripcion> |
    Entonces el deberia de ver un mensaje de confirmacion y el codigo QR
    Y cierra sesion en la app
    Ejemplos:
      | ID | numeroDocumento | tipoDocumento | usuario   | clave | segundaClave | orientacion | codigoError | codigoTransaccion | resultadoEsperado | primeraPregunta | validarClave | nombrePersonalizado | tipoCuenta | numeroCuenta  |monto| descripcion |
   ##@externaldata@./src/test/resources/datadriven/codigoqr/GenerarCodigoQr.xlsx@Datos@5
   |5   |87576483   |1   |autotest13   |1234   |4321   |Acierto   |0   |369   |NO ERROR   |bolp   |ACTIVO   |sinValor   |Ahorros   |406-764830-26   |   |qr automatizado|
