 #language: es

 Característica: Pago a cuenta a prestamos desde una cuenta de depositos en app Bancolombia
   Como usuario de Bancolombia
   Quiero realizar un pago a un prestamo desde una cuenta de depositos

   @manual
   Esquema del escenario: pago a prestamo desde cuenta de deposito

     Dado que <usuario> esta en la APP en el dispositivo <dispositivo>
     Cuando selecciona la opcion de pago con <saldo> de <cuentaOrigen> con <tipo pago> a <cuentaDestino>
     Entonces deberia ver el mensaje <mensaje>
     Y se verifica el archivo COMMFFLGWWW

     Ejemplos:

       | usuario  | dispositivo |   saldo      	| cuentaOrigen  |   cuentaDestino | tipo pago     |     mensaje                  |
       | Juan     | Android     |  con saldo   	| Ahorros       |   Prestamos     |  minimo       | generacion exitosa           |
       | Andres   | iOS         |  con saldo    | Corriente     |   Prestamos     |  total        | generacion exitosa           |
       | Luis     | Huawei      |  sin saldo    | Ahorros       |   Preatamos     |  minimo       | no tiene fondos sufiecientes |
       | Rosa     | Android     |  sin saldo    | Ahorros       |   Preatamos     |  otro valor   | no tiene fondos sufiecientes |
       | Lina     | Android     |  con saldo    | Ahorros       |   Preatamos     |  otro valor   | gemeracion exitosa           |

   @manual
   Esquema del escenario: flujo transaccional pago a credito

     Dado que el usuario esta en la APP
     Cuando selecciona la opción pagar crédito
     Entonces deberia ver el mensaje exitoso
     Y se verifica  que se lancen las transacciones <Trn-1> <Trn-2> <Trn-3> <Trn-4><Trn-5><Trn-6><Trn-7>

     Ejemplos:


       | Trn-1            |  Trn-2                   |  Trn-3                |Trn-4                   |Trn-5                          |Trn-6                |  Trn-7            |
       |Autenticacion 0369|Saldos consolidados - 1756|Listar Créditos - 0345 |Detalle Crédito - 0345  |Listar Cuentas Deposito - 0360 |Consulta Costo - 0888|Pago Crédito - 0346|
