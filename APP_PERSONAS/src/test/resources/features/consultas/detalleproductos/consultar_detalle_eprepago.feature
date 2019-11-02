#language: es

Característica: Consulta de detalle de E-prepago
  Como usuario de Bancolombia
  Quiero consultar el detalle de mi tarjeta E prepago
  Para visualizar el detalle de esta

  Esquema del escenario: Consulta de detalle de e-prepago
    Dado que el Actor se autentica en la app
      | ID   | numeroDocumento   | tipoDocumento   | usuario   | clave   | segundaClave   | orientacion   | codigoError   | codigoTransaccion   | resultadoEsperado   | primeraPregunta   | validarClave   |
      | <ID> | <numeroDocumento> | <tipoDocumento> | <usuario> | <clave> | <segundaClave> | <orientacion> | <codigoError> | <codigoTransaccion> | <resultadoEsperado> | <primeraPregunta> | <validarClave> |
    Cuando el actor quiere CONSULTAR_PRODUCTO
    Cuando consulto en e-Prepago el detalle de mi tarjeta <tipoCuenta> numero <numeroCuenta>
    Entonces deberia de ver el detalle de mi tarjeta eprepago
    Y cierra sesion en la app
    #Y Verifico los resultados en los archivos de iseries
     # | LOG CANAL-COMFFLGWWW | Saldo Depositos Detalle-SCIFFSALDO_DETALLE |
    Ejemplos:
      | ID | numeroDocumento | tipoDocumento | usuario   | clave | segundaClave | orientacion | codigoError | codigoTransaccion | resultadoEsperado | primeraPregunta | validarClave | tipoCuenta | numeroCuenta |
   ##@externaldata@./src/test/resources/datadriven/consultas/detalleproductos/ConsultaDetalleProductos.xlsx@Eprepago@1
   |1   |1037655531   |1   |pruebauser01   |6789   |4321   |Acierto   |000   |0369   |NO ERROR   |bolp   |ACTIVO   |MasterCard   |*0252|
