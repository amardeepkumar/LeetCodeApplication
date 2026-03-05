package com.amardeep.leetcodepractice.slidingwindow

import java.util.Collections.max
import kotlin.math.max

class SlidingWindow {
    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
    fun maxProfit(prices: IntArray): Int {
        //var sellPrice = prices[0]
        var buyPrice = prices[0]
        var profit = 0

        for (price in prices) {
            if (price > buyPrice) {
                profit = max((price - buyPrice), profit)
            } else {
                buyPrice = price
            }
        }
        return profit
    }

    //https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
    fun lengthOfLongestSubstring(s: String): Int {
        var aPointer = 0
        var bPointer = 0
        var maxLen = 0
        var hashSet = mutableSetOf<Char>()

        while (bPointer < s.length) {
            if (!hashSet.contains(s[bPointer])) {
                hashSet.add(s[bPointer])
                bPointer++
                maxLen = maxOf(maxLen, hashSet.size)
            } else {
                hashSet.remove(s[aPointer])
                aPointer++
            }
        }
        return maxLen
    }

    //https://leetcode.com/problems/longest-repeating-character-replacement/description/
    fun characterReplacement(s: String, k: Int): Int {
        val counts = IntArray(26) // To store frequencies of 'A'-'Z'
        var maxFreq = 0
        var left = 0
        var maxLength = 0

        for (right in s.indices) {
            // 1. Add the new character to the window
            val charIndex = s[right] - 'A'
            counts[charIndex]++

            // 2. Track the most frequent character in the current window
            maxFreq = max(maxFreq, counts[charIndex])

            // 3. If window size - maxFreq > k, the window is invalid
            // We must shrink it from the left
            if ((right - left + 1) - maxFreq > k) {
                counts[s[left] - 'A']--
                left++
            }

            // 4. Update the maximum valid window found so far
            maxLength = max(maxLength, right - left + 1)
        }

        return maxLength
    }
    //https://leetcode.com/problems/longest-repeating-character-replacement/description/
    fun characterReplacement2(s: String, k: Int): Int {
        val freq = mutableMapOf<Char, Int>()
        var result = 0
        var i = 0
        var j = 0


        while (j < s.length) {
            freq[s[j]] = freq.getOrDefault(s[j], 0) + 1
            val maxFreq = max(freq.values)
            val currentLen = j - i + 1
            if (currentLen - maxFreq > k) {
                freq[s[i]] = freq.getOrDefault(s[j], 0) - 1
                i += 1
            }
            result = max(result, j - i + 1)
            j++
        }
        return result
    }


    fun characterReplacement7(s: String, k: Int): Int {
        val freq = mutableMapOf<Char, Int>()
        var result = 0
        var i = 0
        var j = 0
        var maxFreq = 0


        while (j < s.length) {
            freq[s[j]] = freq.getOrDefault(s[j], 0) + 1
            maxFreq = max(freq.getOrDefault(s[j], 0), maxFreq)
            if ((j - i + 1) - maxFreq > k) {
                freq[s[i]] = freq.getOrDefault(s[j], 0) - 1
                i += 1
            }
            result = max(result, j - i + 1)
            j++
        }
        return result
    }

    //Input: s = "ADOBECODEBANC", t = "ABC"
    //Output: "BANC"
    fun minWindow(s: String, t: String): String {
        var rp = 0
        var pointer = 0
        val tempResult = StringBuilder()
        val minResult = StringBuilder(s)
        var makeResult = false

        if (t.length > s.length) {
            return ""
        } else {
            while (rp < s.length) {
                while (pointer < t.length) {
                    if (rp > s.length) {
                        break
                    } else if (s[rp] == t[pointer]) {
                        if (pointer == 0) {
                            makeResult = true

                        }
                        tempResult.append(s[rp])
                        pointer++
                    } else if (makeResult) {
                        tempResult.append(s[rp])
                    }
                    rp++
                }
                makeResult = false
                pointer = 0
                if (tempResult.length < minResult.length) {
                    minResult.clear().append(tempResult)
                }
            }
        }
        return minResult.toString()
    }
}