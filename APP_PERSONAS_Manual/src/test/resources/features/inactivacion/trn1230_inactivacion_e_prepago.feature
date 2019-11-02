#language: es

Característica: Trn-1230 activacion e-Prepago en app Bancolombia
  Como usuario de Bancolombia
  Quiero inactivar una tarjeta e-Prepago
  Para inactivar el numero de la tarjeta

  @manual
  Esquema del escenario: inactivacion de e-Prepago con y sin saldo

    Dado que <usuario> esta en la APP en el dispositivo <dispositivo>
    Cuando selecciona la e-Prepago <saldo> para inactivar y da clic en "inactivar"
    Entonces deberia ver el mensaje de inactivacion exitosa
    Y se verifica el archivo COMMFFLGWWW

    Ejemplos:

      | usuario  | dispositivo |   saldo      |
      | Juan     | Android     |  con saldo   |
      | Andres   | iOS         |  sin saldo   |


  @manual
  Esquema del escenario: flujo transaccional de la inactivacion de e-Prepago

    Dado que el usuario esta en la APP
    Cuando selecciona la e-Prepago para inactivar y da clic en "inactivar"
    Entonces deberia ver un mensaje de inactivacion exitosa
    Y se verifica  que se lancen las transacciones <Trn-1> <Trn-2> <Trn-3> <Trn-4> <Trn-5>

    Ejemplos:

      | Trn-1 |  Trn-2 |  Trn-3 |  Trn-4 |  Trn-5 |
      |   Autenticacion - 0369    |Saldos consolidados - 1756| Consulta simple e-Prepago- 1228| Consulta detallada e-Prepago - 0228| Inactivar E-prepago (1230) |