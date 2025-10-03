// Este archivo define una tarea para intentar escribir manualmente en el campo de fecha
package com.reto.datepicker.tasks;

// Importamos las clases necesarias
import net.serenitybdd.screenplay.Actor;          // Representa al usuario
import net.serenitybdd.screenplay.Task;           // Interfaz de tarea
import net.serenitybdd.screenplay.actions.Enter;  // Acción para escribir texto
import net.serenitybdd.screenplay.actions.Switch; // Acción para cambiar iframes
import static com.reto.datepicker.userinterfaces.DatepickerPage.*; // Elementos de la página

// Esta clase es como un ROBOT que intenta escribir fechas manualmente
public class AttemptManualDateEntry implements Task {
    private final String date;  // La fecha que el robot intentará escribir (ej: "25/12/2023")
    
    // Constructor - le pasamos la fecha que queremos que escriba
    public AttemptManualDateEntry(String date) {
        this.date = date;  // Guarda la fecha para usarla después
    }
    
    // Método estático para crear el robot de forma fácil
    // Es como decir: "Crea un robot que escriba esta fecha"
    public static AttemptManualDateEntry withDate(String date) {
        return new AttemptManualDateEntry(date);  // Crea un nuevo robot con la fecha
    }
    
    // Aquí está lo que el ROBOT hace cuando le damos la orden
    @Override
    public <T extends Actor> void performAs(T actor) {
        // El actor (nuestro usuario virtual) intenta hacer estas acciones:
        actor.attemptsTo(
            // PASO 1: Cambiar al iframe (como cambiar de habitación en una casa)
            // Los iframes son como "páginas dentro de páginas"
            Switch.toFrame(0),  // El número 0 significa "primer iframe que encuentres"
            
            // PASO 2: Escribir la fecha en el campo
            // Enter.keyValues() es como escribir en el teclado
            Enter.keyValues(date).into(DATE_FIELD)  // Escribe la fecha en el campo de fecha
        );
    }
}