package com.amardeep.leetcodepractice.twopointer

import org.junit.Before
import org.junit.Test

import junit.framework.TestCase.assertEquals

class TwoPointerSolutionTest {
    lateinit var twoPointerSolution: TwoPointerSolution

    @Before
    fun setUp() {
        twoPointerSolution = TwoPointerSolution()
    }

    @Test
    fun `Empty string input`() {
        // Test with an empty string. The function should return true as per the initial check.
        // TODO implement test
    }

    @Test
    fun `Single character string`() {
        // Test with a single character string. The while loop condition (i < j) will not be met, so it should return true.
        // TODO implement test
    }

    @Test
    fun `Simple palindrome with even length`() {
        // Test with a simple even-length palindromic string like 'abba'.
        // TODO implement test
    }

    @Test
    fun `Simple palindrome with odd length`() {
        // Test with a simple odd-length palindromic string like 'aba'. The middle character will be skipped as i becomes equal to j.
        // TODO implement test
    }

    fun `Non palindrome string`() {
        // Test with a string that is not a palindrome, like 'hello', to ensure it returns false.
        // TODO implement test
    }

    @Test
    fun `Palindrome with mixed case`() {
        assertEquals(twoPointerSolution.isPalindrome("0P0"), true)
    }
    
    @Test
    fun `Test productExceptSelf with 1,2,3,4`() {
        val input = intArrayOf(1, 2, 3, 4)
        val expected = intArrayOf(24, 12, 8, 6)
        val result = twoPointerSolution.productExceptSelf(input)
        assert(expected.contentEquals(result))
    }

    @Test
    fun `String with only non alphabetic characters`() {
        // Test with a string containing only characters that should be skipped, like '123_!$ '. 
        // The pointers should move inwards, and the function should return true.
        // TODO implement test
    }

    @Test
    fun `String with leading trailing non alphabetic characters`() {
        // Test a valid palindrome with leading and trailing non-alphabetic characters, like '...level...'
        // TODO implement test
    }

    @Test
    fun `Long palindrome string`() {
        // Test with a very long palindromic string to check for performance issues.
        // TODO implement test
    }

    @Test
    fun `Long non palindrome string`() {
        // Test with a very long non-palindromic string.
        // TODO implement test
    }

    @Test
    fun `String with characters at ASCII boundaries`() {
        // Test characters at the exact boundaries of the filter condition (ASCII 97 for 'a' and 112 for 'p'). For example, 'app' and 'ppa'.
        // TODO implement test
    }

    @Test
    fun `String with characters just outside ASCII boundaries`() {
        // Test with characters whose ASCII values are just outside the specified range, like '`' (ASCII 96) and 'q' (ASCII 113).
        // TODO implement test
    }

    @Test
    fun `Palindrome with repeated characters`() {
        // Test with a palindrome composed of all the same characters, like 'aaaaa'.
        // TODO implement test
    }

    @Test
    fun `String with two characters palindrome`() {
        // Test with a simple two-character palindrome like 'aa'.
        // TODO implement test
    }

    @Test
    fun `String with two characters non palindrome`() {
        // Test with a simple two-character non-palindrome like 'ab'.
        // TODO implement test
    }

    @Test
    fun `Bug analysis  Incorrect range check`() {
        // The character check `str[i].toInt() > 112 || str[i].toInt() < 97` is incorrect. It only allows 'a' through 'p'. 
        // A test with a palindrome like 'racecar' will fail because 'r' and 'c' are filtered out, leaving 'aea' which is not what's being compared.
        // TODO implement test
    }

    @Test
    fun testThreeSum_WithMultipleTriplets() {
        val nums = intArrayOf(-1, 0, 1, 2, -1, -4)
        val expected = listOf(
            listOf(-1, -1, 2),
            listOf(-1, 0, 1)
        )
        val result = twoPointerSolution.threeSum(nums)
        assertEquals(expected.sortedBy { it.toString() }, result.sortedBy { it.toString() })
    }

    @Test
    fun testThreeSum_NoValidTriplets() {
        val nums = intArrayOf(1, 2, -2, -1)
        val expected = emptyList<List<Int>>()
        val result = twoPointerSolution.threeSum(nums)
        assertEquals(expected, result)
    }

    @Test
    fun testThreeSum_AllZeros() {
        val nums = intArrayOf(0, 0, 0, 0)
        val expected = listOf(
            listOf(0, 0, 0)
        )
        val result = twoPointerSolution.threeSum(nums)
        assertEquals(expected, result)
    }

    @Test
    fun testThreeSum_WithDuplicates() {
        val nums = intArrayOf(-2, 0, 0, 2, 2)
        val expected = listOf(
            listOf(-2, 0, 2)
        )
        val result = twoPointerSolution.threeSum(nums)
        assertEquals(expected, result)
    }
}