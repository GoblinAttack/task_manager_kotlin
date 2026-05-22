package org.example

val tasks = loadTasks()

var nextId = if (tasks.isEmpty()) 1 else tasks.maxOf { it.id } + 1

fun addTask() {
    print("Ingrese el nombre de la tarea: ")
    val title = readLine()?.trim()

    if (title.isNullOrEmpty()) {
        println("El nombre de la tarea no puede estar vacio.")
        return
    }

    print("Ingrese la prioridad (Alta, Media, Baja): ")
    val priorityInput = readLine()?.trim()?.uppercase()

    val priority = when (priorityInput) {
        "ALTA" -> Priority.ALTA
        "MEDIA" -> Priority.MEDIA
        "BAJA" -> Priority.BAJA

        else -> {
            println("Prioridad invalida. Se asignara prioridad MEDIA.")
            Priority.MEDIA
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

    println("\n===== LISTA DE TAREAS =====")

    tasks.forEach { task -> printTask(task) }
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
        println("No se encontro una tarea con ese ID.")
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
        println("No se encontro una tarea con ese ID.")
    }
}

fun showCompletedTasks() {
    val completedTasks = tasks.filter { it.completed }

    if (completedTasks.isEmpty()) {
        println("No hay tareas completadas.")
        return
    }

    println("===== TAREAS COMPLETADAS =====")

    completedTasks.forEach { task -> printTask(task) }
}

fun showPendingTasks() {
    val pendingTasks = tasks.filter { !it.completed }

    if (pendingTasks.isEmpty()) {
        println("No hay tareas pendientes.")
        return
    }

    println("===== TAREAS PENDIENTES =====")

    pendingTasks.forEach { task -> printTask(task) }
}

fun searchTasks() {

    if (tasks.isEmpty()) {
        println("No hay tareas registradas.")
        return
    }

    print("Ingrese una palabra clave: ")
    val keyword = readLine()?.trim()

    if (keyword.isNullOrEmpty()) {
        println("La busqueda no puede estar vacia.")
        return
    }

    val results = tasks.filter {
        it.title.contains(keyword, ignoreCase = true)
    }

    if (results.isEmpty()) {
        println("No se encontraron tareas.")
        return
    }

    println("===== RESULTADOS DE BUSQUEDA =====")

    results.forEach { task -> printTask(task) }
}

fun showStatistics() {

    if (tasks.isEmpty()) {
        println("No hay tareas registradas.")
        return
    }

    val totalTasks = tasks.size
    val completedTasks = tasks.count { it.completed }
    val pendingTasks = tasks.count { !it.completed }
    val highPriorityTasks = tasks.count { it.priority == Priority.ALTA }
    val mediumPriorityTasks = tasks.count { it.priority == Priority.MEDIA }
    val lowPriorityTasks = tasks.count { it.priority == Priority.BAJA }

    println("\n===== ESTADISTICAS =====")
    println("Total de tareas: $totalTasks")
    println("Tareas completadas: $completedTasks")
    println("Tareas pendientes: $pendingTasks")
    println("Prioridad Alta: $highPriorityTasks")
    println("Prioridad Media: $mediumPriorityTasks")
    println("Prioridad Baja: $lowPriorityTasks")
}

fun printTask(task: Task) {
    val status = if (task.completed) "Completada" else "Pendiente"

    println("[${task.id}] ${task.title}")
    println("Estado: $status")
    println("Prioridad: ${task.priority}")
    println("----------------------------------------")
}