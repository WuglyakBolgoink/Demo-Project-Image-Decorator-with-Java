/**
 *	Schneidet an den vier Seiten eines Bildes, das der Konstruktor als erstes Argument erhält,
 *	eweils n Pixel ab. Der Konstruktor erwartet n (Typ int) als zweites Argument.
 *	Das neue Bild ist in beiden Richtungen um 2·n kleiner als das alte Bild.
 *
 *	Bei n < 0 und wenn vom alten Bild kein Pixel mehr übrig bliebe,
 *	wirft der Konstruktor eine IllegalArgumentException.
 *
 * @author "Elderov Ali, IF4B"
 */
public class Cropped extends Decorator {

	/**
	 * croppedBreite.
	 */
	private final int croppedBreite;

	/**
	 * Konstruktor (PixelImage, int) - erwartet ein PixelImage und CroppedBreite.
	 * @param image - PixelImage
	 * @param croppedBreite - croppedBreite
	 */
	public Cropped(final PixelImage image, final int croppedBreite) {
		super(image);
		if (croppedBreite < 0 || image.getHeight() < croppedBreite*2 || image.getWidth() < croppedBreite*2) {
			throw new IllegalArgumentException("Error! Wrong croppedBreite value or original Picture too small.");
		}
		this.croppedBreite = croppedBreite;
	}

	@Override public int getPixel(final int xKor, final int yKor) {
		if (xKor < 0 || xKor >= getWidth() || yKor < 0 || yKor >= getHeight()) {
    		throw new IllegalArgumentException(this.getClass().getName()+" Error! Bad value of X or Y...");
    	}
		return super.getPixel(xKor+croppedBreite, yKor+croppedBreite);
	}

	@Override public int getWidth() {
		return super.getWidth()-croppedBreite*2;
	}

	@Override public int getHeight() {
		return super.getHeight()-croppedBreite*2;
	}
}