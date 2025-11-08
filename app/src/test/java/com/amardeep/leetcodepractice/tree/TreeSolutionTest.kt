package com.amardeep.leetcodepractice.tree

import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test

class TreeSolutionTest {
    private lateinit var solution: TreeSolution
    @Before
    fun setUp() {
        solution = TreeSolution()
    }

    @Test
    fun `Test number of island`() {
        val result = solution.numIslands(arrayOf(charArrayOf('1','1','1','1','0'),
            charArrayOf('1','1','0','1','0'),
            charArrayOf('1','1','0','0','0'),
            charArrayOf('0','0','0','0','0')))
        assertEquals(result, 1)
    }
}