public class KanizsaSquare extends WindowProgram {
    //Diameter and Radius of Circles
    private static final int DIAMETER = 120;
    private static final int RADIUS = DIAMETER / 2;
    //Application width and height
    public static final int APPLICATION_WIDTH = 500;
    public static final int APPLICATION_HEIGHT = 500;

    /*This method creates on canvas 'kanizsa square' visual illusion.
     The circles can be easily resized using constants, and the rectangle will also change dynamically*/
    public void run() {
        drawOvals();
        drawRectangle();
    }

    /*This method build 4 ovals which border 4 corners of canvas.
    For positioning we use width and height of application and diameter*/
    private void drawOvals() {
        GOval topLeftOval = new GOval(0, 0, DIAMETER, DIAMETER);
        GOval topRightOval = new GOval(getWidth() - DIAMETER, 0, DIAMETER, DIAMETER);
        GOval bottomLeftOval = new GOval(0, getHeight() - DIAMETER, DIAMETER, DIAMETER);
        GOval bottomRightOval = new GOval(getWidth() - DIAMETER, getHeight() - DIAMETER, DIAMETER, DIAMETER);
        //To avoid rewriting same code 4 times for adding all ovals and to make code more readable I use a separate method to add circles
        addOvalsToCanvas(topLeftOval, topRightOval, bottomLeftOval, bottomRightOval);
    }

    //This method creates an array from created ovals and then fills them with color and adds all elements to the screen
    private void addOvalsToCanvas(GOval topLeftOval, GOval topRightOval, GOval bottomLeftOval, GOval bottomRightOval) {
        GOval[] OvalsArray = {topLeftOval, topRightOval, bottomLeftOval, bottomRightOval};
        //I use for each loop, basically it's the same as 'for (int i = 0; i < OvalsArray.length; i++) etc.' just more beautiful :)
        for (GOval oval : OvalsArray) {
            oval.setFilled(true);
            oval.setFillColor(Color.black);
            add(oval);
        }
    }

    //Create the rectangle
    public void drawRectangle() {
        /*Rectangle starting coordinates are equal radius, so it will start to be drawn from the middle of the circle.
        And size equals size of application Width/Height minus Diameter */
        GRect rect = new GRect(RADIUS, RADIUS, getWidth() - DIAMETER, getHeight() - DIAMETER);
        rect.setFilled(true);
        rect.setFillColor(Color.white);
        rect.setColor(Color.white);
        add(rect);
    }

}
