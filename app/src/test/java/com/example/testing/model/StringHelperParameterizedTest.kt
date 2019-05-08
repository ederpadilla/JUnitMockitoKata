package com.example.testing.model

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

import java.util.Arrays

import junit.framework.TestCase.assertEquals

@RunWith(Parameterized::class)
class StringHelperParameterizedTest(private val input: String, private val expectedOutput: String) {

    // AACD => CD ACD => CD CDEF=>CDEF CDAA => CDAA

    private var helper = StringHelper()

    @Test
    fun testTruncateAInFirst2Positions() {
        assertEquals(
            expectedOutput,
            helper.truncateAInFirst2Positions(input)
        )
    }

    companion object {

        @Parameterized.Parameters
        @JvmStatic
        fun testConditions(): Collection<Array<String>> {
            val expectedOutputs = arrayOf(arrayOf("AACD", "CD"), arrayOf("ACD", "CD"))
            return Arrays.asList(*expectedOutputs)
        }
    }
}
