#language: es

Característica:Pagar facturas redeban
  Como usuario de Bancolombia
  Quiero pagar mi factura redeban

  Esquema del escenario: Pagar todas las facturas redeban
    Dado que el Actor se autentica en la app
      | ID   | numeroDocumento   | tipoDocumento   | usuario   | clave   | segundaClave   | orientacion   | codigoError   | codigoTransaccion   | resultadoEsperado   | primeraPregunta   | validarClave   |
      | <ID> | <numeroDocumento> | <tipoDocumento> | <usuario> | <clave> | <segundaClave> | <orientacion> | <codigoError> | <codigoTransaccion> | <resultadoEsperado> | <primeraPregunta> | <validarClave> |
    Y el actor quiere PAGAR_FACTURA
    Cuando el actor realizar el pago de sus factura redeban
      | empresaServicio   | fechaFactura   | valorFactura   | numeroCuenta   | tipoCuenta   |
      | <empresaServicio> | <fechaFactura> | <valorFactura> | <numeroCuenta> | <tipoCuenta> |
    Entonces deberia ver el pago de redeban exitoso
    Ejemplos:
      | ID | numeroDocumento | tipoDocumento | usuario         | clave | segundaClave | orientacion | codigoError | codigoTransaccion | resultadoEsperado | primeraPregunta | validarClave | valorFactura | empresaServicio | fechaFactura  | numeroCuenta  | tipoCuenta |
   ##@externaldata@./src/test/resources/datadriven/administrarfacturas/PagarFacturaRedeban.xlsx@Datos@1
   |1   |48646663   |1   |recaudosnatik66   |1234   |4321   |Acierto   |000   |0369   |NO ERROR   |bolp   |ACTIVO   |10.000,00   |50715   |No disponible   |406-158990-01   |Corriente|
