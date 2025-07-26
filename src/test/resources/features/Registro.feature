#lang:en
@Registro-CP01
Feature: Registro de Usuario en IMGBB

  Scenario Outline: Validar el registro de usuario con email y contraseña válidos
    Given que el usuario está en la pagina IMGBB
    When damos click a Crear Cuenta
    And ingresa su correo "<correo>" y usuario "<usuario>" y contraseña "<contrasena>"
    And damos check a la casilla de términos y politica de privacidad
    And damos click al boton Crear Cuenta
    Then visualizamos el mensaje de activacion de cuenta por correo

    Examples:
    | correo | usuario | contrasena |
    | RetoSeek4@gmail.com | RetoOne1 | Pass@123. |

