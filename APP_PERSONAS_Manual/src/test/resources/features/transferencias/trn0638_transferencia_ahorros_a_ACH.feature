 #language: es

 Característica: Transferencia de cuenta de depósitos a fondos de inversión en app Bancolombia
   Como usuario de Bancolombia
   Quiero realizar una transferencia de fondo de inversión a una cuenta de ahorros


   @manual
   Esquema del escenario: transferencia de depósitos a fondos de inversión

     Dado que <usuario> esta en la APP en el dispositivo <dispositivo>
     Cuando selecciona la opcion de transferencia con <saldo> de <cuentaOrigen> a <cuentaDestino>
     Entonces deberia ver el mensaje <mensaje>
     Y se verifica el archivo COMMFFLGWWW

     Ejemplos:

       | usuario  | dispositivo |   saldo      		    | cuentaOrigen  |  CuentaDestino  	   |  mensaje                       |
       | Juan     | Android     |  con saldo   		    | Ahorros       |	Fondo de inversion |  generacion exitosa            |
       | Andres   | iOS         |  sin saldo            | Ahorros       |   Fondo de inversion |  No tiene saldo                |
       | Luis     | Huawei      |  con valor no pertmito| Corriente     |   Fondo de inversion |  ha superado el valor permitido|


   @manual
   Esquema del escenario: flujo transaccional transferencia de depósitos a fondos de inversión

     Dado que el usuario esta en la APP
     Cuando selecciona la opción de transferencia de una cuenta depositos a un fondo de inversion
     Entonces deberia ver el mensaje exitoso
     Y se verifica  que se lancen las transacciones <Trn-1> <Trn-2> <Trn-3> <Trn-4><Trn-5><Trn-6><Trn-7><Trn-8><Trn-9>

     Ejemplos:


       | Trn-1            |  Trn-2                   |  Trn-3                       |Trn-4                            |Trn-5               |Trn-6                             |  Trn-7                        | Trn-8                             | Trn-9                         |
       |Autenticacion 0369|Saldos consolidados - 1756|Listar Cuentas Deposito - 0360|Listar Fondos de inversión - 0410|Listar Cuentas Deposito - 0360 |Listar Fondos de inversión - 0410|Consulta costo (0888)|Transferencia a cuentas ACH - 0638 |Listar Cuentas Deposito - 0360 |
