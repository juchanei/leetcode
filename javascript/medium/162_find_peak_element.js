/**
 * https://leetcode.com/problems/find-peak-element/
 * @param {number[]} nums
 * @return {number}
 */
var findPeakElement = function(nums) {
    const findPeak = () => {
        for (let i = 1; i < nums.length - 1; i++) {
            const left = nums[i - 1]
            const middle = nums[i]
            const right = nums[i + 1]
            if (left < middle && right < middle)
                return i
        }

        return null
    }

    const size = nums.length

    if (size == 1) return 0
    if (nums[1] < nums[0]) return 0
    if (nums[size - 2] < nums[size - 1]) return size - 1
    return findPeak()
};
