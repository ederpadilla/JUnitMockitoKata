package com.example.testing.model

import org.junit.After
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class StringHelperTest {

    private lateinit var stringHelper : StringHelper
    @Before
    fun setUp(){
        stringHelper = StringHelper()
    }


    @Test
    fun firstSample(){
        assertEquals("hola","hola")
    }
    @Test
    fun truncateAInFirst2Positions_Condition1() {
         assertEquals("CD",stringHelper.truncateAInFirst2Positions("AACD"))
    }

    @Test
    fun test2_AinFirstPos(){
        assertEquals("CD",stringHelper.truncateAInFirst2Positions("ACD"))
    }

    @Test
    fun areFirstAndLastTwoCharactersTheSame_1() {
        assertFalse( stringHelper.areFirstAndLastTwoCharactersTheSame("ABCD"))
    }

    @Test
    fun areFirstAndLastTwoCharactersTheSame_2() {
        assertTrue( stringHelper.areFirstAndLastTwoCharactersTheSame("ABAB"))
    }

    @Test
    fun areFirstAndLastTwoCharactersTheSame_3() {
        assertFalse( stringHelper.areFirstAndLastTwoCharactersTheSame("ABCD"))
    }

    @After
    fun tearDown(){

    }
}