import acm.graphics.*;

import static acm.graphics.GImage.*;

public class SteganographyLogic {
    /**
     * Given a GImage containing a hidden message, finds the hidden message
     * contained within it and returns a boolean array containing that message.
     * <p/>
     * A message has been hidden in the input image as follows.  For each pixel
     * in the image, if that pixel has a red component that is an even number,
     * the message value at that pixel is false.  If the red component is an odd
     * number, the message value at that pixel is true.
     *
     * @param source The image containing the hidden message.
     * @return The hidden message, expressed as a boolean array.
     */
    public static boolean[][] findMessage(GImage source) {
        int[][] array = source.getPixelArray();
        int row = array.length;
        int col = array[0].length;

        boolean[][] result = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                if (getRed(array[i][j]) % 2 == 0) {
                    result[i][j] = false;
                } else {
                    result[i][j] = true;
                }
            }
        }
        return result;
    }

    /**
     * Hides the given message inside the specified image.
     * <p/>
     * The image will be given to you as a GImage of some size, and the message will
     * be specified as a boolean array of pixels, where each white pixel is denoted
     * false and each black pixel is denoted true.
     * <p/>
     * The message should be hidden in the image by adjusting the red channel of all
     * the pixels in the original image.  For each pixel in the original image, you
     * should make the red channel an even number if the message color is white at
     * that position, and odd otherwise.
     * <p/>
     * You can assume that the dimensions of the message and the image are the same.
     * <p/>
     *
     * @param message The message to hide.
     * @param source  The source image.
     * @return A GImage whose pixels have the message hidden within it.
     */
    public static GImage hideMessage(boolean[][] message, GImage source) {

        int[][] array = source.getPixelArray();
        int row = array.length;
        int col = array[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                /*Saving components of pixel to then restore it with modified R component
                * */
                int red = getRed(array[i][j]);
                int green = getGreen(array[i][j]);
                int blue = getBlue(array[i][j]);

                if (message[i][j] && red % 2 == 0) {            //If pixel from hidden message have even R component make it odd
                    red += 1;
                } else if (!message[i][j] && red % 2 != 0) {    //If pixel not from hidden message have odd R component make it even
                    red -= 1;
                }

                array[i][j] = createRGBPixel(red, green, blue);
            }
        }
        return new GImage(array);
    }

}
