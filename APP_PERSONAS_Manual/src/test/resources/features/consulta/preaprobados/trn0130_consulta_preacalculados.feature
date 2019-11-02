# language: es

Característica: Trn-0130 Consulta de precalculados en la APP
  Como usuario de la APP Bancolombia
  Quiero realizar la consulta de precalculados
  Para conocer los productos que el banco me ofrece

  @manual
  Esquema del escenario: Consulta de precalculados
    Dado que <nombre> se autentico en la APP con el usuario <usuario> y la clave <clave>
    Cuando realiza la consulta de precalculados en el dispositivo <dispositivo>
    Entonces deberia ver la informacion de los productos ofrecidos
    Y se verifica el registro en el Log del Canal COMFFLGWWW

    Ejemplos:
      |nombre|usuario   |clave|dispositivo|
      |Luis  |invictus01|1234 |Android    |
      |Luis  |invictus01|1234 |iOS        |
      |Luis  |invictus01|1234 |Huawei     |

  @manual
  Esquema del escenario: Flujo transaccional Consulta de precalculados

    Dado que el usuario esta en la APP
    Cuando realiza la consulta de precalculados
    Entonces deberia ver la informacion de los productos ofrecidos
    Y se verifica  que se lancen las transacciones <Trn-1> <Trn-2>

    Ejemplos:

      |Trn-1               |Trn-2                        |
      |Autenticacion - 0369|Consulta precalculados - 0130|
