package com.reto.datepicker.questions;

// Importamos las herramientas necesarias para que funcione nuestro "policía"
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
// Traemos el campo específico que queremos revisar (DATE_FIELD)
import static com.reto.datepicker.userinterfaces.DatepickerPage.DATE_FIELD;

// Esta clase es como un POLICIA que revisa si la fecha está bien
// En lugar de devolver TRUE/FALSE como el anterior, este devuelve TEXTO (String)
public class SelectedDate implements Question<String> {

    // Esto me permite decir: "Policia, revisa la fecha"
    // Es un método estático que crea una nueva instancia de nuestro policía
    public static SelectedDate inField() {
        return new SelectedDate();
    }

    // Aquí es donde el POLICIA hace su trabajo
    // Este método se ejecuta cuando le preguntamos al actor sobre la fecha
    @Override
    public String answeredBy(Actor actor) {
        // Paso a paso lo que hace el policía:
        // 1. BrowseTheWeb.as(actor) -> Le da al actor sus "ojos" para ver la página web
        // 2. .find(DATE_FIELD) -> Busca el campo de fecha en la página
        // 3. .getValue() -> Lee el texto que está escrito dentro del campo
        // 4. Retorna ese texto (por ejemplo: "15/10/2023")
        
        return BrowseTheWeb.as(actor).find(DATE_FIELD).getValue();
    }
}