package io.github.juchanei.leetcodeJava;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by juchanei on 2020/11/14.
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 */
public class BinaryTreeLevelOrderTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private static final List<List<Integer>> ret = new LinkedList<>();

    private static List<List<Integer>> recursive(TreeNode node, int levelOrder) {
        if (ret.size() <= levelOrder)
            ret.add(new LinkedList<>());

        ret.get(levelOrder).add(node.val);

        if (node.left != null) recursive(node.left, levelOrder + 1);
        if (node.right != null) recursive(node.right, levelOrder + 1);

        return ret;
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        return root == null ? ret : recursive(root, 0);
    }

    public static class UnitTest {
        @Test
        public void test1() {
            TreeNode root = new TreeNode(
                3,
                new TreeNode(9),
                new TreeNode(
                    20,
                    new TreeNode(15),
                    new TreeNode(7)
                )
            );

            List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(3),
                Arrays.asList(9, 20),
                Arrays.asList(15, 7)
            );
            Assert.assertEquals(expected, levelOrder(root));
        }
    }
}