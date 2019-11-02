#language: es

Característica: Trn-0369 Autenticacion usuario en la APP Bancolombia
  Como usuario de Bancolombia
  Quiero autenticarme en la APP con mi usuario y clave
  Para interactuar con el menu de opciones de la aplicacion

  @manual
  Esquema del escenario: Autenticacion del usuario en la APP
    Dado que <nombre> se encuentra enrolado en la APP
    Cuando ingresa el usuario <usuario> y la clave <clave> con estado <estado> en el dispositivo <dispositivo>
    Entonces deberia ver que el sistema <resultado>
    Y se verifica el registro en el Log del Canal COMFFLGWWW

    Ejemplos:
      |nombre|usuario   |clave|estado   |dispositivo|resultado                                   |
      |Luis  |invictus01|1234 |activa   |Android    |permite iniciar sesion                      |
      |Luis  |invictus01|1234 |activa   |iOS        |permite iniciar sesion                      |
      |Luis  |invictus01|1234 |activa   |Huawei     |permite iniciar sesion                      |
      |Luis  |invictus01|2354 |activa   |Android    |muestra el mensaje: Usuario o clave invalida|
      |Luis  |invictus01|1362 |activa   |iOS        |muestra el mensaje: Usuario o clave invalida|
      |Luis  |invictus01|3625 |activa   |Huawei     |muestra el mensaje: Usuario o clave invalida|
      |Luis  |invictus01|1234 |bloqueada|Android    |muestra el mensaje: Clave bloqueada         |
      |Luis  |invictus01|1234 |bloqueada|iOS        |muestra el mensaje: Clave bloqueada         |
      |Luis  |invictus01|1234 |bloqueada|Huawei     |muestra el mensaje: Clave bloqueada         |

  @manual
  Esquema del escenario: Flujo transaccional Autenticacion del usuario

    Dado que el usuario esta en la APP
    Cuando ingresa las credenciales de autenticacion
    Entonces deberia iniciar sesion
    Y se verifica  que se lancen las transacciones <Trn-1> <Trn-2>

    Ejemplos:

      |Trn-1               |Trn-2                     |
      |Autenticacion - 0369|Saldos consolidados - 1756|