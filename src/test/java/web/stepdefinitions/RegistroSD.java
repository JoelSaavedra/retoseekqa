package web.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import web.steps.RegistroStep;

public class RegistroSD {
    @Steps
    RegistroStep registroStep;

    @Given("que el usuario está en la pagina IMGBB")
    public void queElUsuarioEstaEnLaPaginaIMGBB(){
        registroStep.queElUsuarioEstaEnLaPaginaIMGBB();
    }

    @When("damos click a Crear Cuenta")
    public void damosClickACrearCuenta(){
        registroStep.damosClickACrearCuenta();
    }

    @And("ingresa su correo {string} y usuario {string} y contraseña {string}")
    public void ingresaSuCorreoYUsuarioYContrasena(String correo, String usuario, String password){
        registroStep.ingresaSuCorreoYUsuarioYContrasena(correo, usuario, password);
    }

    @And("damos check a la casilla de términos y politica de privacidad")
    public void damosCheckALaCasillaDeTerminosYPoliticaDePrivacidad(){
        registroStep.damosCheckALaCasillaDeTerminosYPoliticaDePrivacidad();
    }

    @And("damos click al boton Crear Cuenta")
    public void damosClickAlBotonCrearCuenta(){
        registroStep.damosClickAlBotonCrearCuenta();
    }

    @Then("visualizamos el mensaje de activacion de cuenta por correo")
    public void visualizamosElMensajeDeActivacionDeCuentaPorCorreo(){
        registroStep.visualizamosElMensajeDeActivacionDeCuentaPorCorreo();
    }

}
