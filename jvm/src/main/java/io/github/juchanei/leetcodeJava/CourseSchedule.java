package io.github.juchanei.leetcodeJava;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CourseSchedule {
    private int[][] prerequisites;
    private final HashMap<Integer, Boolean> memo = new HashMap<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        this.prerequisites = prerequisites;

        return IntStream.range(0, numCourses)
            .boxed()
            .allMatch(c -> canFinishRecursive(c, numCourses));
    }

    private boolean canFinishRecursive(int course, int left) {
        if (left == 0) return false;
        if (memo.containsKey(course)) return memo.get(course);

        boolean ret = Arrays.stream(prerequisites)
            .filter(pair -> pair[0] == course)
            .map(pair -> pair[1])
            .allMatch(c -> canFinishRecursive(c, left - 1));

        memo.put(course, ret);
        return ret;
    }

    @Nested
    class UnitTest {
        private final CourseSchedule sut = new CourseSchedule();

        @Test
        public void example1() {
            int nc = 2;
            int[][] pre = {{1, 0}};
            assertTrue(sut.canFinish(nc, pre));
        }

        @Test
        public void example2() {
            int nc = 2;
            int[][] pre = {{1, 0}, {0, 1}};
            assertFalse(sut.canFinish(nc, pre));
        }
    }
}
