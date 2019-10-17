/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * 
 * @param {string} digits
 * @return {string[]}
 */

const toAlphabets = digit => ({
    '2': ['a', 'b', 'c'],
    '3': ['d', 'e', 'f'],
    '4': ['g', 'h', 'i'],
    '5': ['j', 'k', 'l'],
    '6': ['m', 'n', 'o'],
    '7': ['p', 'q', 'r', 's'],
    '8': ['t', 'u', 'v'],
    '9': ['w', 'x', 'y', 'z'],
}[digit])

const toNumbers = str => {
    const result = []
    for (let i = 0; i < str.length; i++)
        result.push(str[i])
    return result
}

var letterCombinations = function(digits) {
    const _letterCombinations = letters => {
        const result = []
        const selected = new Array(letters.length)
    
        const recursive = index => {
            if (index == letters.length) {
                result.push(selected.join(''))
                return
            }

            const candidates = letters[index]
    
            for (let i = 0; i < candidates.length; i++) {
                selected[index] = candidates[i]
                recursive(index + 1)
            }
        }
        recursive(0)
        return result
    }

    if (0 === digits.length) return []

    return _letterCombinations(toNumbers(digits).map(toAlphabets))
};