// Este archivo vive en esta dirección
package com.reto.datepicker.tasks;

// Importamos todas las herramientas que necesitamos
import net.serenitybdd.screenplay.Actor;           // El "usuario" que hace las acciones
import net.serenitybdd.screenplay.Task;            // La "tarea" que vamos a crear
import net.serenitybdd.screenplay.actions.Click;   // Para hacer clics
import net.serenitybdd.screenplay.actions.Switch;  // Para cambiar entre cuadros
import net.serenitybdd.screenplay.waits.WaitUntil; // Para esperar
import static com.reto.datepicker.userinterfaces.DatepickerPage.*; // Trae los Targets
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible; // Para ver si está visible
import org.openqa.selenium.By;                     // Para buscar elementos
import net.serenitybdd.screenplay.targets.Target;  // Para crear Targets dinámicos

// Esta clase es una "Tarea" que selecciona un día del mes
// Es como un ROBOT que sabe hacer clic en días del calendario
public class SelectCurrentDay implements Task {
    // Esta variable guarda el día que vamos a seleccionar (ej: 15)
    private final int day;

    // Este es el "constructor" - se ejecuta cuando creamos la tarea
    // Es como darle al robot la instrucción: "Recuerda que tienes que hacer clic en el día 15"
    public SelectCurrentDay(int day) {
        this.day = day; // Guarda el día que nos pasaron
    }

    // Este método nos permite escribir: SelectCurrentDay.ofMonth(15)
    // Es la forma BONITA de crear el robot
    public static SelectCurrentDay ofMonth(int day) {
        return new SelectCurrentDay(day); // Crea una nueva tarea con ese día
    }

    // Aquí está la "magia" - lo que realmente hace la tarea
    // Este método se ejecuta cuando le decimos al robot: "¡Ahora hazlo!"
    @Override
    public <T extends Actor> void performAs(T actor) {
        // El "actor" (usuario) intenta hacer estas acciones en orden:
        actor.attemptsTo(
            // PASO 1: Cambiar al iframe (entrar al cuadro flotante)
            // Los iframes son como "cuadros de TV dentro de la página"
            // "0" = primer iframe de la página (como el primer cuadro)
            Switch.toFrame(0),
            
            // PASO 2: Esperar hasta que el campo de fecha esté visible
            // Esto evita errores si la página carga lento
            // Es como decir: "Espera a que veas el campo antes de hacer clic"
            WaitUntil.the(DATE_FIELD, isVisible()),
            
            // PASO 3: Hacer clic en el campo de fecha para abrir el calendario
            // Es como cuando haces clic en un campo de fecha y se abre el calendario
            Click.on(DATE_FIELD),
            
            // PASO 4: Buscar y hacer clic en el día específico
            // Crea un Target temporal para el día que queremos
            Click.on(Target.the("día " + day)  // Le ponemos nombre: "día 15"
                    // Busca un enlace (<a>) que tenga exactamente el texto del día
                    // Ej: si day=15, busca <a>15</a>
                    // XPath es como una dirección para encontrar elementos en la página
                    .located(By.xpath("//a[text()='" + day + "']")))
        );
    }
}