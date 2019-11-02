# language: es

Característica: Trn-0445 Consulta de detalle crediagil en la APP
  Como usuario de la APP Bancolombia
  Quiero realizar la consulta de detalle
  Para conocer los datos del producto crediagil

  @manual
  Esquema del escenario: Consulta de detalle crediagil
    Dado que <nombre> se autentico en la APP con el usuario <usuario> y la clave <clave>
    Cuando realiza la consulta de detalle seleccionando la opcion crediagil en el dispositivo <dispositivo>
    Entonces deberia ver los detalles del crediagil
    Y se verifica el registro en el Log del Canal COMFFLGWWW

    Ejemplos:
      |nombre|usuario   |clave|dispositivo|
      |Luis  |invictus01|1234 |Android    |
      |Luis  |invictus01|1234 |iOS        |
      |Luis  |invictus01|1234 |Huawei     |

  @manual
  Esquema del escenario: Flujo transaccional Consulta detalle Crediagil

    Dado que el usuario esta en la APP
    Cuando realiza la consulta de detalle
    Entonces deberia ver los detalles del crediagil
    Y se verifica  que se lancen las transacciones <Trn-1> <Trn-2> <Trn-3>

    Ejemplos:

      |Trn-1               |Trn-2                     |Trn-3                               |
      |Autenticacion - 0369|Saldos consolidados - 1756|Saldos por producto Crediagil - 0445|
