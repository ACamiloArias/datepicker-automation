# Crear README.md
@"
Automatización de JQuery Datepicker

Descripción
Automatización de pruebas para el componente Datepicker de JQuery UI implementada con Serenity BDD y Screenplay Pattern.

Objetivo
Validar el funcionamiento del componente Datepicker en: https://jqueryui.com/datepicker/

## Escenarios de Prueba
1. **Reserva de cita seleccionando fecha del mes actual**
2. **Selección de fecha específica en próximo mes** 
3. **Validación de campo bloqueado para edición manual**

## Arquitectura
- **Screenplay Pattern** - Patrón moderno de automatización
- **Serenity BDD** - Framework para pruebas aceptación
- **Page Objects** - Separación de responsabilidades
- **Cucumber** - BDD con Gherkin

## Tecnologías
- Java 11
- Serenity BDD 3.9.8
- Cucumber 7.11.0
- Selenium WebDriver 4.8.0
- Maven

## Estructura del Proyecto
\`\`\`
src/test/
├── java/com/reto/datepicker/
│   ├── runners/DatepickerTestRunner.java
│   ├── stepdefinitions/DatepickerStepDefinitions.java
│   ├── tasks/ (Screenplay - acciones del usuario)
│   ├── questions/ (Screenplay - verificaciones)
│   └── userinterfaces/ (Page Objects)
└── resources/features/datepicker.feature
\`\`\`

## Ejecución
\`\`\`bash
# Ejecutar pruebas y generar reporte
mvn clean verify serenity:aggregate

# Ejecutar con navegador específico
mvn test -Dtest=DatepickerTestRunner -Dwebdriver.driver=firefox
\`\`\`

## Reportes
Los reportes Serenity BDD se generan en: \`target/site/serenity/index.html\`

