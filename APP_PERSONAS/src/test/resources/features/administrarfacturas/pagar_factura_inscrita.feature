#language: es

Característica:Pagar facturas inscritas
  Como usuario de Bancolombia
  Quiero pagar mi factura programada

  Esquema del escenario: Pagar factura inscrita
    Dado que el Actor se autentica en la app
      | ID   | numeroDocumento   | tipoDocumento   | usuario   | clave   | segundaClave   | orientacion   | codigoError   | codigoTransaccion   | resultadoEsperado   | primeraPregunta   | validarClave   |
      | <ID> | <numeroDocumento> | <tipoDocumento> | <usuario> | <clave> | <segundaClave> | <orientacion> | <codigoError> | <codigoTransaccion> | <resultadoEsperado> | <primeraPregunta> | <validarClave> |
    Y el actor quiere PAGAR_FACTURA
    Cuando el actor realizar el pago de sus facturas inscritas
      | empresaServicio   | fechaFactura   | valorFactura   | numeroCuenta   | tipoCuenta   | valorFacturaReferenciaPagar   |
      | <empresaServicio> | <fechaFactura> | <valorFactura> | <numeroCuenta> | <tipoCuenta> | <valorFacturaReferenciaPagar> |
    Entonces deberia ver el pago de su factura inscrita
    Ejemplos:
      | ID | numeroDocumento | tipoDocumento | usuario         | clave | segundaClave | orientacion | codigoError | codigoTransaccion | resultadoEsperado | primeraPregunta | validarClave | valorFactura | empresaServicio | fechaFactura | numeroCuenta  | tipoCuenta | valorFacturaReferenciaPagar |
   ##@externaldata@./src/test/resources/datadriven/administrarfacturas/PagarFacturaInscrita.xlsx@Datos@1
   |1   |48646663   |1   |recaudosnatik66   |1234   |4321   |Acierto   |000   |0369   |NO ERROR   |bolp   |ACTIVO   |0,00   |65468   |28 Dic 2019   |406-158990-01   |Corriente   |10,00|

  Esquema del escenario: Pagar facturas inscrita con mas factura
    Dado que el Actor se autentica en la app
      | ID   | numeroDocumento   | tipoDocumento   | usuario   | clave   | segundaClave   | orientacion   | codigoError   | codigoTransaccion   | resultadoEsperado   | primeraPregunta   | validarClave   |
      | <ID> | <numeroDocumento> | <tipoDocumento> | <usuario> | <clave> | <segundaClave> | <orientacion> | <codigoError> | <codigoTransaccion> | <resultadoEsperado> | <primeraPregunta> | <validarClave> |
    Y el actor quiere PAGAR_FACTURA
    Cuando el actor realizar el pago de sus facturas inscritas con opcion <opcion>
      | empresaServicio   | fechaFactura   | valorFactura   | numeroCuenta   | tipoCuenta   | fechaVencimiento   | referencia   | valorFacturaReferenciaPagar   |
      | <empresaServicio> | <fechaFactura> | <valorFactura> | <numeroCuenta> | <tipoCuenta> | <fechaVencimiento> | <referencia> | <valorFacturaReferenciaPagar> |
    Entonces deberia ver el pago de su factura inscrita
    Ejemplos:
      | ID | numeroDocumento | tipoDocumento | usuario         | clave | segundaClave | orientacion | codigoError | codigoTransaccion | resultadoEsperado | primeraPregunta | validarClave | valorFactura        | empresaServicio | fechaFactura  | numeroCuenta  | tipoCuenta | fechaVencimiento | referencia | valorFacturaReferenciaPagar | opcion            |
   ##@externaldata@./src/test/resources/datadriven/administrarfacturas/PagarFacturaVariasInscritas.xlsx@Datos@2
   |2   |48646663   |1   |recaudosnatik66   |1234   |4321   |Acierto   |000   |0369   |NO ERROR   |bolp   |ACTIVO   |Disponible al pagar   |65468   |No disponible   |406-158990-01   |Corriente   |no   |no   |no   |Seleccionar todas|

  Esquema del escenario: Pagar facturas inscrita con una referencia
    Dado que el Actor se autentica en la app
      | ID   | numeroDocumento   | tipoDocumento   | usuario   | clave   | segundaClave   | orientacion   | codigoError   | codigoTransaccion   | resultadoEsperado   | primeraPregunta   | validarClave   |
      | <ID> | <numeroDocumento> | <tipoDocumento> | <usuario> | <clave> | <segundaClave> | <orientacion> | <codigoError> | <codigoTransaccion> | <resultadoEsperado> | <primeraPregunta> | <validarClave> |
    Y el actor quiere PAGAR_FACTURA
    Cuando el actor realizar el pago de sus facturas inscritas con opcion <opcion>
      | empresaServicio   | fechaFactura   | valorFactura   | numeroCuenta   | tipoCuenta   | fechaVencimiento   | referencia   | valorFacturaReferenciaPagar   |
      | <empresaServicio> | <fechaFactura> | <valorFactura> | <numeroCuenta> | <tipoCuenta> | <fechaVencimiento> | <referencia> | <valorFacturaReferenciaPagar> |
    Entonces deberia ver el pago de su factura inscrita
    Ejemplos:
      | ID | numeroDocumento | tipoDocumento | usuario         | clave | segundaClave | orientacion | codigoError | codigoTransaccion | resultadoEsperado | primeraPregunta | validarClave | valorFactura        | empresaServicio | fechaFactura  | numeroCuenta  | tipoCuenta | fechaVencimiento | referencia | valorFacturaReferenciaPagar | opcion    |
   ##@externaldata@./src/test/resources/datadriven/administrarfacturas/PagarFacturaVariasInscritas.xlsx@Datos@1
   |1   |48646663   |1   |recaudosnatik66   |1234   |4321   |Acierto   |000   |0369   |NO ERROR   |bolp   |ACTIVO   |Disponible al pagar   |65468   |No disponible   |406-158990-01   |Corriente   |25 Jul 2020   |2019220531   |10.000,00   |Referecia|
