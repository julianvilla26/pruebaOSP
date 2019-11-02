#language: es

Característica: Trn-0483 Contraordenar Cheques en la APP Bancolombia
  Como cliente de Bancolombia
  Quiero realizar la contraorden de los cheques en la APP
  Para efectuar la cancelacion del mismo

  @manual
  Esquema del escenario: Contraordenar Cheques
    Dado que <nombre> se autentico en la APP con el usuario <usuario> y la clave <clave>
    Cuando realiza la contraorden de uno o varios cheques en el dispostivo <dispositivo>
    Entonces se verifica que el sistema presente el mensaje <mensaje>
    Y se verifica el registro en el Log del Canal COMFFLGWWW

    Ejemplos:
      |nombre |usuario   |clave|dispositivo|mensaje            |
      |Alberto|invictus02|1234 |Android    |Contraorden exitosa|
      |Alberto|invictus02|1234 |iOS        |Contraorden exitosa|
      |ALberto|invictus02|1234 |Huawei     |Contraorden exitosa|

  @manual
  Esquema del escenario: Flujo transaccional Contraordenar cheques

    Dado que el usuario esta en la APP
    Cuando realiza la contraorden de cheques
    Entonces deberia ver el mensaje de contraorden exitosa
    Y se verifica  que se lancen las transacciones <Trn-1> <Trn-2> <Trn-3>

    Ejemplos:

      |Trn-1               |Trn-2                        |Trn-3                       |
      |Autenticacion - 0369|Lista cuentas deposito - 0360|Contraordenar cheques - 0483|