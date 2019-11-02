#language: es

Característica: Transferencia entre fondos inversión en app Bancolombia
  Como usuario de Bancolombia
  Quiero realizar una transferencia de fondo de inversion a fondo de inversion

Esquema del escenario: transferencia entre fondos de inversion

Dado que <usuario> esta en la APP en el dispositivo <dispositivo>
Cuando selecciona la opcion de transferencia <saldo> entre fondos de <cuentaOrigen> a <cuentaDestino>
Entonces deberia ver el mensaje <mensaje>
Y se verifica el archivo COMMFFLGWWW

Ejemplos:

| usuario  | dispositivo |   saldo      		 | cuentaOrigen    	  |  CuentaDestino  		   |  mensaje                        |
| Juan     | Android     |  con saldo   		 | Fondo de inversion |		Fondo de inversion	   |  generacion exitosa             |
| Andres   | iOS         |  sin saldo            | Fondo de inversion |     Fondo de inversion     |  No tiene saldo                 |
| Luis     | Huawei      |  con valor no pertmito| Fondo de inversion |     Fondo de inversion     |  ha superado el valor permitido |

  @manual
  Esquema del escenario: flujo transaccional transferencia entre fondos de inversion

    Dado que el usuario esta en la APP
    Cuando selecciona la opción de transferencia desde un fondo de inversion a un fondo de inversion
    Entonces deberia ver el mensaje exitoso
    Y se verifica  que se lancen las transacciones <Trn-1> <Trn-2> <Trn-3> <Trn-4><Trn-5><Trn-6><Trn-7><Trn-8><Trn-9>

    Ejemplos:


      | Trn-1            |  Trn-2                   |  Trn-3                       |Trn-4                            |Trn-5               |Trn-6                             |  Trn-7                        | Trn-8                             | Trn-9                         |
      |Autenticacion 0369|Saldos consolidados - 1756|Listar Cuentas Deposito - 0360|Listar Fondos de inversión - 0410|Listar Cuentas Deposito - 0360 |Listar Fondos de inversión - 0410|Consulta costo (0888)|Transferencia entre fondos de inversion - 1100 |Listar Cuentas Deposito - 0360 |




