#language: es

Característica: Inactivacion eprepago en la app OSP Bancolombia
  Como usuario de Bancolombia
  Quiero inactivar una tarjeta eprepago
  Para realizar compras

  Esquema del escenario: Inactivacion de tarjeta eprepago desde la app de Bancolombia OSP por mis productos
    Dado que el Actor se autentica en la app
      | ID   | numeroDocumento   | tipoDocumento   | usuario   | clave   | segundaClave   | orientacion   | codigoError   | codigoTransaccion   | resultadoEsperado   | primeraPregunta   | validarClave   |
      | <ID> | <numeroDocumento> | <tipoDocumento> | <usuario> | <clave> | <segundaClave> | <orientacion> | <codigoError> | <codigoTransaccion> | <resultadoEsperado> | <primeraPregunta> | <validarClave> |
    Cuando el actor quiere INACTIVAR_EPREPAGO
    Y inactiva la tarjeta
    Entonces deberia de ver un mensaje de inactivacion exitosa para su eprepago
    Ejemplos:
      | ID | numeroDocumento | tipoDocumento | usuario           | clave | segundaClave | orientacion | codigoError | codigoTransaccion | resultadoEsperado | primeraPregunta | validarClave | opcionAutenticacion |
   ##@externaldata@./src/test/resources/datadriven/eprepago/inactivacion_eprepago.xlsx@Datos@1
      | 1  | 700101          | 1             | pruebasregistro49 | 1234  | 4321         | Acierto     | 000         | 0369              | NO ERROR          | bolp            | ACTIVO       | CONSULTAR_PRODUCTO  |

  Esquema del escenario: Inactivacion de tarjeta eprepago con maximo numero de intentos
    Dado que el Actor se autentica en la app
      | ID   | numeroDocumento   | tipoDocumento   | usuario   | clave   | segundaClave   | orientacion   | codigoError   | codigoTransaccion   | resultadoEsperado   | primeraPregunta   | validarClave   |
      | <ID> | <numeroDocumento> | <tipoDocumento> | <usuario> | <clave> | <segundaClave> | <orientacion> | <codigoError> | <codigoTransaccion> | <resultadoEsperado> | <primeraPregunta> | <validarClave> |
    Cuando el actor quiere INACTIVAR_EPREPAGO
    Y inactiva la tarjeta
    Entonces el deberia de ver un mensaje de maximo numero de intentos
    Ejemplos:
      | ID | numeroDocumento | tipoDocumento | usuario           | clave | segundaClave | orientacion | codigoError | codigoTransaccion | resultadoEsperado | primeraPregunta | validarClave | opcionAutenticacion |
   ##@externaldata@./src/test/resources/datadriven/eprepago/inactivacion_eprepago.xlsx@Datos@1
      | 1  | 700101          | 1             | pruebasregistro49 | 1234  | 4321         | Acierto     | 000         | 0369              | NO ERROR          | bolp            | ACTIVO       | CONSULTAR_PRODUCTO  |

  Esquema del escenario: Cancelar inactivacion de tarjeta eprepago desde la app de Bancolombia OSP por mis productos
    Dado que el Actor se autentica en la app
      | ID   | numeroDocumento   | tipoDocumento   | usuario   | clave   | segundaClave   | orientacion   | codigoError   | codigoTransaccion   | resultadoEsperado   | primeraPregunta   | validarClave   |
      | <ID> | <numeroDocumento> | <tipoDocumento> | <usuario> | <clave> | <segundaClave> | <orientacion> | <codigoError> | <codigoTransaccion> | <resultadoEsperado> | <primeraPregunta> | <validarClave> |
    Cuando el actor quiere INACTIVAR_EPREPAGO
    Y cancelo la inactivacion e-prepago
    Entonces no se deberia realizar la accion

    Ejemplos:
      | ID | numeroDocumento | tipoDocumento | usuario           | clave | segundaClave | orientacion | codigoError | codigoTransaccion | resultadoEsperado | primeraPregunta | validarClave | opcionAutenticacion |
   ##@externaldata@./src/test/resources/datadriven/eprepago/inactivacion_eprepago.xlsx@Datos@1
      | 1  | 700101          | 1             | pruebasregistro49 | 1234  | 4321         | Acierto     | 000         | 0369              | NO ERROR          | bolp            | ACTIVO       | CONSULTAR_PRODUCTO  |
