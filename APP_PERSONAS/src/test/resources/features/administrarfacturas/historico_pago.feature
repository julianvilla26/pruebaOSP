 #language: es

 Característica: Historico de pago en programacion de facturas
   Como usuario de Bancolombia
   Quiero ver mi historial de pagos
   Para tener un control de pagos posteriores

   Esquema del escenario: ver historico de pagos de todas las facturas
     Dado que el Actor se autentica en la app
       | ID   | numeroDocumento   | tipoDocumento   | usuario   | clave   | segundaClave   | orientacion   | codigoError   | codigoTransaccion   | resultadoEsperado   | primeraPregunta   | validarClave   |
       | <ID> | <numeroDocumento> | <tipoDocumento> | <usuario> | <clave> | <segundaClave> | <orientacion> | <codigoError> | <codigoTransaccion> | <resultadoEsperado> | <primeraPregunta> | <validarClave> |
     Y el actor quiere VER_HISTORICO_PAGOS
     Cuando el actor revisa el historico de pagos de <opcion> facturas
       | valorFactura   | empresaServicio   | fechaFactura   |
       | <valorFactura> | <empresaServicio> | <fechaFactura> |
     Entonces deberia ver el historico de pagos

     Ejemplos:
       | ID | numeroDocumento | tipoDocumento | usuario         | clave | segundaClave | orientacion | codigoError | codigoTransaccion | resultadoEsperado | primeraPregunta | validarClave | valorFactura | empresaServicio | fechaFactura | opcion |
   ##@externaldata@./src/test/resources/datadriven/administrarfacturas/HistoricoPago.xlsx@Datos@2
   |2   |22493944   |1   |recaudosnatik66   |1234   |4321   |Alterno   |607   |0369   |NO ERROR   |bolp   |ACTIVO   |   |   |   |Todas|

   Esquema del escenario: Ver historico de pago de una factura
     Dado que el Actor se autentica en la app
       | ID   | numeroDocumento   | tipoDocumento   | usuario   | clave   | segundaClave   | orientacion   | codigoError   | codigoTransaccion   | resultadoEsperado   | primeraPregunta   | validarClave   |
       | <ID> | <numeroDocumento> | <tipoDocumento> | <usuario> | <clave> | <segundaClave> | <orientacion> | <codigoError> | <codigoTransaccion> | <resultadoEsperado> | <primeraPregunta> | <validarClave> |
     Y el actor quiere PROGRAMAR_PAGAR_FACTURAS
     Cuando el actor revisa el historico de pagos de <opcion> facturas
       | valorFactura   | empresaServicio   | fechaFactura   |
       | <valorFactura> | <empresaServicio> | <fechaFactura> |
     Entonces deberia ver el historico de pagos

     Ejemplos:
       | ID | numeroDocumento | tipoDocumento | usuario         | clave | segundaClave | orientacion | codigoError | codigoTransaccion | resultadoEsperado | primeraPregunta | validarClave | valorFactura | empresaServicio | fechaFactura | opcion |
   ##@externaldata@./src/test/resources/datadriven/administrarfacturas/HistoricoPago.xlsx@Datos@1
   |1   |48646663   |1   |recaudosnatik66   |1234   |4321   |Acierto   |000   |0369   |NO ERROR   |bolp   |ACTIVO   |0,00   |65468   |28 Dic 2019   |una|
