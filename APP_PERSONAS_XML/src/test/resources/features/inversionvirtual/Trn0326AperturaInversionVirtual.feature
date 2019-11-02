#language: es

Característica: APP Personas Bancolombia
 Una persona debe poder acceder a la aplicacion
 bancolombia si se autentica con un nombre de usuario y clave, para luego realizar la apertura inversion virtual.

 @CasoExitoso1
 Esquema del escenario: Aperturar la inversion virtual de manera exitosa en la aplicacion de APP Personas
  Dado que yo subo los datos para la prueba de apertura inversion virtual
   | <ID> | <orientacion> | <codigoError> | <codigoTransaccion> | <resultadoEsperado>|
   | <numeroDocumento> | <tipoDocumento> | <usuario> | <clave> | <segundaClave> |
   | <CuentaOrigen> | <TipoCuentaOrigen> | <Monto> | | |
   | <Periodicidad> | <Plazo> | <TasaEfectiva> | | |
   | <VersionTYC> | | | | |
  Cuando Intento autenticarme utilizando mis credenciales
  Y Realizo la apertura de la inversion virtual
  Entonces Verifico la apertura de la inversion virtual
  Y Verifico los resultados en los archivos de iseries
   |SALDOS-SCIFFSALDO_DEBITO | MOVIMIENTO-SCIFFMRCMV_DEBITO | TEF Y MOVTF-PCCFFMOVTFLOGTF_DEBITO | DEPOSITOS TOTALES-SCIFFSALDO_TOTALES |

  Ejemplos:
   | ID | numeroDocumento | tipoDocumento | usuario | clave | segundaClave | orientacion | codigoError | codigoTransaccion | resultadoEsperado | CuentaOrigen |  TipoCuentaOrigen | Monto | Periodicidad | Plazo |TasaEfectiva | VersionTYC |
    ##@externaldata@./src/test/resources/datadriven/inversionvirtual/Trn_0326Apertura.xlsx@Datos@1
      |1|35806340|1|nose|2443|4321|Acierto|000|0326|TRANSACCION EXITOSA|40676340007|Ahorros|550000|ATEXPIRATION|90|2.89|1.8|
