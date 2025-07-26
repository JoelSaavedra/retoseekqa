package web.steps;

import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.openqa.selenium.WebDriver;
import web.pages.RegistroPage;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistroStep {
    RegistroPage registroPage;

    public void queElUsuarioEstaEnLaPaginaIMGBB(){
        registroPage.open();
    }

    public void damosClickACrearCuenta(){
        registroPage.damosClickACrearCuenta();
    }

    public void ingresaSuCorreoYUsuarioYContrasena(String correo, String usuario, String password){
        registroPage.ingresaCorreo(correo);
        registroPage.ingresaUsuario(usuario);
        registroPage.ingresaPassword(password);
    }

    public void damosCheckALaCasillaDeTerminosYPoliticaDePrivacidad(){
        registroPage.checkTerminos();
    }

    public void damosClickAlBotonCrearCuenta(){
        registroPage.damosClickAlBotonCrearCuenta();
    }

    public void visualizamosElMensajeDeActivacionDeCuentaPorCorreo() {
        String mensajeEsperado = "Tu cuenta está casi lista";
        String mensajeObtenido = registroPage.obtenerTextoMensajeActivacion();
        assertEquals(mensajeEsperado, mensajeObtenido, "El mensaje de activación no coincide");
        WebDriver driver = ThucydidesWebDriverSupport.getDriver();
        if (driver != null) {
            driver.quit();
        }
    }
}
