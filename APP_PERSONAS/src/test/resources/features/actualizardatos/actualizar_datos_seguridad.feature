#language: es

Característica: Actualizar datos seguridad
  Yo como usuario Bancolombia
  Quiero inscribir mi clave dinamica
  Para poder realizar transacciones

  Esquema del escenario: actualiza datos de seguridad
    Dado que el Actor se autentica en la app
      | ID   | numeroDocumento   | tipoDocumento   | usuario   | clave   | segundaClave   | orientacion   | codigoError   | codigoTransaccion   | resultadoEsperado   | primeraPregunta   | validarClave   |
      | <ID> | <numeroDocumento> | <tipoDocumento> | <usuario> | <clave> | <segundaClave> | <orientacion> | <codigoError> | <codigoTransaccion> | <resultadoEsperado> | <primeraPregunta> | <validarClave> |
    Cuando el actor quiere ACTUALIZAR_DATOS_SEGURIDAD
    Y modifica sus datos con informacion
       | correo   | tipoCorreo   | numeroCelular   |
      | <correo> | <tipoCorreo> | <numeroCelular> |
    Entonces Yo deberia ver mis datos actualizados exitosamente
    Y cierra sesion en la app
    Ejemplos:
      | ID | numeroDocumento | tipoDocumento | usuario   | clave | segundaClave | orientacion | codigoError | codigoTransaccion | resultadoEsperado | primeraPregunta | validarClave  | correo           | tipoCorreo | numeroCelular |
   ##@externaldata@./src/test/resources/datadriven/actualizardatos/ActualizarDatosSeguridad.xlsx@Datos@1
   |1   |333333302   |1   |autotest30   |1234   |4321   |Acierto   |000   |0369   |NO ERROR   |bolp   |ACTIVO   |jfernandez@todo1.net   |Laboral   |3145678956|
