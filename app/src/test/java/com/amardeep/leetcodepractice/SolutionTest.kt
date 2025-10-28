package com.amardeep.leetcodepractice

import junit.framework.TestCase.assertEquals
import org.junit.Test


class SolutionTest {
    @Test
    fun twoSum() {
    }

    @Test
    fun countOnesTest() {
        val solution = Solution()
        val left = 4L// 100
        val right = 7L//111
        val result = solution.countOnes(left, right)
        assertEquals(8L, result)
    }

    @Test
    fun spiralOrderTest() {
        val solution = Solution()
        val matrix = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9)
        )
        val result = solution.spiralOrder(matrix)
        assertEquals(listOf(1, 2, 3, 6, 9, 8, 7, 4, 5), result)
    }

    @Test
    fun mergeTest() {
        val solution = Solution()
        val products = listOf("TV", "Phone", "Phone", "TV", "Bulb")

        val result = solution.findMostSoldItem(products)
        println(result)
    }


    @Test
    fun TestProduct() {

        val products = listOf("TV", "Phone", "Phone", "TV", "Bulb")

        val result = SolutionJava.findMostSoldItem(products)
        println(result)
    }
    
    @Test
    fun testFindMostSoldItem() {
        // Test case 1: Multiple items with one most sold
        val items1 = listOf("TV", "Phone", "Phone", "TV", "Bulb")
        assertEquals("TV : 2", SolutionJava.findMostSoldItem(items1))

        // Test case 2: All items have same count (should return first one)
        val items2 = listOf("Apple", "Banana", "Orange")
        assertEquals("Apple : 1", SolutionJava.findMostSoldItem(items2))

        // Test case 3: Single item in list
        val items3 = listOf("Laptop")
        assertEquals("Laptop : 1", SolutionJava.findMostSoldItem(items3))

        // Test case 4: Empty list
        val items4 = emptyList<String>()
        assertEquals("No items in the list.", SolutionJava.findMostSoldItem(items4))

        // Test case 5: Multiple items with same highest count (should return first one encountered)
        val items5 = listOf("A", "B", "B", "A", "C", "C", "D")
        assertEquals("A : 2", SolutionJava.findMostSoldItem(items5))
    }

    @Test
    fun testGroupAnagrams2() {
        val solution = Solution()

        solution.groupAnagrams2(arrayOf("act","pots","tops","cat","stop","hat"))

    }

    @Test
    fun testF() {
        val solution = Solution()

        solution.topKFrequent(intArrayOf(4,1,-1,2,-1,2,3), 2)
    }
}