package com.example.testing

import com.example.testing.model.Helper
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        val helper = Helper()
        assertEquals(14, helper.add(2,2))
    }

    @Test
    fun testConvertFahrenheitToCelsius() {
        val actual = convertFahrenheitToCelsius(100f)
        // expected value is 212
        val expected = 212f
        // use this method because float is not precise
        assertEquals("Conversion from celsius to fahrenheit failed",
            expected.toDouble(), actual.toDouble(), 0.001)
    }

    @Test
    fun testConvertCelsiusToFahrenheit() {
        val actual = convertFahrenheitToCelsius(212f)
        // expected value is 100
        val expected = 100f
        // use this method because float is not precise
        assertEquals("Conversion from celsius to fahrenheit failed",
            expected.toDouble(), actual.toDouble(), 0.001)
    }

    fun convertFahrenheitToCelsius(temperature : Float) : Float{
        val f = temperature * (9f/5) +32
        return f
    }


}
