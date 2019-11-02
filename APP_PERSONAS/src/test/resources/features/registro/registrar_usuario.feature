#language: es

Característica: Registro en la APP personas bancolombia OSP
  Como usuario de Bancolombia
  Quiero realizar el registro de un usuario
  Para realizar la autenticacion en la app

  Esquema del escenario: Registrar un usuario y su nickname es el numero de identificacion
    Dado que el Actor carga los datos para la prueba
      | ID   | numeroDocumento   | tipoDocumento   | usuario   | clave   | segundaClave   | orientacion   | codigoError   | codigoTransaccion   | resultadoEsperado   | primeraPregunta   | validarClave   |
      | <ID> | <numeroDocumento> | <tipoDocumento> | <usuario> | <clave> | <segundaClave> | <orientacion> | <codigoError> | <codigoTransaccion> | <resultadoEsperado> | <primeraPregunta> | <validarClave> |
    Cuando quiero CONSULTAR_PRODUCTO del usuario <usuario> con clave <clave>
    Y quiere realizar el registro despues
    Entonces el deberia ver la pantalla de registro luego de autenticarse con su identificacion
    Ejemplos:
      | ID | numeroDocumento | tipoDocumento | usuario    | clave | segundaClave | orientacion | codigoError | codigoTransaccion | resultadoEsperado | primeraPregunta | validarClave | nuevoUser | correoUsuario | opcionAutenticacion |
   ##@externaldata@./src/test/resources/datadriven/registro/RegistroUsuario.xlsx@Datos@1
   |1   |30001024   |1   |30001023   |1234   |4321   |Acierto   |000   |0369   |NO ERROR   |bolp   |ACTIVO   |userauto50   |jalzate@todo1.net   |CONSULTAR_PRODUCTO|

  Esquema del escenario: Registrar usuario con documento de identidad desde mis Productos
    Dado que el Actor carga los datos para la prueba
      | ID   | numeroDocumento   | tipoDocumento   | usuario   | clave   | segundaClave   | orientacion   | codigoError   | codigoTransaccion   | resultadoEsperado   | primeraPregunta   | validarClave   |
      | <ID> | <numeroDocumento> | <tipoDocumento> | <usuario> | <clave> | <segundaClave> | <orientacion> | <codigoError> | <codigoTransaccion> | <resultadoEsperado> | <primeraPregunta> | <validarClave> |
    Cuando quiero <opcionAutenticacion> del usuario <usuario> con clave <clave>
    Y quiere realizar el registro con el usuario <nuevoUser> y con el correo <correoUsuario>
    Entonces el deberia de ver un mensaje de registro exitoso
    Ejemplos:
      | ID | numeroDocumento | tipoDocumento | usuario  | clave | segundaClave | orientacion | codigoError | codigoTransaccion | resultadoEsperado | primeraPregunta | validarClave | nuevoUser   | correoUsuario     | opcionAutenticacion |
   ##@externaldata@./src/test/resources/datadriven/registro/RegistroUsuario.xlsx@Datos@1
   |1   |30001024   |1   |30001023   |1234   |4321   |Acierto   |000   |0369   |NO ERROR   |bolp   |ACTIVO   |userauto50   |jalzate@todo1.net   |CONSULTAR_PRODUCTO|

  Esquema del escenario:Registrar usuario con documento de identidad desde otra opcion
    Dado que el Actor carga los datos para la prueba
      | ID   | numeroDocumento   | tipoDocumento   | usuario   | clave   | segundaClave   | orientacion   | codigoError   | codigoTransaccion   | resultadoEsperado   | primeraPregunta   | validarClave   |
      | <ID> | <numeroDocumento> | <tipoDocumento> | <usuario> | <clave> | <segundaClave> | <orientacion> | <codigoError> | <codigoTransaccion> | <resultadoEsperado> | <primeraPregunta> | <validarClave> |
    Cuando quiero <opcionAutenticacion> del usuario <usuario> con clave <clave>
    Y quiere realizar el registro con el usuario <nuevoUser> y con el correo <correoUsuario>
    Entonces el deberia de ver un mensaje de registro exitoso
    Ejemplos:
      | ID | numeroDocumento | tipoDocumento | usuario   | clave | segundaClave | orientacion | codigoError | codigoTransaccion | resultadoEsperado | primeraPregunta | validarClave | nuevoUser   | correoUsuario     |opcionAutenticacion |
   ##@externaldata@./src/test/resources/datadriven/registro/RegistroUsuario.xlsx@Datos@2
   |2   |30001022   |1   |30001022   |1234   |4321   |Acierto   |000   |0369   |NO ERROR   |bolp   |ACTIVO   |userauto51   |jalzate@todo1.net   |RECARGAR_EPREPAGO|

  Esquema del escenario: Registrar un usuario que ya este registrado
    Dado que el Actor carga los datos para la prueba
      | ID   | numeroDocumento   | tipoDocumento   | usuario   | clave   | segundaClave   | orientacion   | codigoError   | codigoTransaccion   | resultadoEsperado   | primeraPregunta   | validarClave   |
      | <ID> | <numeroDocumento> | <tipoDocumento> | <usuario> | <clave> | <segundaClave> | <orientacion> | <codigoError> | <codigoTransaccion> | <resultadoEsperado> | <primeraPregunta> | <validarClave> |
    Cuando quiero <opcionAutenticacion> del usuario <usuario> con clave <clave>
    Entonces el deberia de ver el mensaje usuario o clave invalida
    Ejemplos:
      | ID | numeroDocumento | tipoDocumento | usuario    | clave | segundaClave | orientacion | codigoError | codigoTransaccion | resultadoEsperado | primeraPregunta | validarClave | nuevoUser | correoUsuario | opcionAutenticacion |
   ##@externaldata@./src/test/resources/datadriven/registro/RegistroUsuario.xlsx@Datos@3
   |3   |22480139   |1   |87576481   |1234   |4321   |Acierto   |001   |0370   |NO ERROR   |bolp   |ACTIVO   |   |   |CONSULTAR_PRODUCTO|

  Esquema del escenario: Registrar un usuario con clave bloqueada
    Dado que el Actor carga los datos para la prueba
      | ID   | numeroDocumento   | tipoDocumento   | usuario   | clave   | segundaClave   | orientacion   | codigoError   | codigoTransaccion   | resultadoEsperado   | primeraPregunta   | validarClave   |
      | <ID> | <numeroDocumento> | <tipoDocumento> | <usuario> | <clave> | <segundaClave> | <orientacion> | <codigoError> | <codigoTransaccion> | <resultadoEsperado> | <primeraPregunta> | <validarClave> |
    Cuando quiero <opcionAutenticacion> del usuario <usuario> con clave <clave>
    Entonces el deberia de ver el mensaje de usuario bloqueado
    Ejemplos:
      | ID | numeroDocumento | tipoDocumento | usuario | clave | segundaClave | orientacion | codigoError | codigoTransaccion | resultadoEsperado | primeraPregunta | validarClave | nuevoUser   | correoUsuario     | opcionAutenticacion |
   ##@externaldata@./src/test/resources/datadriven/registro/RegistroUsuario.xlsx@Datos@4
   |4   |4425412   |1   |4425412   |1234   |4321   |Acierto   |001   |0370   |NO ERROR   |bolp   |ACTIVO   |   |   |CONSULTAR_PRODUCTO|
