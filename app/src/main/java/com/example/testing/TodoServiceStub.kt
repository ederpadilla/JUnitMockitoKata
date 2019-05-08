package com.example.testing

import com.example.testing.TodoService
import java.util.*

class TodoServiceStub : TodoService {
    override fun deleteTodo(todo: String) {

    }

    override fun retrieveToDos(user: String): List<String> {
        return Arrays.asList("Learn Spring MVC","Learn Spring","Learn to dance")
    }
}