package io.github.juchanei.leetcodeJava;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Created by juchanei on 2020/11/14.
// https://leetcode.com/problems/binary-tree-level-order-traversal/
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
        if (levelNodes.isEmpty()) return ret;

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

    @Nested
    class UnitTest {
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
                List.of(3),
                List.of(9, 20),
                List.of(15, 7)
            );
            assertEquals(expected, levelOrder(root));
        }

        @Test
        public void test2() {
            Stream.of(1, 2, 3, 4).forEach(System.out::println);
        }
    }
}
