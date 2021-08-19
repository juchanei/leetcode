/**
 * https://leetcode.com/problems/minimum-path-sum/
 * @param {number[][]} grid
 * @return {number}
 */

const min = (a, b) => a < b ? a : b

var minPathSum = function (grid) {
    const height = grid.length - 1
    const width = grid[0].length - 1

    const memo = Array(height + 1).fill().map(() => Array(width + 1).fill(-1))

    const find = (x, y) => {
        if (x === width && y === height) return grid[y][x]
        if (width < x || height < y) return Number.MAX_SAFE_INTEGER

        const memoized = memo[y][x]
        if (-1 !== memoized) return memoized
    
        const ret = min(find(x + 1, y), find(x, y + 1)) + grid[y][x]

        memo[y][x] = ret
        return ret
    }

    return find(0, 0)
};