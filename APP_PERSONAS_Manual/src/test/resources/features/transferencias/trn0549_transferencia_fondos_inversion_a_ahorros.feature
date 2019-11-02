#language: es

Característica: Transferencia de fondos de inversión a cuenta de depósitos en app Bancolombia
  Como usuario de Bancolombia
  Quiero realizar una transferencia de fondo de inversión a una cuenta de ahorros


  @manual
  Esquema del escenario: transferencia de fondos de inversión a cuenta ahorros

    Dado que <usuario> esta en la APP en el dispositivo <dispositivo>
    Cuando selecciona la opcion de transferencia de fondos de inversion <saldo> <cuentaOrigen> a cuenta ahorros <cuentaDestino>
    Entonces deberia ver el mensaje <mensaje>
    Y se verifica el archivo COMMFFLGWWW

    Ejemplos:

      | usuario  | dispositivo |   saldo      		   | cuentaOrigen    	  |  CuentaDestino  |  mensaje                        |
      | Juan     | Android     |  con saldo   		   | Fondo de inversion   |		Ahorros		|  generacion exitosa             |
      | Andres   | iOS         |  sin saldo            | Fondo de inversion   |     Ahorros     |  No tiene saldo                 |
      | Luis     | Huawei      |  con valor no pertmito| Fondo de inversion   |     Ahorros     |  ha superado el valor permitido |



  @manual
  Esquema del escenario: flujo transaccional transferencia de fondos de inversión a cuenta ahorros

    Dado que el usuario esta en la APP
    Cuando selecciona la opción de transferencia de un fondo de inversion a una cuenta de ahorros
    Entonces deberia ver el mensaje exitoso
    Y se verifica  que se lancen las transacciones <Trn-1> <Trn-2> <Trn-3> <Trn-4><Trn-5><Trn-6><Trn-7><Trn-8><Trn-9>

    Ejemplos:


      | Trn-1            |  Trn-2                   |  Trn-3                       |Trn-4                            |Trn-5               |Trn-6                             |  Trn-7                        | Trn-8                             | Trn-9                         |
      |Autenticacion 0369|Saldos consolidados - 1756|Listar Cuentas Deposito - 0360|Listar Fondos de inversión - 0410|Listar Cuentas Deposito - 0360 |Listar Fondos de inversión - 0410|Consulta costo (0888)|Transferencia desde fondos de inversion - 0549 |Listar Cuentas Deposito - 0360 |
