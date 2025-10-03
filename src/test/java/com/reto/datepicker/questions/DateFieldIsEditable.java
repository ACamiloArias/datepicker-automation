// Este archivo verifica si el campo de fecha permite edición manual
package com.reto.datepicker.questions;

// Importamos las clases necesarias para que funcione nuestro código
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
// Importamos el campo de fecha que vamos a verificar
import static com.reto.datepicker.userinterfaces.DatepickerPage.DATE_FIELD;

// Creamos una clase que implementa la interfaz Question para hacer preguntas en nuestras pruebas
public class DateFieldIsEditable implements Question<Boolean> {
    
    // Método estático para usar la pregunta de forma fluida
    // Esto nos permite escribir: DateFieldIsEditable.field() en lugar de 'new DateFieldIsEditable()'
    public static DateFieldIsEditable field() {
        // Creamos una nueva instancia de esta clase
        return new DateFieldIsEditable();
    }
    
    // Este es el método principal que se ejecuta cuando hacemos la pregunta
    // Aquí está la lógica que verifica si el campo es editable
    @Override
    public Boolean answeredBy(Actor actor) {
        // Paso 1: Obtenemos la capacidad del actor para navegar en la web
        // Paso 2: Buscamos el campo de fecha en la página usando DATE_FIELD
        // Paso 3: Verificamos si el campo está habilitado usando .isEnabled()
        // Paso 4: Retornamos:
        //   - TRUE si el campo está habilitado (se puede editar)
        //   - FALSE si el campo está bloqueado (no se puede editar)
        return BrowseTheWeb.as(actor).find(DATE_FIELD).isEnabled();
    }
}