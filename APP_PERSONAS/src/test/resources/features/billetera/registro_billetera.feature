#language: es

Característica: Registro en billetera App
  Como usuario de Bancolombia
  Quiero realizar el registro en Billetera
  Para realizar transacciones
  
  Esquema del escenario: Registro exitoso en billetera App
    Dado que el Actor se autentica en la app
      | ID   | numeroDocumento   | tipoDocumento   | usuario   | clave   | segundaClave   | orientacion   | codigoError   | codigoTransaccion   | resultadoEsperado   | primeraPregunta   | validarClave   |
      | <ID> | <numeroDocumento> | <tipoDocumento> | <usuario> | <clave> | <segundaClave> | <orientacion> | <codigoError> | <codigoTransaccion> | <resultadoEsperado> | <primeraPregunta> | <validarClave> |
    Cuando el actor quiere OPCION_BILLETERA
    Y realiza la activacion de la billetera
    Entonces El deberia de ver que la activacion de su billetera fue exitoso
    Ejemplos:
      | ID | numeroDocumento | tipoDocumento | usuario    | clave | segundaClave | orientacion | codigoError | codigoTransaccion | resultadoEsperado | primeraPregunta | validarClave |
   ##@externaldata@./src/test/resources/datadriven/billetera/RegistroBilletera.xlsx@Datos@1
   |1   |48349402   |1   |autotest12   |1234   |4321   |Acierto   |000   |0369   |NO ERROR   |bolp   |ACTIVO|
