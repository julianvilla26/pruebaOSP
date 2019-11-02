#language: es

Característica: Transferencia de cuenta de depósitos a fondos de inversión en app Bancolombia
  Como usuario de Bancolombia
  Quiero realizar una transferencia de una cuenta de corriente a un fondo de inversión


  @manual
  Esquema del escenario: transferencia de cuenta corriente a fondos de inversión

    Dado que <usuario> esta en la APP en el disposito <dispositivo>
    Cuando selecciona la opcion de transferencia <saldo> de cuenta <cuentaOrigen> a fondos de inversion <cuentaDestino>
    Entonces deberia ver un mensaje de pago exitoso
    Y se verifica el archivo COMMFFLGWWW

    Ejemplos:

      | usuario  | dispositivo | saldo    | cuentaOrigen    | cuentaDestino      |
      | Juan     | Android     | con saldo| Corriente       | Fondo de inversion |
      | Andres   | iOS         | con saldo| Corriente       | Fondo de inversion |
      | Luis     | Huawei      | con saldo| Corriente       | Fondo de inversion |

  @manual
  Esquema del escenario: flujo transaccional transferencia de cuenta de depósito a fonde de inversion

    Dado que el usuario esta en la APP
    Cuando selecciona la opción de transferencia de una cuenta corriente a un fondo de inversion
    Entonces deberia ver el mensaje exitoso
    Y se verifica  que se lancen las transacciones <Trn-1> <Trn-2> <Trn-3> <Trn-4><Trn-5><Trn-6><Trn-7><Trn-8><Trn-9>

    Ejemplos:

      | Trn-1            |  Trn-2                   |  Trn-3                       |Trn-4                            |Trn-5               |Trn-6                             |  Trn-7                        | Trn-8                             | Trn-9                         |
      |Autenticacion 0369|Saldos consolidados - 1756|Listar Cuentas Deposito - 0360|Listar Fondos de inversión - 0410|Listar Cuentas Deposito - 0360 |Listar Fondos de inversión - 0410|Consulta costo (0888)|Transferencia a fiducuentas - 0439 |Listar Cuentas Deposito - 0360 |
