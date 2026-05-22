package org.example

val tasks = loadTasks()

var nextId = if (tasks.isEmpty()) 1 else tasks.maxOf { it.id } + 1

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

fun searchTasks() {

    if (tasks.isEmpty()) {
        println("No hay tareas registradas.")
        return
    }

    print("Ingrese una palabra clave: ")
    val keyword = readLine()?.trim()

    if (keyword.isNullOrEmpty()) {
        println("La búsqueda no puede estar vacía.")
        return
    }

    val results = tasks.filter {
        it.title.contains(keyword, ignoreCase = true)
    }

    if (results.isEmpty()) {
        println("No se encontraron tareas.")
        return
    }

    println("===== RESULTADOS DE BÚSQUEDA =====")

    results.forEach { task ->
        val status = if (task.completed) "[Completada]" else "[Pendiente]"
        println("${task.id}. ${task.title} $status - Prioridad: ${task.priority}")
    }
}

fun showStatistics() {

    if (tasks.isEmpty()) {
        println("No hay tareas registradas.")
        return
    }

    val totalTasks = tasks.size
    val completedTasks = tasks.count { it.completed }
    val pendingTasks = tasks.count { !it.completed }
    val highPriorityTasks = tasks.count { it.priority == "Alta" }
    val mediumPriorityTasks = tasks.count { it.priority == "Media" }
    val lowPriorityTasks = tasks.count { it.priority == "Baja" }

    println("===== ESTADÍSTICAS =====")
    println("Total de tareas: $totalTasks")
    println("Tareas completadas: $completedTasks")
    println("Tareas pendientes: $pendingTasks")
    println("Prioridad Alta: $highPriorityTasks")
    println("Prioridad Media: $mediumPriorityTasks")
    println("Prioridad Baja: $lowPriorityTasks")
}