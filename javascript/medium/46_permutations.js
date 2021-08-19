/**
 * https://leetcode.com/problems/permutations/submissions/
 * 
 * @param {number[]} nums
 * @return {number[][]}
 */

var permute = function(nums) {
    const result = []
    const selected = new Array(nums.length)
    const visited = new Array(nums.length)

    const _permute = count => {
        if (nums.length === count) {
            result.push([...selected])
            return
        }
        
        for (let i = 0; i < nums.length; i++) {
            if (visited[i]) continue;

            visited[i] = true
            selected[count] = nums[i]
            _permute(count + 1)
            visited[i] = false
        }
    }

    _permute(0)

    return result
};