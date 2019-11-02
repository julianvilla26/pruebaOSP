#language: es

Característica: Consulta de detalle de tarjetas de credito
  Como usuario de Bancolombia
  Quiero consultar el detalle de mis tarjetas de credito
  Para visualizar el detalle de mis tarjetas

  Esquema del escenario: Consulta de detalle de tarjeta de credito
    Dado que el Actor se autentica en la app
      | ID   | numeroDocumento   | tipoDocumento   | usuario   | clave   | segundaClave   | orientacion   | codigoError   | codigoTransaccion   | resultadoEsperado   | primeraPregunta   | validarClave   |
      | <ID> | <numeroDocumento> | <tipoDocumento> | <usuario> | <clave> | <segundaClave> | <orientacion> | <codigoError> | <codigoTransaccion> | <resultadoEsperado> | <primeraPregunta> | <validarClave> |
    Cuando el actor quiere CONSULTAR_PRODUCTO
    Y consulto el detalle de tarjeta de credito <tipoCuenta> numero <numeroCuenta>
    Entonces deberia de ver el detalle de mi tarjeta de credito
    Y cierra sesion en la app
   # Y Verifico los resultados en los archivos de iseries
     # | LOG CANAL-COMFFLGWWW | Saldo Depositos Detalle-SCIFFSALDO_DETALLE |
    Ejemplos:
      | ID | numeroDocumento | tipoDocumento | usuario    | clave | segundaClave | orientacion | codigoError | codigoTransaccion | resultadoEsperado | primeraPregunta | validarClave | tipoCuenta         | numeroCuenta |
   ##@externaldata@./src/test/resources/datadriven/consultas/detalleproductos/ConsultaDetalleProductos.xlsx@TarjetasCredito@1
   |1   |1037655531   |1   |invictus10   |1234   |4321   |Acierto   |000   |0369   |NO ERROR   |bolp   |ACTIVO   |Personal American Express   |*7806|
