package com.example.testing.mockito;

import com.example.testing.TodoService;
import com.example.testing.TodosBusinessImpl;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.Captor;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static kotlin.text.Typography.times;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
public class AssertThat {

    @Captor
    ArgumentCaptor<String> argumentCaptor;

    @Test
    public void mockListGetAnyIntMethod_usingBDD(){
        //Given
        List<String> listMock = mock(List.class);
        given(listMock.get(ArgumentMatchers.anyInt())).willReturn("Eder");
        //When
        String firstElement = listMock.get(0);
        assertThat(firstElement, is("Eder"));
    }

    @Test
    public void captureArgument() {

        TodoService todoService = mock(TodoService.class);

        List<String> allTodos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
        Mockito.when(todoService.retrieveToDos("Ranga")).thenReturn(allTodos);

        TodosBusinessImpl todoBusinessImpl = new TodosBusinessImpl(todoService);
        todoBusinessImpl.deleteTodosRelatedSpring("Ranga");
        Mockito.verify(todoService).deleteTodo(argumentCaptor.capture());

        assertEquals("Learn to Dance", argumentCaptor.getValue());
    }

    @Test
    public void captureAlotOfArgument() {

        TodoService todoService = mock(TodoService.class);

        List<String> allTodos = Arrays.asList("Learn  MVC", "Learn Spring", "Learn to Dance");
        Mockito.when(todoService.retrieveToDos("Ranga")).thenReturn(allTodos);

        TodosBusinessImpl todoBusinessImpl = new TodosBusinessImpl(todoService);
        todoBusinessImpl.deleteTodosRelatedSpring("Ranga");
        then(todoService).should(times(2)).deleteTodo(argumentCaptor.capture());

        assertThat(argumentCaptor.getAllValues().size(),is(2));

    }

}
