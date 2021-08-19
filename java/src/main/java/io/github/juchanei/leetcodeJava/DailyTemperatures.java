package io.github.juchanei.leetcodeJava;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class DailyTemperatures {
    private int[] temps;
    private int[] daysToWarmer;

    public int[] dailyTemperatures(int[] T) {
        temps = T;
        daysToWarmer = new int[T.length];
        Arrays.fill(daysToWarmer, -1);

        for (int i = T.length - 1; 0 <= i; i--)
            daysToWarmer[i] = Math.max(0, findDaysToWarmer(i, temps[i]));

        return daysToWarmer;
    }

    private int findDaysToWarmer(int day, int temperature) {
        if (temps.length <= day)
            return Integer.MIN_VALUE;

        if (temperature < temps[day])
            return 0;

        if (0 == daysToWarmer[day])
            return Integer.MIN_VALUE;

        if (0 < daysToWarmer[day])
            return findDaysToWarmer(day + daysToWarmer[day], temperature) + daysToWarmer[day];

        return findDaysToWarmer(day + 1, temperature) + 1;
    }

    public static class UnitTest {
        private DailyTemperatures dt = new DailyTemperatures();

        @Test
        public void example1() {
            int[] input = {73, 74, 75, 71, 69, 72, 76, 73};
            int[] expected = {1, 1, 4, 2, 1, 1, 0, 0};
            Assert.assertArrayEquals(expected, dt.dailyTemperatures(input));
        }

        @Test
        public void example2() {
            int[] input = {99, 30, 30, 30, 30, 100};
            int[] expected = {5, 4, 3, 2, 1, 0};
            Assert.assertArrayEquals(expected, dt.dailyTemperatures(input));
        }
    }
}
