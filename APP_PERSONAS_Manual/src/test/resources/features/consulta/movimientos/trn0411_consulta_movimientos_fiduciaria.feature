# language: es

Característica: Trn-0411 Consulta de movimientos Fiduciarios en la APP
  Como usuario de la APP Bancolombia
  Quiero realizar la consulta de movimientos
  Para conocer la lista de movimientos de los fondos de inversion

  @manual
  Esquema del escenario: Consulta de movimientos fiduciarios
    Dado que <nombre> se autentico en la APP con el usuario <usuario> y la clave <clave>
    Cuando realiza la consulta de movimientos seleccionando la opcion inversiones en el dispostivo <dispositivo>
    Entonces deberia ver el listado de movimientos fiduciarios
    Y se verifica el registro en el Log del Canal COMFFLGWWW

    Ejemplos:
      |nombre|usuario   |clave|dispositivo|
      |Luis  |invictus01|1234 |Android    |
      |Luis  |invictus01|1234 |iOS        |
      |Luis  |invictus01|1234 |Huawei     |

  @manual
  Esquema del escenario: Flujo transaccional Consulta movimientos Fiduciaria

    Dado que el usuario esta en la APP
    Cuando realiza la consulta de movimientos
    Entonces deberia ver el listado de movimientos fiduciarios
    Y se verifica  que se lancen las transacciones <Trn-1> <Trn-2> <Trn-3> <Trn-4> <Trn-5>

    Ejemplos:

      |Trn-1               |Trn-2                     |Trn-3                    |Trn-4                    |Trn-5                        |
      |Autenticacion - 0369|Saldos consolidados - 1756|Saldos Inversiones - 0327|Detalle Fiduciaria - 0410|Movimientos Fiduciaria - 0411|
