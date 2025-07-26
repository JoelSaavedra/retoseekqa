package web.steps;

import web.pages.LoginPage;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginStep {
    LoginPage loginPage;

    public void damosClickAEntrar(){
        loginPage.damosClickAEntrar();
    }

    public void ingresaSuCorreoYContrasena(String correo, String password){
        loginPage.ingresaCorreo(correo);
        loginPage.ingresaPassword(password);
    }

    public void damosClickAlBotonEntrar(){
        loginPage.damosClickAlBotonEntrar();
    }

    public void visualizaremosLaPantallaPrincipalDeIMGBB(){
        String mensajeEspera = "No hay nada que mostrar aquí.";
        String mensajeRecibido = loginPage.obtenerMensajeInicioSesion();
        assertEquals(mensajeEspera, mensajeRecibido, "El mensaje de activación no coincide");
    }
}
