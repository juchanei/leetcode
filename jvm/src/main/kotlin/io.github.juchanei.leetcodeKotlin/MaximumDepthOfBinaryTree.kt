package io.github.juchanei.leetcodeKotlin

import org.assertj.core.api.BDDAssertions.then
import org.junit.jupiter.api.Test
import kotlin.math.max

// https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/555/
class MaximumDepthOfBinaryTree {
    fun maxDepth(root: TreeNode?): Int =
        when (root) {
            null -> 0
            else -> 1 + max(maxDepth(root.left), maxDepth(root.right))
        }

    @Test
    fun test() {
        // given
        val root = TreeNode(3)
        root.left = TreeNode(9)
        root.right = TreeNode(20)
        root.right?.left = TreeNode(15)
        root.right?.right = TreeNode(7)

        // when
        val maxDepth = maxDepth(root)

        // then
        then(maxDepth).isEqualTo(3)
    }
}
