package io.github.juchanei.leetcodeJava;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindAllAnagramsInAString {
    public static List<Integer> findAnagrams(String s, String p) {
        if (s.isEmpty()) return List.of();
        if (s.length() < p.length()) return List.of();

        List<Boolean> results = IntStream.range(0, s.length() - p.length() + 1)
            .boxed()
            .map(createAnagramChecker(s, p))
            .toList();

        return IntStream.range(0, results.size())
            .boxed()
            .filter(results::get)
            .collect(Collectors.toList());
    }

    private static Function<Integer, Boolean> createAnagramChecker(String s, String p) {
        Map<Integer, Boolean> memo = new HashMap<>();

        Map<String, Integer> mapP = countAlphabets(p);

        return new Function<>() {
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

    @Nested
    class UnitTest {
        @Test
        public void empty() {
            List<Integer> expected = List.of();
            List<Integer> actual = findAnagrams("", "abc");

            assertEquals(expected, actual);
        }

        @Test
        public void givenTestCase() {
            List<Integer> expected = Arrays.asList(0, 6);
            List<Integer> actual = findAnagrams("cbaebabacd", "abc");

            assertEquals(expected, actual);
        }

        @Test
        public void test1() {
            List<Integer> expected = Arrays.asList(0, 2, 3, 4, 8);
            List<Integer> actual = findAnagrams("ababaabbabab", "aab");

            assertEquals(expected, actual);
        }

        @Test
        public void test2() {
            List<Integer> expected = Arrays.asList(0, 1, 2, 3, 4);
            List<Integer> actual = findAnagrams("aaaaaaa", "aaa");

            assertEquals(expected, actual);
        }
    }
}
