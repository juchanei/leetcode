/**
 * https://leetcode.com/problems/search-a-2d-matrix-ii/
 * @param {number[][]} matrix
 * @param {number} target
 * @return {boolean}
 */

var searchMatrix = function(matrix, target) {

    const findIndex = (rowIndex, boundary, target) => {
        let i = Math.ceil(boundary / 2)
        let left = 0
        let right = boundary
        const row = matrix[rowIndex]
    
        while (left < right) {
            if (target === row[i])
                return i
            else if (1 === (right - left)) {
                if (row[right] <= target)
                    return right
                return left
            }

            if (row[i] < target) {
                left = i
            }
            else if (target < row[i]) {
                right = i
            }
            i = Math.ceil((right - left)/2) + left
        }
        return i
    }

    const height = matrix.length
    if (0 === height) return false
    const width = matrix[0].length
    if (0 === width) return false

    let boundary = width - 1
    for (let i = 0; i < height; i++) {
        const row = matrix[i]
        boundary = findIndex(i, boundary, target)
        if (target === matrix[i][boundary]) 
            return true
    }
    return false
};