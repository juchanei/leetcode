package io.github.juchanei.leetcodeJava;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        if (s.length() == 0) {
            return List.of(List.of());
        }

        List<List<String>> ret = new ArrayList<>();
        for (int i = 0; i <= s.length(); i++) {
            String candidate = s.substring(0, i);

            if (!isPalindrome(candidate)) continue;

            partition(s.substring(i))
                .stream()
                .map(strings -> Stream
                    .concat(Stream.of(candidate), strings.stream())
                    .collect(Collectors.toList()))
                .forEach(strings -> ret.add(strings));
        }

        return ret;
    }

    public boolean isPalindrome(String candidate) {
        int length = candidate.length();
        if (length == 0) return false;
        if (length == 1) return true;

        for (int i = 0; i < (length / 2); i++)
            if (candidate.charAt(i) != candidate.charAt(length - 1 - i))
                return false;

        return true;
    }


    public static class UnitTest {
        private PalindromePartitioning pp = new PalindromePartitioning();

        @Test
        public void example1() {
            String input = "aab";
            List<List<String>> output = Arrays.asList(
                Arrays.asList("a","a","b"),
                Arrays.asList("aa","b")
            );

            Assert.assertArrayEquals(
                output.toArray(),
                pp.partition(input).toArray()
            );
        }

        @Test
        public void example2() {
            String input = "a";
            List<List<String>> output = Arrays.asList(
                Arrays.asList("a")
            );

            Assert.assertArrayEquals(
                output.toArray(),
                pp.partition(input).toArray()
            );
        }

        @Test
        public void palindromeTest() {
            Assert.assertEquals(true, pp.isPalindrome("heleh"));
            Assert.assertEquals(true, pp.isPalindrome("h"));
            Assert.assertEquals(true, pp.isPalindrome("hh"));
            Assert.assertEquals(false, pp.isPalindrome("ddheleh"));
            Assert.assertEquals(false, pp.isPalindrome(""));
        }

        @Test
        public void test1() {
            String input = "bb";
            List<List<String>> output = Arrays.asList(
                Arrays.asList("b", "b"),
                Arrays.asList("bb")
            );

            Assert.assertArrayEquals(
                output.toArray(),
                pp.partition(input).toArray()
            );
        }
    }
}
