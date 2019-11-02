#language: es

Característica: APP Personas Bancolombia
 Una persona debe poder acceder a la aplicacion
 bancolombia si se autentica con un nombre de usuario y clave, para luego realizar la apertura inversion virtual.

 @CasoExitoso1
 Esquema del escenario: Consultar las tasas de la inversion virtual de manera exitosa en la aplicacion de APP Personas
  Dado que yo subo los datos para la prueba de consulta de tasas de inversion virtual
   | <ID> | <orientacion> | <codigoError> | <codigoTransaccion> | <resultadoEsperado>|
   | <numeroDocumento> | <tipoDocumento> | <usuario> | <clave> | <segundaClave> |
  Cuando Intento autenticarme utilizando mis credenciales
  Y Realizo la consulta de tasas de la inversion virtual
  Entonces Verifico la consulta de tasas de la inversion virtual
  Y Verifico los resultados en los archivos de iseries
   |LOG CANAL-COMFFLGWWW|

  Ejemplos:
   | ID | numeroDocumento | tipoDocumento | usuario | clave | segundaClave | orientacion | codigoError | codigoTransaccion | resultadoEsperado |
    ##@externaldata@./src/test/resources/datadriven/inversionvirtual/Trn_0322ConsultarTasas.xlsx@Datos@1
      |1|1035655536|1|banana01|1223|1234|Acierto|000|0322|TRANSACCION EXITOSA|
