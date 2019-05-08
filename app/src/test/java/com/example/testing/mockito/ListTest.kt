package com.example.testing.mockito

import junit.framework.Assert.assertEquals
import org.hamcrest.CoreMatchers
import org.hamcrest.Matcher
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.BDDMockito.given
import org.mockito.Mockito
import org.mockito.Mockito.anyInt
import org.mockito.Mockito.mock
import java.lang.RuntimeException

class ListTest {

    @Test
    fun mockListSizeMethod(){
        val listMock = mock(List::class.java)
        Mockito.`when`(listMock.size).thenReturn(5)
        assertEquals(5,listMock.size)
    }

    @Test
    fun mockListSizeMethodWithMultipleValues(){
        val listMock = mock(List::class.java)
        Mockito.`when`(listMock.size).thenReturn(5).thenReturn(3).thenReturn(4)
        assertEquals(5,listMock.size)
        assertEquals(3,listMock.size)
        assertEquals(4,listMock.size)
    }

    @Test
    fun mockListGetMethod(){
        val listMock = mock(List::class.java)
        Mockito.`when`(listMock[0]).thenReturn("Eder")
        assertEquals("Eder", listMock[0])
    }

    @Test
    fun mockListGetAnyIntMethod(){
        val listMock = mock(List::class.java)
        Mockito.`when`(listMock[ArgumentMatchers.anyInt()]).thenReturn("Eder")
        assertEquals("Eder", listMock[0])
    }

    @Test
    fun mockListGetAnyIntMethod_usingBDD(){
        //Given
        val listMock = mock(List::class.java)
        given(listMock[ArgumentMatchers.anyInt()]).willReturn("Eder")
        //When
        val firstElement = listMock[0]
        //assertThat(firstElement,CoreMatchers.`is`("Eder"))
    }




    @Test(expected = RuntimeException::class)
    fun mockListGetAnyIntMethodThrowsAnyExcepection(){
        val listMock = mock(List::class.java)
        Mockito.`when`(listMock[ArgumentMatchers.anyInt()]).thenThrow(RuntimeException("Some message"))
        assertEquals("Eder", listMock[0])
    }


}