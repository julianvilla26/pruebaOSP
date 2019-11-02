#language: es

Característica:Pagar facturas programadas
  Como usuario de Bancolombia
  Quiero pagar mi factura programada

  Esquema del escenario: Pagar facturas programadas con mas facturas
    Dado que el Actor se autentica en la app
      | ID   | numeroDocumento   | tipoDocumento   | usuario   | clave   | segundaClave   | orientacion   | codigoError   | codigoTransaccion   | resultadoEsperado   | primeraPregunta   | validarClave   |
      | <ID> | <numeroDocumento> | <tipoDocumento> | <usuario> | <clave> | <segundaClave> | <orientacion> | <codigoError> | <codigoTransaccion> | <resultadoEsperado> | <primeraPregunta> | <validarClave> |
    Y el actor quiere PAGAR_FACTURA
    Cuando el actor realizar el pago de sus facturas programadas con opcion <opcion>
      | empresaServicio   | fechaFactura   | valorFactura   | numeroCuenta   | tipoCuenta   | fechaVencimiento   | referencia   | valorFacturaReferenciaPagar   |
      | <empresaServicio> | <fechaFactura> | <valorFactura> | <numeroCuenta> | <tipoCuenta> | <fechaVencimiento> | <referencia> | <valorFacturaReferenciaPagar> |
    Entonces deberia ver el pago de su factura programada
    Ejemplos:
      | ID | numeroDocumento | tipoDocumento | usuario         | clave | segundaClave | orientacion | codigoError | codigoTransaccion | resultadoEsperado | primeraPregunta | validarClave | valorFactura        | empresaServicio | fechaFactura  | numeroCuenta  | tipoCuenta | fechaVencimiento | referencia | valorFacturaReferenciaPagar | opcion            |
   ##@externaldata@./src/test/resources/datadriven/administrarfacturas/PagarFacturaProgramada.xlsx@Datos@2
      | 2  | 48646663        | 1             | recaudosnatik66 | 1234  | 4321         | Acierto     | 000         | 0369              | NO ERROR          | bolp            | ACTIVO       | Disponible al pagar | 65404           | No disponible | 406-158990-01 | Corriente  | no               | no         | no                          | Seleccionar todas |

  Esquema del escenario: Pagar factura programadas con una referencia
    Dado que el Actor se autentica en la app
      | ID   | numeroDocumento   | tipoDocumento   | usuario   | clave   | segundaClave   | orientacion   | codigoError   | codigoTransaccion   | resultadoEsperado   | primeraPregunta   | validarClave   |
      | <ID> | <numeroDocumento> | <tipoDocumento> | <usuario> | <clave> | <segundaClave> | <orientacion> | <codigoError> | <codigoTransaccion> | <resultadoEsperado> | <primeraPregunta> | <validarClave> |
    Y el actor quiere PAGAR_FACTURA
    Cuando el actor realizar el pago de sus facturas programadas con opcion <opcion>
      | empresaServicio   | fechaFactura   | valorFactura   | referencia   | fechaVencimiento   | valorFacturaReferenciaPagar   | numeroCuenta   | tipoCuenta   |
      | <empresaServicio> | <fechaFactura> | <valorFactura> | <referencia> | <fechaVencimiento> | <valorFacturaReferenciaPagar> | <numeroCuenta> | <tipoCuenta> |
    Entonces deberia ver el pago de su factura programada

    Ejemplos:
      | ID | numeroDocumento | tipoDocumento | usuario         | clave | segundaClave | orientacion | codigoError | codigoTransaccion | resultadoEsperado | primeraPregunta | validarClave | valorFactura        | empresaServicio | fechaFactura  | numeroCuenta  | tipoCuenta | fechaVencimiento | referencia | valorFacturaReferenciaPagar | opcion    |
   ##@externaldata@./src/test/resources/datadriven/administrarfacturas/PagarFacturaProgramada.xlsx@Datos@1
      | 1  | 48646663        | 1             | recaudosnatik66 | 1234  | 4321         | Acierto     | 000         | 0369              | NO ERROR          | bolp            | ACTIVO       | Disponible al pagar | 65404           | No disponible | 406-158990-01 | Corriente  | 26 Jul 2020      | 1038988708 | 10,00                       | Referecia |