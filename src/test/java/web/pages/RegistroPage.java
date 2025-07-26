package web.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.htmlunit.corejs.javascript.tools.shell.Global.quit;

public class RegistroPage extends PageObject {
    //Localizadores
    @FindBy(css = "a.top-btn-create-account")
    private WebElement linkCrearCuenta;
    @FindBy(id = "signup-email") // Ajusta según el ID real
    private WebElement emailInput;
    @FindBy(id = "signup-username")
    private WebElement usernameInput;
    @FindBy(id = "signup-password")
    private WebElement passwordInput;
    @FindBy(id = "signup-accept-terms-policies")
    private WebElement checkboxTerminos;
    @FindBy(xpath = "//button[contains(text(),'Crear cuenta')]")
    private WebElement botonCrearCuenta;
    @FindBy(xpath = "//*[@id='account/awaiting-confirmation']//h1")
    private WebElement mensajeCorreoActivacion;


    //Métodos
    public void damosClickACrearCuenta() {
        linkCrearCuenta.click();
    }

    public void ingresaCorreo(String correo){
        emailInput.clear();
        emailInput.sendKeys(correo);
    }

    public void ingresaUsuario(String usuario){
        usernameInput.clear();
        usernameInput.sendKeys(usuario);
    }

    public void ingresaPassword(String password){
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void checkTerminos(){
        checkboxTerminos.click();
    }

    public void damosClickAlBotonCrearCuenta(){
        botonCrearCuenta.click();
    }

    public String obtenerTextoMensajeActivacion(){
        return mensajeCorreoActivacion.getText().trim();

    }
}
