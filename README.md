# Task Manager Kotlin

Aplicacion de consola desarrollada en Kotlin para gestionar tareas pendientes. Permite agregar, listar, completar, eliminar y buscar tareas utilizando un menu interactivo desde consola. Las tareas se almacenan automaticamente en un archivo de texto para conservar la informacion entre ejecuciones.

---

# Instalacion y ejecucion

## Requisitos

- JDK 21 o superior
- IntelliJ IDEA Community Edition
- Kotlin
- Gradle

---

## Clonar el repositorio

```bash
git clone https://github.com/GoblinAttack/task_manager_kotlin.git
```

---

## Abrir el proyecto

1. Abrir IntelliJ IDEA
2. Seleccionar la opcion `Open`
3. Elegir la carpeta del proyecto

---

## Ejecutar la aplicacion

Desde IntelliJ ejecutar el archivo:

```bash
Main.kt
```

O desde terminal:

```bash
gradlew run
```

---

# Funcionalidades principales

- Agregar tareas
- Listar tareas registradas
- Marcar tareas como completadas
- Eliminar tareas
- Buscar tareas por palabra clave
- Filtrar tareas completadas y pendientes
- Mostrar estadisticas de tareas
- Guardar tareas automaticamente en archivos `.txt`
- Manejo de prioridades mediante `enum class`
- Persistencia de informacion entre ejecuciones

---

# Conceptos de Kotlin aplicados

| Concepto | Implementacion |
|---|---|
| Funciones | Funciones separadas para CRUD, filtros, estadisticas y persistencia |
| Condicionales | Uso de `if` y `when` para validaciones y menus |
| Ciclos | Uso de `while` para mantener la aplicacion en ejecucion |
| Colecciones | Uso de `MutableList<Task>` para almacenar tareas |
| Operaciones funcionales | Uso de `filter`, `find`, `count` y `forEach` |
| Null Safety | Uso de `?.`, `isNullOrEmpty()`, `toIntOrNull()` |
| Data Class | `Task.kt` modela las tareas mediante `data class` |
| Enum Class | `Priority.kt` implementa prioridades seguras |
| Persistencia | `FileHandler.kt` guarda y carga tareas desde archivos `.txt` |
| Refactorizacion | Separacion de responsabilidades en multiples archivos |

---

# Reflexion de proceso

## a) Que fue lo mas dificil de este proyecto y como lo resolviste?

Lo mas dificil fue organizar el proyecto cuando empezo a crecer. Al principio toda la logica estaba dentro del archivo `Main.kt`, pero conforme agregue funcionalidades como filtros, persistencia y estadisticas, el codigo comenzo a hacerse muy largo y dificil de mantener. Para resolverlo decidi refactorizar el proyecto y separar responsabilidades en diferentes archivos como `TaskManager.kt` y `FileHandler.kt`. Esto hizo que el codigo fuera mas limpio, reutilizable y facil de entender.

---

## b) Hubo algun concepto de Kotlin que al principio no entendias y que ahora si comprendes? Como llegaste a entenderlo?

Uno de los conceptos que mas me costo entender fue el manejo de colecciones con operaciones funcionales como `filter`, `find`, `count` y `forEach`. Al principio utilizaba ciclos manuales para casi todo, pero conforme avance en el proyecto empece a comprender que Kotlin tiene herramientas mas limpias y eficientes para trabajar con listas. Practicando directamente sobre el proyecto entendi mejor como funcionan las lambdas y como simplifican mucho el codigo.

---

## c) Si tuvieras que mejorar o ampliar este proyecto, que le agregarias y por que?

Si tuviera que ampliar el proyecto me gustaria agregar una interfaz grafica para que la aplicacion fuera mas amigable para el usuario. Tambien agregaria fechas limite para las tareas, categorias y un sistema de autenticacion de usuarios. Considero que estas mejoras harian que el proyecto se pareciera mas a una aplicacion real.

---

## d) Que aprendiste de este proyecto que no aprendiste solo leyendo o viendo videos?

Aprendi que desarrollar un proyecto completo es muy diferente a solamente leer teoria o ver tutoriales. Durante el desarrollo tuve que resolver errores reales, organizar archivos, corregir problemas de persistencia y pensar en como estructurar mejor el codigo. Tambien aprendi la importancia de hacer commits frecuentes y trabajar de forma progresiva, ya que eso facilita detectar errores y mantener un historial claro del desarrollo del proyecto.