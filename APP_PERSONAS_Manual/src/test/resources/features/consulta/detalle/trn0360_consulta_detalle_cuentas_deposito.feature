# language: es

Característica: Trn-0360 Consulta de detalle cuentas de deposito en la APP
  Como usuario de la APP Bancolombia
  Quiero realizar la consulta de detalle
  Para conocer los datos del producto cuenta de deposito

  @manual
  Esquema del escenario: Consulta de detalle cuentas de deposito
    Dado que <nombre> se autentico en la APP con el usuario <usuario> y la clave <clave>
    Cuando realiza la consulta de detalle seleccionando la opcion cuenta <tipoCuenta> en el dispositivo <dispositivo>
    Entonces deberia ver los detalles de la cuenta de deposito
    Y se verifica el registro en el Log del Canal COMFFLGWWW

    Ejemplos:
      |nombre|usuario   |clave|tipoCuenta|dispositivo|
      |Luis  |invictus01|1234 |Ahorro    |Android    |
      |Luis  |invictus01|1234 |Corriente |Android    |
      |Luis  |invictus01|1234 |Ahorro    |iOS        |
      |Luis  |invictus01|1234 |Corriente |iOS        |
      |Luis  |invictus01|1234 |Ahorro    |Huawei     |
      |Luis  |invictus01|1234 |Corriente |Huawei     |

  @manual
  Esquema del escenario: Flujo transaccional Consulta detalle cuentas deposito

    Dado que el usuario esta en la APP
    Cuando realiza la consulta de detalles
    Entonces deberia ver el detalle de la cuentas de deposito
    Y se verifica  que se lancen las transacciones <Trn-1> <Trn-2> <Trn-3> <Trn-4>

    Ejemplos:

      |Trn-1               |Trn-2                     |Trn-3                          |Trn-4                              |
      |Autenticacion - 0369|Saldos consolidados - 1756|Detalle Cuentas Deposito - 0360|Movimientos Cuentas Deposito - 0464|

