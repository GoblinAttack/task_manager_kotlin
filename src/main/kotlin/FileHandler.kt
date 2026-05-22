package org.example
import java.io.File

const val FILE_NAME = "tasks.txt"

fun saveTasks(tasks: List<Task>) {

    val file = File(FILE_NAME)

    file.printWriter().use { writer ->

        tasks.forEach { task ->

            writer.println(
                "${task.id};${task.title};${task.completed};${task.priority}"
            )
        }
    }
}

fun loadTasks(): MutableList<Task> {

    val file = File(FILE_NAME)

    if (!file.exists()) {
        return mutableListOf()
    }

    val tasks = mutableListOf<Task>()

    file.readLines().forEach { line ->

        val parts = line.split(";")

        if (parts.size == 4) {

            val task = Task(
                id = parts[0].toInt(),
                title = parts[1],
                completed = parts[2].toBoolean(),
                priority = parts[3]
            )

            tasks.add(task)
        }
    }

    return tasks
}