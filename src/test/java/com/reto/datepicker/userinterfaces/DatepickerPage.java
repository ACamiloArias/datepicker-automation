// Esto dice "este archivo pertenece a esta dirección"
package com.reto.datepicker.userinterfaces;

// Importamos herramientas que vamos a usar
import net.serenitybdd.screenplay.targets.Target;  // Para crear "objetivos" en la página
import org.openqa.selenium.By;                     // Para decir "cómo encontrar" los elementos

// Esta clase representa la página web del calendario
// Es como el MAPA DEL TESORO que dice dónde está todo en la página
public class DatepickerPage {
    
    // El cuadro flotante donde está el calendario
    // "iframe.demo-frame" = Busca un elemento con clase "demo-frame"
    // Es como decir: "El tesoro está dentro de este cuadro especial"
    public static final Target IFRAME = Target.the("el cuadro del calendario")
            .located(By.cssSelector("iframe.demo-frame"));  // Encuéntralo por su clase CSS

    // El campo donde aparece la fecha seleccionada  
    // "datepicker" = Busca un elemento con ID "datepicker"
    // Es como decir: "Aquí es donde se escribe y muestra la fecha"
    public static final Target DATE_FIELD = Target.the("campo de fecha")
            .located(By.id("datepicker"));  // Encuéntralo por su ID único

    // botón para ir al próximo mes
    // ".ui-datepicker-next" = Busca un elemento con clase "ui-datepicker-next"
    // Es como decir: "Este botón es la flecha que lleva al próximo mes"
    public static final Target NEXT_BUTTON = Target.the("botón siguiente mes")
            .located(By.cssSelector(".ui-datepicker-next"));  // Encuéntralo por su clase CSS
}