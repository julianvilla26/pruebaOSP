# language: es

Característica: Trn-0445 Consulta de saldos por producto Crediagil en la APP
  Como usuario de la APP Bancolombia
  Quiero realizar la consulta de saldos
  Para conocer el cupo disponible del crediagil

  @manual
  Esquema del escenario: Consulta de saldos por producto Crediagil
    Dado que <nombre> se autentico en la APP con el usuario <usuario> y la clave <clave>
    Cuando realiza la consulta de saldos seleccionando la opcion crediagil en el dispostivo <dispositivo>
    Entonces deberia ver el cupo disponible del crediagil
    Y se verifica el registro en el Log del Canal COMFFLGWWW

    Ejemplos:
      |nombre|usuario   |clave|dispositivo|
      |Luis  |invictus01|1234 |Android    |
      |Luis  |invictus01|1234 |iOS        |
      |Luis  |invictus01|1234 |Huawei     |

  @manual
  Esquema del escenario: Flujo transaccional Consulta de saldos por producto Crediagil

    Dado que el usuario esta en la APP
    Cuando realiza la consulta de saldos
    Entonces deberia ver el cupo disponible del crediagil
    Y se verifica  que se lancen las transacciones <Trn-1> <Trn-2> <Trn-3>

    Ejemplos:

      |Trn-1               |Trn-2                     |Trn-3                               |
      |Autenticacion - 0369|Saldos consolidados - 1756|Saldos por producto Crediagil - 0445|
