/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *	interface.
 *
 * @author Admin
 */
public interface PixelImage {
	/**
	 * konstruktor.
	 * @param xKor - X koordinate
	 * @param yKor - y koordinate
	 * @return null
	 */
    int getPixel(int xKor, int yKor);

    /**
     * gibt breite zurück.
     * @return int
     */
    int getWidth();

    /**
     * gibt höhe zurück.
     * @return int
     */

    int getHeight();
}