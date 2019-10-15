/**
 * @param {number[]} nums
 * @return {number[][]}
 */

var subsets = function(nums) {
    if (0 === nums.length) return [[]]

    const [first, ...rest] = nums
    const listOfResult = subsets(rest)

    return [
        ...listOfResult,
        ...listOfResult.map(result => [...result, first])
    ]
};


const ret = subsets([1,2,3])

console.log(ret)