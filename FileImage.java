import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Repräsentiert ein Bild aus einer Bilddatei.
 *
 * @author "Elderov Ali, IF4B"
 */
public class FileImage implements PixelImage {

	/**
	 * image - BufferedImage.
	 */
	private BufferedImage bufferedImage;

    /**
     * Der Konstruktor erwartet den Namen der Bilddatei als String-Argument.
     *
     * @param fileName - String
     */
	public FileImage(final String fileName) {
		if (fileName.length() == 0 || fileName == null) {
			throw new IllegalArgumentException("Error! You must put in a filename!");
		}
		try {
			bufferedImage = ImageIO.read(new File(fileName));
		} catch (final IOException ioException) {
			ioException.printStackTrace();
		}
	}

	@Override public int getPixel(final int xKor, final int yKor) {
		return bufferedImage.getRGB(xKor, yKor);
	}

	@Override public int getWidth() {
		return bufferedImage.getWidth();
	}

	@Override public int getHeight() {
		return bufferedImage.getHeight();
	}
}