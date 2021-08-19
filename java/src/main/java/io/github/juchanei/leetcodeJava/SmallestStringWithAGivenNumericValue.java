package io.github.juchanei.leetcodeJava;

import org.junit.Assert;
import org.junit.Test;

public class SmallestStringWithAGivenNumericValue {

    private static String find(int n, int k, int nA) {
        if (nA < 0) return null;

        int middleValue = (k - nA) % 26;
        int nZ = n - nA - (middleValue == 0 ? 0 : 1);
        String middleLetter = middleValue == 0 ? "" : String.valueOf((char)(middleValue + 'a' - 1));

        if (nA + middleValue + 26 * nZ == k)
            return "a".repeat(nA) + middleLetter + "z".repeat(nZ);

        return find(n, k, nA - 1);
    }

    public static String getSmallestString(int n, int k) {
        return find(n, k, n);
    }

    public static class UnitTest {
        @Test
        public void givenTest1() {
            String actual = SmallestStringWithAGivenNumericValue.getSmallestString(3, 27);
            Assert.assertEquals("aay", actual);
        }

        @Test
        public void givenTest2() {
            String actual = SmallestStringWithAGivenNumericValue.getSmallestString(5, 73);
            Assert.assertEquals("aaszz", actual);
        }

        @Test
        public void startWithoutA() {
            String actual = SmallestStringWithAGivenNumericValue.getSmallestString(1, 2);
            Assert.assertEquals("b", actual);
        }

        @Test
        public void edge1() {
            String actual = SmallestStringWithAGivenNumericValue.getSmallestString(100000, 100000);
            Assert.assertEquals("a".repeat(100000), actual);
        }

        @Test
        public void edge2() {
            String actual = SmallestStringWithAGivenNumericValue.getSmallestString(100000, 2600000);
            Assert.assertEquals("z".repeat(100000), actual);
        }

        @Test
        public void test1() {
            String actual = SmallestStringWithAGivenNumericValue.getSmallestString(93520, 92185);
            Assert.assertEquals("z".repeat(10000), actual);
        }
    }
}
