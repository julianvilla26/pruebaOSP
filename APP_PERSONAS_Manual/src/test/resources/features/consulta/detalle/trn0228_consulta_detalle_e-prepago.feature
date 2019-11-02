# language: es

Característica: Trn-0228 Consulta de detalle e-Prepago en la APP
  Como usuario de la APP Bancolombia
  Quiero realizar la consulta de detalle
  Para conocer los datos del producto e-Prepago

  @manual
  Esquema del escenario: Consulta de detalle e-Prepago
    Dado que <nombre> se autentico en la APP con el usuario <usuario> y la clave <clave>
    Cuando realiza la consulta de detalle seleccionando la opcion e-Prepago en el dispositivo <dispositivo>
    Entonces deberia ver los detalles del e-Prepago <estado>
    Y se verifica el registro en el Log del Canal COMFFLGWWW

    Ejemplos:
      |nombre |usuario   |clave|dispositivo|estado  |
      |Luis   |invictus01|1234 |Android    |Activa  |
      |Luis   |invictus01|1234 |iOS        |Activa  |
      |Luis   |invictus01|1234 |Huawei     |Activa  |
      |Alberto|invictus02|1234 |Android    |Inactiva|
      |ALberto|invictus02|1234 |iOS        |Inactiva|
      |Alberto|invictus02|1234 |Huawei     |Inactiva|

  @manual
  Esquema del escenario: Flujo transaccional Consulta de detalle e-Prepago

    Dado que el usuario esta en la APP
    Cuando realiza la consulta de detalles
    Entonces deberia ver los detalles del e-Prepago
    Y se verifica  que se lancen las transacciones <Trn-1> <Trn-2> <Trn-3> <Trn-4> <Trn-5>

    Ejemplos:

      |Trn-1               |Trn-2                     |Trn-3                  |Trn-4                   |Trn-5                       |
      |Autenticacion - 0369|Saldos consolidados - 1756|Saldos e-Prepago - 1228|Detalle e-Prepago - 0228|Movimientos e-Prepago - 0229|

