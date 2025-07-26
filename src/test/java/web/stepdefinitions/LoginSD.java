package web.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import web.steps.LoginStep;

public class LoginSD {
    @Steps
    LoginStep loginStep;

    @When("damos click a Entrar")
    public void damosClickAEntrar(){
        loginStep.damosClickAEntrar();
    }

    @And("ingresa su correo {string} y contraseña {string}")
    public void ingresaSuCorreoYContrasena(String correo, String password){
        loginStep.ingresaSuCorreoYContrasena(correo, password);
    }

    @And("damos click al boton Entrar")
    public void damosClickAlBotonEntrar(){
        loginStep.damosClickAlBotonEntrar();
    }

    @Then("visualizaremos la pantalla principal de IMGBB")
    public void visualizaremosLaPantallaPrincipalDeIMGBB(){
        loginStep.visualizaremosLaPantallaPrincipalDeIMGBB();
    }
}
