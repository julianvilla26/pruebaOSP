#language: es

Característica: Trn-0485 Inscripcion de cuentas Bancolombia en la APP
  Como usuario de la APP Bancolombia
  Quiero inscribir una cuenta Bancolombia
  Para realizar debitos y creditos dentro de la APP

  @manual
  Esquema del escenario: Inscripcion de cuentas Bancolombia
    Dado que <nombre> se autentico en la APP con el usuario <usuario> y la clave <clave>
    Cuando intenta registrar una cuenta Bancolombia en el dispostivo <dispositivo>
    Entonces deberia ver el mensaje <mensaje>
    Y se verifica el registro en el Log del Canal COMFFLGWWW

    Ejemplos:
      |nombre|usuario   |clave|dispositivo|mensaje                            |
      |Luis  |invictus01|1234 |Android    |Inscripcion pendiente de activacion|
      |Luis  |invictus01|1234 |iOS        |Inscripcion pendiente de activacion|
      |Luis  |invictus01|1234 |Huawei     |Inscripcion pendiente de activacion|
      |Luis  |invictus01|1234 |Android    |La Cuenta ya esta inscrita         |
      |Luis  |invictus01|1234 |iOS        |La Cuenta ya esta inscrita         |
      |Luis  |invictus01|1234 |Huawei     |La Cuenta ya esta inscrita         |

  @manual
  Esquema del escenario: Flujo transaccional Inscripcion Cuentas Bancolombia

    Dado que el usuario esta en la APP
    Cuando realiza la inscripcion de una cuenta Bancolombia
    Entonces deberia ver el mensaje de inscripcion de cuenta pendiente
    Y se verifica  que se lancen las transacciones <Trn-1> <Trn-2>

    Ejemplos:

      |Trn-1               |Trn-2                                 |
      |Autenticacion - 0369|Inscripcion Cuentas Bancolombia - 0485|