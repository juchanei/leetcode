/**
 * https://leetcode.com/problems/word-break/
 * @param {string} s
 * @param {string[]} wordDict
 * @return {boolean}
 */

const any = l => l.reduce((a, b) => a || b, false)

var wordBreak = function(s, wordDict) {
    const compare = (from, to, word) => {
        if (word.length !== to - from) return false;

        for (let i = 0; i < word.length; i++) {
            if (word[i] !== s[from + i])
                return false
        }
        return true
    }

    const memo = Array(s.length + 1).fill(-1)

    const testFrom = index => {
        if (s.length === index) return true

        const memoized = memo[index]
        if (-1 != memoized) return memoized

        const ret = any(wordDict.map(word => (
            compare(index, index + word.length, word)
                ? testFrom(index + word.length)
                : false
        )))

        memo[index] = ret
        return ret
    }

    return testFrom(0)
};