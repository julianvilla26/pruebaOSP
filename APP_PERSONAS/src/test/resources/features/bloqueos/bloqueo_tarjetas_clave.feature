#language: es

Característica: Bloqueo de primera clave y tarjetas
  Yo como usuario Bancolombia
  Quiero bloquear mi primera clave y tarjetas
  Por motivos de seguridad

  Esquema del escenario: Bloqueo de clave y tarjetas
    Dado que el Actor se autentica en la app
      | ID   | numeroDocumento   | tipoDocumento   | usuario   | clave   | segundaClave   | orientacion   | codigoError   | codigoTransaccion   | resultadoEsperado   | primeraPregunta   | validarClave   |
      | <ID> | <numeroDocumento> | <tipoDocumento> | <usuario> | <clave> | <segundaClave> | <orientacion> | <codigoError> | <codigoTransaccion> | <resultadoEsperado> | <primeraPregunta> | <validarClave> |
    Cuando el actor quiere BLOQUEAR_TARJETAS_CLAVE
    Y quiere bloquear la clave y tarjetas
    Entonces el deberia ver el mensaje de bloqueo exitoso
    Y cierra sesion en la app
    Ejemplos:
      | ID | numeroDocumento | tipoDocumento | usuario    | clave | segundaClave | orientacion | codigoError | codigoTransaccion | resultadoEsperado | primeraPregunta | validarClave | tipoTarjeta | numeroTarjeta |
   ##@externaldata@./src/test/resources/datadriven/bloqueos/Bloqueo.xlsx@Datos@4
   |4   |22483228   |1   |autotest29   |1234   |4321   |Acierto   |000   |0369   |NO ERROR   |bolp   |ACTIVO   |   ||
