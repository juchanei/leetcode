package io.github.juchanei.leetcodeKotlin

import org.assertj.core.api.BDDAssertions.then
import org.junit.jupiter.api.Test

// https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/628/
class BinaryTreeLevelOrderTraversal {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val acc = mutableListOf<Pair<Int, Int>>()
        levelOrder(root, 0, acc)
        return acc.groupBy({ it.first }, { it.second }).values.toList()
    }

    private fun levelOrder(root: TreeNode?, level: Int, acc: MutableList<Pair<Int, Int>>)  {
        if (root == null) return

        acc.add(level to root.`val`)

        levelOrder(root.left, level + 1, acc)
        levelOrder(root.right, level + 1, acc)
    }

    @Test
    fun example1() {
        // given
        val root = TreeNode(3)
        root.left = TreeNode(9)
        root.right = TreeNode(20)
        root.right?.left = TreeNode(15)
        root.right?.right = TreeNode(7)

        // when
        val levelOrder = levelOrder(root)

        // then
        then(levelOrder).isEqualTo(listOf(listOf(3), listOf(9, 20), listOf(15, 7)))
    }

    @Test
    fun example2() {
        // given
        val root = TreeNode(1)

        // when
        val levelOrder = levelOrder(root)

        // then
        then(levelOrder).isEqualTo(listOf(listOf(1)))
    }

    @Test
    fun example3() {
        // given
        val root = null

        // when
        val levelOrder = levelOrder(root)

        // then
        then(levelOrder).isEqualTo(emptyList<Int>())
    }
}
