package web.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import net.thucydides.model.ThucydidesSystemProperty;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"web.stepdefinitions"},
        stepNotifications = true,
        plugin = {
                "pretty",
                "summary",
                "html:target/serenity-report.html",
                "json:target/serenity-report.json"},
        monochrome = true,
        tags = ""
)

public class TestRunner {
    private static final Logger logger = LoggerFactory.getLogger(TestRunner.class);

    @BeforeClass
    public static void beforeExecution(){
        logger.info("INICIANDO LAS PRUEBAS EN SERENITY BDD >>>>>>>>>>");
    }

    @AfterClass
    public static void afterExecution(){
        logger.info("FINALIZANDO LAS PRUEBAS EN SERENITY BDD >>>>>>>>>>");
    }

}
