/**
 * https://leetcode.com/problems/perfect-squares/
 * @param {number} n
 * @return {number}
 */
function * map(f, iter) {
    for (const x of iter) yield f(x)
}

function * range(start, end, step = 1) {
    for (let i = start; i < end; i += step) yield i
}

function takeUntil(cond, iter) {
    const ret = []
    for (const x of iter) {
        if (!cond(x)) return ret
        ret.push(x) 
    }
    return ret
}

const min = (a, b) => a < b ? a : b

var numSquares = function(n) {
    const candicates =
        takeUntil(d => d <= n,
            map(d => d*d,
                range(1, Infinity)))

    const memo = Array(n + 1).fill(null)
    const find = n => {
        if (n === 0) return 0
        if (n < 0) return Number.MAX_SAFE_INTEGER

        const memoized = memo[n]
        if (null !== memoized) return memoized

        let ret = Number.MAX_SAFE_INTEGER
        for (const candidate of candicates) {
            if (n < candidate) break
            ret = min(ret, find(n - candidate) + 1)
        }
        
        memo[n] = ret
        return ret
    }

    return find(n)
};