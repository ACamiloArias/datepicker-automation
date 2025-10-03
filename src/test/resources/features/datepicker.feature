Feature: JQuery Datepicker Automation

  Scenario: Reserva de una cita seleccionando una fecha en el calendario
    Given que el usuario abre la pagina de JQuery Datepicker
    When selecciona el dia 15 del mes actual
    Then deberia ver la fecha seleccionada en el campo de texto

  Scenario: Selección de una fecha específica en un mes diferente
    Given que el usuario abre la pagina de JQuery Datepicker
    When selecciona el dia 10 del proximo mes
    Then deberia ver la fecha del proximo mes en el campo de texto

  Scenario: Validación de campo bloqueado
    Given que el usuario abre la pagina de JQuery Datepicker
    When intenta ingresar una fecha manualmente
    Then no deberia permitir la edicion manual del campo