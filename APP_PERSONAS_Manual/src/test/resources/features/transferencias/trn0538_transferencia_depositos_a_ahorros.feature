 #language: es

 Característica: Transferencia a cuenta de ahorros en app Bancolombia
   Como usuario de Bancolombia
   Quiero realizar una transferencia de una cuenta de depositos a una cuenta ahorros


   @manual
   Esquema del escenario: transferencia de depositos a cuenta de ahorros

     Dado que <usuario> esta en la APP en el dispositivo <dispositivo>
     Cuando selecciona la opcion de transferencia con <saldo> de <cuentaOrigen> a <cuentaDestino> con <QR>
     Entonces deberia ver el mensaje <mensaje>
     Y se verifica el archivo COMMFFLGWWW

     Ejemplos:

       | usuario  | dispositivo |   saldo      		    | cuentaOrigen  |   CuentaDestino         |        mensaje                 |  QR    |Cuenta inscrita|
       | Juan     | Android     |  con saldo   		    | Ahorros       |   Ahorros               |  generacion exitosa            | Con QR |     Si        |
       | Andres   | iOS         |  sin saldo            | Corriente     |   Ahorros               |  No tiene saldo                | Sin QR |     Si        |
       | Luis     | Huawei      |  con valor no pertmito| Ahorros       |   Ahorros               |  ha superado el valor permitido| Con QR |     Si        |
       | Rosa     | Android     |  con saldo   		    | Corriente     |   Ahorros               |  generacion exitosa            | Con QR |     No        |
       | Lina     | Android     |  sin saldo   		    | Corriente     |   Ahorros               |  No tiene saldo                | Con QR |     Si        |
       | Carlos   | Android     |  con saldo   		    | Corriente     |   Caracteres (,,,,)     |  transaccion no permitida      | Sin QR |     No        |

   @manual
   Esquema del escenario: flujo transaccional transferencia de depositos a cuenta de ahorros

     Dado que el usuario esta en la APP
     Cuando selecciona la opción de transferencia de una cuenta deposito a una cuenta de ahorro
     Entonces deberia ver el mensaje exitoso
     Y se verifica  que se lancen las transacciones <Trn-1> <Trn-2> <Trn-3> <Trn-4><Trn-5><Trn-6><Trn-7><Trn-8><Trn-9>

     Ejemplos:


       | Trn-1            |  Trn-2                   |  Trn-3                       |Trn-4                            |Trn-5               |Trn-6                             |  Trn-7                        | Trn-8                             | Trn-9                         |
       |Autenticacion 0369|Saldos consolidados - 1756|Listar Cuentas Deposito - 0360|Listar Fondos de inversión - 0410|Listar Cuentas Deposito - 0360 |Listar Fondos de inversión - 0410|Consulta costo (0888)|Transferencia cuentas bancolombia - 0538 |Listar Cuentas Deposito - 0360 |