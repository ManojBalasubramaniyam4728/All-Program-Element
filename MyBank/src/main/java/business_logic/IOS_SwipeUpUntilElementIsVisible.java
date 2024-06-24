package business_logic;




import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.springframework.stereotype.Component;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;

import io.appium.java_client.ios.IOSDriver;

@Component("LIC13397_PJT1001_PE_NLPe4d7650f-3df5-40fd-83b9-108871337a14")
public class IOS_SwipeUpUntilElementIsVisible implements Nlp {
	@InputParams({@InputParam(name = "element", type = "org.openqa.selenium.WebElement;"),
		@InputParam(name = "maximumCount", type = "java.lang.Integer")})


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
	@Override
	public NlpResponseModel execute(NlpRequestModel nlpRequestModel) throws NlpException {

		NlpResponseModel nlpResponseModel = new NlpResponseModel();
		Map<String, Object> attributes = nlpRequestModel.getAttributes();
		WebElement element = (WebElement) attributes.get("element");
		int maximumCount = (Integer) attributes.get("maximumCount");

		IOSDriver driver =(IOSDriver) nlpRequestModel.getIosDriver();
		try {

				// Taking mobile X and y center of screen
				int centerScreenX = driver.manage().window().getSize().getWidth() / 2;
				int centerScreenY = driver.manage().window().getSize().getHeight() / 2;

				// Frome center of the screen swiping 30% upword
				int endY = (int) (driver.manage().window().getSize().getHeight() * 0.02);

				int maxCount = maximumCount;
				int count = 0;
				for (int i = count; i < maxCount; i++) {
					PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
					Sequence swipe = new Sequence(finger, 1);

					try {
						if (element.isDisplayed()) {
							break;
						}
					} 
					catch (NoSuchElementException e) {
						swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerScreenX,
								centerScreenY));
						swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
						swipe.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(),
								centerScreenX, endY));
						swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
						driver.perform(Arrays.asList(swipe));
					}
					
					catch (NullPointerException e) {
						swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerScreenX,
								centerScreenY));
						swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
						swipe.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(),
								centerScreenX, endY));
						swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
						driver.perform(Arrays.asList(swipe));
					}
					if (count >= maxCount) {
						nlpResponseModel.setStatus(CommonConstants.fail);
						nlpResponseModel.setMessage("Failed to swipe up  until element is visible");
						break;
					}
					else {
						nlpResponseModel.setStatus(CommonConstants.pass);
						nlpResponseModel.setMessage("Swiped up  until element is visible");
					}
				}
		}
		    catch(Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed to swipe up until element is visible");
		}
		return nlpResponseModel;
	}
} 