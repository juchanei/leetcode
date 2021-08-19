/**
 * https://leetcode.com/problems/find-the-duplicate-number/submissions/
 * 
 * @param {number[]} nums
 * @return {number}
 */
// const sum = nums => nums.reduce((sum, num) => sum + num, 0)
// const sumFromOneTo = n => (n + 1) * Math.floor(n / 2) + (n % 2 ? Math.ceil(n / 2) : 0)
// const _findDuplicate1 = nums => sum(nums) - sumFromOneTo(nums.length - 1)

const _findDuplicate2 = nums => {
    const size = nums.length
    for (let i = 0; i < size; i++) 
        for (let j = i + 1; j < size; j++) 
            if (nums[i] === nums[j]) return nums[i]
}

var findDuplicate = function(nums) {
    // return _findDuplicate1(nums)
    return _findDuplicate2(nums)
};