package com.amardeep.leetcodepractice.array

import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test

class ArraySolutionTest {
    private lateinit var solution: ArraySolution

    @Before
    fun setUp() {
        solution = ArraySolution()
    }

    @Test
    fun testEncode() {
        val strs = mutableListOf("Hello", "World", "!")
        val result = solution.encode(strs)
        assertEquals("Hello World !", result)
    }

    @Test
    fun testEncodeWithEmpty() {
        val strs = mutableListOf<String>()
        val result = solution.encode(strs)
        assertEquals("", result)
    }

    @Test
    fun testDecode() {
        val str = "5#Hello5#World1#!"
        val result = solution.decode(str)
        assertEquals(listOf("Hello", "World", "!"), result)
    }

    @Test
    fun testDecodeWithEmpty() {
        val str = ""
        val result = solution.decode(str)
        assertEquals(emptyList<String>(), result)
    }
}