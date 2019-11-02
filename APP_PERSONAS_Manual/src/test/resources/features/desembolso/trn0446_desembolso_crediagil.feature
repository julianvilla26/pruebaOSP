#language: es

Característica: Trn-0446 desembolso de crediagil en app Bancolombia
  Como usuario de Bancolombia
  Quiero desembolsar  mi crediagil
  Para utilizar el cupo del prestamo

  @manual
  Esquema del escenario: desembolso de crediagil

    Dado que <usuario> esta en la APP en el dispositivo <dispositivo>
    Cuando selecciona el crediagil  para desembolsar con monto <monto> y da clic en "desembolsar"
    Entonces deberia ver el mensaje <mensaje>
    Y se verifica el archivo COMMFFLGWWW

    Ejemplos:

      | usuario  | dispositivo |          monto              |   mensaje                         |
      | Juan     | Android     |  cupo total                 | desembolso exitoso                |
      | Andres   | iOS         |  bajo el valor permitido    | no se puede realizar el desembolso|
      | Luis     | Huawei      |  sobre el cupo total        | no se puede realizar el desembolso|
      | Maria    | Android     |  dentro del rango permitido | desembolso exitoso                |



  @manual
  Esquema del escenario: flujo transaccional del desembolso de crediagil

    Dado que el usuario esta en la APP
    Cuando selecciona el crediagil  para desembolsar y da clic en "desembolsar"
    Entonces deberia ver un mensaje de desembolso exitoso
    Y se verifica  que se lancen las transacciones <Trn-1> <Trn-2> <Trn-3> <Trn-4> <Trn-5> <Trn-6>

    Ejemplos:

      | Trn-1 |  Trn-2 |  Trn-3 |  Trn-4 |  Trn-5 | Trn-6 |
      |   Autenticacion - 0369    |Saldos consolidados - 1756| Listar Cuentas deposito- 0360| Consulta Crediagil - 0445|Desembolso Crediagil - 0446| Consulta Crediagil - 0445|



