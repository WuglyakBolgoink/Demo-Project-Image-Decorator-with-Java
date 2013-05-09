/**
 *	Spiegelt ein Bild, das der Konstruktor als erstes Argument erhält, horizontal.
 *	Das neue Bild hat die gleiche Größe wie das alte Bild.
 *
 * @author "Elderov Ali, IF4B"
 */
public class Flipped extends Decorator {

	/**
	 * Konstruktor - erwartet ein pixelImage Objekt.
	 *
	 * @param image - PixelImage
	 */
    public Flipped(final PixelImage image) {
        super(image);
    }

    @Override public int getPixel(final int xKor, final int yKor) {
    	if (xKor < 0 || xKor >= getWidth() || yKor < 0 || yKor >= getHeight()) {
    		throw new IllegalArgumentException(this.getClass().getName()+" Error! Bad value of X or Y...");
    	}
        return super.getPixel(super.getWidth()-xKor-1, yKor);
    }
}