#language: es

Característica: Activacion eprepago en la app OSP Bancolombia
  Como usuario de Bancolombia
  Quiero activar una tarjeta eprepago
  Para realizar compras

  Esquema del escenario: Activacion de tarjeta eprepago desde la app de Bancolombia OSP por mis productos
    Dado que el Actor se autentica en la app
      | ID   | numeroDocumento   | tipoDocumento   | usuario   | clave   | segundaClave   | orientacion   | codigoError   | codigoTransaccion   | resultadoEsperado   | primeraPregunta   | validarClave   |
      | <ID> | <numeroDocumento> | <tipoDocumento> | <usuario> | <clave> | <segundaClave> | <orientacion> | <codigoError> | <codigoTransaccion> | <resultadoEsperado> | <primeraPregunta> | <validarClave> |
    Cuando el actor quiere ACTIVAR_EPREPAGO
    Y quiero activar una tarjeta e-prepago
    Entonces el deberia de ver un mensaje de activación exitosa para su eprepago
    Ejemplos:
      | ID | numeroDocumento | tipoDocumento | usuario           | clave | segundaClave | orientacion | codigoError | codigoTransaccion | resultadoEsperado | primeraPregunta | validarClave |
   ##@externaldata@./src/test/resources/datadriven/eprepago/activacion_eprepago.xlsx@Datos@1
   |1   |700101   |1   |pruebasregistro49   |1234   |4321   |Acierto   |000   |0369   |NO ERROR   |bolp   |ACTIVO|

  Esquema del escenario: Cancelar activacion de tarjeta eprepago desde la app de Bancolombia OSP por mis productos
    Dado que el Actor se autentica en la app
      | ID   | numeroDocumento   | tipoDocumento   | usuario   | clave   | segundaClave   | orientacion   | codigoError   | codigoTransaccion   | resultadoEsperado   | primeraPregunta   | validarClave   |
      | <ID> | <numeroDocumento> | <tipoDocumento> | <usuario> | <clave> | <segundaClave> | <orientacion> | <codigoError> | <codigoTransaccion> | <resultadoEsperado> | <primeraPregunta> | <validarClave> |
    Cuando el actor quiere ACTIVAR_EPREPAGO
    Y cancelo la activación de una tarjeta e-prepago
    Entonces no se deberia realizar la accion
    Ejemplos:
      | ID | numeroDocumento | tipoDocumento | usuario           | clave | segundaClave | orientacion | codigoError | codigoTransaccion | resultadoEsperado | primeraPregunta | validarClave |
   ##@externaldata@./src/test/resources/datadriven/eprepago/activacion_eprepago.xlsx@Datos@2
   |2   |700100   |1   |pruebasregistro48   |1234   |4321   |Acierto   |000   |0369   |NO ERROR   |bolp   |ACTIVO|
