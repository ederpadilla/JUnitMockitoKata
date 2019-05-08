package com.example.testing.mockito

import com.example.testing.TodoService
import com.example.testing.TodoServiceStub
import com.example.testing.TodosBusinessImpl
import junit.framework.Assert.assertEquals
import junit.framework.TestCase
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.Assert.assertThat
import org.junit.Test
import org.mockito.ArgumentCaptor
import org.mockito.BDDMockito.given
import org.mockito.BDDMockito.then
import org.mockito.Mockito
import org.mockito.Mockito.*
import java.util.*

class TodoBusinessImplMockTest {


    @Test
    fun testRetrieveTodosRelatedSpring_usingaMock() {
        //Given
        val todoServiceMock = mock(TodoService::class.java)
        val todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to dance")
        Mockito.`when`(todoServiceMock.retrieveToDos("Dummy")).thenReturn(todos)
        val todosBusiness = TodosBusinessImpl(todoServiceMock)
        //When
        val filteredTodos = todosBusiness.retrieveTodosRelatedSpring("Dummy")
        //Then
        TestCase.assertEquals(2, filteredTodos.size)
    }

    @Test
    fun testRetrieveTodosRelatedSpring_usingaMock_Empty() {
        val todoServiceMock = mock(TodoService::class.java)
        val todos = Arrays.asList<String>()
        Mockito.`when`(todoServiceMock.retrieveToDos("Dummy")).thenReturn(todos)
        val todosBusiness = TodosBusinessImpl(todoServiceMock)
        val filteredTodos = todosBusiness.retrieveTodosRelatedSpring("Dummy")
        TestCase.assertEquals(0, filteredTodos.size)
    }

    @Test
    fun testRetrieveTodosRelatedSpring_usingaMockGiven() {
        //Given
        val todoServiceMock = mock(TodoService::class.java)
        val todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to dance")
        given(todoServiceMock.retrieveToDos("Dummy")).willReturn(todos)
        val todosBusiness = TodosBusinessImpl(todoServiceMock)
        //When
        val filteredTodos = todosBusiness.retrieveTodosRelatedSpring("Dummy")
        //Then
        MatcherAssert.assertThat(filteredTodos.size, CoreMatchers.`is`(2))
    }

    @Test
    fun testDeleteRetrieveTodosRelatedSpring_usingaMockGiven() {
        //Given
        val todoServiceMock = mock(TodoService::class.java)
        val todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to dance")
        given(todoServiceMock.retrieveToDos("Dummy")).willReturn(todos)
        val todosBusiness = TodosBusinessImpl(todoServiceMock)
        //When
        val filteredTodos = todosBusiness.deleteTodosRelatedSpring("Dummy")
        //Then ans set the times that the mothed gets called, also check that never delete
        // an element that does not has to been deleted
        verify(todoServiceMock,times(1)).deleteTodo("Learn to dance")

        verify(todoServiceMock, never()).deleteTodo("Learn Spring MVC")

    }

    @Test
    fun testDeleteRetrieveTodosRelatedSpringAtLeastOnce_usingaMockGiven() {
        //Given
        val todoServiceMock = mock(TodoService::class.java)
        val todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to dance")
        given(todoServiceMock.retrieveToDos("Dummy")).willReturn(todos)
        val todosBusiness = TodosBusinessImpl(todoServiceMock)
        //When
        val filteredTodos = todosBusiness.deleteTodosRelatedSpring("Dummy")
        //Then ans set the times that the mothed gets called, also check that never delete
        // an element that does not has to been deleted
        verify(todoServiceMock, atLeastOnce()).deleteTodo("Learn to dance")

        verify(todoServiceMock, never()).deleteTodo("Learn Spring MVC")

    }

/*    @Test
    fun captureAlotOfArgument() {
        val argumentCaptor = ArgumentCaptor.forClass(String::class.java)

        val todoService = mock(TodoService::class.java)

        val allTodos = Arrays.asList("Learn  MVC", "Learn Spring", "Learn to Dance")
        Mockito.`when`(todoService.retrieveToDos("Ranga")).thenReturn(allTodos)

        val todoBusinessImpl = TodosBusinessImpl(todoService)
        todoBusinessImpl.deleteTodosRelatedSpring("Ranga")
        then(todoService).should(times(2)).deleteTodo(argumentCaptor.capture())

        assertThat(argumentCaptor.allValues.size, CoreMatchers.`is`<Int>(2))
    }*/
}
