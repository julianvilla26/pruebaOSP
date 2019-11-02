#language: es

Característica: Trn-1756 Consulta de saldos cuenta depositos app Bancolombia
  Como usuario de la APP Bancolombia
  Quiero realizar la consulta de saldos
  Para conocer el saldo de mis cuentas de deposito

  @manual
  Esquema del escenario: Consultar saldo de cuentas de deposito

    Dado que <nombre> se autentico en la APP con el usuario <usuario> y la clave <clave>
    Cuando realiza la consulta de saldos seleccionando la opcion cuentas en el dispostivo <dispositivo>
    Entonces deberia ver el saldo disponible para las cuentas de deposito
    Y se verifica el registro en el Log del Canal COMFFLGWWW

    Ejemplos:

      |nombre|usuario   |clave|dispositivo|
      |Luis  |invictus01|1234 |Android    |
      |Luis  |invictus01|1234 |iOS        |
      |Luis  |invictus01|1234 |Huawei     |

  @manual
  Esquema del escenario: Flujo transaccional Consulta de saldos de cuentas de deposito

    Dado que el usuario esta en la APP
    Cuando realiza la consulta de saldos
    Entonces deberia ver los saldos consolidados para cuentas de deposito
    Y se verifica  que se lancen las transacciones <Trn-1> <Trn-2>

    Ejemplos:

      |Trn-1               |Trn-2                     |
      |Autenticacion - 0369|Saldos consolidados - 1756|