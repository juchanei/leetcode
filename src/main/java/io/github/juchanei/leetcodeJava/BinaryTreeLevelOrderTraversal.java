package io.github.juchanei.leetcodeJava;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    private static List<List<Integer>> recursive(List<TreeNode> levelNodes) {
        if (levelNodes.size() == 0) return ret;

        List<Integer> levelValues = levelNodes.stream()
            .map(node -> node.val)
            .collect(Collectors.toList());

        ret.add(levelValues);

        List<TreeNode> nextLevelNodes = levelNodes.stream()
            .flatMap(node -> Stream.of(node.left, node.right))
            .filter(Objects::nonNull)
            .collect(Collectors.toList());

        return recursive(nextLevelNodes);
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        return root == null ? ret : recursive(Collections.singletonList(root));
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

        @Test
        public void test2() {
            Stream.of(1, 2, 3, 4).forEach(System.out::println);
        }
    }
}