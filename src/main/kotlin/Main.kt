package org.example

val tasks = loadTasks()

var nextId = if (tasks.isEmpty()) 1 else tasks.maxOf { it.id } + 1

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
                showCompletedTasks()
            }

            6 -> {
                showPendingTasks()
            }

            7 -> {
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
    println("5. Ver tareas completadas")
    println("6. Ver tareas pendientes")
    println("7. Salir")
    println()
}

fun addTask() {

    print("Ingrese el nombre de la tarea: ")

    val title = readLine()?.trim()

    if (title.isNullOrEmpty()) {

        println("El nombre de la tarea no puede estar vacío.")
        return
    }

    print("Ingrese la prioridad (Alta, Media, Baja): ")

    val priorityInput = readLine()?.trim()?.uppercase()

    val priority = when (priorityInput) {

        "ALTA" -> "Alta"
        "MEDIA" -> "Media"
        "BAJA" -> "Baja"

        else -> {
            println("Prioridad inválida. Se asignará prioridad Media.")
            "Media"
        }
    }

    val task = Task(
        id = nextId,
        title = title,
        completed = false,
        priority = priority
    )

    tasks.add(task)
    saveTasks(tasks)

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

        println("${task.id}. ${task.title} $status - Prioridad: ${task.priority}")
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
        saveTasks(tasks)
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
        saveTasks(tasks)
        println("Tarea eliminada correctamente.")

    } else {

        println("No se encontró una tarea con ese ID.")
    }
}

fun showCompletedTasks() {

    val completedTasks = tasks.filter { it.completed }

    if (completedTasks.isEmpty()) {

        println("No hay tareas completadas.")
        return
    }

    println("===== TAREAS COMPLETADAS =====")

    completedTasks.forEach { task ->

        println("${task.id}. ${task.title} - Prioridad: ${task.priority}")
    }
}

fun showPendingTasks() {

    val pendingTasks = tasks.filter { !it.completed }

    if (pendingTasks.isEmpty()) {

        println("No hay tareas pendientes.")
        return
    }

    println("===== TAREAS PENDIENTES =====")

    pendingTasks.forEach { task ->

        println("${task.id}. ${task.title} - Prioridad: ${task.priority}")
    }
}