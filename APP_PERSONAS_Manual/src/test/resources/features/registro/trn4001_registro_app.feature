#language: es

Característica: Trn-4001 Registro de usuario en la APP Bancolombia
  Como cliente de Bancolombia
  Quiero realizar el registro de mi usuario virtual en la APP
  Para poder transar por los canales virtuales

  @manual
  Esquema del escenario: Registro o enrolamiento del usuario en la APP
    Dado que <nombre> ingreso con cedula <cedula> y clave <clave> en el dispositivo <dispositivo>
    Cuando registra el usuario <usuario> e ingresa el correo <correo>
    Entonces se verifica que el sistema presente mensaje de registro exitoso
    Y se verifica el registro en el Log del Canal COMFFLGWWW

    Ejemplos:
      |nombre  |cedula   |clave  |dispositivo|usuario   |correo                   |
      |Alberto |58156995 |1234   |Android    |invictus02|dfrios@bancolombia.com.co|
      |Jorge   |58156996 |1234   |iOS        |invictus03|dfrios@bancolombia.com.co|
      |Bernardo|58156997 |1234   |Huawei     |invictus04|dfrios@bancolombia.com.co|

  @manual
  Esquema del escenario: Flujo transaccional Registro del usuario

    Dado que el cliente ingreso la cedula y la clave
    Cuando crea el usuario y registra el correo electronico
    Entonces deberia ver mensaje de registro exitoso
    Y se verifica  que se lancen las transacciones <Trn-1> <Trn-2> <Trn-3> <Trn-4> <Trn-5>

    Ejemplos:

      |Trn-1               |Trn-2                        |Trn-3          |Trn-4                           |Trn-5                      |
      |Autenticacion - 0369|Terminos y condiciones - 4002|Registro - 4001|Registro en Comunidad APP - 1700|Saldos consolidados - 1756|