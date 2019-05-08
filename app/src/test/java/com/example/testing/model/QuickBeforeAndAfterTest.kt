package com.example.testing.model

import org.junit.*

class QuickBeforeAndAfterTest {

    companion object {
        @BeforeClass
        @JvmStatic
        fun beforeClass(){
            System.out.println("Before class")
        }

        @AfterClass
        @JvmStatic
        fun afterClass(){
            System.out.println("After class")
        }
    }


    @Before
    fun setUp(){
        System.out.println("Before ")
    }

    @Test
    fun test1(){
        System.out.println("Executed 1")
    }

    @Test
    fun test2(){
        System.out.println("Executed 2")
    }

    @After
    fun tearDown(){
        System.out.println("After")

    }

}