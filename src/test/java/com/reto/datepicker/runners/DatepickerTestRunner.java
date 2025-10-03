package com.reto.datepicker.runners;

// Importamos las herramientas necesarias para ejecutar las pruebas
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

// Esta clase es el MOTOR que pone en marcha todas nuestras pruebas
@RunWith(CucumberWithSerenity.class)  // Le dice a JUnit: "Usa Serenity y Cucumber para correr las pruebas"
@CucumberOptions(
    // Dónde encontrar los archivos .feature (las instrucciones de las pruebas)
    features = "src/test/resources/features",
    
    // Dónde encontrar el código que ejecuta cada paso de las pruebas
    glue = "com.reto.datepicker.stepdefinitions",
    
    // Cómo generar los nombres de los métodos automáticamente
    snippets = CucumberOptions.SnippetType.CAMELCASE  // Ej: "usuarioIngresaFecha" en lugar de "usuario_ingresa_fecha"
)
public class DatepickerTestRunner {
    // Esta clase está vacía porque las anotaciones (@) hacen todo el trabajo
    // Es como el botón de "ENCENDIDO" de nuestras pruebas
}