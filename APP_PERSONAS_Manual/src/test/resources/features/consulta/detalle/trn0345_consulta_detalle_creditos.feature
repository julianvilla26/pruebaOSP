# language: es

Característica: Trn-0345 Consulta de detalle creditos en la APP
  Como usuario de la APP Bancolombia
  Quiero realizar la consulta de detalle
  Para conocer los datos del producto creditos

  @manual
  Esquema del escenario: Consulta de detalle creditos
    Dado que <nombre> se autentico en la APP con el usuario <usuario> y la clave <clave>
    Cuando realiza la consulta de detalle seleccionando la opcion creditos en el dispositivo <dispositivo>
    Entonces deberia ver los detalles del credito
    Y se verifica el registro en el Log del Canal COMFFLGWWW

    Ejemplos:
      |nombre|usuario   |clave|dispositivo|
      |Luis  |invictus01|1234 |Android    |
      |Luis  |invictus01|1234 |iOS        |
      |Luis  |invictus01|1234 |Huawei     |

  @manual
  Esquema del escenario: Flujo transaccional Consulta de detalle por producto Creditos

    Dado que el usuario esta en la APP
    Cuando realiza la consulta de detalles
    Entonces deberia ver los detalles del producto Creditos
    Y se verifica  que se lancen las transacciones <Trn-1> <Trn-2> <Trn-3>

    Ejemplos:

      |Trn-1               |Trn-2                     |Trn-3                              |
      |Autenticacion - 0369|Saldos consolidados - 1756|Saldos por producto Creditos - 0345|