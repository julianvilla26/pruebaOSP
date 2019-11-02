#language: es

Característica: Cargar tarjeta virtual ePrepago
  Yo como usuario de la app Personas Bancolombia quiero cargar mi tarjeta virtual ePrepago para tener saldo

  Esquema del escenario: Carga exitosa a tarjeta virtual ePrepago activa
    Dado que el Actor se autentica en la app
      | ID   | numeroDocumento   | tipoDocumento   | usuario   | clave   | segundaClave   | orientacion   | codigoError   | codigoTransaccion   | resultadoEsperado   | primeraPregunta   | validarClave   |
      | <ID> | <numeroDocumento> | <tipoDocumento> | <usuario> | <clave> | <segundaClave> | <orientacion> | <codigoError> | <codigoTransaccion> | <resultadoEsperado> | <primeraPregunta> | <validarClave> |
    Cuando el actor quiere RECARGAR_EPREPAGO
    Y realiza la carga por valor de <valorRecarga>
      | tipoCuenta   | numeroCuenta   |
      | <tipoCuenta> | <numeroCuenta> |
    Entonces el deberia de ver un mensaje de carga de tarjeta virtual ePrepago exitosa
    Y cierra sesion en la app
    Ejemplos:
      | ID | numeroDocumento | tipoDocumento | usuario    | clave | segundaClave | orientacion | codigoError | codigoTransaccion | resultadoEsperado | primeraPregunta | validarClave | valorRecarga | tipoCuenta | numeroCuenta  |
  ##@externaldata@./src/test/resources/datadriven/eprepago/recargar_tarjeta_virtual_eprepago.xlsx@Datos@1
   |1   |93221450   |1   |autotest25   |1234   |4321   |Acierto   |000   |0369   |NO ERROR   |bolp   |ACTIVO   |1000000   |Ahorros   |406-714500-19|

  Esquema del escenario: Carga a tarjeta virtual ePrepago inactiva
    Dado que el Actor se autentica en la app
      | ID   | numeroDocumento   | tipoDocumento   | usuario   | clave   | segundaClave   | orientacion   | codigoError   | codigoTransaccion   | resultadoEsperado   | primeraPregunta   | validarClave   |
      | <ID> | <numeroDocumento> | <tipoDocumento> | <usuario> | <clave> | <segundaClave> | <orientacion> | <codigoError> | <codigoTransaccion> | <resultadoEsperado> | <primeraPregunta> | <validarClave> |
    Cuando el actor quiere RECARGAR_EPREPAGO
    Y realiza la carga por valor de <valorRecarga>
      | tipoCuenta   | numeroCuenta   |
      | <tipoCuenta> | <numeroCuenta> |
    Entonces el deberia de ver un mensaje de carga de tarjeta virtual ePrepago exitosa
    Y cierra sesion en la app
    Ejemplos:
      | ID | numeroDocumento | tipoDocumento | usuario    | clave | segundaClave | orientacion | codigoError | codigoTransaccion | resultadoEsperado | primeraPregunta | validarClave | valorRecarga | tipoCuenta | numeroCuenta  |
    ##@externaldata@./src/test/resources/datadriven/eprepago/recargar_tarjeta_virtual_eprepago.xlsx@Datos@2
   |2   |93221453   |1   |autotest28   |1234   |4321   |Acierto   |000   |0369   |NO ERROR   |bolp   |ACTIVO   |10000   |Ahorros   |406-714530-16|

  Esquema del escenario: Carga a tarjeta virtual ePrepago sobre el valor maximo permitido
    Dado que el Actor se autentica en la app
      | ID   | numeroDocumento   | tipoDocumento   | usuario   | clave   | segundaClave   | orientacion   | codigoError   | codigoTransaccion   | resultadoEsperado   | primeraPregunta   | validarClave   |
      | <ID> | <numeroDocumento> | <tipoDocumento> | <usuario> | <clave> | <segundaClave> | <orientacion> | <codigoError> | <codigoTransaccion> | <resultadoEsperado> | <primeraPregunta> | <validarClave> |
    Cuando el actor quiere RECARGAR_EPREPAGO
    Y realiza la carga sobre el valor maximo por valor de <valorRecarga>
      | tipoCuenta   | numeroCuenta   |
      | <tipoCuenta> | <numeroCuenta> |
    Entonces el deberia ver un mensaje de monto para cargar no permitido
    Ejemplos:
      | ID | numeroDocumento | tipoDocumento | usuario    | clave | segundaClave | orientacion | codigoError | codigoTransaccion | resultadoEsperado | primeraPregunta | validarClave | valorRecarga | tipoCuenta | numeroCuenta  |
    ##@externaldata@./src/test/resources/datadriven/eprepago/recargar_tarjeta_virtual_eprepago.xlsx@Datos@2
   |2   |93221453   |1   |autotest28   |1234   |4321   |Acierto   |000   |0369   |NO ERROR   |bolp   |ACTIVO   |10000   |Ahorros   |406-714530-16|

  Esquema del escenario: Cargar tarjeta virtual ePrepago con cuenta sin saldo
    Dado que el Actor se autentica en la app
      | ID   | numeroDocumento   | tipoDocumento   | usuario   | clave   | segundaClave   | orientacion   | codigoError   | codigoTransaccion   | resultadoEsperado   | primeraPregunta   | validarClave   |
      | <ID> | <numeroDocumento> | <tipoDocumento> | <usuario> | <clave> | <segundaClave> | <orientacion> | <codigoError> | <codigoTransaccion> | <resultadoEsperado> | <primeraPregunta> | <validarClave> |
    Cuando el actor quiere RECARGAR_EPREPAGO
    Y realiza la carga por valor de <valorRecarga>
      | tipoCuenta   | numeroCuenta   |
      | <tipoCuenta> | <numeroCuenta> |
    Entonces deberia ver el mensaje de error: cuenta origen sin saldo
    Ejemplos:
      | ID | numeroDocumento | tipoDocumento | usuario    | clave | segundaClave | orientacion | codigoError | codigoTransaccion | resultadoEsperado | primeraPregunta | validarClave | valorRecarga | tipoCuenta | numeroCuenta  |
    ##@externaldata@./src/test/resources/datadriven/eprepago/recargar_tarjeta_virtual_eprepago.xlsx@Datos@2
   |2   |93221453   |1   |autotest28   |1234   |4321   |Acierto   |000   |0369   |NO ERROR   |bolp   |ACTIVO   |10000   |Ahorros   |406-714530-16|
