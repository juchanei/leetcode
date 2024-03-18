package io.github.juchanei.leetcodeJava;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountAndSay {
    public String countAndSay(int n) {
        String string = "1";

        for (int i = 1; i < n; i++)
            string = countAndSay(string);

        return string;
    }

    private String countAndSay(String string) {
        if (string.isEmpty()) return "";

        StringBuilder result = new StringBuilder();
        char prev = string.charAt(0);
        int count = 0;

        for (char current : string.toCharArray()) {
            if (prev != current) {
                result.append(count).append(prev);
                prev = current;
                count = 0;
            }
            count++;
        }

        if (0 < count)
            result.append(count).append(prev);

        return result.toString();
    }

    @Nested
    class UnitTest {
        private final CountAndSay sut = new CountAndSay();

        @Test
        public void example1() {
            int input = 1;
            String output = "1";

            assertEquals(output, sut.countAndSay(input));
        }

        @Test
        public void example2() {
            int input = 4;
            String output = "1211";

            assertEquals(output, sut.countAndSay(input));
        }
    }
}
