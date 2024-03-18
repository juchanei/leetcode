package io.github.juchanei.leetcodeJava;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        if (s.isEmpty()) {
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
                .forEach(ret::add);
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


    @Nested
    class UnitTest {
        private final PalindromePartitioning sut = new PalindromePartitioning();

        @Test
        public void example1() {
            String input = "aab";
            List<List<String>> output = Arrays.asList(
                Arrays.asList("a","a","b"),
                Arrays.asList("aa","b")
            );

            assertArrayEquals(
                output.toArray(),
                sut.partition(input).toArray()
            );
        }

        @Test
        public void example2() {
            String input = "a";
            List<List<String>> output = List.of(
                List.of("a")
            );

            assertArrayEquals(
                output.toArray(),
                sut.partition(input).toArray()
            );
        }

        @Test
        public void palindromeTest() {
            assertTrue(sut.isPalindrome("heleh"));
            assertTrue(sut.isPalindrome("h"));
            assertTrue(sut.isPalindrome("hh"));
            assertFalse(sut.isPalindrome("ddheleh"));
            assertFalse(sut.isPalindrome(""));
        }

        @Test
        public void test1() {
            String input = "bb";
            List<List<String>> output = List.of(
                List.of("b", "b"),
                List.of("bb")
            );

            assertArrayEquals(
                output.toArray(),
                sut.partition(input).toArray()
            );
        }
    }
}
