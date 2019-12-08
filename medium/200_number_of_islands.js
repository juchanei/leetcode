/**
 * https://leetcode.com/problems/number-of-islands/
 * @param {character[][]} grid
 * @return {number}
 */
var numIslands = function(grid) {
    const height = grid.length
    if (height === 0) return 0
    const width = grid[0].length
    if (width === 0) return 0

    const visited = Array(height).fill().map(_ => Array(width).fill(0))


    const search = (x, y, count) => {
        if (x < 0 || width <= x) return false
        if (y < 0 || height <= y) return false
        if (grid[y][x] === "0") return false
        if (visited[y][x] !== 0) return false

        visited[y][x] = count

        search(x - 1, y, count)
        search(x + 1, y, count)
        search(x, y - 1, count)
        search(x, y + 1, count)
        return true
    }

    let count = 1
    for (let x = 0; x < width; x++) {
        for (let y = 0; y < height; y++) {
            if (search(x, y, count)) count++
        }
    }

    return count - 1
};
