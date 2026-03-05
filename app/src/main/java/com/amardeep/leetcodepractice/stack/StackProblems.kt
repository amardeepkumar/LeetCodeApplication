package com.amardeep.leetcodepractice.stack

class StackProblems {

    //https://leetcode.com/problems/valid-parentheses/description/
    fun isValidParentheses(s: String): Boolean {
        val stack = ArrayDeque<Char>()
        //Input: s = "([])"
        // ( char=( opening bracket so push
        // (, [ char = [ opening bracket so push
        // (, [ char = ] closing bracket so peek if peek is [ then pop else break
        // ( char = ) closing bracket so peek if peek is [ then pop else break
        //check the length of stack

        for (i in s) {

            when (i) {
                '[', '(', '{' -> {
                    stack.addFirst(i)
                }
                ')' -> {
                    if (stack.isNotEmpty() && stack.first() == '(') {
                        stack.removeFirst()
                    } else {
                        return false
                    }
                }
                ']' -> {
                    if (stack.isNotEmpty() && stack.first() == '[') {
                        stack.removeFirst()
                    } else {
                        return false
                    }
                }
                '}' -> {
                    if (stack.isNotEmpty() && stack.first() == '{') {
                        stack.removeFirst()
                    } else {
                        return false
                    }
                }
            }
        }
        return stack.isEmpty()
    }

    //https://leetcode.com/problems/min-stack/description/
    class MinStack() {

        val minStack = ArrayDeque<Int>()
        val stack = ArrayDeque<Int>()

        fun push(`val`: Int) {
            stack.addFirst(`val`)
            if (minStack.isEmpty() || minStack.first() >= `val`) {
                minStack.addFirst(`val`)
            }
        }

        fun pop() {
            val poppedVal = stack.removeFirst()
            if (minStack.isNotEmpty() && poppedVal == minStack.first()) {
                minStack.removeFirst();
            }
        }

        fun top(): Int {
            return stack.firstOrNull()?:0
        }

        fun getMin(): Int {
            return minStack.firstOrNull()?:0
        }
    }
}