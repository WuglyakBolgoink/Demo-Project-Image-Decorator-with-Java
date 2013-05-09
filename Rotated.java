/**
 * 	DECORATOR.
 *	Dreht ein Bild, das der Konstruktor als erstes Argument erhält,
 *	um 90⁰ gegen den Uhrzeigersinn.
 *	Im neuen Bild sind Breite und Höhe des alten Bildes vertauscht.
 *
 * @author "Elderov Ali, IF4B"
 */
public class Rotated extends Decorator {

	/**
	 * Konstruktor (PixelImage).
	 *
	 * @param image - PixelImage
	 */
	public Rotated(final PixelImage image) {
		super(image);
	}

	@Override public int getPixel(final int xKor, final int yKor) {
		if (xKor < 0 || xKor >= getWidth() || yKor < 0 || yKor >= getHeight()) {
    		throw new IllegalArgumentException(this.getClass().getName()+" Error! Bad value of X or Y.");
    	}
		return super.getPixel(super.getWidth()-yKor-1, xKor);
	}

	@Override public int getWidth() {
		return super.getHeight();
	}

	@Override public int getHeight() {
		return super.getWidth();
	}
}