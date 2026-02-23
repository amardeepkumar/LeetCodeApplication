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

    @Test
    fun `Test with multiple disjoint consecutive sequences`() {
        // Input: [1, 2, 3, 10, 11, 12, 13, 5, 6]
        // Expected Output: 4
        // Rationale: The function should correctly identify the longest sequence ([10, 11, 12, 13]) among multiple sequences.
        val result = solution.longestConsecutive(intArrayOf(1, 2, 3, 10, 11, 12, 13, 5, 6))
        assertEquals(4, result)
    }


    @Test
    fun testAnagram() {
        assertEquals(solution.isAnagram("hello", "olehh"), false)
    }

    @Test
    fun `Test zigzag`() {
        val result = solution.zigzag("PAYPALISHIRING", 4)
        assertEquals(result, "PINALSIGYAHRPI")
    }
}