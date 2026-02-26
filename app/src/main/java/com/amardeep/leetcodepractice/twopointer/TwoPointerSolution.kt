package com.amardeep.leetcodepractice.twopointer

class TwoPointerSolution {
    //https://leetcode.com/problems/valid-palindrome/description/
    fun isPalindrome(s: String): Boolean {

        if (s.isEmpty()) return true
        var i = 0
        var j = s.length - 1
        val str = s.lowercase()

        while (i < j) {
            when (str[i].code) {
                in 97..122 -> {}
                in 48..57 -> {}
                else -> {
                    i++
                    continue
                }

            }

            when (str[j].code) {
                in 97..122 -> {}
                in 48..57 -> {}
                else -> {
                    j--
                    continue
                }

            }

            if (str[i] != str[j]) {
                return false
            }
            i++
            j--
        }
        return true
    }

    //https://leetcode.com/problems/product-of-array-except-self/description/
    fun productExceptSelf(nums: IntArray): IntArray {
        var multiplier = 1
        val result = IntArray(nums.size) {1}

        nums.forEachIndexed() { index, element ->
            result[index] = multiplier
            multiplier = multiplier * element
        }
        multiplier = 1
        for (i in nums.lastIndex downTo 0) {
            result[i] = result[i] * multiplier
            multiplier = multiplier * nums[i]
        }

        return result
    }
}