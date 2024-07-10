package io.github.juchanei.leetcodeKotlin

import org.assertj.core.api.BDDAssertions.then
import org.junit.jupiter.api.Test

// https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/625/
class ValidateBinarySearchTree {
    fun isValidBST(root: TreeNode?): Boolean =
        isValidBST(root, null, null)

    private fun isValidBST(root: TreeNode?, min: Int?, max: Int?): Boolean =
        when {
            root == null -> true
            min != null && root.`val` <= min -> false
            max != null && root.`val` >= max -> false
            else -> isValidBST(root.left, min, root.`val`) && isValidBST(root.right, root.`val`, max)
        }

    @Test
    fun example1() {
        // given
        val root = TreeNode(2)
        root.left = TreeNode(1)
        root.right = TreeNode(3)

        // when
        val isValid = isValidBST(root)

        // then
        then(isValid).isTrue
    }

    @Test
    fun example2() {
        // given
        val root = TreeNode(5)
        root.left = TreeNode(1)
        root.right = TreeNode(4)
        root.right?.left = TreeNode(3)
        root.right?.right = TreeNode(6)

        // when
        val isValid = isValidBST(root)

        // then
        then(isValid).isFalse
    }

    @Test
    fun example3() {
        // given
        val root = TreeNode(5)
        root.left = TreeNode(4)
        root.right = TreeNode(6)
        root.right?.left = TreeNode(3)
        root.right?.right = TreeNode(7)

        // when
        val isValid = isValidBST(root)

        // then
        then(isValid).isFalse
    }

    @Test
    fun example4() {
        // given
        val root = TreeNode(120)
        root.left = TreeNode(70)
        root.right = TreeNode(140)
        root.left?.left = TreeNode(50)
        root.left?.right = TreeNode(100)
        root.right?.left = TreeNode(130)
        root.right?.right = TreeNode(160)
        root.left?.left?.left = TreeNode(20)
        root.left?.left?.right = TreeNode(55)
        root.left?.right?.left = TreeNode(75)
        root.left?.right?.right = TreeNode(110)
        root.left?.right?.right?.left = TreeNode(119)
        root.right?.left?.left = TreeNode(135)
        root.right?.left?.right = TreeNode(150)
        root.right?.right?.right = TreeNode(200)

        // when
        val isValid = isValidBST(root)

        // then
        then(isValid).isFalse
    }

    @Test
    fun example5() {
        // given
        val root = TreeNode(Int.MIN_VALUE)
        root.right = TreeNode(Int.MAX_VALUE)

        // when
        val isValid = isValidBST(root)

        // then
        then(isValid).isTrue
    }
}
