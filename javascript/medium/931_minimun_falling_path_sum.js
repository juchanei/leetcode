/**
 * https://leetcode.com/problems/minimum-falling-path-sum/
 * @param {number[][]} A
 * @return {number}
 */
function * range(start, end, step = 1) {
    for (let i = start; i < end; i += step) yield i
}

function * map(f, iter) {
    for (const x of iter) yield f(x)
}

function reduce(f, acc, iter) {
    for (const x of iter) {
        acc = f(acc, x)
    }
    return acc
}

function * filter(f, iter) {
    for (const x of iter) {
        if (f(x)) yield x
    }
}

var minFallingPathSum = function(A) {
    const height = A.length
    if (height === 0) return null
    const width = A[0].length
    if (width === 0) return null

    const memo = Array(height).fill().map(_ => Array(width).fill(null))
    const find = (x, y) => {
        if (y === height) return 0

        const memoized = memo[y][x]
        if (null !== memoized) return memoized

        const ret = 
            reduce(Math.min, Number.MAX_SAFE_INTEGER,
                map(nextX => find(nextX, y + 1) + A[y][x],
                    filter(x => 0 <= x && x < width,
                        range(x - 1, x + 2))))

        memo[y][x] = ret
        return ret
    }

    return (
        reduce(Math.min, Number.MAX_SAFE_INTEGER,
            map(startX =>find(startX, 0),
                range(0, width)))
    )
};
