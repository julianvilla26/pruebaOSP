#language: es

Característica: Transferencia de cuenta de depósitos a fondos de inversión en app Bancolombia
Como usuario de Bancolombia
Quiero realizar una transferencia de una cuenta de ahorros a un fondo de inversión


@manual
Esquema del escenario: transferencia de cuenta de ahorros a fondos de inversión

  Dado que <usuario> esta en la APP en el dispositivo <dispositivo>
  Cuando selecciona la opcion de transferencia de cuenta de ahorros <cuentaOrigen> a fondos de inversion <cuentaDestino>
  Entonces deberia ver un mensaje de pago exitoso
  Y se verifica el archivo COMMFFLGWWW

Ejemplos:

| usuario  | dispositivo | cuentaOrigen | cuentaDestino      |
| Juan     | Android     | Ahorro       | Fondo de inversion |
| Andres   | iOS         | Ahorro       | Fondo de inversion |
| Luis     | Huawei      | Ahorro       | Fondo de inversion |


  @manual
  Esquema del escenario: flujo transaccional transferencia de cuenta de ahorros a fondos de inversión

    Dado que el usuario esta en la APP
    Cuando selecciona la opción de transferencia de una cuenta de ahorros a un fondo de inversion
    Entonces deberia ver el mensaje exitoso
    Y se verifica  que se lancen las transacciones <Trn-1> <Trn-2> <Trn-3> <Trn-4><Trn-5><Trn-6><Trn-7><Trn-8><Trn-9>

    Ejemplos:


      | Trn-1            |  Trn-2                   |  Trn-3                       |Trn-4                            |Trn-5               |Trn-6                             |  Trn-7                        | Trn-8                             | Trn-9                         |
      |Autenticacion 0369|Saldos consolidados - 1756|Listar Cuentas Deposito - 0360|Listar Fondos de inversión - 0410|Listar Cuentas Deposito - 0360 |Listar Fondos de inversión - 0410|Consulta costo (0888)|Transferencia a fondos de inversion - 0539 |Listar Cuentas Deposito - 0360 |