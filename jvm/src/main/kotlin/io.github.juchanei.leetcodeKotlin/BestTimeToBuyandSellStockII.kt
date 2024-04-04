package io.github.juchanei.leetcodeKotlin

import org.assertj.core.api.BDDAssertions.then
import org.junit.jupiter.api.Test
import java.lang.Integer.max

// https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/564/
class BestTimeToBuyAndSellStockII {
    fun maxProfit(prices: IntArray): Int {
        val memo = mutableMapOf<Pair<Int, Int?>, Int>()

        fun search(day: Int, buyPrice: Int? = null): Int {
            val cache = memo[day to buyPrice]
            if (cache != null) return cache

            return when {
                // 기간이 끝났을 때 팔지 못한 주식이 있다면 손해로 책정한다
                prices.size == day -> {
                    if (buyPrice == null) {
                        0
                    } else {
                        -buyPrice
                    }
                }
                // 가지고 있는 주식이 없는 경우 오늘 사거나 사지 않는다
                buyPrice == null -> {
                    max(
                        search(day + 1, prices[day]), // buy
                        search(day + 1) // skip
                    )
                }
                // 가지고 있는 주식의 가격이 오른 상태면 오늘 팔거나 팔지 않는다
                buyPrice < prices[day] -> {
                    max(
                        search(day + 1) + prices[day] - buyPrice, // sell
                        search(day + 1, buyPrice), // skip
                    )
                }
                // 가지고 있는 주식의 가격이 변동이 없거나 떨어져있으면
                // 오를때 까지 기다렸다가 팔거나 팔지 않는다
                else -> {
                    val nextDay = (day + 1 until prices.size)
                        .find { prices[day] < prices[it] }
                        ?: prices.size

                    max(
                        search(nextDay) + prices[day] - buyPrice, // sell
                        search(nextDay, buyPrice), // skip
                    )
                }
            }.also {
                memo[day to buyPrice] = it
            }
        }

        return search(0)
    }

    @Test
    fun example1() {
        // given
        val prices = intArrayOf(7, 1, 5, 3, 6, 4)

        // when
        val ret = maxProfit(prices)

        // then
        then(ret).isEqualTo(7)
    }

    @Test
    fun example2() {
        // given
        val prices = intArrayOf(1, 2, 3, 4, 5)

        // when
        val ret = maxProfit(prices)

        // then
        then(ret).isEqualTo(4)
    }

    @Test
    fun example3() {
        // given
        val prices = intArrayOf(7, 6, 4, 3, 1)

        // when
        val ret = maxProfit(prices)

        // then
        then(ret).isEqualTo(0)
    }
}
