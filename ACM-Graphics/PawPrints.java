public class PawPrints extends WindowProgram {
    /* Constants controlling the relative positions of the
     * three toes to the upper-left corner of the paw-print */
    private static final double FIRST_TOE_OFFSET_X = 0;
    private static final double FIRST_TOE_OFFSET_Y = 20;
    private static final double SECOND_TOE_OFFSET_X = 30;
    private static final double SECOND_TOE_OFFSET_Y = 0;
    private static final double THIRD_TOE_OFFSET_X = 60;
    private static final double THIRD_TOE_OFFSET_Y = 20;

    /* The position of the heel relative to the upper-left
     * corner of the paw-print */
    private static final double HEEL_OFFSET_X = 20;
    private static final double HEEL_OFFSET_Y = 40;

    /*Width and height of toes */
    private static final double TOE_WIDTH = 20;
    private static final double TOE_HEIGHT = 30;

    /* Width and height of heels*/
    private static final double HEEL_WIDTH = 40;
    private static final double HEEL_HEIGHT = 60;

    /*The default width and height of the window */
    public static final int APPLICATION_WIDTH = 300;
    public static final int APPLICATION_HEIGHT = 250;

    //Draws two paw-prints on the canvas
    public void run() {
        drawPawprint(20, 20);
        drawPawprint(180, 70);
    }

    /* Draws a paw-print by adding constants to the parameters.
        The parameters should specify the upper-left corner of the bounding box containing that paw-print */
    private void drawPawprint(double x, double y) {

        GOval firstToe = new GOval(x + FIRST_TOE_OFFSET_X, y + FIRST_TOE_OFFSET_Y, TOE_WIDTH, TOE_HEIGHT);

        GOval secondToe = new GOval(x + SECOND_TOE_OFFSET_X, y + SECOND_TOE_OFFSET_Y, TOE_WIDTH, TOE_HEIGHT);

        GOval thirdToe = new GOval(x + THIRD_TOE_OFFSET_X, y + THIRD_TOE_OFFSET_Y, TOE_WIDTH, TOE_HEIGHT);

        GOval heel = new GOval(x + HEEL_OFFSET_X, y + HEEL_OFFSET_Y, HEEL_WIDTH, HEEL_HEIGHT);

        //Creating an array from ovals
        GOval[] pawElements = {firstToe, secondToe, thirdToe, heel};

        //Paint all ovals black and add them to the canvas
        for (GOval pawElement : pawElements) {
            pawElement.setFilled(true);
            pawElement.setFillColor(Color.black);
            add(pawElement);
        }
    }
}
