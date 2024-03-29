package io.github.juchanei.leetcodeJava;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IncreasingTripletSubsequence {
    private int[] nums;

// best solution
//    public boolean increasingTriplet(int[] nums) {
//        int first=Integer.MAX_VALUE;
//        int second=Integer.MAX_VALUE;
//        for(int num :nums){
//            if(num<=first)
//                first=num;
//            else if(num<=second)
//                second=num;
//            else
//                return true;
//        }
//        return false;
//    }

    public boolean increasingTriplet(int[] nums) {
        this.nums = nums;

        return find(0, Integer.MIN_VALUE, 0);
    }

    private boolean find(int index, int prev, int nIncSub) {
        if (3 <= nIncSub) return true;
        if (index == nums.length) return false;

        if (prev < nums[index])
            if (find(index + 1, nums[index], nIncSub + 1))
                return true;

        return find(index + 1, prev, nIncSub);
    }

    @Nested
    class UnitTest {
        private final IncreasingTripletSubsequence sut = new IncreasingTripletSubsequence();

        @Test
        public void example1() {
            int[] input = { 1,2,3,4,5 };
            boolean output = true;

            assertEquals(output, sut.increasingTriplet(input));
        }

        @Test
        public void example2() {
            int[] input = { 5,4,3,2,1 };
            boolean output = false;

            assertEquals(output, sut.increasingTriplet(input));
        }

        @Test
        public void example3() {
            int[] input = { 2,1,5,0,4,6 };
            boolean output = true;

            assertEquals(output, sut.increasingTriplet(input));
        }

        @Test
        public void test1() {
            int[] input = { 20,100,10,12,5,13 };
            boolean output = true;

            assertEquals(output, sut.increasingTriplet(input));
        }

        @Test
        public void test2() {
            int[] input = { 1,5,0,4,1,3 };
            boolean output = true;

            assertEquals(output, sut.increasingTriplet(input));
        }
    }
}
