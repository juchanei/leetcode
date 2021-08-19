package io.github.juchanei.leetcodeJava;

import org.junit.Assert;
import org.junit.Test;

public class GameOfLife {
    private int[][] board;

    public void gameOfLife(int[][] board) {
        this.board = board;

        int height = board.length;
        int width = board[0].length;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                boolean status = liveOrDead(j, i);
                board[i][j] |= (status ? 2 : 0);
            }
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                this.board[i][j] = 0 < (this.board[i][j] & 2) ? 1 : 0;
            }
        }
    }

    private boolean liveOrDead(int x, int y) {
        int neighborhood = 0;

        for (int i = y - 1; i <= y + 1; i++) {
            for (int j = x - 1; j <= x + 1; j++) {
                if (x == j && y == i) continue;
                if (i < 0 || board.length <= i) continue;
                if (j < 0 || board[i].length <= j) continue;

                neighborhood += board[i][j] & 1;
            }
        }

        if (0 < (this.board[y][x] & 1)) {
            if (neighborhood < 2) return false;
            if (3 < neighborhood) return false;
            return true;
        }
        else {
            if (neighborhood == 3) return true;
            return false;
        }
    }

    public static class UnitTest {
        private GameOfLife gl = new GameOfLife();

        @Test
        public void example1() {
            int[][] expected = {
                {0,0,0},
                {1,0,1},
                {0,1,1},
                {0,1,0},
            };
            int[][] actual = {
                {0,1,0},
                {0,0,1},
                {1,1,1},
                {0,0,0},
            };
            gl.gameOfLife(actual);
            Assert.assertArrayEquals(actual, expected);
        }

        @Test
        public void example2() {
            int[][] expected = {
                {1,1},
                {1,1},
            };
            int[][] actual = {
                {1,1},
                {1,0},
            };
            gl.gameOfLife(actual);
            Assert.assertArrayEquals(expected, actual);
        }

        @Test
        public void test1() {
            int[][] expected = {
                {1,1,1,0,1,1,1,1,1,1,0,0,1,1,1,1,1,1,0,0},
                {0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0},
                {0,0,0,1,0,1,0,1,0,0,0,0,0,0,1,0,1,0,1,0},
                {0,0,0,1,0,1,0,1,0,0,0,0,0,0,1,0,1,0,1,0},
                {0,0,0,1,1,0,1,0,1,0,0,0,0,1,0,1,0,1,1,0},
                {1,1,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0},
            };
            int[][] actual = {
                {1,1,0,1,0,1,0,1,0,1,1,1,1,0,1,0,1,0,1,0},
                {1,1,0,0,1,0,1,0,1,0,1,1,0,1,0,1,0,1,0,0},
                {1,1,0,1,0,1,0,1,0,1,1,1,1,0,1,0,1,0,1,0},
                {1,1,0,1,0,1,0,1,0,1,1,1,1,0,1,0,1,0,1,0},
                {1,1,0,0,1,0,1,0,1,0,1,1,0,1,0,1,0,1,0,0},
                {1,1,0,0,1,0,1,0,1,0,1,1,0,1,0,1,0,1,0,0},
            };
            gl.gameOfLife(actual);
            Assert.assertArrayEquals(expected, actual);
        }
    }
}
