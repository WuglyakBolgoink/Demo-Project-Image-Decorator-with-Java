import java.awt.Color;

/**
 * Ein quadratisches Bild mit den Regenbogenfarben als horizontalem Farbverlauf.
 *
 * @author "Elderov Ali, IF4B"
 */
public class RainbowImage implements PixelImage {

	/**
	 * int Randbreite.
	 */
	private final int borderLength;

	/**
	 * Der Konstuktor erwartet die Kantenlänge (positiv) als int-Argument.
	 *
	 * @param borderLength - Integer, >0
	 */
	public RainbowImage(final int borderLength) {
		if (borderLength <= 0) {
			throw new IllegalArgumentException("Wrong border value");
		}
		this.borderLength = borderLength;
	}

	@Override public int getPixel(final int xKor, final int yKor) {
		if (xKor < 0 || xKor >= getWidth()) {
    		throw new IllegalArgumentException(this.getClass().getName()+" Error! Bad value of X or Y...");
    	}
		return Color.HSBtoRGB((float)xKor/borderLength, 1, 1);
	}

	@Override public int getWidth() {
		return borderLength;
	}

	@Override public int getHeight() {
		return borderLength;
	}
}