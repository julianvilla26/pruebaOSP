#language: es

Característica: Realizar una transferencia a productos propios

  Esquema del escenario: Transferencia a productos propios
    Dado que el Actor se autentica en la app
      | ID   | numeroDocumento   | tipoDocumento   | usuario   | clave   | segundaClave   | orientacion   | codigoError   | codigoTransaccion   | resultadoEsperado   | primeraPregunta   | validarClave   |
      | <ID> | <numeroDocumento> | <tipoDocumento> | <usuario> | <clave> | <segundaClave> | <orientacion> | <codigoError> | <codigoTransaccion> | <resultadoEsperado> | <primeraPregunta> | <validarClave> |
    Y el actor quiere TRANSFERIR_DINERO
    Cuando el transfiere desde <opcionProductoOrigen> hacia el producto <opcionProductoDestino>
      | tipoTransferencia   | numeroCuenta     | tipoCuenta           | monto   | productoDestino   | tipoProductoDestino   |
      | <tipoTransferencia> | <productoOrigen> | <tipoProductoOrigen> | <monto> | <productoDestino> | <tipoProductoDestino> |
    Entonces deberia ver la confirmacion exitosa de la transferencia
    Ejemplos:
      | ID | numeroDocumento | tipoDocumento        | usuario      | clave | segundaClave | orientacion | codigoError | codigoTransaccion | resultadoEsperado | primeraPregunta | validarClave | productoOrigen | tipoProductoOrigen | monto | tipoTransferencia                         | productoDestino | tipoProductoDestino | opcionProductoOrigen | opcionProductoDestino |
   ##@externaldata@./src/test/resources/datadriven/transferencia/Transferencia.xlsx@MismoBanco@2
      | 2  | 1010111         | Cédula de ciudadanía | pruebauser01 | 6789  | 4321         | Alterno     | 000         | 0369              | NO ERROR          | bolp            | ACTIVO       | 406-182800-02  | Corriente          | 6000  | Productos propios e inscritos Bancolombia | 406-182800-03   | Corriente           | Mis productos        | Mis productos         |

  Esquema del escenario: Transferencia desde un fondo de inversion a inscritas Bancolombia cuenta inversión
    Dado que el Actor se autentica en la app
      | ID   | numeroDocumento   | tipoDocumento   | usuario   | clave   | segundaClave   | orientacion   | codigoError   | codigoTransaccion   | resultadoEsperado   | primeraPregunta   | validarClave   |
      | <ID> | <numeroDocumento> | <tipoDocumento> | <usuario> | <clave> | <segundaClave> | <orientacion> | <codigoError> | <codigoTransaccion> | <resultadoEsperado> | <primeraPregunta> | <validarClave> |
    Y el actor quiere TRANSFERIR_DINERO
    Cuando el transfiere desde <opcionProductoOrigen> hacia el producto <opcionProductoDestino>
      | tipoTransferencia   | numeroCuenta     | tipoCuenta           | monto   | productoDestino   | tipoProductoDestino   |
      | <tipoTransferencia> | <productoOrigen> | <tipoProductoOrigen> | <monto> | <productoDestino> | <tipoProductoDestino> |
    Entonces deberia ver la confirmacion exitosa de la transferencia
    Ejemplos:
      | ID | numeroDocumento | tipoDocumento        | usuario      | clave | segundaClave | orientacion | codigoError | codigoTransaccion | resultadoEsperado | primeraPregunta | validarClave | productoOrigen | tipoProductoOrigen | monto | tipoTransferencia                         | productoDestino | tipoProductoDestino | opcionProductoOrigen | opcionProductoDestino |
   ##@externaldata@./src/test/resources/datadriven/transferencia/Transferencia.xlsx@MismoBanco@7
      | 7  | 1010111         | Cédula de ciudadanía | pruebauser01 | 6789  | 4321         | Alterno     | 000         | 0369              | NO ERROR          | bolp            | ACTIVO       | 0437002003817  | FIDUCUENTA         | 2000  | Productos propios e inscritos Bancolombia | 0009000301809   | Inversión           | Inversiones          | Inscritos             |

  Esquema del escenario: Transferencia desde un fondo de inversion a inscritas Bancolombia a cuenta depósto
    Dado que el Actor se autentica en la app
      | ID   | numeroDocumento   | tipoDocumento   | usuario   | clave   | segundaClave   | orientacion   | codigoError   | codigoTransaccion   | resultadoEsperado   | primeraPregunta   | validarClave   |
      | <ID> | <numeroDocumento> | <tipoDocumento> | <usuario> | <clave> | <segundaClave> | <orientacion> | <codigoError> | <codigoTransaccion> | <resultadoEsperado> | <primeraPregunta> | <validarClave> |
    Y el actor quiere TRANSFERIR_DINERO
    Cuando el transfiere desde <opcionProductoOrigen> hacia el producto <opcionProductoDestino>
      | tipoTransferencia   | numeroCuenta     | tipoCuenta           | monto   | productoDestino   | tipoProductoDestino   |
      | <tipoTransferencia> | <productoOrigen> | <tipoProductoOrigen> | <monto> | <productoDestino> | <tipoProductoDestino> |
    Entonces deberia ver la confirmacion exitosa de la transferencia
    Ejemplos:
      | ID | numeroDocumento | tipoDocumento        | usuario      | clave | segundaClave | orientacion | codigoError | codigoTransaccion | resultadoEsperado | primeraPregunta | validarClave | productoOrigen | tipoProductoOrigen | monto | tipoTransferencia                         | productoDestino | tipoProductoDestino | opcionProductoOrigen | opcionProductoDestino |
   ##@externaldata@./src/test/resources/datadriven/transferencia/Transferencia.xlsx@MismoBanco@6
      | 6  | 1010111         | Cédula de ciudadanía | pruebauser01 | 6789  | 4321         | Alterno     | 000         | 0369              | NO ERROR          | bolp            | ACTIVO       | 0437002003817  | FIDUCUENTA         | 3000  | Productos propios e inscritos Bancolombia | 406-757180-07   | Ahorros             | Inversiones          | Inscritos             |

  Esquema del escenario: Transferencia desde un fondo de inversion a inscritas Bancolombia a cuenta depósto
    Dado que el Actor se autentica en la app
      | ID   | numeroDocumento   | tipoDocumento   | usuario   | clave   | segundaClave   | orientacion   | codigoError   | codigoTransaccion   | resultadoEsperado   | primeraPregunta   | validarClave   |
      | <ID> | <numeroDocumento> | <tipoDocumento> | <usuario> | <clave> | <segundaClave> | <orientacion> | <codigoError> | <codigoTransaccion> | <resultadoEsperado> | <primeraPregunta> | <validarClave> |
    Y el actor quiere TRANSFERIR_DINERO
    Cuando el transfiere desde <opcionProductoOrigen> hacia el producto <opcionProductoDestino>
      | tipoTransferencia   | numeroCuenta     | tipoCuenta           | monto   | productoDestino   | tipoProductoDestino   |
      | <tipoTransferencia> | <productoOrigen> | <tipoProductoOrigen> | <monto> | <productoDestino> | <tipoProductoDestino> |
    Entonces deberia ver el mensaje de error: cuenta origen sin saldo
    Ejemplos:
      | ID | numeroDocumento | tipoDocumento        | usuario      | clave | segundaClave | orientacion | codigoError | codigoTransaccion | resultadoEsperado | primeraPregunta | validarClave | productoOrigen | tipoProductoOrigen | monto | tipoTransferencia                         | productoDestino | tipoProductoDestino | opcionProductoOrigen | opcionProductoDestino |
   ##@externaldata@./src/test/resources/datadriven/transferencia/Transferencia.xlsx@MismoBanco@11
      | 6  | 1010111         | Cédula de ciudadanía | pruebauser01 | 6789  | 4321         | Alterno     | 000         | 0369              | NO ERROR          | bolp            | ACTIVO       | 0437002003817  | FIDUCUENTA         | 3000  | Productos propios e inscritos Bancolombia | 406-757180-07   | Ahorros             | Inversiones          | Inscritos             |
