/**
 * https://leetcode.com/problems/longest-increasing-subsequence/
 * @param {number[]} nums
 * @return {number}
 */
var lengthOfLIS = function(nums) {
    if (nums.length === 0) return 0

    const memo = Array(nums.length).fill().map(_ => Array(nums.length).fill(null))
    const find = (prev, curr) => {
        if (curr === nums.length) return 0

        const memoized = memo[prev][curr]
        if (null !== memoized) return memoized

        let ret = 0
        if (nums[prev] < nums[curr]) {
            ret = Math.max(ret, find(curr, curr + 1) + 1)
        }
        ret = Math.max(ret, find(prev, curr + 1))
        
        memo[prev][curr] = ret
        return ret
    }

    let ret = 0
    for (let i = 0; i < nums.length; i++) {
        ret = Math.max(ret, find(i, i) + 1)
    }
    return ret
};
