/**
 * https://leetcode.com/problems/combination-sum/
 * @param {number[]} candidates
 * @param {number} target
 * @return {number[][]}
 */

const repeat = (value, repeatCount) => Array(repeatCount).fill(value)
const range = (start, end) => repeat(null, end - start).map((_, i) => start + i)
 
var combinationSum = function(candidates, target) {
    
    const memo = repeat(null, candidates.length + 1).map(() => repeat(-1, target + 1))

    const _combinationSum = (index, target) => {
        if (0 === target) return [[]]
        if (index === candidates.length) return []

        const memoized = memo[index][target]
        if (-1 !== memoized) return memoized

        const candidate = candidates[index]
        const ret = range(0, Math.floor(target/candidate) + 1)
            .map(count => {
                const nextTarget = target - candidate*count
                if (nextTarget < 0) return [];

                return _combinationSum(index + 1, nextTarget)
                    .map(ret => [...repeat(candidate, count), ...ret])
            })
            .reduce((acc, cur) => [...acc, ...cur], [])

        memo[index][target] = ret
        return ret
    }

    return _combinationSum(0, target)
};