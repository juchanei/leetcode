/**
 * https://leetcode.com/problems/unique-paths/
 * @param {number} m
 * @param {number} n
 * @return {number}
 */

var uniquePaths = function(m, n) {

    const memo = Array(m).fill().map(() => Array(n).fill(-1))

    const _uniquePaths = (x, y) => {
        if (m <= x || n <= y) return 0
        const memoized = memo[x][y]
        if (-1 !== memoized) return memoized

        if ((x === (m - 1)) && (y === (n - 1))) return 1

        const ret = _uniquePaths(x + 1, y) + _uniquePaths(x, y + 1)

        memo[x][y] = ret
        return ret
    }

    return _uniquePaths(0, 0)
};