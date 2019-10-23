/**
 * https://leetcode.com/problems/valid-parentheses/
 * @param {string} s
 * @return {boolean}
 */

const isOpen = c => {
    if (c === '(') return true
    if (c === '[') return true
    if (c === '{') return true

    return false
}

const isPair = (a, b) => {
    if (a === '(' && b ===')') return true
    if (b === '(' && a ===')') return true
    if (a === '[' && b ===']') return true
    if (b === '[' && a ===']') return true
    if (a === '{' && b ==='}') return true
    if (b === '{' && a ==='}') return true

    return false
}

var isValid = function(s) {
    const stack = []

    for (char of Array.from(s)) {
        if (isOpen(char)) {
            stack.push(char)
            continue
        }

        const lastChar = stack[stack.length-1]
        if (!isPair(lastChar, char)) return false
        stack.pop()
    }

    return stack.length ? false : true
};