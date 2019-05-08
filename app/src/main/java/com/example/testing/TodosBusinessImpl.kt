package com.example.testing

class TodosBusinessImpl(private val todoService : TodoService) {

    fun retrieveTodosRelatedSpring(user : String) : List<String>{
        val filteredTodos = ArrayList<String>()
        val todos = todoService.retrieveToDos(user)
        for (todo in todos ){
            if (todo.contains("Spring")){
                filteredTodos.add(todo)
            }
        }
        return filteredTodos
    }

    fun deleteTodosRelatedSpring(user : String) {
        val filteredTodos = ArrayList<String>()
        val todos = todoService.retrieveToDos(user)
        for (todo in todos ){
            if (!todo.contains("Spring")){
                todoService.deleteTodo(todo)
            }
        }
    }


}