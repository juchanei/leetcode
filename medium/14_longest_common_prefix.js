/**
 * https://leetcode.com/problems/longest-common-prefix/
 * @param {string[]} strs
 * @return {string}
 */

const min = (a, b) => a < b ? a : b
const strToArray = str => Array(str.length).fill().map((_, i) => str[i])

const zip = ll => {
    const size = ll.map(l => l.length).reduce(min, Number.MAX_SAFE_INTEGER)
    return Array(size).fill().map((_, i) => ll.map(l => l[i]))
}

const every = l => {
    const first = l[0]
    return l.map(e => first === e).reduce((a, b) => a && b, true)
}

const takeWhile = (l, pred) => {
    const ret = []
    for (let i = 0; i < l.length; i++) {
        if (!pred(l[i])) break
        ret.push(l[i])
    }
    return ret
}

const identity = e => e

var longestCommonPrefix = function(strs) {
    if (0 === strs.length) return ''

    const first = strs[0]
    const test = zip(strs.map(strToArray)).map(every)
    const takeCount = takeWhile(test, identity).length
    return first.slice(0, takeCount)
};