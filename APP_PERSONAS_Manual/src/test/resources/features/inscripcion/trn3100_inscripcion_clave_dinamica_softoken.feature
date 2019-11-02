#language: es

Característica: Trn-3100 Inscripcion a clave dinamica por softoken en la APP
  Como usuario de la APP Bancolombia
  Quiero realizar la inscribicion a clave dinamica
  Para realizar transacciones de manera segura

  @manual
  Esquema del escenario: Inscripcion clave dinamica
    Dado que <nombre> se encuentra enrolado en la APP con el usuario <usuario>
    Cuando intenta realizar la inscripcion a clave dinamica en el dispostivo <dispositivo>
    Entonces deberia ver el mensaje <mensaje>
    Y se verifica el registro en el Log del Canal COMFFLGWWW

    Ejemplos:
      |nombre |usuario   |dispositivo|mensaje            |
      |Alberto|invictus02|Android    |Inscripcion exitosa|
      |Alberto|invictus02|iOS        |Inscripcion exitosa|
      |Alberto|invictus02|Huawei     |Inscripcion exitosa|

  @manual
  Esquema del escenario: Flujo transaccional Inscripcion Clave dinamica

    Dado que el usuario esta en la APP
    Cuando realiza la inscripcion a clave dinamica por softoken
    Entonces deberia ver el mensaje de inscripcion exitosa
    Y se verifica  que se lancen las transacciones <Trn-1> <Trn-2> <Trn-3> <Trn-4> <Trn-5> <Trn-6> <Trn-7> <Trn-8>

    Ejemplos:

      |Trn-1               |Trn-2                     |Trn-3                               |Trn-4        |Trn-5                          |Trn-6                               |Trn-7                            |Trn-8                            |
      |Autenticacion - 0369|Consulta Info OTP - 3700|Clave dinamica data seguridad - 3900|GetPin - 3200|Validar codigo seguridad - 3300|Clave dinamica data seguridad - 3900|Inscripcion clave dinamica - 3100|Notificar enrolamiento OTP - 3101|