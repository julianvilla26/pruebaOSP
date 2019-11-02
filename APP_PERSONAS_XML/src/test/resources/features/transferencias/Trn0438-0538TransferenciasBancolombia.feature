@E2E_APP_PERSONAS
Feature: APP Personas Bancolombia
  A person must be able to access the transactional site APP persons Bancolombia and authenticate with user and
  password and be able to consult the detail of a Card e-Prepago.

  @TestCase1
  Scenario Outline:  TRN0438-0538 Successful transfers bancolombia to the APP Personas Bancolombia

    Given I Upload the Transaction Data
      | <ID> | <RutaEvidencia> | <RutaLogCanal> | <NombreEvidencia> | <orientacion> | <codigoError> | <codigoTransaccion> | <resultadoEsperado> |
    When I try to authenticate myself using my credentials
      | <numeroDocumento> | <tipoDocumento> | <usuario> | <clave> | <segundaClave> |
    And I verify the authentication
    And Previous consultations transfer bancolombia
      | <CuentaOrigen> | <TipoCuentaOrigen> | <CuentaDestino> | <TipoCuentaDestino> | <Monto> |
    And I transfer to Bancolombia Accounts
    And Subsequent consultations transfer bancolombia
    Then I verify the transfer bancolombia result
    And I verify the debit of the balance in the SCIFFSALDO
    #And he can see the verification in the LogCanal-COMFFLGWWW

    Examples:
      | ID | RutaEvidencia | RutaLogCanal                                          | NombreEvidencia       | numeroDocumento | tipoDocumento | usuario   | clave | segundaClave | orientacion | codigoError | codigoTransaccion | resultadoEsperado | CuentaOrigen |  TipoCuentaOrigen | CuentaDestino |  TipoCuentaDestino | Monto |
    ##@externaldata@./src/test/resources/datadriven/transfers/Trn_0438-0538TransferenciasBancolombia.xlsx@Datos@1
   |1   |./logs/   |./src/test/resources/logs/canal/TRN0438_0538_LogCanal.xlsx   |TRN0438_0538_LogCanal.xlsx   |1035655536   |1   |banana01   |1223   |1234   |Acierto   |000   |0438   |TRANSACCION EXITOSA   |40675536005   |Ahorros   |40615536000   |Corriente   |12000|
