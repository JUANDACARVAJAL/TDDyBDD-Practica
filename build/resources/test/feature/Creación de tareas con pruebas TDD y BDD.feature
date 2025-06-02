Feature: Creación de nuevas tareas

  Scenario: Guardar una Tarea con titulo NULO
    Given El cliente intenta crear una tarea sin titulo
    When El cliente introduce un cuerpo valido con valor title = NULL
    Then El sistema retornara un error

  Scenario: Guardar una Tarea con Descripcion NULO
    Given El cliente intenta crear una tarea sin Descripcion
    When El cliente introduce un cuerpo valido con valor Descripcion = NULL
    Then El sistema retornara un error

  Scenario: Guardar una nueva tarea con campos obligatorios
    Given El cliente intenta crear una tarea con Titulo y descripcion
    When El cliente introduce valores validos para los campos Titulo y descripción
    Then El sistema pruede retornar los valores de Titulo y descripción

    Scenario: Crear nueva tarea y que retorne un 201
      Given El cliente intenta crear una tarea a traves del servicio
      When El cliente introduce un cuerpo valido
      Then El Cliente puede ver el cuerpo guardado y la respuesta 201