#language: es

Característica: APP Personas Bancolombia
 Una persona debe poder acceder a la aplicacion
 bancolombia si se autentica con un nombre de usuario y clave.

 @CasoExitoso
 Esquema del escenario: Acceso exitoso a la aplicacion de Bancolombia
  Dado que yo subo los datos para la prueba de autenticacion
   | <ID> | <orientacion> | <codigoError> | <codigoTransaccion> | <resultadoEsperado> |
   | <numeroDocumento> | <tipoDocumento> | <usuario> | <clave> | <segundaClave> |
  Cuando Intento autenticarme utilizando mis credenciales
  Entonces Verifico el resultado de autenticacion
  Y Verifico los resultados en los archivos de iseries
   | LOG CANAL-COMFFLGWWW |

  Ejemplos:
   | ID | numeroDocumento | tipoDocumento | usuario | clave | segundaClave | orientacion | codigoError | codigoTransaccion | resultadoEsperado |
   ##@externaldata@./src/test/resources/datadriven/autenticacion/Trn_0369Autenticacion.xlsx@Datos
   |1   |1037655531   |1   |jacinto25   |1223   |3221   |Acierto   |000   |0369   |NO ERROR|
