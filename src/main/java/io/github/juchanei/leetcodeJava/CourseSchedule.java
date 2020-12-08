package io.github.juchanei.leetcodeJava;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.IntStream;

public class CourseSchedule {
    private int[][] prerequisites;
    private HashMap<Integer, Boolean> memo = new HashMap<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        this.prerequisites = prerequisites;

        return IntStream.range(0, numCourses)
            .boxed()
            .map(c -> canFinishRecursive(c, numCourses))
            .noneMatch(b -> !b);
    }

    private boolean canFinishRecursive(int course, int left) {
        if (left == 0) return false;
        if (memo.containsKey(course)) return memo.get(course);

        boolean ret = Arrays.asList(prerequisites)
            .stream()
            .filter(pair -> pair[0] == course)
            .map(pair -> pair[1])
            .map(c -> canFinishRecursive(c, left - 1))
            .noneMatch(b -> !b);

        memo.put(course, ret);
        return ret;
    }

    public static class UnitTest {
        private CourseSchedule cs = new CourseSchedule();

        @Test
        public void example1() {
            int nc = 2;
            int[][] pre = {{1, 0}};
            Assert.assertEquals(cs.canFinish(nc, pre), true);
        }

        @Test
        public void example2() {
            int nc = 2;
            int[][] pre = {{1, 0}, {0, 1}};
            Assert.assertEquals(cs.canFinish(nc, pre), false);
        }
    }
}
