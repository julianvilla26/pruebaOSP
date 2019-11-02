#language: es

Característica:Consulta detalle de facturas programada
  Como usuario de Bancolombia
  Quiero ver el detalle de mis facturas programada

  Esquema del escenario: Consulta detalle de facturas programada
    Dado que el Actor se autentica en la app
      | ID   | numeroDocumento   | tipoDocumento   | usuario   | clave   | segundaClave   | orientacion   | codigoError   | codigoTransaccion   | resultadoEsperado   | primeraPregunta   | validarClave   |
      | <ID> | <numeroDocumento> | <tipoDocumento> | <usuario> | <clave> | <segundaClave> | <orientacion> | <codigoError> | <codigoTransaccion> | <resultadoEsperado> | <primeraPregunta> | <validarClave> |
    Y el actor quiere CONSULTAR_DETALLE_FACTURA
    Cuando el actor revisa el detalle de su factura programada con informacion
      | empresaServicio   | fechaFactura   | valorFactura   |
      | <empresaServicio> | <fechaFactura> | <valorFactura> |
    Entonces deberia ver el detalle de su factura programada

    Ejemplos:
      | ID | numeroDocumento | tipoDocumento | usuario         | clave | segundaClave | orientacion | codigoError | codigoTransaccion | resultadoEsperado | primeraPregunta | validarClave | valorFactura | empresaServicio | fechaFactura |
   ##@externaldata@./src/test/resources/datadriven/administrarfacturas/ConsultaDetalleFactura.xlsx@Datos@2
   |2   |48646663   |1   |recaudosnatik66   |1234   |4321   |Acierto   |000   |0369   |NO ERROR   |bolp   |ACTIVO   |55.500,05   |65401   |05 Abr 2020|
