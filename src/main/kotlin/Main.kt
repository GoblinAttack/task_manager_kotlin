package org.example

fun main() {

    var running = true

    while (running) {

        showMenu()

        print("Seleccione una opción: ")
        val option = readLine()?.toIntOrNull()

        when (option) {

            1 -> {
                println("Agregar tarea próximamente...")
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