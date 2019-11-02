#language: es

Característica: Consulta de detalle de crediagil
  Como usuario de Bancolombia
  Quiero consultar el detalle de mi crediagil
  Para visualizar el detalle de mi crediagil

  Esquema del escenario: Consulta de detalle de crediagil
    Dado que el Actor se autentica en la app
      | ID   | numeroDocumento   | tipoDocumento   | usuario   | clave   | segundaClave   | orientacion   | codigoError   | codigoTransaccion   | resultadoEsperado   | primeraPregunta   | validarClave   |
      | <ID> | <numeroDocumento> | <tipoDocumento> | <usuario> | <clave> | <segundaClave> | <orientacion> | <codigoError> | <codigoTransaccion> | <resultadoEsperado> | <primeraPregunta> | <validarClave> |
    Cuando el actor quiere CONSULTAR_PRODUCTO
    Y consulto en el detalle de Crediágil
    Entonces deberia de ver el detalle del crediagil
    Y cierra sesion en la app
    #Y Verifico los resultados en los archivos de iseries
      #| LOG CANAL-COMFFLGWWW | Saldo Depositos Detalle-SCIFFSALDO_DETALLE |
    Ejemplos:
      | ID | numeroDocumento | tipoDocumento | usuario    | clave | segundaClave | orientacion | codigoError | codigoTransaccion | resultadoEsperado | primeraPregunta | validarClave |
   ##@externaldata@./src/test/resources/datadriven/consultas/detalleproductos/ConsultaDetalleProductos.xlsx@Crediagil@1
   |1   |1037655531   |1   |invictus10   |1234   |4321   |Acierto   |000   |0369   |NO ERROR   |bolp   |ACTIVO|
