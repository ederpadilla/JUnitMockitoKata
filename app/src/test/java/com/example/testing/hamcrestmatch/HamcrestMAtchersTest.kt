package com.example.testing.hamcrestmatch

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers
import org.hamcrest.Matchers.*
import org.junit.Test
import java.util.*

class HamcrestMAtchersTest {

    @Test
    fun test(){
        val scores = Arrays.asList(99,100,101,105)
        assertThat(scores,hasSize(4))
    }

    @Test
    fun hasItems(){
        val scores = Arrays.asList(99,100,101,105)
        assertThat(scores, hasItems(99,100))
    }

    @Test
    fun everyItem(){
        val scores = Arrays.asList(99,100,101,105)
        assertThat(scores, Matchers.everyItem(greaterThan(90)))
        //assertThat(scores, Matchers.everyItem(lessThan(90)))
    }

    @Test
    fun everyItemLEsttTHan(){
        val scores = Arrays.asList(79,80,81,85)
        assertThat(scores, Matchers.everyItem(lessThan(90)))
    }

    @Test
    fun isEmptyString(){
        //assertThat("", isEmptyString())
    }


    @Test
    fun sizeArray(){
        val marks = arrayOf(1, 2, 3)
        assertThat(marks, arrayWithSize(3))
    }


}