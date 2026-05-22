package org.example

fun main() {
    var running = true

    while (running) {
        showMenu()
        print("Seleccione una opcion: ")
        val option = readLine()?.toIntOrNull()

        when (option) {
            1 -> { addTask() }
            2 -> { listTasks() }
            3 -> { completeTask() }
            4 -> { deleteTask() }
            5 -> { showCompletedTasks() }
            6 -> { showPendingTasks() }
            7 -> { searchTasks() }
            8 -> showStatistics()
            9 -> {
                println("Saliendo del programa...")
                running = false
            }
            else -> { println("Opcion invalida.") }
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
    println("8. Mostrar estadisticas")
    println("9. Salir")
    println()
}