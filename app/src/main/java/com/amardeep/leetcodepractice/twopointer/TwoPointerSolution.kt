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

    //https://leetcode.com/problems/3sum/description/
    fun threeSum(nums: IntArray): List<List<Int>> {//[-1,0,1,2,-1,-4]
        val result = mutableListOf<List<Int>>()
        nums.sort()
        for ((i, num) in nums.withIndex()) {
            if (num > 0) {//If number is greater than 0 means no triplet can be found with this num
                break
            }
            if (i > 0 && nums[i - 1] == num) {//If number is same as last index then skip
                continue
            }
            var lp = i + 1
            var rp = nums.size - 1

            while (lp < rp) {
                val threeSum = num + nums[lp] + nums[rp]

                when {
                    threeSum > 0 -> rp--
                    threeSum < 0 -> lp++
                    else -> {
                        result.add(listOf(num, nums[lp], nums[rp]))
                        lp++
                        rp--
                        while (lp < rp && nums[lp] == nums[lp - 1]) {//Move left pointer if number is same as last index then skip
                            lp++
                        }
                    }
                }
            }
        }

        return result
    }
}