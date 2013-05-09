import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

/**
 * mein.
 * @author "Elderov Ali, IF4B"
 *
 */
public class MeinTest extends JFrame {


	/**
	 * serialVersionUID.
	 */
	private static final long serialVersionUID = 1128804299377151760L;
	/**
	 * plus breite.
	 */
	private static final int WINDOWWIDTH = 100;

	/**
	 * image.
	 */
	private BufferedImage image;

	/**
	 * panel.
	 */
	private final JPanel panel;

	/**
	 * label.
	 */
	private final JLabel label;

	/**
	 * icon.
	 */
	private final ImageIcon icon;

	/**
	 * construktor.
	 * @param frameTitle - String
	 * @param image - BufferedImage
	 */
	public MeinTest(final String frameTitle, final PixelImage image) {

		final int imageWidth = image.getWidth();
        final int imageHeight = image.getHeight();


        final BufferedImage bufferedImage = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB);

        for(int y = 0; y < imageHeight; y++) {
			for(int x = 0; x < imageWidth; x++) {
				bufferedImage.setRGB(x, y, image.getPixel(x, y));
			}
		}

        icon = new ImageIcon(bufferedImage);
        label = new JLabel(icon);
        label.setBorder(new LineBorder(Color.WHITE));

        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.ORANGE);
        panel.add(label, BorderLayout.CENTER);

        setTitle(frameTitle);
        getContentPane().add(panel);
        setSize(imageWidth+WINDOWWIDTH, imageHeight+WINDOWWIDTH);
        setLocation(WINDOWWIDTH, WINDOWWIDTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
	}




	/**
	 * bild.
	 * @param args - keine parameter nötig
	 */
	public static void main(final String... args) {
		 SwingUtilities.invokeLater(new Runnable() {
			              @Override
						public void run(){
//			                 final String file = "/Users/Admin/Google Drive/workspace_java/DecoratorImage/bild.jpg";
//			                 final String file ="/Users/Admin/Google Drive/workspace_java/DecoratorImage/AVATAR.png";

//			                 final MeinTest tRainbowImage = new MeinTest("RainbowImage",new RainbowImage(300));
//			                 final MeinTest tFileImage = new MeinTest("FileImage",new FileImage(file));
//			                 final MeinTest t2 = new MeinTest("R_FI",new Rotated(new FileImage(file)));
//			                 final MeinTest t3 = new MeinTest("R_R_FI",new Rotated(new Rotated(new FileImage(file))));
//			                 final MeinTest t4 = new MeinTest("R_R_R_FI",new Rotated(new Rotated(new Rotated(new FileImage(file)))));
//			                 final MeinTest t5 = new MeinTest("R_R_R_R_FI",new Rotated(new Rotated(new Rotated(new Rotated(new FileImage(file))))));
//			                 final MeinTest t6 = new MeinTest("Fl_F", new Flipped(new FileImage(file)));
//			                 final MeinTest tCropped = new MeinTest("Cr_F", new Cropped(new FileImage(file),25));
//			                 final MeinTest tZoomed = new MeinTest("ZooMZoom_F", new Zoomed(new FileImage(file),-5.0));
//			                 final MeinTest tHue = new MeinTest("Hue_F", new HueShifted(new FileImage(file),45));
//			                 final MeinTest tHueRainbow1 = new MeinTest("HueRainbow_F_120", new HueShifted(new RainbowImage(300),120));
//			                 final MeinTest tHueRainbow2 = new MeinTest("HueRainbow_F_480", new HueShifted(new RainbowImage(300),480));

//			                 final MeinTest tSaving = new MeinTest("SavingImage",new Saving(new RainbowImage(300),"/Users/Admin/Google Drive/workspace_java/DecoratorImage/test.jpg"));
//			                 final Saving tSave = new Saving(new RainbowImage(300),"test.JPEG");
//			                 tSave.save();

//			                 final Rotated r = new Rotated(new FileImage(file));
//			                 System.out.println(r.getPixel(0, 0));

//			                 Debugging:
//			                 final Cropped cropped = new Cropped(new FileImage(file),1);
//			                 System.out.println(cropped.getWidth()+" "+cropped.getHeight());
//			                 cropped.getPixel(cropped.getWidth()-1, cropped.getHeight());

//			                 final Zoomed z = new Zoomed(new FileImage(file), 0.5);
//			                 System.out.println(z.getWidth()+" "+z.getHeight());
//			                 System.out.println(z.getPixel(1, z.getHeight()));

			                 final RainbowImage tRainbowImage = new RainbowImage(300);
			                 System.out.println(tRainbowImage.getPixel(0, Integer.parseInt("301")));
			                 final MeinTest a = new MeinTest("rot_rain", new Rotated(tRainbowImage));
			              }
			         });


	}


}
