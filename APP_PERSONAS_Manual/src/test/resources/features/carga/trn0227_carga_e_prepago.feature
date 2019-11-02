#language: es

Característica: Trn-0227 carga e-Prepago en app Bancolombia
  Como usuario de Bancolombia
  Quiero cargar mi tarjeta e-Prepago
  Para comprar por internet

  @manual
  Esquema del escenario: carga de e-Prepago

    Dado que <usuario> esta en la APP en el dispositivo <dispositivo>
    Cuando selecciona la e-Prepago  con estado <estado> para cargar <monto> y da clic en "cargar"
    Entonces deberia ver el mensaje <mensaje>
    Y se verifica el archivo COMMFFLGWWW

    Ejemplos:

      | usuario  | dispositivo |   estado    |             monto             |  mensaje                       |
      | Juan     | Android     |  activa     | con maximo valor permitido    |recarga exitosa                 |
      | Andres   | iOS         |  activa     | con minimo valor permitido    |recarga exitosa                 |
      | Luis     | Huawei      |  activa     | sobre el valor permitido      |no se puede realizar la recarga |
      | Maria    | Android     |  inactiva   | con monto total de la cuenta  |no se puede realizar la recarga |
      | Andrea   | iOS         |  activa     | con  monto total de la cuenta |recarga exitosa                 |
      | Laura    | Huawei      |  activa     | con cuenta en $0              |recarga exitosa                 |
      | Pablo    | Android     |  activa     | con $50000                    |recarga exitosa                 |


  @manual
  Esquema del escenario: flujo transaccional de la carga de e-Prepago

    Dado que el usuario esta en la APP
    Cuando selecciona la e-Prepago para cargar y da clic en "cargar"
    Entonces deberia ver un mensaje de recarga exitosa
    Y se verifica  que se lancen las transacciones <Trn-1> <Trn-2> <Trn-3> <Trn-4> <Trn-5> <Trn-6>

    Ejemplos:

      | Trn-1 |  Trn-2 |  Trn-3 |  Trn-4 |  Trn-5 | Trn-6 |
      |   Autenticacion - 0369    |Saldos consolidados - 1756| Listar Cuentas deposito- 0360| Consulta Costo - 888|  Carga E-prepago - 0227 |Listar Cuentas deposito- 0360|