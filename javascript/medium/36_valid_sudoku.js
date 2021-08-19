/**
 * https://leetcode.com/problems/valid-sudoku/
 * @param {character[][]} board
 * @return {boolean}
 */
const checkRepeatition = l => {
    const map = Array(10).fill(false)
    for (const e of l.filter(c => c !== '.').map(c => parseInt(c))) {
        if (map[e]) return false
        map[e] = true
    }
    return true
}

var isValidSudoku = function(board) {
    const checkRows = () => {
        for (const numbers of board) {
            if (!checkRepeatition(numbers))
                return false
        }
        return true
    }

    const checkColumns = () => {
        for (let i = 0; i < 9; i++) {
            const numbers = board.map(row => row[i])
            if (!checkRepeatition(numbers))
                return false
        }
        return true
    }

    const checkBlocks = () => {
        for (let i = 0; i < 3; i++) {
            for (let j = 0; j < 3; j++) {
                const numbers = [
                    ...board[i * 3 + 0].slice(j * 3, j * 3 + 3),
                    ...board[i * 3 + 1].slice(j * 3, j * 3 + 3),
                    ...board[i * 3 + 2].slice(j * 3, j * 3 + 3),
                ]
                if (!checkRepeatition(numbers))
                    return false
            }
        }
        return true
    }

    if (!checkRows()) return false
    if (!checkColumns()) return false
    if (!checkBlocks()) return false
    return true
};
