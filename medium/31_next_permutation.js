/**
 * https://leetcode.com/problems/next-permutation/
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
const zip = (l1, l2) => {
    return Array(l1.length).fill().map((_, i) => [l1[i], l2[i]])
}

const sizeCheck = pred => (l1, l2) => {
    const test = zip(l1, l2).map(pred)
    for (let i = 0; i < l1.length; i++) {
        if (0 < test[i]) return true
        if (test[i] < 0) return false
    }
    return false
}

const lesser = sizeCheck(([a, b]) => b - a)
const greater = sizeCheck(([a, b]) => a - b)

const copy = (l1, l2) => {
    for (let i = 0; i < l1.length; i++) {
        l2[i] = l1[i]
    }
}

var nextPermutation = function(nums) {
    const size = nums.length

    const max = Array(size).fill(Number.MAX_SAFE_INTEGER)
    let min = max
    const visited = Array(size).fill(0)
    const selected = Array(size).fill(Number.MAX_SAFE_INTEGER)

    const find = count => {
        if (count === size) {
            if (greater(selected, nums) && lesser(selected, min)) {
                min = [...selected]
            }
            return
        }

        for (let i = 0; i < size; i++) {
            if (visited[i]) continue

            visited[i] = 1
            selected[count] = nums[i]
            if (lesser(selected, nums) || greater(selected, min)) {
                selected[count] = Number.MAX_SAFE_INTEGER
                visited[i] = 0
                continue
            }
            find(count + 1)
            selected[count] = Number.MAX_SAFE_INTEGER
            visited[i] = 0
        }
    }

    find(0)
    
    if (min === max) {
        nums.sort((a, b) => a - b)
        return
    }
    copy(min, nums)
};