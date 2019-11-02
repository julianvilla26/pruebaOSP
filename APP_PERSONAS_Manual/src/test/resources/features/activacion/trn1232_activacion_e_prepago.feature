#language: es

Característica: Trn-1232 activacion e-Prepago en app Bancolombia
  Como usuario de Bancolombia
  Quiero activar una tarjeta e-Prepago
  Para generar un nuevo numero de la tarjeta

  @manual
  Esquema del escenario: activacion de e-Prepago con y sin saldo

    Dado que <usuario> esta en la APP en el dispositivo <dispositivo>
    Cuando selecciona la e-Prepago <saldo> para activar y da clic en "activar"
    Entonces deberia ver el mensaje <mensaje>
    Y se verifica el archivo COMMFFLGWWW

    Ejemplos:

      | usuario  | dispositivo |   saldo      |    mensaje                                   |
      | Juan     | Android     |  con saldo   | generacion exitosa                           |
      | Andres   | iOS         |  sin saldo   | debes cargar la e-Prepago antes de activarla |
      | Luis     | Huawei      |  con saldo   | generacion exitosa                           |



  @manual
  Esquema del escenario: activacion de e-Prepago con maximo numero de activaciones diarias

    Dado que <usuario> esta en la APP en el dispositivo <dispositivo>
    Cuando selecciona la e-Prepago para activar y da clic en "activar"
    Entonces deberia ver que el mensaje de activacion fallo
    Y se verifica el archivo COMMFFLGWWW

    Ejemplos:

      | usuario  | dispositivo |
      | Juan     | Android     |
      | Andres   | iOS         |
      | Luis     | Huawei      |


  @manual
  Esquema del escenario: flujo transaccional de la activacion de e-Prepago

    Dado que el usuario esta en la APP
    Cuando selecciona la e-Prepago para activar y da clic en "activar"
    Entonces deberia ver un mensaje de generacion exitosa
    Y se verifica  que se lancen las transacciones <Trn-1> <Trn-2> <Trn-3> <Trn-4> <Trn-5>

    Ejemplos:

      | Trn-1 |  Trn-2 |  Trn-3 |  Trn-4 |  Trn-5 |
      |   Autenticacion - 0369    |Saldos consolidados - 1756| Consulta simple e-Prepago- 1228| Consulta detallada e-Prepago - 0228| Activar E-prepago (1232) |