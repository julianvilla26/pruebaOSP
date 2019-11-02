#language: es

Característica: Consulta de saldos de inversiones app Bancolombia
  Como usuario de Bancolombia
  Quiero consultar mis inversiones
  Para visualizar el saldo de mis inversiones

  Esquema del escenario: Consulta de productos inversiones desde saldos y movimientos
    Dado que el Actor se autentica en la app
      | ID   | numeroDocumento   | tipoDocumento   | usuario   | clave   | segundaClave   | orientacion   | codigoError   | codigoTransaccion   | resultadoEsperado   | primeraPregunta   | validarClave   |
      | <ID> | <numeroDocumento> | <tipoDocumento> | <usuario> | <clave> | <segundaClave> | <orientacion> | <codigoError> | <codigoTransaccion> | <resultadoEsperado> | <primeraPregunta> | <validarClave> |
    Cuando el actor quiere CONSULTAR_PRODUCTO
    Cuando consulto el saldo de mis Inversiones
      | <tipoCuenta> | <numeroCuenta> |
    Entonces Verifico el resultado de la consulta del saldo
    Y cierra sesion en la app
    #Y Verifico los resultados en los archivos de iseries
     # | Logcanal-COMFFLGWWW | Pertenencia fondos-ENCARC |
    Ejemplos:
      | ID | numeroDocumento | tipoDocumento | usuario    | clave | segundaClave | orientacion | codigoError | codigoTransaccion | resultadoEsperado   | primeraPregunta | validarClave | tipoCuenta            | numeroCuenta                |
   ##@externaldata@./src/test/resources/datadriven/consultas/saldos/ConsultaSaldosConsolidados.xlsx@Inversiones@1
   |1   |22452521   |1   |invictus10   |1234   |4321   |Acierto   |000   |0410   |TRANSACCION EXITOSA   |bolp   |ACTIVO   |Inversión;Inversión   |0935000000538;0935000000832|
