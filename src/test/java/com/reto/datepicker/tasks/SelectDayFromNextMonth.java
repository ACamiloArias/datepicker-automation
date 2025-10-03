// Este archivo define una tarea para seleccionar un día del próximo mes en el calendario
package com.reto.datepicker.tasks;

// Importamos las herramientas necesarias
import net.serenitybdd.screenplay.Actor;                    // El "actor" que hace las acciones  
import net.serenitybdd.screenplay.Task;                     // La "tarea" que vamos a crear
import net.serenitybdd.screenplay.actions.Click;           // Para hacer clics
import net.serenitybdd.screenplay.actions.Switch;          // Para cambiar de iframes
import net.serenitybdd.screenplay.waits.WaitUntil;         // Para esperar
import static com.reto.datepicker.userinterfaces.DatepickerPage.*; // Trae los elementos de la página
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible; // Para ver si está visible
import org.openqa.selenium.By;                             // Para buscar elementos
import net.serenitybdd.screenplay.targets.Target;          // Para crear elementos dinámicos

// Esta clase es un ROBOT ESPECIAL que sabe navegar al próximo mes
// Es como el robot anterior, pero más inteligente porque cambia de mes
public class SelectDayFromNextMonth implements Task {
    private final int day;  // Guarda el día que vamos a seleccionar (ej: 15)
    
    // Constructor - le decimos al robot qué día debe recordar
    public SelectDayFromNextMonth(int day) { 
        this.day = day;  // El robot guarda el día en su memoria
    }
    
    // Método estático para crear el robot de forma fácil
    // Es como decir: "Crea un robot que seleccione el día 15"
    public static SelectDayFromNextMonth day(int day) { 
        return new SelectDayFromNextMonth(day);  // Crea el robot con el día que le pasamos
    }
    
    // Aquí está lo que el ROBOT hace cuando le damos la orden
    @Override
    public <T extends Actor> void performAs(T actor) {
        // El actor (nuestro usuario virtual) intenta hacer estas acciones EN ORDEN:
        actor.attemptsTo(
            // PASO 1: Cambiar al iframe (entrar al cuadro especial)
            // Como el calendario está en un "cuadro dentro de la página"
            Switch.toFrame(0),  // "0" significa el primer cuadro que encuentre
            
            // PASO 2: Esperar hasta que el campo de fecha esté visible
            // Esto evita que el robot se apure demasiado
            WaitUntil.the(DATE_FIELD, isVisible()),  // "Espera a que veas el campo"
            
            // PASO 3: Hacer clic en el campo de fecha para abrir el calendario
            Click.on(DATE_FIELD),  // "Haz clic aquí para que se abra el calendario"
            
            // PASO 4: Esperar hasta que el botón "siguiente mes" esté visible  
            // Ahora el calendario está abierto, esperamos el botón de siguiente
            WaitUntil.the(NEXT_BUTTON, isVisible()),  // "Espera a que veas la flecha de siguiente"
            
            // PASO 5: Hacer clic en el botón "siguiente mes" 
            // ¡Este es el paso MÁGICO! Cambiamos al próximo mes
            Click.on(NEXT_BUTTON),  // "Haz clic aquí para ir al próximo mes"
            
            // PASO 6: Buscar y hacer clic en el día específico
            // Ahora que estamos en el próximo mes, buscamos nuestro día
            Click.on(Target.the("día " + day)  // Le ponemos nombre: "día 15"
                    // Busca un enlace (<a>) que tenga exactamente el texto del día
                    // Ej: si day=15, busca <a>15</a> en el próximo mes
                    .located(By.xpath("//a[text()='" + day + "']")))
        );
    }
}