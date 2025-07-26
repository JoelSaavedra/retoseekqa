#lang:en
@Login-CP01
Feature: Login de Usuario en IMGB

  Scenario: Validar inicio de sesión con credenciales válidas
    Given que el usuario está en la pagina IMGBB
    When damos click a Entrar
    And ingresa su correo "pruebaretoone@gmail.com" y contraseña "PruebaQAReto."
    And damos click al boton Entrar
    Then visualizaremos la pantalla principal de IMGBB
