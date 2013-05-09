import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 *	Ändert nichts am Bild, das der Konstruktor als Argument erhält.
 *
 * @author "Elderov Ali, IF4B"
 */
public class Saving implements PixelImage {
	/**
	 * image - PixelImage Object.
	 */
    private final PixelImage image;

    /**
     * File Name.
     */
    private final String fileName;

	/**
	 * konstruktor (PixelImage, String).
	 *
	 * @param image - pixelImage
	 * @param fileName - String, Path for picture
	 */
	public Saving(final PixelImage image, final String fileName) {
		this.image = image;
		if (fileName.length() == 0 || fileName == null) {
			throw new IllegalArgumentException("Error! You must put in a fileName.");
		}
		this.fileName = fileName;
	}

	/**
	 * eine zusätzliche Methode, die das Bild in die Datei speichert,
	 * deren Name der Konstruktor als zweites Argument erhält.
	 */
	public void save() {
        final BufferedImage bufferedImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);

        for(int yKor = 0; yKor < getHeight(); yKor++) {
			for(int xKor = 0; xKor < getWidth(); xKor++) {
				bufferedImage.setRGB(xKor, yKor, getPixel(xKor, yKor));
			}
		} // forY

        final String format = fileName.substring(fileName.lastIndexOf('.') + 1);
        try {
			ImageIO.write(bufferedImage, format, new File(fileName));
		} catch (final IOException runtimeException) {
			throw new RuntimeException("Error! Unexpected error writing image.");
		}
	}

	@Override public int getPixel(final int xKor, final int yKor) {
		if (xKor < 0 || xKor >= getWidth() || yKor < 0 || yKor >= getHeight()) {
    		throw new IllegalArgumentException(this.getClass().getName()+" Error! Bad value of X or Y...");
    	}
		return image.getPixel(xKor, yKor);
	}

	@Override public int getWidth() {
		return image.getWidth();
	}

	@Override public int getHeight() {
		return image.getHeight();
	}
}