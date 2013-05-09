/**
 *	Abstrakte Decorator.
 *
 * @author "Elderov Ali, IF4B"
 */
public abstract class Decorator implements PixelImage {
	/**
	 * image - pixelImage.
	 */
    private final PixelImage image;

    /**
     * Konstruktor (PixelImage).
     *
     * @param image - PixelImage
     */
    public Decorator(final PixelImage image) {
        this.image = image;
    }

    @Override public int getWidth() {
        return image.getWidth();
    }

    @Override public int getHeight() {
        return image.getHeight();
    }

    @Override public int getPixel(final int xKor, final int yKor) {
         return image.getPixel(xKor, yKor);
    }
}