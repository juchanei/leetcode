/**
 * https://leetcode.com/problems/coin-change/
 * @param {number[]} coins
 * @param {number} amount
 * @return {number}
 */
const min = (a, b) => a < b ? a : b

var coinChange = function(coins, amount) {
    
    const memo = Array(coins.length).fill().map(() => Array(amount+1).fill(null))
    const find = (index, left) => {
        if (left === 0) return 0
        if (left < 0) return Number.MAX_SAFE_INTEGER
        if (coins.length <= index) return Number.MAX_SAFE_INTEGER

        const memoized = memo[index][left]
        if (null !== memoized) return memoized

        const ret = min(
            find(index, left - coins[index]) + 1,
            find(index + 1, left),
        )

        memo[index][left] = ret
        return ret
    }

    const ret = find(0, amount)
    return ret < Number.MAX_SAFE_INTEGER ? ret : -1
};