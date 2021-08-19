/**
 * @param {number[]} A
 * @return {number}
 */

var numberOfArithmeticSlices = function(A) {
    const isArithmetic = (start, end) => {
        const between1 = A[start + 1] - A[start]
        for (let i = start + 2; i < end; i++) {
            const between2 = A[i] - A[i - 1]
            if (between1 !== between2) return false
        }
        return true
    }

    const size = A.length

    const find = (start, end) => {
        if (end - start < 3) return 0
        if (end - start === 3) {
            return isArithmetic(start, end) ? 1 : 0
        }

        let acc = find(start + 1, end)
        acc += find(start, start + 3)
        for (let i = start + 4; i <= end; i++) {
            if (isArithmetic(start + 1, i)) {
                if (isArithmetic(start, start + 3)) {
                    acc++
                }
            }
        }

        return acc
    }

    return find(0, size)
};
