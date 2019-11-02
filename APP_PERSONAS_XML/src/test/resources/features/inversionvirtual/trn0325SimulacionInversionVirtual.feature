#language: es

@E2E_APP_PERSONAS
Característica: : APP Personas Bancolombia,
  Una persona debe poder ingresar autenticarce en la APP personas y simular la inversión virtual sin que el saldo de la cuenta se vea afectado


  @TestCase1
  Esquema del escenario: :  TRN0325 simulacion de inversion virtual

    Dado que yo cargo los datos para la prueba de simulacion de inversion virtual
      | <ID>                 | <orientacion>      | <codigoError> | <codigoTransaccion> | <resultadoEsperado> |
      | <numeroDocumento>    | <tipoDocumento>    | <usuario>     | <clave>             | <segundaClave>      |
      | <CuentaOrigen>       | <TipoCuentaOrigen> | <Monto>       |                     |                     |
      | <Periodicidad>       | <Tiempo>           | <TasaEfectiva>|                     |                     |
    Cuando yo Intento autenticarme utilizando mis credenciales
    Y yo simulo la inversion virtual
    Entonces yo verifico el resultado de la simulacion de inversión virtual
    Y Verifico los resultados en los archivos de iseries
      | LOG CANAL-COMFFLGWWW |




    Ejemplos:
      | ID | numeroDocumento | tipoDocumento | usuario   | clave | segundaClave | orientacion | codigoError | codigoTransaccion | resultadoEsperado | CuentaOrigen |  TipoCuentaOrigen | Monto |Periodicidad|Tiempo|TasaEfectiva|
    ##@externaldata@./src/test/resources/datadriven/inversionvirtual/Trn_0325SimulacionIV.xlsx@Datos@1
      |1|1035103510|1|banana01|1223|1234|Acierto|000|0325|TRANSACCION EXITOSA|40676340007|Ahorros|500000|ATEXPIRATION|90|4.20|
