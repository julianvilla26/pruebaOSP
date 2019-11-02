#language: es

Característica: Transferencia de fondos de inversión a cuenta de depósitos en app Bancolombia
  Como usuario de Bancolombia
  Quiero realizar una transferencia de fondo de inversión a una cuenta de corriente


  @manual
  Esquema del escenario: transferencia de fondos de inversión a cuenta corriente

    Dado que <usuario> esta en la APP en el disposito <dispositivo>
    Cuando selecciona la opcion de transferencia de fondos de inversion <cuentaOrigen> a cuenta corriente <cuentaDestino>
    Entonces deberia ver un mensaje de pago exitoso
    Y se verifica el archivo COMMFFLGWWW

    Ejemplos:

      | usuario  | dispositivo | cuentaOrigen             | cuentaDestino      |
      | Juan     | Android     | Fondo de inversion       | Corriente          |
      | Andres   | iOS         | Fondo de inversion       | Corriente          |
      | Luis     | Huawei      | Fondo de inversion       | Corriente          |


  @manual
  Esquema del escenario: flujo transaccional transferencia de fondo de inversion a cuenta corriente

    Dado que el usuario esta en la APP
    Cuando selecciona la opción de transferencia de un fondo de inversion a una cuenta corriente
    Entonces deberia ver el mensaje exitoso
    Y se verifica  que se lancen las transacciones <Trn-1> <Trn-2> <Trn-3> <Trn-4><Trn-5><Trn-6><Trn-7><Trn-8><Trn-9>

    Ejemplos:


      | Trn-1            |  Trn-2                   |  Trn-3                       |Trn-4                            |Trn-5               |Trn-6                             |  Trn-7                        | Trn-8                             | Trn-9                         |
      |Autenticacion 0369|Saldos consolidados - 1756|Listar Cuentas Deposito - 0360|Listar Fondos de inversión - 0410|Listar Cuentas Deposito - 0360 |Listar Fondos de inversión - 0410|Consulta costo (0888)|Transferencia fondo de inversion - 0449 |Listar Cuentas Deposito - 0360 |

