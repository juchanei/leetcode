/**
 * https://leetcode.com/problems/word-break/
 * @param {string} s
 * @param {string[]} wordDict
 * @return {boolean}
 */
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

    const testFrom = (index) => {
        if (s.length === index) return true;
        if (s.length < index) return false

        const memoized = memo[index]
        if (-1 != memoized) return memoized

        let ret = false
        for (let i = 0; i < wordDict.length; i++) {
            const word = wordDict[i]
            const size = word.length

            if (compare(index, index + size, word))
                ret = ret || testFrom(index + size)
        }

        memo[index] = ret
        return ret
    }

    return testFrom(0)
};