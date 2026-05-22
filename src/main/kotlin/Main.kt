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
                listTasks()
            }

            3 -> {
                completeTask()
            }

            4 -> {
                deleteTask()
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

fun listTasks() {

    if (tasks.isEmpty()) {

        println("No hay tareas registradas.")
        return
    }

    println("===== LISTA DE TAREAS =====")

    tasks.forEach { task ->

        val status = if (task.completed) "[Completada]" else "[Pendiente]"

        println("${task.id}. ${task.title} $status")
    }
}

fun completeTask() {

    if (tasks.isEmpty()) {

        println("No hay tareas registradas.")
        return
    }

    listTasks()

    print("Ingrese el ID de la tarea completada: ")

    val taskId = readLine()?.toIntOrNull()

    val task = tasks.find { it.id == taskId }

    if (task != null) {

        task.completed = true
        println("Tarea marcada como completada.")

    } else {

        println("No se encontró una tarea con ese ID.")
    }
}

fun deleteTask() {

    if (tasks.isEmpty()) {

        println("No hay tareas registradas.")
        return
    }

    listTasks()

    print("Ingrese el ID de la tarea que desea eliminar: ")

    val taskId = readLine()?.toIntOrNull()

    val task = tasks.find { it.id == taskId }

    if (task != null) {

        tasks.remove(task)

        println("Tarea eliminada correctamente.")

    } else {

        println("No se encontró una tarea con ese ID.")
    }
}