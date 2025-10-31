package com.amardeep.leetcodepractice.array

class ArraySolution {

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
}