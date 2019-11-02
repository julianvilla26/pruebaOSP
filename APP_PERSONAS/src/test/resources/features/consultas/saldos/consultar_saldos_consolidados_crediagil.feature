#language: es

Característica: Consulta de saldos crediagil app Bancolombia
  Como usuario de Bancolombia
  Quiero consultar mi crediagil
  Para visualizar el saldo de mi crediagil
  
  Esquema del escenario: Consulta de productos crediagil desde saldos y movimientos
    Dado que el Actor se autentica en la app
      | ID   | numeroDocumento   | tipoDocumento   | usuario   | clave   | segundaClave   | orientacion   | codigoError   | codigoTransaccion   | resultadoEsperado   | primeraPregunta   | validarClave   |
      | <ID> | <numeroDocumento> | <tipoDocumento> | <usuario> | <clave> | <segundaClave> | <orientacion> | <codigoError> | <codigoTransaccion> | <resultadoEsperado> | <primeraPregunta> | <validarClave> |
    Cuando el actor quiere CONSULTAR_PRODUCTO
    Cuando consulto el saldo de mi producto Crediágil
    Entonces Verifico el resultado de la consulta del saldo
    Y cierra sesion en la app
#    Y Verifico el resultado de los siguientes archivos de iSeries
#    | Logcanal- COMFFLGWWW |
    Ejemplos:
      | ID | numeroDocumento | tipoDocumento | usuario    | clave | segundaClave | orientacion | codigoError | codigoTransaccion | resultadoEsperado | primeraPregunta | validarClave |tipoCuenta|numeroCuenta|
   ##@externaldata@./src/test/resources/datadriven/consultas/saldos/ConsultaSaldosConsolidados.xlsx@Crediagil@1
   |1   |1037655531   |1   |invictus10   |1234   |4321   |Acierto   |000   |0369   |NO ERROR   |bolp   |ACTIVO   |   ||
