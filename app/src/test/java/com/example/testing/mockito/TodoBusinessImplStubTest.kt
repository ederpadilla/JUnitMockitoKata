package com.example.testing.mockito

import com.example.testing.TodoService
import com.example.testing.TodoServiceStub
import com.example.testing.TodosBusinessImpl
import junit.framework.Assert.assertEquals
import org.junit.Test

class TodoBusinessImplStubTest {

    @Test
    fun test(){
        val todoService = TodoServiceStub()
        val todoServiceImpl = TodosBusinessImpl(todoService)
        val filteredTodos = todoServiceImpl.retrieveTodosRelatedSpring("Dummy")
        assertEquals(2,filteredTodos.size)
    }

    @Test
    fun test_2(){
        val todoService = TodoServiceStub()
        val todoServiceImpl = TodosBusinessImpl(todoService)
        val filteredTodos = todoServiceImpl.retrieveTodosRelatedSpring("Dummy 1")
        assertEquals(0,filteredTodos.size)
    }
}