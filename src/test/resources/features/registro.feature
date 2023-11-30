@Regression
Feature: COMO usuario del sistema. QUIERO registrar nuevos usuarios. PARA QUE sea posible almacenar y gestionar sus datos.

  @Nombre @Error
  Scenario Outline: Visualizar los errores del campo Nombre
    Given me encuentro ubicado en el formulario de registro
    When completo el campo Nombre con '<name>'
    And clickeo el boton de Registrar
    Then veo el error '<message>' en el campo Nombre

    Examples:
      | name | message                             |
      |      | O campo Nome é obrigatório.         |
      | asd  | Por favor, insira um nome completo. |

  @Email @Error
  Scenario Outline: Visualizar los errores del campo E-mail
    Given me encuentro ubicado en el formulario de registro
    When completo el campo E-mail con '<email>'
    And clickeo el boton de Registrar
    Then veo el error '<message>' en el campo E-mail

    Examples:
      | email      | message                             |
      |            | O campo E-mail é obrigatório.       |
      | a@.com     | Por favor, insira um e-mail válido. |
      | @gmail.com | Por favor, insira um e-mail válido. |

  @Password @Error
  Scenario Outline: Visualizar los errores del campo Contraseña
    Given me encuentro ubicado en el formulario de registro
    When completo el campo Contraseña con '<password>'
    And clickeo el boton de Registrar
    Then veo el error '<message>' en el campo Contraseña

    Examples:
      | password | message                                    |
      |          | O campo Senha é obrigatório.               |
      | 1234567  | A senha deve conter ao menos 8 caracteres. |

  @Smoke @Registro @Exitoso
  Scenario Outline: Realizar un registro exitoso
    Given me encuentro ubicado en el formulario de registro
    When completo el campo Nombre con '<name>'
    And completo el campo E-mail con '<email>'
    And completo el campo Contraseña con '<password>'
    And clickeo el boton de Registrar
    Then veo el Id '1', Nombre '<name>' y E-mail '<email>' en Usuarios registrados

    Examples:
      | name               | email          | password |
      | Firstname Lastname | test@gmail.com | password |

  @Smoke @Eliminar @Exitoso
  Scenario: Realizar la eliminacion de un usuario registrado
    Given me encuentro ubicado en el formulario de registro
    And completo el campo Nombre con 'Firstname Lastname'
    And completo el campo E-mail con 'test@gmail.com'
    And completo el campo Contraseña con 'password'
    And clickeo el boton de Registrar

    When clickeo el boton de Eliminar en el primer usuario
    Then la tabla de usuarios registrados esta vacia