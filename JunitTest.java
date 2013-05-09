import java.io.IOException;

import org.junit.Test;


/**
 * Test klass zum Decorator.
 * @author "Elderov Ali, IF4B"
 *
 */
public class JunitTest {
	/**
	 * zoom- 50px.
	 */
	private static final int ZOOM50 = 50;
	/**
	 * image - FileImage.
	 */
	private final FileImage image;

	/**
	 * Konstruktor.
	 * @throws IOException - IO
	 */
	public JunitTest() throws IOException{
		image = new FileImage("bild.jpg");
	}

	/**
	 * test1.
	 */
  @Test (expected=Exception.class)
  public void exceptionsFileImage() {
    image.getPixel(image.getWidth(), image.getHeight());
  }

  /**
   * test2.
   */
  @Test (expected=Exception.class)
  public void rainbowOverX(){
    final RainbowImage rainImage = new RainbowImage(400);
    rainImage.getPixel(Integer.parseInt("400"), Integer.parseInt("200"));
  }

  /**
   * test3.
   */
  @Test (expected=Exception.class)
  public void testRotatedMinus0(){
    new Rotated(image).getPixel(0, -1);
  }

  /**
   * test.
   */
  @Test (expected=Exception.class)
  public void testRotatedMinus1(){
    new Rotated(image).getPixel(-1, 0);
  }

  /**
   * test.
   */
  @Test (expected=Exception.class)
  public void testRotatedGerade(){
    new Rotated(image).getPixel(image.getWidth(), image.getHeight());
  }

  //Konstruktor Test
  /**
   * test.
   */
  @Test (expected=Exception.class)
  public void testZoomedConstruktorMinus(){
    new Zoomed(image, -1.0);
  }

  /**
   * test.
   */
  @Test (expected=Exception.class)
  public void testZoomedConstruktorNull(){
    new Zoomed(image, 0.0);
  }

  /**
   * test.
   */
  @Test (expected=Exception.class)
  public void testRainbowNull(){
    new RainbowImage(0);
  }

  /**
   * test.
   */
  @Test (expected=Exception.class)
  public void testRainbowMinus(){
    new RainbowImage(-1);
  }

  /**
   * test.
   */
  @Test (expected=Exception.class)
  public void flippedCroppedTestVielGroesse(){
    new Cropped(image,Integer.parseInt("1000"));
  }

  /**
   * test.
   */
  @Test (expected=Exception.class)
  public void flippedCroppedTestGleicheGroesse(){
    new Cropped(image,image.getHeight()/2);
  }

/**
 * test.
 */
  //Methoden Test
  @Test (expected=Exception.class)
  public void zoomedOverX(){
    final Zoomed zoomIm = new Zoomed(image,5.0);
    zoomIm.getPixel(zoomIm.getWidth(), zoomIm.getHeight()-ZOOM50);
  }

  /**
   * test.
   */
  @Test (expected=Exception.class)
  public void zoomedOverY(){
    final Zoomed zoomIm = new Zoomed(image,50.0);
    zoomIm.getPixel(zoomIm.getWidth()-ZOOM50, zoomIm.getHeight());
  }

  /**
   * test.
   */
  @Test (expected=Exception.class)
  public void zoomedMinusX(){
    final Zoomed zoomIm = new Zoomed(image,50.0);
    zoomIm.getPixel(-1, zoomIm.getHeight()-ZOOM50);
  }

  /**
   * test.
   */
  @Test (expected=Exception.class)
  public void zoomedMinusY(){
    final Zoomed zoomIm = new Zoomed(image,50.0);
    zoomIm.getPixel(zoomIm.getWidth()-ZOOM50, -1);
  }

  /**
   * test.
   */
  @Test (expected=Exception.class)
  public void rainBowGetPixel(){
    final RainbowImage rainbow = new RainbowImage(100);
    rainbow.getPixel(-1, Integer.parseInt("9"));
  }

  /**
   * test.
   */
  //getPixelTest
  @Test public void randTest(){
    image.getPixel(image.getWidth()-1, image.getHeight()-1);
    image.getPixel(0, 0);
    new Rotated(image).getPixel(image.getHeight()-1, image.getWidth()-1);
    new Rotated(image).getPixel(0, 0);
    new Cropped(image,image.getHeight()/2-1);
  }


  /**
   * test.
   */
  @Test (expected=Exception.class)
  public void croppedRotated(){
    final Cropped cropped = new Cropped(image,1);
    cropped.getPixel(cropped.getWidth(), cropped.getHeight());
  }

  /**
   * test.
   */
  @Test (expected=Exception.class)
  public void croppedRotatedOverFlow(){
    final Cropped cropped = new Cropped(image,1);
    cropped.getPixel(cropped.getWidth()-1, cropped.getHeight());
  }
}