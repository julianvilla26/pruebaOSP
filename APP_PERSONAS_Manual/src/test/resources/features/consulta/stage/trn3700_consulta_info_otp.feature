# language: es

Característica: Trn-3700 Consulta Info OTP en la APP
  Como usuario de la APP Bancolombia
  Quiero realizar la consulta de la Informacion OTP
  Para conocer el stage del usuario

  @manual
  Esquema del escenario: Consulta de Info OTP
    Dado que <nombre> se autentico en la APP con el usuario <usuario> y la clave <clave>
    Cuando realiza la consulta de la info OTP en el dispositivo <dispositivo>
    Entonces deberia conocer el stage de usuario
    Y se verifica el registro en el Log del Canal COMFFLGWWW

    Ejemplos:
      |nombre |usuario   |clave|dispositivo|
      |Luis   |invictus01|1234 |Android    |
      |Luis   |invictus01|1234 |iOS        |
      |Luis   |invictus01|1234 |Huawei     |

  @manual
  Esquema del escenario: Flujo transaccional Consulta de Info OTP

    Dado que el usuario esta en la APP
    Cuando realiza la consulta de la info OTP
    Entonces deberia conocer el stage del usuario
    Y se verifica  que se lancen las transacciones <Trn-1> <Trn-2>

    Ejemplos:

      |Trn-1               |Trn-2                   |
      |Autenticacion - 0369|Consulta Info OTP - 3700|