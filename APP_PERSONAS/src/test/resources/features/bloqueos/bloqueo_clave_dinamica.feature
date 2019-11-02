#language: es

Característica: Bloqueo de clave dinamica
  Yo como usuario Bancolombia
  Quiero bloquear mi clave dinamica
  Para no realizar transacciones

  Esquema del escenario: Bloqueo de clave dinamica
    Dado que el Actor se autentica en la app
      | ID   | numeroDocumento   | tipoDocumento   | usuario   | clave   | segundaClave   | orientacion   | codigoError   | codigoTransaccion   | resultadoEsperado   | primeraPregunta   | validarClave   |
      | <ID> | <numeroDocumento> | <tipoDocumento> | <usuario> | <clave> | <segundaClave> | <orientacion> | <codigoError> | <codigoTransaccion> | <resultadoEsperado> | <primeraPregunta> | <validarClave> |
    Cuando el actor quiere BLOQUEAR_CLAVE_DINAMICA
    Y quiere bloquear la clave dinamica
    Entonces el deberia ver el mensaje de bloqueo exitoso
    Y cierra sesion en la app
    Ejemplos:
      | ID | numeroDocumento | tipoDocumento | usuario    | clave | segundaClave | orientacion | codigoError | codigoTransaccion | resultadoEsperado | primeraPregunta | validarClave | tipoTarjeta | numeroTarjeta |
   ##@externaldata@./src/test/resources/datadriven/bloqueos/Bloqueo.xlsx@Datos@1
   |1   |22483228   |1   |autotest28   |1234   |4321   |Acierto   |000   |0369   |NO ERROR   |bolp   |ACTIVO   |   ||
