// HW1 2-d array Problems
// CharGrid encapsulates a 2-d grid of chars and supports
// a few operations on the grid.

public class CharGrid {
    private char[][] grid;
    /**
     * Constructs a new CharGrid with the given grid.
     * Does not make a copy.
     * @param grid
     */
    public CharGrid(char[][] grid) {
        this.grid = grid;
    }
    /**
     * Returns the area for the given char in the grid.
     * @param ch char to look for
     * @return area for given char
     */
    public int charArea (char ch) {
        int minRow = grid.length, maxRow = -1;
        int minCol = grid[0].length, maxCol = -1;
        boolean found = false;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == ch) {
                    found = true;
                    minRow = Math.min(minRow, i);
                    maxRow = Math.max(maxRow, i);
                    minCol = Math.min(minCol, j);
                    maxCol = Math.max(maxCol, j);
                }
            }
        }
        if (!found) {
            return 0; // char not found
        }
        return (maxRow - minRow + 1) * (maxCol - minCol + 1);
    }
    /**
     * Returns the count of '+' figures in the grid.
     * @return number of + in grid
     */
    public int countPlus() {
        int count = 0;
        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < grid[i].length - 1; j++) {
                if (isCenterOfPlus(i, j)) {
                    count++;
                }
            }
        }
        return count;
    }
    /**
     * kiem tra xem vi tri co phai la tam cua hinh chu thap "+" hay khong
     * @param row center row
     * @param col center column
     * @return true if position is center of '+', false otherwise
     */
    private boolean isCenterOfPlus(int row, int col) {
        char ch = grid[row][col];
        int up = countInDirection(row, col, -1, 0, ch); // count up
        int down = countInDirection(row, col, 1, 0, ch); // count down
        int left = countInDirection(row, col, 0, -1, ch); // count left
        int right = countInDirection(row, col, 0, 1, ch); // count right
        return ch != ' ' && up >= 2 && down >= 2 && left >= 2 && right >= 2 &&
                up == down && left == right;
    }
    /**
     * dem cac ki tu lien tiep theo mot huong
     * @param row starting row
     * @param col starting column
     * @param dRow row direction (-1, 0, 1)
     * @param dCol column direction (-1, 0, 1)
     * @param ch character to count
     * @return count of consecutive characters
     */
    private int countInDirection(int row, int col, int dRow, int dCol, char ch) {
        int count = 0;
        int i = row + dRow;
        int j = col + dCol;
        while (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == ch) {
            count++;
            i += dRow;
            j += dCol;
        }
        return count;
    }
}