# RETO SEEK QA: Serenity BDD + Cucumber

Este proyecto implementa un framework de automatización de pruebas web utilizando **Serenity BDD**, **Cucumber** y el **patrón de diseño Page Object Model (POM)**. El objetivo es facilitar la mantenibilidad, reutilización y claridad de las pruebas automatizadas.

### La estructura del Proyecto
La construcción del Proyecto se basa en un enfoque POM (Page Object Model) con una estructuración marcada de carpetas:
```Gherkin
src
  + main
  + test
    + java 
      + web
        + pages
        + runner                  Test runner
        + stepdefinitions
        + steps                     
    + resources
      + features                  documentos .feature
```

## Ejecución de Pruebas
Comando para iniciar la ejecución de pruebas
mvn clean verify


## Generación de Reportes
El headless.mode permite ejecutar las pruebas en segundo plano sin ver el navegador, por eso lo desactivamos.
En cada reporte de automatización se visualizarán capturas de pantalla de CADA ACCIÓN ya que se configuró en serenity.conf lo siguiente:

```
serenity {
    take.screenshots = FOR_EACH_ACTION
    screenshots{
        afterEachStep = true
    }
}

headless.mode = false
```
En las dependencias debería visualizarse así para poder llamar a los reportes
```
             <plugin>
                <groupId>net.serenity-bdd.maven.plugins</groupId>
                <artifactId>serenity-maven-plugin</artifactId>
                <version>${serenity.maven.version}</version>
                <configuration>
                    <tags>${tags}</tags>
                </configuration>
                <executions>
                    <execution>
                        <id>serenity-reports</id>
                        <phase>post-integration-test</phase>
                        <goals>
                            <goal>aggregate</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>


Además en el serenity.conf se ha ajustado lo siguiente:
```


## Configuración WebDriver
Se configuran los capabilites, por default agregamos a chrome como navegador.
```java
webdriver {
  driver = chrome
  capabilities {
    browserName = "chrome"
    acceptInsecureCerts = true
    "goog:chromeOptions" {
      args = ["remote-allow-origins=*","test-type", "no-sandbox", "ignore-certificate-errors", "--window-size=1000,800",
        "incognito", "disable-infobars", "disable-gpu", "disable-default-apps", "disable-popup-blocking",
        "disable-dev-shm-usage", "disable-extensions", "disable-web-security", "disable-translate", "disable-logging"]
    }
  }
}

```


"Serenity usa WebDriverManager para descargar los binarios WebDriver y no preocuparnos por ello"


### Configuraciones Específicas para Ambientes
Podemos configurar a futuro nuestro proyecto según ambientes y ordenar las ejecuciones según lo conveniente
```json
environments {
  default {
    webdriver.base.url = "https://imgbb.com/"
  }
  dev {
    webdriver.base.url = "https://imgbb-dev.com/"
  }
  cert {
    webdriver.base.url = "https://imgbb-cert.com/"
  }
  prod {
    webdriver.base.url = "https://imgbb.com/"
  }
}
```

Pasa ejecutar las pruebas en un ambiente en específico puedes lanzar en consola el siguiente comando utilizando "-Denvironment":
```json
$ mvn clean verify -Denvironment=staging
```
