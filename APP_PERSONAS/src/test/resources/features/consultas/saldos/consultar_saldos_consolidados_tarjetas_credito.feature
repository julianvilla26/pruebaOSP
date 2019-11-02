#language: es

Característica: Consulta de saldos tarjetas de credito app Bancolombia
  Como usuario de Bancolombia
  Quiero consultar mis tarjetas de credito
  Para visualizar el saldo de estas

  Esquema del escenario: Consulta de productos tarjetas de credito desde saldos y movimientos
    Dado que el Actor se autentica en la app
      | ID   | numeroDocumento   | tipoDocumento   | usuario   | clave   | segundaClave   | orientacion   | codigoError   | codigoTransaccion   | resultadoEsperado   | primeraPregunta   | validarClave   |
      | <ID> | <numeroDocumento> | <tipoDocumento> | <usuario> | <clave> | <segundaClave> | <orientacion> | <codigoError> | <codigoTransaccion> | <resultadoEsperado> | <primeraPregunta> | <validarClave> |
    Cuando el actor quiere CONSULTAR_PRODUCTO
    Cuando consulto el saldo de mis Tarjetas de crédito
      | <tipoCuenta> | <numeroCuenta> |
    Entonces Verifico el resultado de la consulta del saldo
    Y cierra sesion en la app
    #Y Verifico los resultados en los archivos de iseries
     # | Logcanal-COMFFLGWWW | Saldos TDC-PCCFFLOGTF_TDCCONSOLIDADO | Pertenencia TDC-CXREF_CNAME_CONSOLIDADOTDC |
    Ejemplos:
      | ID | numeroDocumento | tipoDocumento | usuario      | clave | segundaClave | orientacion | codigoError | codigoTransaccion | resultadoEsperado | primeraPregunta | validarClave | tipoCuenta                                                                                                              | numeroCuenta                        |
         ##@externaldata@./src/test/resources/datadriven/consultas/saldos/ConsultaSaldosConsolidados.xlsx@TarjetasCredito@1
   |1   |1037655531   |1   |pruebauser01   |6789   |4321   |Acierto   |000   |0369   |NO ERROR   |bolp   |ACTIVO   |Personal American Express;Personal American Express;Personal Visa;Personal Visa;Personal Mastercard;Personal Mastercard   |*8410;*3490;*6177;*7194;*4707;*2127|
