Feature: Disponibilidad de fecha de vuelos

  Background: Ingresar a la pagina de reserva

  Scenario: Fecha de llegada proyectada mayor a 3 meses a la fecha del sistema
    When El cliente selecciona la fecha de llegada igual a hoy mas tres meses
    Then El cliente no puede seleccionar dicha fecha

  Scenario: Fecha de llegada inferior a la fecha actual
    When El cliente selecciona la fecha de llegada anterior a la fecha actual
    Then El cliente no puede seleccionar dicha fecha

