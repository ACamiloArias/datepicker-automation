package com.reto.datepicker.stepdefinitions;

// Importamos las herramientas necesarias para hacer las pruebas
import io.cucumber.java.Before;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

// Esta clase es como el MANUAL DE INSTRUCCIONES que conecta:
// - Lo que escribimos en español en los archivos .feature
// - Con el código Java que realmente hace las acciones
public class DatepickerStepDefinitions {

    // @Managed es como decir: "Serenity, tú encárgate de abrir y cerrar el navegador"
    @Managed
    WebDriver driver;  // Este es el control remoto del navegador (Chrome, Firefox, etc.)

    // Creamos un PERSONAJE llamado "Usuario" que será nuestro tester virtual
    private Actor usuario = Actor.named("Usuario");

    // @Before significa: "Haz esto ANTES de comenzar cada prueba"
    // Es como los preparativos antes de una función de teatro
    @Before
    public void setup() {
        // Le damos superpoderes a nuestro personaje: poder usar el navegador
        usuario.can(BrowseTheWeb.with(driver));
    }

    // @Dado es la PREPARACIÓN - lo que debe pasar ANTES de la acción principal
    // Este método se activa cuando Cucumber lee: "que el usuario abre la pagina de JQuery Datepicker"
    @Dado("que el usuario abre la pagina de JQuery Datepicker")
    public void queElUsuarioAbreLaPaginaDeJQueryDatepicker() {
        // Nuestro personaje intenta abrir la página web
        usuario.attemptsTo(Open.url("https://jqueryui.com/datepicker/"));
    }

    // @Cuando es la ACCIÓN principal - lo que el usuario HACE
    // El {int} significa: "Atrapa cualquier número que venga aquí y guárdalo en 'dia'"
    @Cuando("selecciona el dia {int} del mes actual")
    public void seleccionaElDiaDelMesActual(Integer dia) {
        // Por ahora solo escribimos en la consola, pero aquí iría el código para hacer clic en el calendario
        System.out.println("Seleccionando día " + dia + " del mes actual");
        // Más adelante aquí pondríamos: usuario.haceClicEnElDia(dia);
    }

    @Cuando("selecciona el dia {int} del proximo mes")
    public void seleccionaElDiaDelProximoMes(Integer dia) {
        System.out.println("Seleccionando día " + dia + " del próximo mes");
    }

    @Cuando("intenta ingresar una fecha manualmente")
    public void intentaIngresarUnaFechaManualmente() {
        System.out.println("Intentando ingresar fecha manualmente");
    }

    // @Entonces es la VERIFICACIÓN - lo que esperamos que PASE después de las acciones
    @Entonces("deberia ver la fecha seleccionada en el campo de texto")
    public void deberiaVerLaFechaSeleccionadaEnElCampoDeTexto() {
        System.out.println("Verificando fecha seleccionada");
        // Aquí después pondríamos: usuario.deberiaVerLaFechaCorrecta();
    }

    @Entonces("deberia ver la fecha del proximo mes en el campo de texto")
    public void deberiaVerLaFechaDelProximoMesEnElCampoDeTexto() {
        System.out.println("Verificando fecha del próximo mes");
    }

    @Entonces("no deberia permitir la edicion manual del campo")
    public void noDeberiaPermitirLaEdicionManualDelCampo() {
        System.out.println("Verificando que el campo no es editable");
    }
}