package com.example.testing.model

import org.junit.Assert.assertArrayEquals
import org.junit.Test
import java.lang.NullPointerException
import java.util.*

class ArraysCompareTest {

    //Arrays.sort

    @Test
    fun test(){
        val array = arrayOf(12,3,4,1)
        val expected = arrayOf(1,3,4,12)
        Arrays.sort(array)
        assertArrayEquals(expected,array)
    }

    @Test(expected = NullPointerException::class)
    fun testException(){
        val array : Array<Int>? = null
        Arrays.sort(array)
    }

    @Test(timeout = 100)
    fun testSort_Performance(){
        val array = arrayOf(12,3,4,1)
        for (number  in 0..1000000){
            array[0] = number
            Arrays.sort(array)
        }

    }

}