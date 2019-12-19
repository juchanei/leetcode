/**
 * https://leetcode.com/problems/wiggle-sort-ii/
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var wiggleSort = function(nums) {
    const size = nums.length
    const half = Math.ceil(nums.length / 2)
    nums.sort((a,b) => a - b)

    const ret = Array(size).fill()
    for (let i = 0; i < half; i++) {
        if (i < half) ret[i * 2] = nums[i]
        else ret[(i - half) * 2 + 1] = nums[i]
    }

    for (let i = 0; i < size; i++) {
        nums[i] = ret[i]
    }
};
