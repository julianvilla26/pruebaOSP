#language: es

Característica: Trn-3800 bloqueo de clave dinamica en app Bancolombia
  Como usuario de Bancolombia
  Quiero bloquear mi clave dinamica
  Para administrar la seguridad

  @manual
  Esquema del escenario: bloqueo de clave dinamica

    Dado que <usuario> esta en la APP en el dispositivo <dispositivo>
    Cuando selecciona bloquear clave dinamica
    Entonces deberia ver el mensaje de bloqueo exitoso
    Y se verifica el archivo COMMFFLGWWW

    Ejemplos:

      | usuario  | dispositivo |
      | Juan     | Android     |
      | Andres   | iOS         |
      | Luis     | Huawei      |

  @manual
  Esquema del escenario: flujo transaccional del bloqueo de la  clave dinamica

    Dado que el usuario esta en la APP
    Cuando selecciona bloquear clave dinamica
    Entonces deberia ver el mensaje de bloqueo exitoso
    Y se verifica  que se lancen las transacciones <Trn-1> <Trn-2>

    Ejemplos:


      | Trn-1 |  Trn-2 |
      |   Autenticacion - 0369    |Bloqueo OTP- 3800|