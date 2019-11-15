/**
 * https://leetcode.com/problems/group-anagrams/
 * @param {string[]} strs
 * @return {string[][]}
 */
const _ = list => {
    const l = [...list]

    return {
        map: fn => _(l.map(fn)),
        groupBy: fn => {
            const dict = l.reduce((acc, cur) => {
                const value = acc[fn(cur)]
                acc[fn(cur)] = value ? [...value, cur] : [cur]
                return acc
            }, {})
        
            const ret = Object.keys(dict).map(key => dict[key])
            return _(ret)
        },
        value: () => l
    }
}

const strToArray = str => Array(str.length).fill().map((_, i) => str[i])
const createId = str => strToArray(str).sort().join('')

var groupAnagrams = function (strs) {
    return _(strs)
        .map(str => ({ id: createId(str), str }))
        .groupBy(({ id }) => id)
        .map(values => values.map(({ str }) => str))
        .value()
};