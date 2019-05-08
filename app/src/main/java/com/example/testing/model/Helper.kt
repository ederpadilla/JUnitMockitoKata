package com.example.testing.model

class Helper {

    fun add(numOne : Int, numTwo : Int):Int{
        return numOne+numTwo+tax()
    }

    private fun tax():Int{
        return 10
    }

}