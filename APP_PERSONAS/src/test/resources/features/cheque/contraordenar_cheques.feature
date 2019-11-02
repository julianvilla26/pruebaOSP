#language: es

Característica: Contraordenar cheques como usario Bancolombia

  Esquema del escenario: Contraordenar cheques
    Dado que el Actor se autentica en la app
      | ID   | numeroDocumento   | tipoDocumento   | usuario   | clave   | segundaClave   | orientacion   | codigoError   | codigoTransaccion   | resultadoEsperado   | primeraPregunta   | validarClave   |
      | <ID> | <numeroDocumento> | <tipoDocumento> | <usuario> | <clave> | <segundaClave> | <orientacion> | <codigoError> | <codigoTransaccion> | <resultadoEsperado> | <primeraPregunta> | <validarClave> |
    Cuando el actor quiere CONTRAORDENAR_CHEQUE
    Y el actor contraordena su cheque con informacion
      | tipoCuenta   | numeroCuenta   | tipoContraordenacion   | numeroCheque   | rangoDesde   | rangoHasta   |
      | <tipoCuenta> | <numeroCuenta> | <tipoContraordenacion> | <numeroCheque> | <rangoDesde> | <rangoHasta> |
    Entonces El deberia ver contraordenacion de su cheque exitoso
    Y cierra sesion en la app
    #Y Verifico los resultados en los archivos de iseries
      #| LOG CANAL-COMFFLGWWW | Saldo Depositos Detalle-SCIFFSALDO_DETALLE |
    Ejemplos:
      | ID | numeroDocumento | tipoDocumento        | usuario       | clave | segundaClave | orientacion | codigoError | codigoTransaccion | resultadoEsperado | primeraPregunta | validarClave | tipoCuenta | numeroCuenta  | tipoContraordenacion | numeroCheque | rangoDesde | rangoHasta |
   ##@externaldata@./src/test/resources/datadriven/cheque/contraordenarcheque.xlsx@Datos@1
   |1   |664775789   |Cédula de ciudadanía   |usercheques01   |1234   |4321   |Alterno   |000   |0369   |NO ERROR   |bolp   |ACTIVO   |Corriente   |406-157890-08   |Cheque   |65765   |   ||

  Esquema del escenario: Contraordenar cheques con rango
    Dado que el Actor se autentica en la app
      | ID   | numeroDocumento   | tipoDocumento   | usuario   | clave   | segundaClave   | orientacion   | codigoError   | codigoTransaccion   | resultadoEsperado   | primeraPregunta   | validarClave   |
      | <ID> | <numeroDocumento> | <tipoDocumento> | <usuario> | <clave> | <segundaClave> | <orientacion> | <codigoError> | <codigoTransaccion> | <resultadoEsperado> | <primeraPregunta> | <validarClave> |
    Cuando el actor quiere CONTRAORDENAR_CHEQUE
    Y el actor contraordena su cheque con informacion
      | tipoCuenta   | numeroCuenta   | tipoContraordenacion   | numeroCheque   | rangoDesde   | rangoHasta   |
      | <tipoCuenta> | <numeroCuenta> | <tipoContraordenacion> | <numeroCheque> | <rangoDesde> | <rangoHasta> |
    Entonces El deberia ver contraordenacion de su cheque con rango exitoso
    Y cierra sesion en la app
    #Y Verifico los resultados en los archivos de iseries
      #| LOG CANAL-COMFFLGWWW | Saldo Depositos Detalle-SCIFFSALDO_DETALLE |
    Ejemplos:
      | ID | numeroDocumento | tipoDocumento        | usuario       | clave | segundaClave | orientacion | codigoError | codigoTransaccion | resultadoEsperado | primeraPregunta | validarClave | tipoCuenta | numeroCuenta  | tipoContraordenacion | numeroCheque | rangoDesde | rangoHasta |
   ##@externaldata@./src/test/resources/datadriven/cheque/contraordenarcheque.xlsx@Datos@2
   |2   |664775789   |Cédula de ciudadanía   |usercheques01   |1234   |4321   |Alterno   |000   |0369   |NO ERROR   |bolp   |ACTIVO   |Corriente   |406-157890-08   |Rango de cheques    |   |65762   |65763|
