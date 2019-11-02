# language: es

Característica: Trn-0410 Consulta de detalle fiduciaria en la APP
  Como usuario de la APP Bancolombia
  Quiero realizar la consulta de detalle
  Para conocer los datos del producto fondos de inversion

  @manual
  Esquema del escenario: Consulta de detalle fiduciaria
    Dado que <nombre> se autentico en la APP con el usuario <usuario> y la clave <clave>
    Cuando realiza la consulta de detalle seleccionando la opcion inversiones en el dispositivo <dispositivo>
    Entonces deberia ver los detalles del fondo de inversion
    Y se verifica el registro en el Log del Canal COMFFLGWWW

    Ejemplos:
      |nombre|usuario   |clave|dispositivo|
      |Luis  |invictus01|1234 |Android    |
      |Luis  |invictus01|1234 |iOS        |
      |Luis  |invictus01|1234 |Huawei     |

  @manual
  Esquema del escenario: Flujo transaccional Consulta detalle Fiduciaria

    Dado que el usuario esta en la APP
    Cuando realiza la consulta de detalle
    Entonces deberia ver los detalles de los fondos de inversion
    Y se verifica  que se lancen las transacciones <Trn-1> <Trn-2> <Trn-3> <Trn-4> <Trn-5>

    Ejemplos:

      |Trn-1               |Trn-2                     |Trn-3                    |Trn-4                    |Trn-5                        |
      |Autenticacion - 0369|Saldos consolidados - 1756|Saldos Inversiones - 0327|Detalle Fiduciaria - 0410|Movimientos Fiduciaria - 0411|
