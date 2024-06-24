package Business_Logic;

import java.awt.image.BufferedImage; 
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import com.tyss.optimize.nlp.util.annotation.ReturnType;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.util.LoadLibs;
import org.springframework.stereotype.Component;
 
@Component("LIC13397_PJT1001_PE_NLPd006beb4-9fa6-46c2-b9a2-5d1ca40e39e9")
public class MOB_SwipeUtilTextIsVisible implements Nlp {
	@InputParams({ @InputParam(name = "xpath", type = "java.lang.String"),
		@InputParam(name = "Max swipe count", type = "java.lang.Integer"),
		@InputParam(name = "screenshotPath", type = "java.lang.String"),
			@InputParam(name = "desiredText", type = "java.lang.String") ,
			@InputParam(name = "StartX", type = "java.lang.Integer"),
			@InputParam(name = "StartY", type = "java.lang.Integer"),
			@InputParam(name = "EndX", type = "java.lang.Integer"),
			@InputParam(name = "EndY", type = "java.lang.Integer"),
	         @InputParam(name = "XorYCoordinate", type = "java.lang.String")})

    @ReturnType(name = "Coordinates", type = "java.lang.String")

	@Override
	public List<String> getTestParameters() throws NlpException {
		List<String> params = new ArrayList<>();
		return params;
	}

	@Override
	public StringBuilder getTestCode() throws NlpException {
		StringBuilder sb = new StringBuilder();
		return sb;
	}

	public static void screentshot(String screenshotPath2, AppiumDriver driver) {

		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		String screenshotPath = screenshotPath2;

		try {
			FileUtils.copyFile(screenshot, new File(screenshotPath));
			System.out.println("Screenshot saved successfully!");
		} catch (IOException e) {
			System.out.println("Failed to save screenshot: " + e.getMessage());
		}
	}

	@Override
	public NlpResponseModel execute(NlpRequestModel nlpRequestModel) throws NlpException {

		NlpResponseModel nlpResponseModel = new NlpResponseModel();
		Map<String, Object> attributes = nlpRequestModel.getAttributes();
		String xpath = (String) attributes.get("xpath");
		int maxSwipeCount = (Integer) attributes.get("Max swipe count");
		String screenshotPath = (String) attributes.get("screenshotPath");
		String desiredText = (String) attributes.get("desiredText");
		int StartX = (Integer) attributes.get("StartX");
		int StartY = (Integer) attributes.get("StartY");
		int EndX = (Integer) attributes.get("EndX");
		int EndY = (Integer) attributes.get("EndY");
		String XorYCoordinate = (String) attributes.get("XorYCoordinate");
		AppiumDriver driver = (AndroidDriver) nlpRequestModel.getAndroidDriver();
		int xpi=0;
		int ypi=0;
		try {

			int count = 0;

			PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

			while (count <= maxSwipeCount) {
				screentshot(screenshotPath, driver);
				File imageFile = new File(screenshotPath);

				ITesseract tesseract = new Tesseract();
				tesseract.setDatapath(LoadLibs.extractTessResources("tessdata").getAbsolutePath());
				boolean s = false;
				try {
					BufferedImage bufferedImage = ImageIO.read(imageFile);
					String result = tesseract.doOCR(bufferedImage);

					// Find the position of the desired text in the image
					String[] lines = result.split("\\r?\\n");
					int yPixel = 0;

					for (int i = 0; i < lines.length; i++) {
						if (lines[i].contains(desiredText)) {
							yPixel += i * bufferedImage.getHeight() / lines.length;
							s = true;
							break;
						}
					}

					int xPixel = result.indexOf(desiredText) * bufferedImage.getWidth() / result.length();

					// Print the pixel coordinates
					System.out.println("Desired Text: " + desiredText);
					System.out.println("X Pixel: " + xPixel);
					System.out.println("Y Pixel: " + yPixel);
					xpi=xPixel;
					ypi=yPixel;
				} catch (Exception e) {
					e.printStackTrace();
				}

				if (s == false) {

					Sequence swipe = new Sequence(finger, 1);

					// Move finger into starting position
					swipe.addAction(
							finger.createPointerMove(Duration.ofSeconds(0), PointerInput.Origin.viewport(), StartX, StartY));

					// Finger goes up into contact with screen
					swipe.addAction(finger.createPointerDown(0));

					// Finger moves to End Position
					swipe.addAction(finger.createPointerMove(Duration.ofMillis(300), PointerInput.Origin.viewport(),
							EndX, EndY));

					// Take out finger from screen
					swipe.addAction(finger.createPointerUp(0));

					driver.perform(Arrays.asList(swipe));
				
					count++;

				} else if (s == true) {
					nlpResponseModel.setStatus(CommonConstants.pass);
					nlpResponseModel.setMessage("Swiped up  until element is visible");
					break;
				}
				if (count >= maxSwipeCount) {
					nlpResponseModel.setStatus(CommonConstants.fail);
					nlpResponseModel.setMessage("Failed to  swipe up  until text is visible");
					break;
				}
			}

		}

		catch (Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed to swipe up until element is visible");
		}
		
		if (XorYCoordinate.equalsIgnoreCase("X")) {
	        nlpResponseModel.getAttributes().put("Coordinates", xpi+"");

		}
		else if (XorYCoordinate.equalsIgnoreCase("Y")) {
			 nlpResponseModel.getAttributes().put("Coordinates", ypi+"");
		}
		else {
        nlpResponseModel.getAttributes().put("Coordinates", "null");
		}
		return nlpResponseModel;
	}
}