package com.amardeep.leetcodepractice.array

import kotlin.math.max

class ArraySolution {
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

    //https://neetcode.io/problems/string-encode-and-decode?list=blind75
    //--------------------------------------------------------------------
    fun encode(strs: MutableList<String>): String {
        var result = StringBuilder()
        for (str in strs) {
            result = result.append(str.length).append("#").append(str)
        }
        return result.toString()
    }

    fun decode(str: String): MutableList<String> {
        if (str.isEmpty()) return mutableListOf()
        var result = mutableListOf<String>()
        var i = 0
        while (i < str.length - 1) {
            var j = i
            while (str[j] != '#') {
                j++
            }
            val length = str.substring(i, j).toInt()
            result.add(str.substring(j + 1, j + 1 + length))
            i = j + 1 + length
        }

        return result
    }
    //------------------------------------------------------

    //https://leetcode.com/problems/longest-consecutive-sequence/
    fun longestConsecutive(nums: IntArray): Int {
        //[100,4,200,1,3,2]
        val numSet = nums.toSet()
        var longest = 0
        for (i in numSet) {
            if (!numSet.contains(i - 1)) {
                var length = 1
                while(numSet.contains(i + length)) {
                    length++
                }
                longest = max(length, longest)
            }
        }
        return longest
    }

    //https://leetcode.com/problems/zigzag-conversion/description/
    fun zigzag(s: String, numRows: Int): String {
        val charList = List(numRows) { mutableListOf<Char>() }
        var inc = true
        var j = 0
        for (i in s) {
            charList[j].add(i)
            if (j == numRows - 1) inc = false
            if (j == 0) inc = true
            if (inc) {
                j++
            } else {
                j--
            }
        }
        var result = ""
        for (c in charList) {
            result = result + c.joinToString(separator = "")
        }
        return result
    }
}