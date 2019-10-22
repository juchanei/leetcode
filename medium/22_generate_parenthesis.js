/**
 * https://leetcode.com/problems/generate-parentheses/submissions/
 * @param {number} n
 * @return {string[]}
 */

var generateParenthesis = function(n) {
    const _generateParenthesis = (i, nOpened, nClosed) => {
        if (n*2 === i) return ['']
    
        const a = nOpened < n
            ? _generateParenthesis(i + 1, nOpened + 1, nClosed).map(str => `(${str}`)
            : []
    
        const b = nClosed < nOpened
            ? _generateParenthesis(i + 1, nOpened, nClosed + 1).map(str => `)${str}`)
            : []
    
        return [...a, ...b]
    }

    return _generateParenthesis(0, 0, 0)
};