#language: es

Característica: Autenticacion app Bancolombia
  Como usuario de Bancolombia
  Quiero ingresar usuario y contrasena
  Para autenticarme en la aplicación

  @Manual:Passed
  Esquema del escenario: Login exitoso a la aplicacion de Bancolombia OSP desde diferentes opciones
    Dado que el Actor carga los datos para la prueba
      | <ID> | <orientacion> | <codigoError> | <codigoTransaccion> | <resultadoEsperado> | <tipoDocumento> | <numeroDocumento> | <segundaClave> | <primeraPregunta> | <validarClave> |
    Cuando quiero <opcionAutenticacion> del usuario <usuario> con clave <clave>
    Entonces la autenticacion deberia de ser exitosa
    Y cierra sesion en la app
    #Y Verifico los resultados en los archivos de iseries
      #| LOG CANAL-COMFFLGWWW |
    Ejemplos:
      | ID | numeroDocumento | tipoDocumento | usuario | clave | segundaClave | orientacion | codigoError | codigoTransaccion | resultadoEsperado | primeraPregunta | validarClave | opcionAutenticacion |
   ##@externaldata@./src/test/resources/datadriven/autenticacion/Autenticacion.xlsx@Datos@1
   |1   |43024987   |1   |automata87   |1234   |4321   |Acierto   |000   |0369   |NO ERROR   |bolp   |ACTIVO   |CONSULTAR_PRODUCTO|

  Esquema del escenario: Login exitoso a la aplicacion de Bancolombia OSP
    Dado que el Actor carga los datos para la prueba
      | ID   | numeroDocumento   | tipoDocumento   | usuario   | clave   | segundaClave   | orientacion   | codigoError   | codigoTransaccion   | resultadoEsperado   | primeraPregunta   | validarClave   |
      | <ID> | <numeroDocumento> | <tipoDocumento> | <usuario> | <clave> | <segundaClave> | <orientacion> | <codigoError> | <codigoTransaccion> | <resultadoEsperado> | <primeraPregunta> | <validarClave> |
    Cuando quiero <opcionAutenticacion> del usuario <usuario> con clave <clave>
    Entonces la autenticacion deberia de ser exitosa
    Y cierra sesion en la app
    #Y Verifico los resultados en los archivos de iseries
      #| LOG CANAL-COMFFLGWWW |
    Ejemplos:
      | ID | numeroDocumento | tipoDocumento | usuario | clave | segundaClave | orientacion | codigoError | codigoTransaccion | resultadoEsperado | primeraPregunta | validarClave | opcionAutenticacion |
   ##@externaldata@./src/test/resources/datadriven/autenticacion/Autenticacion.xlsx@Datos@4
   |4   |43024987   |1   |testing10   |1234   |4321   |Acierto   |000   |0369   |NO ERROR   |bolp   |ACTIVO   |CONSULTAR_PRODUCTO|

  Esquema del escenario: Login fallido a la aplicacion de Bancolombia OSP
    Dado que el Actor carga los datos para la prueba
      | ID   | numeroDocumento   | tipoDocumento   | usuario   | clave   | segundaClave   | orientacion   | codigoError   | codigoTransaccion   | resultadoEsperado   | primeraPregunta   | validarClave   |
      | <ID> | <numeroDocumento> | <tipoDocumento> | <usuario> | <clave> | <segundaClave> | <orientacion> | <codigoError> | <codigoTransaccion> | <resultadoEsperado> | <primeraPregunta> | <validarClave> |
    Cuando quiero <opcionAutenticacion> del usuario <usuario> con clave <clave>
    Entonces la autenticacion deberia de ser fallida por clave invalida
    #Y Verifico los resultados en los archivos de iseries
      #| LOG CANAL-COMFFLGWWW |
    Ejemplos:
      | ID | numeroDocumento | tipoDocumento | usuario | clave | segundaClave | orientacion | codigoError | codigoTransaccion | resultadoEsperado | primeraPregunta | validarClave | opcionAutenticacion |
   ##@externaldata@./src/test/resources/datadriven/autenticacion/Autenticacion.xlsx@Datos@5
   |5   |45612862   |1   |testing10   |1267   |4321   |Alterno   |052   |0369   |CLAVE NO VALIDA   |bolp   |ACTIVO   |CONSULTAR_PRODUCTO|

  Esquema del escenario: Login con usuario bloqueado a la aplicacion de Bancolombia OSP
    Dado que el Actor carga los datos para la prueba
      | ID   | numeroDocumento   | tipoDocumento   | usuario   | clave   | segundaClave   | orientacion   | codigoError   | codigoTransaccion   | resultadoEsperado   | primeraPregunta   | validarClave   |
      | <ID> | <numeroDocumento> | <tipoDocumento> | <usuario> | <clave> | <segundaClave> | <orientacion> | <codigoError> | <codigoTransaccion> | <resultadoEsperado> | <primeraPregunta> | <validarClave> |
    Cuando quiero <opcionAutenticacion> del usuario <usuario> con clave <clave>
    Entonces la autenticacion deberia de ser fallida por usuario bloqueado
    #Y Verifico los resultados en los archivos de iseries
      #| LOG CANAL-COMFFLGWWW |
    Ejemplos:
      | ID | numeroDocumento | tipoDocumento | usuario | clave | segundaClave | orientacion | codigoError | codigoTransaccion | resultadoEsperado | primeraPregunta | validarClave | opcionAutenticacion |
   ##@externaldata@./src/test/resources/datadriven/autenticacion/Autenticacion.xlsx@Datos@6
   |6   |22493944   |1   |userrobot9   |1234   |4321   |Alterno   |607   |0370   |Clave bloqueada   |bolp   |ACTIVO   |CONSULTAR_PRODUCTO|
