#language: es

Característica: Consulta de saldos de creditos app Bancolombia
  Como usuario de Bancolombia
  Quiero consultar mis creditos
  Para visualizar el saldo de mis creditos

  Esquema del escenario: Consulta de productos credito desde saldos y movimientos
    Dado que el Actor se autentica en la app
      | ID   | numeroDocumento   | tipoDocumento   | usuario   | clave   | segundaClave   | orientacion   | codigoError   | codigoTransaccion   | resultadoEsperado   | primeraPregunta   | validarClave   |
      | <ID> | <numeroDocumento> | <tipoDocumento> | <usuario> | <clave> | <segundaClave> | <orientacion> | <codigoError> | <codigoTransaccion> | <resultadoEsperado> | <primeraPregunta> | <validarClave> |
    Cuando el actor quiere CONSULTAR_PRODUCTO
    Cuando consulto el saldo de mis Créditos
      | <tipoCuenta> | <numeroCuenta> |
    Entonces Verifico el resultado de la consulta del saldo
    Y cierra sesion en la app
    #Y Verifico los resultados en los archivos de iseries
     # | LOGCANAL-COMFFLGWWW | Saldo consolidados Creditos-CXREF_CNAME_LMBAL_SALDO_CREDITOS |
    Ejemplos:
      | ID | numeroDocumento | tipoDocumento | usuario    | clave | segundaClave | orientacion | codigoError | codigoTransaccion | resultadoEsperado | primeraPregunta | validarClave | tipoCuenta                                | numeroCuenta            |
   ##@externaldata@./src/test/resources/datadriven/consultas/saldos/ConsultaSaldosConsolidados.xlsx@Creditos@1
   |1   |22419862   |1   |invictus12   |1234   |4321   |Acierto   |000   |0345   |NO ERROR   |bolp   |ACTIVO   |Prestamo Personal Ta;Prestamo Personal Ta   |29281023955;29281024975|
