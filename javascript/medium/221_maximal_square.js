/**
 * https://leetcode.com/problems/maximal-square/
 * @param {character[][]} matrix
 * @return {number}
 */

const checkAllZero = matrix => {
    const height = matrix.length
    const width = matrix[0].length

    for (let i = 0; i < height; i++)
        for (let j = 0; j < width; j++)
            if (matrix[i][j] === '1')
                return false
    return true
}

const check = (matrix, x, y, size) => {
    const height = matrix.length
    const width = matrix[0].length

    if (width < x + size) return false
    if (height < y + size) return false

    for (let nextX = x; nextX < x + size; nextX++) {
        for (let nextY = y; nextY < y + size; nextY++) {
            if (matrix[nextY][nextX] === "0") return false
            if (matrix[nextY][nextX] === false) return false
        }
    }
    return true
}

const updateMap = matrix => {
    const height = matrix.length
    const width = matrix[0].length

    const map = Array(height - 1).fill().map(_ => Array(width - 1).fill(0))
    
    let exits = false
    for (let i = 0; i < height - 1; i++) {
        for (let j = 0; j < width -1; j++) {
            map[i][j] = check(matrix, j, i, 2)
            exits |= map[i][j]
        }
    }
    return exits ? map : null
}

var maximalSquare = function(matrix) {
    const height = matrix.length
    if (!height) return 0
    const width = matrix[0].length
    if (!width) return 0
    if (checkAllZero(matrix)) return 0

    let map = updateMap(matrix)
    if (!map) return 1

    let count = 1
    while (map) {
        map = updateMap(map)
        count++
    }

    return count**2
};