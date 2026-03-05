package com.amardeep.leetcodepractice.slidingwindow

import com.amardeep.leetcodepractice.Solution
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import org.junit.Before
import org.junit.Test

class SlidingWindowTest {
    private lateinit var solution: SlidingWindow
    @Before
    fun setUp() {
        solution = SlidingWindow()
    }
    @Test
    fun checkEmptyStringLongestSubString() {
      assertEquals(solution.lengthOfLongestSubstring(" "), 0)
    }
    @Test
    fun longestSubString() {
        assertEquals(solution.lengthOfLongestSubstring("abcad"), 4)
    }

    @Test
    fun characterReplacement() {
        assertEquals(solution.characterReplacement2("AABABBA", 1), 4)
    }

    @Test
    fun minWindow() {
        assertEquals(solution.minWindow("ADOBECODEBANC", "ABC"), "BANC")
    }
}