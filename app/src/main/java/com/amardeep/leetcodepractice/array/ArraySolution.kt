package com.amardeep.leetcodepractice.array

import kotlin.math.max

class ArraySolution {

    //https://leetcode.com/problems/valid-anagram/description/
    fun isAnagram(s: String, t: String): Boolean {

        if (s.length != t.length) {
            return false
        }
        val arr = IntArray(26)
        for (c in s) {
            arr[c - 'a'] += 1
        }

        for (c in t) {
            arr[c - 'a'] -= 1
        }

        for (c in arr) {
            if (c != 0) {
                return false
            }
        }

        return true
    }

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
                while (numSet.contains(i + length)) {
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

    fun threeSum(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        nums.sort()
        for ((i, num) in nums.withIndex()) {
            if (num > 0) {
                break
            }
            if (i > 0 && nums[i - 1] == num) {
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
                        while (lp < rp && nums[lp] == nums[lp - 1]) {
                            lp++
                        }
                    }
                }
            }
        }

        return result
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

    fun topKFrequent2(nums: IntArray, k: Int): IntArray {
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

    fun topKFrequent3(nums: IntArray, k: Int): IntArray {

        //Input: nums = [1,1,1,2,2,3], k = 2

        //Output: [1,2]
        return nums.groupBy { it }                // Group numbers
            .mapValues { it.value.size }          // Count occurrences
            .entries
            .sortedByDescending { it.value }      // Sort by frequency
            .take(k)                              // Take top k
            .map { it.key }                       // Extract keys
            .toIntArray()
    }


    /*fun shipWithinDays(weights: IntArray, days: Int): Int {
        //find the sum of weight
        //get the avg of total weight
        //Check the output starting from avg

        var minAvg = weights.sum() / days
        var dayCont = days

        while (dayCont > 0) {


            var lp = 0
            var w =  weights[lp]
            var rp = lp + 1
            while (rp < weights.size) {
                if (minAvg > (w + weights[rp])) {
                    w = w + weights[rp]
                    rp++
                    dayCont--
                } else {
                    minAvg++
                    rp = lp + 1
                }
            }

        }

    }*/
}
