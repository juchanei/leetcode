/**
 * https://leetcode.com/problems/gas-station/
 * @param {number[]} gas
 * @param {number[]} cost
 * @return {number}
 */
var canCompleteCircuit = function(gas, cost) {

    const find = (target, current, gasLeft) => {
        const currentGas = gasLeft + gas[current]
        if (currentGas < cost[current]) return false

        const next = (current + 1) % gas.length
        if (next === target) return true

        return find(target, next, currentGas - cost[current])
    }

    for (let i = 0; i < gas.length; i++)
        if (find(i, i, 0))
            return i

    return -1
};