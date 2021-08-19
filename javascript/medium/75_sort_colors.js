/**
 * https://leetcode.com/problems/sort-colors/
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */

var sortColors = function(nums) {
    let left = 0
    let right = nums.length - 1

    const swap = (i, j) => {
        const temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp
    }

    for (let i = 0; i < nums.length; i++) {
        if (0 === nums[i]) {
            nums[i] = 1
            nums[left] = 0
            left++
        }
        else if (2 === nums[i]) {
            swap(i, right)
            i--
            right--
        }
        if (right <= i) break;
        if (left === right) break;
    }

    return nums
};