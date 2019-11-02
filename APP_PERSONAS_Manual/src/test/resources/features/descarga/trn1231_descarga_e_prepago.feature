#language: es

Característica: Trn-1231 descarga e-Prepago en app Bancolombia
  Como usuario de Bancolombia
  Quiero descargar mi tarjeta e-Prepago
  Para devolver mi dinero a una cuenta deposito

  @manual
  Esquema del escenario: descarga de e-Prepago

    Dado que <usuario> esta en la APP en el dispositivo <dispositivo>
    Cuando selecciona la e-Prepago  para descargar <monto> y da clic en "descargar"
    Entonces deberia ver el mensaje <mensaje>
    Y se verifica el archivo COMMFFLGWWW

    Ejemplos:

      | usuario  | dispositivo |                   monto                      |   mensaje                       |
      | Juan     | Android     |  todo el monto                               | descarga exitosa                    |
      | Andres   | iOS         |  por monto parcial                           | descarga exitosa                    |
      | Luis     | Huawei      |  por monto parcial del salto total           | descarga exitosa                    |
      | Maria    | Android     |  por monto parcial del saldo minimo          | descarga exitosa                    |
      | Andrea   | iOS         |  por monto parcial del saldo limite          | descarga exitosa                    |
      | Laura    | Huawei      |  por monto parcial superior al saldo total   | no se puede realizar la descarga    |


  @manual
  Esquema del escenario: flujo transaccional de la descarga de e-Prepago

    Dado que el usuario esta en la APP
    Cuando selecciona la e-Prepago para descargar y da clic en "descargar"
    Entonces deberia ver un mensaje de descarga exitosa
    Y se verifica  que se lancen las transacciones <Trn-1> <Trn-2> <Trn-3> <Trn-4> <Trn-5>

    Ejemplos:

      | Trn-1 |  Trn-2 |  Trn-3 |  Trn-4 |  Trn-5 |
      |   Autenticacion - 0369    |Saldos consolidados - 1756| Listar Cuentas deposito- 0360|  Descarga E-prepago - 1231 |Listar Cuentas deposito- 0360|

