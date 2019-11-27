/**
 * https://leetcode.com/problems/minimum-cost-for-tickets/
 * @param {number[]} days
 * @param {number[]} costs
 * @return {number}
 */
const min = (a, b) => a < b ? a : b

const ticketDays = i => {
    switch (i) {
        case 0: return 1
        case 1: return 7
        case 2: return 30
        default:
            throw new Error('bad ticket')
    }
}

const findIndexUntil = (cond, list, init = 0) => {
    for (let i = init; i < list.length; i++) {
        if (cond(list[i])) return i
    }
    return list.length
}

var mincostTickets = function(days, costs) {

    const memo = Array(days.length).fill(null)
    const find = dayIndex => {
        if (days.length === dayIndex) return 0

        const memoized = memo[dayIndex]
        if (null !== memoized) return memoized

        const day = days[dayIndex]
        let minCost = Number.MAX_SAFE_INTEGER
        for (let i = 0; i < 3; i++) {
            const cost = costs[i]
            const limit = day + ticketDays(i) - 1
            const nextDayIndex = findIndexUntil(day => limit < day, days, dayIndex)
            minCost = min(find(nextDayIndex) + cost, minCost)
        }

        memo[dayIndex] = minCost
        return minCost
    }

    return find(0, 0)
};