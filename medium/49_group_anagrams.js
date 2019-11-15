/**
 * https://leetcode.com/problems/group-anagrams/
 * @param {string[]} strs
 * @return {string[][]}
 */
const strToArray = str => {
    return Array(str.length).fill().map((_, i) => str[i])
}

const groupBy = (objs, fn) => {
    const dict = objs.reduce((acc, cur) => {
        const value = acc[fn(cur)]
        acc[fn(cur)] = value ? [...value, cur] : [cur]
        return acc
    }, {})

    return Object.keys(dict).map(key => dict[key])
}

const createId = str => strToArray(str).sort().join('')

var groupAnagrams = function (strs) {
    const pairs = strs.map(str => ({ id: createId(str), str }))

    return groupBy(pairs, ({ id }) => id)
        .map(values => values.map(({ str }) => str))
};