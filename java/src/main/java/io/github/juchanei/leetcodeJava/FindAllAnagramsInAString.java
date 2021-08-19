package io.github.juchanei.leetcodeJava;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FindAllAnagramsInAString {
    public static List<Integer> findAnagrams(String s, String p) {
        if (s.length() == 0) return Collections.EMPTY_LIST;
        if (s.length() < p.length()) return Collections.EMPTY_LIST;

        List<Boolean> results = IntStream.range(0, s.length() - p.length() + 1)
            .boxed()
            .map(createAnagramChecker(s, p))
            .collect(Collectors.toList());

        return IntStream.range(0, results.size())
            .boxed()
            .filter(results::get)
            .collect(Collectors.toList());
    }

    private static Function<Integer, Boolean> createAnagramChecker(String s, String p) {
        Map<Integer, Boolean> memo = new HashMap<>();

        Map<String, Integer> mapP = countAlphabets(p);

        return new Function<Integer, Boolean>() {
            private Boolean memoAndGet(int index, boolean res) {
                memo.put(index, res);
                return res;
            }

            @Override
            public Boolean apply(Integer fromIndex) {
                Boolean ret = memo.get(fromIndex);
                if (ret != null) return ret;

                int toIndex = fromIndex + p.length();
                if (0 < fromIndex && s.charAt(fromIndex - 1) == s.charAt(toIndex - 1))
                    return memoAndGet(fromIndex, apply(fromIndex - 1));

                String sub = s.substring(fromIndex, toIndex);
                return memoAndGet(fromIndex, mapP.equals(countAlphabets(sub)));
            }
        };
    }

    private static Map<String, Integer> countAlphabets(String str) {
        Map<String, Integer> map = new HashMap<>();
        Stream.of(str.split(""))
            .forEach(key -> map.put(key, map.getOrDefault(key, 0) + 1));
        return map;
    }

    public static class UnitTest {
        @Test
        public void empty() {
            List<Integer> expected = Arrays.asList();
            List<Integer> actual = findAnagrams("", "abc");

            Assert.assertTrue(expected.equals(actual));
        }

        @Test
        public void givenTestCase() {
            List<Integer> expected = Arrays.asList(0, 6);
            List<Integer> actual = findAnagrams("cbaebabacd", "abc");

            Assert.assertTrue(expected.equals(actual));
        }

        @Test
        public void test1() {
            List<Integer> expected = Arrays.asList(0, 2, 3, 4, 8);
            List<Integer> actual = findAnagrams("ababaabbabab", "aab");

            Assert.assertTrue(expected.equals(actual));
        }

        @Test
        public void test2() {
            List<Integer> expected = Arrays.asList(0, 1, 2, 3, 4);
            List<Integer> actual = findAnagrams("aaaaaaa", "aaa");

            Assert.assertTrue(expected.equals(actual));
        }
    }
}
