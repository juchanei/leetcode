/**
 * https://leetcode.com/problems/longest-increasing-subsequence/
 * @param {number[]} nums
 * @return {number}
 */
var lengthOfLIS = function(nums) {
    const memo = Array(nums.length).fill(null)
    const find = index => {
        const memoized = memo[index]
        if (null !== memoized) return memoized

        let ret = 1
        for (let next = index + 1; next < nums.length; next++) {
            if (nums[index] < nums[next]) {
                ret = Math.max(ret, find(next) + 1)
                if (nums[index] + 1 === nums[next]) break;
            }
        }
        
        memo[index] = ret
        return ret
    }

    let ret = 0
    for (let i = 0; i < nums.length; i++) {
        ret = Math.max(ret, find(i))
    }
    return ret
};
