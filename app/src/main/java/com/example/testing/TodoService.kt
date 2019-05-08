package com.example.testing

interface TodoService {

    fun retrieveToDos(user : String) : List<String>

    fun deleteTodo(todo : String)

}