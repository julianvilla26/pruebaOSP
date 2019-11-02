#language: es

Característica: APP Personas Bancolombia
  Una persona debe poder acceder a la aplicacion
  bancolombia si se autentica con un nombre de usuario y clave, para luego realizar la consulta de costo de avance de tarjeta.

  @CasoExitoso1
  Esquema del escenario: Consultar el costo de avance de tarjeta de manera exitosa en la aplicacion de APP Personas
    Dado que yo subo los datos para la prueba de consulta de costo de avance de tarjeta
      | <ID>                   | <orientacion>        | <codigoError> | <codigoTransaccion> | <resultadoEsperado> |
      | <numeroDocumento>      | <tipoDocumento>      | <usuario>     | <clave>             | <segundaClave>      |
      | <numeroTarjetaCredito> | <tipoTarjetaCredito> |               |                     |                     |
    Cuando Intento autenticarme utilizando mis credenciales
    Y Realizo la consulta de costo de avance de tarjeta
    Entonces Verifico la consulta de costo de avance de tarjeta
    Y Verifico los resultados en los archivos de iseries
      | LOG CANAL-COMFFLGWWW |

    Ejemplos:
      | ID | numeroDocumento | tipoDocumento | usuario | clave | segundaClave | orientacion | codigoError | codigoTransaccion | resultadoEsperado | numeroTarjetaCredito | tipoTarjetaCredito |
    ##@externaldata@./src/test/resources/datadriven/tarjetadecredito/Trn_0533ConsultaCostoAvanceTarjeta.xlsx@Datos@1
      |1|1035655536|1|banana01|1223|1234|Acierto|000|0533|TRANSACCION EXITOSA|5303710222339850|Personal American Express|

  @CasoExitoso2
  Esquema del escenario: Consultar el costo de avance de tarjeta de manera exitosa en la aplicacion de APP Personas
    Dado que yo subo los datos para la prueba de consulta de costo de avance de tarjeta
      | <ID>                   | <orientacion>        | <codigoError> | <codigoTransaccion> | <resultadoEsperado> |
      | <numeroDocumento>      | <tipoDocumento>      | <usuario>     | <clave>             | <segundaClave>      |
      | <numeroTarjetaCredito> | <tipoTarjetaCredito> |               |                     |                     |
    Cuando Intento autenticarme utilizando mis credenciales
    Y Realizo la consulta de costo de avance de tarjeta
    Entonces Verifico la consulta de costo de avance de tarjeta
    Y Verifico los resultados en los archivos de iseries
      | LOG CANAL-COMFFLGWWW |

    Ejemplos:
      | ID | numeroDocumento | tipoDocumento | usuario | clave | segundaClave | orientacion | codigoError | codigoTransaccion | resultadoEsperado | numeroTarjetaCredito | tipoTarjetaCredito |
    ##@externaldata@./src/test/resources/datadriven/tarjetadecredito/Trn_0533ConsultaCostoAvanceTarjeta.xlsx@Datos@2
      |2|1035655536|1|banana01|1223|1234|Error|004|0533|CUENTA NO AUTORIZADA A LA SOLICITUD|5303710222339850|Personal American Express|
