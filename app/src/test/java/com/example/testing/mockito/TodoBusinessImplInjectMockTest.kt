package com.example.testing.mockito

import com.example.testing.TodoService
import com.example.testing.TodosBusinessImpl
import junit.framework.TestCase
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.*
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoJUnitRunner
import java.util.*


@RunWith(MockitoJUnitRunner::class)
class TodoBusinessImplInjectMockTest {

    @get:Rule
    @JvmField
    public val mockitoRule = MockitoJUnit.rule()

    @Mock
    lateinit var todoServiceMock : TodoService

    @InjectMocks
    lateinit var todosBusiness : TodosBusinessImpl


    @Test
    fun testRetrieveTodosRelatedSpring_usingaMock() {
        //Given
        val todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to dance")
        Mockito.`when`(todoServiceMock.retrieveToDos("Dummy")).thenReturn(todos)
        //When
        val filteredTodos = todosBusiness.retrieveTodosRelatedSpring("Dummy")
        //Then
        TestCase.assertEquals(2, filteredTodos.size)
    }

    @Test
    fun testRetrieveTodosRelatedSpring_usingaMock_Empty() {
        val todos = Arrays.asList<String>()
        Mockito.`when`(todoServiceMock.retrieveToDos("Dummy")).thenReturn(todos)
        val filteredTodos = todosBusiness.retrieveTodosRelatedSpring("Dummy")
        TestCase.assertEquals(0, filteredTodos.size)
    }

    @Test
    fun testRetrieveTodosRelatedSpring_usingaMockGiven() {
        //Given
        val todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to dance")
        BDDMockito.given(todoServiceMock.retrieveToDos("Dummy")).willReturn(todos)
        //When
        val filteredTodos = todosBusiness.retrieveTodosRelatedSpring("Dummy")
        //Then
        MatcherAssert.assertThat(filteredTodos.size, CoreMatchers.`is`(2))
    }

    @Test
    fun testDeleteRetrieveTodosRelatedSpring_usingaMockGiven() {
        //Given
        val todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to dance")
        BDDMockito.given(todoServiceMock.retrieveToDos("Dummy")).willReturn(todos)
        //When
        val filteredTodos = todosBusiness.deleteTodosRelatedSpring("Dummy")
        //Then ans set the times that the mothed gets called, also check that never delete
        // an element that does not has to been deleted
        Mockito.verify(todoServiceMock, Mockito.times(1)).deleteTodo("Learn to dance")

        Mockito.verify(todoServiceMock, Mockito.never()).deleteTodo("Learn Spring MVC")

    }

    @Test
    fun testDeleteRetrieveTodosRelatedSpringAtLeastOnce_usingaMockGiven() {
        //Given
        val todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to dance")
        BDDMockito.given(todoServiceMock.retrieveToDos("Dummy")).willReturn(todos)
        //When
        val filteredTodos = todosBusiness.deleteTodosRelatedSpring("Dummy")
        //Then ans set the times that the mothed gets called, also check that never delete
        // an element that does not has to been deleted
        Mockito.verify(todoServiceMock, Mockito.atLeastOnce()).deleteTodo("Learn to dance")

        Mockito.verify(todoServiceMock, Mockito.never()).deleteTodo("Learn Spring MVC")

    }


}