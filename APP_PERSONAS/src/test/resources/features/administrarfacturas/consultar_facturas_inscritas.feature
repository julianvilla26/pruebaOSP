#language: es

Característica:Consulta facturas inscritas
  Como usuario de Bancolombia
  Quiero ver el detalle de mis facturas inscritas

  Esquema del escenario: Consulta facturas inscritas
    Dado que el Actor se autentica en la app
      | ID   | numeroDocumento   | tipoDocumento   | usuario   | clave   | segundaClave   | orientacion   | codigoError   | codigoTransaccion   | resultadoEsperado   | primeraPregunta   | validarClave   |
      | <ID> | <numeroDocumento> | <tipoDocumento> | <usuario> | <clave> | <segundaClave> | <orientacion> | <codigoError> | <codigoTransaccion> | <resultadoEsperado> | <primeraPregunta> | <validarClave> |
    Y el actor quiere PROGRAMAR_PAGAR_FACTURAS
    Cuando el actor realiza la consulta de sus facturas inscritas
    Entonces deberia ver consulta de sus facturas

    Ejemplos:
      | ID | numeroDocumento | tipoDocumento | usuario         | clave | segundaClave | orientacion | codigoError | codigoTransaccion | resultadoEsperado | primeraPregunta | validarClave | opcion|
   ##@externaldata@./src/test/resources/datadriven/administrarfacturas/ConsultarFacturas.xlsx@Datos@1
   |1   |22493944   |1   |recaudosnatik66   |1234   |4321   |Alterno   |607   |0369   |NO ERROR   |bolp   |ACTIVO   |Inscritas|
