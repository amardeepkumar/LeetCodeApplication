package com.amardeep.leetcodepractice.tree

class TreeSolution {

    fun numIslands(grid: Array<CharArray>): Int {
        var islandCount = 0
        for (i in grid.indices) {
            for (j in grid[i].indices) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j)
                    islandCount++
                }
            }
        }
        return islandCount
    }

    private fun dfs(grid: Array<CharArray>, i: Int, j: Int) {
        if (i < 0 || j < 0 || i >= grid.size || j >= grid[i].size || grid[i][j] != '1') return
        grid[i][j] = 'X'
        dfs(grid, i + 1, j)
        dfs(grid, i - 1, j)
        dfs(grid, i, j + 1)
        dfs(grid, i, j - 1)
    }
}