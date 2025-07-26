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
        + runner
        + stepdefinitions
        + steps                     Test runners and supporting code
    + resources
      + features                  Feature files
```

## Ejecución de Pruebas
mvn clean verify


## Generación de Reportes
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

serenity {
    take.screenshots = FOR_EACH_ACTION
    screenshots{
        afterEachStep = true
    }
}

headless.mode = false
```


## Configuración WebDriver
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
Podemos configurar nuestro proyecto según ambientes y ordenar las ejecuciones según lo conveniente
```json
environments {
  default {
    webdriver.base.url = "https://duckduckgo.com"
  }
  dev {
    webdriver.base.url = "https://duckduckgo.com/dev"
  }
  staging {
    webdriver.base.url = "https://duckduckgo.com/staging"
  }
  prod {
    webdriver.base.url = "https://duckduckgo.com/prod"
  }
}
```

Pasa ejecutar las pruebas en un ambiente en específico puedes lanzar en consola el siguiente comando utilizando "-Denvironment":
```json
$ mvn clean verify -Denvironment=staging
```
