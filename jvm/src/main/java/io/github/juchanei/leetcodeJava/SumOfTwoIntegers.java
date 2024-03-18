package io.github.juchanei.leetcodeJava;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumOfTwoIntegers {
    public int getSum(int a, int b) {
        int acc = 0;
        int carry = 0;
        for (int mask = 1; mask != 0; mask = mask << 1) {
            int op1 = a & mask;
            int op2 = b & mask;

            if (0 < (op1 & op2)) {
                acc |= carry;
                carry = (op1 & op2) << 1;
                continue;
            }

            op1 = op1 ^ op2;
            int temp = op1 & carry;
            if (0 < temp) {
                carry = temp << 1;
                continue;
            }

            acc |= op1 ^ carry;
        }
        return acc;
    }

    @Nested
    class UnitTest {
        private final SumOfTwoIntegers sut = new SumOfTwoIntegers();

        @Test
        public void example1() {
            int a = 1;
            int b = 2;
            int c = 3;
            assertEquals(c, sut.getSum(a, b));
        }

        @Test
        public void example2() {
            int a = 2;
            int b = 3;
            int c = 5;
            assertEquals(c, sut.getSum(a, b));
        }

        @Test
        public void test1() {
            int a = -12;
            int b = 3;
            int c = -9;
            assertEquals(c, sut.getSum(a, b));
        }

        @Test
        public void test2() {
            int a = 20;
            int b = 30;
            int c = 50;
            assertEquals(c, sut.getSum(a, b));
        }
    }
}
