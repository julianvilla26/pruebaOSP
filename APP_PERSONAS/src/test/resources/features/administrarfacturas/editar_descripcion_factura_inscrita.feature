 #language: es

 Característica: Editar descripcion factura inscrita
   Como usuario de Bancolombia
   Quiero modificar una factura
   Para tener un control de pagos posteriores

   Esquema del escenario: Modificar facturas inscrita
     Dado que el Actor se autentica en la app
       | ID   | numeroDocumento   | tipoDocumento   | usuario   | clave   | segundaClave   | orientacion   | codigoError   | codigoTransaccion   | resultadoEsperado   | primeraPregunta   | validarClave   |
       | <ID> | <numeroDocumento> | <tipoDocumento> | <usuario> | <clave> | <segundaClave> | <orientacion> | <codigoError> | <codigoTransaccion> | <resultadoEsperado> | <primeraPregunta> | <validarClave> |
     Y el actor quiere PROGRAMAR_PAGAR_FACTURAS
     Cuando el actor modifica descripcion de su factura inscrita
       | valorFactura   | empresaServicio   | fechaFactura   | descripcionFactura   |
       | <valorFactura> | <empresaServicio> | <fechaFactura> | <descripcionFactura> |
     Entonces deberia ver modificacion descripcion exitosa
     Ejemplos:
       | ID | numeroDocumento | tipoDocumento | usuario         | clave | segundaClave | orientacion | codigoError | codigoTransaccion | resultadoEsperado | primeraPregunta | validarClave | valorFactura | empresaServicio | fechaFactura | descripcionFactura |
   ##@externaldata@./src/test/resources/datadriven/administrarfacturas/ModificarDescipcionFacturaInscrita.xlsx@Datos@1
   |1   |48646663   |1   |recaudosNatik66   |1234   |4321   |Acierto   |000   |0369   |NO ERROR   |bolp   |ACTIVO   |55.700,07   |65401   |05 Abr 2020   |Susana12|
