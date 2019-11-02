#language: es

Característica: Consulta de productos asociados a un cliente en app Bancolombia
  Como usuario de Bancolombia
  Quiero consultar mis productos
  Desde la opción saldos y movimientos

  Esquema del escenario: Consulta de cuentas deposito del usuario
    Dado que el Actor se autentica en la app
      | ID   | numeroDocumento   | tipoDocumento   | usuario   | clave   | segundaClave   | orientacion   | codigoError   | codigoTransaccion   | resultadoEsperado   | primeraPregunta   | validarClave   |
      | <ID> | <numeroDocumento> | <tipoDocumento> | <usuario> | <clave> | <segundaClave> | <orientacion> | <codigoError> | <codigoTransaccion> | <resultadoEsperado> | <primeraPregunta> | <validarClave> |
    Cuando el actor quiere CONSULTAR_PRODUCTO
    Y el ingresa a sus productos
    Entonces El deberia de ver los productos asociados a su cuenta
    Y cierra sesion en la app
    #Y Verifico el resultado de los siguientes archivos de iSeries
    #| Logcanal- COMFFLGWWW |
    Ejemplos:
      | ID | numeroDocumento | tipoDocumento | usuario  | clave | segundaClave | orientacion | codigoError | codigoTransaccion | resultadoEsperado | primeraPregunta | validarClave |
   ##@externaldata@./src/test/resources/datadriven/consultas/saldos/ConsultaProductosAsociados.xlsx@Datos@2
   |2   |1037655531   |1   |invictus10   |1234   |4321   |Acierto   |000   |0369   |NO ERROR   |bolp   |ACTIVO|

  Esquema del escenario: Consulta de una unica cuenta deposito del usuario
    Dado que el Actor se autentica en la app
      | ID   | numeroDocumento   | tipoDocumento   | usuario   | clave   | segundaClave   | orientacion   | codigoError   | codigoTransaccion   | resultadoEsperado   | primeraPregunta   | validarClave   |
      | <ID> | <numeroDocumento> | <tipoDocumento> | <usuario> | <clave> | <segundaClave> | <orientacion> | <codigoError> | <codigoTransaccion> | <resultadoEsperado> | <primeraPregunta> | <validarClave> |
    Cuando el actor quiere CONSULTAR_PRODUCTO
    Y el ingresa a sus productos
    Entonces El deberia ver unicamente cuentas deposito
    Y cierra sesion en la app
    #Y Verifico el resultado de los siguientes archivos de iSeries
    #| Logcanal- COMFFLGWWW |
    Ejemplos:
      | ID | numeroDocumento | tipoDocumento | usuario  | clave | segundaClave | orientacion | codigoError | codigoTransaccion | resultadoEsperado | primeraPregunta | validarClave |
   ##@externaldata@./src/test/resources/datadriven/consultas/saldos/ConsultaProductosAsociados.xlsx@Datos@1
   |1   |87576487   |1   |autouser20   |1234   |4321   |Acierto   |000   |0369   |NO ERROR   |bolp   |ACTIVO|
