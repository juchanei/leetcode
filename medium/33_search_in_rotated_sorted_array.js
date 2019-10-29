/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */

const max = (a, b) => a < b ? b : a

var search = function(nums, target) {
    if (nums.length === 0) return -1

    const _search = (left, right) => {
        if (right === left) 
            return nums[left] === target ? left : -1

        const pivot = Math.floor((left + right)/2)
        return max(_search(left, pivot), _search(pivot + 1, right))
    }

    return _search(0, nums.length - 1)
};