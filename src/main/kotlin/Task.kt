package org.example

data class Task(
    val id: Int,
    val title: String,
    var completed: Boolean,
    val priority: String
)