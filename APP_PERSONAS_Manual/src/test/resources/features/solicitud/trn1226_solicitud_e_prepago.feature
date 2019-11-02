#language: es

Característica: Trn-1226 solicitud e-Prepago en app Bancolombia
  Como usuario de Bancolombia
  Quiero solicitar una tarjeta e-Prepago
  Para obtener el producto

  @manual
  Esquema del escenario: solicitud de e-Prepago

    Dado que <usuario> esta en la APP en el dispositivo <dispositivo>
    Cuando selecciona la opcion de solicitar e-Prepago
    Y acepta los terminos y condiciones
    Entonces deberia ver el mensaje <mensaje>
    Y se verifica el archivo COMMFFLGWWW

    Ejemplos:

      | usuario  | dispositivo |    mensaje           |
      | Juan     | Android     | Solicitud exitosa    |
      | Andres   | iOS         | Solicitud exitosa    |
      | Luis     | Huawei      | Solicitud exitosa    |

  @manual
  Esquema del escenario: flujo transaccional de la solicitud de e-Prepago

    Dado que el usuario esta en la APP y no tiene e-Prepago
    Cuando selecciona la opcion de solicitar e-Prepago
    Entonces deberia ver el mensaje de Solicitud exitosa
    Y se verifica  que se lancen las transacciones <Trn-1> <Trn-2> <Trn-3> <Trn-4> <Trn-5>

    Ejemplos:

      | Trn-1 |  Trn-2 |  Trn-3 |  Trn-4 |  Trn-5 |
      |   Autenticacion - 0369    |Saldos consolidados - 1756| Consulta simple e-Prepago- 1228| Consulta detallada e-Prepago - 0228| Inactivar E-prepago (1230) |