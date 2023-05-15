public class Assignment2Part6 extends WindowProgram {
    //Number of circles(caterpillar segments)
    private static final int NUM_CIRCLES = 6;
    //Circle size
    private static final int CIRCLE_SIZE = 100;

    //Circles vertical overlap. Increasing this constant will increase the vertical distance between circles
    private static final int VERTICAL_OVERLAP = 30;

    //Horizontal overlap of circles. Increasing this constant will **decrease** the horizontal distance between circles
    private static final int HORIZONTAL_OVERLAP = 40;

    //Application size
    public static final int APPLICATION_WIDTH = 500;
    public static final int APPLICATION_HEIGHT = 300;

    /* Goes through number of circles, calculates x and y coordinates for each of them and adds to canvas */
    public void run() {
        for (int i = 0; i < NUM_CIRCLES; i++) {
            double x = calculateX(i);
            double y = calculateY(i);
            drawCircles(x, y);
        }
    }

    //Calculates X coordinate considering the vertical overlap of circles
    private int calculateX(int numOfCircle) {
        return numOfCircle * (CIRCLE_SIZE - HORIZONTAL_OVERLAP);
    }

    //Calculates the Y coordinate and adds horizontal overlap for each even circle.
    private double calculateY(int numOfCircle) {
        double y;
        if (numOfCircle % 2 == 0) {
            y = getHeight() - CIRCLE_SIZE;
        } else {
            y = getHeight() - CIRCLE_SIZE - VERTICAL_OVERLAP;
        }
        return y;
    }

    //Add circles to the canvas
    private void drawCircles(double x, double y) {
        GOval circle = new GOval(x, y, CIRCLE_SIZE, CIRCLE_SIZE);
        circle.setFilled(true);
        circle.setFillColor(Color.green);
        circle.setColor(Color.red);
        add(circle);
    }

}
