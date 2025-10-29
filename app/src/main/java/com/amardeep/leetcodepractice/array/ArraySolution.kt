package com.amardeep.leetcodepractice.array

class ArraySolution {

    //https://neetcode.io/problems/string-encode-and-decode?list=blind75
    //--------------------------------------------------------------------
    fun encode(strs: MutableList<String>): String {
        var result = StringBuilder()
        for (str in strs) {
            result = result.append(str).append(" ")
        }
        return result.trim().toString()
    }

    fun decode(str: String): MutableList<String> {
        if (str.isEmpty()) return mutableListOf()
        return str.split(" ").toMutableList()
    }
    //------------------------------------------------------
}