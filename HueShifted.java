import java.awt.Color;

/**
 *	Verschiebt die Farben der Pixel des Bildes, das der Konstruktor als erstes Argument erhält,
 *	um a⁰ im Farbkreis des Regenbogens.
 *	Der Konstruktor erwartet a (Typ int) als zweites Argument.
 *	Das neue Bild hat die gleiche Größe wie das alte Bild.
 *
 * @author "Elderov Ali, IF4B"
 */
public class HueShifted extends Decorator {

	/**
	 * alpha - int.
	 */
	private final int alpha;

	/**
	 *	konstruktor (PixelImage, int).
	 *
	 * @param image - pixelImage
	 * @param alpha - farbeAlpha
	 */
	public HueShifted(final PixelImage image, final int alpha) {
		super(image);
		this.alpha = alpha;
	}

	@Override
	public int getPixel(final int xKor, final int yKor) {
		if (xKor < 0 || xKor >= getWidth() || yKor < 0 || yKor >= getHeight()) {
    		throw new IllegalArgumentException(this.getClass().getName()+" Error! Bad value of X or Y.");
    	}
		final Color color = new Color(super.getPixel(xKor, yKor));
		final float[] hsb = Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), null);
		final int creisGrad = 360;
		return Color.HSBtoRGB(hsb[0] + (float)alpha/creisGrad, hsb[1], hsb[2]);
	}
}