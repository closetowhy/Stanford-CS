public class Assignment2Part5 extends WindowProgram {
    /* The number of rows and columns in the grid, respectively. */
    private static final int NUM_ROWS = 5;
    private static final int NUM_COLS = 6;
    /* The width and height of each box. */
    private static final double BOX_SIZE = 40;
    /* The horizontal and vertical spacing between the boxes. */
    private static final double BOX_SPACING = 10;
    /*Application size*/
    public static final int APPLICATION_WIDTH = 400;
    public static final int APPLICATION_HEIGHT = 400;

    /*This method crates on canvas 'Hermann grid illusion' which consists of a given number of rows and columns*/
    public void run() {
        drawGrid(NUM_ROWS, NUM_COLS);
    }

    //Method that takes number of rows and columns and draws grid
    private void drawGrid(int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            drawGridRow(i, cols);
        }
    }

    //Method that draws each row of grid
    private void drawGridRow(int rowNumber, int cols) {
        for (int i = 0; i < cols; i++) {
            drawGridItem(rowNumber, i);
        }
    }

    //This method draws items of the grid by creating rectangles
    private void drawGridItem(int rowNumber, int colNumber) {
        /*To x, y coordinates which are centered position of the grid
        I add number of column/row multiplied by box size and box spacing sum */
        double x = calculateXCoordinate(NUM_COLS, BOX_SIZE, BOX_SPACING);
        double y = calculateYCoordinate(NUM_ROWS, BOX_SIZE, BOX_SPACING);
        GRect box = new GRect(
                x + colNumber * (BOX_SIZE + BOX_SPACING),
                y + rowNumber * (BOX_SIZE + BOX_SPACING),
                BOX_SIZE, BOX_SIZE);
        box.setFilled(true);
        box.setFillColor(Color.BLACK);
        add(box);
    }

    //Calculate x coordinate for the top-left corner of the grid
    private double calculateXCoordinate(int numCols, double boxSize, double boxSpacing) {
        // Calculate the total width of the grid
        double gridWidth = numCols * boxSize + (numCols - 1) * boxSpacing;
        double x = (getWidth() - gridWidth) / 2;
        return x;
    }

    //Calculate y coordinate for the top-left corner of the grid
    private double calculateYCoordinate(int numRows, double boxSize, double boxSpacing) {
        // Calculate the total height of the grid
        double gridHeight = numRows * boxSize + (numRows - 1) * boxSpacing;
        double y = (getHeight() - gridHeight) / 2;
        return y;
    }
}
