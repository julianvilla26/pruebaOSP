#language: es

Característica: Realizar una transferencia a productos inscritos

  Esquema del escenario: Transferencia a productos inscritos
    Dado que el Actor se autentica en la app
      | ID   | numeroDocumento   | tipoDocumento   | usuario   | clave   | segundaClave   | orientacion   | codigoError   | codigoTransaccion   | resultadoEsperado   | primeraPregunta   | validarClave   |
      | <ID> | <numeroDocumento> | <tipoDocumento> | <usuario> | <clave> | <segundaClave> | <orientacion> | <codigoError> | <codigoTransaccion> | <resultadoEsperado> | <primeraPregunta> | <validarClave> |
    Y el actor quiere TRANSFERIR_DINERO
    Cuando el transfiere desde <opcionProductoOrigen> hacia el producto <opcionProductoDestino>
      | tipoTransferencia   | numeroCuenta     | tipoCuenta           | monto   | productoDestino   | tipoProductoDestino   |
      | <tipoTransferencia> | <productoOrigen> | <tipoProductoOrigen> | <monto> | <productoDestino> | <tipoProductoDestino> |
    Entonces deberia ver la confirmacion exitosa de la transferencia
    Ejemplos:
      | ID | numeroDocumento | tipoDocumento        | usuario   | clave | segundaClave | orientacion | codigoError | codigoTransaccion | resultadoEsperado | primeraPregunta | validarClave | productoOrigen | tipoProductoOrigen | monto | tipoTransferencia                         | productoDestino | tipoProductoDestino | opcionProductoOrigen | opcionProductoDestino |
   ##@externaldata@./src/test/resources/datadriven/transferencia/Transferencia.xlsx@MismoBanco@3
      | 3  | 1010111         | Cédula de ciudadanía | testing10 | 1234  | 4321         | Alterno     | 000         | 0369              | NO ERROR          | bolp            | ACTIVO       | 406-139740-01  | Corriente          | 1000  | Productos propios e inscritos Bancolombia | 7001000033569   |                     | Mis productos        | Inscritos             |

  Esquema del escenario: Transferencia a productos inscritos desde cuenta deposito sin saldo
    Dado que el Actor se autentica en la app
      | ID   | numeroDocumento   | tipoDocumento   | usuario   | clave   | segundaClave   | orientacion   | codigoError   | codigoTransaccion   | resultadoEsperado   | primeraPregunta   | validarClave   |
      | <ID> | <numeroDocumento> | <tipoDocumento> | <usuario> | <clave> | <segundaClave> | <orientacion> | <codigoError> | <codigoTransaccion> | <resultadoEsperado> | <primeraPregunta> | <validarClave> |
    Y el actor quiere TRANSFERIR_DINERO
    Cuando el transfiere desde <opcionProductoOrigen> hacia el producto <opcionProductoDestino>
      | tipoTransferencia   | numeroCuenta     | tipoCuenta           | monto   | productoDestino   | tipoProductoDestino   |
      | <tipoTransferencia> | <productoOrigen> | <tipoProductoOrigen> | <monto> | <productoDestino> | <tipoProductoDestino> |
    Entonces deberia ver el mensaje de error: cuenta origen sin saldo
    Ejemplos:
      | ID | numeroDocumento | tipoDocumento        | usuario   | clave | segundaClave | orientacion | codigoError | codigoTransaccion | resultadoEsperado | primeraPregunta | validarClave | productoOrigen | tipoProductoOrigen | monto | tipoTransferencia                         | productoDestino | tipoProductoDestino | opcionProductoOrigen | opcionProductoDestino |
   ##@externaldata@./src/test/resources/datadriven/transferencia/Transferencia.xlsx@MismoBanco@9
      | 3  | 1010111         | Cédula de ciudadanía | testing10 | 1234  | 4321         | Alterno     | 000         | 0369              | NO ERROR          | bolp            | ACTIVO       | 406-139740-01  | Corriente          | 1000  | Productos propios e inscritos Bancolombia | 7001000033569   |                     | Mis productos        | Inscritos             |
