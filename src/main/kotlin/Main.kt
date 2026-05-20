package org.example

val tasks = mutableListOf<Task>()

var nextId = 1

fun main() {

    var running = true


    while (running) {

        showMenu()

        print("Seleccione una opción: ")
        val option = readLine()?.toIntOrNull()

        when (option) {

            1 -> {
                addTask()
            }

            2 -> {
                println("Listar tareas próximamente...")
            }

            3 -> {
                println("Marcar tarea como completada próximamente...")
            }

            4 -> {
                println("Eliminar tarea próximamente...")
            }

            5 -> {
                println("Saliendo del programa...")
                running = false
            }

            else -> {
                println("Opción inválida.")
            }
        }

        println()
    }
}

fun showMenu() {

    println("===== GESTOR DE TAREAS =====")
    println("1. Agregar tarea")
    println("2. Listar tareas")
    println("3. Completar tarea")
    println("4. Eliminar tarea")
    println("5. Salir")
    println()
}

fun addTask() {

    print("Ingrese el nombre de la tarea: ")

    val title = readLine()?.trim()

    if (title.isNullOrEmpty()) {

        println("El nombre de la tarea no puede estar vacío.")
        return
    }

    val task = Task(
        id = nextId,
        title = title,
        completed = false
    )

    tasks.add(task)

    println("Tarea agregada correctamente.")

    nextId++
}