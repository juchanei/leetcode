/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number[]}
 */

const zip = (l1, l2) => l1.map((e, i) => [e, l2[i]])
const zipWith = (l1, l2, fn) => zip(l1, l2).map(([a, b]) => fn(a, b))
const toArray = obj => zipWith(Object.keys(obj), Object.values(obj), (key, value) => ({ key, value }))

const reducer = (counts, num) => {
	counts[num] = counts[num] ? counts[num] + 1 : 1
	return counts
}

const getCounts = nums => nums.reduce(reducer, {})

var topKFrequent = function(nums, k) {
	return toArray(getCounts(nums))
		.sort((a, b) => b.value - a.value)
		.slice(0, k)
		.map(e => parseInt(e.key))
};

const ret = topKFrequent([1,1,1,2,2,3], 2)

console.log(ret)