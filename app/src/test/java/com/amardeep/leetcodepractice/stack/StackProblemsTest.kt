package com.amardeep.leetcodepractice.stack

import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test

class StackProblemsTest {
    lateinit var solution: StackProblems

    @Before
    fun setUp() {
        solution = StackProblems()
    }

    @Test
    fun isValidParentheses() {
        assertEquals(solution.isValidParentheses("()]{}"), false)
    }
}