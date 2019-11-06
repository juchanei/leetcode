/**
 * https://leetcode.com/problems/combination-sum-ii/
 * @param {number[]} candidates
 * @param {number} target
 * @return {number[][]}
 */

var combinationSum2 = function(_candidates, target) {

    const candidates = _candidates.sort((a, b) => a - b)

    const advance = (index, candidate) => {
        while (candidates[index] === candidate && index < candidates.length)
            index++
        return index
    }

    const memo = Array(candidates.length + 1).fill().map(() => Array(target + 1).fill(-1))

    const _combinationSum2 = (index, target) => {
        if (0 === target) return [[]]
        if (target < 0) return []
        if (index == candidates.length) return []

        const memoized = memo[index][target]
        if (-1 !== memoized) return memoized

        const candidate = candidates[index]

        const ret = [
            ..._combinationSum2(index + 1, target - candidate).map(ret => [candidate, ...ret]),
            ..._combinationSum2(advance(index + 1, candidate), target),
        ]

        memo[index][target] = ret
        return ret
    }

    return _combinationSum2(0, target)
};