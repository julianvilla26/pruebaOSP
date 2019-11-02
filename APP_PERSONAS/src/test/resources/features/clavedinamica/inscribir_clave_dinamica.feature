#language: es

Característica: Inscribir clave dinamica
  Yo como usuario Bancolombia
  Quiero inscribir mi clave dinamica
  Para poder realizar transacciones

  @Manual:Passed
  Esquema del escenario: Inscripcion clave dinamica exitoso
    Dado que el Actor se autentica en la app
      | ID   | numeroDocumento   | tipoDocumento   | usuario   | clave   | segundaClave   | orientacion   | codigoError   | codigoTransaccion   | resultadoEsperado   | primeraPregunta   | validarClave   |
      | <ID> | <numeroDocumento> | <tipoDocumento> | <usuario> | <clave> | <segundaClave> | <orientacion> | <codigoError> | <codigoTransaccion> | <resultadoEsperado> | <primeraPregunta> | <validarClave> |
    Cuando el actor quiere GESTIONAR_CLAVE_DINAMICA
    Y gestiono la inscripcion de clave dinamica
      | segundaClave   | nombrePersonalizado   | correo   | tipoCorreo   | numeroCelular   |
      | <segundaClave> | <nombrePersonalizado> | <correo> | <tipoCorreo> | <numeroCelular> |
    Entonces Yo deberia ver mis datos registrados en clave dinamica
    Y cierra sesion en la app
    Ejemplos:
      | ID | numeroDocumento | tipoDocumento | usuario    | clave | segundaClave | orientacion | codigoError | codigoTransaccion | resultadoEsperado | primeraPregunta | validarClave | nombrePersonalizado | correo         | tipoCorreo | numeroCelular |
   ##@externaldata@./src/test/resources/datadriven/clavedinamica/InscribirClaveDinamica.xlsx@Datos@1
   |1   |87576483       |1   |autotest13   |1234   |4321   |Acierto   |000   |0369   |NO ERROR   |bolp   |ACTIVO   |Autotesttrece   |jrua@todo1.net   |Laboral   |3145678956|
