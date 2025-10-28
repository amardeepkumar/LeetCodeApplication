package com.amardeep.leetcodepractice

import kotlin.collections.groupingBy
import kotlin.collections.toIntArray

class Solution {
    /**
     * Finds indices of the two numbers such that they add up to target.
     * @param nums Input array of integers
     * @param target Target sum
     * @return IntArray containing the indices of the two numbers
     * @throws IllegalArgumentException if no solution is found
     */
    //https://leetcode.com/problems/two-sum/
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = HashMap<Int, Int>()

        for ((index, num) in nums.withIndex()) {
            val complement = target - num
            map[complement]?.let { return intArrayOf(it, index) }
            map[num] = index
        }

        throw IllegalArgumentException("No two sum solution")
    }


    private fun countSetBits(n: Long): Long {
        var count = 0L
        var num = n
        while (num > 0) {
            num = num and (num - 1)
            count++
        }
        return count
    }

    //https://www.geeksforgeeks.org/dsa/count-set-bits-range/
    fun countOnes(l: Long, r: Long): Long {
        var result = 0L
        for (i in l..r) {
            result += countSetBits(i)
        }
        return result
    }

    //https://leetcode.com/problems/spiral-matrix/description/
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        var result = ArrayList<Int>()
        var top = 0
        var bottom = matrix.size - 1
        var left = 0
        var right = matrix[0].size - 1

        while (top <= bottom && left <= right) {
            for (i in left..right) {
                result.add(matrix[top][i])
            }
            top++
            for (i in top..bottom) {
                result.add(matrix[i][right])
            }
            right--
            if (top <= bottom) {
                for (i in right downTo left) {
                    result.add(matrix[bottom][i])
                }
                bottom--
            }
            if (left <= right) {
                for (i in bottom downTo top) {
                    result.add(matrix[i][left])
                }
                left++
            }
        }
        return result
    }

    //https://leetcode.com/problems/merge-intervals/description/
    fun mergeIntervals(intervals: Array<IntArray>): Array<IntArray> {
        if (intervals.isEmpty()) return emptyArray()

        intervals.sortBy { it[0] }
        val merged = mutableListOf<IntArray>()
        var currentInterval = intervals[0]
        for (i in 1 until intervals.size) {
            val nextInterval = intervals[i]

            if (nextInterval[0] <= currentInterval[1]) {
                currentInterval[1] = maxOf(currentInterval[1], nextInterval[1])
            } else {
                merged.add(currentInterval)
                currentInterval = nextInterval
            }
        }

        merged.add(currentInterval)
        return merged.toTypedArray()
    }


    //PayPal interview question
    fun findMostSoldItem(items: List<String>): String {
        // 1. Group items and count each occurrence.
        // The map will be created in the order of first appearance, e.g., {TV=2, Phone=2, Bulb=1}
        val productCountsMap = items.groupingBy { it }.eachCount()

        // 2. Find the map entry with the maximum count.
        // If multiple entries have the same max count, maxByOrNull returns the first one encountered.
        val mostSoldEntry = productCountsMap.maxByOrNull { it.value }

        // 3. Handle the case where the list was empty.
        return if (mostSoldEntry != null) {
            // 4. Format and return the output string.
            "${mostSoldEntry.key} : ${mostSoldEntry.value}"
        } else {
            "No items in the list."
        }
        var a = mutableSetOf<Int>()
        a.add(3)
    }


    //https://leetcode.com/problems/contains-duplicate/
    fun containsDuplicate(nums: IntArray): Boolean {
        //[1,1,1,3,3,4,3,2,4,2]

        val set = mutableSetOf<Int>()
        for (num in nums) {
            if (set.add(num) == false) {
                return true
            }
        }
        return false
    }

    //https://leetcode.com/problems/group-anagrams/description/
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val resultMap = mutableMapOf<Map<Char, Int>, ArrayList<String>>()

        for (str in strs) {
            val map = str.groupingBy { it }.eachCount()

            if (resultMap[map] != null) {
                resultMap[map]?.add(str)
            } else {
                resultMap[map] = arrayListOf(str)
            }
        }
        return resultMap.values.toList()
    }

    //https://leetcode.com/problems/group-anagrams/description/
    fun groupAnagrams2(strs: Array<String>): List<List<String>> {
        val res = HashMap<List<Int>, MutableList<String>>()

        for (s in strs) {
            val count = MutableList(26) { 0 }
            for (c in s) {
                count[c - 'a']++
            }
            res.getOrPut(count) { mutableListOf() }.add(s)
        }

        return res.values.toList()
    }

    //https://leetcode.com/problems/top-k-frequent-elements/description/
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val count = HashMap<Int, Int>()
        val freq = List(nums.size + 1) { mutableListOf<Int>() }

        for (num in nums) {
            count[num] = count.getOrDefault(num, 0) + 1
        }
        for ((num, cnt) in count) {
            freq[cnt].add(num)
        }

        val res = mutableListOf<Int>()
        for (i in freq.size - 1 downTo 1) {
            for (num in freq[i]) {
                res.add(num)
                if (res.size == k) {
                    return res.toIntArray()
                }
            }
        }
        return res.toIntArray()
    }

    fun topKFrequentr(nums: IntArray, k: Int): IntArray {
        val countMap = mutableMapOf<Int, Int>()

        val freqBucket = List(nums.size + 1) { mutableListOf<Int>() }


        for (num in nums) {
            countMap[num] = countMap.getOrDefault(num, 0) + 1
        }

        for ((num, occurence) in countMap) {
            freqBucket[occurence].add(num)
        }
        val result = mutableListOf<Int>()
        for (i in freqBucket.size - 1 downTo 1) {
            for (num in freqBucket[i]) {
                result.add(num)
                if (result.size == k) {
                    return result.toIntArray()
                }
            }
        }
        return result.toIntArray()
    }
}


