/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */

const identity = e => e

function freq(f, iter) {
    const acc = {}
    for (const x of iter) {
        const key = f(x)
        const value = acc[key]
        acc[key] = value === undefined ? 1 : value + 1
    }
    return acc
}

const toList = obj => Object.keys(obj).map(key => ({ key, value: obj[key]}))

var findKthLargest = function(nums, k) {
    if (nums.length <= 0) return -1

    const counts = toList(freq(identity, nums)).sort((a, b) => b.key - a.key)

    const rest = k
    for (const count of counts) {
        if (k - count.value <= 0) {
            return count.key
        }
        k -= count.value
    }
    return counts[counts.length - 1].value
};