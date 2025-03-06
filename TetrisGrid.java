//
// TetrisGrid encapsulates a tetris board and has
// a clearRows() capability.

public class TetrisGrid {
    private boolean[][] grid;
    /**
     * Constructs a new instance with the given grid.
     * Does not make a copy.
     * @param grid
     */
    public TetrisGrid(boolean[][] grid) {
        this.grid = grid;
    }
    /**
     * Does row-clearing on the grid (see handout)
     */
    public void clearRows() {
        int height = grid[0].length;
        int width = grid.length;
        int currentRow = 0;
        for (int y = 0; y < height; y++) {
            boolean isFullRow = true;
            for (int x = 0; x < width; x++) {
                if (!grid[x][y]) {
                    isFullRow = false;
                    break;
                }
            }
            // khong du thi chuyen xuong duoi
            if (!isFullRow) {
                for (int x = 0; x < width; x++) {
                    grid[x][currentRow] = grid[x][y];
                }
                currentRow++;
            }
        }

        // xoa cac hang con lai
        for (int y = currentRow; y < height; y++) {
            for (int x = 0; x < width; x++) {
                grid[x][y] = false;
            }
        }
    }
    /**
     * Returns the internal 2D grid array.
     * @return 2D grid array
     */
    public boolean[][] getGrid() {
        return grid;
    }