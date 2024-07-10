package io.github.juchanei.leetcodeKotlin

import org.assertj.core.api.BDDAssertions.then
import org.junit.jupiter.api.Test

// https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/627/
class SymmetricTree {
    fun isSymmetric(root: TreeNode?): Boolean =
        when (root) {
            null -> true
            else -> isSymmetric(root.left, root.right)
        }

    private fun isSymmetric(leftSub: TreeNode?, rightSub: TreeNode?): Boolean =
        when {
            leftSub == null && rightSub == null -> true
            leftSub == null || rightSub == null -> false
            leftSub.`val` != rightSub.`val` -> false
            else -> isSymmetric(leftSub.left, rightSub.right) && isSymmetric(leftSub.right, rightSub.left)
        }

    @Test
    fun example1() {
        // given
        val root = TreeNode(1)
        root.left = TreeNode(2)
        root.right = TreeNode(2)
        root.left?.left = TreeNode(3)
        root.left?.right = TreeNode(4)
        root.right?.left = TreeNode(4)
        root.right?.right = TreeNode(3)

        // when
        val isSymmetric = isSymmetric(root)

        // then
        then(isSymmetric).isTrue
    }

    @Test
    fun example2() {
        // given
        val root = TreeNode(1)
        root.left = TreeNode(2)
        root.right = TreeNode(2)
        root.left?.right = TreeNode(3)
        root.right?.right = TreeNode(3)

        // when
        val isSymmetric = isSymmetric(root)

        // then
        then(isSymmetric).isFalse
    }
}
