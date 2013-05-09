/**
 *	Skaliert ein Bild, das der Konstruktor als erstes Argument erhält,
 *	mit dem Faktor f. Der Konstruktor erwartet f (Typ double) als zweites Argument.
 *	Das neue Bild ist in beiden Richtungen f× so groß wie das alte Bild.
 *
 *	Bei f = 1 ändert sich das Bild nicht. Bei f < 1 schrumpft es, bei f > 1 wächst es.
 *	Bei f ≤ 0 wirft der Konstruktor eine IllegalArgumentException.
 *
 * @author "Elderov Ali, IF4B"
 */
public class Zoomed extends Decorator {

	/**
	 *	faktor for Zooming.
	 */
	private final Double faktor;

	/**
	 * konstruktor (PixelImage, Double).
	 *
	 * @param image - PixelImage
	 * @param faktor - faktor
	 */
	public Zoomed(final PixelImage image, final Double faktor) {
		super(image);
		if (faktor <= 0) {
			throw new IllegalArgumentException("Error! Faktor [" + faktor + "]  is too small. Must be over 0.");
		}
		this.faktor = faktor;
	}

	@Override public int getWidth() {
		return (int)(super.getWidth()*faktor);
	}

	@Override public int getHeight() {
		return (int)(super.getHeight()*faktor);
	}

	@Override public int getPixel(final int xKor, final int yKor) {
		if (xKor < 0 || xKor >= getWidth() || yKor < 0 || yKor >= getHeight()) {
    		throw new IllegalArgumentException(this.getClass().getName()+" Error! Bad value of X or Y.");
    	}
		return super.getPixel((int)(xKor/faktor),(int)(yKor/faktor));
	}
}