#language: es

Característica: Programar Facturas
  Yo Como usuario de Bancolombia
  Quiero programar una factura
  Para que se pague de forma automatica

  Esquema del escenario: Programar facturas inscritas
    Dado que el Actor se autentica en la app
      | ID   | numeroDocumento   | tipoDocumento   | usuario   | clave   | segundaClave   | orientacion   | codigoError   | codigoTransaccion   | resultadoEsperado   | primeraPregunta   | validarClave   |
      | <ID> | <numeroDocumento> | <tipoDocumento> | <usuario> | <clave> | <segundaClave> | <orientacion> | <codigoError> | <codigoTransaccion> | <resultadoEsperado> | <primeraPregunta> | <validarClave> |
    Y el actor quiere PROGRAMAR_PAGAR_FACTURAS
    Cuando el actor programa sus facturas inscritas con informacion
      | valorFactura   | empresaServicio   | fechaFactura   | numeroCuenta   | tipoCuenta   | periodicidad   | numeroIntento   | fechaInicio   | fechaFin   | mesProgramacion   | duracionProgramacion   |
      | <valorFactura> | <empresaServicio> | <fechaFactura> | <numeroCuenta> | <tipoCuenta> | <periodicidad> | <numeroIntento> | <fechaInicio> | <fechaFin> | <mesProgramacion> | <duracionProgramacion> |
    Entonces el deberia ver el mensaje de programación exitosa
    Ejemplos:
      | ID | numeroDocumento | tipoDocumento | usuario         | clave | segundaClave | orientacion | codigoError | codigoTransaccion | resultadoEsperado | primeraPregunta | validarClave | valorFactura | empresaServicio | fechaFactura | numeroCuenta  | tipoCuenta | periodicidad               | numeroIntento | fechaInicio | fechaFin | mesProgramacion | duracionProgramacion |
   ##@externaldata@./src/test/resources/datadriven/administrarfacturas/ProgramarFacturas.xlsx@Datos@1
   |1   |48346663   |1   |recaudosnatik66   |1234   |4321   |Acierto   |000   |0369   |NO ERROR   |bolp   |ACTIVO   |55.700,07   |65401   |05 Abr 2020   |406-158990-01   |Corriente   |En la fecha de vencimiento   |1   |17   |19   |Octubre   |Rango de fechas|
