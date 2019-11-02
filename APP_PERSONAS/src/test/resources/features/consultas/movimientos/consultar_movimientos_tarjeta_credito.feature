#language: es

Característica: Consulta de productos Tarjeta de credito de un cliente en app Bancolombia
  Como usuario de Bancolombia
  Quiero consultar mis productos
  Desde la opción saldos y movimientos
  El deberia de ver los movimientos de su tarjeta de credito
  
  Esquema del escenario: Consultar cuenta Corriente con movimientos en la app con tarjetas de credito
    Dado que el Actor se autentica en la app
      | ID   | numeroDocumento   | tipoDocumento   | usuario   | clave   | segundaClave   | orientacion   | codigoError   | codigoTransaccion   | resultadoEsperado   | primeraPregunta   | validarClave   |
      | <ID> | <numeroDocumento> | <tipoDocumento> | <usuario> | <clave> | <segundaClave> | <orientacion> | <codigoError> | <codigoTransaccion> | <resultadoEsperado> | <primeraPregunta> | <validarClave> |
    Cuando el actor quiere CONSULTAR_PRODUCTO
    Y quiero revisar mis movimientos de tarjeta de credito en la app con tipo de cuenta <tipoCuenta> y numero cuenta <numeroCuenta>
    Entonces El deberia de ver los movimientos asociados a su cuenta
    Y cierra sesion en la app
    Ejemplos:
      | ID | numeroDocumento | tipoDocumento | usuario | clave | segundaClave | orientacion | codigoError | codigoTransaccion | resultadoEsperado | primeraPregunta | validarClave | tipoCuenta | numeroCuenta |
   ##@externaldata@./src/test/resources/datadriven/consultas/movimientos/ConsultaMovimientos.xlsx@TarjetasCredito@1
   |1   |1037655531   |1   |pagotdc1   |1234   |4321   |Acierto   |000   |0369   |NO ERROR   |bolp   |ACTIVO   |Personal American Express   |*0702|
    
   Esquema del escenario: Consultar tarjetas de credito sin movimientos
    Dado que el Actor se autentica en la app
      | ID   | numeroDocumento   | tipoDocumento   | usuario   | clave   | segundaClave   | orientacion   | codigoError   | codigoTransaccion   | resultadoEsperado   | primeraPregunta   | validarClave   |
      | <ID> | <numeroDocumento> | <tipoDocumento> | <usuario> | <clave> | <segundaClave> | <orientacion> | <codigoError> | <codigoTransaccion> | <resultadoEsperado> | <primeraPregunta> | <validarClave> |
    Cuando el actor quiere CONSULTAR_PRODUCTO
    Y consulto en TARJETAS_CREDITO los movimientos con tipo <tipoCuenta> y numero cuenta <numeroCuenta>
    Entonces El deberia de ver el mensaje La Tarjeta no tiene movimientos
    Y cierra sesion en la app
    Ejemplos:
      | ID | numeroDocumento | tipoDocumento | usuario | clave | segundaClave | orientacion | codigoError | codigoTransaccion | resultadoEsperado | primeraPregunta | validarClave | tipoCuenta | numeroCuenta |
   ##@externaldata@./src/test/resources/datadriven/consultas/movimientos/ConsultaMovimientos.xlsx@TarjetasCredito@2
   |2   |1037655531   |1   |pagotdc1   |1234   |4321   |Acierto   |000   |0369   |NO ERROR   |bolp   |ACTIVO   |Personal Visa   |*8298|
