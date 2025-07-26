package web.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;

public class LoginPage extends PageObject {
    //Localizadores
    @FindBy(css = "a[href='https://imgbb.com/login']")
    private WebElement btnEntrar;
    @FindBy(id = "login-subject")
    private WebElement inputcorreo;
    @FindBy(id = "login-password")
    private WebElement inputpassword;
    @FindBy(css = "button.btn.btn-input.default[type='submit']")
    private WebElement btnEntrarSesion;
    @FindBy(xpath = "//*[@id='list-most-recent']/div/h2")
    private WebElement mensajeIniciarSesion;


    //Métodos
    public void damosClickAEntrar(){
        btnEntrar.click();
    }

    public void ingresaCorreo(String correo){
        inputcorreo.clear();
        inputcorreo.sendKeys(correo);
    }

    public void ingresaPassword(String password){
        inputpassword.clear();
        inputpassword.sendKeys(password);
    }

    public void damosClickAlBotonEntrar(){
        btnEntrarSesion.click();
    }

    public String obtenerMensajeInicioSesion(){
        return mensajeIniciarSesion.getText().trim();
    }
}
